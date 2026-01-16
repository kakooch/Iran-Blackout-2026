package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: XmlRpcSession.java */
/* loaded from: classes3.dex */
class XmlRpcSessionImpl implements XmlRpcSession {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native XmlRpcRequest createRequest(long j, int i, String str);

    private native void release(long j);

    private native void sendRequest(long j, XmlRpcRequest xmlRpcRequest);

    private native boolean unref(long j, boolean z);

    protected XmlRpcSessionImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.XmlRpcSession
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.XmlRpcSession
    public synchronized XmlRpcRequest createRequest(XmlRpcArgType xmlRpcArgType, String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createRequest() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createRequest(this.nativePtr, xmlRpcArgType.toInt(), str);
    }

    @Override // org.linphone.core.XmlRpcSession
    public synchronized void release() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call release() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        release(this.nativePtr);
    }

    @Override // org.linphone.core.XmlRpcSession
    public synchronized void sendRequest(XmlRpcRequest xmlRpcRequest) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call sendRequest() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        sendRequest(this.nativePtr, xmlRpcRequest);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.XmlRpcSession
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.XmlRpcSession
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.XmlRpcSession
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
