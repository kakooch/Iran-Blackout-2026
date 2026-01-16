package org.linphone.core;

/* loaded from: classes3.dex */
public interface CallStats {
    float getDownloadBandwidth();

    float getEstimatedDownloadBandwidth();

    IceState getIceState();

    AddressFamily getIpFamilyOfRemote();

    float getJitterBufferSizeMs();

    int getLatePacketsCumulativeNumber();

    float getLocalLateRate();

    float getLocalLossRate();

    long getNativePointer();

    float getReceiverInterarrivalJitter();

    float getReceiverLossRate();

    float getRoundTripDelay();

    float getRtcpDownloadBandwidth();

    float getRtcpUploadBandwidth();

    float getSenderInterarrivalJitter();

    float getSenderLossRate();

    StreamType getType();

    float getUploadBandwidth();

    UpnpState getUpnpState();

    Object getUserData();

    String getZrtpAuthTagAlgo();

    String getZrtpCipherAlgo();

    String getZrtpHashAlgo();

    String getZrtpKeyAgreementAlgo();

    String getZrtpSasAlgo();

    boolean isZrtpKeyAgreementAlgoPostQuantum();

    void setUserData(Object obj);

    String toString();
}
