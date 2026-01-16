package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import ir.nasim.AbstractC14721iN;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.qP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19465qP extends AbstractC24073y0 {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19465qP(Context context, boolean z, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, List list) {
        this(context, onAudioFocusChangeListener, new C17386ms5(z), list, null, null, null, null, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(onAudioFocusChangeListener, "audioFocusChangeListener");
        AbstractC13042fc3.i(list, "preferredDeviceList");
    }

    @Override // ir.nasim.InterfaceC20791sc6.a
    public void b(AbstractC14721iN abstractC14721iN) {
        AbstractC13042fc3.i(abstractC14721iN, "audioDevice");
        l().a("AudioSwitch", "onDeviceDisconnected(" + abstractC14721iN + ')');
        boolean zRemove = j().remove(abstractC14721iN);
        if (AbstractC13042fc3.d(o(), abstractC14721iN)) {
            B(null);
        }
        if ((abstractC14721iN instanceof AbstractC14721iN.d) && g().e()) {
            zRemove = j().add(new AbstractC14721iN.b(null, 1, null)) || zRemove;
        }
        AbstractC24073y0.t(this, zRemove, null, 2, null);
    }

    @Override // ir.nasim.AbstractC24073y0
    protected void q(AbstractC14721iN abstractC14721iN) {
        AbstractC13042fc3.i(abstractC14721iN, "audioDevice");
        l().a("AudioSwitch", "onActivate(" + abstractC14721iN + ')');
        if (abstractC14721iN instanceof AbstractC14721iN.a) {
            g().c(false);
            g().b(true);
        } else if ((abstractC14721iN instanceof AbstractC14721iN.b) || (abstractC14721iN instanceof AbstractC14721iN.d)) {
            g().c(false);
            g().b(false);
        } else if (abstractC14721iN instanceof AbstractC14721iN.c) {
            g().b(false);
            g().c(true);
        }
    }

    @Override // ir.nasim.AbstractC24073y0
    protected void r() {
        l().a("AudioSwitch", "onDeactivate");
        if (n() instanceof AbstractC14721iN.a) {
            g().b(false);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C19465qP(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, NI3 ni3, List list, AudioManager audioManager, C17083mN c17083mN, Handler handler, InterfaceC20791sc6 interfaceC20791sc6, int i, ED1 ed1) {
        AudioManager audioManager2;
        if ((i & 16) != 0) {
            Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            }
            audioManager2 = (AudioManager) systemService;
        } else {
            audioManager2 = audioManager;
        }
        C17083mN c17083mN2 = (i & 32) != 0 ? new C17083mN(context, ni3, audioManager2, null, null, onAudioFocusChangeListener, 24, null) : c17083mN;
        Handler handler2 = (i & 64) != 0 ? new Handler(Looper.getMainLooper()) : handler;
        this(context, onAudioFocusChangeListener, ni3, list, audioManager2, c17083mN2, handler2, (i & 128) != 0 ? new C18856pN(audioManager2, handler2) : interfaceC20791sc6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19465qP(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, NI3 ni3, List list, AudioManager audioManager, C17083mN c17083mN, Handler handler, InterfaceC20791sc6 interfaceC20791sc6) {
        super(context, onAudioFocusChangeListener, interfaceC20791sc6, false, ni3, list, c17083mN, 8, null);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(onAudioFocusChangeListener, "audioFocusChangeListener");
        AbstractC13042fc3.i(ni3, "logger");
        AbstractC13042fc3.i(list, "preferredDeviceList");
        AbstractC13042fc3.i(audioManager, "audioManager");
        AbstractC13042fc3.i(c17083mN, "audioDeviceManager");
        AbstractC13042fc3.i(handler, "handler");
        AbstractC13042fc3.i(interfaceC20791sc6, "scanner");
    }
}
