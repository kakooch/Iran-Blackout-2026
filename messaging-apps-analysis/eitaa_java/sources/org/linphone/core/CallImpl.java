package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.mediastream.Log;

/* compiled from: Call.java */
/* loaded from: classes3.dex */
class CallImpl implements Call {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int accept(long j);

    private native int acceptEarlyMedia(long j);

    private native int acceptEarlyMediaWithParams(long j, CallParams callParams);

    private native int acceptUpdate(long j, CallParams callParams);

    private native int acceptWithParams(long j, CallParams callParams);

    private native void addListener(long j, CallListener callListener);

    private native boolean askedToAutoanswer(long j);

    private native void cancelDtmfs(long j);

    private native void confirmGoClear(long j);

    private native Object createNativeVideoWindowId(long j);

    private native int decline(long j, int i);

    private native int declineWithErrorInfo(long j, ErrorInfo errorInfo);

    private native int deferUpdate(long j);

    private native CallStats getAudioStats(long j);

    private native String getAuthenticationToken(long j);

    private native boolean getAuthenticationTokenVerified(long j);

    private native float getAverageQuality(long j);

    private native CallLog getCallLog(long j);

    private native ChatRoom getChatRoom(long j);

    private native Conference getConference(long j);

    private native Core getCore(long j);

    private native CallParams getCurrentParams(long j);

    private native float getCurrentQuality(long j);

    private native int getDir(long j);

    private native Address getDiversionAddress(long j);

    private native int getDuration(long j);

    private native ErrorInfo getErrorInfo(long j);

    private native AudioDevice getInputAudioDevice(long j);

    private native boolean getMicrophoneMuted(long j);

    private native float getMicrophoneVolumeGain(long j);

    private native Object getNativeVideoWindowId(long j);

    private native AudioDevice getOutputAudioDevice(long j);

    private native CallParams getParams(long j);

    private native float getPlayVolume(long j);

    private native Player getPlayer(long j);

    private native int getReason(long j);

    private native float getRecordVolume(long j);

    private native String getReferTo(long j);

    private native Address getRemoteAddress(long j);

    private native String getRemoteAddressAsString(long j);

    private native String getRemoteContact(long j);

    private native CallParams getRemoteParams(long j);

    private native String getRemoteUserAgent(long j);

    private native Call getReplacedCall(long j);

    private native Address getRequestAddress(long j);

    private native boolean getSpeakerMuted(long j);

    private native float getSpeakerVolumeGain(long j);

    private native int getState(long j);

    private native CallStats getStats(long j, int i);

    private native int getStreamCount(long j);

    private native CallStats getTextStats(long j);

    private native Address getToAddress(long j);

    private native String getToHeader(long j, String str);

    private native int getTransferState(long j);

    private native Call getTransferTargetCall(long j);

    private native Call getTransfererCall(long j);

    private native VideoSourceDescriptor getVideoSource(long j);

    private native CallStats getVideoStats(long j);

    private native boolean hasTransferPending(long j);

    private native boolean isCameraEnabled(long j);

    private native boolean isEchoCancellationEnabled(long j);

    private native boolean isEchoLimiterEnabled(long j);

    private native boolean isRecording(long j);

    private native boolean mediaInProgress(long j);

    private native void notifyRinging(long j);

    private native void oglRender(long j);

    private native int pause(long j);

    private native int redirect(long j, String str);

    private native int redirectTo(long j, Address address);

    private native void removeListener(long j, CallListener callListener);

    private native void requestNotifyNextVideoFrameDecoded(long j);

    private native int resume(long j);

    private native int sendDtmf(long j, char c);

    private native int sendDtmfs(long j, String str);

    private native int sendInfoMessage(long j, InfoMessage infoMessage);

    private native void sendVfuRequest(long j);

    private native void setAuthenticationTokenVerified(long j, boolean z);

    private native void setCameraEnabled(long j, boolean z);

    private native void setEchoCancellationEnabled(long j, boolean z);

    private native void setEchoLimiterEnabled(long j, boolean z);

    private native void setInputAudioDevice(long j, AudioDevice audioDevice);

    private native void setMicrophoneMuted(long j, boolean z);

    private native void setMicrophoneVolumeGain(long j, float f);

    private native void setNativeVideoWindowId(long j, Object obj);

    private native void setOutputAudioDevice(long j, AudioDevice audioDevice);

    private native void setParams(long j, CallParams callParams);

