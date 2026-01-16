package ir.nasim;

/* renamed from: ir.nasim.kS0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC15947kS0 {

    /* renamed from: ir.nasim.kS0$a */
    public static final class a {
        public static String a(InterfaceC15947kS0 interfaceC15947kS0, AB2 ab2) {
            AbstractC13042fc3.i(interfaceC15947kS0, "this");
            AbstractC13042fc3.i(ab2, "functionDescriptor");
            if (interfaceC15947kS0.a(ab2)) {
                return null;
            }
            return interfaceC15947kS0.getDescription();
        }
    }

    boolean a(AB2 ab2);

    String b(AB2 ab2);

    String getDescription();
}
