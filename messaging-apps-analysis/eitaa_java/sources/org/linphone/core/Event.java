package org.linphone.core;

/* loaded from: classes3.dex */
public interface Event {
    int acceptSubscription();

    void addCustomHeader(String str, String str2);

    void addListener(EventListener eventListener);

    int denySubscription(Reason reason);

    Core getCore();

    String getCustomHeader(String str);

    ErrorInfo getErrorInfo();

    Address getFrom();

    String getName();

    long getNativePointer();

    PublishState getPublishState();

    Reason getReason();

    Address getRemoteContact();

    Address getResource();

    SubscriptionDir getSubscriptionDir();

    SubscriptionState getSubscriptionState();

    Address getTo();

    Object getUserData();

    int notify(Content content);

    void pausePublish();

    int refreshPublish();

    int refreshSubscribe();

    void removeCustomHeader(String str);

    void removeListener(EventListener eventListener);

    int sendPublish(Content content);

    int sendSubscribe(Content content);

    void setUserData(Object obj);

    void terminate();

    String toString();

    int updatePublish(Content content);

    int updateSubscribe(Content content);
}
