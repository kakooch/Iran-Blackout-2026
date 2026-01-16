package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.livekit.android.events.RoomEvent;
import io.livekit.android.room.participant.Participant;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC5072Ht7;
import java.lang.ref.WeakReference;
import livekit.LivekitModels$TrackInfo;

/* renamed from: ir.nasim.Gt7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC4838Gt7 {
    static final /* synthetic */ InterfaceC5239Im3[] n = {AbstractC10882cM5.f(new C5942Lm4(AbstractC4838Gt7.class, "track", "getTrack()Lio/livekit/android/room/track/Track;", 0)), AbstractC10882cM5.f(new C5942Lm4(AbstractC4838Gt7.class, "muted", "getMuted()Z", 0))};
    private final C9927an4 a;
    private String b;
    private String c;
    private AbstractC21649tt7.f d;
    private final C9080Yk0 e;
    private final InterfaceC7983Ua2 f;
    private final C9927an4 g;
    private Boolean h;
    private AbstractC21649tt7.e i;
    private AbstractC21649tt7.g j;
    private String k;
    private LivekitModels$TrackInfo l;
    private WeakReference m;

    public AbstractC4838Gt7(LivekitModels$TrackInfo livekitModels$TrackInfo, AbstractC21649tt7 abstractC21649tt7, Participant participant) {
        AbstractC13042fc3.i(livekitModels$TrackInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(participant, "participant");
        this.a = AbstractC5508Jq2.c(abstractC21649tt7, null, 2, null);
        C9080Yk0 c9080Yk0 = new C9080Yk0();
        this.e = c9080Yk0;
        this.f = c9080Yk0.e();
        this.g = AbstractC5508Jq2.c(Boolean.FALSE, null, 2, null);
        this.j = AbstractC21649tt7.g.a;
        String sid = livekitModels$TrackInfo.getSid();
        AbstractC13042fc3.h(sid, "getSid(...)");
        this.c = sid;
        String name = livekitModels$TrackInfo.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        this.b = name;
        AbstractC21649tt7.f.a aVar = AbstractC21649tt7.f.Companion;
        EnumC10201bF3 type = livekitModels$TrackInfo.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        this.d = aVar.a(type);
        this.m = new WeakReference(participant);
        m(livekitModels$TrackInfo);
    }

    public final AbstractC21649tt7.f a() {
        return this.d;
    }

    public boolean b() {
        return ((Boolean) this.g.h(this, n[1])).booleanValue();
    }

    public final String c() {
        return this.b;
    }

    public final WeakReference d() {
        return this.m;
    }

    public final String e() {
        return this.c;
    }

    public final AbstractC21649tt7.g f() {
        return this.j;
    }

    public boolean g() {
        return h() != null;
    }

    public AbstractC21649tt7 h() {
        return (AbstractC21649tt7) this.a.h(this, n[0]);
    }

    public final LivekitModels$TrackInfo i() {
        return this.l;
    }

    public final void j(RoomEvent.TranscriptionReceived transcriptionReceived) {
        AbstractC13042fc3.i(transcriptionReceived, "transcription");
        if (AbstractC13042fc3.d(transcriptionReceived.getPublication(), this)) {
            this.e.f(new AbstractC5072Ht7.a(this, transcriptionReceived.getTranscriptionSegments()));
        }
    }

    public void k(boolean z) {
        this.g.i(this, n[1], Boolean.valueOf(z));
    }

    public void l(AbstractC21649tt7 abstractC21649tt7) {
        this.a.i(this, n[0], abstractC21649tt7);
    }

    public final void m(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        AbstractC13042fc3.i(livekitModels$TrackInfo, ParameterNames.INFO);
        String sid = livekitModels$TrackInfo.getSid();
        AbstractC13042fc3.h(sid, "getSid(...)");
        this.c = sid;
        String name = livekitModels$TrackInfo.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        this.b = name;
        AbstractC21649tt7.f.a aVar = AbstractC21649tt7.f.Companion;
        EnumC10201bF3 type = livekitModels$TrackInfo.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        this.d = aVar.a(type);
        k(livekitModels$TrackInfo.getMuted());
        AbstractC21649tt7.g.a aVar2 = AbstractC21649tt7.g.Companion;
        EnumC9607aF3 source = livekitModels$TrackInfo.getSource();
        AbstractC13042fc3.h(source, "getSource(...)");
        this.j = aVar2.a(source);
        if (this.d == AbstractC21649tt7.f.c) {
            this.h = Boolean.valueOf(livekitModels$TrackInfo.getSimulcast());
            this.i = new AbstractC21649tt7.e(livekitModels$TrackInfo.getWidth(), livekitModels$TrackInfo.getHeight());
        }
        this.k = livekitModels$TrackInfo.getMimeType();
        this.l = livekitModels$TrackInfo;
    }
}
