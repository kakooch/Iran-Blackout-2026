package org.linphone.core;

/* loaded from: classes3.dex */
public interface AuthInfo {
    void addAvailableAlgorithm(String str);

    void clearAvailableAlgorithms();

    /* renamed from: clone */
    AuthInfo mo45clone();

    String getAlgorithm();

    String[] getAvailableAlgorithms();

    String getDomain();

    String getHa1();

    long getNativePointer();

    String getPassword();

    String getRealm();

    String getTlsCert();

    String getTlsCertPath();

    String getTlsKey();

    String getTlsKeyPath();

    Object getUserData();

    String getUserid();

    String getUsername();

    boolean isEqualButAlgorithms(AuthInfo authInfo);

    void setAlgorithm(String str);

    void setAvailableAlgorithms(String[] strArr);

    void setDomain(String str);

    void setHa1(String str);

    void setPassword(String str);

    void setRealm(String str);

    void setTlsCert(String str);

    void setTlsCertPath(String str);

    void setTlsKey(String str);

    void setTlsKeyPath(String str);

    void setUserData(Object obj);

    void setUserid(String str);

    void setUsername(String str);

    String toString();
}
