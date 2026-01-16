package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ProxyConfig.java */
/* loaded from: classes3.dex */
class ProxyConfigImpl implements ProxyConfig {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int done(long j);

    private native void edit(long j);

    private native AuthInfo findAuthInfo(long j);

    private native int getAvpfMode(long j);

    private native int getAvpfRrInterval(long j);

    private native String getConferenceFactoryUri(long j);

    private native Address getContact(long j);

    private native String getContactParameters(long j);

    private native String getContactUriParameters(long j);

    private native Core getCore(long j);

    private native String getCustomHeader(long j, String str);

    private native ProxyConfig getDependency(long j);

    private native boolean getDialEscapePlus(long j);

    private native String getDialPrefix(long j);

    private native String getDomain(long j);

    private native int getError(long j);

    private native ErrorInfo getErrorInfo(long j);

    private native int getExpires(long j);

    private native Address getIdentityAddress(long j);

    private native String getIdkey(long j);

    private native NatPolicy getNatPolicy(long j);

    private native int getPrivacy(long j);

    private native int getPublishExpires(long j);

    private native PushNotificationConfig getPushNotificationConfig(long j);

    private native String getQualityReportingCollector(long j);

    private native int getQualityReportingInterval(long j);

    private native String getRealm(long j);

    private native String getRefKey(long j);

    private native String[] getRoutes(long j);

    private native String getServerAddr(long j);

    private native int getState(long j);

    private native String getTransport(long j);

    private native int getUnreadChatMessageCount(long j);

    private native boolean isAvpfEnabled(long j);

    private native boolean isPublishEnabled(long j);

    private native boolean isPushNotificationAllowed(long j);

    private native boolean isPushNotificationAvailable(long j);

    private native boolean isQualityReportingEnabled(long j);

    private native boolean isRegisterEnabled(long j);

    private native boolean isRemotePushNotificationAllowed(long j);

    private native String normalizePhoneNumber(long j, String str);

    private native Address normalizeSipUri(long j, String str);

    private native void pauseRegister(long j);

    private native void refreshRegister(long j);

    private native void setAvpfMode(long j, int i);

    private native void setAvpfRrInterval(long j, int i);

    private native void setConferenceFactoryUri(long j, String str);

    private native void setContactParameters(long j, String str);

    private native void setContactUriParameters(long j, String str);

    private native void setCustomHeader(long j, String str, String str2);

    private native void setDependency(long j, ProxyConfig proxyConfig);

    private native void setDialEscapePlus(long j, boolean z);

    private native void setDialPrefix(long j, String str);

    private native void setExpires(long j, int i);

    private native int setIdentityAddress(long j, Address address);

    private native void setIdkey(long j, String str);

    private native void setNatPolicy(long j, NatPolicy natPolicy);

    private native void setPrivacy(long j, int i);

    private native void setPublishEnabled(long j, boolean z);

    private native void setPublishExpires(long j, int i);

    private native void setPushNotificationAllowed(long j, boolean z);

    private native void setPushNotificationConfig(long j, PushNotificationConfig pushNotificationConfig);

    private native void setQualityReportingCollector(long j, String str);

    private native void setQualityReportingEnabled(long j, boolean z);

    private native void setQualityReportingInterval(long j, int i);

    private native void setRealm(long j, String str);

    private native void setRefKey(long j, String str);

    private native void setRegisterEnabled(long j, boolean z);

    private native void setRemotePushNotificationAllowed(long j, boolean z);

    private native int setRoute(long j, String str);

    private native int setRoutes(long j, String[] strArr);

