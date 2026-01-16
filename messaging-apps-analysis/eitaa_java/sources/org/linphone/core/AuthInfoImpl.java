package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: AuthInfo.java */
/* loaded from: classes3.dex */
class AuthInfoImpl implements AuthInfo {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addAvailableAlgorithm(long j, String str);

    private native void clearAvailableAlgorithms(long j);

    private native AuthInfo clone(long j);

    private native String getAlgorithm(long j);

    private native String[] getAvailableAlgorithms(long j);

    private native String getDomain(long j);

    private native String getHa11(long j);

    private native String getPassword(long j);

    private native String getRealm(long j);

    private native String getTlsCert(long j);

    private native String getTlsCertPath(long j);

    private native String getTlsKey(long j);

    private native String getTlsKeyPath(long j);

    private native String getUserid(long j);

    private native String getUsername(long j);

    private native boolean isEqualButAlgorithms(long j, AuthInfo authInfo);

    private native void setAlgorithm(long j, String str);

    private native void setAvailableAlgorithms(long j, String[] strArr);

    private native void setDomain(long j, String str);

    private native void setHa11(long j, String str);

    private native void setPassword(long j, String str);

    private native void setRealm(long j, String str);

    private native void setTlsCert(long j, String str);

    private native void setTlsCertPath(long j, String str);

    private native void setTlsKey(long j, String str);

    private native void setTlsKeyPath(long j, String str);

    private native void setUserid(long j, String str);

    private native void setUsername(long j, String str);

    private native boolean unref(long j, boolean z);

    protected AuthInfoImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.AuthInfo
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getAlgorithm() {
        return getAlgorithm(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setAlgorithm(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAlgorithm() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAlgorithm(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String[] getAvailableAlgorithms() {
        return getAvailableAlgorithms(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setAvailableAlgorithms(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAvailableAlgorithms() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAvailableAlgorithms(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getDomain() {
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
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

    @Override // org.linphone.core.AuthInfo
    public synchronized String getHa1() {
        return getHa11(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setHa1(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHa1() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHa11(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getPassword() {
        return getPassword(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
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

    @Override // org.linphone.core.AuthInfo
    public synchronized String getRealm() {
        return getRealm(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setRealm(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRealm() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRealm(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getTlsCert() {
        return getTlsCert(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setTlsCert(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsCert() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsCert(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getTlsCertPath() {
        return getTlsCertPath(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setTlsCertPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsCertPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsCertPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getTlsKey() {
        return getTlsKey(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setTlsKey(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsKey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsKey(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getTlsKeyPath() {
        return getTlsKeyPath(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setTlsKeyPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsKeyPath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsKeyPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getUserid() {
        return getUserid(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void setUserid(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUserid() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUserid(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized String getUsername() {
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
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

    @Override // org.linphone.core.AuthInfo
    public synchronized void addAvailableAlgorithm(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addAvailableAlgorithm() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addAvailableAlgorithm(this.nativePtr, str);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized void clearAvailableAlgorithms() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearAvailableAlgorithms() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearAvailableAlgorithms(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized AuthInfo clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.AuthInfo
    public synchronized boolean isEqualButAlgorithms(AuthInfo authInfo) {
        return isEqualButAlgorithms(this.nativePtr, authInfo);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.AuthInfo
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.AuthInfo
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.AuthInfo
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
