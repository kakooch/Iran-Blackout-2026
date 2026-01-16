package org.linphone.core;

/* loaded from: classes3.dex */
public interface XmlRpcSession {
    XmlRpcRequest createRequest(XmlRpcArgType xmlRpcArgType, String str);

    long getNativePointer();

    Object getUserData();

    void release();

    void sendRequest(XmlRpcRequest xmlRpcRequest);

    void setUserData(Object obj);

    String toString();
}
