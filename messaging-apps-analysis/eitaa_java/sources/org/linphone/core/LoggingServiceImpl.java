package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: LoggingService.java */
/* loaded from: classes3.dex */
class LoggingServiceImpl implements LoggingService {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, LoggingServiceListener loggingServiceListener);

    private native void debug(long j, String str);

    private native void error(long j, String str);

    private native void fatal(long j, String str);

    private native LoggingService get(long j);

    private native String getDomain(long j);

    private native int getLogLevelMask(long j);

    private native void message(long j, String str);

    private native void removeListener(long j, LoggingServiceListener loggingServiceListener);

    private native void setDomain(long j, String str);

    private native void setLogFile(long j, String str, String str2, int i);

    private native void setLogLevel(long j, int i);

    private native void setLogLevelMask(long j, int i);

    private native void setStackTraceDumpsEnabled(long j, boolean z);

    private native void trace(long j, String str);

    private native boolean unref(long j, boolean z);

    private native void warning(long j, String str);

    protected LoggingServiceImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.LoggingService
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.LoggingService
    public synchronized String getDomain() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getDomain() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getDomain(this.nativePtr);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void setDomain(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDomain() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDomain(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void setLogLevel(LogLevel logLevel) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogLevel() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setLogLevel(this.nativePtr, logLevel.toInt());
        }
    }

    @Override // org.linphone.core.LoggingService
    public synchronized int getLogLevelMask() {
        return getLogLevelMask(this.nativePtr);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void setLogLevelMask(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLogLevelMask() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLogLevelMask(this.nativePtr, i);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void setStackTraceDumpsEnabled(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStackTraceDumpsEnabled() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setStackTraceDumpsEnabled(this.nativePtr, z);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void debug(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call debug() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        debug(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void error(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call error() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        error(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void fatal(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call fatal() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        fatal(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void message(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call message() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        message(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void setLogFile(String str, String str2, int i) {
        setLogFile(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void trace(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call trace() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        trace(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void warning(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call warning() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        warning(this.nativePtr, str);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized LoggingService get() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call get() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return get(this.nativePtr);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void addListener(LoggingServiceListener loggingServiceListener) {
        addListener(this.nativePtr, loggingServiceListener);
    }

    @Override // org.linphone.core.LoggingService
    public synchronized void removeListener(LoggingServiceListener loggingServiceListener) {
        removeListener(this.nativePtr, loggingServiceListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.LoggingService
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.LoggingService
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.LoggingService
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
