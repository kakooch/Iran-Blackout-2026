package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: VideoSourceDescriptor.java */
/* loaded from: classes3.dex */
class VideoSourceDescriptorImpl implements VideoSourceDescriptor {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native VideoSourceDescriptor clone(long j);

    private native Call getCall(long j);

    private native String getCameraId(long j);

    private native String getImage(long j);

    private native int getType(long j);

    private native void setCall(long j, Call call);

    private native void setCameraId(long j, String str);

    private native void setImage(long j, String str);

    private native boolean unref(long j, boolean z);

    protected VideoSourceDescriptorImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized Call getCall() {
        return getCall(this.nativePtr);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized void setCall(Call call) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCall() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCall(this.nativePtr, call);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized String getCameraId() {
        return getCameraId(this.nativePtr);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized void setCameraId(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCameraId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCameraId(this.nativePtr, str);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized String getImage() {
        return getImage(this.nativePtr);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized void setImage(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setImage() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setImage(this.nativePtr, str);
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized VideoSourceType getType() {
        return VideoSourceType.fromInt(getType(this.nativePtr));
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public synchronized VideoSourceDescriptor clone() {
        return clone(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.VideoSourceDescriptor
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
