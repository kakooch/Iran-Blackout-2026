package org.linphone.core;

import org.linphone.core.AudioDevice;

/* compiled from: AudioDevice.java */
/* loaded from: classes3.dex */
class AudioDeviceImpl implements AudioDevice {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int getCapabilities(long j);

    private native String getDeviceName(long j);

    private native String getDriverName(long j);

    private native String getId(long j);

    private native int getType(long j);

    private native boolean hasCapability(long j, int i);

    private native boolean unref(long j, boolean z);

    protected AudioDeviceImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.AudioDevice
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized AudioDevice.Capabilities getCapabilities() {
        return AudioDevice.Capabilities.fromInt(getCapabilities(this.nativePtr));
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized String getDeviceName() {
        return getDeviceName(this.nativePtr);
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized String getDriverName() {
        return getDriverName(this.nativePtr);
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized String getId() {
        return getId(this.nativePtr);
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized AudioDevice.Type getType() {
        return AudioDevice.Type.fromInt(getType(this.nativePtr));
    }

    @Override // org.linphone.core.AudioDevice
    public synchronized boolean hasCapability(AudioDevice.Capabilities capabilities) {
        return hasCapability(this.nativePtr, capabilities.toInt());
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.AudioDevice
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.AudioDevice
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.AudioDevice
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
