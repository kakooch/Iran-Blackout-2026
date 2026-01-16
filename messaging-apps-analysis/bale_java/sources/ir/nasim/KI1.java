package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class KI1 {

    static class a extends AbstractC16980mB4 {
        final /* synthetic */ InterfaceC11005ca2 a;
        final /* synthetic */ Set b;
        final /* synthetic */ boolean c;

        /* renamed from: ir.nasim.KI1$a$a, reason: collision with other inner class name */
        class C0463a implements UA2 {
            C0463a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // ir.nasim.UA2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C19938rB7 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
                if (interfaceC15194jA0 == null) {
                    a(0);
                }
                a.this.a.a(interfaceC15194jA0);
                return C19938rB7.a;
            }
        }

        a(InterfaceC11005ca2 interfaceC11005ca2, Set set, boolean z) {
            this.a = interfaceC11005ca2;
            this.b = set;
            this.c = z;
        }

        private static /* synthetic */ void f(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "fromSuper";
            } else if (i == 2) {
                objArr[0] = "fromCurrent";
            } else if (i == 3) {
                objArr[0] = "member";
            } else if (i != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i == 1 || i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.AbstractC10899cO4
        public void a(InterfaceC15194jA0 interfaceC15194jA0) {
            if (interfaceC15194jA0 == null) {
                f(0);
            }
            C11663dO4.N(interfaceC15194jA0, new C0463a());
            this.b.add(interfaceC15194jA0);
        }

        @Override // ir.nasim.AbstractC10899cO4
        public void d(InterfaceC15194jA0 interfaceC15194jA0, Collection collection) {
            if (interfaceC15194jA0 == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.c || interfaceC15194jA0.f() == InterfaceC15194jA0.a.FAKE_OVERRIDE) {
                super.d(interfaceC15194jA0, collection);
            }
        }

        @Override // ir.nasim.AbstractC16980mB4
        public void e(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
            if (interfaceC15194jA0 == null) {
                f(1);
            }
            if (interfaceC15194jA02 == null) {
                f(2);
            }
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static InterfaceC24919zQ7 b(C6432No4 c6432No4, InterfaceC21331tU0 interfaceC21331tU0) {
        if (c6432No4 == null) {
            a(19);
        }
        if (interfaceC21331tU0 == null) {
            a(20);
        }
        Collection collectionK = interfaceC21331tU0.k();
        if (collectionK.size() != 1) {
            return null;
        }
        for (InterfaceC24919zQ7 interfaceC24919zQ7 : ((InterfaceC18329oU0) collectionK.iterator().next()).h()) {
            if (interfaceC24919zQ7.getName().equals(c6432No4)) {
                return interfaceC24919zQ7;
            }
        }
        return null;
    }

    private static Collection c(C6432No4 c6432No4, Collection collection, Collection collection2, InterfaceC21331tU0 interfaceC21331tU0, InterfaceC11005ca2 interfaceC11005ca2, C11663dO4 c11663dO4, boolean z) {
        if (c6432No4 == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (interfaceC21331tU0 == null) {
            a(15);
        }
        if (interfaceC11005ca2 == null) {
            a(16);
        }
        if (c11663dO4 == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c11663dO4.y(c6432No4, collection, collection2, interfaceC21331tU0, new a(interfaceC11005ca2, linkedHashSet, z));
        return linkedHashSet;
    }

    public static Collection d(C6432No4 c6432No4, Collection collection, Collection collection2, InterfaceC21331tU0 interfaceC21331tU0, InterfaceC11005ca2 interfaceC11005ca2, C11663dO4 c11663dO4) {
        if (c6432No4 == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (interfaceC21331tU0 == null) {
            a(3);
        }
        if (interfaceC11005ca2 == null) {
            a(4);
        }
        if (c11663dO4 == null) {
            a(5);
        }
        return c(c6432No4, collection, collection2, interfaceC21331tU0, interfaceC11005ca2, c11663dO4, false);
    }

    public static Collection e(C6432No4 c6432No4, Collection collection, Collection collection2, InterfaceC21331tU0 interfaceC21331tU0, InterfaceC11005ca2 interfaceC11005ca2, C11663dO4 c11663dO4) {
        if (c6432No4 == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (interfaceC21331tU0 == null) {
            a(9);
        }
        if (interfaceC11005ca2 == null) {
            a(10);
        }
        if (c11663dO4 == null) {
            a(11);
        }
        return c(c6432No4, collection, collection2, interfaceC21331tU0, interfaceC11005ca2, c11663dO4, true);
    }
}
