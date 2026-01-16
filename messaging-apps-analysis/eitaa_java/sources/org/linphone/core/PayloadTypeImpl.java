package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: PayloadType.java */
/* loaded from: classes3.dex */
class PayloadTypeImpl implements PayloadType {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native PayloadType clone(long j);

    private native int enable(long j, boolean z);

    private native boolean enabled(long j);

    private native int getChannels(long j);

    private native int getClockRate(long j);

    private native String getDescription(long j);

    private native String getEncoderDescription(long j);

    private native String getMimeType(long j);

    private native int getNormalBitrate(long j);

    private native int getNumber(long j);

    private native String getRecvFmtp(long j);

    private native String getSendFmtp(long j);

    private native int getType(long j);

    private native boolean isUsable(long j);

    private native boolean isVbr(long j);

    private native void setNormalBitrate(long j, int i);

    private native void setNumber(long j, int i);

    private native void setRecvFmtp(long j, String str);

    private native void setSendFmtp(long j, String str);

    private native boolean unref(long j, boolean z);

    protected PayloadTypeImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PayloadType
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int getChannels() {
        return getChannels(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int getClockRate() {
        return getClockRate(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized String getDescription() {
        return getDescription(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized String getEncoderDescription() {
        return getEncoderDescription(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized boolean isUsable() {
        return isUsable(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized boolean isVbr() {
        return isVbr(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized String getMimeType() {
        return getMimeType(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int getNormalBitrate() {
        return getNormalBitrate(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized void setNormalBitrate(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNormalBitrate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNormalBitrate(this.nativePtr, i);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int getNumber() {
        return getNumber(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized void setNumber(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNumber() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNumber(this.nativePtr, i);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized String getRecvFmtp() {
        return getRecvFmtp(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized void setRecvFmtp(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecvFmtp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecvFmtp(this.nativePtr, str);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized String getSendFmtp() {
        return getSendFmtp(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized void setSendFmtp(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSendFmtp() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSendFmtp(this.nativePtr, str);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int getType() {
        return getType(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized PayloadType clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized int enable(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enable() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return enable(this.nativePtr, z);
    }

    @Override // org.linphone.core.PayloadType
    public synchronized boolean enabled() {
        return enabled(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PayloadType
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PayloadType
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PayloadType
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
