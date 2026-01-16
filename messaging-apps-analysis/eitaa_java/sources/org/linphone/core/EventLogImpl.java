package org.linphone.core;

import org.linphone.core.EventLog;
import org.linphone.mediastream.Log;

/* compiled from: EventLog.java */
/* loaded from: classes3.dex */
class EventLogImpl implements EventLog {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void deleteFromDatabase(long j);

    private native CallLog getCallLog(long j);

    private native ChatMessage getChatMessage(long j);

    private native ConferenceInfo getConferenceInfo(long j);

    private native long getCreationTime(long j);

    private native Address getDeviceAddress(long j);

    private native long getEphemeralMessageLifetime(long j);

    private native Address getLocalAddress(long j);

    private native int getNotifyId(long j);

    private native Address getParticipantAddress(long j);

    private native Address getPeerAddress(long j);

    private native Address getSecurityEventFaultyDeviceAddress(long j);

    private native int getSecurityEventType(long j);

    private native String getSubject(long j);

    private native int getType(long j);

    private native boolean unref(long j, boolean z);

    protected EventLogImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.EventLog
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.EventLog
    public synchronized CallLog getCallLog() {
        return getCallLog(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized ChatMessage getChatMessage() {
        return getChatMessage(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized ConferenceInfo getConferenceInfo() {
        return getConferenceInfo(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized long getCreationTime() {
        return getCreationTime(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized Address getDeviceAddress() {
        return getDeviceAddress(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized long getEphemeralMessageLifetime() {
        return getEphemeralMessageLifetime(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized Address getLocalAddress() {
        return getLocalAddress(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized int getNotifyId() {
        return getNotifyId(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized Address getParticipantAddress() {
        return getParticipantAddress(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized Address getPeerAddress() {
        return getPeerAddress(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized Address getSecurityEventFaultyDeviceAddress() {
        return getSecurityEventFaultyDeviceAddress(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized EventLog.SecurityEventType getSecurityEventType() {
        return EventLog.SecurityEventType.fromInt(getSecurityEventType(this.nativePtr));
    }

    @Override // org.linphone.core.EventLog
    public synchronized String getSubject() {
        return getSubject(this.nativePtr);
    }

    @Override // org.linphone.core.EventLog
    public synchronized EventLog.Type getType() {
        return EventLog.Type.fromInt(getType(this.nativePtr));
    }

    @Override // org.linphone.core.EventLog
    public synchronized void deleteFromDatabase() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call deleteFromDatabase() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        deleteFromDatabase(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.EventLog
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.EventLog
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.EventLog
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
