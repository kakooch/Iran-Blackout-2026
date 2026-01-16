package org.linphone.core;

/* loaded from: classes3.dex */
public interface LdapParams {
    int check();

    /* renamed from: clone */
    LdapParams mo49clone();

    LdapAuthMethod getAuthMethod();

    String getBaseObject();

    String getBindDn();

    String getCustomValue(String str);

    LdapDebugLevel getDebugLevel();

    int getDelay();

    boolean getEnabled();

    String getFilter();

    int getMaxResults();

    int getMinChars();

    String getNameAttribute();

    long getNativePointer();

    String getPassword();

    String getServer();

    LdapCertVerificationMode getServerCertificatesVerificationMode();

    String getSipAttribute();

    String getSipDomain();

    int getTimeout();

    Object getUserData();

    boolean isSalEnabled();

    boolean isTlsEnabled();

    void setAuthMethod(LdapAuthMethod ldapAuthMethod);

    void setBaseObject(String str);

    void setBindDn(String str);

    void setCustomValue(String str, String str2);

    void setDebugLevel(LdapDebugLevel ldapDebugLevel);

    void setDelay(int i);

    void setEnabled(boolean z);

    void setFilter(String str);

    void setMaxResults(int i);

    void setMinChars(int i);

    void setNameAttribute(String str);

    void setPassword(String str);

    void setSalEnabled(boolean z);

    void setServer(String str);

    void setServerCertificatesVerificationMode(LdapCertVerificationMode ldapCertVerificationMode);

    void setSipAttribute(String str);

    void setSipDomain(String str);

    void setTimeout(int i);

    void setTlsEnabled(boolean z);

    void setUserData(Object obj);

    String toString();
}
