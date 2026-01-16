package ir.nasim.features.firebase;

import android.gov.nist.javax.sip.parser.TokenNames;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC19562qZ6;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC4398Ey5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C13923h3;
import ir.nasim.C19406qI3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C92;
import ir.nasim.InterfaceC15767k82;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KD4;
import ir.nasim.LH4;
import ir.nasim.SA2;
import ir.nasim.VE4;
import ir.nasim.XV4;
import ir.nasim.features.firebase.BaleFirebaseMessagingService;
import ir.nasim.features.firebase.newPush.usecase.DecryptAndParsPushDataUseCase;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\t\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00142\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lir/nasim/features/firebase/BaleFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "", "", "remoteData", "Lir/nasim/XV4;", "", "x", "(Ljava/util/Map;)Lir/nasim/XV4;", "Lir/nasim/Ey5;", "pushNotification", "Lir/nasim/VE4;", "notificationsModule", "ownerId", "data", "Lir/nasim/rB7;", "A", "(Lir/nasim/Ey5;Lir/nasim/VE4;ILjava/util/Map;)V", "", "D", "(I)Z", "pushType", TokenNames.F, "(Ljava/lang/String;)Z", TokenNames.E, "(Ljava/util/Map;)Z", "token", "s", "(Ljava/lang/String;)V", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "q", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "Lir/nasim/LH4;", "g", "Lir/nasim/Yu3;", "y", "()Lir/nasim/LH4;", "oldPushHandler", "Lir/nasim/features/firebase/newPush/usecase/DecryptAndParsPushDataUseCase;", "h", "z", "()Lir/nasim/features/firebase/newPush/usecase/DecryptAndParsPushDataUseCase;", "parsingUseCase", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BaleFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 oldPushHandler = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UZ
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return BaleFirebaseMessagingService.B();
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 parsingUseCase = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VZ
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return BaleFirebaseMessagingService.C();
        }
    });

    private final void A(AbstractC4398Ey5 pushNotification, VE4 notificationsModule, int ownerId, Map data) {
        if (KD4.a(pushNotification.c())) {
            String str = (String) data.get("messageDate");
            notificationsModule.G(ownerId, str != null ? Long.parseLong(str) : 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LH4 B() {
        return new LH4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecryptAndParsPushDataUseCase C() {
        return ((InterfaceC15767k82) C92.a(C5721Ko.a.d(), InterfaceC15767k82.class)).F0();
    }

    private final boolean D(int ownerId) {
        C5495Jo7.l1(C5721Ko.a.d());
        if (ownerId == 0) {
            C19406qI3.a("PushManager", "Push received # remoteMessage.data.owner_id not existed, so return!", new Object[0]);
            return true;
        }
        if (C13923h3.a.o().contains(String.valueOf(ownerId))) {
            return false;
        }
        C19406qI3.a("PushManager", "Push received # owner_id not existed in login users, so return!", new Object[0]);
        return true;
    }

    private final boolean E(Map data) {
        return data.containsKey("peer_user_id") || data.containsKey("update_peer_user_id") || data.containsKey("pushType");
    }

    private final boolean F(String pushType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TokenNames.MESSAGE);
        arrayList.add("MENTION");
        arrayList.add("REPLY");
        arrayList.add("EDIT");
        arrayList.add("DELETE");
        arrayList.add("READ");
        arrayList.add("REACTION");
        arrayList.add("COMMENT_REPLY");
        return pushType != null && arrayList.contains(pushType);
    }

    private final XV4 x(Map remoteData) {
        Integer numO;
        String str = (String) remoteData.get("data");
        if (str == null) {
            str = "";
        }
        String str2 = (String) remoteData.get("owner_id");
        int iIntValue = (str2 == null || (numO = AbstractC19562qZ6.o(str2)) == null) ? 0 : numO.intValue();
        return (str.length() != 0 || iIntValue == 0) ? z().c(str) : AbstractC4616Fw7.a(remoteData, Integer.valueOf(iIntValue));
    }

    private final LH4 y() {
        return (LH4) this.oldPushHandler.getValue();
    }

    private final DecryptAndParsPushDataUseCase z() {
        return (DecryptAndParsPushDataUseCase) this.parsingUseCase.getValue();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void q(RemoteMessage remoteMessage) throws NumberFormatException {
        AbstractC13042fc3.i(remoteMessage, "remoteMessage");
        C19406qI3.a("PushManager", "onMessageReceived called!", new Object[0]);
        C5735Kp4.w().D();
        try {
            Map mapP = remoteMessage.P();
            AbstractC13042fc3.h(mapP, "getData(...)");
            XV4 xv4X = x(mapP);
            Map map = (Map) xv4X.a();
            int iIntValue = ((Number) xv4X.b()).intValue();
            if (D(iIntValue)) {
                C19406qI3.a("PushManager", "onMessageReceived: return because of shouldIgnorePush!", new Object[0]);
                return;
            }
            if (E(map)) {
                C19406qI3.a("PushManager", "Push received # use new push", new Object[0]);
                if (!map.containsKey("pushType")) {
                    C19406qI3.a("PushManager", "Push received # with no pushType, so return!", new Object[0]);
                    return;
                }
                C19406qI3.a("PushManager", "Push received # pushType: " + map.get("pushType"), new Object[0]);
                VE4 ve4K = AbstractC5969Lp4.d().o2().K();
                if (C13923h3.a.m() != iIntValue) {
                    AbstractC4398Ey5 abstractC4398Ey5C = AbstractC4398Ey5.a.c(map);
                    if (abstractC4398Ey5C == null) {
                        C19406qI3.j("PushManager", "Received push from other account is null (after conversion), so return!", new Object[0]);
                        return;
                    } else {
                        AbstractC13042fc3.f(ve4K);
                        A(abstractC4398Ey5C, ve4K, iIntValue, map);
                    }
                } else if (F((String) map.get("pushType"))) {
                    C19406qI3.a("PushManager", "onPushReceived from Firebase", new Object[0]);
                    AbstractC4398Ey5 abstractC4398Ey5C2 = AbstractC4398Ey5.a.c(map);
                    if (abstractC4398Ey5C2 == null) {
                        C19406qI3.j("PushManager", "Received push is null (after conversion), so return!", new Object[0]);
                        return;
                    }
                    ve4K.I(abstractC4398Ey5C2);
                } else {
                    C19406qI3.a("PushManager", "Push received # use old push received", new Object[0]);
                    AbstractC13042fc3.g(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String?>");
                    ve4K.H(AbstractC19810qy7.d(map));
                }
            } else {
                C19406qI3.a("PushManager", "Push received # use old push handler (marketing, ...)", new Object[0]);
                y().t(remoteMessage, map);
            }
            C19406qI3.a("PushManager", "onMessageReceived ended!", new Object[0]);
        } catch (Exception e) {
            C19406qI3.b("PushManager", "onMessageReceived: return because of exception in getData: " + e.getMessage());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void s(String token) {
        AbstractC13042fc3.i(token, "token");
        super.s(token);
        C19406qI3.a("PushManager", "onNewToken: setFCMPushToken", new Object[0]);
        C5735Kp4.w().r(token);
    }
}
