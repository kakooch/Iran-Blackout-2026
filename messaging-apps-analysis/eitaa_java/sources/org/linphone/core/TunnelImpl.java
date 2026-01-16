package org.linphone.core;

import org.linphone.core.Tunnel;
import org.linphone.mediastream.Log;

/* compiled from: Tunnel.java */
/* loaded from: classes3.dex */
class TunnelImpl implements Tunnel {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addServer(long j, TunnelConfig tunnelConfig);

    private native void cleanServers(long j);

    private native boolean connected(long j);

    private native boolean getActivated(long j);

    private native String getDomain(long j);

    private native int getMode(long j);

    private native TunnelConfig[] getServers(long j);

    private native String getUsername(long j);

    private native boolean isDualModeEnabled(long j);

    private native boolean isSipEnabled(long j);

    private native void reconnect(long j);

    private native void removeServer(long j, TunnelConfig tunnelConfig);

    private native void setDomain(long j, String str);

    private native void setDualModeEnabled(long j, boolean z);

    private native void setHttpProxy(long j, String str, int i, String str2, String str3);

    private native void setHttpProxyAuthInfo(long j, String str, String str2);

    private native void setMode(long j, int i);

    private native void setSipEnabled(long j, boolean z);

    private native void setUsername(long j, String str);

    private native boolean unref(long j, boolean z);

    protected TunnelImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Tunnel
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Tunnel
    public synchronized boolean getActivated() {
        return getActivated(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized String getDomain() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDomain() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setDomain(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDomain() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDomain(this.nativePtr, str);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized boolean isDualModeEnabled() {
        return isDualModeEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setDualModeEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDualModeEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDualModeEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized Tunnel.Mode getMode() {
        return Tunnel.Mode.fromInt(getMode(this.nativePtr));
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setMode(Tunnel.Mode mode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setMode(this.nativePtr, mode.toInt());
        }
    }

    @Override // org.linphone.core.Tunnel
    public synchronized TunnelConfig[] getServers() {
        return getServers(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized boolean isSipEnabled() {
        return isSipEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setSipEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized String getUsername() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUsername() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setUsername(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUsername() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUsername(this.nativePtr, str);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void addServer(TunnelConfig tunnelConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addServer(this.nativePtr, tunnelConfig);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void cleanServers() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call cleanServers() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        cleanServers(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized boolean connected() {
        return connected(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void reconnect() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reconnect() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reconnect(this.nativePtr);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void removeServer(TunnelConfig tunnelConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeServer(this.nativePtr, tunnelConfig);
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setHttpProxy(String str, int i, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHttpProxy() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setHttpProxy(this.nativePtr, str, i, str2, str3);
        }
    }

    @Override // org.linphone.core.Tunnel
    public synchronized void setHttpProxyAuthInfo(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHttpProxyAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHttpProxyAuthInfo(this.nativePtr, str, str2);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Tunnel
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Tunnel
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Tunnel
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
