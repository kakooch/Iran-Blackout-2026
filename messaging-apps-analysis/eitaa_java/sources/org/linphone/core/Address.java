package org.linphone.core;

/* loaded from: classes3.dex */
public interface Address {
    String asString();

    String asStringUriOnly();

    void clean();

    /* renamed from: clone */
    Address mo44clone();

    boolean equal(Address address);

    String getDisplayName();

    String getDomain();

    String getHeader(String str);

    String getMethodParam();

    long getNativePointer();

    String getParam(String str);

    String getPassword();

    int getPort();

    String getScheme();

    boolean getSecure();

    TransportType getTransport();

    String getUriParam(String str);

    Object getUserData();

    String getUsername();

    boolean hasParam(String str);

    boolean hasUriParam(String str);

    boolean isSip();

    boolean isValid();

    void removeUriParam(String str);

    int setDisplayName(String str);

    int setDomain(String str);

    void setHeader(String str, String str2);

    void setMethodParam(String str);

    void setParam(String str, String str2);

    void setPassword(String str);

    int setPort(int i);

    void setSecure(boolean z);

    int setTransport(TransportType transportType);

    void setUriParam(String str, String str2);

    void setUriParams(String str);

    void setUserData(Object obj);

    int setUsername(String str);

    String toString();

    boolean weakEqual(Address address);
}
