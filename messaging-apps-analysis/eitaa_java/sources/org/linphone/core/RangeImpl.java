package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Range.java */
/* loaded from: classes3.dex */
class RangeImpl implements Range {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int getMax(long j);

    private native int getMin(long j);

    private native void setMax(long j, int i);

    private native void setMin(long j, int i);

    private native boolean unref(long j, boolean z);

    protected RangeImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Range
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Range
    public synchronized int getMax() {
        return getMax(this.nativePtr);
    }

    @Override // org.linphone.core.Range
    public synchronized void setMax(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMax() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMax(this.nativePtr, i);
    }

    @Override // org.linphone.core.Range
    public synchronized int getMin() {
        return getMin(this.nativePtr);
    }

    @Override // org.linphone.core.Range
    public synchronized void setMin(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMin() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMin(this.nativePtr, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Range
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Range
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Range
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
