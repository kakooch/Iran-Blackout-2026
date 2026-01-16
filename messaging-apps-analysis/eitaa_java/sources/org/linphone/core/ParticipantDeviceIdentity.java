package org.linphone.core;

/* loaded from: classes3.dex */
public interface ParticipantDeviceIdentity {
    Address getAddress();

    @Deprecated
    String getCapabilityDescriptor();

    String[] getCapabilityDescriptorList();

    long getNativePointer();

    Object getUserData();

    @Deprecated
    void setCapabilityDescriptor(String str);

    void setCapabilityDescriptor(String[] strArr);

    void setUserData(Object obj);

    String toString();
}
