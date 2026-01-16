package org.linphone.core;

/* loaded from: classes3.dex */
public abstract class Factory {
    static Factory _Factory;

    public abstract String computeHa1ForAlgorithm(String str, String str2, String str3, String str4);

    public abstract Address createAddress(String str);

    public abstract AuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6);

    public abstract AuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public abstract Buffer createBuffer();

    public abstract Buffer createBufferFromData(byte[] bArr, int i);

    public abstract Buffer createBufferFromString(String str);

    public abstract ConferenceInfo createConferenceInfo();

    public abstract ConferenceInfo createConferenceInfoFromIcalendarContent(Content content);

    public abstract Config createConfig(String str);

    public abstract Config createConfigFromString(String str);

    public abstract Config createConfigWithFactory(String str, String str2);

    public abstract Content createContent();

    public abstract Content createContentFromFile(String str);

    public abstract Core createCore(String str, String str2, Object obj);

    public abstract Core createCoreWithConfig(Config config, Object obj);

    public abstract DigestAuthenticationPolicy createDigestAuthenticationPolicy();

    public abstract ErrorInfo createErrorInfo();

    public abstract FriendPhoneNumber createFriendPhoneNumber(String str, String str2);

    public abstract ParticipantDeviceIdentity createParticipantDeviceIdentity(Address address, String str);

    public abstract Content createQrcode(String str, int i, int i2, int i3);

    public abstract Range createRange();

    public abstract Transports createTransports();

    public abstract TunnelConfig createTunnelConfig();

    public abstract Vcard createVcard();

    public abstract VideoActivationPolicy createVideoActivationPolicy();

    public abstract VideoDefinition createVideoDefinition(int i, int i2);

    public abstract VideoDefinition createVideoDefinitionFromName(String str);

    public abstract VideoSourceDescriptor createVideoSourceDescriptor();

    public abstract void enableLogCollection(LogCollectionState logCollectionState);

    public abstract void enableLogcatLogs(boolean z);

    public abstract String getCacheDir(Object obj);

    public abstract String getConfigDir(Object obj);

    public abstract Core getCore(long j);

    public abstract String getDataDir(Object obj);

    public abstract String getDataResourcesDir();

    public abstract DialPlan[] getDialPlans();

    public abstract String getDownloadDir(Object obj);

    public abstract String getImageResourcesDir();

    public abstract LoggingService getLoggingService();

    public abstract String getMspluginsDir();

    public abstract long getNativePointer();

    public abstract VideoDefinition[] getRecommendedVideoDefinitions();

    public abstract String getRingResourcesDir();

    public abstract String getSoundResourcesDir();

    public abstract VideoDefinition[] getSupportedVideoDefinitions();

    public abstract String getTopResourcesDir();

    public abstract Object getUserData();

    public abstract boolean isCacheDirSet();

    public abstract boolean isChatroomBackendAvailable(ChatRoomBackend chatRoomBackend);

    public abstract boolean isConfigDirSet();

    public abstract boolean isDataDirSet();

    public abstract boolean isDatabaseStorageAvailable();

    public abstract boolean isDownloadDirSet();

    public abstract boolean isImdnAvailable();

    public abstract boolean isQrcodeAvailable();

    public abstract void setCacheDir(String str);

    public abstract void setConfigDir(String str);

    public abstract void setDataDir(String str);

    public abstract void setDataResourcesDir(String str);

    public abstract void setDebugMode(boolean z, String str);

    public abstract void setDownloadDir(String str);

    public abstract void setImageResourcesDir(String str);

    public abstract void setLogCollectionPath(String str);

    public abstract void setLoggerDomain(String str);

    public abstract void setMspluginsDir(String str);

    public abstract void setRingResourcesDir(String str);

    public abstract void setSoundResourcesDir(String str);

    public abstract void setTopResourcesDir(String str);

    public abstract void setUserData(Object obj);

    public abstract void setVfsEncryption(int i, byte[] bArr, int i2);

    public abstract int writeQrcodeFile(String str, String str2, int i, int i2, int i3);

    public static final synchronized Factory instance() {
        try {
        } catch (Exception unused) {
            System.err.println("Cannot instanciate factory");
        }
        if (_Factory == null) {
            _Factory = new FactoryImpl();
        }
        return _Factory;
    }
}
