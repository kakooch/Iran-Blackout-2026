package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ImNotifPolicy.java */
/* loaded from: classes3.dex */
class ImNotifPolicyImpl implements ImNotifPolicy {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void clear(long j);

    private native void enableAll(long j);

    private native boolean getRecvImdnDelivered(long j);

    private native boolean getRecvImdnDeliveryError(long j);

    private native boolean getRecvImdnDisplayed(long j);

    private native boolean getRecvIsComposing(long j);

    private native boolean getSendImdnDelivered(long j);

    private native boolean getSendImdnDeliveryError(long j);

    private native boolean getSendImdnDisplayed(long j);

    private native boolean getSendIsComposing(long j);

    private native void setRecvImdnDelivered(long j, boolean z);

    private native void setRecvImdnDeliveryError(long j, boolean z);

    private native void setRecvImdnDisplayed(long j, boolean z);

    private native void setRecvIsComposing(long j, boolean z);

    private native void setSendImdnDelivered(long j, boolean z);

    private native void setSendImdnDeliveryError(long j, boolean z);

    private native void setSendImdnDisplayed(long j, boolean z);

    private native void setSendIsComposing(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected ImNotifPolicyImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ImNotifPolicy
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getRecvImdnDelivered() {
        return getRecvImdnDelivered(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setRecvImdnDelivered(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecvImdnDelivered() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecvImdnDelivered(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getRecvImdnDeliveryError() {
        return getRecvImdnDeliveryError(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setRecvImdnDeliveryError(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecvImdnDeliveryError() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecvImdnDeliveryError(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getRecvImdnDisplayed() {
        return getRecvImdnDisplayed(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setRecvImdnDisplayed(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecvImdnDisplayed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecvImdnDisplayed(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getRecvIsComposing() {
        return getRecvIsComposing(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setRecvIsComposing(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRecvIsComposing() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRecvIsComposing(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getSendImdnDelivered() {
        return getSendImdnDelivered(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setSendImdnDelivered(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSendImdnDelivered() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSendImdnDelivered(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getSendImdnDeliveryError() {
        return getSendImdnDeliveryError(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setSendImdnDeliveryError(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSendImdnDeliveryError() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSendImdnDeliveryError(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getSendImdnDisplayed() {
        return getSendImdnDisplayed(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setSendImdnDisplayed(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSendImdnDisplayed() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSendImdnDisplayed(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized boolean getSendIsComposing() {
        return getSendIsComposing(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void setSendIsComposing(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSendIsComposing() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSendIsComposing(this.nativePtr, z);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void clear() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call clear() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        clear(this.nativePtr);
    }

    @Override // org.linphone.core.ImNotifPolicy
    public synchronized void enableAll() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call enableAll() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        enableAll(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ImNotifPolicy
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ImNotifPolicy
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ImNotifPolicy
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
