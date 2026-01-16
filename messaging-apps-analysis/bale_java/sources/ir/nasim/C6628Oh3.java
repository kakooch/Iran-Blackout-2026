package ir.nasim;

import livekit.org.webrtc.audio.JavaAudioDeviceModule;

/* renamed from: ir.nasim.Oh3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6628Oh3 implements IO {
    private final JavaAudioDeviceModule a;

    public C6628Oh3(JavaAudioDeviceModule javaAudioDeviceModule) {
        AbstractC13042fc3.i(javaAudioDeviceModule, "audioDeviceModule");
        this.a = javaAudioDeviceModule;
    }

    @Override // ir.nasim.IO
    public void a() {
        this.a.prewarmRecording();
    }

    @Override // ir.nasim.IO
    public void stop() {
        this.a.requestStopRecording();
    }
}
