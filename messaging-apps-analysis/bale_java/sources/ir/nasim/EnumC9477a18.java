package ir.nasim;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lir/nasim/a18;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "c", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.a18, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9477a18 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final InterfaceC9173Yu3 a;
    public static final EnumC9477a18 b = new EnumC9477a18("Idle", 0);
    public static final EnumC9477a18 c = new EnumC9477a18("Loading", 1);
    public static final EnumC9477a18 d = new EnumC9477a18("Loaded", 2);
    private static final /* synthetic */ EnumC9477a18[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.a18$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) EnumC9477a18.a.getValue();
        }

        public final KSerializer serializer() {
            return a();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC9477a18[] enumC9477a18ArrJ = j();
        e = enumC9477a18ArrJ;
        f = G92.a(enumC9477a18ArrJ);
        INSTANCE = new Companion(null);
        a = AbstractC13269fw3.b(EnumC4870Gx3.b, new SA2() { // from class: ir.nasim.Z08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EnumC9477a18.p();
            }
        });
    }

    private EnumC9477a18(String str, int i) {
    }

    private static final /* synthetic */ EnumC9477a18[] j() {
        return new EnumC9477a18[]{b, c, d};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer p() {
        return Q92.b("ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext.VoiceToTextState", values());
    }

    public static EnumC9477a18 valueOf(String str) {
        return (EnumC9477a18) Enum.valueOf(EnumC9477a18.class, str);
    }

    public static EnumC9477a18[] values() {
        return (EnumC9477a18[]) e.clone();
    }
}
