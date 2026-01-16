package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ParticipantDevice.java */
/* loaded from: classes3.dex */
class ParticipantDeviceImpl implements ParticipantDevice {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, ParticipantDeviceListener participantDeviceListener);

    private native Object createNativeVideoWindowId(long j);

    private native Address getAddress(long j);

    private native int getDisconnectionMethod(long j);

    private native String getDisconnectionReason(long j);

    private native boolean getIsMuted(long j);

    private native boolean getIsSpeaking(long j);

    private native int getJoiningMethod(long j);

    private native String getName(long j);

    private native Object getNativeVideoWindowId(long j);

    private native int getSecurityLevel(long j);

    private native int getSsrc(long j, int i);

    private native int getState(long j);

    private native boolean getStreamAvailability(long j, int i);

    private native int getStreamCapability(long j, int i);

    private native long getTimeOfDisconnection(long j);

    private native long getTimeOfJoining(long j);

    private native boolean isInConference(long j);

    private native void removeListener(long j, ParticipantDeviceListener participantDeviceListener);

    private native void setNativeVideoWindowId(long j, Object obj);

    private native boolean unref(long j, boolean z);

    protected ParticipantDeviceImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ParticipantDevice
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized Address getAddress() {
        return getAddress(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized ParticipantDeviceDisconnectionMethod getDisconnectionMethod() {
        return ParticipantDeviceDisconnectionMethod.fromInt(getDisconnectionMethod(this.nativePtr));
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized String getDisconnectionReason() {
        return getDisconnectionReason(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized boolean isInConference() {
        return isInConference(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized boolean getIsMuted() {
        return getIsMuted(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized boolean getIsSpeaking() {
        return getIsSpeaking(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized ParticipantDeviceJoiningMethod getJoiningMethod() {
        return ParticipantDeviceJoiningMethod.fromInt(getJoiningMethod(this.nativePtr));
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized String getName() {
        return getName(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized Object getNativeVideoWindowId() {
        return getNativeVideoWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized void setNativeVideoWindowId(Object obj) {
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

    @Override // org.linphone.core.ParticipantDevice
    public synchronized ChatRoomSecurityLevel getSecurityLevel() {
        return ChatRoomSecurityLevel.fromInt(getSecurityLevel(this.nativePtr));
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized ParticipantDeviceState getState() {
        return ParticipantDeviceState.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized long getTimeOfDisconnection() {
        return getTimeOfDisconnection(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized long getTimeOfJoining() {
        return getTimeOfJoining(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized Object createNativeVideoWindowId() {
        return createNativeVideoWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized int getSsrc(StreamType streamType) {
        return getSsrc(this.nativePtr, streamType.toInt());
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized boolean getStreamAvailability(StreamType streamType) {
        return getStreamAvailability(this.nativePtr, streamType.toInt());
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized MediaDirection getStreamCapability(StreamType streamType) {
        return MediaDirection.fromInt(getStreamCapability(this.nativePtr, streamType.toInt()));
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized void addListener(ParticipantDeviceListener participantDeviceListener) {
        addListener(this.nativePtr, participantDeviceListener);
    }

    @Override // org.linphone.core.ParticipantDevice
    public synchronized void removeListener(ParticipantDeviceListener participantDeviceListener) {
        removeListener(this.nativePtr, participantDeviceListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ParticipantDevice
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ParticipantDevice
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ParticipantDevice
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
