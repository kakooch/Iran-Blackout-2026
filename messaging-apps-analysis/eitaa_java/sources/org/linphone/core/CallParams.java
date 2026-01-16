package org.linphone.core;

/* loaded from: classes3.dex */
public interface CallParams {
    void addCustomContent(Content content);

    void addCustomHeader(String str, String str2);

    void addCustomSdpAttribute(String str, String str2);

    void addCustomSdpMediaAttribute(StreamType streamType, String str, String str2);

    void clearCustomSdpAttributes();

    void clearCustomSdpMediaAttributes(StreamType streamType);

    CallParams copy();

    Account getAccount();

    MediaDirection getAudioDirection();

    ConferenceLayout getConferenceVideoLayout();

    Content[] getCustomContents();

    String getCustomHeader(String str);

    String getCustomSdpAttribute(String str);

    String getCustomSdpMediaAttribute(StreamType streamType, String str);

    String getFromHeader();

    AudioDevice getInputAudioDevice();

    boolean getLocalConferenceMode();

    MediaEncryption getMediaEncryption();

    long getNativePointer();

    AudioDevice getOutputAudioDevice();

    int getPrivacy();

    @Deprecated
    ProxyConfig getProxyConfig();

    int getRealtimeTextKeepaliveInterval();

    float getReceivedFramerate();

    VideoDefinition getReceivedVideoDefinition();

    String getRecordFile();

    String getRtpProfile();

    float getSentFramerate();

    VideoDefinition getSentVideoDefinition();

    String getSessionName();

    SrtpSuite[] getSrtpSuites();

    PayloadType getUsedAudioPayloadType();

    PayloadType getUsedTextPayloadType();

    PayloadType getUsedVideoPayloadType();

    Object getUserData();

    MediaDirection getVideoDirection();

    boolean hasCustomSdpAttribute(String str);

    boolean hasCustomSdpMediaAttribute(StreamType streamType, String str);

    boolean isAudioEnabled();

    boolean isAudioMulticastEnabled();

    boolean isAvpfEnabled();

    @Deprecated
    boolean isCapabilityNegotiationReinviteEnabled();

    boolean isCapabilityNegotiationsEnabled();

    boolean isEarlyMediaSendingEnabled();

    boolean isLowBandwidthEnabled();

    boolean isMediaEncryptionSupported(MediaEncryption mediaEncryption);

    boolean isMicEnabled();

    boolean isRealtimeTextEnabled();

    boolean isRecording();

    boolean isRtpBundleEnabled();

    boolean isToneIndicationsEnabled();

    boolean isVideoEnabled();

    boolean isVideoMulticastEnabled();

    void setAccount(Account account);

    void setAudioBandwidthLimit(int i);

    void setAudioDirection(MediaDirection mediaDirection);

    void setAudioEnabled(boolean z);

    void setAudioMulticastEnabled(boolean z);

    void setAvpfEnabled(boolean z);

    void setCapabilityNegotiationReinviteEnabled(boolean z);

    void setCapabilityNegotiationsEnabled(boolean z);

    void setConferenceVideoLayout(ConferenceLayout conferenceLayout);

    void setEarlyMediaSendingEnabled(boolean z);

    void setFromHeader(String str);

    void setInputAudioDevice(AudioDevice audioDevice);

    void setLowBandwidthEnabled(boolean z);

    void setMediaEncryption(MediaEncryption mediaEncryption);

    void setMicEnabled(boolean z);

    void setOutputAudioDevice(AudioDevice audioDevice);

    void setPrivacy(int i);

    @Deprecated
    void setProxyConfig(ProxyConfig proxyConfig);

    int setRealtimeTextEnabled(boolean z);

    void setRealtimeTextKeepaliveInterval(int i);

    void setRecordFile(String str);

    @Deprecated
    void setRtpBundleEnabled(boolean z);

    void setSessionName(String str);

    void setSrtpSuites(SrtpSuite[] srtpSuiteArr);

    void setTcapLineMergingEnabled(boolean z);

    void setToneIndicationsEnabled(boolean z);

    void setUserData(Object obj);

    void setVideoDirection(MediaDirection mediaDirection);

    void setVideoEnabled(boolean z);

    void setVideoMulticastEnabled(boolean z);

    boolean tcapLinesMerged();

    String toString();
}
