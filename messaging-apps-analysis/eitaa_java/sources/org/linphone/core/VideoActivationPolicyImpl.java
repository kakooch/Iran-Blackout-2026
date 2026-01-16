package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: VideoActivationPolicy.java */
/* loaded from: classes3.dex */
class VideoActivationPolicyImpl implements VideoActivationPolicy {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native boolean getAutomaticallyAccept(long j);

    private native boolean getAutomaticallyInitiate(long j);

    private native void setAutomaticallyAccept(long j, boolean z);

    private native void setAutomaticallyInitiate(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected VideoActivationPolicyImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public synchronized boolean getAutomaticallyAccept() {
        return getAutomaticallyAccept(this.nativePtr);
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public synchronized void setAutomaticallyAccept(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutomaticallyAccept() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutomaticallyAccept(this.nativePtr, z);
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public synchronized boolean getAutomaticallyInitiate() {
        return getAutomaticallyInitiate(this.nativePtr);
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public synchronized void setAutomaticallyInitiate(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAutomaticallyInitiate() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAutomaticallyInitiate(this.nativePtr, z);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.VideoActivationPolicy
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
