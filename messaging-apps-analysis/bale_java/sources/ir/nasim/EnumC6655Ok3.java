package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lir/nasim/Ok3;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "c", "d", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ok3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC6655Ok3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final InterfaceC9173Yu3 a;
    public static final EnumC6655Ok3 b = new EnumC6655Ok3("LOCATION", 0);
    public static final EnumC6655Ok3 c = new EnumC6655Ok3("CONTACT", 1);
    public static final EnumC6655Ok3 d = new EnumC6655Ok3("UNKNOWN", 2);
    private static final /* synthetic */ EnumC6655Ok3[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.Ok3$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) EnumC6655Ok3.a.getValue();
        }

        public final KSerializer serializer() {
            return a();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC6655Ok3[] enumC6655Ok3ArrJ = j();
        e = enumC6655Ok3ArrJ;
        f = G92.a(enumC6655Ok3ArrJ);
        INSTANCE = new Companion(null);
        a = AbstractC13269fw3.b(EnumC4870Gx3.b, new SA2() { // from class: ir.nasim.Nk3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EnumC6655Ok3.p();
            }
        });
    }

    private EnumC6655Ok3(String str, int i) {
    }

    private static final /* synthetic */ EnumC6655Ok3[] j() {
        return new EnumC6655Ok3[]{b, c, d};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer p() {
        return Q92.a("ir.nasim.dialoglist.data.mapper.mappingStrategies.JsonMessageDataType", values(), new String[]{"location", SIPHeaderNames.CONTACT, CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE}, new Annotation[][]{null, null, null}, null);
    }

    public static EnumC6655Ok3 valueOf(String str) {
        return (EnumC6655Ok3) Enum.valueOf(EnumC6655Ok3.class, str);
    }

    public static EnumC6655Ok3[] values() {
        return (EnumC6655Ok3[]) e.clone();
    }
}
