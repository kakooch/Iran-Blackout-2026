package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import livekit.LivekitRtc$TrackPublishedResponse;

/* loaded from: classes3.dex */
public abstract class YG3 {
    private static final List a = AbstractC10360bX0.p(CS7.b.j(), CS7.c.j());

    public static final boolean b(GV7 gv7) {
        AbstractC13042fc3.i(gv7, "<this>");
        C12373eW c12373eWA = gv7.a();
        return ((c12373eWA != null ? c12373eWA.a() : null) == null || AbstractC13042fc3.d(gv7.f(), gv7.a().a())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(String str) {
        return a.contains(str);
    }

    public static final List d(io.livekit.android.room.participant.a aVar) {
        AbstractC13042fc3.i(aVar, "<this>");
        Collection<AbstractC4838Gt7> collectionValues = aVar.r().values();
        ArrayList arrayList = new ArrayList();
        for (AbstractC4838Gt7 abstractC4838Gt7 : collectionValues) {
            AbstractC21649tt7 abstractC21649tt7H = abstractC4838Gt7.h();
            LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse = abstractC21649tt7H == null ? null : (LivekitRtc$TrackPublishedResponse) LivekitRtc$TrackPublishedResponse.newBuilder().A(abstractC21649tt7H.h().id()).B(abstractC4838Gt7.i()).a();
            if (livekitRtc$TrackPublishedResponse != null) {
                arrayList.add(livekitRtc$TrackPublishedResponse);
            }
        }
        return arrayList;
    }
}
