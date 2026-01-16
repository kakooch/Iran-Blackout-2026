package org.linphone.core;

/* loaded from: classes3.dex */
public interface XmlRpcRequest {
    void addIntArg(int i);

    void addListener(XmlRpcRequestListener xmlRpcRequestListener);

    void addStringArg(String str);

    String getContent();

    int getIntResponse();

    String[] getListResponse();

    long getNativePointer();

    String getRawResponse();

    XmlRpcStatus getStatus();

    String getStringResponse();

    Object getUserData();

    void removeListener(XmlRpcRequestListener xmlRpcRequestListener);

    void setUserData(Object obj);

    String toString();
}
