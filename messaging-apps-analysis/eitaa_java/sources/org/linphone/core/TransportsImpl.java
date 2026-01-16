package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Transports.java */
/* loaded from: classes3.dex */
class TransportsImpl implements Transports {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int getDtlsPort(long j);

    private native int getTcpPort(long j);

    private native int getTlsPort(long j);

    private native int getUdpPort(long j);

    private native void setDtlsPort(long j, int i);

    private native void setTcpPort(long j, int i);

    private native void setTlsPort(long j, int i);

    private native void setUdpPort(long j, int i);

    private native boolean unref(long j, boolean z);

    protected TransportsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Transports
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Transports
    public synchronized int getDtlsPort() {
        return getDtlsPort(this.nativePtr);
    }

    @Override // org.linphone.core.Transports
    public synchronized void setDtlsPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDtlsPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDtlsPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Transports
    public synchronized int getTcpPort() {
        return getTcpPort(this.nativePtr);
    }

    @Override // org.linphone.core.Transports
    public synchronized void setTcpPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTcpPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTcpPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Transports
    public synchronized int getTlsPort() {
        return getTlsPort(this.nativePtr);
    }

    @Override // org.linphone.core.Transports
    public synchronized void setTlsPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Transports
    public synchronized int getUdpPort() {
        return getUdpPort(this.nativePtr);
    }

    @Override // org.linphone.core.Transports
    public synchronized void setUdpPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUdpPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUdpPort(this.nativePtr, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Transports
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Transports
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Transports
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
