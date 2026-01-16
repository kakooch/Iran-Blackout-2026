package org.linphone.core;

/* compiled from: Participant.java */
/* loaded from: classes3.dex */
class ParticipantImpl implements Participant {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native ParticipantDevice findDevice(long j, Address address);

    private native ParticipantDevice findDevice2(long j, Call call);

    private native Address getAddress(long j);

    private native long getCreationTime(long j);

    private native ParticipantDevice[] getDevices(long j);

    private native int getSecurityLevel(long j);

    private native boolean isAdmin(long j);

    private native boolean isFocus(long j);

    private native boolean unref(long j, boolean z);

    protected ParticipantImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Participant
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Participant
    public synchronized Address getAddress() {
        return getAddress(this.nativePtr);
    }

    @Override // org.linphone.core.Participant
    public synchronized long getCreationTime() {
        return getCreationTime(this.nativePtr);
    }

    @Override // org.linphone.core.Participant
    public synchronized ParticipantDevice[] getDevices() {
        return getDevices(this.nativePtr);
    }

    @Override // org.linphone.core.Participant
    public synchronized boolean isAdmin() {
        return isAdmin(this.nativePtr);
    }

    @Override // org.linphone.core.Participant
    public synchronized boolean isFocus() {
        return isFocus(this.nativePtr);
    }

    @Override // org.linphone.core.Participant
    public synchronized ChatRoomSecurityLevel getSecurityLevel() {
        return ChatRoomSecurityLevel.fromInt(getSecurityLevel(this.nativePtr));
    }

    @Override // org.linphone.core.Participant
    public synchronized ParticipantDevice findDevice(Address address) {
        return findDevice(this.nativePtr, address);
    }

    @Override // org.linphone.core.Participant
    public synchronized ParticipantDevice findDevice(Call call) {
        return findDevice2(this.nativePtr, call);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Participant
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Participant
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Participant
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
