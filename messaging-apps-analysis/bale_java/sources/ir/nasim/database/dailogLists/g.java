package ir.nasim.database.dailogLists;

import ir.nasim.AbstractC13269fw3;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.Q92;
import ir.nasim.SA2;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lir/nasim/database/dailogLists/g;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "c", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final InterfaceC9173Yu3 a;
    public static final g b = new g("SuccessfulCall", 0);
    public static final g c = new g("MissedCall", 1);
    private static final /* synthetic */ g[] d;
    private static final /* synthetic */ F92 e;

    /* renamed from: ir.nasim.database.dailogLists.g$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) g.a.getValue();
        }

        public final KSerializer serializer() {
            return a();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static {
        g[] gVarArrJ = j();
        d = gVarArrJ;
        e = G92.a(gVarArrJ);
        INSTANCE = new Companion(null);
        a = AbstractC13269fw3.b(EnumC4870Gx3.b, new SA2() { // from class: ir.nasim.vt3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.database.dailogLists.g.p();
            }
        });
    }

    private g(String str, int i) {
    }

    private static final /* synthetic */ g[] j() {
        return new g[]{b, c};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer p() {
        return Q92.b("ir.nasim.database.dailogLists.LastMessageCallType", values());
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) d.clone();
    }
}
