package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: PresenceService.java */
/* loaded from: classes3.dex */
class PresenceServiceImpl implements PresenceService {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int addNote(long j, PresenceNote presenceNote);

    private native int clearNotes(long j);

    private native int getBasicStatus(long j);

    private native String getContact(long j);

    private native String getId(long j);

    private native int getNbNotes(long j);

    private native PresenceNote getNthNote(long j, int i);

    private native String[] getServiceDescriptions(long j);

    private native int setBasicStatus(long j, int i);

    private native int setContact(long j, String str);

    private native int setId(long j, String str);

    private native int setServiceDescriptions(long j, String[] strArr);

    private native boolean unref(long j, boolean z);

    protected PresenceServiceImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PresenceService
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PresenceService
    public synchronized PresenceBasicStatus getBasicStatus() {
        return PresenceBasicStatus.fromInt(getBasicStatus(this.nativePtr));
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int setBasicStatus(PresenceBasicStatus presenceBasicStatus) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBasicStatus() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setBasicStatus(this.nativePtr, presenceBasicStatus.toInt());
    }

    @Override // org.linphone.core.PresenceService
    public synchronized String getContact() {
        return getContact(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int setContact(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setContact() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setContact(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized String getId() {
        return getId(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int setId(String str) {
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
        return setId(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int getNbNotes() {
        return getNbNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized String[] getServiceDescriptions() {
        return getServiceDescriptions(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int setServiceDescriptions(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setServiceDescriptions() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setServiceDescriptions(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int addNote(PresenceNote presenceNote) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addNote(this.nativePtr, presenceNote);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized int clearNotes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearNotes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceService
    public synchronized PresenceNote getNthNote(int i) {
        return getNthNote(this.nativePtr, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PresenceService
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PresenceService
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PresenceService
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
