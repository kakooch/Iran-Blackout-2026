package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Buffer.java */
/* loaded from: classes3.dex */
class BufferImpl implements Buffer {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native byte[] getContent(long j);

    private native int getSize(long j);

    private native String getStringContent(long j);

    private native boolean isEmpty(long j);

    private native Buffer newFromData(long j, byte[] bArr, int i);

    private native Buffer newFromString(long j, String str);

    private native void setContent(long j, byte[] bArr, int i);

    private native void setSize(long j, int i);

    private native void setStringContent(long j, String str);

    private native boolean unref(long j, boolean z);

    protected BufferImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Buffer
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Buffer
    public synchronized byte[] getContent() {
        return getContent(this.nativePtr);
    }

    @Override // org.linphone.core.Buffer
    public synchronized boolean isEmpty() {
        return isEmpty(this.nativePtr);
    }

    @Override // org.linphone.core.Buffer
    public synchronized int getSize() {
        return getSize(this.nativePtr);
    }

    @Override // org.linphone.core.Buffer
    public synchronized void setSize(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSize() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSize(this.nativePtr, i);
    }

    @Override // org.linphone.core.Buffer
    public synchronized String getStringContent() {
        return getStringContent(this.nativePtr);
    }

    @Override // org.linphone.core.Buffer
    public synchronized void setStringContent(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStringContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setStringContent(this.nativePtr, str);
    }

    @Override // org.linphone.core.Buffer
    public synchronized void setContent(byte[] bArr, int i) {
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
        setContent(this.nativePtr, bArr, i);
    }

    @Override // org.linphone.core.Buffer
    public synchronized Buffer newFromData(byte[] bArr, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newFromData() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newFromData(this.nativePtr, bArr, i);
    }

    @Override // org.linphone.core.Buffer
    public synchronized Buffer newFromString(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newFromString() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newFromString(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Buffer
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Buffer
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Buffer
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
