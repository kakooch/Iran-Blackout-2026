package org.linphone.core;

/* loaded from: classes3.dex */
public interface Ldap {
    Core getCore();

    int getIndex();

    long getNativePointer();

    LdapParams getParams();

    Object getUserData();

    Ldap newWithParams(Core core, LdapParams ldapParams);

    void setIndex(int i);

    void setParams(LdapParams ldapParams);

    void setUserData(Object obj);

    String toString();
}
