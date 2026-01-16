package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ParticipantDeviceIdentity.java */
/* loaded from: classes3.dex */
class ParticipantDeviceIdentityImpl implements ParticipantDeviceIdentity {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native Address getAddress(long j);

    private native String getCapabilityDescriptor(long j);

    private native String[] getCapabilityDescriptorList(long j);

    private native void setCapabilityDescriptor(long j, String str);

    private native void setCapabilityDescriptor2(long j, String[] strArr);

    private native boolean unref(long j, boolean z);

    protected ParticipantDeviceIdentityImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public synchronized Address getAddress() {
        return getAddress(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public synchronized String getCapabilityDescriptor() {
        return getCapabilityDescriptor(this.nativePtr);
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public synchronized void setCapabilityDescriptor(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityDescriptor() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityDescriptor(this.nativePtr, str);
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public synchronized void setCapabilityDescriptor(String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCapabilityDescriptor() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCapabilityDescriptor2(this.nativePtr, strArr);
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public synchronized String[] getCapabilityDescriptorList() {
        return getCapabilityDescriptorList(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ParticipantDeviceIdentity
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