    private native void setSpeakerMuted(long j, boolean z);

    private native void setSpeakerVolumeGain(long j, float f);

    private native void setVideoSource(long j, VideoSourceDescriptor videoSourceDescriptor);

    private native void startRecording(long j);

    private native void stopRecording(long j);

    private native int takePreviewSnapshot(long j, String str);

    private native int takeVideoSnapshot(long j, String str);

    private native int terminate(long j);

    private native int terminateWithErrorInfo(long j, ErrorInfo errorInfo);

    private native int transfer(long j, String str);

    private native int transferTo(long j, Address address);

    private native int transferToAnother(long j, Call call);

    private native boolean unref(long j, boolean z);

    private native int update(long j, CallParams callParams);

    private native void zoom(long j, float f, float f2, float f3);

    protected CallImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.Call
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Call
    public synchronized CallStats getAudioStats() {
        CallStats audioStats;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getAudioStats() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            audioStats = getAudioStats(this.nativePtr);
        }
        return audioStats;
    }

    @Override // org.linphone.core.Call
    public synchronized String getAuthenticationToken() {
        String authenticationToken;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getAuthenticationToken() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            authenticationToken = getAuthenticationToken(this.nativePtr);
        }
        return authenticationToken;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean getAuthenticationTokenVerified() {
        boolean authenticationTokenVerified;
        synchronized (this.core) {
            authenticationTokenVerified = getAuthenticationTokenVerified(this.nativePtr);
        }
        return authenticationTokenVerified;
    }

    @Override // org.linphone.core.Call
    public synchronized void setAuthenticationTokenVerified(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setAuthenticationTokenVerified() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setAuthenticationTokenVerified(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized float getAverageQuality() {
        float averageQuality;
        synchronized (this.core) {
            averageQuality = getAverageQuality(this.nativePtr);
        }
        return averageQuality;
    }

    @Override // org.linphone.core.Call
    public synchronized CallLog getCallLog() {
        CallLog callLog;
        synchronized (this.core) {
            callLog = getCallLog(this.nativePtr);
        }
        return callLog;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean isCameraEnabled() {
        boolean zIsCameraEnabled;
        synchronized (this.core) {
            zIsCameraEnabled = isCameraEnabled(this.nativePtr);
        }
        return zIsCameraEnabled;
    }

    @Override // org.linphone.core.Call
    public synchronized void setCameraEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setCameraEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setCameraEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized ChatRoom getChatRoom() {
        ChatRoom chatRoom;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getChatRoom() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatRoom = getChatRoom(this.nativePtr);
        }
        return chatRoom;
    }

    @Override // org.linphone.core.Call
    public synchronized Conference getConference() {
        Conference conference;
        synchronized (this.core) {
            conference = getConference(this.nativePtr);
        }
        return conference;
    }

    @Override // org.linphone.core.Call
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Call
    public synchronized CallParams getCurrentParams() {
        CallParams currentParams;
        synchronized (this.core) {
            currentParams = getCurrentParams(this.nativePtr);
        }
        return currentParams;
    }

    @Override // org.linphone.core.Call
    public synchronized float getCurrentQuality() {
        float currentQuality;
        synchronized (this.core) {
            currentQuality = getCurrentQuality(this.nativePtr);
        }
        return currentQuality;
    }

    @Override // org.linphone.core.Call
    public synchronized Call.Dir getDir() {
        Call.Dir dirFromInt;
        synchronized (this.core) {
            dirFromInt = Call.Dir.fromInt(getDir(this.nativePtr));
        }
        return dirFromInt;
    }

    @Override // org.linphone.core.Call
    public synchronized Address getDiversionAddress() {
        Address diversionAddress;
        synchronized (this.core) {
            diversionAddress = getDiversionAddress(this.nativePtr);
        }
        return diversionAddress;
    }

    @Override // org.linphone.core.Call
    public synchronized int getDuration() {
        int duration;
        synchronized (this.core) {
            duration = getDuration(this.nativePtr);
        }
        return duration;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean isEchoCancellationEnabled() {
        boolean zIsEchoCancellationEnabled;
        synchronized (this.core) {
            zIsEchoCancellationEnabled = isEchoCancellationEnabled(this.nativePtr);
        }
        return zIsEchoCancellationEnabled;
    }

    @Override // org.linphone.core.Call
    public synchronized void setEchoCancellationEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setEchoCancellationEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setEchoCancellationEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized boolean isEchoLimiterEnabled() {
        boolean zIsEchoLimiterEnabled;
        synchronized (this.core) {
            zIsEchoLimiterEnabled = isEchoLimiterEnabled(this.nativePtr);
        }
        return zIsEchoLimiterEnabled;
    }

    @Override // org.linphone.core.Call
    public synchronized void setEchoLimiterEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setEchoLimiterEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setEchoLimiterEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized ErrorInfo getErrorInfo() {
        ErrorInfo errorInfo;
        synchronized (this.core) {
            errorInfo = getErrorInfo(this.nativePtr);
        }
        return errorInfo;
    }

    @Override // org.linphone.core.Call
    public synchronized AudioDevice getInputAudioDevice() {
        AudioDevice inputAudioDevice;
        synchronized (this.core) {
            inputAudioDevice = getInputAudioDevice(this.nativePtr);
        }
        return inputAudioDevice;
    }

    @Override // org.linphone.core.Call
    public synchronized void setInputAudioDevice(AudioDevice audioDevice) {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.Call
    public synchronized boolean isRecording() {
        boolean zIsRecording;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isRecording() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsRecording = isRecording(this.nativePtr);
        }
        return zIsRecording;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean getMicrophoneMuted() {
        boolean microphoneMuted;
        synchronized (this.core) {
            microphoneMuted = getMicrophoneMuted(this.nativePtr);
        }
        return microphoneMuted;
    }

    @Override // org.linphone.core.Call
    public synchronized void setMicrophoneMuted(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setMicrophoneMuted() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setMicrophoneMuted(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized float getMicrophoneVolumeGain() {
        float microphoneVolumeGain;
        synchronized (this.core) {
            microphoneVolumeGain = getMicrophoneVolumeGain(this.nativePtr);
        }
        return microphoneVolumeGain;
    }

    @Override // org.linphone.core.Call
    public synchronized void setMicrophoneVolumeGain(float f) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setMicrophoneVolumeGain() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setMicrophoneVolumeGain(this.nativePtr, f);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized Object getNativeVideoWindowId() {
        Object nativeVideoWindowId;
        synchronized (this.core) {
            nativeVideoWindowId = getNativeVideoWindowId(this.nativePtr);
        }
        return nativeVideoWindowId;
    }

    @Override // org.linphone.core.Call
    public synchronized void setNativeVideoWindowId(Object obj) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setNativeVideoWindowId() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setNativeVideoWindowId(this.nativePtr, obj);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized AudioDevice getOutputAudioDevice() {
        AudioDevice outputAudioDevice;
        synchronized (this.core) {
            outputAudioDevice = getOutputAudioDevice(this.nativePtr);
        }
        return outputAudioDevice;
    }

    @Override // org.linphone.core.Call
    public synchronized void setOutputAudioDevice(AudioDevice audioDevice) {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.Call
    public synchronized CallParams getParams() {
        CallParams params;
        synchronized (this.core) {
            params = getParams(this.nativePtr);
        }
        return params;
    }

    @Override // org.linphone.core.Call
    public synchronized void setParams(CallParams callParams) {
        synchronized (this.core) {
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
            setParams(this.nativePtr, callParams);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized float getPlayVolume() {
        float playVolume;
        synchronized (this.core) {
            playVolume = getPlayVolume(this.nativePtr);
        }
        return playVolume;
    }

    @Override // org.linphone.core.Call
    public synchronized Player getPlayer() {
        Player player;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getPlayer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            player = getPlayer(this.nativePtr);
        }
        return player;
    }

    @Override // org.linphone.core.Call
    public synchronized Reason getReason() {
        Reason reasonFromInt;
        synchronized (this.core) {
            reasonFromInt = Reason.fromInt(getReason(this.nativePtr));
        }
        return reasonFromInt;
    }

    @Override // org.linphone.core.Call
    public synchronized float getRecordVolume() {
        float recordVolume;
        synchronized (this.core) {
            recordVolume = getRecordVolume(this.nativePtr);
        }
        return recordVolume;
    }

    @Override // org.linphone.core.Call
    public synchronized String getReferTo() {
        String referTo;
        synchronized (this.core) {
            referTo = getReferTo(this.nativePtr);
        }
        return referTo;
    }

    @Override // org.linphone.core.Call
    public synchronized Address getRemoteAddress() {
        Address remoteAddress;
        synchronized (this.core) {
            remoteAddress = getRemoteAddress(this.nativePtr);
        }
        return remoteAddress;
    }

    @Override // org.linphone.core.Call
    public synchronized String getRemoteAddressAsString() {
        String remoteAddressAsString;
        synchronized (this.core) {
            remoteAddressAsString = getRemoteAddressAsString(this.nativePtr);
        }
        return remoteAddressAsString;
    }

    @Override // org.linphone.core.Call
    public synchronized String getRemoteContact() {
        String remoteContact;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getRemoteContact() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            remoteContact = getRemoteContact(this.nativePtr);
        }
        return remoteContact;
    }

    @Override // org.linphone.core.Call
    public synchronized CallParams getRemoteParams() {
        CallParams remoteParams;
        synchronized (this.core) {
            remoteParams = getRemoteParams(this.nativePtr);
        }
        return remoteParams;
    }

    @Override // org.linphone.core.Call
    public synchronized String getRemoteUserAgent() {
        String remoteUserAgent;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getRemoteUserAgent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            remoteUserAgent = getRemoteUserAgent(this.nativePtr);
        }
        return remoteUserAgent;
    }

    @Override // org.linphone.core.Call
    public synchronized Call getReplacedCall() {
        Call replacedCall;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getReplacedCall() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            replacedCall = getReplacedCall(this.nativePtr);
        }
        return replacedCall;
    }

    @Override // org.linphone.core.Call
    public synchronized Address getRequestAddress() {
        Address requestAddress;
        synchronized (this.core) {
            requestAddress = getRequestAddress(this.nativePtr);
        }
        return requestAddress;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean getSpeakerMuted() {
        boolean speakerMuted;
        synchronized (this.core) {
            speakerMuted = getSpeakerMuted(this.nativePtr);
        }
        return speakerMuted;
    }

    @Override // org.linphone.core.Call
    public synchronized void setSpeakerMuted(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSpeakerMuted() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setSpeakerMuted(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized float getSpeakerVolumeGain() {
        float speakerVolumeGain;
        synchronized (this.core) {
            speakerVolumeGain = getSpeakerVolumeGain(this.nativePtr);
        }
        return speakerVolumeGain;
    }

    @Override // org.linphone.core.Call
    public synchronized void setSpeakerVolumeGain(float f) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSpeakerVolumeGain() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setSpeakerVolumeGain(this.nativePtr, f);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized Call.State getState() {
        Call.State stateFromInt;
        synchronized (this.core) {
            stateFromInt = Call.State.fromInt(getState(this.nativePtr));
        }
        return stateFromInt;
    }

    @Override // org.linphone.core.Call
    public synchronized int getStreamCount() {
        int streamCount;
        synchronized (this.core) {
            streamCount = getStreamCount(this.nativePtr);
        }
        return streamCount;
    }

    @Override // org.linphone.core.Call
    public synchronized CallStats getTextStats() {
        CallStats textStats;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getTextStats() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            textStats = getTextStats(this.nativePtr);
        }
        return textStats;
    }

    @Override // org.linphone.core.Call
    public synchronized Address getToAddress() {
        Address toAddress;
        synchronized (this.core) {
            toAddress = getToAddress(this.nativePtr);
        }
        return toAddress;
    }

    @Override // org.linphone.core.Call
    public synchronized Call.State getTransferState() {
        Call.State stateFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getTransferState() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            stateFromInt = Call.State.fromInt(getTransferState(this.nativePtr));
        }
        return stateFromInt;
    }

    @Override // org.linphone.core.Call
    public synchronized Call getTransferTargetCall() {
        Call transferTargetCall;
        synchronized (this.core) {
            transferTargetCall = getTransferTargetCall(this.nativePtr);
        }
        return transferTargetCall;
    }

    @Override // org.linphone.core.Call
    public synchronized Call getTransfererCall() {
        Call transfererCall;
        synchronized (this.core) {
            transfererCall = getTransfererCall(this.nativePtr);
        }
        return transfererCall;
    }

    @Override // org.linphone.core.Call
    public synchronized VideoSourceDescriptor getVideoSource() {
        VideoSourceDescriptor videoSource;
        synchronized (this.core) {
            videoSource = getVideoSource(this.nativePtr);
        }
        return videoSource;
    }

    @Override // org.linphone.core.Call
    public synchronized void setVideoSource(VideoSourceDescriptor videoSourceDescriptor) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setVideoSource() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setVideoSource(this.nativePtr, videoSourceDescriptor);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized CallStats getVideoStats() {
        CallStats videoStats;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getVideoStats() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            videoStats = getVideoStats(this.nativePtr);
        }
        return videoStats;
    }

    @Override // org.linphone.core.Call
    public synchronized int accept() {
        int iAccept;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call accept() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAccept = accept(this.nativePtr);
        }
        return iAccept;
    }

    @Override // org.linphone.core.Call
    public synchronized int acceptEarlyMedia() {
        int iAcceptEarlyMedia;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call acceptEarlyMedia() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAcceptEarlyMedia = acceptEarlyMedia(this.nativePtr);
        }
        return iAcceptEarlyMedia;
    }

    @Override // org.linphone.core.Call
    public synchronized int acceptEarlyMediaWithParams(CallParams callParams) {
        int iAcceptEarlyMediaWithParams;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call acceptEarlyMediaWithParams() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAcceptEarlyMediaWithParams = acceptEarlyMediaWithParams(this.nativePtr, callParams);
        }
        return iAcceptEarlyMediaWithParams;
    }

    @Override // org.linphone.core.Call
    public synchronized int acceptUpdate(CallParams callParams) {
        int iAcceptUpdate;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call acceptUpdate() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAcceptUpdate = acceptUpdate(this.nativePtr, callParams);
        }
        return iAcceptUpdate;
    }

    @Override // org.linphone.core.Call
    public synchronized int acceptWithParams(CallParams callParams) {
        int iAcceptWithParams;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call acceptWithParams() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iAcceptWithParams = acceptWithParams(this.nativePtr, callParams);
        }
        return iAcceptWithParams;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean askedToAutoanswer() {
        boolean zAskedToAutoanswer;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call askedToAutoanswer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zAskedToAutoanswer = askedToAutoanswer(this.nativePtr);
        }
        return zAskedToAutoanswer;
    }

    @Override // org.linphone.core.Call
    public synchronized void cancelDtmfs() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call cancelDtmfs() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            cancelDtmfs(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized void confirmGoClear() {
        synchronized (this.core) {
            confirmGoClear(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized Object createNativeVideoWindowId() {
        Object objCreateNativeVideoWindowId;
        synchronized (this.core) {
            objCreateNativeVideoWindowId = createNativeVideoWindowId(this.nativePtr);
        }
        return objCreateNativeVideoWindowId;
    }

    @Override // org.linphone.core.Call
    public synchronized int decline(Reason reason) {
        int iDecline;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call decline() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iDecline = decline(this.nativePtr, reason.toInt());
        }
        return iDecline;
    }

    @Override // org.linphone.core.Call
    public synchronized int declineWithErrorInfo(ErrorInfo errorInfo) {
        int iDeclineWithErrorInfo;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call declineWithErrorInfo() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iDeclineWithErrorInfo = declineWithErrorInfo(this.nativePtr, errorInfo);
        }
        return iDeclineWithErrorInfo;
    }

    @Override // org.linphone.core.Call
    public synchronized int deferUpdate() {
        int iDeferUpdate;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call deferUpdate() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iDeferUpdate = deferUpdate(this.nativePtr);
        }
        return iDeferUpdate;
    }

    @Override // org.linphone.core.Call
    public synchronized CallStats getStats(StreamType streamType) {
        CallStats stats;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getStats() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            stats = getStats(this.nativePtr, streamType.toInt());
        }
        return stats;
    }

    @Override // org.linphone.core.Call
    public synchronized String getToHeader(String str) {
        String toHeader;
        synchronized (this.core) {
            toHeader = getToHeader(this.nativePtr, str);
        }
        return toHeader;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean hasTransferPending() {
        boolean zHasTransferPending;
        synchronized (this.core) {
            zHasTransferPending = hasTransferPending(this.nativePtr);
        }
        return zHasTransferPending;
    }

    @Override // org.linphone.core.Call
    public synchronized boolean mediaInProgress() {
        boolean zMediaInProgress;
        synchronized (this.core) {
            zMediaInProgress = mediaInProgress(this.nativePtr);
        }
        return zMediaInProgress;
    }

    @Override // org.linphone.core.Call
    public synchronized void notifyRinging() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call notifyRinging() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            notifyRinging(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized void oglRender() {
        synchronized (this.core) {
            oglRender(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized int pause() {
        int iPause;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call pause() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iPause = pause(this.nativePtr);
        }
        return iPause;
    }

    @Override // org.linphone.core.Call
    public synchronized int redirect(String str) {
        int iRedirect;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call redirect() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iRedirect = redirect(this.nativePtr, str);
        }
        return iRedirect;
    }

    @Override // org.linphone.core.Call
    public synchronized int redirectTo(Address address) {
        int iRedirectTo;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call redirectTo() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iRedirectTo = redirectTo(this.nativePtr, address);
        }
        return iRedirectTo;
    }

    @Override // org.linphone.core.Call
    public synchronized void requestNotifyNextVideoFrameDecoded() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call requestNotifyNextVideoFrameDecoded() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            requestNotifyNextVideoFrameDecoded(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized int resume() {
        int iResume;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call resume() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iResume = resume(this.nativePtr);
        }
        return iResume;
    }

    @Override // org.linphone.core.Call
    public synchronized int sendDtmf(char c) {
        int iSendDtmf;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendDtmf() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSendDtmf = sendDtmf(this.nativePtr, c);
        }
        return iSendDtmf;
    }

    @Override // org.linphone.core.Call
    public synchronized int sendDtmfs(String str) {
        int iSendDtmfs;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendDtmfs() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSendDtmfs = sendDtmfs(this.nativePtr, str);
        }
        return iSendDtmfs;
    }

    @Override // org.linphone.core.Call
    public synchronized int sendInfoMessage(InfoMessage infoMessage) {
        int iSendInfoMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendInfoMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSendInfoMessage = sendInfoMessage(this.nativePtr, infoMessage);
        }
        return iSendInfoMessage;
    }

    @Override // org.linphone.core.Call
    public synchronized void sendVfuRequest() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call sendVfuRequest() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            sendVfuRequest(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized void startRecording() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call startRecording() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            startRecording(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized void stopRecording() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call stopRecording() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            stopRecording(this.nativePtr);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized int takePreviewSnapshot(String str) {
        int iTakePreviewSnapshot;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call takePreviewSnapshot() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTakePreviewSnapshot = takePreviewSnapshot(this.nativePtr, str);
        }
        return iTakePreviewSnapshot;
    }

    @Override // org.linphone.core.Call
    public synchronized int takeVideoSnapshot(String str) {
        int iTakeVideoSnapshot;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call takeVideoSnapshot() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTakeVideoSnapshot = takeVideoSnapshot(this.nativePtr, str);
        }
        return iTakeVideoSnapshot;
    }

    @Override // org.linphone.core.Call
    public synchronized int terminate() {
        int iTerminate;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call terminate() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTerminate = terminate(this.nativePtr);
        }
        return iTerminate;
    }

    @Override // org.linphone.core.Call
    public synchronized int terminateWithErrorInfo(ErrorInfo errorInfo) {
        int iTerminateWithErrorInfo;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call terminateWithErrorInfo() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTerminateWithErrorInfo = terminateWithErrorInfo(this.nativePtr, errorInfo);
        }
        return iTerminateWithErrorInfo;
    }

    @Override // org.linphone.core.Call
    public synchronized int transfer(String str) {
        int iTransfer;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call transfer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTransfer = transfer(this.nativePtr, str);
        }
        return iTransfer;
    }

    @Override // org.linphone.core.Call
    public synchronized int transferTo(Address address) {
        int iTransferTo;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call transferTo() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTransferTo = transferTo(this.nativePtr, address);
        }
        return iTransferTo;
    }

    @Override // org.linphone.core.Call
    public synchronized int transferToAnother(Call call) {
        int iTransferToAnother;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call transferToAnother() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iTransferToAnother = transferToAnother(this.nativePtr, call);
        }
        return iTransferToAnother;
    }

    @Override // org.linphone.core.Call
    public synchronized int update(CallParams callParams) {
        int iUpdate;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call update() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iUpdate = update(this.nativePtr, callParams);
        }
        return iUpdate;
    }

    @Override // org.linphone.core.Call
    public synchronized void zoom(float f, float f2, float f3) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call zoom() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zoom(this.nativePtr, f, f2, f3);
        }
    }

    @Override // org.linphone.core.Call
    public synchronized void addListener(CallListener callListener) {
        addListener(this.nativePtr, callListener);
    }

    @Override // org.linphone.core.Call
    public synchronized void removeListener(CallListener callListener) {
        removeListener(this.nativePtr, callListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Call
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Call
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Call
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
