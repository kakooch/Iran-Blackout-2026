package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: VideoDefinition.java */
/* loaded from: classes3.dex */
class VideoDefinitionImpl implements VideoDefinition {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native VideoDefinition clone(long j);

    private native boolean equals(long j, VideoDefinition videoDefinition);

    private native int getHeight(long j);

    private native String getName(long j);

    private native int getWidth(long j);

    private native boolean isUndefined(long j);

    private native void setDefinition(long j, int i, int i2);

    private native void setHeight(long j, int i);

    private native void setName(long j, String str);

    private native void setWidth(long j, int i);

    private native boolean strictEquals(long j, VideoDefinition videoDefinition);

    private native boolean unref(long j, boolean z);

    protected VideoDefinitionImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.VideoDefinition
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized int getHeight() {
        return getHeight(this.nativePtr);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized void setHeight(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setHeight() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setHeight(this.nativePtr, i);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized boolean isUndefined() {
        return isUndefined(this.nativePtr);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized String getName() {
        return getName(this.nativePtr);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized void setName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setName(this.nativePtr, str);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized int getWidth() {
        return getWidth(this.nativePtr);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized void setWidth(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setWidth() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setWidth(this.nativePtr, i);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized VideoDefinition clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized boolean equals(VideoDefinition videoDefinition) {
        return equals(this.nativePtr, videoDefinition);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized void setDefinition(int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDefinition() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDefinition(this.nativePtr, i, i2);
    }

    @Override // org.linphone.core.VideoDefinition
    public synchronized boolean strictEquals(VideoDefinition videoDefinition) {
        return strictEquals(this.nativePtr, videoDefinition);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.VideoDefinition
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.VideoDefinition
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.VideoDefinition
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
