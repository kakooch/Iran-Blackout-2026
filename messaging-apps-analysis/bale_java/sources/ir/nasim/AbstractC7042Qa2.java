package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Qa2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7042Qa2 {

    /* renamed from: ir.nasim.Qa2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final String a(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        int i = a.a[exPeerType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : "bot" : "user" : "channel" : "group";
    }
}
