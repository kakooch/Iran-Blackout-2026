package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: TunnelConfig.java */
/* loaded from: classes3.dex */
class TunnelConfigImpl implements TunnelConfig {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int getDelay(long j);

    private native String getHost(long j);

    private native String getHost22(long j);

    private native int getPort(long j);

    private native int getPort22(long j);

    private native int getRemoteUdpMirrorPort(long j);

    private native void setDelay(long j, int i);

    private native void setHost(long j, String str);

    private native void setHost22(long j, String str);

    private native void setPort(long j, int i);

    private native void setPort22(long j, int i);

    private native void setRemoteUdpMirrorPort(long j, int i);

    private native boolean unref(long j, boolean z);

    protected TunnelConfigImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.TunnelConfig
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized int getDelay() {
        return getDelay(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setDelay(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDelay() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDelay(this.nativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized String getHost() {
        return getHost(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setHost(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHost() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHost(this.nativePtr, str);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized String getHost2() {
        return getHost22(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setHost2(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHost2() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHost22(this.nativePtr, str);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized int getPort() {
        return getPort(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized int getPort2() {
        return getPort22(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setPort2(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPort2() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPort22(this.nativePtr, i);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized int getRemoteUdpMirrorPort() {
        return getRemoteUdpMirrorPort(this.nativePtr);
    }

    @Override // org.linphone.core.TunnelConfig
    public synchronized void setRemoteUdpMirrorPort(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRemoteUdpMirrorPort() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRemoteUdpMirrorPort(this.nativePtr, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.TunnelConfig
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.TunnelConfig
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.TunnelConfig
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
