package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: ChatRoomParams.java */
/* loaded from: classes3.dex */
class ChatRoomParamsImpl implements ChatRoomParams {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native int getBackend(long j);

    private native int getEncryptionBackend(long j);

    private native long getEphemeralLifetime(long j);

    private native int getEphemeralMode(long j);

    private native String getSubject(long j);

    private native boolean isEncryptionEnabled(long j);

    private native boolean isGroupEnabled(long j);

    private native boolean isRttEnabled(long j);

    private native boolean isValid(long j);

    private native void setBackend(long j, int i);

    private native void setEncryptionBackend(long j, int i);

    private native void setEncryptionEnabled(long j, boolean z);

    private native void setEphemeralLifetime(long j, long j2);

    private native void setEphemeralMode(long j, int i);

    private native void setGroupEnabled(long j, boolean z);

    private native void setRttEnabled(long j, boolean z);

    private native void setSubject(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ChatRoomParamsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.ChatRoomParams
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized ChatRoomBackend getBackend() {
        return ChatRoomBackend.fromInt(getBackend(this.nativePtr));
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setBackend(ChatRoomBackend chatRoomBackend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBackend() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setBackend(this.nativePtr, chatRoomBackend.toInt());
        }
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized ChatRoomEncryptionBackend getEncryptionBackend() {
        return ChatRoomEncryptionBackend.fromInt(getEncryptionBackend(this.nativePtr));
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setEncryptionBackend(ChatRoomEncryptionBackend chatRoomEncryptionBackend) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEncryptionBackend() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setEncryptionBackend(this.nativePtr, chatRoomEncryptionBackend.toInt());
        }
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized boolean isEncryptionEnabled() {
        return isEncryptionEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setEncryptionEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEncryptionEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEncryptionEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized long getEphemeralLifetime() {
        return getEphemeralLifetime(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setEphemeralLifetime(long j) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEphemeralLifetime() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEphemeralLifetime(this.nativePtr, j);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized ChatRoomEphemeralMode getEphemeralMode() {
        return ChatRoomEphemeralMode.fromInt(getEphemeralMode(this.nativePtr));
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEphemeralMode() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setEphemeralMode(this.nativePtr, chatRoomEphemeralMode.toInt());
        }
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized boolean isGroupEnabled() {
        return isGroupEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setGroupEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setGroupEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setGroupEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized boolean isValid() {
        return isValid(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized boolean isRttEnabled() {
        return isRttEnabled(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setRttEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRttEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRttEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized String getSubject() {
        return getSubject(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoomParams
    public synchronized void setSubject(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSubject() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSubject(this.nativePtr, str);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ChatRoomParams
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ChatRoomParams
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ChatRoomParams
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
