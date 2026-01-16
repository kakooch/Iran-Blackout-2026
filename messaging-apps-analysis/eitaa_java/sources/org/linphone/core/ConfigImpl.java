package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: Config.java */
/* loaded from: classes3.dex */
class ConfigImpl implements Config {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void cleanEntry(long j, String str, String str2);

    private native void cleanSection(long j, String str);

    private native String dump(long j);

    private native String dumpAsXml(long j);

    private native boolean getBool(long j, String str, String str2, boolean z);

    private native float getDefaultFloat(long j, String str, String str2, float f);

    private native int getDefaultInt(long j, String str, String str2, int i);

    private native int getDefaultInt644(long j, String str, String str2, int i);

    private native String getDefaultString(long j, String str, String str2, String str3);

    private native float getFloat(long j, String str, String str2, float f);

    private native int getInt(long j, String str, String str2, int i);

    private native int getInt644(long j, String str, String str2, int i);

    private native String[] getKeysNamesList(long j, String str);

    private native boolean getOverwriteFlagForEntry(long j, String str, String str2);

    private native boolean getOverwriteFlagForSection(long j, String str);

    private native String getSectionParamString(long j, String str, String str2, String str3);

    private native String[] getSectionsNamesList(long j);

    private native boolean getSkipFlagForEntry(long j, String str, String str2);

    private native boolean getSkipFlagForSection(long j, String str);

    private native String getString(long j, String str, String str2, String str3);

    private native String[] getStringList(long j, String str, String str2, String[] strArr);

    private native int hasEntry(long j, String str, String str2);

    private native int hasSection(long j, String str);

    private native String loadFromXmlFile(long j, String str);

    private native int loadFromXmlString(long j, String str);

    private native Config newFromBuffer(long j, String str);

    private native Config newWithFactory(long j, String str, String str2);

    private native int readFile(long j, String str);

    private native boolean relativeFileExists(long j, String str);

    private native void reload(long j);

    private native void setBool(long j, String str, String str2, boolean z);

    private native void setFloat(long j, String str, String str2, float f);

    private native void setInt(long j, String str, String str2, int i);

    private native void setInt644(long j, String str, String str2, int i);

    private native void setIntHex(long j, String str, String str2, int i);

    private native void setOverwriteFlagForEntry(long j, String str, String str2, boolean z);

    private native void setOverwriteFlagForSection(long j, String str, boolean z);

    private native void setRange(long j, String str, String str2, int i, int i2);

    private native void setSkipFlagForEntry(long j, String str, String str2, boolean z);

    private native void setSkipFlagForSection(long j, String str, boolean z);

    private native void setString(long j, String str, String str2, String str3);

    private native void setStringList(long j, String str, String str2, String[] strArr);

    private native int sync(long j);

    private native boolean unref(long j, boolean z);

    private native void writeRelativeFile(long j, String str, String str2);

