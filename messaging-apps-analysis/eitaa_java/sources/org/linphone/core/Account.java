package org.linphone.core;

/* loaded from: classes3.dex */
public interface Account {
    void addCustomParam(String str, String str2);

    void addListener(AccountListener accountListener);

    /* renamed from: clone */
    Account mo42clone();

    AuthInfo findAuthInfo();

    Address getContactAddress();

    Core getCore();

    String getCustomHeader(String str);

    String getCustomParam(String str);

    Account getDependency();

    Reason getError();

    ErrorInfo getErrorInfo();

    long getNativePointer();

    AccountParams getParams();

    RegistrationState getState();

    @Deprecated
    TransportType getTransport();

    int getUnreadChatMessageCount();

    Object getUserData();

    boolean isAvpfEnabled();

    boolean isPhoneNumber(String str);

    Account newWithConfig(Core core, AccountParams accountParams, ProxyConfig proxyConfig);

    String normalizePhoneNumber(String str);

    Address normalizeSipUri(String str);

    void pauseRegister();

    void refreshRegister();

    void removeListener(AccountListener accountListener);

    void setContactAddress(Address address);

    void setCustomHeader(String str, String str2);

    void setDependency(Account account);

    int setParams(AccountParams accountParams);

    void setUserData(Object obj);

    String toString();
}
