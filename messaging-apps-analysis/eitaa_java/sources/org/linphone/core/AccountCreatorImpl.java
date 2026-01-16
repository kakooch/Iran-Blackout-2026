package org.linphone.core;

import org.linphone.core.AccountCreator;
import org.linphone.mediastream.Log;

/* compiled from: AccountCreator.java */
/* loaded from: classes3.dex */
class AccountCreatorImpl implements AccountCreator {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int activateAccount(long j);

    private native int activateAlias(long j);

    private native void addListener(long j, AccountCreatorListener accountCreatorListener);

    private native AccountCreator create(long j, Core core);

    private native int createAccount(long j);

    private native Account createAccountInCore(long j);

    private native ProxyConfig createProxyConfig(long j);

    private native String getAccountCreationRequestToken(long j);

    private native String getActivationCode(long j);

    private native String getAlgorithm(long j);

    private native String getDisplayName(long j);

    private native String getDomain(long j);

    private native String getEmail(long j);

    private native String getHa11(long j);

    private native String getLanguage(long j);

    private native String getPassword(long j);

    private native String getPhoneCountryCode(long j);

    private native String getPhoneNumber(long j);

    private native String getPnParam(long j);

    private native String getPnPrid(long j);

    private native String getPnProvider(long j);

    private native String getRoute(long j);

    private native boolean getSetAsDefault(long j);

    private native String getToken(long j);

    private native int getTransport(long j);

    private native String getUsername(long j);

    private native int isAccountActivated(long j);

    private native int isAccountExist(long j);

    private native int isAccountLinked(long j);

    private native int isAliasUsed(long j);

    private native int linkAccount(long j);

    private native int loginLinphoneAccount(long j);

    private native int recoverAccount(long j);

    private native void removeListener(long j, AccountCreatorListener accountCreatorListener);

    private native int requestAccountCreationRequestToken(long j);

    private native int requestAccountCreationTokenUsingRequestToken(long j);

    private native int requestAuthToken(long j);

    private native void reset(long j);

    private native void setAccountCreationRequestToken(long j, String str);

    private native int setActivationCode(long j, String str);

    private native int setAlgorithm(long j, String str);

    private native int setAsDefault(long j, boolean z);

    private native int setDisplayName(long j, String str);

    private native int setDomain(long j, String str);

    private native int setEmail(long j, String str);

    private native int setHa11(long j, String str);

    private native int setLanguage(long j, String str);

    private native int setPassword(long j, String str);

    private native int setPhoneNumber(long j, String str, String str2);

    private native void setPnParam(long j, String str);

    private native void setPnPrid(long j, String str);

    private native void setPnProvider(long j, String str);

    private native void setProxyConfig(long j, ProxyConfig proxyConfig);

    private native int setRoute(long j, String str);

    private native void setToken(long j, String str);

    private native int setTransport(long j, int i);

    private native int setUsername(long j, String str);

    private native boolean unref(long j, boolean z);

    private native int updateAccount(long j);

    private native void useTestAdminAccount(long j);

    protected AccountCreatorImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.AccountCreator
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getAccountCreationRequestToken() {
        return getAccountCreationRequestToken(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setAccountCreationRequestToken(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAccountCreationRequestToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAccountCreationRequestToken(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getActivationCode() {
        return getActivationCode(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.ActivationCodeStatus setActivationCode(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setActivationCode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.ActivationCodeStatus.fromInt(setActivationCode(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getAlgorithm() {
        return getAlgorithm(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreatorAlgoStatus setAlgorithm(String str) {
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
        return AccountCreatorAlgoStatus.fromInt(setAlgorithm(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status setAsDefault(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAsDefault() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(setAsDefault(this.nativePtr, z));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getDisplayName() {
        return getDisplayName(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.UsernameStatus setDisplayName(String str) {
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
        return AccountCreator.UsernameStatus.fromInt(setDisplayName(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getDomain() {
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.DomainStatus setDomain(String str) {
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
        return AccountCreator.DomainStatus.fromInt(setDomain(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getEmail() {
        return getEmail(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.EmailStatus setEmail(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEmail() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.EmailStatus.fromInt(setEmail(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getHa1() {
        return getHa11(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.PasswordStatus setHa1(String str) {
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
        return AccountCreator.PasswordStatus.fromInt(setHa11(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getLanguage() {
        return getLanguage(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.LanguageStatus setLanguage(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLanguage() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.LanguageStatus.fromInt(setLanguage(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPassword() {
        return getPassword(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.PasswordStatus setPassword(String str) {
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
        return AccountCreator.PasswordStatus.fromInt(setPassword(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPhoneCountryCode() {
        return getPhoneCountryCode(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPhoneNumber() {
        return getPhoneNumber(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPnParam() {
        return getPnParam(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setPnParam(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPnParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPnParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPnPrid() {
        return getPnPrid(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setPnPrid(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPnPrid() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPnPrid(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getPnProvider() {
        return getPnProvider(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setPnProvider(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPnProvider() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPnProvider(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setProxyConfig(ProxyConfig proxyConfig) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setProxyConfig() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setProxyConfig(this.nativePtr, proxyConfig);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getRoute() {
        return getRoute(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status setRoute(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRoute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(setRoute(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized boolean getSetAsDefault() {
        return getSetAsDefault(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getToken() {
        return getToken(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void setToken(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setToken(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized TransportType getTransport() {
        return TransportType.fromInt(getTransport(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.TransportStatus setTransport(TransportType transportType) {
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
        return AccountCreator.TransportStatus.fromInt(setTransport(this.nativePtr, transportType.toInt()));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized String getUsername() {
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.UsernameStatus setUsername(String str) {
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
        return AccountCreator.UsernameStatus.fromInt(setUsername(this.nativePtr, str));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status activateAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call activateAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(activateAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status activateAlias() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call activateAlias() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(activateAlias(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status createAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(createAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized Account createAccountInCore() {
        return createAccountInCore(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized ProxyConfig createProxyConfig() {
        return createProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status isAccountActivated() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAccountActivated() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(isAccountActivated(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status isAccountExist() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAccountExist() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(isAccountExist(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status isAccountLinked() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAccountLinked() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(isAccountLinked(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status isAliasUsed() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isAliasUsed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(isAliasUsed(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status linkAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call linkAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(linkAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status loginLinphoneAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call loginLinphoneAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(loginLinphoneAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status recoverAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call recoverAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(recoverAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status requestAccountCreationRequestToken() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call requestAccountCreationRequestToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(requestAccountCreationRequestToken(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status requestAccountCreationTokenUsingRequestToken() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call requestAccountCreationTokenUsingRequestToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(requestAccountCreationTokenUsingRequestToken(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status requestAuthToken() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call requestAuthToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(requestAuthToken(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void reset() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reset() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reset(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized int setPhoneNumber(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPhoneNumber() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setPhoneNumber(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator.Status updateAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call updateAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return AccountCreator.Status.fromInt(updateAccount(this.nativePtr));
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void useTestAdminAccount() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call useTestAdminAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        useTestAdminAccount(this.nativePtr);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized AccountCreator create(Core core) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call create() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return create(this.nativePtr, core);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void addListener(AccountCreatorListener accountCreatorListener) {
        addListener(this.nativePtr, accountCreatorListener);
    }

    @Override // org.linphone.core.AccountCreator
    public synchronized void removeListener(AccountCreatorListener accountCreatorListener) {
        removeListener(this.nativePtr, accountCreatorListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.AccountCreator
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.AccountCreator
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.AccountCreator
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
