package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.core.PresenceActivity;
import org.linphone.mediastream.Log;

/* compiled from: Core.java */
/* loaded from: classes3.dex */
class CoreImpl implements Core {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void activateAudioSession(long j, boolean z);

    private native int addAccount(long j, Account account);

    private native int addAllToConference(long j);

    private native void addAuthInfo(long j, AuthInfo authInfo);

    private native void addContentTypeSupport(long j, String str);

    private native void addFriendList(long j, FriendList friendList);

    private native void addLdap(long j, Ldap ldap);

    private native void addLinphoneSpec(long j, String str);

    private native void addListener(long j, CoreListener coreListener);

    private native int addProxyConfig(long j, ProxyConfig proxyConfig);

    private native void addSupportedTag(long j, String str);

    private native int addToConference(long j, Call call);

    private native void audioRouteChanged(long j);

    private native int chatRoomGetDefaultEphemeralMode(long j);

    private native void chatRoomSetDefaultEphemeralMode(long j, int i);

    private native void checkForUpdate(long j, String str);

    private native void clearAccounts(long j);

    private native void clearAllAuthInfo(long j);

    private native void clearCallLogs(long j);

    private native void clearLdaps(long j);

    private native void clearProxyConfig(long j);

    private native String compressLogCollection(long j);

    private native int configSync(long j);

    private native void configureAudioSession(long j);

    private native Account createAccount(long j, AccountParams accountParams);

    private native AccountCreator createAccountCreator(long j, String str);

    private native AccountParams createAccountParams(long j);

    private native Address createAddress(long j, String str);

    private native CallLog createCallLog(long j, Address address, Address address2, int i, int i2, long j2, long j3, int i3, boolean z, float f);

    private native CallParams createCallParams(long j, Call call);

    private native ChatRoom createChatRoom(long j, ChatRoomParams chatRoomParams, Address address, String str, Address[] addressArr);

    private native ChatRoom createChatRoom2(long j, ChatRoomParams chatRoomParams, String str, Address[] addressArr);

    private native ChatRoom createChatRoom3(long j, String str, Address[] addressArr);

    private native ChatRoom createChatRoom4(long j, ChatRoomParams chatRoomParams, Address address, Address address2);

    private native ChatRoom createChatRoom5(long j, Address address);

    private native ChatRoom createChatRoom6(long j, ChatRoomParams chatRoomParams, Address address, Address[] addressArr);

    private native ChatRoom createClientGroupChatRoom(long j, String str, boolean z);

    private native ChatRoom createClientGroupChatRoom2(long j, String str, boolean z, boolean z2);

    private native ConferenceParams createConferenceParams2(long j, Conference conference);

    private native ConferenceScheduler createConferenceScheduler(long j);

    private native Conference createConferenceWithParams(long j, ConferenceParams conferenceParams);

    private native Config createConfig(long j, String str);

    private native Content createContent(long j);

    private native ChatRoomParams createDefaultChatRoomParams(long j);

    private native Friend createFriend(long j);

    private native FriendList createFriendList(long j);

    private native Friend createFriendWithAddress(long j, String str);

    private native InfoMessage createInfoMessage(long j);

    private native Ldap createLdap(long j);

    private native LdapParams createLdapParams(long j);

    private native Ldap createLdapWithParams(long j, LdapParams ldapParams);

    private native Player createLocalPlayer(long j, String str, String str2, Object obj);

    private native MagicSearch createMagicSearch(long j);

    private native NatPolicy createNatPolicy(long j);

    private native Object createNativePreviewWindowId(long j);

    private native Object createNativeVideoWindowId(long j);

    private native Event createNotify(long j, Address address, String str);

    private native Event createOneShotPublish(long j, Address address, String str);

    private native PresenceActivity createPresenceActivity(long j, int i, String str);

    private native PresenceModel createPresenceModel(long j);

    private native PresenceModel createPresenceModelWithActivity(long j, int i, String str);

    private native PresenceModel createPresenceModelWithActivityAndNote(long j, int i, String str, String str2, String str3);

    private native PresenceNote createPresenceNote(long j, String str, String str2);

    private native PresencePerson createPresencePerson(long j, String str);

    private native PresenceService createPresenceService(long j, String str, int i, String str2);

    private native Address createPrimaryContactParsed(long j);

    private native ProxyConfig createProxyConfig(long j);

    private native Event createPublish(long j, Address address, String str, int i);

    private native Recorder createRecorder(long j, RecorderParams recorderParams);

    private native RecorderParams createRecorderParams(long j);

    private native Event createSubscribe(long j, Address address, String str, int i);

    private native Event createSubscribe2(long j, Address address, ProxyConfig proxyConfig, String str, int i);

    private native XmlRpcSession createXmlRpcSession(long j, String str);

    private native void deleteChatRoom(long j, ChatRoom chatRoom);

    private native void deleteConferenceInformation(long j, ConferenceInfo conferenceInfo);

    private native void didRegisterForRemotePush(long j, Object obj);

    private native void didRegisterForRemotePushWithStringifiedToken(long j, String str);

    private native void disableChat(long j, int i);

    private native void enableChat(long j);

    private native void enableLime(long j, int i);

    private native void enableLogCollection(long j, int i);

    private native void ensureRegistered(long j);

    private native void enterBackground(long j);

    private native int enterConference(long j);

    private native void enterForeground(long j);

    private native boolean fileFormatSupported(long j, String str);

    private native AuthInfo findAuthInfo(long j, String str, String str2, String str3);

    private native Call findCallFromUri(long j, String str);

    private native CallLog findCallLog(long j, String str, int i);

    private native CallLog findCallLogFromCallId(long j, String str);

    private native ChatRoom findChatRoom(long j, Address address, Address address2);

    private native ConferenceInfo findConferenceInformationFromUri(long j, Address address);

    private native Address[] findContactsByChar(long j, String str, boolean z);

    private native Friend findFriend(long j, Address address);

    private native Friend findFriendByPhoneNumber(long j, String str);

    private native Friend[] findFriends(long j, Address address);

    private native ChatRoom findOneToOneChatRoom2(long j, Address address, Address address2, boolean z);

    private native Account getAccountByIdkey(long j, String str);

    private native int getAccountCreatorBackend(long j);

    private native String getAccountCreatorUrl(long j);

    private native Account[] getAccountList(long j);

    private native String getAdaptiveRateAlgorithm(long j);

    private native AudioDevice[] getAudioDevices(long j);

    private native int getAudioDscp(long j);

    private native int getAudioJittcomp(long j);

    private native String getAudioMulticastAddr(long j);

    private native int getAudioMulticastTtl(long j);

    private native PayloadType[] getAudioPayloadTypes(long j);

    private native int getAudioPort(long j);

    private native Range getAudioPortsRange(long j);

    private native AuthInfo[] getAuthInfoList(long j);

    private native int getAutoIterateBackgroundSchedule(long j);

    private native int getAutoIterateForegroundSchedule(long j);

    private native int getAvpfMode(long j);

    private native int getAvpfRrInterval(long j);

    private native Call getCallByCallid(long j, String str);

    private native Call getCallByRemoteAddress(long j, String str);

    private native Call getCallByRemoteAddress22(long j, Address address);

    private native CallLog[] getCallHistory2(long j, Address address, Address address2);

    private native CallLog[] getCallHistoryForAddress(long j, Address address);

    private native CallLog[] getCallLogs(long j);

    private native String getCallLogsDatabasePath(long j);

    private native Call[] getCalls(long j);

    private native int getCallsNb(long j);

    private native int getCameraSensorRotation(long j);

    private native String getCaptureDevice(long j);

    private native boolean getChatMessagesAggregationEnabled(long j);

    private native ChatRoom getChatRoom(long j, Address address);

    private native ChatRoom getChatRoom2(long j, Address address, Address address2);

    private native ChatRoom getChatRoomFromUri(long j, String str);

    private native ChatRoom[] getChatRooms(long j);

    private native Conference getConference(long j);

    private native ConferenceInfo[] getConferenceInformationList(long j);

    private native ConferenceInfo[] getConferenceInformationListAfterTime(long j, long j2);

    private native float getConferenceLocalInputVolume(long j);

    private native int getConferenceParticipantListType(long j);

    private native int getConferenceSize(long j);

    private native Config getConfig(long j);

    private native int getConsolidatedPresence(long j);

    private native Call getCurrentCall(long j);

    private native Address getCurrentCallRemoteAddress(long j);

    private native VideoDefinition getCurrentPreviewVideoDefinition(long j);

    private native Account getDefaultAccount(long j);

    private native int getDefaultConferenceLayout(long j);

    private native long getDefaultEphemeralLifetime(long j);

    private native FriendList getDefaultFriendList(long j);

    private native AudioDevice getDefaultInputAudioDevice(long j);

    private native AudioDevice getDefaultOutputAudioDevice(long j);

    private native ProxyConfig getDefaultProxyConfig(long j);

    private native String getDefaultVideoDisplayFilter(long j);

    private native int getDelayedTimeout(long j);

    private native int getDeviceRotation(long j);

    private native DigestAuthenticationPolicy getDigestAuthenticationPolicy(long j);

    private native boolean getDisableRecordOnMute(long j);

    private native boolean getDnsSetByApp(long j);

    private native int getDownloadBandwidth(long j);

    private native int getDownloadPtime(long j);

    private native int getEchoCancellationCalibration(long j);

    private native String getEchoCancellerFilterName(long j);

    private native AudioDevice[] getExtendedAudioDevices(long j);

    private native String getFileTransferServer(long j);

    private native Friend getFriendByRefKey(long j, String str);

    private native FriendList getFriendListByName(long j, String str);

    private native String getFriendsDatabasePath(long j);

    private native FriendList[] getFriendsLists(long j);

    private native ConferenceInfo[] getFutureConferenceInformationList(long j);

    private native int getGlobalState(long j);

    private native boolean getGuessHostname(long j);

    private native String getHttpProxyHost(long j);

    private native int getHttpProxyPort(long j);

    private native String getIdentity(long j);

    private native ImNotifPolicy getImNotifPolicy(long j);

    private native int getInCallTimeout(long j);

    private native int getIncTimeout(long j);

    private native AudioDevice getInputAudioDevice(long j);

    private native CallLog getLastOutgoingCallLog(long j);

    private native Ldap[] getLdapList(long j);

    private native String getLimeX3DhServerUrl(long j);

    private native String[] getLinphoneSpecsList(long j);

    private native int getLogCollectionMaxFileSize(long j);

    private native String getLogCollectionPath(long j);

    private native String getLogCollectionPrefix(long j);

    private native String getLogCollectionUploadServerUrl(long j);

    private native int getMaxCalls(long j);

    private native int getMaxSizeForAutoDownloadIncomingFiles(long j);

    private native String getMediaDevice(long j);

    private native int getMediaEncryption(long j);

    private native int getMediaResourceMode(long j);

