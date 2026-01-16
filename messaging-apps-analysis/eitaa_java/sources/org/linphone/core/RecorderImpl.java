package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Recorder.java */
/* loaded from: classes3.dex */
class RecorderImpl implements Recorder {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void close(long j);

    private native Content createContent(long j);

    private native float getCaptureVolume(long j);

    private native int getDuration(long j);

    private native String getFile(long j);

    private native RecorderParams getParams(long j);

    private native int getState(long j);

    private native int open(long j, String str);

    private native int pause(long j);

    private native void setParams(long j, RecorderParams recorderParams);

    private native int start(long j);

    private native boolean unref(long j, boolean z);

    protected RecorderImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Recorder
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Recorder
    public synchronized float getCaptureVolume() {
        return getCaptureVolume(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized int getDuration() {
        return getDuration(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized String getFile() {
        return getFile(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized RecorderParams getParams() {
        return getParams(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized void setParams(RecorderParams recorderParams) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParams() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParams(this.nativePtr, recorderParams);
    }

    @Override // org.linphone.core.Recorder
    public synchronized RecorderState getState() {
        return RecorderState.fromInt(getState(this.nativePtr));
    }

    @Override // org.linphone.core.Recorder
    public synchronized void close() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call close() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        close(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized Content createContent() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call createContent() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return createContent(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized int open(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call open() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return open(this.nativePtr, str);
    }

    @Override // org.linphone.core.Recorder
    public synchronized int pause() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call pause() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return pause(this.nativePtr);
    }

    @Override // org.linphone.core.Recorder
    public synchronized int start() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call start() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return start(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Recorder
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Recorder
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Recorder
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
