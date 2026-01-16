package org.linphone.core;

import org.linphone.mediastream.Log;

/* compiled from: MagicSearch.java */
/* loaded from: classes3.dex */
class MagicSearchImpl implements MagicSearch {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, MagicSearchListener magicSearchListener);

    private native SearchResult[] getContactListFromFilter(long j, String str, String str2);

    private native void getContactListFromFilterAsync(long j, String str, String str2);

    private native SearchResult[] getContacts(long j, String str, String str2, int i);

    private native void getContactsAsync(long j, String str, String str2, int i);

    private native SearchResult[] getContactsList(long j, String str, String str2, int i, int i2);

    private native void getContactsListAsync(long j, String str, String str2, int i, int i2);

    private native String getDelimiter(long j);

    private native SearchResult[] getLastSearch(long j);

    private native boolean getLimitedSearch(long j);

    private native int getMaxWeight(long j);

    private native int getMinWeight(long j);

    private native int getSearchLimit(long j);

    private native boolean getUseDelimiter(long j);

    private native void removeListener(long j, MagicSearchListener magicSearchListener);

    private native void resetSearchCache(long j);

    private native void setDelimiter(long j, String str);

    private native void setLimitedSearch(long j, boolean z);

    private native void setMaxWeight(long j, int i);

    private native void setMinWeight(long j, int i);

    private native void setSearchLimit(long j, int i);

    private native void setUseDelimiter(long j, boolean z);

    private native boolean unref(long j, boolean z);

    protected MagicSearchImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.MagicSearch
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized String getDelimiter() {
        return getDelimiter(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setDelimiter(String str) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setDelimiter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setDelimiter(this.nativePtr, str);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized SearchResult[] getLastSearch() {
        return getLastSearch(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized boolean getLimitedSearch() {
        return getLimitedSearch(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setLimitedSearch(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setLimitedSearch() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setLimitedSearch(this.nativePtr, z);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized int getMaxWeight() {
        return getMaxWeight(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setMaxWeight(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMaxWeight() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMaxWeight(this.nativePtr, i);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized int getMinWeight() {
        return getMinWeight(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setMinWeight(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setMinWeight() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setMinWeight(this.nativePtr, i);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized int getSearchLimit() {
        return getSearchLimit(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setSearchLimit(int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setSearchLimit() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setSearchLimit(this.nativePtr, i);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized boolean getUseDelimiter() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getUseDelimiter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getUseDelimiter(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void setUseDelimiter(boolean z) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call setUseDelimiter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        setUseDelimiter(this.nativePtr, z);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized SearchResult[] getContactListFromFilter(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactListFromFilter() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getContactListFromFilter(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void getContactListFromFilterAsync(String str, String str2) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactListFromFilterAsync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        getContactListFromFilterAsync(this.nativePtr, str, str2);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized SearchResult[] getContacts(String str, String str2, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContacts() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getContacts(this.nativePtr, str, str2, i);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void getContactsAsync(String str, String str2, int i) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactsAsync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            getContactsAsync(this.nativePtr, str, str2, i);
        }
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized SearchResult[] getContactsList(String str, String str2, int i, MagicSearchAggregation magicSearchAggregation) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactsList() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        return getContactsList(this.nativePtr, str, str2, i, magicSearchAggregation.toInt());
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void getContactsListAsync(String str, String str2, int i, MagicSearchAggregation magicSearchAggregation) {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call getContactsListAsync() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        } else {
            getContactsListAsync(this.nativePtr, str, str2, i, magicSearchAggregation.toInt());
        }
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void resetSearchCache() {
        if (this._isConst) {
            try {
                throw new CoreException(toString() + " is const! If you want to call resetSearchCache() on it, clone it first.");
            } catch (CoreException e) {
                Log.e(e);
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    Log.e(stackTraceElement);
                }
            }
        }
        resetSearchCache(this.nativePtr);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void addListener(MagicSearchListener magicSearchListener) {
        addListener(this.nativePtr, magicSearchListener);
    }

    @Override // org.linphone.core.MagicSearch
    public synchronized void removeListener(MagicSearchListener magicSearchListener) {
        removeListener(this.nativePtr, magicSearchListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.MagicSearch
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.MagicSearch
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.MagicSearch
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
