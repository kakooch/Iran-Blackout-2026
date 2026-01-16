package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: PresencePerson.java */
/* loaded from: classes3.dex */
class PresencePersonImpl implements PresencePerson {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int addActivitiesNote(long j, PresenceNote presenceNote);

    private native int addActivity(long j, PresenceActivity presenceActivity);

    private native int addNote(long j, PresenceNote presenceNote);

    private native int clearActivities(long j);

    private native int clearActivitiesNotes(long j);

    private native int clearNotes(long j);

    private native String getId(long j);

    private native int getNbActivities(long j);

    private native int getNbActivitiesNotes(long j);

    private native int getNbNotes(long j);

    private native PresenceNote getNthActivitiesNote(long j, int i);

    private native PresenceActivity getNthActivity(long j, int i);

    private native PresenceNote getNthNote(long j, int i);

    private native int setId(long j, String str);

    private native boolean unref(long j, boolean z);

    protected PresencePersonImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PresencePerson
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized String getId() {
        return getId(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
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

    @Override // org.linphone.core.PresencePerson
    public synchronized int getNbActivities() {
        return getNbActivities(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized int getNbActivitiesNotes() {
        return getNbActivitiesNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized int getNbNotes() {
        return getNbNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized int addActivitiesNote(PresenceNote presenceNote) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addActivitiesNote() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addActivitiesNote(this.nativePtr, presenceNote);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized int addActivity(PresenceActivity presenceActivity) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addActivity() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return addActivity(this.nativePtr, presenceActivity);
    }

    @Override // org.linphone.core.PresencePerson
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

    @Override // org.linphone.core.PresencePerson
    public synchronized int clearActivities() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearActivities() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearActivities(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized int clearActivitiesNotes() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clearActivitiesNotes() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return clearActivitiesNotes(this.nativePtr);
    }

    @Override // org.linphone.core.PresencePerson
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

    @Override // org.linphone.core.PresencePerson
    public synchronized PresenceNote getNthActivitiesNote(int i) {
        return getNthActivitiesNote(this.nativePtr, i);
    }

    @Override // org.linphone.core.PresencePerson
    public synchronized PresenceActivity getNthActivity(int i) {
        return getNthActivity(this.nativePtr, i);
    }

    @Override // org.linphone.core.PresencePerson
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

    @Override // org.linphone.core.PresencePerson
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PresencePerson
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PresencePerson
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
