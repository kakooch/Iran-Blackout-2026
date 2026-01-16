package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: LdapParams.java */
/* loaded from: classes3.dex */
class LdapParamsImpl implements LdapParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int check(long j);

    private native LdapParams clone(long j);

    private native int getAuthMethod(long j);

    private native String getBaseObject(long j);

    private native String getBindDn(long j);

    private native String getCustomValue(long j, String str);

    private native int getDebugLevel(long j);

    private native int getDelay(long j);

    private native boolean getEnabled(long j);

    private native String getFilter(long j);

    private native int getMaxResults(long j);

    private native int getMinChars(long j);

    private native String getNameAttribute(long j);

    private native String getPassword(long j);

    private native String getServer(long j);

    private native int getServerCertificatesVerificationMode(long j);

    private native String getSipAttribute(long j);

    private native String getSipDomain(long j);

    private native int getTimeout(long j);

    private native boolean isSalEnabled(long j);

    private native boolean isTlsEnabled(long j);

    private native void setAuthMethod(long j, int i);

    private native void setBaseObject(long j, String str);

    private native void setBindDn(long j, String str);

    private native void setCustomValue(long j, String str, String str2);

    private native void setDebugLevel(long j, int i);

    private native void setDelay(long j, int i);

    private native void setEnabled(long j, boolean z);

    private native void setFilter(long j, String str);

    private native void setMaxResults(long j, int i);

    private native void setMinChars(long j, int i);

    private native void setNameAttribute(long j, String str);

    private native void setPassword(long j, String str);

    private native void setSalEnabled(long j, boolean z);

    private native void setServer(long j, String str);

    private native void setServerCertificatesVerificationMode(long j, int i);

    private native void setSipAttribute(long j, String str);

    private native void setSipDomain(long j, String str);

    private native void setTimeout(long j, int i);

    private native void setTlsEnabled(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected LdapParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.LdapParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.LdapParams
    public synchronized LdapAuthMethod getAuthMethod() {
        return LdapAuthMethod.fromInt(getAuthMethod(this.nativePtr));
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setAuthMethod(LdapAuthMethod ldapAuthMethod) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAuthMethod() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setAuthMethod(this.nativePtr, ldapAuthMethod.toInt());
        }
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getBaseObject() {
        return getBaseObject(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setBaseObject(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBaseObject() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setBaseObject(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getBindDn() {
        return getBindDn(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setBindDn(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBindDn() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setBindDn(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized LdapDebugLevel getDebugLevel() {
        return LdapDebugLevel.fromInt(getDebugLevel(this.nativePtr));
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setDebugLevel(LdapDebugLevel ldapDebugLevel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDebugLevel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setDebugLevel(this.nativePtr, ldapDebugLevel.toInt());
        }
    }

    @Override // org.linphone.core.LdapParams
    public synchronized int getDelay() {
        return getDelay(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
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

    @Override // org.linphone.core.LdapParams
    public synchronized boolean getEnabled() {
        return getEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getFilter() {
        return getFilter(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setFilter(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFilter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFilter(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized int getMaxResults() {
        return getMaxResults(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setMaxResults(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMaxResults() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMaxResults(this.nativePtr, i);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized int getMinChars() {
        return getMinChars(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setMinChars(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMinChars() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMinChars(this.nativePtr, i);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getNameAttribute() {
        return getNameAttribute(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setNameAttribute(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setNameAttribute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setNameAttribute(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getPassword() {
        return getPassword(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
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

    @Override // org.linphone.core.LdapParams
    public synchronized boolean isSalEnabled() {
        return isSalEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setSalEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSalEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSalEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getServer() {
        return getServer(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setServer(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setServer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setServer(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized LdapCertVerificationMode getServerCertificatesVerificationMode() {
        return LdapCertVerificationMode.fromInt(getServerCertificatesVerificationMode(this.nativePtr));
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setServerCertificatesVerificationMode(LdapCertVerificationMode ldapCertVerificationMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setServerCertificatesVerificationMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setServerCertificatesVerificationMode(this.nativePtr, ldapCertVerificationMode.toInt());
        }
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getSipAttribute() {
        return getSipAttribute(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setSipAttribute(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipAttribute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipAttribute(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getSipDomain() {
        return getSipDomain(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setSipDomain(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSipDomain() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSipDomain(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized int getTimeout() {
        return getTimeout(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setTimeout(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTimeout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTimeout(this.nativePtr, i);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized boolean isTlsEnabled() {
        return isTlsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setTlsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTlsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTlsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized int check() {
        return check(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized LdapParams clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized String getCustomValue(String str) {
        return getCustomValue(this.nativePtr, str);
    }

    @Override // org.linphone.core.LdapParams
    public synchronized void setCustomValue(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCustomValue() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCustomValue(this.nativePtr, str, str2);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.LdapParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.LdapParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.LdapParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
