package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: PresenceNote.java */
/* loaded from: classes3.dex */
class PresenceNoteImpl implements PresenceNote {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native String getContent(long j);

    private native String getLang(long j);

    private native int setContent(long j, String str);

    private native int setLang(long j, String str);

    private native boolean unref(long j, boolean z);

    protected PresenceNoteImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PresenceNote
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PresenceNote
    public synchronized String getContent() {
        return getContent(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceNote
    public synchronized int setContent(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setContent(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceNote
    public synchronized String getLang() {
        return getLang(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceNote
    public synchronized int setLang(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLang() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setLang(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PresenceNote
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PresenceNote
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PresenceNote
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
