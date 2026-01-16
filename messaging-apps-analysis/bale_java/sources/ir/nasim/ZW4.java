package ir.nasim;

import io.livekit.android.room.participant.Participant;
import io.livekit.android.room.track.TrackException;
import ir.nasim.AbstractC21649tt7;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class ZW4 extends AbstractC17794na2 {
    private final Participant a;

    public static final class a extends ZW4 {
        private final Map b;
        private final Map c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Participant participant, Map map, Map map2) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(map, "changedAttributes");
            AbstractC13042fc3.i(map2, "oldAttributes");
            this.b = map;
            this.c = map2;
        }

        public final Map getChangedAttributes() {
            return this.b;
        }

        public final Map getOldAttributes() {
            return this.c;
        }
    }

    public static final class b extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final byte[] c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(io.livekit.android.room.participant.d dVar, byte[] bArr, String str) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(bArr, "data");
            this.b = dVar;
            this.c = bArr;
            this.d = str;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class c extends ZW4 {
        private final io.livekit.android.room.participant.a b;
        private final AbstractC21649tt7 c;
        private final TrackException.PublishException d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(io.livekit.android.room.participant.a aVar, AbstractC21649tt7 abstractC21649tt7, TrackException.PublishException publishException) {
            super(aVar, null);
            AbstractC13042fc3.i(aVar, "participant");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(publishException, "e");
            this.b = aVar;
            this.c = abstractC21649tt7;
            this.d = publishException;
        }

        public final TrackException.PublishException a() {
            return this.d;
        }

        public final AbstractC21649tt7 getTrack() {
            return this.c;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.a getParticipant() {
            return this.b;
        }
    }

    public static final class d extends ZW4 {
        private final io.livekit.android.room.participant.a b;
        private final C20597sH3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(io.livekit.android.room.participant.a aVar, C20597sH3 c20597sH3) {
            super(aVar, null);
            AbstractC13042fc3.i(aVar, "participant");
            AbstractC13042fc3.i(c20597sH3, "publication");
            this.b = aVar;
            this.c = c20597sH3;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.a getParticipant() {
            return this.b;
        }
    }

    public static final class e extends ZW4 {
        private final io.livekit.android.room.participant.a b;
        private final C20597sH3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(io.livekit.android.room.participant.a aVar, C20597sH3 c20597sH3) {
            super(aVar, null);
            AbstractC13042fc3.i(aVar, "participant");
            AbstractC13042fc3.i(c20597sH3, "publication");
            this.b = aVar;
            this.c = c20597sH3;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.a getParticipant() {
            return this.b;
        }
    }

    public static final class f extends ZW4 {
        private final io.livekit.android.room.participant.a b;
        private final C20597sH3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(io.livekit.android.room.participant.a aVar, C20597sH3 c20597sH3) {
            super(aVar, null);
            AbstractC13042fc3.i(aVar, "participant");
            AbstractC13042fc3.i(c20597sH3, "publication");
            this.b = aVar;
            this.c = c20597sH3;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.a getParticipant() {
            return this.b;
        }
    }

    public static final class g extends ZW4 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Participant participant, String str) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            this.b = str;
        }

        public final String getPrevMetadata() {
            return this.b;
        }
    }

    public static final class h extends ZW4 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Participant participant, String str) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            this.b = str;
        }

        public final String getName() {
            return this.b;
        }
    }

    public static final class i extends ZW4 {
        private final Participant b;
        private final io.livekit.android.room.participant.c c;
        private final io.livekit.android.room.participant.c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Participant participant, io.livekit.android.room.participant.c cVar, io.livekit.android.room.participant.c cVar2) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            this.b = participant;
            this.c = cVar;
            this.d = cVar2;
        }

        public final io.livekit.android.room.participant.c getNewPermissions() {
            return this.c;
        }

        public final io.livekit.android.room.participant.c getOldPermissions() {
            return this.d;
        }

        @Override // ir.nasim.ZW4
        public Participant getParticipant() {
            return this.b;
        }
    }

    public static final class j extends ZW4 {
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Participant participant, boolean z) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            this.b = z;
        }
    }

    public static final class k extends ZW4 {
        private final Participant b;
        private final Participant.b c;
        private final Participant.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Participant participant, Participant.b bVar, Participant.b bVar2) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(bVar, "newState");
            AbstractC13042fc3.i(bVar2, "oldState");
            this.b = participant;
            this.c = bVar;
            this.d = bVar2;
        }

        public final Participant.b getNewState() {
            return this.c;
        }

        public final Participant.b getOldState() {
            return this.d;
        }

        @Override // ir.nasim.ZW4
        public Participant getParticipant() {
            return this.b;
        }
    }

    public static final class l extends ZW4 {
        private final AbstractC4838Gt7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Participant participant, AbstractC4838Gt7 abstractC4838Gt7) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            this.b = abstractC4838Gt7;
        }
    }

    public static final class m extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final AN5 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(io.livekit.android.room.participant.d dVar, AN5 an5) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(an5, "publication");
            this.b = dVar;
            this.c = an5;
        }

        public final AN5 a() {
            return this.c;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class n extends ZW4 {
        private final Participant b;
        private final AbstractC4838Gt7 c;
        private final AbstractC21649tt7.h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Participant participant, AbstractC4838Gt7 abstractC4838Gt7, AbstractC21649tt7.h hVar) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(abstractC4838Gt7, "trackPublication");
            AbstractC13042fc3.i(hVar, "streamState");
            this.b = participant;
            this.c = abstractC4838Gt7;
            this.d = hVar;
        }

        @Override // ir.nasim.ZW4
        public Participant getParticipant() {
            return this.b;
        }

        public final AbstractC21649tt7.h getStreamState() {
            return this.d;
        }

        public final AbstractC4838Gt7 getTrackPublication() {
            return this.c;
        }
    }

    public static final class o extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final AbstractC21649tt7 c;
        private final AN5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(io.livekit.android.room.participant.d dVar, AbstractC21649tt7 abstractC21649tt7, AN5 an5) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(an5, "publication");
            this.b = dVar;
            this.c = abstractC21649tt7;
            this.d = an5;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class p extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final String c;
        private final Exception d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(io.livekit.android.room.participant.d dVar, String str, Exception exc) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(str, "sid");
            AbstractC13042fc3.i(exc, "exception");
            this.b = dVar;
            this.c = str;
            this.d = exc;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class q extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final AN5 c;
        private final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(io.livekit.android.room.participant.d dVar, AN5 an5, boolean z) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(an5, "trackPublication");
            this.b = dVar;
            this.c = an5;
            this.d = z;
        }

        public final boolean getSubscriptionAllowed() {
            return this.d;
        }

        public final AN5 getTrackPublication() {
            return this.c;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class r extends ZW4 {
        private final AbstractC4838Gt7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Participant participant, AbstractC4838Gt7 abstractC4838Gt7) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            this.b = abstractC4838Gt7;
        }
    }

    public static final class s extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final AN5 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(io.livekit.android.room.participant.d dVar, AN5 an5) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(an5, "publication");
            this.b = dVar;
            this.c = an5;
        }

        public final AN5 a() {
            return this.c;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class t extends ZW4 {
        private final io.livekit.android.room.participant.d b;
        private final AbstractC21649tt7 c;
        private final AN5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(io.livekit.android.room.participant.d dVar, AbstractC21649tt7 abstractC21649tt7, AN5 an5) {
            super(dVar, null);
            AbstractC13042fc3.i(dVar, "participant");
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(an5, "publication");
            this.b = dVar;
            this.c = abstractC21649tt7;
            this.d = an5;
        }

        @Override // ir.nasim.ZW4
        public io.livekit.android.room.participant.d getParticipant() {
            return this.b;
        }
    }

    public static final class u extends ZW4 {
        private final Participant b;
        private final List c;
        private final AbstractC4838Gt7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(Participant participant, List list, AbstractC4838Gt7 abstractC4838Gt7) {
            super(participant, null);
            AbstractC13042fc3.i(participant, "participant");
            AbstractC13042fc3.i(list, "transcriptions");
            this.b = participant;
            this.c = list;
            this.d = abstractC4838Gt7;
        }

        @Override // ir.nasim.ZW4
        public Participant getParticipant() {
            return this.b;
        }
    }

    public /* synthetic */ ZW4(Participant participant, ED1 ed1) {
        this(participant);
    }

    public Participant getParticipant() {
        return this.a;
    }

    private ZW4(Participant participant) {
        super(null);
        this.a = participant;
    }
}
