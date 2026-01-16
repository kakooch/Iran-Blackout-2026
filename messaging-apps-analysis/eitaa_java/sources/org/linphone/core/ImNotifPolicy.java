package org.linphone.core;

/* loaded from: classes3.dex */
public interface ImNotifPolicy {
    void clear();

    void enableAll();

    long getNativePointer();

    boolean getRecvImdnDelivered();

    boolean getRecvImdnDeliveryError();

    boolean getRecvImdnDisplayed();

    boolean getRecvIsComposing();

    boolean getSendImdnDelivered();

    boolean getSendImdnDeliveryError();

    boolean getSendImdnDisplayed();

    boolean getSendIsComposing();

    Object getUserData();

    void setRecvImdnDelivered(boolean z);

    void setRecvImdnDeliveryError(boolean z);

    void setRecvImdnDisplayed(boolean z);

    void setRecvIsComposing(boolean z);

    void setSendImdnDelivered(boolean z);

    void setSendImdnDeliveryError(boolean z);

    void setSendImdnDisplayed(boolean z);

    void setSendIsComposing(boolean z);

    void setUserData(Object obj);

    String toString();
}
