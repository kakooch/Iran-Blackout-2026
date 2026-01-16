package ir.nasim;

import ir.nasim.AbstractC21649tt7;
import livekit.org.webrtc.AudioTrack;

/* renamed from: ir.nasim.wP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23128wP extends AbstractC21649tt7 {
    private final AudioTrack k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC23128wP(String str, AudioTrack audioTrack, FF5 ff5) {
        super(str, AbstractC21649tt7.f.b, audioTrack, ff5);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(audioTrack, "rtcTrack");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.k = audioTrack;
    }

    @Override // ir.nasim.AbstractC21649tt7
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public AudioTrack h() {
        return this.k;
    }
}
