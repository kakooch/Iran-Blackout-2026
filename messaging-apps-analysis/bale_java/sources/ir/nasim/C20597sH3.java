package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.concurrent.ExecutionException;
import livekit.LivekitModels$TrackInfo;

/* renamed from: ir.nasim.sH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20597sH3 extends AbstractC4838Gt7 {
    private final InterfaceC5306It7 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20597sH3(LivekitModels$TrackInfo livekitModels$TrackInfo, AbstractC21649tt7 abstractC21649tt7, io.livekit.android.room.participant.a aVar, InterfaceC5306It7 interfaceC5306It7) {
        super(livekitModels$TrackInfo, abstractC21649tt7, aVar);
        AbstractC13042fc3.i(livekitModels$TrackInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(abstractC21649tt7, "track");
        AbstractC13042fc3.i(aVar, "participant");
        AbstractC13042fc3.i(interfaceC5306It7, "options");
        this.o = interfaceC5306It7;
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public boolean b() {
        return super.b();
    }

    public final InterfaceC5306It7 n() {
        return this.o;
    }

    @Override // ir.nasim.AbstractC4838Gt7
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void k(boolean z) throws ExecutionException, InterruptedException {
        AbstractC21649tt7 abstractC21649tt7H;
        if (z == b() || (abstractC21649tt7H = h()) == null) {
            return;
        }
        abstractC21649tt7H.k(!z);
        super.k(z);
        Object obj = d().get();
        io.livekit.android.room.participant.a aVar = obj instanceof io.livekit.android.room.participant.a ? (io.livekit.android.room.participant.a) obj : null;
        if (aVar == null) {
            return;
        }
        aVar.p0().V0(e(), z);
        if (z) {
            aVar.w(this);
        } else {
            aVar.y(this);
        }
    }
}
