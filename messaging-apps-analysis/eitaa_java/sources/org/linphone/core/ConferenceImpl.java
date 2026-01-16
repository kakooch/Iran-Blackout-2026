package org.linphone.core;

import org.linphone.core.Conference;
import org.linphone.mediastream.Log;

/* compiled from: Conference.java */
/* loaded from: classes3.dex */
class ConferenceImpl implements Conference {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, ConferenceListener conferenceListener);

    private native int addParticipant(long j, Call call);

    private native int addParticipant2(long j, Address address);

    private native int addParticipants(long j, Call[] callArr);

    private native int addParticipants2(long j, Address[] addressArr);

    private native int enter(long j);

    private native Participant findParticipant(long j, Address address);

    private native ParticipantDevice getActiveSpeakerParticipantDevice(long j);

    private native Call getCall(long j);

    private native Address getConferenceAddress(long j);

    private native Core getCore(long j);

    private native ConferenceParams getCurrentParams(long j);

    private native int getDuration(long j);

    private native String getId(long j);

    private native AudioDevice getInputAudioDevice(long j);

    private native Participant getMe(long j);

    private native AudioDevice getOutputAudioDevice(long j);

    private native int getParticipantCount(long j);

    private native ParticipantDevice[] getParticipantDeviceList(long j);

    private native int getParticipantDeviceVolume(long j, ParticipantDevice participantDevice);

    private native Participant[] getParticipantList(long j);

    private native Address[] getParticipants(long j);

    private native long getStartTime(long j);

    private native int getState(long j);

    private native String getSubject(long j);

    private native String getUsername(long j);

    private native int inviteParticipants(long j, Address[] addressArr, CallParams callParams);

    private native boolean isIn(long j);

    private native boolean isMe(long j, Address address);

    private native boolean isRecording(long j);

    private native int leave(long j);

    private native void removeListener(long j, ConferenceListener conferenceListener);

    private native int removeParticipant(long j, Address address);

    private native int removeParticipant2(long j, Participant participant);

    private native int removeParticipant3(long j, Call call);

    private native void setConferenceAddress(long j, Address address);

    private native void setId(long j, String str);

    private native void setInputAudioDevice(long j, AudioDevice audioDevice);

    private native void setLocalParticipantStreamCapability(long j, int i, int i2);

    private native void setOutputAudioDevice(long j, AudioDevice audioDevice);

    private native void setParticipantAdminStatus(long j, Participant participant, boolean z);

    private native void setSubject(long j, String str);

    private native void setUsername(long j, String str);

    private native int startRecording(long j, String str);

    private native int stopRecording(long j);

    private native int terminate(long j);

    private native boolean unref(long j, boolean z);

    private native int updateParams(long j, ConferenceParams conferenceParams);

    protected ConferenceImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Conference
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Conference
    public synchronized ParticipantDevice getActiveSpeakerParticipantDevice() {
        return getActiveSpeakerParticipantDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Call getCall() {
        return getCall(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Address getConferenceAddress() {
        return getConferenceAddress(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized void setConferenceAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setConferenceAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.Conference
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized ConferenceParams getCurrentParams() {
        return getCurrentParams(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized String getId() {
        return getId(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized void setId(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setId(this.nativePtr, str);
    }

    @Override // org.linphone.core.Conference
    public synchronized AudioDevice getInputAudioDevice() {
        return getInputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
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

    @Override // org.linphone.core.Conference
    public synchronized boolean isIn() {
        return isIn(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized boolean isRecording() {
        return isRecording(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Participant getMe() {
        return getMe(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized AudioDevice getOutputAudioDevice() {
        return getOutputAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
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

    @Override // org.linphone.core.Conference
    public synchronized int getParticipantCount() {
        return getParticipantCount(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized ParticipantDevice[] getParticipantDeviceList() {
        return getParticipantDeviceList(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Participant[] getParticipantList() {
        return getParticipantList(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Address[] getParticipants() {
        return getParticipants(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized long getStartTime() {
        return getStartTime(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Conference.State getState() {
        return Conference.State.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.Conference
    public synchronized String getSubject() {
        return getSubject(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized void setSubject(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSubject() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSubject(this.nativePtr, str);
    }

    @Override // org.linphone.core.Conference
    public synchronized String getUsername() {
        return getUsername(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
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

    @Override // org.linphone.core.Conference
    public synchronized int addParticipant(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addParticipant2(this.nativePtr, address);
    }

    @Override // org.linphone.core.Conference
    public synchronized int addParticipant(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addParticipant(this.nativePtr, call);
    }

    @Override // org.linphone.core.Conference
    public synchronized int addParticipants(Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addParticipants() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addParticipants2(this.nativePtr, addressArr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int addParticipants(Call[] callArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addParticipants() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addParticipants(this.nativePtr, callArr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int enter() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return enter(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized Participant findParticipant(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call findParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return findParticipant(this.nativePtr, address);
    }

    @Override // org.linphone.core.Conference
    public synchronized int getParticipantDeviceVolume(ParticipantDevice participantDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getParticipantDeviceVolume() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getParticipantDeviceVolume(this.nativePtr, participantDevice);
    }

    @Override // org.linphone.core.Conference
    public synchronized int inviteParticipants(Address[] addressArr, CallParams callParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call inviteParticipants() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return inviteParticipants(this.nativePtr, addressArr, callParams);
    }

    @Override // org.linphone.core.Conference
    public synchronized boolean isMe(Address address) {
        return isMe(this.nativePtr, address);
    }

    @Override // org.linphone.core.Conference
    public synchronized int leave() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call leave() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return leave(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int removeParticipant(Participant participant) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return removeParticipant2(this.nativePtr, participant);
    }

    @Override // org.linphone.core.Conference
    public synchronized int removeParticipant(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return removeParticipant3(this.nativePtr, call);
    }

    @Override // org.linphone.core.Conference
    public synchronized int removeParticipant(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call removeParticipant() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return removeParticipant(this.nativePtr, address);
    }

    @Override // org.linphone.core.Conference
    public synchronized void setLocalParticipantStreamCapability(MediaDirection mediaDirection, StreamType streamType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLocalParticipantStreamCapability() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setLocalParticipantStreamCapability(this.nativePtr, mediaDirection.toInt(), streamType.toInt());
        }
    }

    @Override // org.linphone.core.Conference
    public synchronized void setParticipantAdminStatus(Participant participant, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParticipantAdminStatus() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParticipantAdminStatus(this.nativePtr, participant, z);
    }

    @Override // org.linphone.core.Conference
    public synchronized int startRecording(String str) {
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
        return startRecording(this.nativePtr, str);
    }

    @Override // org.linphone.core.Conference
    public synchronized int stopRecording() {
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
        return stopRecording(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int terminate() {
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
        return terminate(this.nativePtr);
    }

    @Override // org.linphone.core.Conference
    public synchronized int updateParams(ConferenceParams conferenceParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call updateParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return updateParams(this.nativePtr, conferenceParams);
    }

    @Override // org.linphone.core.Conference
    public synchronized void addListener(ConferenceListener conferenceListener) {
        addListener(this.nativePtr, conferenceListener);
    }

    @Override // org.linphone.core.Conference
    public synchronized void removeListener(ConferenceListener conferenceListener) {
        removeListener(this.nativePtr, conferenceListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Conference
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Conference
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Conference
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
