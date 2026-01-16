package org.linphone.core;

/* compiled from: CallStats.java */
/* loaded from: classes3.dex */
class CallStatsImpl implements CallStats {
    protected boolean _isConst;
    protected long nativePtr;
    protected transient Object userData = null;

    private native float getDownloadBandwidth(long j);

    private native float getEstimatedDownloadBandwidth(long j);

    private native int getIceState(long j);

    private native int getIpFamilyOfRemote(long j);

    private native float getJitterBufferSizeMs(long j);

    private native int getLatePacketsCumulativeNumber(long j);

    private native float getLocalLateRate(long j);

    private native float getLocalLossRate(long j);

    private native float getReceiverInterarrivalJitter(long j);

    private native float getReceiverLossRate(long j);

    private native float getRoundTripDelay(long j);

    private native float getRtcpDownloadBandwidth(long j);

    private native float getRtcpUploadBandwidth(long j);

    private native float getSenderInterarrivalJitter(long j);

    private native float getSenderLossRate(long j);

    private native int getType(long j);

    private native float getUploadBandwidth(long j);

    private native int getUpnpState(long j);

    private native String getZrtpAuthTagAlgo(long j);

    private native String getZrtpCipherAlgo(long j);

    private native String getZrtpHashAlgo(long j);

    private native String getZrtpKeyAgreementAlgo(long j);

    private native String getZrtpSasAlgo(long j);

    private native boolean isZrtpKeyAgreementAlgoPostQuantum(long j);

    private native boolean unref(long j, boolean z);

    protected CallStatsImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this._isConst = false;
        this.nativePtr = j;
        this._isConst = z;
    }

    @Override // org.linphone.core.CallStats
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getDownloadBandwidth() {
        return getDownloadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getEstimatedDownloadBandwidth() {
        return getEstimatedDownloadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized IceState getIceState() {
        return IceState.fromInt(getIceState(this.nativePtr));
    }

    @Override // org.linphone.core.CallStats
    public synchronized AddressFamily getIpFamilyOfRemote() {
        return AddressFamily.fromInt(getIpFamilyOfRemote(this.nativePtr));
    }

    @Override // org.linphone.core.CallStats
    public synchronized boolean isZrtpKeyAgreementAlgoPostQuantum() {
        return isZrtpKeyAgreementAlgoPostQuantum(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getJitterBufferSizeMs() {
        return getJitterBufferSizeMs(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized int getLatePacketsCumulativeNumber() {
        return getLatePacketsCumulativeNumber(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getLocalLateRate() {
        return getLocalLateRate(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getLocalLossRate() {
        return getLocalLossRate(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getReceiverInterarrivalJitter() {
        return getReceiverInterarrivalJitter(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getReceiverLossRate() {
        return getReceiverLossRate(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getRoundTripDelay() {
        return getRoundTripDelay(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getRtcpDownloadBandwidth() {
        return getRtcpDownloadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getRtcpUploadBandwidth() {
        return getRtcpUploadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getSenderInterarrivalJitter() {
        return getSenderInterarrivalJitter(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getSenderLossRate() {
        return getSenderLossRate(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized StreamType getType() {
        return StreamType.fromInt(getType(this.nativePtr));
    }

    @Override // org.linphone.core.CallStats
    public synchronized float getUploadBandwidth() {
        return getUploadBandwidth(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized UpnpState getUpnpState() {
        return UpnpState.fromInt(getUpnpState(this.nativePtr));
    }

    @Override // org.linphone.core.CallStats
    public synchronized String getZrtpAuthTagAlgo() {
        return getZrtpAuthTagAlgo(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized String getZrtpCipherAlgo() {
        return getZrtpCipherAlgo(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized String getZrtpHashAlgo() {
        return getZrtpHashAlgo(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized String getZrtpKeyAgreementAlgo() {
        return getZrtpKeyAgreementAlgo(this.nativePtr);
    }

    @Override // org.linphone.core.CallStats
    public synchronized String getZrtpSasAlgo() {
        return getZrtpSasAlgo(this.nativePtr);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.CallStats
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.CallStats
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.CallStats
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
