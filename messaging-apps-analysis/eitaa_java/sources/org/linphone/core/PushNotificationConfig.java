package org.linphone.core;

/* loaded from: classes3.dex */
public interface PushNotificationConfig {
    /* renamed from: clone */
    PushNotificationConfig mo52clone();

    String getBundleIdentifier();

    String getCallSnd();

    String getCallStr();

    String getGroupChatStr();

    String getMsgSnd();

    String getMsgStr();

    long getNativePointer();

    String getParam();

    String getPrid();

    String getProvider();

    String getRemoteToken();

    String getTeamId();

    Object getUserData();

    String getVoipToken();

    boolean isEqual(PushNotificationConfig pushNotificationConfig);

    void setBundleIdentifier(String str);

    void setCallSnd(String str);

    void setCallStr(String str);

    void setGroupChatStr(String str);

    void setMsgSnd(String str);

    void setMsgStr(String str);

    void setParam(String str);

    void setPrid(String str);

    void setProvider(String str);

    void setRemoteToken(String str);

    void setTeamId(String str);

    void setUserData(Object obj);

    void setVoipToken(String str);

    String toString();
}
