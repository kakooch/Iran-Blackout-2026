package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: NatPolicy.java */
/* loaded from: classes3.dex */
class NatPolicyImpl implements NatPolicy {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void clear(long j);

    private native NatPolicy clone(long j);

    private native Core getCore(long j);

    private native String getNatV4Address(long j);

    private native String getNatV6Address(long j);

    private native String getStunServer(long j);

    private native String getStunServerUsername(long j);

    private native boolean isIceEnabled(long j);

    private native boolean isStunEnabled(long j);

    private native boolean isTcpTurnTransportEnabled(long j);

    private native boolean isTlsTurnTransportEnabled(long j);

    private native boolean isTurnEnabled(long j);

    private native boolean isUdpTurnTransportEnabled(long j);

    private native boolean isUpnpEnabled(long j);

    private native void resolveStunServer(long j);

    private native void setIceEnabled(long j, boolean z);

    private native void setNatV4Address(long j, String str);

    private native void setNatV6Address(long j, String str);

    private native void setStunEnabled(long j, boolean z);

    private native void setStunServer(long j, String str);

    private native void setStunServerUsername(long j, String str);

    private native void setTcpTurnTransportEnabled(long j, boolean z);

    private native void setTlsTurnTransportEnabled(long j, boolean z);

    private native void setTurnEnabled(long j, boolean z);

    private native void setUdpTurnTransportEnabled(long j, boolean z);

    private native void setUpnpEnabled(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected NatPolicyImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.NatPolicy
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isIceEnabled() {
        boolean zIsIceEnabled;
        synchronized (this.core) {
            zIsIceEnabled = isIceEnabled(this.nativePtr);
        }
        return zIsIceEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setIceEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setIceEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setIceEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized String getNatV4Address() {
        String natV4Address;
        synchronized (this.core) {
            natV4Address = getNatV4Address(this.nativePtr);
        }
        return natV4Address;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setNatV4Address(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setNatV4Address() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setNatV4Address(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized String getNatV6Address() {
        String natV6Address;
        synchronized (this.core) {
            natV6Address = getNatV6Address(this.nativePtr);
        }
        return natV6Address;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setNatV6Address(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setNatV6Address() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setNatV6Address(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isStunEnabled() {
        boolean zIsStunEnabled;
        synchronized (this.core) {
            zIsStunEnabled = isStunEnabled(this.nativePtr);
        }
        return zIsStunEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setStunEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setStunEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setStunEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized String getStunServer() {
        String stunServer;
        synchronized (this.core) {
            stunServer = getStunServer(this.nativePtr);
        }
        return stunServer;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setStunServer(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setStunServer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setStunServer(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized String getStunServerUsername() {
        String stunServerUsername;
        synchronized (this.core) {
            stunServerUsername = getStunServerUsername(this.nativePtr);
        }
        return stunServerUsername;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setStunServerUsername(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setStunServerUsername() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setStunServerUsername(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isTcpTurnTransportEnabled() {
        boolean zIsTcpTurnTransportEnabled;
        synchronized (this.core) {
            zIsTcpTurnTransportEnabled = isTcpTurnTransportEnabled(this.nativePtr);
        }
        return zIsTcpTurnTransportEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setTcpTurnTransportEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setTcpTurnTransportEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setTcpTurnTransportEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isTlsTurnTransportEnabled() {
        boolean zIsTlsTurnTransportEnabled;
        synchronized (this.core) {
            zIsTlsTurnTransportEnabled = isTlsTurnTransportEnabled(this.nativePtr);
        }
        return zIsTlsTurnTransportEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setTlsTurnTransportEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setTlsTurnTransportEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setTlsTurnTransportEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isTurnEnabled() {
        boolean zIsTurnEnabled;
        synchronized (this.core) {
            zIsTurnEnabled = isTurnEnabled(this.nativePtr);
        }
        return zIsTurnEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setTurnEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setTurnEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setTurnEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isUdpTurnTransportEnabled() {
        boolean zIsUdpTurnTransportEnabled;
        synchronized (this.core) {
            zIsUdpTurnTransportEnabled = isUdpTurnTransportEnabled(this.nativePtr);
        }
        return zIsUdpTurnTransportEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setUdpTurnTransportEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setUdpTurnTransportEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setUdpTurnTransportEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized boolean isUpnpEnabled() {
        boolean zIsUpnpEnabled;
        synchronized (this.core) {
            zIsUpnpEnabled = isUpnpEnabled(this.nativePtr);
        }
        return zIsUpnpEnabled;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void setUpnpEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setUpnpEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setUpnpEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void clear() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call clear() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            clear(this.nativePtr);
        }
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized NatPolicy clone() {
        NatPolicy natPolicyClone;
        synchronized (this.core) {
            natPolicyClone = clone(this.nativePtr);
        }
        return natPolicyClone;
    }

    @Override // org.linphone.core.NatPolicy
    public synchronized void resolveStunServer() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call resolveStunServer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            resolveStunServer(this.nativePtr);
        }
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.NatPolicy
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.NatPolicy
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.NatPolicy
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
