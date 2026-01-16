package org.linphone.core;

import org.linphone.core.Call;

/* loaded from: classes3.dex */
public class CallListenerStub implements CallListener {
    @Override // org.linphone.core.CallListener
    public void onAckProcessing(Call call, Headers headers, boolean z) {
    }

    @Override // org.linphone.core.CallListener
    public void onAudioDeviceChanged(Call call, AudioDevice audioDevice) {
    }

    @Override // org.linphone.core.CallListener
    public void onCameraNotWorking(Call call, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onDtmfReceived(Call call, int i) {
    }

    @Override // org.linphone.core.CallListener
    public void onEncryptionChanged(Call call, boolean z, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onGoclearAckSent(Call call) {
    }

    @Override // org.linphone.core.CallListener
    public void onInfoMessageReceived(Call call, InfoMessage infoMessage) {
    }

    @Override // org.linphone.core.CallListener
    public void onNextVideoFrameDecoded(Call call) {
    }

    @Override // org.linphone.core.CallListener
    public void onReceiveMasterKeyChanged(Call call, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onRemoteRecording(Call call, boolean z) {
    }

    @Override // org.linphone.core.CallListener
    public void onSendMasterKeyChanged(Call call, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onSnapshotTaken(Call call, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onStateChanged(Call call, Call.State state, String str) {
    }

    @Override // org.linphone.core.CallListener
    public void onStatsUpdated(Call call, CallStats callStats) {
    }

    @Override // org.linphone.core.CallListener
    public void onTmmbrReceived(Call call, int i, int i2) {
    }

    @Override // org.linphone.core.CallListener
    public void onTransferStateChanged(Call call, Call.State state) {
    }

    @Override // org.linphone.core.CallListener
    public void onVideoDisplayErrorOccurred(Call call, int i) {
    }
}
