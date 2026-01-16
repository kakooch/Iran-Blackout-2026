package ir.nasim;

import ai.bale.proto.PresenceStruct$UserOffline;
import ai.bale.proto.PresenceStruct$UserOnline;
import ai.bale.proto.PresenceStruct$UserPresence;
import ir.nasim.PI7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class XI7 {
    private static final List e(Collection collection, UA2 ua2, UA2 ua22, UA2 ua23) {
        PresenceStruct$UserOnline userOnline;
        if (collection == null || collection.isEmpty()) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            PresenceStruct$UserPresence presenceStruct$UserPresence = (PresenceStruct$UserPresence) it.next();
            Object objInvoke = null;
            if (presenceStruct$UserPresence.hasUserOffline()) {
                PresenceStruct$UserOffline userOffline = presenceStruct$UserPresence.getUserOffline();
                if (userOffline != null) {
                    objInvoke = ua2.invoke(userOffline);
                }
            } else if (presenceStruct$UserPresence.hasUserOnline() && (userOnline = presenceStruct$UserPresence.getUserOnline()) != null) {
                objInvoke = ua22.invoke(userOnline);
            }
            if (objInvoke != null && (ua23 == null || ((Boolean) ua23.invoke(objInvoke)).booleanValue())) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final PI7 f(SI7 si7) {
        AbstractC13042fc3.i(si7, "<this>");
        return new PI7(PI7.a.j(si7.c()), si7.a(), C11458d25.r(si7.b()), si7.d());
    }

    public static final List g(Collection collection, UA2 ua2) {
        return e(collection, new UA2() { // from class: ir.nasim.VI7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XI7.i((PresenceStruct$UserOffline) obj);
            }
        }, new UA2() { // from class: ir.nasim.WI7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XI7.j((PresenceStruct$UserOnline) obj);
            }
        }, ua2);
    }

    public static /* synthetic */ List h(Collection collection, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            ua2 = null;
        }
        return g(collection, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PI7 i(PresenceStruct$UserOffline presenceStruct$UserOffline) {
        AbstractC13042fc3.i(presenceStruct$UserOffline, "it");
        return new PI7(PI7.a.OFFLINE, presenceStruct$UserOffline.getDate() != null ? presenceStruct$UserOffline.getDate().getValue() * 1000 : 0L, C11458d25.E(presenceStruct$UserOffline.getPeer().getUid()), presenceStruct$UserOffline.getUserLastSeenUnknown() == null || presenceStruct$UserOffline.getUserLastSeenUnknown().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PI7 j(PresenceStruct$UserOnline presenceStruct$UserOnline) {
        AbstractC13042fc3.i(presenceStruct$UserOnline, "it");
        return new PI7(PI7.a.ONLINE, AbstractC20507s76.p(), C11458d25.E(presenceStruct$UserOnline.getPeer().getUid()), false);
    }

    public static final List k(Collection collection, UA2 ua2) {
        return e(collection, new UA2() { // from class: ir.nasim.TI7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XI7.m((PresenceStruct$UserOffline) obj);
            }
        }, new UA2() { // from class: ir.nasim.UI7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XI7.n((PresenceStruct$UserOnline) obj);
            }
        }, ua2);
    }

    public static /* synthetic */ List l(Collection collection, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            ua2 = null;
        }
        return k(collection, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SI7 m(PresenceStruct$UserOffline presenceStruct$UserOffline) {
        AbstractC13042fc3.i(presenceStruct$UserOffline, "userOffline");
        return new SI7(presenceStruct$UserOffline.getPeer().getUid(), presenceStruct$UserOffline.getDate() != null ? presenceStruct$UserOffline.getDate().getValue() * 1000 : 0L, PI7.a.OFFLINE.p(), presenceStruct$UserOffline.getUserLastSeenUnknown() == null || presenceStruct$UserOffline.getUserLastSeenUnknown().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SI7 n(PresenceStruct$UserOnline presenceStruct$UserOnline) {
        AbstractC13042fc3.i(presenceStruct$UserOnline, "userOnline");
        return new SI7(presenceStruct$UserOnline.getPeer().getUid(), AbstractC20507s76.p(), PI7.a.ONLINE.p(), false);
    }
}
