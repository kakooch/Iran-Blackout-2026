package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: AccountParams.java */
/* loaded from: classes3.dex */
class AccountParamsImpl implements AccountParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addCustomParam(long j, String str, String str2);

    private native AccountParams clone(long j);

    private native Address getAudioVideoConferenceFactoryAddress(long j);

    private native int getAvpfMode(long j);

    private native int getAvpfRrInterval(long j);

    private native String getConferenceFactoryUri(long j);

    private native String getContactParameters(long j);

    private native String getContactUriParameters(long j);

    private native Address getCustomContact(long j);

    private native String getCustomParam(long j, String str);

    private native String getDomain(long j);

    private native int getExpires(long j);

    private native String getIdentity(long j);

    private native Address getIdentityAddress(long j);

    private native String getIdkey(long j);

    private native String getInternationalPrefix(long j);

    private native String getLimeServerUrl(long j);

    private native NatPolicy getNatPolicy(long j);

    private native int getPrivacy(long j);

    private native int getPublishExpires(long j);

    private native boolean getPushNotificationAllowed(long j);

    private native PushNotificationConfig getPushNotificationConfig(long j);

    private native String getQualityReportingCollector(long j);

    private native int getQualityReportingInterval(long j);

    private native String getRealm(long j);

    private native String getRefKey(long j);

    private native boolean getRemotePushNotificationAllowed(long j);

    private native Address[] getRoutesAddresses(long j);

    private native String getServerAddr(long j);

    private native Address getServerAddress(long j);

    private native int getTransport(long j);

    private native boolean getUseInternationalPrefixForCallsAndChats(long j);

    private native boolean isCpimInBasicChatRoomEnabled(long j);

    private native boolean isDialEscapePlusEnabled(long j);

    private native boolean isOutboundProxyEnabled(long j);

    private native boolean isPublishEnabled(long j);

    private native boolean isPushNotificationAvailable(long j);

    private native boolean isQualityReportingEnabled(long j);

    private native boolean isRegisterEnabled(long j);

    private native boolean isRtpBundleAssumptionEnabled(long j);

    private native boolean isRtpBundleEnabled(long j);

    private native AccountParams newWithConfig(long j, Core core, int i);

    private native void setAudioVideoConferenceFactoryAddress(long j, Address address);

    private native void setAvpfMode(long j, int i);

    private native void setAvpfRrInterval(long j, int i);

    private native void setConferenceFactoryUri(long j, String str);

    private native void setContactParameters(long j, String str);

    private native void setContactUriParameters(long j, String str);

    private native void setCpimInBasicChatRoomEnabled(long j, boolean z);

    private native void setCustomContact(long j, Address address);

    private native void setDialEscapePlusEnabled(long j, boolean z);

    private native void setExpires(long j, int i);

    private native int setIdentityAddress(long j, Address address);

    private native void setIdkey(long j, String str);

    private native void setInternationalPrefix(long j, String str);

    private native void setLimeServerUrl(long j, String str);

    private native void setNatPolicy(long j, NatPolicy natPolicy);

    private native void setOutboundProxyEnabled(long j, boolean z);

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

    private native int setRoutesAddresses(long j, Address[] addressArr);

    private native void setRtpBundleAssumptionEnabled(long j, boolean z);

    private native void setRtpBundleEnabled(long j, boolean z);

    private native int setServerAddr(long j, String str);

    private native int setServerAddress(long j, Address address);

    private native void setTransport(long j, int i);

    private native void setUseInternationalPrefixForCallsAndChats(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected AccountParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.AccountParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.AccountParams
    public synchronized Address getAudioVideoConferenceFactoryAddress() {
        return getAudioVideoConferenceFactoryAddress(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setAudioVideoConferenceFactoryAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioVideoConferenceFactoryAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioVideoConferenceFactoryAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized AVPFMode getAvpfMode() {
        return AVPFMode.fromInt(getAvpfMode(this.nativePtr));
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setAvpfMode(AVPFMode aVPFMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAvpfMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setAvpfMode(this.nativePtr, aVPFMode.toInt());
        }
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int getAvpfRrInterval() {
        return getAvpfRrInterval(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setAvpfRrInterval(int i) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getConferenceFactoryUri() {
        return getConferenceFactoryUri(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setConferenceFactoryUri(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getContactParameters() {
        return getContactParameters(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setContactParameters(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getContactUriParameters() {
        return getContactUriParameters(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setContactUriParameters(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isCpimInBasicChatRoomEnabled() {
        return isCpimInBasicChatRoomEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setCpimInBasicChatRoomEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCpimInBasicChatRoomEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCpimInBasicChatRoomEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized Address getCustomContact() {
        return getCustomContact(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setCustomContact(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCustomContact() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCustomContact(this.nativePtr, address);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isDialEscapePlusEnabled() {
        return isDialEscapePlusEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setDialEscapePlusEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDialEscapePlusEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDialEscapePlusEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized String getDomain() {
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int getExpires() {
        return getExpires(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setExpires(int i) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getIdentity() {
        return getIdentity(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized Address getIdentityAddress() {
        return getIdentityAddress(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int setIdentityAddress(Address address) {
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
        return setIdentityAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized String getIdkey() {
        return getIdkey(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setIdkey(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getInternationalPrefix() {
        return getInternationalPrefix(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setInternationalPrefix(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInternationalPrefix() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setInternationalPrefix(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isPushNotificationAvailable() {
        return isPushNotificationAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized String getLimeServerUrl() {
        return getLimeServerUrl(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setLimeServerUrl(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLimeServerUrl() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLimeServerUrl(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized NatPolicy getNatPolicy() {
        return getNatPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setNatPolicy(NatPolicy natPolicy) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isOutboundProxyEnabled() {
        return isOutboundProxyEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setOutboundProxyEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOutboundProxyEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOutboundProxyEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int getPrivacy() {
        return getPrivacy(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setPrivacy(int i) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isPublishEnabled() {
        return isPublishEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setPublishEnabled(boolean z) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized int getPublishExpires() {
        return getPublishExpires(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setPublishExpires(int i) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean getPushNotificationAllowed() {
        return getPushNotificationAllowed(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setPushNotificationAllowed(boolean z) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized PushNotificationConfig getPushNotificationConfig() {
        return getPushNotificationConfig(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setPushNotificationConfig(PushNotificationConfig pushNotificationConfig) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getQualityReportingCollector() {
        return getQualityReportingCollector(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setQualityReportingCollector(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isQualityReportingEnabled() {
        return isQualityReportingEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setQualityReportingEnabled(boolean z) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized int getQualityReportingInterval() {
        return getQualityReportingInterval(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setQualityReportingInterval(int i) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getRealm() {
        return getRealm(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
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

    @Override // org.linphone.core.AccountParams
    public synchronized String getRefKey() {
        return getRefKey(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setRefKey(String str) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isRegisterEnabled() {
        return isRegisterEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setRegisterEnabled(boolean z) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized boolean getRemotePushNotificationAllowed() {
        return getRemotePushNotificationAllowed(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setRemotePushNotificationAllowed(boolean z) {
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

    @Override // org.linphone.core.AccountParams
    public synchronized Address[] getRoutesAddresses() {
        return getRoutesAddresses(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int setRoutesAddresses(Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRoutesAddresses() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setRoutesAddresses(this.nativePtr, addressArr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isRtpBundleAssumptionEnabled() {
        return isRtpBundleAssumptionEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setRtpBundleAssumptionEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRtpBundleAssumptionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRtpBundleAssumptionEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized boolean isRtpBundleEnabled() {
        return isRtpBundleEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setRtpBundleEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRtpBundleEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRtpBundleEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized String getServerAddr() {
        return getServerAddr(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int setServerAddr(String str) {
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
        return setServerAddr(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized Address getServerAddress() {
        return getServerAddress(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized int setServerAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setServerAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setServerAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized TransportType getTransport() {
        return TransportType.fromInt(getTransport(this.nativePtr));
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setTransport(TransportType transportType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTransport() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setTransport(this.nativePtr, transportType.toInt());
        }
    }

    @Override // org.linphone.core.AccountParams
    public synchronized boolean getUseInternationalPrefixForCallsAndChats() {
        return getUseInternationalPrefixForCallsAndChats(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized void setUseInternationalPrefixForCallsAndChats(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUseInternationalPrefixForCallsAndChats() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUseInternationalPrefixForCallsAndChats(this.nativePtr, z);
    }

    @Override // org.linphone.core.AccountParams
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

    @Override // org.linphone.core.AccountParams
    public synchronized AccountParams clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized String getCustomParam(String str) {
        return getCustomParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.AccountParams
    public synchronized AccountParams newWithConfig(Core core, int i) {
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
        return newWithConfig(this.nativePtr, core, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.AccountParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.AccountParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.AccountParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
