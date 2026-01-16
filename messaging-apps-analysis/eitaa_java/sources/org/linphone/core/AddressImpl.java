package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Address.java */
/* loaded from: classes3.dex */
class AddressImpl implements Address {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native String asString(long j);

    private native String asStringUriOnly(long j);

    private native void clean(long j);

    private native Address clone(long j);

    private native boolean equal(long j, Address address);

    private native String getDisplayName(long j);

    private native String getDomain(long j);

    private native String getHeader(long j, String str);

    private native String getMethodParam(long j);

    private native String getParam(long j, String str);

    private native String getPassword(long j);

    private native int getPort(long j);

    private native String getScheme(long j);

    private native boolean getSecure(long j);

    private native int getTransport(long j);

    private native String getUriParam(long j, String str);

    private native String getUsername(long j);

    private native boolean hasParam(long j, String str);

    private native boolean hasUriParam(long j, String str);

    private native boolean isSip(long j);

    private native boolean isValid(long j);

    private native void removeUriParam(long j, String str);

    private native int setDisplayName(long j, String str);

    private native int setDomain(long j, String str);

    private native void setHeader(long j, String str, String str2);

    private native void setMethodParam(long j, String str);

    private native void setParam(long j, String str, String str2);

    private native void setPassword(long j, String str);

    private native int setPort(long j, int i);

    private native void setSecure(long j, boolean z);

    private native int setTransport(long j, int i);

    private native void setUriParam(long j, String str, String str2);

    private native void setUriParams(long j, String str);

    private native int setUsername(long j, String str);

    private native boolean unref(long j, boolean z);

    private native boolean weakEqual(long j, Address address);

    protected AddressImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Address
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Address
    public synchronized String getDisplayName() {
        return getDisplayName(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized int setDisplayName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDisplayName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setDisplayName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String getDomain() {
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized int setDomain(String str) {
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
        return setDomain(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean isSip() {
        return isSip(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean isValid() {
        return isValid(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized String getMethodParam() {
        return getMethodParam(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized void setMethodParam(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMethodParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMethodParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String getPassword() {
        return getPassword(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized void setPassword(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPassword() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPassword(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized int getPort() {
        return getPort(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized int setPort(int i) {
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
        return setPort(this.nativePtr, i);
    }

    @Override // org.linphone.core.Address
    public synchronized String getScheme() {
        return getScheme(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean getSecure() {
        return getSecure(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized void setSecure(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSecure() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSecure(this.nativePtr, z);
    }

    @Override // org.linphone.core.Address
    public synchronized TransportType getTransport() {
        return TransportType.fromInt(getTransport(this.nativePtr));
    }

    @Override // org.linphone.core.Address
    public synchronized int setTransport(TransportType transportType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTransport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setTransport(this.nativePtr, transportType.toInt());
    }

    @Override // org.linphone.core.Address
    public synchronized void setUriParams(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUriParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUriParams(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String getUsername() {
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized int setUsername(String str) {
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
        return setUsername(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String asString() {
        return asString(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized String asStringUriOnly() {
        return asStringUriOnly(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized void clean() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clean() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clean(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized Address clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean equal(Address address) {
        return equal(this.nativePtr, address);
    }

    @Override // org.linphone.core.Address
    public synchronized String getHeader(String str) {
        return getHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String getParam(String str) {
        return getParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized String getUriParam(String str) {
        return getUriParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean hasParam(String str) {
        return hasParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean hasUriParam(String str) {
        return hasUriParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized void removeUriParam(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeUriParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        removeUriParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Address
    public synchronized void setHeader(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Address
    public synchronized void setParam(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParam(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Address
    public synchronized void setUriParam(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUriParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUriParam(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Address
    public synchronized boolean weakEqual(Address address) {
        return weakEqual(this.nativePtr, address);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Address
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Address
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Address
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
