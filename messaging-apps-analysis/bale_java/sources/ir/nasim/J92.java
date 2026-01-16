package ir.nasim;

import ir.nasim.W24;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public class J92 extends AbstractC21988uU0 {
    private final InterfaceC13882gy7 i;
    private final W24 j;
    private final InterfaceC23016wC4 k;
    private final InterfaceC4356Eu l;

    private class a extends X24 {
        private final I34 b;
        private final I34 c;
        private final InterfaceC23016wC4 d;
        final /* synthetic */ J92 e;

        /* renamed from: ir.nasim.J92$a$a, reason: collision with other inner class name */
        class C0442a implements UA2 {
            final /* synthetic */ J92 a;

            C0442a(J92 j92) {
                this.a = j92;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(C6432No4 c6432No4) {
                return a.this.m(c6432No4);
            }
        }

        class b implements UA2 {
            final /* synthetic */ J92 a;

            b(J92 j92) {
                this.a = j92;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(C6432No4 c6432No4) {
                return a.this.n(c6432No4);
            }
        }

        class c implements SA2 {
            final /* synthetic */ J92 a;

            c(J92 j92) {
                this.a = j92;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke() {
                return a.this.l();
            }
        }

        class d extends AbstractC16980mB4 {
            final /* synthetic */ Set a;

            d(Set set) {
                this.a = set;
            }

            private static /* synthetic */ void f(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
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
                C11663dO4.N(interfaceC15194jA0, null);
                this.a.add(interfaceC15194jA0);
            }

            @Override // ir.nasim.AbstractC16980mB4
            protected void e(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
                if (interfaceC15194jA0 == null) {
                    f(1);
                }
                if (interfaceC15194jA02 == null) {
                    f(2);
                }
            }
        }

        public a(J92 j92, ON6 on6) {
            if (on6 == null) {
                h(0);
            }
            this.e = j92;
            this.b = on6.e(new C0442a(j92));
            this.c = on6.e(new b(j92));
            this.d = on6.c(new c(j92));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void h(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J92.a.h(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection l() {
            HashSet hashSet = new HashSet();
            for (C6432No4 c6432No4 : (Set) this.e.k.invoke()) {
                FA4 fa4 = FA4.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(d(c6432No4, fa4));
                hashSet.addAll(b(c6432No4, fa4));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection m(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                h(8);
            }
            return p(c6432No4, o().d(c6432No4, FA4.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection n(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                h(4);
            }
            return p(c6432No4, o().b(c6432No4, FA4.FOR_NON_TRACKED_SCOPE));
        }

        private W24 o() {
            W24 w24O = ((AbstractC4099Dr3) this.e.j().b().iterator().next()).o();
            if (w24O == null) {
                h(9);
            }
            return w24O;
        }

        private Collection p(C6432No4 c6432No4, Collection collection) {
            if (c6432No4 == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            C11663dO4.d.y(c6432No4, collection, Collections.emptySet(), this.e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set a() {
            Set set = (Set) this.e.k.invoke();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Collection b(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(1);
            }
            if (ij3 == null) {
                h(2);
            }
            Collection collection = (Collection) this.c.invoke(c6432No4);
            if (collection == null) {
                h(3);
            }
            return collection;
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set c() {
            Set set = (Set) this.e.k.invoke();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Collection d(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(5);
            }
            if (ij3 == null) {
                h(6);
            }
            Collection collection = (Collection) this.b.invoke(c6432No4);
            if (collection == null) {
                h(7);
            }
            return collection;
        }

        @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
        public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
            if (c24841zI1 == null) {
                h(13);
            }
            if (ua2 == null) {
                h(14);
            }
            Collection collection = (Collection) this.d.invoke();
            if (collection == null) {
                h(15);
            }
            return collection;
        }

        @Override // ir.nasim.X24, ir.nasim.W24
        public Set g() {
            Set setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                h(18);
            }
            return setEmptySet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private J92(ON6 on6, InterfaceC21331tU0 interfaceC21331tU0, AbstractC4099Dr3 abstractC4099Dr3, C6432No4 c6432No4, InterfaceC23016wC4 interfaceC23016wC4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        super(on6, interfaceC21331tU0, c6432No4, jh6, false);
        if (on6 == null) {
            i0(6);
        }
        if (interfaceC21331tU0 == null) {
            i0(7);
        }
        if (abstractC4099Dr3 == null) {
            i0(8);
        }
        if (c6432No4 == null) {
            i0(9);
        }
        if (interfaceC23016wC4 == null) {
            i0(10);
        }
        if (interfaceC4356Eu == null) {
            i0(11);
        }
        if (jh6 == null) {
            i0(12);
        }
        this.l = interfaceC4356Eu;
        this.i = new GU0(this, Collections.emptyList(), Collections.singleton(abstractC4099Dr3), on6);
        this.j = new a(this, on6);
        this.k = interfaceC23016wC4;
    }

    public static J92 K0(ON6 on6, InterfaceC21331tU0 interfaceC21331tU0, C6432No4 c6432No4, InterfaceC23016wC4 interfaceC23016wC4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (on6 == null) {
            i0(0);
        }
        if (interfaceC21331tU0 == null) {
            i0(1);
        }
        if (c6432No4 == null) {
            i0(2);
        }
        if (interfaceC23016wC4 == null) {
            i0(3);
        }
        if (interfaceC4356Eu == null) {
            i0(4);
        }
        if (jh6 == null) {
            i0(5);
        }
        return new J92(on6, interfaceC21331tU0, interfaceC21331tU0.p(), c6432No4, interfaceC23016wC4, interfaceC4356Eu, jh6);
    }

    private static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return false;
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 M(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            i0(13);
        }
        W24 w24 = this.j;
        if (w24 == null) {
            i0(14);
        }
        return w24;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        AU0 au0 = AU0.ENUM_ENTRY;
        if (au0 == null) {
            i0(18);
        }
        return au0;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        InterfaceC4356Eu interfaceC4356Eu = this.l;
        if (interfaceC4356Eu == null) {
            i0(21);
        }
        return interfaceC4356Eu;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = QI1.e;
        if (ri1 == null) {
            i0(20);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        InterfaceC13882gy7 interfaceC13882gy7 = this.i;
        if (interfaceC13882gy7 == null) {
            i0(17);
        }
        return interfaceC13882gy7;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection k() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            i0(16);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 m0() {
        W24.b bVar = W24.b.b;
        if (bVar == null) {
            i0(15);
        }
        return bVar;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            i0(22);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = EnumC11067cg4.FINAL;
        if (enumC11067cg4 == null) {
            i0(19);
        }
        return enumC11067cg4;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection y() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            i0(23);
        }
        return listEmptyList;
    }
}
