package org.linphone.core;

/* loaded from: classes3.dex */
public interface AccountParams {
    void addCustomParam(String str, String str2);

    /* renamed from: clone */
    AccountParams mo43clone();

    Address getAudioVideoConferenceFactoryAddress();

    AVPFMode getAvpfMode();

    int getAvpfRrInterval();

    String getConferenceFactoryUri();

    String getContactParameters();

    String getContactUriParameters();

    Address getCustomContact();

    String getCustomParam(String str);

    String getDomain();

    int getExpires();

    @Deprecated
    String getIdentity();

    Address getIdentityAddress();

    String getIdkey();

    String getInternationalPrefix();

    String getLimeServerUrl();

    NatPolicy getNatPolicy();

    long getNativePointer();

    int getPrivacy();

    int getPublishExpires();

    boolean getPushNotificationAllowed();

    PushNotificationConfig getPushNotificationConfig();

    String getQualityReportingCollector();

    int getQualityReportingInterval();

    String getRealm();

    String getRefKey();

    boolean getRemotePushNotificationAllowed();

    Address[] getRoutesAddresses();

    @Deprecated
    String getServerAddr();

    Address getServerAddress();

    TransportType getTransport();

    boolean getUseInternationalPrefixForCallsAndChats();

    Object getUserData();

    boolean isCpimInBasicChatRoomEnabled();

    boolean isDialEscapePlusEnabled();

    boolean isOutboundProxyEnabled();

    boolean isPublishEnabled();

    boolean isPushNotificationAvailable();

    boolean isQualityReportingEnabled();

    boolean isRegisterEnabled();

    boolean isRtpBundleAssumptionEnabled();

    boolean isRtpBundleEnabled();

    AccountParams newWithConfig(Core core, int i);

    void setAudioVideoConferenceFactoryAddress(Address address);

    void setAvpfMode(AVPFMode aVPFMode);

    void setAvpfRrInterval(int i);

    void setConferenceFactoryUri(String str);

    void setContactParameters(String str);

    void setContactUriParameters(String str);

    void setCpimInBasicChatRoomEnabled(boolean z);

    void setCustomContact(Address address);

    void setDialEscapePlusEnabled(boolean z);

    void setExpires(int i);

    int setIdentityAddress(Address address);

    void setIdkey(String str);

    void setInternationalPrefix(String str);

    void setLimeServerUrl(String str);

    void setNatPolicy(NatPolicy natPolicy);

    void setOutboundProxyEnabled(boolean z);

    void setPrivacy(int i);

    void setPublishEnabled(boolean z);

    void setPublishExpires(int i);

    void setPushNotificationAllowed(boolean z);

    void setPushNotificationConfig(PushNotificationConfig pushNotificationConfig);

    void setQualityReportingCollector(String str);

    void setQualityReportingEnabled(boolean z);

    void setQualityReportingInterval(int i);

    void setRealm(String str);

    void setRefKey(String str);

    void setRegisterEnabled(boolean z);

    void setRemotePushNotificationAllowed(boolean z);

    int setRoutesAddresses(Address[] addressArr);

    void setRtpBundleAssumptionEnabled(boolean z);

    void setRtpBundleEnabled(boolean z);

    @Deprecated
    int setServerAddr(String str);

    int setServerAddress(Address address);

    void setTransport(TransportType transportType);

    void setUseInternationalPrefixForCallsAndChats(boolean z);

    void setUserData(Object obj);

    String toString();
}
