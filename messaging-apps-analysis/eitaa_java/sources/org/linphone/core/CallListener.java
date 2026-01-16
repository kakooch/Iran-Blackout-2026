package org.linphone.core;

import org.linphone.core.Call;

/* loaded from: classes3.dex */
public interface CallListener {
    void onAckProcessing(Call call, Headers headers, boolean z);

    void onAudioDeviceChanged(Call call, AudioDevice audioDevice);

    void onCameraNotWorking(Call call, String str);

    void onDtmfReceived(Call call, int i);

    void onEncryptionChanged(Call call, boolean z, String str);

    void onGoclearAckSent(Call call);

    void onInfoMessageReceived(Call call, InfoMessage infoMessage);

    void onNextVideoFrameDecoded(Call call);

    void onReceiveMasterKeyChanged(Call call, String str);

    void onRemoteRecording(Call call, boolean z);

    void onSendMasterKeyChanged(Call call, String str);

    void onSnapshotTaken(Call call, String str);

    void onStateChanged(Call call, Call.State state, String str);

    void onStatsUpdated(Call call, CallStats callStats);

    void onTmmbrReceived(Call call, int i, int i2);

    void onTransferStateChanged(Call call, Call.State state);

    void onVideoDisplayErrorOccurred(Call call, int i);
}
