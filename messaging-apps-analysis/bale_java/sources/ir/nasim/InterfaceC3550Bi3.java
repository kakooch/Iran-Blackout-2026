package ir.nasim;

/* renamed from: ir.nasim.Bi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC3550Bi3 {
    public static final InterfaceC3550Bi3 a = new a();

    /* renamed from: ir.nasim.Bi3$a */
    static class a implements InterfaceC3550Bi3 {
        a() {
        }

        private static /* synthetic */ void f(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.InterfaceC3550Bi3
        public void a(InterfaceC7106Qh3 interfaceC7106Qh3, InterfaceC21331tU0 interfaceC21331tU0) {
            if (interfaceC7106Qh3 == null) {
                f(7);
            }
            if (interfaceC21331tU0 == null) {
                f(8);
            }
        }

        @Override // ir.nasim.InterfaceC3550Bi3
        public void b(InterfaceC19648qi3 interfaceC19648qi3, JC6 jc6) {
            if (interfaceC19648qi3 == null) {
                f(1);
            }
            if (jc6 == null) {
                f(2);
            }
        }

        @Override // ir.nasim.InterfaceC3550Bi3
        public InterfaceC21331tU0 c(C9424Zw2 c9424Zw2) {
            if (c9424Zw2 != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // ir.nasim.InterfaceC3550Bi3
        public void d(InterfaceC13720gi3 interfaceC13720gi3, InterfaceC21426te1 interfaceC21426te1) {
            if (interfaceC13720gi3 == null) {
                f(3);
            }
            if (interfaceC21426te1 == null) {
                f(4);
            }
        }

        @Override // ir.nasim.InterfaceC3550Bi3
        public void e(InterfaceC14921ii3 interfaceC14921ii3, InterfaceC20989sw5 interfaceC20989sw5) {
            if (interfaceC14921ii3 == null) {
                f(5);
            }
            if (interfaceC20989sw5 == null) {
                f(6);
            }
        }
    }

    void a(InterfaceC7106Qh3 interfaceC7106Qh3, InterfaceC21331tU0 interfaceC21331tU0);

    void b(InterfaceC19648qi3 interfaceC19648qi3, JC6 jc6);

    InterfaceC21331tU0 c(C9424Zw2 c9424Zw2);

    void d(InterfaceC13720gi3 interfaceC13720gi3, InterfaceC21426te1 interfaceC21426te1);

    void e(InterfaceC14921ii3 interfaceC14921ii3, InterfaceC20989sw5 interfaceC20989sw5);
}
