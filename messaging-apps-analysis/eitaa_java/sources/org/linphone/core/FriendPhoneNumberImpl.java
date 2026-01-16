package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: FriendPhoneNumber.java */
/* loaded from: classes3.dex */
class FriendPhoneNumberImpl implements FriendPhoneNumber {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native FriendPhoneNumber clone(long j);

    private native String getLabel(long j);

    private native String getPhoneNumber(long j);

    private native void setLabel(long j, String str);

    private native void setPhoneNumber(long j, String str);

    private native boolean unref(long j, boolean z);

    protected FriendPhoneNumberImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public synchronized String getLabel() {
        return getLabel(this.nativePtr);
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public synchronized void setLabel(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLabel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLabel(this.nativePtr, str);
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public synchronized String getPhoneNumber() {
        return getPhoneNumber(this.nativePtr);
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public synchronized void setPhoneNumber(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPhoneNumber() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPhoneNumber(this.nativePtr, str);
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public synchronized FriendPhoneNumber clone() {
        return clone(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.FriendPhoneNumber
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
