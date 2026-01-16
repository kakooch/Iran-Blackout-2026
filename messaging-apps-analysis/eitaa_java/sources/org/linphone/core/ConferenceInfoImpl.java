package org.linphone.core;

import org.linphone.core.ConferenceInfo;
import org.linphone.mediastream.Log;

/* compiled from: ConferenceInfo.java */
/* loaded from: classes3.dex */
class ConferenceInfoImpl implements ConferenceInfo {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addParticipant(long j, Address address);

    private native ConferenceInfo clone(long j);

    private native long getDateTime(long j);

    private native String getDescription(long j);

    private native int getDuration(long j);

    private native String getIcalendarString(long j);

    private native Address getOrganizer(long j);

    private native Address[] getParticipants(long j);

    private native int getState(long j);

    private native String getSubject(long j);

    private native Address getUri(long j);

    private native void removeParticipant(long j, Address address);

    private native void setDateTime(long j, long j2);

    private native void setDescription(long j, String str);

    private native void setDuration(long j, int i);

    private native void setOrganizer(long j, Address address);

    private native void setParticipants(long j, Address[] addressArr);

    private native void setSubject(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ConferenceInfoImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ConferenceInfo
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized long getDateTime() {
        return getDateTime(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void setDateTime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDateTime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDateTime(this.nativePtr, j);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized String getDescription() {
        return getDescription(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
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

    @Override // org.linphone.core.ConferenceInfo
    public synchronized int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void setDuration(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDuration() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDuration(this.nativePtr, i);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized String getIcalendarString() {
        return getIcalendarString(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized Address getOrganizer() {
        return getOrganizer(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void setOrganizer(Address address) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOrganizer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOrganizer(this.nativePtr, address);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized Address[] getParticipants() {
        return getParticipants(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void setParticipants(Address[] addressArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParticipants() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParticipants(this.nativePtr, addressArr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized ConferenceInfo.State getState() {
        return ConferenceInfo.State.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized String getSubject() {
        return getSubject(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
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

    @Override // org.linphone.core.ConferenceInfo
    public synchronized Address getUri() {
        return getUri(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void addParticipant(Address address) {
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
        addParticipant(this.nativePtr, address);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized ConferenceInfo clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.ConferenceInfo
    public synchronized void removeParticipant(Address address) {
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
        removeParticipant(this.nativePtr, address);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ConferenceInfo
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ConferenceInfo
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ConferenceInfo
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
