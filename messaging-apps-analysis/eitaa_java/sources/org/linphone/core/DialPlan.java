package org.linphone.core;

/* loaded from: classes3.dex */
public interface DialPlan {
    DialPlan byCcc(String str);

    DialPlan byCccAsInt(int i);

    DialPlan[] getAllList();

    String getCountry();

    String getCountryCallingCode();

    String getInternationalCallPrefix();

    String getIsoCountryCode();

    int getNationalNumberLength();

    long getNativePointer();

    Object getUserData();

    boolean isGeneric();

    int lookupCccFromE164(String str);

    int lookupCccFromIso(String str);

    void setUserData(Object obj);

    String toString();
}
