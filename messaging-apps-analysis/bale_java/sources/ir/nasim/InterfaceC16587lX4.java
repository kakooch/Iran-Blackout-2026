package ir.nasim;

import io.livekit.android.room.participant.Participant;

/* renamed from: ir.nasim.lX4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC16587lX4 {

    /* renamed from: ir.nasim.lX4$a */
    public static final class a {
        public static void a(InterfaceC16587lX4 interfaceC16587lX4, Participant participant) {
            AbstractC13042fc3.i(participant, "participant");
        }

        public static void b(InterfaceC16587lX4 interfaceC16587lX4, AN5 an5, io.livekit.android.room.participant.d dVar) {
            AbstractC13042fc3.i(an5, "publication");
            AbstractC13042fc3.i(dVar, "participant");
        }
    }

    void A(C20597sH3 c20597sH3, io.livekit.android.room.participant.a aVar);

    void B(AbstractC4838Gt7 abstractC4838Gt7, Participant participant);

    void C(AbstractC21649tt7 abstractC21649tt7, AN5 an5, io.livekit.android.room.participant.d dVar);

    void F(AN5 an5, io.livekit.android.room.participant.d dVar);

    void G(AN5 an5, io.livekit.android.room.participant.d dVar);

    void O(AbstractC21649tt7 abstractC21649tt7, AN5 an5, io.livekit.android.room.participant.d dVar);

    void q(Participant participant);

    void u(AbstractC4838Gt7 abstractC4838Gt7, Participant participant);

    void v(Participant participant, String str);

    void w(String str, Exception exc, io.livekit.android.room.participant.d dVar);

    void z(C20597sH3 c20597sH3, io.livekit.android.room.participant.a aVar);
}
