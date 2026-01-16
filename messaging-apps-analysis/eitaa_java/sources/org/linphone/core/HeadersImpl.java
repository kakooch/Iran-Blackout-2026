package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Headers.java */
/* loaded from: classes3.dex */
class HeadersImpl implements Headers {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void add(long j, String str, String str2);

    private native String getValue(long j, String str);

    private native void remove(long j, String str);

    private native boolean unref(long j, boolean z);

    protected HeadersImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Headers
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Headers
    public synchronized void add(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call add() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        add(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Headers
    public synchronized String getValue(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getValue() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getValue(this.nativePtr, str);
    }

    @Override // org.linphone.core.Headers
    public synchronized void remove(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call remove() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        remove(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Headers
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Headers
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Headers
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
