package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ca2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC11005ca2 {
    public static final InterfaceC11005ca2 a = new a();

    /* renamed from: ir.nasim.ca2$a */
    static class a implements InterfaceC11005ca2 {
        a() {
        }

        private static /* synthetic */ void c(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.InterfaceC11005ca2
        public void a(InterfaceC15194jA0 interfaceC15194jA0) {
            if (interfaceC15194jA0 == null) {
                c(2);
            }
        }

        @Override // ir.nasim.InterfaceC11005ca2
        public void b(InterfaceC21331tU0 interfaceC21331tU0, List list) {
            if (interfaceC21331tU0 == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(InterfaceC15194jA0 interfaceC15194jA0);

    void b(InterfaceC21331tU0 interfaceC21331tU0, List list);
}
