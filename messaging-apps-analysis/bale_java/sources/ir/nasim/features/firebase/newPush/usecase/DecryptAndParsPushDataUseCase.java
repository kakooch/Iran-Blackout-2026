package ir.nasim.features.firebase.newPush.usecase;

import ai.bale.proto.PushStruct$EncryptedNotifications;
import ai.bale.proto.PushStruct$NotificationData;
import ai.bale.proto.PushStruct$PushNotification;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.AbstractC2383g;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C12275eL0;
import ir.nasim.C14582i90;
import ir.nasim.C3930Cy5;
import ir.nasim.KS2;
import ir.nasim.Wb8;
import ir.nasim.XV4;
import java.util.Map;

/* loaded from: classes5.dex */
public final class DecryptAndParsPushDataUseCase {
    private final C3930Cy5 a;

    public DecryptAndParsPushDataUseCase(C3930Cy5 c3930Cy5) {
        AbstractC13042fc3.i(c3930Cy5, "pushKeyFactory");
        this.a = c3930Cy5;
    }

    private final Map a(String str) {
        Map map = (Map) new KS2().l(str, new TypeToken<Map<String, ? extends String>>() { // from class: ir.nasim.features.firebase.newPush.usecase.DecryptAndParsPushDataUseCase$convertJsonStringToMap$mapType$1
        }.d());
        AbstractC13042fc3.f(map);
        return map;
    }

    private final Map b(PushStruct$EncryptedNotifications pushStruct$EncryptedNotifications, int i) {
        Wb8 wb8B = this.a.b(i);
        if (wb8B == null) {
            return AbstractC20051rO3.k();
        }
        PushStruct$NotificationData from = PushStruct$NotificationData.parseFrom(wb8B.b(pushStruct$EncryptedNotifications.getEncryptedData(0).a0(), new byte[0]));
        if (!from.hasLegacy()) {
            return AbstractC20051rO3.k();
        }
        byte[] bArrA0 = from.getLegacy().a0();
        AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
        return a(new String(bArrA0, C12275eL0.b));
    }

    public final XV4 c(String str) {
        Map mapK;
        byte[] bArrA0;
        AbstractC2383g legacy;
        AbstractC13042fc3.i(str, "data");
        PushStruct$PushNotification from = PushStruct$PushNotification.parseFrom(C14582i90.a(str));
        if (from.hasEncryptedNotification()) {
            PushStruct$EncryptedNotifications encryptedNotification = from.getEncryptedNotification();
            AbstractC13042fc3.h(encryptedNotification, "getEncryptedNotification(...)");
            mapK = b(encryptedNotification, from.getOwnerId());
        } else if (from.hasPlainNotification()) {
            PushStruct$NotificationData pushStruct$NotificationData = from.getPlainNotification().getDataList().get(0);
            if (pushStruct$NotificationData == null || (legacy = pushStruct$NotificationData.getLegacy()) == null || (bArrA0 = legacy.a0()) == null) {
                bArrA0 = new byte[0];
            }
            mapK = a(new String(bArrA0, C12275eL0.b));
        } else {
            mapK = AbstractC20051rO3.k();
        }
        return AbstractC4616Fw7.a(mapK, Integer.valueOf(from.getOwnerId()));
    }
}
