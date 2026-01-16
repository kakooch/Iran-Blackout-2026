package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: CallParams.java */
/* loaded from: classes3.dex */
class CallParamsImpl implements CallParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addCustomContent(long j, Content content);

    private native void addCustomHeader(long j, String str, String str2);

    private native void addCustomSdpAttribute(long j, String str, String str2);

    private native void addCustomSdpMediaAttribute(long j, int i, String str, String str2);

    private native void clearCustomSdpAttributes(long j);

    private native void clearCustomSdpMediaAttributes(long j, int i);

    private native CallParams copy(long j);

    private native Account getAccount(long j);

    private native int getAudioDirection(long j);

    private native int getConferenceVideoLayout(long j);

    private native Content[] getCustomContents(long j);

    private native String getCustomHeader(long j, String str);

    private native String getCustomSdpAttribute(long j, String str);

    private native String getCustomSdpMediaAttribute(long j, int i, String str);

    private native String getFromHeader(long j);

    private native AudioDevice getInputAudioDevice(long j);

    private native boolean getLocalConferenceMode(long j);

    private native int getMediaEncryption(long j);

    private native AudioDevice getOutputAudioDevice(long j);

    private native int getPrivacy(long j);

    private native ProxyConfig getProxyConfig(long j);

    private native int getRealtimeTextKeepaliveInterval(long j);

    private native float getReceivedFramerate(long j);

    private native VideoDefinition getReceivedVideoDefinition(long j);

    private native String getRecordFile(long j);

    private native String getRtpProfile(long j);

    private native float getSentFramerate(long j);

    private native VideoDefinition getSentVideoDefinition(long j);

    private native String getSessionName(long j);

    private native int[] getSrtpSuites(long j);

    private native PayloadType getUsedAudioPayloadType(long j);

    private native PayloadType getUsedTextPayloadType(long j);

    private native PayloadType getUsedVideoPayloadType(long j);

    private native int getVideoDirection(long j);

    private native boolean hasCustomSdpAttribute(long j, String str);

    private native boolean hasCustomSdpMediaAttribute(long j, int i, String str);

    private native boolean isAudioEnabled(long j);

    private native boolean isAudioMulticastEnabled(long j);

    private native boolean isAvpfEnabled(long j);

    private native boolean isCapabilityNegotiationReinviteEnabled(long j);

    private native boolean isCapabilityNegotiationsEnabled(long j);

    private native boolean isEarlyMediaSendingEnabled(long j);

    private native boolean isLowBandwidthEnabled(long j);

    private native boolean isMediaEncryptionSupported(long j, int i);

    private native boolean isMicEnabled(long j);

    private native boolean isRealtimeTextEnabled(long j);

    private native boolean isRecording(long j);

    private native boolean isRtpBundleEnabled(long j);

    private native boolean isToneIndicationsEnabled(long j);

    private native boolean isVideoEnabled(long j);

    private native boolean isVideoMulticastEnabled(long j);

    private native void setAccount(long j, Account account);

    private native void setAudioBandwidthLimit(long j, int i);

    private native void setAudioDirection(long j, int i);

    private native void setAudioEnabled(long j, boolean z);

    private native void setAudioMulticastEnabled(long j, boolean z);

    private native void setAvpfEnabled(long j, boolean z);

    private native void setCapabilityNegotiationReinviteEnabled(long j, boolean z);

    private native void setCapabilityNegotiationsEnabled(long j, boolean z);

    private native void setConferenceVideoLayout(long j, int i);

    private native void setEarlyMediaSendingEnabled(long j, boolean z);

    private native void setFromHeader(long j, String str);

    private native void setInputAudioDevice(long j, AudioDevice audioDevice);

    private native void setLowBandwidthEnabled(long j, boolean z);

    private native void setMediaEncryption(long j, int i);

    private native void setMicEnabled(long j, boolean z);

    private native void setOutputAudioDevice(long j, AudioDevice audioDevice);

    private native void setPrivacy(long j, int i);

    private native void setProxyConfig(long j, ProxyConfig proxyConfig);

    private native int setRealtimeTextEnabled(long j, boolean z);

    private native void setRealtimeTextKeepaliveInterval(long j, int i);

    private native void setRecordFile(long j, String str);

    private native void setRtpBundleEnabled(long j, boolean z);

    private native void setSessionName(long j, String str);

    private native void setSrtpSuites(long j, int[] iArr);

    private native void setTcapLineMergingEnabled(long j, boolean z);

    private native void setToneIndicationsEnabled(long j, boolean z);

    private native void setVideoDirection(long j, int i);

    private native void setVideoEnabled(long j, boolean z);

    private native void setVideoMulticastEnabled(long j, boolean z);

    private native boolean tcapLinesMerged(long j);

    private native boolean unref(long j, boolean z);

    protected CallParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.CallParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.CallParams
    public synchronized Account getAccount() {
        return getAccount(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAccount(Account account) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAccount() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAccount(this.nativePtr, account);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAudioBandwidthLimit(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioBandwidthLimit() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioBandwidthLimit(this.nativePtr, i);
    }

    @Override // org.linphone.core.CallParams
    public synchronized MediaDirection getAudioDirection() {
        return MediaDirection.fromInt(getAudioDirection(this.nativePtr));
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAudioDirection(MediaDirection mediaDirection) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioDirection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setAudioDirection(this.nativePtr, mediaDirection.toInt());
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isAudioEnabled() {
        return isAudioEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAudioEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isAudioMulticastEnabled() {
        return isAudioMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAudioMulticastEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioMulticastEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioMulticastEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isAvpfEnabled() {
        return isAvpfEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setAvpfEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAvpfEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAvpfEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isCapabilityNegotiationReinviteEnabled() {
        return isCapabilityNegotiationReinviteEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setCapabilityNegotiationReinviteEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityNegotiationReinviteEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityNegotiationReinviteEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isCapabilityNegotiationsEnabled() {
        return isCapabilityNegotiationsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setCapabilityNegotiationsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityNegotiationsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityNegotiationsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized ConferenceLayout getConferenceVideoLayout() {
        return ConferenceLayout.fromInt(getConferenceVideoLayout(this.nativePtr));
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setConferenceVideoLayout(ConferenceLayout conferenceLayout) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceVideoLayout() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setConferenceVideoLayout(this.nativePtr, conferenceLayout.toInt());
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized Content[] getCustomContents() {
        return getCustomContents(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isEarlyMediaSendingEnabled() {
        return isEarlyMediaSendingEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setEarlyMediaSendingEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEarlyMediaSendingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEarlyMediaSendingEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getFromHeader() {
        return getFromHeader(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setFromHeader(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFromHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFromHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized AudioDevice getInputAudioDevice() {
        return getInputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setInputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setInputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isRecording() {
        return isRecording(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean getLocalConferenceMode() {
        return getLocalConferenceMode(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isLowBandwidthEnabled() {
        return isLowBandwidthEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setLowBandwidthEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLowBandwidthEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLowBandwidthEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized MediaEncryption getMediaEncryption() {
        return MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setMediaEncryption(MediaEncryption mediaEncryption) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMediaEncryption() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setMediaEncryption(this.nativePtr, mediaEncryption.toInt());
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isMicEnabled() {
        return isMicEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setMicEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMicEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMicEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized AudioDevice getOutputAudioDevice() {
        return getOutputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setOutputAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOutputAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOutputAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.CallParams
    public synchronized int getPrivacy() {
        return getPrivacy(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
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

    @Override // org.linphone.core.CallParams
    public synchronized ProxyConfig getProxyConfig() {
        return getProxyConfig(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
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

    @Override // org.linphone.core.CallParams
    public synchronized boolean isRealtimeTextEnabled() {
        return isRealtimeTextEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized int setRealtimeTextEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRealtimeTextEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setRealtimeTextEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized int getRealtimeTextKeepaliveInterval() {
        return getRealtimeTextKeepaliveInterval(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setRealtimeTextKeepaliveInterval(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRealtimeTextKeepaliveInterval() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRealtimeTextKeepaliveInterval(this.nativePtr, i);
    }

    @Override // org.linphone.core.CallParams
    public synchronized float getReceivedFramerate() {
        return getReceivedFramerate(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized VideoDefinition getReceivedVideoDefinition() {
        return getReceivedVideoDefinition(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getRecordFile() {
        return getRecordFile(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setRecordFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecordFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecordFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isRtpBundleEnabled() {
        return isRtpBundleEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
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

    @Override // org.linphone.core.CallParams
    public synchronized String getRtpProfile() {
        return getRtpProfile(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized float getSentFramerate() {
        return getSentFramerate(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized VideoDefinition getSentVideoDefinition() {
        return getSentVideoDefinition(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getSessionName() {
        return getSessionName(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setSessionName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSessionName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSessionName(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized SrtpSuite[] getSrtpSuites() {
        return SrtpSuite.fromIntArray(getSrtpSuites(this.nativePtr));
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setSrtpSuites(SrtpSuite[] srtpSuiteArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSrtpSuites() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setSrtpSuites(this.nativePtr, SrtpSuite.toIntArray(srtpSuiteArr));
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setTcapLineMergingEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTcapLineMergingEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTcapLineMergingEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isToneIndicationsEnabled() {
        return isToneIndicationsEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setToneIndicationsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setToneIndicationsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setToneIndicationsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized PayloadType getUsedAudioPayloadType() {
        return getUsedAudioPayloadType(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized PayloadType getUsedTextPayloadType() {
        return getUsedTextPayloadType(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized PayloadType getUsedVideoPayloadType() {
        return getUsedVideoPayloadType(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized MediaDirection getVideoDirection() {
        return MediaDirection.fromInt(getVideoDirection(this.nativePtr));
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setVideoDirection(MediaDirection mediaDirection) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoDirection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setVideoDirection(this.nativePtr, mediaDirection.toInt());
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isVideoEnabled() {
        return isVideoEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setVideoEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isVideoMulticastEnabled() {
        return isVideoMulticastEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void setVideoMulticastEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoMulticastEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoMulticastEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void addCustomContent(Content content) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addCustomContent(this.nativePtr, content);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void addCustomHeader(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addCustomHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void addCustomSdpAttribute(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomSdpAttribute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addCustomSdpAttribute(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void addCustomSdpMediaAttribute(StreamType streamType, String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomSdpMediaAttribute() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            addCustomSdpMediaAttribute(this.nativePtr, streamType.toInt(), str, str2);
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized void clearCustomSdpAttributes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearCustomSdpAttributes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clearCustomSdpAttributes(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized void clearCustomSdpMediaAttributes(StreamType streamType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearCustomSdpMediaAttributes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            clearCustomSdpMediaAttributes(this.nativePtr, streamType.toInt());
        }
    }

    @Override // org.linphone.core.CallParams
    public synchronized CallParams copy() {
        return copy(this.nativePtr);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getCustomSdpAttribute(String str) {
        return getCustomSdpAttribute(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized String getCustomSdpMediaAttribute(StreamType streamType, String str) {
        return getCustomSdpMediaAttribute(this.nativePtr, streamType.toInt(), str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean hasCustomSdpAttribute(String str) {
        return hasCustomSdpAttribute(this.nativePtr, str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean hasCustomSdpMediaAttribute(StreamType streamType, String str) {
        return hasCustomSdpMediaAttribute(this.nativePtr, streamType.toInt(), str);
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean isMediaEncryptionSupported(MediaEncryption mediaEncryption) {
        return isMediaEncryptionSupported(this.nativePtr, mediaEncryption.toInt());
    }

    @Override // org.linphone.core.CallParams
    public synchronized boolean tcapLinesMerged() {
        return tcapLinesMerged(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.CallParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.CallParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.CallParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