    protected ConfigImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.Config
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.Config
    public synchronized String[] getSectionsNamesList() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getSectionsNamesList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getSectionsNamesList(this.nativePtr);
    }

    @Override // org.linphone.core.Config
    public synchronized void cleanEntry(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call cleanEntry() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        cleanEntry(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Config
    public synchronized void cleanSection(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call cleanSection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        cleanSection(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized String dump() {
        return dump(this.nativePtr);
    }

    @Override // org.linphone.core.Config
    public synchronized String dumpAsXml() {
        return dumpAsXml(this.nativePtr);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean getBool(String str, String str2, boolean z) {
        return getBool(this.nativePtr, str, str2, z);
    }

    @Override // org.linphone.core.Config
    public synchronized float getDefaultFloat(String str, String str2, float f) {
        return getDefaultFloat(this.nativePtr, str, str2, f);
    }

    @Override // org.linphone.core.Config
    public synchronized int getDefaultInt(String str, String str2, int i) {
        return getDefaultInt(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.Config
    public synchronized int getDefaultInt64(String str, String str2, int i) {
        return getDefaultInt644(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.Config
    public synchronized String getDefaultString(String str, String str2, String str3) {
        return getDefaultString(this.nativePtr, str, str2, str3);
    }

    @Override // org.linphone.core.Config
    public synchronized float getFloat(String str, String str2, float f) {
        return getFloat(this.nativePtr, str, str2, f);
    }

    @Override // org.linphone.core.Config
    public synchronized int getInt(String str, String str2, int i) {
        return getInt(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.Config
    public synchronized int getInt64(String str, String str2, int i) {
        return getInt644(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.Config
    public synchronized String[] getKeysNamesList(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getKeysNamesList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getKeysNamesList(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean getOverwriteFlagForEntry(String str, String str2) {
        return getOverwriteFlagForEntry(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean getOverwriteFlagForSection(String str) {
        return getOverwriteFlagForSection(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized String getSectionParamString(String str, String str2, String str3) {
        return getSectionParamString(this.nativePtr, str, str2, str3);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean getSkipFlagForEntry(String str, String str2) {
        return getSkipFlagForEntry(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean getSkipFlagForSection(String str) {
        return getSkipFlagForSection(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized String getString(String str, String str2, String str3) {
        return getString(this.nativePtr, str, str2, str3);
    }

    @Override // org.linphone.core.Config
    public synchronized String[] getStringList(String str, String str2, String[] strArr) {
        return getStringList(this.nativePtr, str, str2, strArr);
    }

    @Override // org.linphone.core.Config
    public synchronized int hasEntry(String str, String str2) {
        return hasEntry(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Config
    public synchronized int hasSection(String str) {
        return hasSection(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized String loadFromXmlFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call loadFromXmlFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return loadFromXmlFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized int loadFromXmlString(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call loadFromXmlString() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return loadFromXmlString(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized int readFile(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call readFile() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return readFile(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized boolean relativeFileExists(String str) {
        return relativeFileExists(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized void reload() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call reload() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        reload(this.nativePtr);
    }

    @Override // org.linphone.core.Config
    public synchronized void setBool(String str, String str2, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setBool() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setBool(this.nativePtr, str, str2, z);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setFloat(String str, String str2, float f) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setFloat() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setFloat(this.nativePtr, str, str2, f);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setInt(String str, String str2, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInt() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setInt(this.nativePtr, str, str2, i);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setInt64(String str, String str2, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setInt64() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setInt644(this.nativePtr, str, str2, i);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setIntHex(String str, String str2, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setIntHex() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setIntHex(this.nativePtr, str, str2, i);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setOverwriteFlagForEntry(String str, String str2, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOverwriteFlagForEntry() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setOverwriteFlagForEntry(this.nativePtr, str, str2, z);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setOverwriteFlagForSection(String str, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setOverwriteFlagForSection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setOverwriteFlagForSection(this.nativePtr, str, z);
    }

    @Override // org.linphone.core.Config
    public synchronized void setRange(String str, String str2, int i, int i2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setRange() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setRange(this.nativePtr, str, str2, i, i2);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setSkipFlagForEntry(String str, String str2, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSkipFlagForEntry() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setSkipFlagForEntry(this.nativePtr, str, str2, z);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setSkipFlagForSection(String str, boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSkipFlagForSection() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSkipFlagForSection(this.nativePtr, str, z);
    }

    @Override // org.linphone.core.Config
    public synchronized void setString(String str, String str2, String str3) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setString() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setString(this.nativePtr, str, str2, str3);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized void setStringList(String str, String str2, String[] strArr) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setStringList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            setStringList(this.nativePtr, str, str2, strArr);
        }
    }

    @Override // org.linphone.core.Config
    public synchronized int sync() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call sync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return sync(this.nativePtr);
    }

    @Override // org.linphone.core.Config
    public synchronized void writeRelativeFile(String str, String str2) {
        writeRelativeFile(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.Config
    public synchronized Config newFromBuffer(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newFromBuffer() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newFromBuffer(this.nativePtr, str);
    }

    @Override // org.linphone.core.Config
    public synchronized Config newWithFactory(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call newWithFactory() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return newWithFactory(this.nativePtr, str, str2);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.Config
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.Config
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.Config
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
