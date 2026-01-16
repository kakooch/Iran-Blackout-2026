package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Account.java */
/* loaded from: classes3.dex */
class AccountImpl implements Account {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addCustomParam(long j, String str, String str2);

    private native void addListener(long j, AccountListener accountListener);

    private native Account clone(long j);

    private native AuthInfo findAuthInfo(long j);

    private native Address getContactAddress(long j);

    private native Core getCore(long j);

    private native String getCustomHeader(long j, String str);

    private native String getCustomParam(long j, String str);

    private native Account getDependency(long j);

    private native int getError(long j);

    private native ErrorInfo getErrorInfo(long j);

    private native AccountParams getParams(long j);

    private native int getState(long j);

    private native int getTransport(long j);

    private native int getUnreadChatMessageCount(long j);

    private native boolean isAvpfEnabled(long j);

    private native boolean isPhoneNumber(long j, String str);

    private native Account newWithConfig(long j, Core core, AccountParams accountParams, ProxyConfig proxyConfig);

    private native String normalizePhoneNumber(long j, String str);

    private native Address normalizeSipUri(long j, String str);

    private native void pauseRegister(long j);

    private native void refreshRegister(long j);

    private native void removeListener(long j, AccountListener accountListener);

    private native void setContactAddress(long j, Address address);

    private native void setCustomHeader(long j, String str, String str2);

    private native void setDependency(long j, Account account);

    private native int setParams(long j, AccountParams accountParams);

    private native boolean unref(long j, boolean z);

    protected AccountImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Account
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Account
    public synchronized boolean isAvpfEnabled() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAvpfEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return isAvpfEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized Address getContactAddress() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getContactAddress(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized void setContactAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setContactAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setContactAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.Account
    public synchronized Core getCore() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCore() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized Account getDependency() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDependency() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDependency(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized void setDependency(Account account) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDependency() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDependency(this.nativePtr, account);
    }

    @Override // org.linphone.core.Account
    public synchronized Reason getError() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getError() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return Reason.fromInt(getError(this.nativePtr));
    }

    @Override // org.linphone.core.Account
    public synchronized ErrorInfo getErrorInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getErrorInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getErrorInfo(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized AccountParams getParams() {
        return getParams(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized int setParams(AccountParams accountParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setParams(this.nativePtr, accountParams);
    }

    @Override // org.linphone.core.Account
    public synchronized RegistrationState getState() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getState() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return RegistrationState.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.Account
    public synchronized TransportType getTransport() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getTransport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return TransportType.fromInt(getTransport(this.nativePtr));
    }

    @Override // org.linphone.core.Account
    public synchronized int getUnreadChatMessageCount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUnreadChatMessageCount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUnreadChatMessageCount(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized void addCustomParam(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addCustomParam(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Account
    public synchronized Account clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized AuthInfo findAuthInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findAuthInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findAuthInfo(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized String getCustomHeader(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCustomHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getCustomHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.Account
    public synchronized String getCustomParam(String str) {
        return getCustomParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.Account
    public synchronized boolean isPhoneNumber(String str) {
        return isPhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.Account
    public synchronized String normalizePhoneNumber(String str) {
        return normalizePhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.Account
    public synchronized Address normalizeSipUri(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call normalizeSipUri() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return normalizeSipUri(this.nativePtr, str);
    }

    @Override // org.linphone.core.Account
    public synchronized void pauseRegister() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call pauseRegister() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        pauseRegister(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized void refreshRegister() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call refreshRegister() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        refreshRegister(this.nativePtr);
    }

    @Override // org.linphone.core.Account
    public synchronized void setCustomHeader(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCustomHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCustomHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Account
    public synchronized Account newWithConfig(Core core, AccountParams accountParams, ProxyConfig proxyConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newWithConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newWithConfig(this.nativePtr, core, accountParams, proxyConfig);
    }

    @Override // org.linphone.core.Account
    public synchronized void addListener(AccountListener accountListener) {
        addListener(this.nativePtr, accountListener);
    }

    @Override // org.linphone.core.Account
    public synchronized void removeListener(AccountListener accountListener) {
        removeListener(this.nativePtr, accountListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Account
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Account
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Account
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
