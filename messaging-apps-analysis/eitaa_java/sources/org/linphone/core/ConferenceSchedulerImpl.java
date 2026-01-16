package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ConferenceScheduler.java */
/* loaded from: classes3.dex */
class ConferenceSchedulerImpl implements ConferenceScheduler {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, ConferenceSchedulerListener conferenceSchedulerListener);

    private native void cancelConference(long j, ConferenceInfo conferenceInfo);

    private native Account getAccount(long j);

    private native Core getCore(long j);

    private native ConferenceInfo getInfo(long j);

    private native void removeListener(long j, ConferenceSchedulerListener conferenceSchedulerListener);

    private native void sendInvitations(long j, ChatRoomParams chatRoomParams);

    private native void setAccount(long j, Account account);

    private native void setInfo(long j, ConferenceInfo conferenceInfo);

    private native boolean unref(long j, boolean z);

    protected ConferenceSchedulerImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ConferenceScheduler
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized Account getAccount() {
        return getAccount(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceScheduler
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

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized ConferenceInfo getInfo() {
        return getInfo(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized void setInfo(ConferenceInfo conferenceInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInfo() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setInfo(this.nativePtr, conferenceInfo);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized void cancelConference(ConferenceInfo conferenceInfo) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call cancelConference() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        cancelConference(this.nativePtr, conferenceInfo);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized void sendInvitations(ChatRoomParams chatRoomParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call sendInvitations() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        sendInvitations(this.nativePtr, chatRoomParams);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized void addListener(ConferenceSchedulerListener conferenceSchedulerListener) {
        addListener(this.nativePtr, conferenceSchedulerListener);
    }

    @Override // org.linphone.core.ConferenceScheduler
    public synchronized void removeListener(ConferenceSchedulerListener conferenceSchedulerListener) {
        removeListener(this.nativePtr, conferenceSchedulerListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ConferenceScheduler
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ConferenceScheduler
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ConferenceScheduler
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
