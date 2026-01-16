package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Content.java */
/* loaded from: classes3.dex */
class ContentImpl implements Content {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addContentTypeParameter(long j, String str, String str2);

    private native void addCustomHeader(long j, String str, String str2);

    private native String exportPlainFile(long j);

    private native Content findPartByHeader(long j, String str, String str2);

    private native byte[] getBuffer(long j);

    private native String getCustomHeader(long j, String str);

    private native String getDisposition(long j);

    private native String getEncoding(long j);

    private native int getFileDuration(long j);

    private native String getFilePath(long j);

    private native int getFileSize(long j);

    private native String getKey(long j);

    private native int getKeySize(long j);

    private native String getName(long j);

    private native Content getPart(long j, int i);

    private native Content[] getParts(long j);

    private native String getPlainFilePath(long j);

    private native int getSize(long j);

    private native String getStringBuffer(long j);

    private native String getSubtype(long j);

    private native String getType(long j);

    private native String getUtf8Text(long j);

    private native boolean isFile(long j);

    private native boolean isFileEncrypted(long j);

    private native boolean isFileTransfer(long j);

    private native boolean isIcalendar(long j);

    private native boolean isMultipart(long j);

    private native boolean isText(long j);

    private native boolean isVoiceRecording(long j);

    private native void setBuffer(long j, byte[] bArr, int i);

    private native void setDisposition(long j, String str);

    private native void setEncoding(long j, String str);

    private native void setFilePath(long j, String str);

    private native void setKey(long j, String str, int i);

    private native void setName(long j, String str);

    private native void setSize(long j, int i);

    private native void setStringBuffer(long j, String str);

    private native void setSubtype(long j, String str);

    private native void setType(long j, String str);

    private native void setUtf8Text(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ContentImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Content
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Content
    public synchronized byte[] getBuffer() {
        return getBuffer(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized String getDisposition() {
        return getDisposition(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setDisposition(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDisposition() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDisposition(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized String getEncoding() {
        return getEncoding(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setEncoding(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setEncoding() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setEncoding(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized int getFileDuration() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getFileDuration() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getFileDuration(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized String getFilePath() {
        return getFilePath(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setFilePath(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFilePath() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setFilePath(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized int getFileSize() {
        return getFileSize(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isFile() {
        return isFile(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isFileEncrypted() {
        return isFileEncrypted(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isFileTransfer() {
        return isFileTransfer(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isIcalendar() {
        return isIcalendar(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isMultipart() {
        return isMultipart(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isText() {
        return isText(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized boolean isVoiceRecording() {
        return isVoiceRecording(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized String getKey() {
        return getKey(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized int getKeySize() {
        return getKeySize(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized String getName() {
        return getName(this.nativePtr);
    }

    @Override // org.linphone.core.Content
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

    @Override // org.linphone.core.Content
    public synchronized Content[] getParts() {
        return getParts(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized String getPlainFilePath() {
        return getPlainFilePath(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized int getSize() {
        return getSize(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setSize(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSize() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSize(this.nativePtr, i);
    }

    @Override // org.linphone.core.Content
    public synchronized String getStringBuffer() {
        return getStringBuffer(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setStringBuffer(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStringBuffer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setStringBuffer(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized String getSubtype() {
        return getSubtype(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setSubtype(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSubtype() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSubtype(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized String getType() {
        return getType(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setType(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setType() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setType(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized String getUtf8Text() {
        return getUtf8Text(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized void setUtf8Text(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUtf8Text() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUtf8Text(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized void addContentTypeParameter(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addContentTypeParameter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addContentTypeParameter(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Content
    public synchronized void addCustomHeader(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call addCustomHeader() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        addCustomHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Content
    public synchronized String exportPlainFile() {
        return exportPlainFile(this.nativePtr);
    }

    @Override // org.linphone.core.Content
    public synchronized Content findPartByHeader(String str, String str2) {
        return findPartByHeader(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Content
    public synchronized String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    @Override // org.linphone.core.Content
    public synchronized Content getPart(int i) {
        return getPart(this.nativePtr, i);
    }

    @Override // org.linphone.core.Content
    public synchronized void setBuffer(byte[] bArr, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBuffer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setBuffer(this.nativePtr, bArr, i);
    }

    @Override // org.linphone.core.Content
    public synchronized void setKey(String str, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setKey() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setKey(this.nativePtr, str, i);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Content
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Content
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Content
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
