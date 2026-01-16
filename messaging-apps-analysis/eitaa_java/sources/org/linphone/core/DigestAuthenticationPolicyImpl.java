package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: DigestAuthenticationPolicy.java */
/* loaded from: classes3.dex */
class DigestAuthenticationPolicyImpl implements DigestAuthenticationPolicy {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native boolean getAllowMd55(long j);

    private native boolean getAllowNoQop(long j);

    private native void setAllowMd55(long j, boolean z);

    private native void setAllowNoQop(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected DigestAuthenticationPolicyImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public synchronized boolean getAllowMd5() {
        return getAllowMd55(this.nativePtr);
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public synchronized void setAllowMd5(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAllowMd5() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAllowMd55(this.nativePtr, z);
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public synchronized boolean getAllowNoQop() {
        return getAllowNoQop(this.nativePtr);
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public synchronized void setAllowNoQop(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAllowNoQop() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAllowNoQop(this.nativePtr, z);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.DigestAuthenticationPolicy
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
