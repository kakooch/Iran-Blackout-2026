package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: XmlRpcRequest.java */
/* loaded from: classes3.dex */
class XmlRpcRequestImpl implements XmlRpcRequest {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addIntArg(long j, int i);

    private native void addListener(long j, XmlRpcRequestListener xmlRpcRequestListener);

    private native void addStringArg(long j, String str);

    private native String getContent(long j);

    private native int getIntResponse(long j);

    private native String[] getListResponse(long j);

    private native String getRawResponse(long j);

    private native int getStatus(long j);

    private native String getStringResponse(long j);

    private native void removeListener(long j, XmlRpcRequestListener xmlRpcRequestListener);

    private native boolean unref(long j, boolean z);

    protected XmlRpcRequestImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.XmlRpcRequest
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized String getContent() {
        return getContent(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized int getIntResponse() {
        return getIntResponse(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized String[] getListResponse() {
        return getListResponse(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized String getRawResponse() {
        return getRawResponse(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized XmlRpcStatus getStatus() {
        return XmlRpcStatus.fromInt(getStatus(this.nativePtr));
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized String getStringResponse() {
        return getStringResponse(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized void addIntArg(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addIntArg() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addIntArg(this.nativePtr, i);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized void addStringArg(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addStringArg() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addStringArg(this.nativePtr, str);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized void addListener(XmlRpcRequestListener xmlRpcRequestListener) {
        addListener(this.nativePtr, xmlRpcRequestListener);
    }

    @Override // org.linphone.core.XmlRpcRequest
    public synchronized void removeListener(XmlRpcRequestListener xmlRpcRequestListener) {
        removeListener(this.nativePtr, xmlRpcRequestListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.XmlRpcRequest
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.XmlRpcRequest
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.XmlRpcRequest
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
