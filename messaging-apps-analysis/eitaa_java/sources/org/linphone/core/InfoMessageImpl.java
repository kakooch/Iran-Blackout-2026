package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: InfoMessage.java */
/* loaded from: classes3.dex */
class InfoMessageImpl implements InfoMessage {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addHeader(long j, String str, String str2);

    private native Content getContent(long j);

    private native String getHeader(long j, String str);

    private native void setContent(long j, Content content);

    private native boolean unref(long j, boolean z);

    protected InfoMessageImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.InfoMessage
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.InfoMessage
    public synchronized Content getContent() {
        return getContent(this.nativePtr);
    }

    @Override // org.linphone.core.InfoMessage
    public synchronized void setContent(Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setContent(this.nativePtr, content);
    }

    @Override // org.linphone.core.InfoMessage
    public synchronized void addHeader(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.InfoMessage
    public synchronized String getHeader(String str) {
        return getHeader(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.InfoMessage
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.InfoMessage
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.InfoMessage
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
