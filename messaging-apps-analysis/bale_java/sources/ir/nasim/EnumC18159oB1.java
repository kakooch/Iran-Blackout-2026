package ir.nasim;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 ir.nasim.oB1, still in use, count: 1, list:
  (r0v0 ir.nasim.oB1) from 0x001a: SPUT (r0v0 ir.nasim.oB1) (LINE:27) ir.nasim.oB1.c ir.nasim.oB1
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: ir.nasim.oB1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC18159oB1 {
    PREFER_ARGB_8888,
    PREFER_RGB_565;

    public static final EnumC18159oB1 c = new EnumC18159oB1();

    static {
    }

    private EnumC18159oB1() {
    }

    public static EnumC18159oB1 valueOf(String str) {
        return (EnumC18159oB1) Enum.valueOf(EnumC18159oB1.class, str);
    }

    public static EnumC18159oB1[] values() {
        return (EnumC18159oB1[]) d.clone();
    }
}
