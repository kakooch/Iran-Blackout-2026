package org.linphone.core;

import org.linphone.core.Player;
import org.linphone.mediastream.Log;

/* compiled from: Player.java */
/* loaded from: classes3.dex */
class PlayerImpl implements Player {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, PlayerListener playerListener);

    private native void close(long j);

    private native Object createWindowId(long j);

    private native Core getCore(long j);

    private native int getCurrentPosition(long j);

    private native int getDuration(long j);

    private native boolean getIsVideoAvailable(long j);

    private native int getState(long j);

    private native float getVolumeGain(long j);

    private native int open(long j, String str);

    private native int pause(long j);

    private native void removeListener(long j, PlayerListener playerListener);

    private native int seek(long j, int i);

    private native void setVolumeGain(long j, float f);

    private native void setWindowId(long j, Object obj);

    private native int start(long j);

    private native boolean unref(long j, boolean z);

    protected PlayerImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.Player
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Player
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.Player
    public synchronized int getCurrentPosition() {
        int currentPosition;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getCurrentPosition() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            currentPosition = getCurrentPosition(this.nativePtr);
        }
        return currentPosition;
    }

    @Override // org.linphone.core.Player
    public synchronized int getDuration() {
        int duration;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getDuration() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            duration = getDuration(this.nativePtr);
        }
        return duration;
    }

    @Override // org.linphone.core.Player
    public synchronized boolean getIsVideoAvailable() {
        boolean isVideoAvailable;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getIsVideoAvailable() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            isVideoAvailable = getIsVideoAvailable(this.nativePtr);
        }
        return isVideoAvailable;
    }

    @Override // org.linphone.core.Player
    public synchronized Player.State getState() {
        Player.State stateFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getState() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            stateFromInt = Player.State.fromInt(getState(this.nativePtr));
        }
        return stateFromInt;
    }

    @Override // org.linphone.core.Player
    public synchronized float getVolumeGain() {
        float volumeGain;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getVolumeGain() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            volumeGain = getVolumeGain(this.nativePtr);
        }
        return volumeGain;
    }

    @Override // org.linphone.core.Player
    public synchronized void setVolumeGain(float f) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setVolumeGain() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setVolumeGain(this.nativePtr, f);
        }
    }

    @Override // org.linphone.core.Player
    public synchronized void setWindowId(Object obj) {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.Player
    public synchronized void close() {
        synchronized (this.core) {
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
    }

    @Override // org.linphone.core.Player
    public synchronized Object createWindowId() {
        Object objCreateWindowId;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createWindowId() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            objCreateWindowId = createWindowId(this.nativePtr);
        }
        return objCreateWindowId;
    }

    @Override // org.linphone.core.Player
    public synchronized int open(String str) {
        int iOpen;
        synchronized (this.core) {
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
            iOpen = open(this.nativePtr, str);
        }
        return iOpen;
    }

    @Override // org.linphone.core.Player
    public synchronized int pause() {
        int iPause;
        synchronized (this.core) {
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
            iPause = pause(this.nativePtr);
        }
        return iPause;
    }

    @Override // org.linphone.core.Player
    public synchronized int seek(int i) {
        int iSeek;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call seek() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iSeek = seek(this.nativePtr, i);
        }
        return iSeek;
    }

    @Override // org.linphone.core.Player
    public synchronized int start() {
        int iStart;
        synchronized (this.core) {
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
            iStart = start(this.nativePtr);
        }
        return iStart;
    }

    @Override // org.linphone.core.Player
    public synchronized void addListener(PlayerListener playerListener) {
        addListener(this.nativePtr, playerListener);
    }

    @Override // org.linphone.core.Player
    public synchronized void removeListener(PlayerListener playerListener) {
        removeListener(this.nativePtr, playerListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Player
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Player
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Player
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
