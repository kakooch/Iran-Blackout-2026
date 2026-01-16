package org.linphone.core;

/* compiled from: PushNotificationMessage.java */
/* loaded from: classes3.dex */
class PushNotificationMessageImpl implements PushNotificationMessage {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native boolean isConferenceInvitationCancellation(long j);

    private native boolean isConferenceInvitationNew(long j);

    private native boolean isConferenceInvitationUpdate(long j);

    private native boolean isIcalendar(long j);

    private native boolean unref(long j, boolean z);

    protected PushNotificationMessageImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PushNotificationMessage
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PushNotificationMessage
    public synchronized boolean isConferenceInvitationCancellation() {
        return isConferenceInvitationCancellation(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationMessage
    public synchronized boolean isConferenceInvitationNew() {
        return isConferenceInvitationNew(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationMessage
    public synchronized boolean isConferenceInvitationUpdate() {
        return isConferenceInvitationUpdate(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationMessage
    public synchronized boolean isIcalendar() {
        return isIcalendar(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PushNotificationMessage
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PushNotificationMessage
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PushNotificationMessage
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
