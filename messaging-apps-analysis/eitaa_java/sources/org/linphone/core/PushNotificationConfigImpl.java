package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: PushNotificationConfig.java */
/* loaded from: classes3.dex */
class PushNotificationConfigImpl implements PushNotificationConfig {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native PushNotificationConfig clone(long j);

    private native String getBundleIdentifier(long j);

    private native String getCallSnd(long j);

    private native String getCallStr(long j);

    private native String getGroupChatStr(long j);

    private native String getMsgSnd(long j);

    private native String getMsgStr(long j);

    private native String getParam(long j);

    private native String getPrid(long j);

    private native String getProvider(long j);

    private native String getRemoteToken(long j);

    private native String getTeamId(long j);

    private native String getVoipToken(long j);

    private native boolean isEqual(long j, PushNotificationConfig pushNotificationConfig);

    private native void setBundleIdentifier(long j, String str);

    private native void setCallSnd(long j, String str);

    private native void setCallStr(long j, String str);

    private native void setGroupChatStr(long j, String str);

    private native void setMsgSnd(long j, String str);

    private native void setMsgStr(long j, String str);

    private native void setParam(long j, String str);

    private native void setPrid(long j, String str);

    private native void setProvider(long j, String str);

    private native void setRemoteToken(long j, String str);

    private native void setTeamId(long j, String str);

    private native void setVoipToken(long j, String str);

    private native boolean unref(long j, boolean z);

    protected PushNotificationConfigImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.PushNotificationConfig
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getBundleIdentifier() {
        return getBundleIdentifier(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setBundleIdentifier(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBundleIdentifier() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setBundleIdentifier(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getCallSnd() {
        return getCallSnd(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setCallSnd(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCallSnd() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCallSnd(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getCallStr() {
        return getCallStr(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setCallStr(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setCallStr() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setCallStr(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getGroupChatStr() {
        return getGroupChatStr(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setGroupChatStr(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setGroupChatStr() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setGroupChatStr(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getMsgSnd() {
        return getMsgSnd(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setMsgSnd(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMsgSnd() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMsgSnd(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getMsgStr() {
        return getMsgStr(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setMsgStr(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMsgStr() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMsgStr(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getParam() {
        return getParam(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setParam(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setParam() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setParam(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getPrid() {
        return getPrid(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setPrid(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setPrid() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setPrid(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getProvider() {
        return getProvider(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setProvider(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setProvider() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setProvider(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getRemoteToken() {
        return getRemoteToken(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setRemoteToken(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRemoteToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setRemoteToken(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getTeamId() {
        return getTeamId(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setTeamId(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setTeamId() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setTeamId(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized String getVoipToken() {
        return getVoipToken(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized void setVoipToken(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setVoipToken() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setVoipToken(this.nativePtr, str);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized PushNotificationConfig clone() {
        return clone(this.nativePtr);
    }

    @Override // org.linphone.core.PushNotificationConfig
    public synchronized boolean isEqual(PushNotificationConfig pushNotificationConfig) {
        return isEqual(this.nativePtr, pushNotificationConfig);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.PushNotificationConfig
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.PushNotificationConfig
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.PushNotificationConfig
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
