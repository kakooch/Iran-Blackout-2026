package org.linphone.core;

/* loaded from: classes3.dex */
public interface ProxyConfig {
    @Deprecated
    int done();

    @Deprecated
    void edit();

    @Deprecated
    AuthInfo findAuthInfo();

    @Deprecated
    AVPFMode getAvpfMode();

    @Deprecated
    int getAvpfRrInterval();

    @Deprecated
    String getConferenceFactoryUri();

    @Deprecated
    Address getContact();

    @Deprecated
    String getContactParameters();

    @Deprecated
    String getContactUriParameters();

    @Deprecated
    Core getCore();

    @Deprecated
    String getCustomHeader(String str);

    @Deprecated
    ProxyConfig getDependency();

    @Deprecated
    boolean getDialEscapePlus();

    @Deprecated
    String getDialPrefix();

    @Deprecated
    String getDomain();

    @Deprecated
    Reason getError();

    @Deprecated
    ErrorInfo getErrorInfo();

    @Deprecated
    int getExpires();

    @Deprecated
    Address getIdentityAddress();

    @Deprecated
    String getIdkey();

    @Deprecated
    NatPolicy getNatPolicy();

    long getNativePointer();

    @Deprecated
    int getPrivacy();

    @Deprecated
    int getPublishExpires();

    @Deprecated
    PushNotificationConfig getPushNotificationConfig();

    @Deprecated
    String getQualityReportingCollector();

    @Deprecated
    int getQualityReportingInterval();

    @Deprecated
    String getRealm();

    @Deprecated
    String getRefKey();

    @Deprecated
    String[] getRoutes();

    @Deprecated
    String getServerAddr();

    @Deprecated
    RegistrationState getState();

    @Deprecated
    String getTransport();

    @Deprecated
    int getUnreadChatMessageCount();

    Object getUserData();

    @Deprecated
    boolean isAvpfEnabled();

    @Deprecated
    boolean isPublishEnabled();

    @Deprecated
    boolean isPushNotificationAllowed();

    @Deprecated
    boolean isPushNotificationAvailable();

    @Deprecated
    boolean isQualityReportingEnabled();

    @Deprecated
    boolean isRegisterEnabled();

    @Deprecated
    boolean isRemotePushNotificationAllowed();

    @Deprecated
    String normalizePhoneNumber(String str);

    @Deprecated
    Address normalizeSipUri(String str);

    @Deprecated
    void pauseRegister();

    @Deprecated
    void refreshRegister();

    @Deprecated
    void setAvpfMode(AVPFMode aVPFMode);

    @Deprecated
    void setAvpfRrInterval(int i);

    @Deprecated
    void setConferenceFactoryUri(String str);

    @Deprecated
    void setContactParameters(String str);

    @Deprecated
    void setContactUriParameters(String str);

    @Deprecated
    void setCustomHeader(String str, String str2);

    @Deprecated
    void setDependency(ProxyConfig proxyConfig);

    @Deprecated
    void setDialEscapePlus(boolean z);

    @Deprecated
    void setDialPrefix(String str);

    @Deprecated
    void setExpires(int i);

    @Deprecated
    int setIdentityAddress(Address address);

    @Deprecated
    void setIdkey(String str);

    @Deprecated
    void setNatPolicy(NatPolicy natPolicy);

    @Deprecated
    void setPrivacy(int i);

    @Deprecated
    void setPublishEnabled(boolean z);

    @Deprecated
    void setPublishExpires(int i);

    @Deprecated
    void setPushNotificationAllowed(boolean z);

    @Deprecated
    void setPushNotificationConfig(PushNotificationConfig pushNotificationConfig);

    @Deprecated
    void setQualityReportingCollector(String str);

    @Deprecated
    void setQualityReportingEnabled(boolean z);

    @Deprecated
    void setQualityReportingInterval(int i);

    @Deprecated
    void setRealm(String str);

    @Deprecated
    void setRefKey(String str);

    @Deprecated
    void setRegisterEnabled(boolean z);

    @Deprecated
    void setRemotePushNotificationAllowed(boolean z);

    @Deprecated
    int setRoute(String str);

    @Deprecated
    int setRoutes(String[] strArr);

    @Deprecated
    int setServerAddr(String str);

    void setUserData(Object obj);

    String toString();
}