    private native int setServerAddr(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ProxyConfigImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.ProxyConfig
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isAvpfEnabled() {
        boolean zIsAvpfEnabled;
        synchronized (this.core) {
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
            zIsAvpfEnabled = isAvpfEnabled(this.nativePtr);
        }
        return zIsAvpfEnabled;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized AVPFMode getAvpfMode() {
        AVPFMode aVPFModeFromInt;
        synchronized (this.core) {
            aVPFModeFromInt = AVPFMode.fromInt(getAvpfMode(this.nativePtr));
        }
        return aVPFModeFromInt;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setAvpfMode(AVPFMode aVPFMode) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setAvpfMode() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setAvpfMode(this.nativePtr, aVPFMode.toInt());
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getAvpfRrInterval() {
        int avpfRrInterval;
        synchronized (this.core) {
            avpfRrInterval = getAvpfRrInterval(this.nativePtr);
        }
        return avpfRrInterval;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setAvpfRrInterval(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setAvpfRrInterval() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setAvpfRrInterval(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getConferenceFactoryUri() {
        String conferenceFactoryUri;
        synchronized (this.core) {
            conferenceFactoryUri = getConferenceFactoryUri(this.nativePtr);
        }
        return conferenceFactoryUri;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setConferenceFactoryUri(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setConferenceFactoryUri() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setConferenceFactoryUri(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized Address getContact() {
        Address contact;
        synchronized (this.core) {
            contact = getContact(this.nativePtr);
        }
        return contact;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getContactParameters() {
        String contactParameters;
        synchronized (this.core) {
            contactParameters = getContactParameters(this.nativePtr);
        }
        return contactParameters;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setContactParameters(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setContactParameters() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setContactParameters(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getContactUriParameters() {
        String contactUriParameters;
        synchronized (this.core) {
            contactUriParameters = getContactUriParameters(this.nativePtr);
        }
        return contactUriParameters;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setContactUriParameters(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setContactUriParameters() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setContactUriParameters(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized ProxyConfig getDependency() {
        ProxyConfig dependency;
        synchronized (this.core) {
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
            dependency = getDependency(this.nativePtr);
        }
        return dependency;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setDependency(ProxyConfig proxyConfig) {
        synchronized (this.core) {
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
            setDependency(this.nativePtr, proxyConfig);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean getDialEscapePlus() {
        boolean dialEscapePlus;
        synchronized (this.core) {
            dialEscapePlus = getDialEscapePlus(this.nativePtr);
        }
        return dialEscapePlus;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setDialEscapePlus(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setDialEscapePlus() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setDialEscapePlus(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getDialPrefix() {
        String dialPrefix;
        synchronized (this.core) {
            dialPrefix = getDialPrefix(this.nativePtr);
        }
        return dialPrefix;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setDialPrefix(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setDialPrefix() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setDialPrefix(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getDomain() {
        String domain;
        synchronized (this.core) {
            domain = getDomain(this.nativePtr);
        }
        return domain;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized Reason getError() {
        Reason reasonFromInt;
        synchronized (this.core) {
            reasonFromInt = Reason.fromInt(getError(this.nativePtr));
        }
        return reasonFromInt;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized ErrorInfo getErrorInfo() {
        ErrorInfo errorInfo;
        synchronized (this.core) {
            errorInfo = getErrorInfo(this.nativePtr);
        }
        return errorInfo;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getExpires() {
        int expires;
        synchronized (this.core) {
            expires = getExpires(this.nativePtr);
        }
        return expires;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setExpires(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setExpires() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setExpires(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized Address getIdentityAddress() {
        Address identityAddress;
        synchronized (this.core) {
            identityAddress = getIdentityAddress(this.nativePtr);
        }
        return identityAddress;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int setIdentityAddress(Address address) {
        int identityAddress;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setIdentityAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            identityAddress = setIdentityAddress(this.nativePtr, address);
        }
        return identityAddress;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getIdkey() {
        String idkey;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getIdkey() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            idkey = getIdkey(this.nativePtr);
        }
        return idkey;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setIdkey(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setIdkey() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setIdkey(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isPushNotificationAllowed() {
        boolean zIsPushNotificationAllowed;
        synchronized (this.core) {
            zIsPushNotificationAllowed = isPushNotificationAllowed(this.nativePtr);
        }
        return zIsPushNotificationAllowed;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isPushNotificationAvailable() {
        boolean zIsPushNotificationAvailable;
        synchronized (this.core) {
            zIsPushNotificationAvailable = isPushNotificationAvailable(this.nativePtr);
        }
        return zIsPushNotificationAvailable;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isRemotePushNotificationAllowed() {
        boolean zIsRemotePushNotificationAllowed;
        synchronized (this.core) {
            zIsRemotePushNotificationAllowed = isRemotePushNotificationAllowed(this.nativePtr);
        }
        return zIsRemotePushNotificationAllowed;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized NatPolicy getNatPolicy() {
        NatPolicy natPolicy;
        synchronized (this.core) {
            natPolicy = getNatPolicy(this.nativePtr);
        }
        return natPolicy;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setNatPolicy(NatPolicy natPolicy) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setNatPolicy() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setNatPolicy(this.nativePtr, natPolicy);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getPrivacy() {
        int privacy;
        synchronized (this.core) {
            privacy = getPrivacy(this.nativePtr);
        }
        return privacy;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setPrivacy(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPrivacy() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPrivacy(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isPublishEnabled() {
        boolean zIsPublishEnabled;
        synchronized (this.core) {
            zIsPublishEnabled = isPublishEnabled(this.nativePtr);
        }
        return zIsPublishEnabled;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setPublishEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPublishEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPublishEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getPublishExpires() {
        int publishExpires;
        synchronized (this.core) {
            publishExpires = getPublishExpires(this.nativePtr);
        }
        return publishExpires;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setPublishExpires(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPublishExpires() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPublishExpires(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setPushNotificationAllowed(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPushNotificationAllowed() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPushNotificationAllowed(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized PushNotificationConfig getPushNotificationConfig() {
        PushNotificationConfig pushNotificationConfig;
        synchronized (this.core) {
            pushNotificationConfig = getPushNotificationConfig(this.nativePtr);
        }
        return pushNotificationConfig;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setPushNotificationConfig(PushNotificationConfig pushNotificationConfig) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setPushNotificationConfig() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setPushNotificationConfig(this.nativePtr, pushNotificationConfig);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getQualityReportingCollector() {
        String qualityReportingCollector;
        synchronized (this.core) {
            qualityReportingCollector = getQualityReportingCollector(this.nativePtr);
        }
        return qualityReportingCollector;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setQualityReportingCollector(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setQualityReportingCollector() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setQualityReportingCollector(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isQualityReportingEnabled() {
        boolean zIsQualityReportingEnabled;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isQualityReportingEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsQualityReportingEnabled = isQualityReportingEnabled(this.nativePtr);
        }
        return zIsQualityReportingEnabled;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setQualityReportingEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setQualityReportingEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setQualityReportingEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getQualityReportingInterval() {
        int qualityReportingInterval;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getQualityReportingInterval() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            qualityReportingInterval = getQualityReportingInterval(this.nativePtr);
        }
        return qualityReportingInterval;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setQualityReportingInterval(int i) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setQualityReportingInterval() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setQualityReportingInterval(this.nativePtr, i);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getRealm() {
        String realm;
        synchronized (this.core) {
            realm = getRealm(this.nativePtr);
        }
        return realm;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setRealm(String str) {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getRefKey() {
        String refKey;
        synchronized (this.core) {
            refKey = getRefKey(this.nativePtr);
        }
        return refKey;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setRefKey(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRefKey() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRefKey(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized boolean isRegisterEnabled() {
        boolean zIsRegisterEnabled;
        synchronized (this.core) {
            zIsRegisterEnabled = isRegisterEnabled(this.nativePtr);
        }
        return zIsRegisterEnabled;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setRegisterEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRegisterEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRegisterEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setRemotePushNotificationAllowed(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRemotePushNotificationAllowed() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setRemotePushNotificationAllowed(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int setRoute(String str) {
        int route;
        synchronized (this.core) {
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
            route = setRoute(this.nativePtr, str);
        }
        return route;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String[] getRoutes() {
        String[] routes;
        synchronized (this.core) {
            routes = getRoutes(this.nativePtr);
        }
        return routes;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int setRoutes(String[] strArr) {
        int routes;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setRoutes() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            routes = setRoutes(this.nativePtr, strArr);
        }
        return routes;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getServerAddr() {
        String serverAddr;
        synchronized (this.core) {
            serverAddr = getServerAddr(this.nativePtr);
        }
        return serverAddr;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int setServerAddr(String str) {
        int serverAddr;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setServerAddr() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            serverAddr = setServerAddr(this.nativePtr, str);
        }
        return serverAddr;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized RegistrationState getState() {
        RegistrationState registrationStateFromInt;
        synchronized (this.core) {
            registrationStateFromInt = RegistrationState.fromInt(getState(this.nativePtr));
        }
        return registrationStateFromInt;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getTransport() {
        String transport;
        synchronized (this.core) {
            transport = getTransport(this.nativePtr);
        }
        return transport;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int getUnreadChatMessageCount() {
        int unreadChatMessageCount;
        synchronized (this.core) {
            unreadChatMessageCount = getUnreadChatMessageCount(this.nativePtr);
        }
        return unreadChatMessageCount;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized int done() {
        int iDone;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call done() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iDone = done(this.nativePtr);
        }
        return iDone;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void edit() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call edit() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            edit(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized AuthInfo findAuthInfo() {
        AuthInfo authInfoFindAuthInfo;
        synchronized (this.core) {
            authInfoFindAuthInfo = findAuthInfo(this.nativePtr);
        }
        return authInfoFindAuthInfo;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String getCustomHeader(String str) {
        String customHeader;
        synchronized (this.core) {
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
            customHeader = getCustomHeader(this.nativePtr, str);
        }
        return customHeader;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized String normalizePhoneNumber(String str) {
        String strNormalizePhoneNumber;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call normalizePhoneNumber() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            strNormalizePhoneNumber = normalizePhoneNumber(this.nativePtr, str);
        }
        return strNormalizePhoneNumber;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized Address normalizeSipUri(String str) {
        Address addressNormalizeSipUri;
        synchronized (this.core) {
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
            addressNormalizeSipUri = normalizeSipUri(this.nativePtr, str);
        }
        return addressNormalizeSipUri;
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void pauseRegister() {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void refreshRegister() {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.ProxyConfig
    public synchronized void setCustomHeader(String str, String str2) {
        synchronized (this.core) {
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
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ProxyConfig
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ProxyConfig
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ProxyConfig
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
