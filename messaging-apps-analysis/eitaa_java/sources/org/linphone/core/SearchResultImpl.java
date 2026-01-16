package org.linphone.core;

/* compiled from: SearchResult.java */
/* loaded from: classes3.dex */
class SearchResultImpl implements SearchResult {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native Address getAddress(long j);

    private native int getCapabilities(long j);

    private native Friend getFriend(long j);

    private native String getPhoneNumber(long j);

    private native int getSourceFlags(long j);

    private native int getWeight(long j);

    private native boolean hasCapability(long j, int i);

    private native boolean unref(long j, boolean z);

    protected SearchResultImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.SearchResult
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.SearchResult
    public synchronized Address getAddress() {
        return getAddress(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized int getCapabilities() {
        return getCapabilities(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized Friend getFriend() {
        return getFriend(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized String getPhoneNumber() {
        return getPhoneNumber(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized int getSourceFlags() {
        return getSourceFlags(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized int getWeight() {
        return getWeight(this.nativePtr);
    }

    @Override // org.linphone.core.SearchResult
    public synchronized boolean hasCapability(FriendCapability friendCapability) {
        return hasCapability(this.nativePtr, friendCapability.toInt());
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.SearchResult
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.SearchResult
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.SearchResult
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
