package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ConferenceParams.java */
/* loaded from: classes3.dex */
class ConferenceParamsImpl implements ConferenceParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native ConferenceParams clone(long j);

    private native Account getAccount(long j);

    private native Address getConferenceFactoryAddress(long j);

    private native String getDescription(long j);

    private native long getEndTime(long j);

    private native int getParticipantListType(long j);

    private native ProxyConfig getProxyCfg(long j);

    private native long getStartTime(long j);

    private native String getSubject(long j);

    private native boolean isAudioEnabled(long j);

    private native boolean isChatEnabled(long j);

    private native boolean isLocalParticipantEnabled(long j);

    private native boolean isOneParticipantConferenceEnabled(long j);

    private native boolean isVideoEnabled(long j);

    private native void setAudioEnabled(long j, boolean z);

    private native void setChatEnabled(long j, boolean z);

    private native void setConferenceFactoryAddress(long j, Address address);

    private native void setDescription(long j, String str);

    private native void setEndTime(long j, long j2);

    private native void setLocalParticipantEnabled(long j, boolean z);

    private native void setOneParticipantConferenceEnabled(long j, boolean z);

    private native void setParticipantListType(long j, int i);

    private native void setStartTime(long j, long j2);

    private native void setSubject(long j, String str);

    private native void setVideoEnabled(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected ConferenceParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ConferenceParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized Account getAccount() {
        return getAccount(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized boolean isAudioEnabled() {
        return isAudioEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
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

    @Override // org.linphone.core.ConferenceParams
    public synchronized boolean isChatEnabled() {
        return isChatEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setChatEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setChatEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setChatEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized Address getConferenceFactoryAddress() {
        return getConferenceFactoryAddress(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setConferenceFactoryAddress(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setConferenceFactoryAddress() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setConferenceFactoryAddress(this.nativePtr, address);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized String getDescription() {
        return getDescription(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setDescription(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDescription() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDescription(this.nativePtr, str);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized long getEndTime() {
        return getEndTime(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setEndTime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEndTime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEndTime(this.nativePtr, j);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized boolean isLocalParticipantEnabled() {
        return isLocalParticipantEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setLocalParticipantEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLocalParticipantEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLocalParticipantEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized boolean isOneParticipantConferenceEnabled() {
        return isOneParticipantConferenceEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setOneParticipantConferenceEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOneParticipantConferenceEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOneParticipantConferenceEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized ConferenceParticipantListType getParticipantListType() {
        return ConferenceParticipantListType.fromInt(getParticipantListType(this.nativePtr));
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setParticipantListType(ConferenceParticipantListType conferenceParticipantListType) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParticipantListType() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setParticipantListType(this.nativePtr, conferenceParticipantListType.toInt());
        }
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized ProxyConfig getProxyCfg() {
        return getProxyCfg(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized long getStartTime() {
        return getStartTime(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized void setStartTime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStartTime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setStartTime(this.nativePtr, j);
    }

    @Override // org.linphone.core.ConferenceParams
    public synchronized String getSubject() {
        return getSubject(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
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

    @Override // org.linphone.core.ConferenceParams
    public synchronized boolean isVideoEnabled() {
        return isVideoEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceParams
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

    @Override // org.linphone.core.ConferenceParams
    public synchronized ConferenceParams clone() {
        return clone(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ConferenceParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ConferenceParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ConferenceParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