    private native org.linphone.mediastream.Factory getMediastreamerFactory(long j);

    private native float getMicGainDb(long j);

    private native int getMissedCallsCount(long j);

    private native int getMtu(long j);

    private native String getNatAddress(long j);

    private native NatPolicy getNatPolicy(long j);

    private native Object getNativePreviewWindowId(long j);

    private native Object getNativeVideoWindowId(long j);

    private native int getNortpTimeout(long j);

    private native AudioDevice getOutputAudioDevice(long j);

    private native PayloadType getPayloadType(long j, String str, int i, int i2);

    private native String getPlayFile(long j);

    private native String getPlaybackDevice(long j);

    private native float getPlaybackGainDb(long j);

    private native boolean getPostQuantumAvailable(long j);

    private native float getPreferredFramerate(long j);

    private native VideoDefinition getPreferredVideoDefinition(long j);

    private native PresenceModel getPresenceModel(long j);

    private native VideoDefinition getPreviewVideoDefinition(long j);

    private native String getPrimaryContact(long j);

    private native Address getPrimaryContactParsed(long j);

    private native String getProvisioningUri(long j);

    private native ProxyConfig getProxyConfigByIdkey(long j, String str);

    private native ProxyConfig[] getProxyConfigList(long j);

    private native int getPushIncomingCallTimeout(long j);

    private native PushNotificationConfig getPushNotificationConfig(long j);

    private native String getRecordFile(long j);

    private native String getRemoteRingbackTone(long j);

    private native String getRing(long j);

    private native boolean getRingDuringIncomingEarlyMedia(long j);

    private native String getRingback(long j);

    private native String getRingerDevice(long j);

    private native String getRootCa(long j);

    private native int getSessionExpiresMinValue(long j);

    private native int getSessionExpiresRefresherValue(long j);

    private native int getSessionExpiresValue(long j);

    private native int getSipDscp(long j);

    private native int getSipTransportTimeout(long j);

    private native String[] getSoundDevicesList(long j);

    private native String getSrtpCryptoSuites(long j);

    private native String getStaticPicture(long j);

    private native float getStaticPictureFps(long j);

    private native String getStunServer(long j);

    private native String[] getSupportedFileFormatsList(long j);

    private native int getTag100RelSupportLevel(long j);

    private native PayloadType[] getTextPayloadTypes(long j);

    private native int getTextPort(long j);

    private native Range getTextPortsRange(long j);

    private native String getTlsCert(long j);

    private native String getTlsCertPath(long j);

    private native String getTlsKey(long j);

    private native String getTlsKeyPath(long j);

    private native Transports getTransports(long j);

    private native Transports getTransportsUsed(long j);

    private native Tunnel getTunnel(long j);

    private native int getUnreadChatMessageCount(long j);

    private native int getUnreadChatMessageCountFromActiveLocals(long j);

    private native int getUnreadChatMessageCountFromLocal(long j, Address address);

    private native int getUploadBandwidth(long j);

    private native int getUploadPtime(long j);

    private native String getUpnpExternalIpaddress(long j);

    private native int getUpnpState(long j);

    private native boolean getUseFiles(long j);

    private native boolean getUseInfoForDtmf(long j);

    private native boolean getUseRfc2833ForDtmf(long j);

    private native String getUserAgent(long j);

    private native String getUserCertificatesPath(long j);

    private native String getVersion(long j);

    private native VideoActivationPolicy getVideoActivationPolicy(long j);

    private native String getVideoDevice(long j);

    private native String[] getVideoDevicesList(long j);

    private native String getVideoDisplayFilter(long j);

    private native int getVideoDscp(long j);

    private native int getVideoJittcomp(long j);

    private native String getVideoMulticastAddr(long j);

    private native int getVideoMulticastTtl(long j);

    private native PayloadType[] getVideoPayloadTypes(long j);

    private native int getVideoPort(long j);

    private native Range getVideoPortsRange(long j);

    private native String getVideoPreset(long j);

    private native int[] getZrtpAvailableKeyAgreementList(long j);

    private native int[] getZrtpKeyAgreementList(long j);

    private native String getZrtpSecretsFile(long j);

    private native int getZrtpStatus(long j, String str);

    private native boolean hasBuiltinEchoCanceller(long j);

    private native boolean hasCrappyOpengl(long j);

    private native boolean inCall(long j);

    private native Address interpretUrl(long j, String str);

    private native Address interpretUrl2(long j, String str, boolean z);

    private native Call invite(long j, String str);

    private native Call inviteAddress(long j, Address address);

    private native Call inviteAddressWithParams(long j, Address address, CallParams callParams);

    private native Call inviteAddressWithParams2(long j, Address address, CallParams callParams, String str, Content content);

    private native Call inviteWithParams(long j, String str, CallParams callParams);

    private native boolean isAdaptiveRateControlEnabled(long j);

    private native boolean isAudioAdaptiveJittcompEnabled(long j);

    private native boolean isAudioMulticastEnabled(long j);

    private native boolean isAutoDownloadIcalendarsEnabled(long j);

    private native boolean isAutoDownloadVoiceRecordingsEnabled(long j);

    private native boolean isAutoIterateEnabled(long j);

    private native boolean isAutoSendRingingEnabled(long j);

    private native boolean isAutomaticHttpProxyDetectionEnabled(long j);

    private native boolean isCallToneIndicationsEnabled(long j);

    private native boolean isCallkitEnabled(long j);

    private native boolean isCapabilityNegociationEnabled(long j);

    private native boolean isCapabilityNegotiationReinviteEnabled(long j);

    private native boolean isChatEnabled(long j);

    private native boolean isConferenceIcsInMessageBodyEnabled(long j);

    private native boolean isConferenceServerEnabled(long j);

    private native boolean isContentTypeSupported(long j, String str);

    private native boolean isDnsSearchEnabled(long j);

    private native boolean isDnsSrvEnabled(long j);

    private native boolean isEchoCancellationEnabled(long j);

    private native boolean isEchoCancellerCalibrationRequired(long j);

    private native boolean isEchoLimiterEnabled(long j);

    private native boolean isForcedIceRelayEnabled(long j);

    private native boolean isFriendListSubscriptionEnabled(long j);

    private native boolean isGenericComfortNoiseEnabled(long j);

    private native boolean isInBackground(long j);

    private native boolean isInConference(long j);

    private native boolean isIncomingInvitePending(long j);

    private native boolean isIpv6Enabled(long j);

    private native boolean isKeepAliveEnabled(long j);

    private native boolean isLimeX3DhEnabled(long j);

    private native boolean isLocalPermissionEnabled(long j);

    private native boolean isMediaEncryptionMandatory(long j);

    private native boolean isMediaEncryptionSupported(long j, int i);

    private native boolean isMediaFilterSupported(long j, String str);

    private native boolean isMicEnabled(long j);

    private native boolean isNativeRingingEnabled(long j);

    private native boolean isNetworkReachable(long j);

    private native boolean isPushNotificationAvailable(long j);

    private native boolean isPushNotificationEnabled(long j);

    private native boolean isQrcodeVideoPreviewEnabled(long j);

    private native boolean isRealtimeTextEnabled(long j);

    private native boolean isRecordAwareEnabled(long j);

    private native boolean isRetransmissionOnNackEnabled(long j);

    private native boolean isRtpBundleEnabled(long j);

    private native boolean isSdp200AckEnabled(long j);

    private native boolean isSelfViewEnabled(long j);

    private native boolean isSenderNameHiddenInForwardMessage(long j);

    private native boolean isSessionExpiresEnabled(long j);

    private native boolean isTcapLinesMergingEnabled(long j);

    private native boolean isVerifyServerCertificates(long j);

    private native boolean isVerifyServerCn(long j);

    private native boolean isVibrationOnIncomingCallEnabled(long j);

    private native boolean isVideoAdaptiveJittcompEnabled(long j);

    private native boolean isVideoCaptureEnabled(long j);

    private native boolean isVideoDisplayEnabled(long j);

    private native boolean isVideoEnabled(long j);

    private native boolean isVideoMulticastEnabled(long j);

    private native boolean isVideoPreviewEnabled(long j);

    private native boolean isWifiOnlyEnabled(long j);

    private native boolean isZeroRtpPortForStreamInactiveEnabled(long j);

    private native boolean isZrtpGoClearEnabled(long j);

    private native void iterate(long j);

    private native boolean ldapAvailable(long j);

    private native int leaveConference(long j);

    private native boolean limeAvailable(long j);

    private native int limeEnabled(long j);

    private native boolean limeX3DhAvailable(long j);

    private native void loadConfigFromXml(long j, String str);

    private native int logCollectionEnabled(long j);

    private native boolean mediaEncryptionSupported(long j, int i);

    private native void migrateLogsFromRcToDb(long j);

    private native int migrateToMultiTransport(long j);

    private native void notifyAllFriends(long j, PresenceModel presenceModel);

    private native void notifyNotifyPresenceReceived(long j, Friend friend);

    private native void notifyNotifyPresenceReceivedForUriOrTel(long j, Friend friend, String str, PresenceModel presenceModel);

    private native int pauseAllCalls(long j);

    private native void playDtmf(long j, char c, int i);

    private native int playLocal(long j, String str);

    private native int preemptSoundResources(long j);

    private native void previewOglRender(long j);

    private native void processPushNotification(long j, String str);

    private native Event publish(long j, Address address, String str, int i, Content content);

    private native int realtimeTextGetKeepaliveInterval(long j);

    private native void realtimeTextSetKeepaliveInterval(long j, int i);

    private native void refreshRegisters(long j);

    private native void rejectSubscriber(long j, Friend friend);

    private native void reloadMsPlugins(long j, String str);

    private native void reloadSoundDevices(long j);

    private native void reloadVideoDevices(long j);

    private native void removeAccount(long j, Account account);

    private native void removeAuthInfo(long j, AuthInfo authInfo);

    private native void removeCallLog(long j, CallLog callLog);

    private native void removeContentTypeSupport(long j, String str);

    private native void removeFriendList(long j, FriendList friendList);

    private native int removeFromConference(long j, Call call);

    private native void removeLdap(long j, Ldap ldap);

    private native void removeLinphoneSpec(long j, String str);

    private native void removeListener(long j, CoreListener coreListener);

    private native void removeProxyConfig(long j, ProxyConfig proxyConfig);

    private native void removeSupportedTag(long j, String str);

    private native void resetEchoCancellationCalibration(long j);

    private native void resetLogCollection(long j);

    private native void resetMissedCallsCount(long j);

    private native ChatRoom searchChatRoom(long j, ChatRoomParams chatRoomParams, Address address, Address address2, Address[] addressArr);

    private native Conference searchConference(long j, ConferenceParams conferenceParams, Address address, Address address2, Address[] addressArr);

    private native Conference searchConference2(long j, Address address);

    private native void serializeLogs(long j);

