package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: RecorderParams.java */
/* loaded from: classes3.dex */
class RecorderParamsImpl implements RecorderParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native RecorderParams clone(long j);

    private native AudioDevice getAudioDevice(long j);

    private native int getFileFormat(long j);

    private native String getVideoCodec(long j);

    private native String getWebcamName(long j);

    private native Object getWindowId(long j);

    private native void setAudioDevice(long j, AudioDevice audioDevice);

    private native void setFileFormat(long j, int i);

    private native void setVideoCodec(long j, String str);

    private native void setWebcamName(long j, String str);

    private native void setWindowId(long j, Object obj);

    private native boolean unref(long j, boolean z);

    protected RecorderParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.RecorderParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized AudioDevice getAudioDevice() {
        return getAudioDevice(this.nativePtr);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized void setAudioDevice(AudioDevice audioDevice) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setAudioDevice() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setAudioDevice(this.nativePtr, audioDevice);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized RecorderFileFormat getFileFormat() {
        return RecorderFileFormat.fromInt(getFileFormat(this.nativePtr));
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized void setFileFormat(RecorderFileFormat recorderFileFormat) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFileFormat() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setFileFormat(this.nativePtr, recorderFileFormat.toInt());
        }
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized String getVideoCodec() {
        return getVideoCodec(this.nativePtr);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized void setVideoCodec(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVideoCodec() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVideoCodec(this.nativePtr, str);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized String getWebcamName() {
        return getWebcamName(this.nativePtr);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized void setWebcamName(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setWebcamName() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setWebcamName(this.nativePtr, str);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized Object getWindowId() {
        return getWindowId(this.nativePtr);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized void setWindowId(Object obj) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setWindowId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setWindowId(this.nativePtr, obj);
    }

    @Override // org.linphone.core.RecorderParams
    public synchronized RecorderParams clone() {
        return clone(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.RecorderParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.RecorderParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.RecorderParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
