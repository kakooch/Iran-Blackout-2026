package org.linphone.core;

import android.util.Log;
import org.linphone.mediastream.Version;

/* compiled from: Factory.java */
/* loaded from: classes3.dex */
class FactoryImpl extends Factory {
    protected long nativePtr;
    protected transient Object userData = null;
    protected boolean _isConst = false;
    protected LoggingService loggingService = null;

    private native String computeHa1ForAlgorithm(long j, String str, String str2, String str3, String str4);

    private native Address createAddress(long j, String str);

    private native AuthInfo createAuthInfo(long j, String str, String str2, String str3, String str4, String str5, String str6);

    private native AuthInfo createAuthInfo2(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    private native Buffer createBuffer(long j);

    private native Buffer createBufferFromData(long j, byte[] bArr, int i);

    private native Buffer createBufferFromString(long j, String str);

    private native ConferenceInfo createConferenceInfo(long j);

    private native ConferenceInfo createConferenceInfoFromIcalendarContent(long j, Content content);

    private native Config createConfig(long j, String str);

    private native Config createConfigFromString(long j, String str);

    private native Config createConfigWithFactory(long j, String str, String str2);

    private native Content createContent(long j);

    private native Content createContentFromFile(long j, String str);

    private native Core createCore3(long j, String str, String str2, Object obj);

    private native Core createCoreWithConfig3(long j, Config config, Object obj);

    private native DigestAuthenticationPolicy createDigestAuthenticationPolicy(long j);

    private native ErrorInfo createErrorInfo(long j);

    private native FriendPhoneNumber createFriendPhoneNumber(long j, String str, String str2);

    private native ParticipantDeviceIdentity createParticipantDeviceIdentity(long j, Address address, String str);

    private native Content createQrcode(long j, String str, int i, int i2, int i3);

    private native Range createRange(long j);

    private native Transports createTransports(long j);

    private native TunnelConfig createTunnelConfig(long j);

    private native Vcard createVcard(long j);

    private native VideoActivationPolicy createVideoActivationPolicy(long j);

    private native VideoDefinition createVideoDefinition(long j, int i, int i2);

    private native VideoDefinition createVideoDefinitionFromName(long j, String str);

    private native VideoSourceDescriptor createVideoSourceDescriptor(long j);

    private native void enableLogCollection(long j, int i);

    private native String getCacheDir(long j, Object obj);

    private native String getConfigDir(long j, Object obj);

    private native Core getCore(long j, long j2);

    private native String getDataDir(long j, Object obj);

    private native String getDataResourcesDir(long j);

    private native DialPlan[] getDialPlans(long j);

    private native String getDownloadDir(long j, Object obj);

    private native String getImageResourcesDir(long j);

    private native String getMspluginsDir(long j);

    private native VideoDefinition[] getRecommendedVideoDefinitions(long j);

    private native String getRingResourcesDir(long j);

    private native String getSoundResourcesDir(long j);

    private native VideoDefinition[] getSupportedVideoDefinitions(long j);

    private native String getTopResourcesDir(long j);

    private native long init();

    private native boolean isCacheDirSet(long j);

    private native boolean isChatroomBackendAvailable(long j, int i);

    private native boolean isConfigDirSet(long j);

    private native boolean isDataDirSet(long j);

    private native boolean isDatabaseStorageAvailable(long j);

    private native boolean isDownloadDirSet(long j);

    private native boolean isImdnAvailable(long j);

    private native boolean isQrcodeAvailable(long j);

    private native void setCacheDir(long j, String str);

    private native void setConfigDir(long j, String str);

    private native void setDataDir(long j, String str);

    private native void setDataResourcesDir(long j, String str);

    private native void setDownloadDir(long j, String str);

    private native void setImageResourcesDir(long j, String str);

    private native void setLogCollectionPath(long j, String str);

    private native void setMspluginsDir(long j, String str);

    private native void setRingResourcesDir(long j, String str);

    private native void setSoundResourcesDir(long j, String str);

    private native void setTopResourcesDir(long j, String str);

    private native void setVfsEncryption(long j, int i, byte[] bArr, int i2);

    private native int writeQrcodeFile(long j, String str, String str2, int i, int i2, int i3);

    @Override // org.linphone.core.Factory
    public native void enableLogcatLogs(boolean z);

    @Override // org.linphone.core.Factory
    public native void setDebugMode(boolean z, String str);

    @Override // org.linphone.core.Factory
    public native void setLoggerDomain(String str);

    protected FactoryImpl() {
        this.nativePtr = 0L;
        this.nativePtr = init();
    }

    @Override // org.linphone.core.Factory
    public long getNativePointer() {
        return this.nativePtr;
    }

    private static boolean loadOptionalLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            Log.w("FactoryImpl", "Unable to load optional library " + str + ": " + th.getMessage());
            return false;
        }
    }

    static {
        System.loadLibrary("c++_shared");
        loadOptionalLibrary("ffmpeg-linphone");
        System.loadLibrary("bctoolbox");
        System.loadLibrary("ortp");
        System.loadLibrary("mediastreamer");
        System.loadLibrary("linphone");
        Version.dumpCapabilities();
    }

    @Override // org.linphone.core.Factory
    public Core getCore(long j) {
        return getCore(this.nativePtr, j);
    }

    @Override // org.linphone.core.Factory
    public LoggingService getLoggingService() {
        if (this.loggingService == null) {
            this.loggingService = new LoggingServiceImpl(0L, false).get();
        }
        return this.loggingService;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Factory
    public synchronized void setCacheDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCacheDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setCacheDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setConfigDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConfigDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setConfigDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setDataDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDataDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setDataDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getDataResourcesDir() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDataResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getDataResourcesDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setDataResourcesDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDataResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setDataResourcesDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized DialPlan[] getDialPlans() {
        return getDialPlans(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setDownloadDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDownloadDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setDownloadDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getImageResourcesDir() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getImageResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getImageResourcesDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setImageResourcesDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setImageResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setImageResourcesDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isCacheDirSet() {
        return isCacheDirSet(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isConfigDirSet() {
        return isConfigDirSet(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isDataDirSet() {
        return isDataDirSet(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isDatabaseStorageAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isDatabaseStorageAvailable() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return isDatabaseStorageAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isDownloadDirSet() {
        return isDownloadDirSet(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isImdnAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isImdnAvailable() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return isImdnAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isQrcodeAvailable() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isQrcodeAvailable() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return isQrcodeAvailable(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setLogCollectionPath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogCollectionPath() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setLogCollectionPath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getMspluginsDir() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getMspluginsDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getMspluginsDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setMspluginsDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMspluginsDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setMspluginsDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoDefinition[] getRecommendedVideoDefinitions() {
        return getRecommendedVideoDefinitions(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getRingResourcesDir() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getRingResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getRingResourcesDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setRingResourcesDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRingResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setRingResourcesDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getSoundResourcesDir() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getSoundResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getSoundResourcesDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setSoundResourcesDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSoundResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setSoundResourcesDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoDefinition[] getSupportedVideoDefinitions() {
        return getSupportedVideoDefinitions(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getTopResourcesDir() {
        return getTopResourcesDir(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void setTopResourcesDir(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTopResourcesDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        setTopResourcesDir(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized String computeHa1ForAlgorithm(String str, String str2, String str3, String str4) {
        return computeHa1ForAlgorithm(this.nativePtr, str, str2, str3, str4);
    }

    @Override // org.linphone.core.Factory
    public synchronized Address createAddress(String str) {
        return createAddress(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized AuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        return createAuthInfo(this.nativePtr, str, str2, str3, str4, str5, str6);
    }

    @Override // org.linphone.core.Factory
    public synchronized AuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return createAuthInfo2(this.nativePtr, str, str2, str3, str4, str5, str6, str7);
    }

    @Override // org.linphone.core.Factory
    public synchronized Buffer createBuffer() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createBuffer() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createBuffer(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized Buffer createBufferFromData(byte[] bArr, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createBufferFromData() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createBufferFromData(this.nativePtr, bArr, i);
    }

    @Override // org.linphone.core.Factory
    public synchronized Buffer createBufferFromString(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createBufferFromString() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createBufferFromString(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized ConferenceInfo createConferenceInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConferenceInfo() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createConferenceInfo(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized ConferenceInfo createConferenceInfoFromIcalendarContent(Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConferenceInfoFromIcalendarContent() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createConferenceInfoFromIcalendarContent(this.nativePtr, content);
    }

    @Override // org.linphone.core.Factory
    public synchronized Config createConfig(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConfig() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createConfig(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized Config createConfigFromString(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConfigFromString() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createConfigFromString(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized Config createConfigWithFactory(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createConfigWithFactory() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createConfigWithFactory(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Factory
    public synchronized Content createContent() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createContent() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createContent(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized Content createContentFromFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createContentFromFile() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createContentFromFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized Core createCore(String str, String str2, Object obj) {
        return createCore3(this.nativePtr, str, str2, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized Core createCoreWithConfig(Config config, Object obj) {
        return createCoreWithConfig3(this.nativePtr, config, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized DigestAuthenticationPolicy createDigestAuthenticationPolicy() {
        return createDigestAuthenticationPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized ErrorInfo createErrorInfo() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createErrorInfo() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createErrorInfo(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized FriendPhoneNumber createFriendPhoneNumber(String str, String str2) {
        return createFriendPhoneNumber(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Factory
    public synchronized ParticipantDeviceIdentity createParticipantDeviceIdentity(Address address, String str) {
        return createParticipantDeviceIdentity(this.nativePtr, address, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized Content createQrcode(String str, int i, int i2, int i3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createQrcode() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createQrcode(this.nativePtr, str, i, i2, i3);
    }

    @Override // org.linphone.core.Factory
    public synchronized Range createRange() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createRange() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createRange(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized Transports createTransports() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createTransports() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createTransports(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized TunnelConfig createTunnelConfig() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createTunnelConfig() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createTunnelConfig(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized Vcard createVcard() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createVcard() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createVcard(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoActivationPolicy createVideoActivationPolicy() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createVideoActivationPolicy() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createVideoActivationPolicy(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoDefinition createVideoDefinition(int i, int i2) {
        return createVideoDefinition(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoDefinition createVideoDefinitionFromName(String str) {
        return createVideoDefinitionFromName(this.nativePtr, str);
    }

    @Override // org.linphone.core.Factory
    public synchronized VideoSourceDescriptor createVideoSourceDescriptor() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createVideoSourceDescriptor() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return createVideoSourceDescriptor(this.nativePtr);
    }

    @Override // org.linphone.core.Factory
    public synchronized void enableLogCollection(LogCollectionState logCollectionState) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enableLogCollection() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        } else {
            enableLogCollection(this.nativePtr, logCollectionState.toInt());
        }
    }

    @Override // org.linphone.core.Factory
    public synchronized String getCacheDir(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getCacheDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getCacheDir(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getConfigDir(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getConfigDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getConfigDir(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getDataDir(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDataDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getDataDir(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized String getDownloadDir(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDownloadDir() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return getDownloadDir(this.nativePtr, obj);
    }

    @Override // org.linphone.core.Factory
    public synchronized boolean isChatroomBackendAvailable(ChatRoomBackend chatRoomBackend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call isChatroomBackendAvailable() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return isChatroomBackendAvailable(this.nativePtr, chatRoomBackend.toInt());
    }

    @Override // org.linphone.core.Factory
    public synchronized void setVfsEncryption(int i, byte[] bArr, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVfsEncryption() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        } else {
            setVfsEncryption(this.nativePtr, i, bArr, i2);
        }
    }

    @Override // org.linphone.core.Factory
    public synchronized int writeQrcodeFile(String str, String str2, int i, int i2, int i3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call writeQrcodeFile() on it, clone it first.");
            } catch (CoreException e) {
                org.linphone.mediastream.Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    org.linphone.mediastream.Log.e(stackTraceElement);
                }
            }
        }
        return writeQrcodeFile(this.nativePtr, str, str2, i, i2, i3);
    }

    @Override // org.linphone.core.Factory
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Factory
    public Object getUserData() {
        return this.userData;
    }
}