    private native void setAccountCreatorBackend(long j, int i);

    private native void setAccountCreatorUrl(long j, String str);

    private native void setAdaptiveRateAlgorithm(long j, String str);

    private native void setAdaptiveRateControlEnabled(long j, boolean z);

    private native void setAudioAdaptiveJittcompEnabled(long j, boolean z);

    private native void setAudioDscp(long j, int i);

    private native void setAudioJittcomp(long j, int i);

    private native int setAudioMulticastAddr(long j, String str);

    private native void setAudioMulticastEnabled(long j, boolean z);

    private native int setAudioMulticastTtl(long j, int i);

    private native void setAudioPayloadTypes(long j, PayloadType[] payloadTypeArr);

    private native void setAudioPort(long j, int i);

    private native void setAudioPortRange(long j, int i, int i2);

    private native void setAutoDownloadIcalendarsEnabled(long j, boolean z);

    private native void setAutoDownloadVoiceRecordingsEnabled(long j, boolean z);

    private native void setAutoIterateBackgroundSchedule(long j, int i);

    private native void setAutoIterateEnabled(long j, boolean z);

    private native void setAutoIterateForegroundSchedule(long j, int i);

    private native void setAutoSendRingingEnabled(long j, boolean z);

    private native void setAutomaticHttpProxyDetectionEnabled(long j, boolean z);

    private native void setAvpfMode(long j, int i);

    private native void setAvpfRrInterval(long j, int i);

    private native void setCallLogsDatabasePath(long j, String str);

    private native void setCallToneIndicationsEnabled(long j, boolean z);

    private native void setCallkitEnabled(long j, boolean z);

    private native void setCapabilityNegociationEnabled(long j, boolean z);

    private native void setCapabilityNegotiationReinviteEnabled(long j, boolean z);

    private native int setCaptureDevice(long j, String str);

    private native void setChatMessagesAggregationEnabled(long j, boolean z);

    private native void setConferenceIcsInMessageBodyEnabled(long j, boolean z);

    private native void setConferenceParticipantListType(long j, int i);

    private native void setConferenceServerEnabled(long j, boolean z);

    private native void setConsolidatedPresence(long j, int i);

    private native void setDefaultAccount(long j, Account account);

    private native void setDefaultConferenceLayout(long j, int i);

    private native void setDefaultEphemeralLifetime(long j, long j2);

    private native void setDefaultInputAudioDevice(long j, AudioDevice audioDevice);

    private native void setDefaultOutputAudioDevice(long j, AudioDevice audioDevice);

    private native void setDefaultProxyConfig(long j, ProxyConfig proxyConfig);

    private native void setDelayedTimeout(long j, int i);

    private native void setDeviceRotation(long j, int i);

    private native void setDigestAuthenticationPolicy(long j, DigestAuthenticationPolicy digestAuthenticationPolicy);

    private native void setDisableRecordOnMute(long j, boolean z);

    private native void setDnsSearchEnabled(long j, boolean z);

    private native void setDnsServers(long j, String[] strArr);

    private native void setDnsServersApp(long j, String[] strArr);

    private native void setDnsSrvEnabled(long j, boolean z);

    private native void setDownloadBandwidth(long j, int i);

    private native void setDownloadPtime(long j, int i);

    private native void setEchoCancellationEnabled(long j, boolean z);

    private native void setEchoCancellerFilterName(long j, String str);

    private native void setEchoLimiterEnabled(long j, boolean z);

    private native void setEnableSipUpdate(long j, int i);

    private native void setExpectedBandwidth(long j, int i);

    private native void setFileTransferServer(long j, String str);

    private native void setForcedIceRelayEnabled(long j, boolean z);

    private native void setFriendListSubscriptionEnabled(long j, boolean z);

    private native void setFriendsDatabasePath(long j, String str);

    private native void setGenericComfortNoiseEnabled(long j, boolean z);

    private native void setGuessHostname(long j, boolean z);

    private native void setHttpProxyHost(long j, String str);

    private native void setHttpProxyPort(long j, int i);

    private native void setInCallTimeout(long j, int i);

    private native void setIncTimeout(long j, int i);

    private native void setInputAudioDevice(long j, AudioDevice audioDevice);

    private native void setIpv6Enabled6(long j, boolean z);

    private native void setKeepAliveEnabled(long j, boolean z);

    private native void setLimeX3DhEnabled(long j, boolean z);

    private native void setLimeX3DhServerUrl(long j, String str);

    private native void setLinphoneSpecsList(long j, String[] strArr);

    private native void setLogCollectionMaxFileSize(long j, int i);

    private native void setLogCollectionPath(long j, String str);

    private native void setLogCollectionPrefix(long j, String str);

    private native void setLogCollectionUploadServerUrl(long j, String str);

    private native void setMaxCalls(long j, int i);

    private native void setMaxSizeForAutoDownloadIncomingFiles(long j, int i);

    private native int setMediaDevice(long j, String str);

    private native int setMediaEncryption(long j, int i);

    private native void setMediaEncryptionMandatory(long j, boolean z);

    private native void setMediaNetworkReachable(long j, boolean z);

    private native void setMediaResourceMode(long j, int i);

    private native void setMicEnabled(long j, boolean z);

    private native void setMicGainDb(long j, float f);

    private native void setMtu(long j, int i);

    private native void setNatAddress(long j, String str);

    private native void setNatPolicy(long j, NatPolicy natPolicy);

    private native void setNativePreviewWindowId(long j, Object obj);

    private native void setNativeRingingEnabled(long j, boolean z);

    private native void setNativeVideoWindowId(long j, Object obj);

    private native void setNetworkReachable(long j, boolean z);

    private native void setNortpTimeout(long j, int i);

    private native void setOutputAudioDevice(long j, AudioDevice audioDevice);

    private native void setPlayFile(long j, String str);

    private native int setPlaybackDevice(long j, String str);

    private native void setPlaybackGainDb(long j, float f);

    private native void setPreferredFramerate(long j, float f);

    private native void setPreferredVideoDefinition(long j, VideoDefinition videoDefinition);

    private native void setPreferredVideoDefinitionByName(long j, String str);

    private native void setPresenceModel(long j, PresenceModel presenceModel);

    private native void setPreviewVideoDefinition(long j, VideoDefinition videoDefinition);

    private native void setPreviewVideoDefinitionByName(long j, String str);

    private native int setPrimaryContact(long j, String str);

    private native int setProvisioningUri(long j, String str);

    private native void setPushIncomingCallTimeout(long j, int i);

    private native void setPushNotificationEnabled(long j, boolean z);

    private native void setQrcodeDecodeRect(long j, int i, int i2, int i3, int i4);

    private native void setQrcodeVideoPreviewEnabled(long j, boolean z);

    private native void setRecordAwareEnabled(long j, boolean z);

    private native void setRecordFile(long j, String str);

    private native void setRemoteRingbackTone(long j, String str);

    private native void setRetransmissionOnNackEnabled(long j, boolean z);

    private native void setRing(long j, String str);

    private native void setRingDuringIncomingEarlyMedia(long j, boolean z);

    private native void setRingback(long j, String str);

    private native int setRingerDevice(long j, String str);

    private native void setRootCa(long j, String str);

    private native void setRootCaData(long j, String str);

    private native void setRtpBundleEnabled(long j, boolean z);

    private native void setSdp200AckEnabled(long j, boolean z);

    private native void setSelfViewEnabled(long j, boolean z);

    private native void setSenderNameHiddenInForwardMessageEnabled(long j, boolean z);

    private native void setSessionExpiresEnabled(long j, boolean z);

    private native void setSessionExpiresMinValue(long j, int i);

    private native void setSessionExpiresRefresherValue(long j, int i);

    private native void setSessionExpiresValue(long j, int i);

    private native void setSipDscp(long j, int i);

    private native void setSipNetworkReachable(long j, boolean z);

    private native void setSipTransportTimeout(long j, int i);

    private native void setSrtpCryptoSuites(long j, String str);

    private native int setStaticPicture(long j, String str);

    private native int setStaticPictureFps(long j, float f);

    private native void setStunServer(long j, String str);

    private native void setSupportedTag(long j, String str);

    private native void setTag100RelSupportLevel(long j, int i);

    private native void setTcapLineMergingEnabled(long j, boolean z);

    private native void setTextPayloadTypes(long j, PayloadType[] payloadTypeArr);

    private native void setTextPort(long j, int i);

    private native void setTextPortRange(long j, int i, int i2);

    private native void setTlsCert(long j, String str);

    private native void setTlsCertPath(long j, String str);

    private native void setTlsKey(long j, String str);

    private native void setTlsKeyPath(long j, String str);

    private native void setTone(long j, int i, String str);

    private native int setTransports(long j, Transports transports);

    private native void setUploadBandwidth(long j, int i);

    private native void setUploadPtime(long j, int i);

    private native void setUseFiles(long j, boolean z);

    private native void setUseInfoForDtmf(long j, boolean z);

    private native void setUseRfc2833ForDtmf(long j, boolean z);

    private native void setUserAgent(long j, String str, String str2);

    private native void setUserCertificatesPath(long j, String str);

    private native void setVibrationOnIncomingCallEnabled(long j, boolean z);

    private native void setVideoActivationPolicy(long j, VideoActivationPolicy videoActivationPolicy);

    private native void setVideoAdaptiveJittcompEnabled(long j, boolean z);

    private native void setVideoCaptureEnabled(long j, boolean z);

    private native int setVideoDevice(long j, String str);

    private native void setVideoDisplayEnabled(long j, boolean z);

    private native void setVideoDisplayFilter(long j, String str);

    private native void setVideoDscp(long j, int i);

    private native void setVideoJittcomp(long j, int i);

    private native int setVideoMulticastAddr(long j, String str);

    private native void setVideoMulticastEnabled(long j, boolean z);

    private native int setVideoMulticastTtl(long j, int i);

    private native void setVideoPayloadTypes(long j, PayloadType[] payloadTypeArr);

    private native void setVideoPort(long j, int i);

    private native void setVideoPortRange(long j, int i, int i2);

    private native void setVideoPreset(long j, String str);

    private native void setVideoPreviewEnabled(long j, boolean z);

    private native void setVideoSourceReuseEnabled(long j, boolean z);

    private native void setWifiOnlyEnabled(long j, boolean z);

    private native void setZeroRtpPortForStreamInactiveEnabled(long j, boolean z);

    private native void setZrtpGoClearEnabled(long j, boolean z);

    private native void setZrtpKeyAgreementSuites(long j, int[] iArr);

    private native void setZrtpSecretsFile(long j, String str);

    private native boolean soundDeviceCanCapture(long j, String str);

    private native boolean soundDeviceCanPlayback(long j, String str);

    private native boolean soundResourcesLocked(long j);

    private native int start(long j);

    private native int startConferenceRecording(long j, String str);

    private native int startEchoCancellerCalibration(long j);

