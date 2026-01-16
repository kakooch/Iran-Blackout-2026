package ir.nasim;

import ir.nasim.C11655dN5;
import ir.nasim.CN5;
import livekit.LivekitModels$ParticipantInfo;

/* renamed from: ir.nasim.wN5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23116wN5 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;

    public C23116wN5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
    }

    public static C23116wN5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        return new C23116wN5(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55);
    }

    public static io.livekit.android.room.participant.d c(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo, io.livekit.android.room.l lVar, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C11655dN5.a aVar, CN5.a aVar2) {
        return new io.livekit.android.room.participant.d(livekitModels$ParticipantInfo, lVar, abstractC13778go1, abstractC13778go12, aVar, aVar2);
    }

    public io.livekit.android.room.participant.d b(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        return c(livekitModels$ParticipantInfo, (io.livekit.android.room.l) this.a.get(), (AbstractC13778go1) this.b.get(), (AbstractC13778go1) this.c.get(), (C11655dN5.a) this.d.get(), (CN5.a) this.e.get());
    }
}
