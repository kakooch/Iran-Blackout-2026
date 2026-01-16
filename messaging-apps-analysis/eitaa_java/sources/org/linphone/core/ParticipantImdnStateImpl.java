package org.linphone.core;

import org.linphone.core.ChatMessage;

/* compiled from: ParticipantImdnState.java */
/* loaded from: classes3.dex */
class ParticipantImdnStateImpl implements ParticipantImdnState {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native Participant getParticipant(long j);

    private native int getState(long j);

    private native long getStateChangeTime(long j);

    private native boolean unref(long j, boolean z);

    protected ParticipantImdnStateImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ParticipantImdnState
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ParticipantImdnState
    public synchronized Participant getParticipant() {
        return getParticipant(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantImdnState
    public synchronized ChatMessage.State getState() {
        return ChatMessage.State.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.ParticipantImdnState
    public synchronized long getStateChangeTime() {
        return getStateChangeTime(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ParticipantImdnState
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ParticipantImdnState
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ParticipantImdnState
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