    private native int startEchoTester(long j, int i);

    private native void stop(long j);

    private native void stopAsync(long j);

    private native int stopConferenceRecording(long j);

    private native void stopDtmf(long j);

    private native int stopEchoTester(long j);

    private native void stopRinging(long j);

    private native Event subscribe(long j, Address address, String str, int i, Content content);

    private native int takePreviewSnapshot(long j, String str);

    private native int terminateAllCalls(long j);

    private native int terminateConference(long j);

    private native boolean tunnelAvailable(long j);

    private native boolean unref(long j, boolean z);

    private native void uploadLogCollection(long j);

    private native boolean upnpAvailable(long j);

    private native void usePreviewWindow(long j, boolean z);

    private native boolean vcardSupported(long j);

    private native void verifyServerCertificates(long j, boolean z);

    private native void verifyServerCn(long j, boolean z);

    private native boolean videoSupported(long j);

    protected CoreImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Core
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Core
    public synchronized AccountCreatorBackend getAccountCreatorBackend() {
        return AccountCreatorBackend.fromInt(getAccountCreatorBackend(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setAccountCreatorBackend(AccountCreatorBackend accountCreatorBackend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAccountCreatorBackend() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setAccountCreatorBackend(this.nativePtr, accountCreatorBackend.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized String getAccountCreatorUrl() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getAccountCreatorUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getAccountCreatorUrl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAccountCreatorUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAccountCreatorUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAccountCreatorUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Account[] getAccountList() {
        return getAccountList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getAdaptiveRateAlgorithm() {
        return getAdaptiveRateAlgorithm(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAdaptiveRateAlgorithm(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAdaptiveRateAlgorithm() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAdaptiveRateAlgorithm(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAdaptiveRateControlEnabled() {
        return isAdaptiveRateControlEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAdaptiveRateControlEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAdaptiveRateControlEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAdaptiveRateControlEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAudioAdaptiveJittcompEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAudioAdaptiveJittcompEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isAudioAdaptiveJittcompEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioAdaptiveJittcompEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioAdaptiveJittcompEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioAdaptiveJittcompEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice[] getAudioDevices() {
        return getAudioDevices(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAudioDscp() {
        return getAudioDscp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioDscp(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioDscp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAudioJittcomp() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getAudioJittcomp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getAudioJittcomp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioJittcomp(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioJittcomp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioJittcomp(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getAudioMulticastAddr() {
        return getAudioMulticastAddr(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setAudioMulticastAddr(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioMulticastAddr() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setAudioMulticastAddr(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAudioMulticastEnabled() {
        return isAudioMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioMulticastEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioMulticastEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioMulticastEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAudioMulticastTtl() {
        return getAudioMulticastTtl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setAudioMulticastTtl(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioMulticastTtl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setAudioMulticastTtl(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized PayloadType[] getAudioPayloadTypes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getAudioPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getAudioPayloadTypes(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioPayloadTypes(PayloadType[] payloadTypeArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioPayloadTypes(this.nativePtr, payloadTypeArr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAudioPort() {
        return getAudioPort(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized Range getAudioPortsRange() {
        return getAudioPortsRange(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized AuthInfo[] getAuthInfoList() {
        return getAuthInfoList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAutoDownloadIcalendarsEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAutoDownloadIcalendarsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isAutoDownloadIcalendarsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoDownloadIcalendarsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoDownloadIcalendarsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoDownloadIcalendarsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAutoDownloadVoiceRecordingsEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAutoDownloadVoiceRecordingsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isAutoDownloadVoiceRecordingsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoDownloadVoiceRecordingsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoDownloadVoiceRecordingsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoDownloadVoiceRecordingsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAutoIterateBackgroundSchedule() {
        return getAutoIterateBackgroundSchedule(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoIterateBackgroundSchedule(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoIterateBackgroundSchedule() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoIterateBackgroundSchedule(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAutoIterateEnabled() {
        return isAutoIterateEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoIterateEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoIterateEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoIterateEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getAutoIterateForegroundSchedule() {
        return getAutoIterateForegroundSchedule(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoIterateForegroundSchedule(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoIterateForegroundSchedule() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoIterateForegroundSchedule(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAutoSendRingingEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAutoSendRingingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isAutoSendRingingEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutoSendRingingEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutoSendRingingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutoSendRingingEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isAutomaticHttpProxyDetectionEnabled() {
        return isAutomaticHttpProxyDetectionEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAutomaticHttpProxyDetectionEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutomaticHttpProxyDetectionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutomaticHttpProxyDetectionEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized AVPFMode getAvpfMode() {
        return AVPFMode.fromInt(getAvpfMode(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setAvpfMode(AVPFMode aVPFMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAvpfMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setAvpfMode(this.nativePtr, aVPFMode.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized int getAvpfRrInterval() {
        return getAvpfRrInterval(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAvpfRrInterval(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAvpfRrInterval() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAvpfRrInterval(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog[] getCallLogs() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCallLogs() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCallLogs(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getCallLogsDatabasePath() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCallLogsDatabasePath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCallLogsDatabasePath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setCallLogsDatabasePath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCallLogsDatabasePath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCallLogsDatabasePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isCallToneIndicationsEnabled() {
        return isCallToneIndicationsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setCallToneIndicationsEnabled(boolean z) {
        setCallToneIndicationsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isCallkitEnabled() {
        return isCallkitEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setCallkitEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCallkitEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCallkitEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized Call[] getCalls() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCalls() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCalls(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getCallsNb() {
        return getCallsNb(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getCameraSensorRotation() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCameraSensorRotation() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCameraSensorRotation(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isCapabilityNegociationEnabled() {
        return isCapabilityNegociationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setCapabilityNegociationEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityNegociationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityNegociationEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isCapabilityNegotiationReinviteEnabled() {
        return isCapabilityNegotiationReinviteEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setCapabilityNegotiationReinviteEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityNegotiationReinviteEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityNegotiationReinviteEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getCaptureDevice() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCaptureDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCaptureDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setCaptureDevice(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCaptureDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setCaptureDevice(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isChatEnabled() {
        return isChatEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getChatMessagesAggregationEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getChatMessagesAggregationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getChatMessagesAggregationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setChatMessagesAggregationEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setChatMessagesAggregationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setChatMessagesAggregationEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom[] getChatRooms() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getChatRooms() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getChatRooms(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Conference getConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isConferenceIcsInMessageBodyEnabled() {
        return isConferenceIcsInMessageBodyEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setConferenceIcsInMessageBodyEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceIcsInMessageBodyEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setConferenceIcsInMessageBodyEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceInfo[] getConferenceInformationList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConferenceInformationList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConferenceInformationList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized float getConferenceLocalInputVolume() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConferenceLocalInputVolume() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConferenceLocalInputVolume(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceParticipantListType getConferenceParticipantListType() {
        return ConferenceParticipantListType.fromInt(getConferenceParticipantListType(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setConferenceParticipantListType(ConferenceParticipantListType conferenceParticipantListType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceParticipantListType() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setConferenceParticipantListType(this.nativePtr, conferenceParticipantListType.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isConferenceServerEnabled() {
        return isConferenceServerEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setConferenceServerEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceServerEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setConferenceServerEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getConferenceSize() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConferenceSize() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConferenceSize(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Config getConfig() {
        return getConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ConsolidatedPresence getConsolidatedPresence() {
        return ConsolidatedPresence.fromInt(getConsolidatedPresence(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setConsolidatedPresence(ConsolidatedPresence consolidatedPresence) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConsolidatedPresence() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setConsolidatedPresence(this.nativePtr, consolidatedPresence.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized Call getCurrentCall() {
        return getCurrentCall(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Address getCurrentCallRemoteAddress() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCurrentCallRemoteAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCurrentCallRemoteAddress(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized VideoDefinition getCurrentPreviewVideoDefinition() {
        return getCurrentPreviewVideoDefinition(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Account getDefaultAccount() {
        return getDefaultAccount(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultAccount(Account account) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefaultAccount(this.nativePtr, account);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceLayout getDefaultConferenceLayout() {
        return ConferenceLayout.fromInt(getDefaultConferenceLayout(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultConferenceLayout(ConferenceLayout conferenceLayout) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultConferenceLayout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setDefaultConferenceLayout(this.nativePtr, conferenceLayout.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized long getDefaultEphemeralLifetime() {
        return getDefaultEphemeralLifetime(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultEphemeralLifetime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultEphemeralLifetime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefaultEphemeralLifetime(this.nativePtr, j);
    }

    @Override // org.linphone.core.Core
    public synchronized FriendList getDefaultFriendList() {
        return getDefaultFriendList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice getDefaultInputAudioDevice() {
        return getDefaultInputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultInputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultInputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefaultInputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice getDefaultOutputAudioDevice() {
        return getDefaultOutputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultOutputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultOutputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefaultOutputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.Core
    public synchronized ProxyConfig getDefaultProxyConfig() {
        return getDefaultProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDefaultProxyConfig(ProxyConfig proxyConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefaultProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefaultProxyConfig(this.nativePtr, proxyConfig);
    }

    @Override // org.linphone.core.Core
    public synchronized String getDefaultVideoDisplayFilter() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDefaultVideoDisplayFilter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDefaultVideoDisplayFilter(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getDelayedTimeout() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDelayedTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDelayedTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDelayedTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDelayedTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDelayedTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getDeviceRotation() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDeviceRotation() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDeviceRotation(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDeviceRotation(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDeviceRotation() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDeviceRotation(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized DigestAuthenticationPolicy getDigestAuthenticationPolicy() {
        return getDigestAuthenticationPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDigestAuthenticationPolicy(DigestAuthenticationPolicy digestAuthenticationPolicy) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDigestAuthenticationPolicy() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDigestAuthenticationPolicy(this.nativePtr, digestAuthenticationPolicy);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getDisableRecordOnMute() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDisableRecordOnMute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDisableRecordOnMute(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDisableRecordOnMute(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDisableRecordOnMute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDisableRecordOnMute(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isDnsSearchEnabled() {
        return isDnsSearchEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDnsSearchEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDnsSearchEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDnsSearchEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDnsServers(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDnsServers() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDnsServers(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDnsServersApp(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDnsServersApp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDnsServersApp(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getDnsSetByApp() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDnsSetByApp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDnsSetByApp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isDnsSrvEnabled() {
        return isDnsSrvEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDnsSrvEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDnsSrvEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDnsSrvEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getDownloadBandwidth() {
        return getDownloadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDownloadBandwidth(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDownloadBandwidth() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDownloadBandwidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getDownloadPtime() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDownloadPtime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDownloadPtime(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setDownloadPtime(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDownloadPtime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDownloadPtime(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getEchoCancellationCalibration() {
        return getEchoCancellationCalibration(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isEchoCancellationEnabled() {
        return isEchoCancellationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setEchoCancellationEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEchoCancellationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEchoCancellationEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getEchoCancellerFilterName() {
        return getEchoCancellerFilterName(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setEchoCancellerFilterName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEchoCancellerFilterName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEchoCancellerFilterName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isEchoLimiterEnabled() {
        return isEchoLimiterEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setEchoLimiterEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEchoLimiterEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEchoLimiterEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void setEnableSipUpdate(int i) {
        setEnableSipUpdate(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized void setExpectedBandwidth(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setExpectedBandwidth() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setExpectedBandwidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice[] getExtendedAudioDevices() {
        return getExtendedAudioDevices(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getFileTransferServer() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getFileTransferServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getFileTransferServer(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setFileTransferServer(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFileTransferServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFileTransferServer(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isForcedIceRelayEnabled() {
        return isForcedIceRelayEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setForcedIceRelayEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setForcedIceRelayEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setForcedIceRelayEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isFriendListSubscriptionEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isFriendListSubscriptionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isFriendListSubscriptionEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setFriendListSubscriptionEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFriendListSubscriptionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFriendListSubscriptionEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getFriendsDatabasePath() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getFriendsDatabasePath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getFriendsDatabasePath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setFriendsDatabasePath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFriendsDatabasePath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFriendsDatabasePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized FriendList[] getFriendsLists() {
        return getFriendsLists(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceInfo[] getFutureConferenceInformationList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getFutureConferenceInformationList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getFutureConferenceInformationList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isGenericComfortNoiseEnabled() {
        return isGenericComfortNoiseEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setGenericComfortNoiseEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setGenericComfortNoiseEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setGenericComfortNoiseEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized GlobalState getGlobalState() {
        return GlobalState.fromInt(getGlobalState(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getGuessHostname() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getGuessHostname() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getGuessHostname(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setGuessHostname(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setGuessHostname() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setGuessHostname(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getHttpProxyHost() {
        return getHttpProxyHost(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setHttpProxyHost(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHttpProxyHost() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHttpProxyHost(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int getHttpProxyPort() {
        return getHttpProxyPort(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setHttpProxyPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHttpProxyPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHttpProxyPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getIdentity() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getIdentity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getIdentity(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ImNotifPolicy getImNotifPolicy() {
        return getImNotifPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getInCallTimeout() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getInCallTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getInCallTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setInCallTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInCallTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setInCallTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getIncTimeout() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getIncTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getIncTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setIncTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setIncTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setIncTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice getInputAudioDevice() {
        return getInputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setInputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setInputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isIpv6Enabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isIpv6Enabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isIpv6Enabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setIpv6Enabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setIpv6Enabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setIpv6Enabled6(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isEchoCancellerCalibrationRequired() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isEchoCancellerCalibrationRequired() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isEchoCancellerCalibrationRequired(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isInBackground() {
        return isInBackground(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isInConference() {
        return isInConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isIncomingInvitePending() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isIncomingInvitePending() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isIncomingInvitePending(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isMediaEncryptionMandatory() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isMediaEncryptionMandatory() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isMediaEncryptionMandatory(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isNetworkReachable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isNetworkReachable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isNetworkReachable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isPushNotificationAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isPushNotificationAvailable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isPushNotificationAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isSenderNameHiddenInForwardMessage() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isSenderNameHiddenInForwardMessage() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isSenderNameHiddenInForwardMessage(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVerifyServerCertificates() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVerifyServerCertificates() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVerifyServerCertificates(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVerifyServerCn() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVerifyServerCn() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVerifyServerCn(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isKeepAliveEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isKeepAliveEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isKeepAliveEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setKeepAliveEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setKeepAliveEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setKeepAliveEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog getLastOutgoingCallLog() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLastOutgoingCallLog() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLastOutgoingCallLog(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Ldap[] getLdapList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLdapList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLdapList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isLimeX3DhEnabled() {
        return isLimeX3DhEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLimeX3DhEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLimeX3DhEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLimeX3DhEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getLimeX3DhServerUrl() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLimeX3DhServerUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLimeX3DhServerUrl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLimeX3DhServerUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLimeX3DhServerUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLimeX3DhServerUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String[] getLinphoneSpecsList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLinphoneSpecsList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLinphoneSpecsList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLinphoneSpecsList(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLinphoneSpecsList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLinphoneSpecsList(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isLocalPermissionEnabled() {
        return isLocalPermissionEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getLogCollectionUploadServerUrl() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLogCollectionUploadServerUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLogCollectionUploadServerUrl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLogCollectionUploadServerUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogCollectionUploadServerUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLogCollectionUploadServerUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int getMaxCalls() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMaxCalls() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getMaxCalls(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMaxCalls(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMaxCalls() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMaxCalls(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getMaxSizeForAutoDownloadIncomingFiles() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMaxSizeForAutoDownloadIncomingFiles() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getMaxSizeForAutoDownloadIncomingFiles(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMaxSizeForAutoDownloadIncomingFiles(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMaxSizeForAutoDownloadIncomingFiles() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMaxSizeForAutoDownloadIncomingFiles(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getMediaDevice() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMediaDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getMediaDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setMediaDevice(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setMediaDevice(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized MediaEncryption getMediaEncryption() {
        return MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized int setMediaEncryption(MediaEncryption mediaEncryption) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaEncryption() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setMediaEncryption(this.nativePtr, mediaEncryption.toInt());
    }

    @Override // org.linphone.core.Core
    public synchronized void setMediaEncryptionMandatory(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaEncryptionMandatory() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMediaEncryptionMandatory(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMediaNetworkReachable(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaNetworkReachable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMediaNetworkReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized MediaResourceMode getMediaResourceMode() {
        return MediaResourceMode.fromInt(getMediaResourceMode(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setMediaResourceMode(MediaResourceMode mediaResourceMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaResourceMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setMediaResourceMode(this.nativePtr, mediaResourceMode.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isMicEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isMicEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isMicEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMicEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMicEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMicEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized float getMicGainDb() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMicGainDb() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getMicGainDb(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMicGainDb(float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMicGainDb() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMicGainDb(this.nativePtr, f);
    }

    @Override // org.linphone.core.Core
    public synchronized int getMissedCallsCount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMissedCallsCount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getMissedCallsCount(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getMtu() {
        return getMtu(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setMtu(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMtu() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMtu(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getNatAddress() {
        return getNatAddress(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNatAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNatAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNatAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized NatPolicy getNatPolicy() {
        return getNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNatPolicy(NatPolicy natPolicy) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNatPolicy() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNatPolicy(this.nativePtr, natPolicy);
    }

    @Override // org.linphone.core.Core
    public synchronized Object getNativePreviewWindowId() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getNativePreviewWindowId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getNativePreviewWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNativePreviewWindowId(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNativePreviewWindowId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNativePreviewWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isNativeRingingEnabled() {
        return isNativeRingingEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNativeRingingEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNativeRingingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNativeRingingEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized Object getNativeVideoWindowId() {
        return getNativeVideoWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNativeVideoWindowId(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNativeVideoWindowId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNativeVideoWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNetworkReachable(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNetworkReachable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNetworkReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getNortpTimeout() {
        return getNortpTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setNortpTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNortpTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNortpTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized AudioDevice getOutputAudioDevice() {
        return getOutputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setOutputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOutputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOutputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.Core
    public synchronized String getPlayFile() {
        return getPlayFile(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPlayFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPlayFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPlayFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getPlaybackDevice() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPlaybackDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPlaybackDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setPlaybackDevice(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPlaybackDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setPlaybackDevice(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized float getPlaybackGainDb() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPlaybackGainDb() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPlaybackGainDb(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPlaybackGainDb(float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPlaybackGainDb() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPlaybackGainDb(this.nativePtr, f);
    }

    @Override // org.linphone.core.Core
    public synchronized float getPreferredFramerate() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPreferredFramerate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPreferredFramerate(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPreferredFramerate(float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPreferredFramerate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPreferredFramerate(this.nativePtr, f);
    }

    @Override // org.linphone.core.Core
    public synchronized VideoDefinition getPreferredVideoDefinition() {
        return getPreferredVideoDefinition(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPreferredVideoDefinition(VideoDefinition videoDefinition) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPreferredVideoDefinition() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPreferredVideoDefinition(this.nativePtr, videoDefinition);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPreferredVideoDefinitionByName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPreferredVideoDefinitionByName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPreferredVideoDefinitionByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceModel getPresenceModel() {
        return getPresenceModel(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPresenceModel(PresenceModel presenceModel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPresenceModel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPresenceModel(this.nativePtr, presenceModel);
    }

    @Override // org.linphone.core.Core
    public synchronized VideoDefinition getPreviewVideoDefinition() {
        return getPreviewVideoDefinition(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPreviewVideoDefinition(VideoDefinition videoDefinition) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPreviewVideoDefinition() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPreviewVideoDefinition(this.nativePtr, videoDefinition);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPreviewVideoDefinitionByName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPreviewVideoDefinitionByName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPreviewVideoDefinitionByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getPrimaryContact() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPrimaryContact() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPrimaryContact(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setPrimaryContact(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPrimaryContact() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setPrimaryContact(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Address getPrimaryContactParsed() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPrimaryContactParsed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPrimaryContactParsed(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getProvisioningUri() {
        return getProvisioningUri(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setProvisioningUri(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setProvisioningUri() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setProvisioningUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized ProxyConfig[] getProxyConfigList() {
        return getProxyConfigList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getPushIncomingCallTimeout() {
        return getPushIncomingCallTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPushIncomingCallTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPushIncomingCallTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPushIncomingCallTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized PushNotificationConfig getPushNotificationConfig() {
        return getPushNotificationConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isPushNotificationEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isPushNotificationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isPushNotificationEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setPushNotificationEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPushNotificationEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPushNotificationEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isQrcodeVideoPreviewEnabled() {
        return isQrcodeVideoPreviewEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setQrcodeVideoPreviewEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setQrcodeVideoPreviewEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setQrcodeVideoPreviewEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isRealtimeTextEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isRealtimeTextEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isRealtimeTextEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isRecordAwareEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isRecordAwareEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isRecordAwareEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRecordAwareEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecordAwareEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecordAwareEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRecordFile() {
        return getRecordFile(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRecordFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecordFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecordFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRemoteRingbackTone() {
        return getRemoteRingbackTone(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRemoteRingbackTone(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRemoteRingbackTone() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRemoteRingbackTone(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isRetransmissionOnNackEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isRetransmissionOnNackEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isRetransmissionOnNackEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRetransmissionOnNackEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRetransmissionOnNackEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRetransmissionOnNackEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRing() {
        return getRing(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRing(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRing() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRing(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getRingDuringIncomingEarlyMedia() {
        return getRingDuringIncomingEarlyMedia(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRingDuringIncomingEarlyMedia(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRingDuringIncomingEarlyMedia() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRingDuringIncomingEarlyMedia(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRingback() {
        return getRingback(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRingback(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRingback() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRingback(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRingerDevice() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getRingerDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getRingerDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setRingerDevice(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRingerDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setRingerDevice(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getRootCa() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getRootCa() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getRootCa(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRootCa(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRootCa() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRootCa(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRootCaData(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRootCaData() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRootCaData(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isRtpBundleEnabled() {
        return isRtpBundleEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setRtpBundleEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRtpBundleEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRtpBundleEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isSdp200AckEnabled() {
        return isSdp200AckEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSdp200AckEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSdp200AckEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSdp200AckEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isSelfViewEnabled() {
        return isSelfViewEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSelfViewEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSelfViewEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSelfViewEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSenderNameHiddenInForwardMessageEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSenderNameHiddenInForwardMessageEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSenderNameHiddenInForwardMessageEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isSessionExpiresEnabled() {
        return isSessionExpiresEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSessionExpiresEnabled(boolean z) {
        setSessionExpiresEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getSessionExpiresMinValue() {
        return getSessionExpiresMinValue(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSessionExpiresMinValue(int i) {
        setSessionExpiresMinValue(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized SessionExpiresRefresher getSessionExpiresRefresherValue() {
        return SessionExpiresRefresher.fromInt(getSessionExpiresRefresherValue(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setSessionExpiresRefresherValue(SessionExpiresRefresher sessionExpiresRefresher) {
        setSessionExpiresRefresherValue(this.nativePtr, sessionExpiresRefresher.toInt());
    }

    @Override // org.linphone.core.Core
    public synchronized int getSessionExpiresValue() {
        return getSessionExpiresValue(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSessionExpiresValue(int i) {
        setSessionExpiresValue(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getSipDscp() {
        return getSipDscp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSipDscp(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipDscp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSipNetworkReachable(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipNetworkReachable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipNetworkReachable(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getSipTransportTimeout() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getSipTransportTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getSipTransportTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSipTransportTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipTransportTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipTransportTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String[] getSoundDevicesList() {
        return getSoundDevicesList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getSrtpCryptoSuites() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getSrtpCryptoSuites() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getSrtpCryptoSuites(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSrtpCryptoSuites(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSrtpCryptoSuites() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSrtpCryptoSuites(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getStaticPicture() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getStaticPicture() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getStaticPicture(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setStaticPicture(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStaticPicture() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setStaticPicture(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized float getStaticPictureFps() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getStaticPictureFps() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getStaticPictureFps(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setStaticPictureFps(float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStaticPictureFps() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setStaticPictureFps(this.nativePtr, f);
    }

    @Override // org.linphone.core.Core
    public synchronized String getStunServer() {
        return getStunServer(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setStunServer(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStunServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setStunServer(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String[] getSupportedFileFormatsList() {
        return getSupportedFileFormatsList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setSupportedTag(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSupportedTag() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSupportedTag(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized SupportLevel getTag100RelSupportLevel() {
        return SupportLevel.fromInt(getTag100RelSupportLevel(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setTag100RelSupportLevel(SupportLevel supportLevel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTag100RelSupportLevel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setTag100RelSupportLevel(this.nativePtr, supportLevel.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void setTcapLineMergingEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTcapLineMergingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTcapLineMergingEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isTcapLinesMergingEnabled() {
        return isTcapLinesMergingEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized PayloadType[] getTextPayloadTypes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getTextPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getTextPayloadTypes(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTextPayloadTypes(PayloadType[] payloadTypeArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTextPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTextPayloadTypes(this.nativePtr, payloadTypeArr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getTextPort() {
        return getTextPort(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTextPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTextPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTextPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized Range getTextPortsRange() {
        return getTextPortsRange(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getTlsCert() {
        return getTlsCert(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTlsCert(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsCert() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsCert(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getTlsCertPath() {
        return getTlsCertPath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTlsCertPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsCertPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsCertPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getTlsKey() {
        return getTlsKey(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTlsKey(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsKey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String getTlsKeyPath() {
        return getTlsKeyPath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTlsKeyPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsKeyPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsKeyPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Transports getTransports() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getTransports() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getTransports(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setTransports(Transports transports) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTransports() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setTransports(this.nativePtr, transports);
    }

    @Override // org.linphone.core.Core
    public synchronized Transports getTransportsUsed() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getTransportsUsed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getTransportsUsed(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Tunnel getTunnel() {
        return getTunnel(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getUnreadChatMessageCount() {
        return getUnreadChatMessageCount(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getUnreadChatMessageCountFromActiveLocals() {
        return getUnreadChatMessageCountFromActiveLocals(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getUploadBandwidth() {
        return getUploadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUploadBandwidth(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUploadBandwidth() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUploadBandwidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int getUploadPtime() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUploadPtime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUploadPtime(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUploadPtime(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUploadPtime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUploadPtime(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getUpnpExternalIpaddress() {
        return getUpnpExternalIpaddress(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized UpnpState getUpnpState() {
        return UpnpState.fromInt(getUpnpState(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getUseFiles() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUseFiles() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUseFiles(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUseFiles(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUseFiles() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUseFiles(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getUseInfoForDtmf() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUseInfoForDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUseInfoForDtmf(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUseInfoForDtmf(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUseInfoForDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUseInfoForDtmf(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getUseRfc2833ForDtmf() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUseRfc2833ForDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUseRfc2833ForDtmf(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUseRfc2833ForDtmf(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUseRfc2833ForDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUseRfc2833ForDtmf(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getUserAgent() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUserAgent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUserAgent(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getUserCertificatesPath() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUserCertificatesPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUserCertificatesPath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setUserCertificatesPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUserCertificatesPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUserCertificatesPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVibrationOnIncomingCallEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVibrationOnIncomingCallEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVibrationOnIncomingCallEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVibrationOnIncomingCallEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVibrationOnIncomingCallEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVibrationOnIncomingCallEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized VideoActivationPolicy getVideoActivationPolicy() {
        return getVideoActivationPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoActivationPolicy(VideoActivationPolicy videoActivationPolicy) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoActivationPolicy() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoActivationPolicy(this.nativePtr, videoActivationPolicy);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoAdaptiveJittcompEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVideoAdaptiveJittcompEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVideoAdaptiveJittcompEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoAdaptiveJittcompEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoAdaptiveJittcompEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoAdaptiveJittcompEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoCaptureEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVideoCaptureEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVideoCaptureEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoCaptureEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoCaptureEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoCaptureEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getVideoDevice() {
        return getVideoDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setVideoDevice(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setVideoDevice(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized String[] getVideoDevicesList() {
        return getVideoDevicesList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoDisplayEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVideoDisplayEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVideoDisplayEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoDisplayEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoDisplayEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoDisplayEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized String getVideoDisplayFilter() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getVideoDisplayFilter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getVideoDisplayFilter(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoDisplayFilter(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoDisplayFilter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoDisplayFilter(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int getVideoDscp() {
        return getVideoDscp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoDscp(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoDscp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoDscp(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isVideoEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isVideoEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getVideoJittcomp() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getVideoJittcomp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getVideoJittcomp(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoJittcomp(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoJittcomp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoJittcomp(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized String getVideoMulticastAddr() {
        return getVideoMulticastAddr(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setVideoMulticastAddr(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoMulticastAddr() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setVideoMulticastAddr(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoMulticastEnabled() {
        return isVideoMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoMulticastEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoMulticastEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoMulticastEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int getVideoMulticastTtl() {
        return getVideoMulticastTtl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int setVideoMulticastTtl(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoMulticastTtl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setVideoMulticastTtl(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized PayloadType[] getVideoPayloadTypes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getVideoPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getVideoPayloadTypes(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoPayloadTypes(PayloadType[] payloadTypeArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoPayloadTypes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoPayloadTypes(this.nativePtr, payloadTypeArr);
    }

    @Override // org.linphone.core.Core
    public synchronized int getVideoPort() {
        return getVideoPort(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized Range getVideoPortsRange() {
        return getVideoPortsRange(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getVideoPreset() {
        return getVideoPreset(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoPreset(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoPreset() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoPreset(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isVideoPreviewEnabled() {
        return isVideoPreviewEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoPreviewEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoPreviewEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoPreviewEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoSourceReuseEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoSourceReuseEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoSourceReuseEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isWifiOnlyEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isWifiOnlyEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isWifiOnlyEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setWifiOnlyEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setWifiOnlyEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setWifiOnlyEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isZeroRtpPortForStreamInactiveEnabled() {
        return isZeroRtpPortForStreamInactiveEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setZeroRtpPortForStreamInactiveEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setZeroRtpPortForStreamInactiveEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setZeroRtpPortForStreamInactiveEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized ZrtpKeyAgreement[] getZrtpAvailableKeyAgreementList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getZrtpAvailableKeyAgreementList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return ZrtpKeyAgreement.fromIntArray(getZrtpAvailableKeyAgreementList(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isZrtpGoClearEnabled() {
        return isZrtpGoClearEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setZrtpGoClearEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setZrtpGoClearEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setZrtpGoClearEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized ZrtpKeyAgreement[] getZrtpKeyAgreementList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getZrtpKeyAgreementList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return ZrtpKeyAgreement.fromIntArray(getZrtpKeyAgreementList(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void setZrtpKeyAgreementSuites(ZrtpKeyAgreement[] zrtpKeyAgreementArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setZrtpKeyAgreementSuites() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setZrtpKeyAgreementSuites(this.nativePtr, ZrtpKeyAgreement.toIntArray(zrtpKeyAgreementArr));
        }
    }

    @Override // org.linphone.core.Core
    public synchronized String getZrtpSecretsFile() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getZrtpSecretsFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getZrtpSecretsFile(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setZrtpSecretsFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setZrtpSecretsFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setZrtpSecretsFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void activateAudioSession(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call activateAudioSession() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        activateAudioSession(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized int addAccount(Account account) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addAccount(this.nativePtr, account);
    }

    @Override // org.linphone.core.Core
    public synchronized int addAllToConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addAllToConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addAllToConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void addAuthInfo(AuthInfo authInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addAuthInfo(this.nativePtr, authInfo);
    }

    @Override // org.linphone.core.Core
    public synchronized void addContentTypeSupport(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addContentTypeSupport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addContentTypeSupport(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void addFriendList(FriendList friendList) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addFriendList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addFriendList(this.nativePtr, friendList);
    }

    @Override // org.linphone.core.Core
    public synchronized void addLdap(Ldap ldap) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addLdap() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addLdap(this.nativePtr, ldap);
    }

    @Override // org.linphone.core.Core
    public synchronized void addLinphoneSpec(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addLinphoneSpec() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addLinphoneSpec(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int addProxyConfig(ProxyConfig proxyConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addProxyConfig(this.nativePtr, proxyConfig);
    }

    @Override // org.linphone.core.Core
    public synchronized void addSupportedTag(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addSupportedTag() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addSupportedTag(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int addToConference(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addToConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addToConference(this.nativePtr, call);
    }

    @Override // org.linphone.core.Core
    public synchronized void audioRouteChanged() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call audioRouteChanged() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        audioRouteChanged(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoomEphemeralMode chatRoomGetDefaultEphemeralMode() {
        return ChatRoomEphemeralMode.fromInt(chatRoomGetDefaultEphemeralMode(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void chatRoomSetDefaultEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call chatRoomSetDefaultEphemeralMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            chatRoomSetDefaultEphemeralMode(this.nativePtr, chatRoomEphemeralMode.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void checkForUpdate(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call checkForUpdate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        checkForUpdate(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void clearAccounts() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearAccounts() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearAccounts(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void clearAllAuthInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearAllAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearAllAuthInfo(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void clearCallLogs() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearCallLogs() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearCallLogs(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void clearLdaps() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearLdaps() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearLdaps(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void clearProxyConfig() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int configSync() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call configSync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return configSync(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void configureAudioSession() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call configureAudioSession() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        configureAudioSession(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Account createAccount(AccountParams accountParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createAccount(this.nativePtr, accountParams);
    }

    @Override // org.linphone.core.Core
    public synchronized AccountCreator createAccountCreator(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createAccountCreator() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createAccountCreator(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized AccountParams createAccountParams() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createAccountParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createAccountParams(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Address createAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog createCallLog(Address address, Address address2, Call.Dir dir, int i, long j, long j2, Call.Status status, boolean z, float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createCallLog() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createCallLog(this.nativePtr, address, address2, dir.toInt(), i, j, j2, status.toInt(), z, f);
    }

    @Override // org.linphone.core.Core
    public synchronized CallParams createCallParams(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createCallParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createCallParams(this.nativePtr, call);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(String str, Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom3(this.nativePtr, str, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(ChatRoomParams chatRoomParams, String str, Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom2(this.nativePtr, chatRoomParams, str, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom5(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, Address address2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom4(this.nativePtr, chatRoomParams, address, address2);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom6(this.nativePtr, chatRoomParams, address, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, String str, Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createChatRoom(this.nativePtr, chatRoomParams, address, str, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createClientGroupChatRoom(String str, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createClientGroupChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createClientGroupChatRoom(this.nativePtr, str, z);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom createClientGroupChatRoom(String str, boolean z, boolean z2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createClientGroupChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createClientGroupChatRoom2(this.nativePtr, str, z, z2);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceParams createConferenceParams(Conference conference) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConferenceParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createConferenceParams2(this.nativePtr, conference);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceScheduler createConferenceScheduler() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConferenceScheduler() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createConferenceScheduler(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Conference createConferenceWithParams(ConferenceParams conferenceParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConferenceWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createConferenceWithParams(this.nativePtr, conferenceParams);
    }

    @Override // org.linphone.core.Core
    public synchronized Config createConfig(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createConfig(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Content createContent() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createContent(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoomParams createDefaultChatRoomParams() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createDefaultChatRoomParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createDefaultChatRoomParams(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend createFriend() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createFriend() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createFriend(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized FriendList createFriendList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createFriendList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createFriendList(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend createFriendWithAddress(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createFriendWithAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createFriendWithAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized InfoMessage createInfoMessage() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createInfoMessage() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createInfoMessage(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Ldap createLdap() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createLdap() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createLdap(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized LdapParams createLdapParams() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createLdapParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createLdapParams(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Ldap createLdapWithParams(LdapParams ldapParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createLdapWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createLdapWithParams(this.nativePtr, ldapParams);
    }

    @Override // org.linphone.core.Core
    public synchronized Player createLocalPlayer(String str, String str2, Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createLocalPlayer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createLocalPlayer(this.nativePtr, str, str2, obj);
    }

    @Override // org.linphone.core.Core
    public synchronized MagicSearch createMagicSearch() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createMagicSearch() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createMagicSearch(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized NatPolicy createNatPolicy() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createNatPolicy() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Object createNativePreviewWindowId() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createNativePreviewWindowId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createNativePreviewWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Object createNativeVideoWindowId() {
        return createNativeVideoWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Event createNotify(Address address, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createNotify() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createNotify(this.nativePtr, address, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Event createOneShotPublish(Address address, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createOneShotPublish() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createOneShotPublish(this.nativePtr, address, str);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceActivity createPresenceActivity(PresenceActivity.Type type, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceActivity(this.nativePtr, type.toInt(), str);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceModel createPresenceModel() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceModel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceModel(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceModel createPresenceModelWithActivity(PresenceActivity.Type type, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceModelWithActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceModelWithActivity(this.nativePtr, type.toInt(), str);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceModel createPresenceModelWithActivityAndNote(PresenceActivity.Type type, String str, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceModelWithActivityAndNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceModelWithActivityAndNote(this.nativePtr, type.toInt(), str, str2, str3);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceNote createPresenceNote(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceNote(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Core
    public synchronized PresencePerson createPresencePerson(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresencePerson() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresencePerson(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized PresenceService createPresenceService(String str, PresenceBasicStatus presenceBasicStatus, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPresenceService() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPresenceService(this.nativePtr, str, presenceBasicStatus.toInt(), str2);
    }

    @Override // org.linphone.core.Core
    public synchronized Address createPrimaryContactParsed() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPrimaryContactParsed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPrimaryContactParsed(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ProxyConfig createProxyConfig() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Event createPublish(Address address, String str, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createPublish() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createPublish(this.nativePtr, address, str, i);
    }

    @Override // org.linphone.core.Core
    public synchronized Recorder createRecorder(RecorderParams recorderParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createRecorder() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createRecorder(this.nativePtr, recorderParams);
    }

    @Override // org.linphone.core.Core
    public synchronized RecorderParams createRecorderParams() {
        return createRecorderParams(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Event createSubscribe(Address address, ProxyConfig proxyConfig, String str, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createSubscribe() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createSubscribe2(this.nativePtr, address, proxyConfig, str, i);
    }

    @Override // org.linphone.core.Core
    public synchronized Event createSubscribe(Address address, String str, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createSubscribe() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createSubscribe(this.nativePtr, address, str, i);
    }

    @Override // org.linphone.core.Core
    public synchronized XmlRpcSession createXmlRpcSession(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createXmlRpcSession() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createXmlRpcSession(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void deleteChatRoom(ChatRoom chatRoom) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call deleteChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        deleteChatRoom(this.nativePtr, chatRoom);
    }

    @Override // org.linphone.core.Core
    public synchronized void deleteConferenceInformation(ConferenceInfo conferenceInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call deleteConferenceInformation() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        deleteConferenceInformation(this.nativePtr, conferenceInfo);
    }

    @Override // org.linphone.core.Core
    public synchronized void didRegisterForRemotePush(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call didRegisterForRemotePush() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        didRegisterForRemotePush(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Core
    public synchronized void didRegisterForRemotePushWithStringifiedToken(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call didRegisterForRemotePushWithStringifiedToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        didRegisterForRemotePushWithStringifiedToken(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void disableChat(Reason reason) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call disableChat() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            disableChat(this.nativePtr, reason.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void enableChat() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enableChat() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        enableChat(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void enableLime(LimeState limeState) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enableLime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            enableLime(this.nativePtr, limeState.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void ensureRegistered() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call ensureRegistered() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        ensureRegistered(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void enterBackground() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enterBackground() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        enterBackground(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int enterConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enterConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return enterConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void enterForeground() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enterForeground() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        enterForeground(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean fileFormatSupported(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call fileFormatSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return fileFormatSupported(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized AuthInfo findAuthInfo(String str, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findAuthInfo(this.nativePtr, str, str2, str3);
    }

    @Override // org.linphone.core.Core
    public synchronized Call findCallFromUri(String str) {
        return findCallFromUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog findCallLog(String str, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findCallLog() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findCallLog(this.nativePtr, str, i);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog findCallLogFromCallId(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findCallLogFromCallId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findCallLogFromCallId(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom findChatRoom(Address address, Address address2) {
        return findChatRoom(this.nativePtr, address, address2);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceInfo findConferenceInformationFromUri(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findConferenceInformationFromUri() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findConferenceInformationFromUri(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized Address[] findContactsByChar(String str, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findContactsByChar() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findContactsByChar(this.nativePtr, str, z);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend findFriend(Address address) {
        return findFriend(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend findFriendByPhoneNumber(String str) {
        return findFriendByPhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend[] findFriends(Address address) {
        return findFriends(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom findOneToOneChatRoom(Address address, Address address2, boolean z) {
        return findOneToOneChatRoom2(this.nativePtr, address, address2, z);
    }

    @Override // org.linphone.core.Core
    public synchronized Account getAccountByIdkey(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getAccountByIdkey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getAccountByIdkey(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Call getCallByCallid(String str) {
        return getCallByCallid(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Call getCallByRemoteAddress(String str) {
        return getCallByRemoteAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Call getCallByRemoteAddress2(Address address) {
        return getCallByRemoteAddress22(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog[] getCallHistory(Address address, Address address2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCallHistory() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCallHistory2(this.nativePtr, address, address2);
    }

    @Override // org.linphone.core.Core
    public synchronized CallLog[] getCallHistoryForAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCallHistoryForAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCallHistoryForAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom getChatRoom(Address address, Address address2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getChatRoom2(this.nativePtr, address, address2);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom getChatRoom(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getChatRoom() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getChatRoom(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom getChatRoomFromUri(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getChatRoomFromUri() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getChatRoomFromUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized ConferenceInfo[] getConferenceInformationListAfterTime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConferenceInformationListAfterTime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConferenceInformationListAfterTime(this.nativePtr, j);
    }

    @Override // org.linphone.core.Core
    public synchronized Friend getFriendByRefKey(String str) {
        return getFriendByRefKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized FriendList getFriendListByName(String str) {
        return getFriendListByName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized PayloadType getPayloadType(String str, int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPayloadType() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPayloadType(this.nativePtr, str, i, i2);
    }

    @Override // org.linphone.core.Core
    public synchronized ProxyConfig getProxyConfigByIdkey(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getProxyConfigByIdkey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getProxyConfigByIdkey(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int getUnreadChatMessageCountFromLocal(Address address) {
        return getUnreadChatMessageCountFromLocal(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized ZrtpPeerStatus getZrtpStatus(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getZrtpStatus() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return ZrtpPeerStatus.fromInt(getZrtpStatus(this.nativePtr, str));
    }

    @Override // org.linphone.core.Core
    public synchronized boolean hasBuiltinEchoCanceller() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call hasBuiltinEchoCanceller() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return hasBuiltinEchoCanceller(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean hasCrappyOpengl() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call hasCrappyOpengl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return hasCrappyOpengl(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean inCall() {
        return inCall(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Address interpretUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call interpretUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return interpretUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Address interpretUrl(String str, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call interpretUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return interpretUrl2(this.nativePtr, str, z);
    }

    @Override // org.linphone.core.Core
    public synchronized Call invite(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call invite() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return invite(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Call inviteAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call inviteAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return inviteAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized Call inviteAddressWithParams(Address address, CallParams callParams, String str, Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call inviteAddressWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return inviteAddressWithParams2(this.nativePtr, address, callParams, str, content);
    }

    @Override // org.linphone.core.Core
    public synchronized Call inviteAddressWithParams(Address address, CallParams callParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call inviteAddressWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return inviteAddressWithParams(this.nativePtr, address, callParams);
    }

    @Override // org.linphone.core.Core
    public synchronized Call inviteWithParams(String str, CallParams callParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call inviteWithParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return inviteWithParams(this.nativePtr, str, callParams);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isContentTypeSupported(String str) {
        return isContentTypeSupported(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isMediaEncryptionSupported(MediaEncryption mediaEncryption) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isMediaEncryptionSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isMediaEncryptionSupported(this.nativePtr, mediaEncryption.toInt());
    }

    @Override // org.linphone.core.Core
    public synchronized boolean isMediaFilterSupported(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isMediaFilterSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isMediaFilterSupported(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void iterate() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call iterate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        iterate(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean ldapAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call ldapAvailable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return ldapAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int leaveConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call leaveConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return leaveConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean limeAvailable() {
        return limeAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized LimeState limeEnabled() {
        return LimeState.fromInt(limeEnabled(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized boolean limeX3DhAvailable() {
        return limeX3DhAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void loadConfigFromXml(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call loadConfigFromXml() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        loadConfigFromXml(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean mediaEncryptionSupported(MediaEncryption mediaEncryption) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call mediaEncryptionSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return mediaEncryptionSupported(this.nativePtr, mediaEncryption.toInt());
    }

    @Override // org.linphone.core.Core
    public synchronized void migrateLogsFromRcToDb() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call migrateLogsFromRcToDb() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        migrateLogsFromRcToDb(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int migrateToMultiTransport() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call migrateToMultiTransport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return migrateToMultiTransport(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void notifyAllFriends(PresenceModel presenceModel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call notifyAllFriends() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        notifyAllFriends(this.nativePtr, presenceModel);
    }

    @Override // org.linphone.core.Core
    public synchronized void notifyNotifyPresenceReceived(Friend friend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call notifyNotifyPresenceReceived() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        notifyNotifyPresenceReceived(this.nativePtr, friend);
    }

    @Override // org.linphone.core.Core
    public synchronized void notifyNotifyPresenceReceivedForUriOrTel(Friend friend, String str, PresenceModel presenceModel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call notifyNotifyPresenceReceivedForUriOrTel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            notifyNotifyPresenceReceivedForUriOrTel(this.nativePtr, friend, str, presenceModel);
        }
    }

    @Override // org.linphone.core.Core
    public synchronized int pauseAllCalls() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call pauseAllCalls() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return pauseAllCalls(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void playDtmf(char c, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call playDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        playDtmf(this.nativePtr, c, i);
    }

    @Override // org.linphone.core.Core
    public synchronized int playLocal(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call playLocal() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return playLocal(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int preemptSoundResources() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call preemptSoundResources() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return preemptSoundResources(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void previewOglRender() {
        previewOglRender(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void processPushNotification(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call processPushNotification() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        processPushNotification(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized Event publish(Address address, String str, int i, Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call publish() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return publish(this.nativePtr, address, str, i, content);
    }

    @Override // org.linphone.core.Core
    public synchronized int realtimeTextGetKeepaliveInterval() {
        return realtimeTextGetKeepaliveInterval(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void realtimeTextSetKeepaliveInterval(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call realtimeTextSetKeepaliveInterval() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        realtimeTextSetKeepaliveInterval(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized void refreshRegisters() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call refreshRegisters() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        refreshRegisters(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void rejectSubscriber(Friend friend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call rejectSubscriber() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        rejectSubscriber(this.nativePtr, friend);
    }

    @Override // org.linphone.core.Core
    public synchronized void reloadMsPlugins(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reloadMsPlugins() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reloadMsPlugins(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void reloadSoundDevices() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reloadSoundDevices() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reloadSoundDevices(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void reloadVideoDevices() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reloadVideoDevices() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reloadVideoDevices(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeAccount(Account account) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeAccount(this.nativePtr, account);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeAuthInfo(AuthInfo authInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeAuthInfo(this.nativePtr, authInfo);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeCallLog(CallLog callLog) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeCallLog() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeCallLog(this.nativePtr, callLog);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeContentTypeSupport(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeContentTypeSupport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeContentTypeSupport(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeFriendList(FriendList friendList) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeFriendList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeFriendList(this.nativePtr, friendList);
    }

    @Override // org.linphone.core.Core
    public synchronized int removeFromConference(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeFromConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return removeFromConference(this.nativePtr, call);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeLdap(Ldap ldap) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeLdap() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeLdap(this.nativePtr, ldap);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeLinphoneSpec(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeLinphoneSpec() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeLinphoneSpec(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeProxyConfig(ProxyConfig proxyConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeProxyConfig(this.nativePtr, proxyConfig);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeSupportedTag(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeSupportedTag() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeSupportedTag(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void resetEchoCancellationCalibration() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call resetEchoCancellationCalibration() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        resetEchoCancellationCalibration(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void resetMissedCallsCount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call resetMissedCallsCount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        resetMissedCallsCount(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized ChatRoom searchChatRoom(ChatRoomParams chatRoomParams, Address address, Address address2, Address[] addressArr) {
        return searchChatRoom(this.nativePtr, chatRoomParams, address, address2, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized Conference searchConference(Address address) {
        return searchConference2(this.nativePtr, address);
    }

    @Override // org.linphone.core.Core
    public synchronized Conference searchConference(ConferenceParams conferenceParams, Address address, Address address2, Address[] addressArr) {
        return searchConference(this.nativePtr, conferenceParams, address, address2, addressArr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setAudioPortRange(int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioPortRange() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioPortRange(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.Core
    public synchronized void setQrcodeDecodeRect(int i, int i2, int i3, int i4) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setQrcodeDecodeRect() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setQrcodeDecodeRect(this.nativePtr, i, i2, i3, i4);
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void setTextPortRange(int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTextPortRange() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTextPortRange(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.Core
    public synchronized void setTone(ToneID toneID, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTone() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setTone(this.nativePtr, toneID.toInt(), str);
        }
    }

    @Override // org.linphone.core.Core
    public synchronized void setUserAgent(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUserAgent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUserAgent(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Core
    public synchronized void setVideoPortRange(int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoPortRange() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoPortRange(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean soundDeviceCanCapture(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call soundDeviceCanCapture() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return soundDeviceCanCapture(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean soundDeviceCanPlayback(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call soundDeviceCanPlayback() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return soundDeviceCanPlayback(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean soundResourcesLocked() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call soundResourcesLocked() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return soundResourcesLocked(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int start() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call start() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return start(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int startConferenceRecording(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call startConferenceRecording() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return startConferenceRecording(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int startEchoCancellerCalibration() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call startEchoCancellerCalibration() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return startEchoCancellerCalibration(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int startEchoTester(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call startEchoTester() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return startEchoTester(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized void stop() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stop() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        stop(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void stopAsync() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stopAsync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        stopAsync(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int stopConferenceRecording() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stopConferenceRecording() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return stopConferenceRecording(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void stopDtmf() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stopDtmf() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        stopDtmf(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int stopEchoTester() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stopEchoTester() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return stopEchoTester(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void stopRinging() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call stopRinging() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        stopRinging(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized Event subscribe(Address address, String str, int i, Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call subscribe() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return subscribe(this.nativePtr, address, str, i, content);
    }

    @Override // org.linphone.core.Core
    public synchronized int takePreviewSnapshot(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call takePreviewSnapshot() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return takePreviewSnapshot(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized int terminateAllCalls() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call terminateAllCalls() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return terminateAllCalls(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized int terminateConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call terminateConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return terminateConference(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void uploadLogCollection() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call uploadLogCollection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        uploadLogCollection(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void usePreviewWindow(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call usePreviewWindow() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        usePreviewWindow(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void verifyServerCertificates(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call verifyServerCertificates() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        verifyServerCertificates(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized void verifyServerCn(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call verifyServerCn() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        verifyServerCn(this.nativePtr, z);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean videoSupported() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call videoSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return videoSupported(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String compressLogCollection() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call compressLogCollection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return compressLogCollection(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void enableLogCollection(LogCollectionState logCollectionState) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enableLogCollection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            enableLogCollection(this.nativePtr, logCollectionState.toInt());
        }
    }

    @Override // org.linphone.core.Core
    public synchronized int getLogCollectionMaxFileSize() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLogCollectionMaxFileSize() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLogCollectionMaxFileSize(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getLogCollectionPath() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLogCollectionPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLogCollectionPath(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getLogCollectionPrefix() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getLogCollectionPrefix() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getLogCollectionPrefix(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean getPostQuantumAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getPostQuantumAvailable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getPostQuantumAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized String getVersion() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getVersion() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getVersion(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized LogCollectionState logCollectionEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call logCollectionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return LogCollectionState.fromInt(logCollectionEnabled(this.nativePtr));
    }

    @Override // org.linphone.core.Core
    public synchronized void resetLogCollection() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call resetLogCollection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        resetLogCollection(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void serializeLogs() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call serializeLogs() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        serializeLogs(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLogCollectionMaxFileSize(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogCollectionMaxFileSize() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLogCollectionMaxFileSize(this.nativePtr, i);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLogCollectionPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogCollectionPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLogCollectionPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized void setLogCollectionPrefix(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogCollectionPrefix() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLogCollectionPrefix(this.nativePtr, str);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean tunnelAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call tunnelAvailable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return tunnelAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean upnpAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call upnpAvailable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return upnpAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized boolean vcardSupported() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call vcardSupported() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return vcardSupported(this.nativePtr);
    }

    @Override // org.linphone.core.Core
    public synchronized void addListener(CoreListener coreListener) {
        addListener(this.nativePtr, coreListener);
    }

    @Override // org.linphone.core.Core
    public synchronized void removeListener(CoreListener coreListener) {
        removeListener(this.nativePtr, coreListener);
    }

    @Override // org.linphone.core.Core
    public org.linphone.mediastream.Factory getMediastreamerFactory() {
        return getMediastreamerFactory(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Core
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Core
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Core
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
