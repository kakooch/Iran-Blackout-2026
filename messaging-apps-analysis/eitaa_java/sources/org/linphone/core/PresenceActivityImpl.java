package org.linphone.core;

import org.linphone.core.PresenceActivity;
import org.linphone.mediastream.Log;

/* compiled from: PresenceActivity.java */
/* loaded from: classes3.dex */
class PresenceActivityImpl implements PresenceActivity {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native String getDescription(long j);

    private native int getType(long j);

    private native int setDescription(long j, String str);

    private native int setType(long j, int i);

    private native String toString(long j);

    private native boolean unref(long j, boolean z);

    protected PresenceActivityImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PresenceActivity
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PresenceActivity
    public synchronized String getDescription() {
        return getDescription(this.nativePtr);
    }

    @Override // org.linphone.core.PresenceActivity
    public synchronized int setDescription(String str) {
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
        return setDescription(this.nativePtr, str);
    }

    @Override // org.linphone.core.PresenceActivity
    public synchronized PresenceActivity.Type getType() {
        return PresenceActivity.Type.fromInt(getType(this.nativePtr));
    }

    @Override // org.linphone.core.PresenceActivity
    public synchronized int setType(PresenceActivity.Type type) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setType() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return setType(this.nativePtr, type.toInt());
    }

    @Override // org.linphone.core.PresenceActivity
    public synchronized String toString() {
        return toString(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PresenceActivity
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PresenceActivity
    public Object getUserData() {
        return this.userData;
    }
}
