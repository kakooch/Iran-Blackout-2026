package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.mediastream.Log;

/* compiled from: CallLog.java */
/* loaded from: classes3.dex */
class CallLogImpl implements CallLog {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native String getCallId(long j);

    private native ConferenceInfo getConferenceInfo(long j);

    private native int getDir(long j);

    private native int getDuration(long j);

    private native ErrorInfo getErrorInfo(long j);

    private native Address getFromAddress(long j);

    private native Address getLocalAddress(long j);

    private native float getQuality(long j);

    private native String getRefKey(long j);

    private native Address getRemoteAddress(long j);

    private native long getStartDate(long j);

    private native int getStatus(long j);

    private native Address getToAddress(long j);

    private native boolean isVideoEnabled(long j);

    private native void setRefKey(long j, String str);

    private native void setRemoteAddress(long j, Address address);

    private native String toStr(long j);

    private native boolean unref(long j, boolean z);

    private native boolean wasConference(long j);

    protected CallLogImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.CallLog
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.CallLog
    public synchronized String getCallId() {
        return getCallId(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized ConferenceInfo getConferenceInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConferenceInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getConferenceInfo(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized Call.Dir getDir() {
        return Call.Dir.fromInt(getDir(this.nativePtr));
    }

    @Override // org.linphone.core.CallLog
    public synchronized int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized ErrorInfo getErrorInfo() {
        return getErrorInfo(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized Address getFromAddress() {
        return getFromAddress(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized Address getLocalAddress() {
        return getLocalAddress(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized float getQuality() {
        return getQuality(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized String getRefKey() {
        return getRefKey(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized void setRefKey(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRefKey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRefKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallLog
    public synchronized Address getRemoteAddress() {
        return getRemoteAddress(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized void setRemoteAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRemoteAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRemoteAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.CallLog
    public synchronized long getStartDate() {
        return getStartDate(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized Call.Status getStatus() {
        return Call.Status.fromInt(getStatus(this.nativePtr));
    }

    @Override // org.linphone.core.CallLog
    public synchronized Address getToAddress() {
        return getToAddress(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized boolean isVideoEnabled() {
        return isVideoEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized String toStr() {
        return toStr(this.nativePtr);
    }

    @Override // org.linphone.core.CallLog
    public synchronized boolean wasConference() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call wasConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return wasConference(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.CallLog
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.CallLog
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.CallLog
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
