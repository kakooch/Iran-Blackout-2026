package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ErrorInfo.java */
/* loaded from: classes3.dex */
class ErrorInfoImpl implements ErrorInfo {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native String getPhrase(long j);

    private native String getProtocol(long j);

    private native int getProtocolCode(long j);

    private native int getReason(long j);

    private native int getRetryAfter(long j);

    private native ErrorInfo getSubErrorInfo(long j);

    private native String getWarnings(long j);

    private native void set(long j, String str, int i, int i2, String str2, String str3);

    private native void setPhrase(long j, String str);

    private native void setProtocol(long j, String str);

    private native void setProtocolCode(long j, int i);

    private native void setReason(long j, int i);

    private native void setRetryAfter(long j, int i);

    private native void setSubErrorInfo(long j, ErrorInfo errorInfo);

    private native void setWarnings(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ErrorInfoImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ErrorInfo
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized String getPhrase() {
        return getPhrase(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setPhrase(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPhrase() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPhrase(this.nativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized String getProtocol() {
        return getProtocol(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setProtocol(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setProtocol() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setProtocol(this.nativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized int getProtocolCode() {
        return getProtocolCode(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setProtocolCode(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setProtocolCode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setProtocolCode(this.nativePtr, i);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized Reason getReason() {
        return Reason.fromInt(getReason(this.nativePtr));
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setReason(Reason reason) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setReason() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setReason(this.nativePtr, reason.toInt());
        }
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized int getRetryAfter() {
        return getRetryAfter(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setRetryAfter(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRetryAfter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRetryAfter(this.nativePtr, i);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized ErrorInfo getSubErrorInfo() {
        return getSubErrorInfo(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setSubErrorInfo(ErrorInfo errorInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSubErrorInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSubErrorInfo(this.nativePtr, errorInfo);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized String getWarnings() {
        return getWarnings(this.nativePtr);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void setWarnings(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setWarnings() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setWarnings(this.nativePtr, str);
    }

    @Override // org.linphone.core.ErrorInfo
    public synchronized void set(String str, Reason reason, int i, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call set() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            set(this.nativePtr, str, reason.toInt(), i, str2, str3);
        }
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ErrorInfo
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ErrorInfo
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ErrorInfo
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
