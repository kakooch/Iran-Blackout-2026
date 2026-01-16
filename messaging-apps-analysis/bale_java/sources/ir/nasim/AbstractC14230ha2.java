package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.ha2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14230ha2 {
    private static final InterfaceC8507Wg4 a = new b();
    private static final c b = new c(C6432No4.s("<ERROR CLASS>"));
    public static final XC6 c = j("<LOOP IN SUPERTYPES>");
    private static final AbstractC4099Dr3 d = j("<ERROR PROPERTY TYPE>");
    private static final InterfaceC20989sw5 e;
    private static final Set f;

    /* renamed from: ir.nasim.ha2$a */
    static class a implements InterfaceC13882gy7 {
        final /* synthetic */ c a;
        final /* synthetic */ String b;

        a(c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        private static /* synthetic */ void f(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 3 ? 2 : 3];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public InterfaceC13882gy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
            if (abstractC5284Ir3 == null) {
                f(3);
            }
            return this;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public Collection b() {
            List listM = AbstractC10360bX0.m();
            if (listM == null) {
                f(1);
            }
            return listM;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        /* renamed from: d */
        public MU0 t() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return false;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            List listM = AbstractC10360bX0.m();
            if (listM == null) {
                f(0);
            }
            return listM;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public AbstractC19738qr3 n() {
            C24202yD1 c24202yD1N0 = C24202yD1.N0();
            if (c24202yD1N0 == null) {
                f(2);
            }
            return c24202yD1N0;
        }

        public String toString() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.ha2$c */
    private static class c extends C23174wU0 {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                i0(0);
            }
            InterfaceC8507Wg4 interfaceC8507Wg4Q = AbstractC14230ha2.q();
            EnumC11067cg4 enumC11067cg4 = EnumC11067cg4.OPEN;
            AU0 au0 = AU0.CLASS;
            List listEmptyList = Collections.emptyList();
            JH6 jh6 = JH6.a;
            super(interfaceC8507Wg4Q, c6432No4, enumC11067cg4, au0, listEmptyList, jh6, false, C14671iI3.e);
            C18920pU0 c18920pU0L1 = C18920pU0.l1(this, InterfaceC4356Eu.W.b(), true, jh6);
            c18920pU0L1.o1(Collections.emptyList(), QI1.d);
            W24 w24H = AbstractC14230ha2.h(getName().h());
            c18920pU0L1.f1(new C13639ga2(AbstractC14230ha2.m("<ERROR>", this), w24H));
            J0(w24H, Collections.singleton(c18920pU0L1), c18920pU0L1);
        }

        private static /* synthetic */ void i0(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // ir.nasim.E0, ir.nasim.InterfaceC19829r07
        /* renamed from: I0, reason: merged with bridge method [inline-methods] */
        public InterfaceC21331tU0 c(C5585Jy7 c5585Jy7) {
            if (c5585Jy7 == null) {
                i0(1);
            }
            return this;
        }

        @Override // ir.nasim.C23174wU0
        public String toString() {
            return getName().h();
        }

        @Override // ir.nasim.E0, ir.nasim.AbstractC6615Og4
        public W24 x(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5284Ir3 abstractC5284Ir3) {
            if (abstractC5117Hy7 == null) {
                i0(6);
            }
            if (abstractC5284Ir3 == null) {
                i0(7);
            }
            W24 w24H = AbstractC14230ha2.h("Error scope for class " + getName() + " with arguments: " + abstractC5117Hy7);
            if (w24H == null) {
                i0(8);
            }
            return w24H;
        }
    }

    /* renamed from: ir.nasim.ha2$d */
    public static class d implements W24 {
        private final String b;

        /* synthetic */ d(String str, b bVar) {
            this(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void h(int r10) {
            /*
                r0 = 18
                r1 = 7
                if (r10 == r1) goto Ld
                if (r10 == r0) goto Ld
                switch(r10) {
                    case 10: goto Ld;
                    case 11: goto Ld;
                    case 12: goto Ld;
                    case 13: goto Ld;
                    default: goto La;
                }
            La:
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lf
            Ld:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lf:
                r3 = 2
                if (r10 == r1) goto L19
                if (r10 == r0) goto L19
                switch(r10) {
                    case 10: goto L19;
                    case 11: goto L19;
                    case 12: goto L19;
                    case 13: goto L19;
                    default: goto L17;
                }
            L17:
                r4 = 3
                goto L1a
            L19:
                r4 = r3
            L1a:
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope"
                r6 = 0
                switch(r10) {
                    case 1: goto L3e;
                    case 2: goto L39;
                    case 3: goto L3e;
                    case 4: goto L39;
                    case 5: goto L3e;
                    case 6: goto L39;
                    case 7: goto L36;
                    case 8: goto L3e;
                    case 9: goto L39;
                    case 10: goto L36;
                    case 11: goto L36;
                    case 12: goto L36;
                    case 13: goto L36;
                    case 14: goto L3e;
                    case 15: goto L39;
                    case 16: goto L31;
                    case 17: goto L2c;
                    case 18: goto L36;
                    case 19: goto L3e;
                    case 20: goto L27;
                    default: goto L22;
                }
            L22:
                java.lang.String r7 = "debugMessage"
                r4[r6] = r7
                goto L42
            L27:
                java.lang.String r7 = "p"
                r4[r6] = r7
                goto L42
            L2c:
                java.lang.String r7 = "nameFilter"
                r4[r6] = r7
                goto L42
            L31:
                java.lang.String r7 = "kindFilter"
                r4[r6] = r7
                goto L42
            L36:
                r4[r6] = r5
                goto L42
            L39:
                java.lang.String r7 = "location"
                r4[r6] = r7
                goto L42
            L3e:
                java.lang.String r7 = "name"
                r4[r6] = r7
            L42:
                java.lang.String r6 = "getContributedVariables"
                java.lang.String r7 = "getContributedFunctions"
                java.lang.String r8 = "getContributedDescriptors"
                r9 = 1
                if (r10 == r1) goto L68
                if (r10 == r0) goto L65
                switch(r10) {
                    case 10: goto L62;
                    case 11: goto L5d;
                    case 12: goto L58;
                    case 13: goto L53;
                    default: goto L50;
                }
            L50:
                r4[r9] = r5
                goto L6a
            L53:
                java.lang.String r5 = "getClassifierNames"
                r4[r9] = r5
                goto L6a
            L58:
                java.lang.String r5 = "getVariableNames"
                r4[r9] = r5
                goto L6a
            L5d:
                java.lang.String r5 = "getFunctionNames"
                r4[r9] = r5
                goto L6a
            L62:
                r4[r9] = r7
                goto L6a
            L65:
                r4[r9] = r8
                goto L6a
            L68:
                r4[r9] = r6
            L6a:
                switch(r10) {
                    case 1: goto L8f;
                    case 2: goto L8f;
                    case 3: goto L8a;
                    case 4: goto L8a;
                    case 5: goto L87;
                    case 6: goto L87;
                    case 7: goto L93;
                    case 8: goto L84;
                    case 9: goto L84;
                    case 10: goto L93;
                    case 11: goto L93;
                    case 12: goto L93;
                    case 13: goto L93;
                    case 14: goto L7f;
                    case 15: goto L7f;
                    case 16: goto L7c;
                    case 17: goto L7c;
                    case 18: goto L93;
                    case 19: goto L77;
                    case 20: goto L72;
                    default: goto L6d;
                }
            L6d:
                java.lang.String r5 = "<init>"
                r4[r3] = r5
                goto L93
            L72:
                java.lang.String r5 = "printScopeStructure"
                r4[r3] = r5
                goto L93
            L77:
                java.lang.String r5 = "definitelyDoesNotContainName"
                r4[r3] = r5
                goto L93
            L7c:
                r4[r3] = r8
                goto L93
            L7f:
                java.lang.String r5 = "recordLookup"
                r4[r3] = r5
                goto L93
            L84:
                r4[r3] = r7
                goto L93
            L87:
                r4[r3] = r6
                goto L93
            L8a:
                java.lang.String r5 = "getContributedClassifierIncludeDeprecated"
                r4[r3] = r5
                goto L93
            L8f:
                java.lang.String r5 = "getContributedClassifier"
                r4[r3] = r5
            L93:
                java.lang.String r2 = java.lang.String.format(r2, r4)
                if (r10 == r1) goto La4
                if (r10 == r0) goto La4
                switch(r10) {
                    case 10: goto La4;
                    case 11: goto La4;
                    case 12: goto La4;
                    case 13: goto La4;
                    default: goto L9e;
                }
            L9e:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r2)
                goto La9
            La4:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r2)
            La9:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14230ha2.d.h(int):void");
        }

        @Override // ir.nasim.W24
        public Set a() {
            Set setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                h(11);
            }
            return setEmptySet;
        }

        @Override // ir.nasim.W24
        public Set c() {
            Set setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                h(12);
            }
            return setEmptySet;
        }

        @Override // ir.nasim.InterfaceC22011uW5
        public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(1);
            }
            if (ij3 == null) {
                h(2);
            }
            return AbstractC14230ha2.e(c6432No4.h());
        }

        @Override // ir.nasim.InterfaceC22011uW5
        public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
            if (c24841zI1 == null) {
                h(16);
            }
            if (ua2 == null) {
                h(17);
            }
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                h(18);
            }
            return listEmptyList;
        }

        @Override // ir.nasim.W24
        public Set g() {
            Set setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                h(13);
            }
            return setEmptySet;
        }

        @Override // ir.nasim.W24
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Set d(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(8);
            }
            if (ij3 == null) {
                h(9);
            }
            Set setSingleton = Collections.singleton(AbstractC14230ha2.f(this));
            if (setSingleton == null) {
                h(10);
            }
            return setSingleton;
        }

        @Override // ir.nasim.W24
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Set b(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(5);
            }
            if (ij3 == null) {
                h(6);
            }
            Set set = AbstractC14230ha2.f;
            if (set == null) {
                h(7);
            }
            return set;
        }

        public String toString() {
            return "ErrorScope{" + this.b + '}';
        }

        private d(String str) {
            if (str == null) {
                h(0);
            }
            this.b = str;
        }
    }

    /* renamed from: ir.nasim.ha2$e */
    private static class e implements W24 {
        private final String b;

        /* synthetic */ e(String str, b bVar) {
            this(str);
        }

        private static /* synthetic */ void h(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = DialogEntity.COLUMN_MESSAGE;
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.W24
        public Set a() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.W24
        public Collection b(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(5);
            }
            if (ij3 == null) {
                h(6);
            }
            throw new IllegalStateException(this.b + ", required name: " + c6432No4);
        }

        @Override // ir.nasim.W24
        public Set c() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.W24
        public Collection d(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(7);
            }
            if (ij3 == null) {
                h(8);
            }
            throw new IllegalStateException(this.b + ", required name: " + c6432No4);
        }

        @Override // ir.nasim.InterfaceC22011uW5
        public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
            if (c6432No4 == null) {
                h(1);
            }
            if (ij3 == null) {
                h(2);
            }
            throw new IllegalStateException(this.b + ", required name: " + c6432No4);
        }

        @Override // ir.nasim.InterfaceC22011uW5
        public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
            if (c24841zI1 == null) {
                h(9);
            }
            if (ua2 == null) {
                h(10);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // ir.nasim.W24
        public Set g() {
            throw new IllegalStateException();
        }

        public String toString() {
            return "ThrowingScope{" + this.b + '}';
        }

        private e(String str) {
            if (str == null) {
                h(0);
            }
            this.b = str;
        }
    }

    static {
        C21676tw5 c21676tw5G = g();
        e = c21676tw5G;
        f = Collections.singleton(c21676tw5G);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static InterfaceC21331tU0 e(String str) {
        if (str == null) {
            a(1);
        }
        return new c(C6432No4.s("<ERROR CLASS: " + str + Separators.GREATER_THAN));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JC6 f(d dVar) {
        if (dVar == null) {
            a(5);
        }
        C13021fa2 c13021fa2 = new C13021fa2(b, dVar);
        c13021fa2.Q0(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), EnumC11067cg4.OPEN, QI1.e);
        return c13021fa2;
    }

    private static C21676tw5 g() {
        C21676tw5 c21676tw5M0 = C21676tw5.M0(b, InterfaceC4356Eu.W.b(), EnumC11067cg4.OPEN, QI1.e, true, C6432No4.s("<ERROR PROPERTY>"), InterfaceC15194jA0.a.DECLARATION, JH6.a, false, false, false, false, false, false);
        c21676tw5M0.Y0(d, Collections.emptyList(), null, null);
        return c21676tw5M0;
    }

    public static W24 h(String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    public static W24 i(String str, boolean z) {
        if (str == null) {
            a(3);
        }
        b bVar = null;
        return z ? new e(str, bVar) : new d(str, bVar);
    }

    public static XC6 j(String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    public static InterfaceC13882gy7 k(String str) {
        if (str == null) {
            a(15);
        }
        return m("[ERROR : " + str + "]", b);
    }

    public static InterfaceC13882gy7 l(String str) {
        if (str == null) {
            a(16);
        }
        return m(str, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InterfaceC13882gy7 m(String str, c cVar) {
        if (str == null) {
            a(17);
        }
        if (cVar == null) {
            a(18);
        }
        return new a(cVar, str);
    }

    public static XC6 n(String str, List list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new C13639ga2(k(str), h(str), list, false);
    }

    public static XC6 o(String str, InterfaceC13882gy7 interfaceC13882gy7) {
        if (str == null) {
            a(9);
        }
        if (interfaceC13882gy7 == null) {
            a(10);
        }
        return new C13639ga2(interfaceC13882gy7, h(str));
    }

    public static XC6 p(String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    public static InterfaceC8507Wg4 q() {
        InterfaceC8507Wg4 interfaceC8507Wg4 = a;
        if (interfaceC8507Wg4 == null) {
            a(19);
        }
        return interfaceC8507Wg4;
    }

    public static boolean r(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            return false;
        }
        return s(interfaceC12795fB1) || s(interfaceC12795fB1.b()) || interfaceC12795fB1 == a;
    }

    private static boolean s(InterfaceC12795fB1 interfaceC12795fB1) {
        return interfaceC12795fB1 instanceof c;
    }

    public static boolean t(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            return false;
        }
        abstractC4099Dr3.K0();
        return false;
    }

    /* renamed from: ir.nasim.ha2$b */
    static class b implements InterfaceC8507Wg4 {
        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void x(int r12) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14230ha2.b.x(int):void");
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public Object a0(C7332Rg4 c7332Rg4) {
            if (c7332Rg4 != null) {
                return null;
            }
            x(0);
            return null;
        }

        @Override // ir.nasim.InterfaceC12795fB1
        public InterfaceC12795fB1 b() {
            return null;
        }

        @Override // ir.nasim.InterfaceC10612bu
        public InterfaceC4356Eu getAnnotations() {
            InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
            if (interfaceC4356EuB == null) {
                x(1);
            }
            return interfaceC4356EuB;
        }

        @Override // ir.nasim.InterfaceC7638So4
        public C6432No4 getName() {
            C6432No4 c6432No4S = C6432No4.s("<ERROR MODULE>");
            if (c6432No4S == null) {
                x(5);
            }
            return c6432No4S;
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public Collection l(C9424Zw2 c9424Zw2, UA2 ua2) {
            if (c9424Zw2 == null) {
                x(2);
            }
            if (ua2 == null) {
                x(3);
            }
            List listM = AbstractC10360bX0.m();
            if (listM == null) {
                x(4);
            }
            return listM;
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public AbstractC19738qr3 n() {
            C24202yD1 c24202yD1N0 = C24202yD1.N0();
            if (c24202yD1N0 == null) {
                x(14);
            }
            return c24202yD1N0;
        }

        @Override // ir.nasim.InterfaceC12795fB1
        public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
            if (interfaceC15204jB1 != null) {
                return null;
            }
            x(11);
            return null;
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public List x0() {
            List listM = AbstractC10360bX0.m();
            if (listM == null) {
                x(9);
            }
            return listM;
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public boolean z(InterfaceC8507Wg4 interfaceC8507Wg4) {
            if (interfaceC8507Wg4 != null) {
                return false;
            }
            x(12);
            return false;
        }

        @Override // ir.nasim.InterfaceC8507Wg4
        public OS4 z0(C9424Zw2 c9424Zw2) {
            if (c9424Zw2 == null) {
                x(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // ir.nasim.InterfaceC12795fB1
        public InterfaceC12795fB1 a() {
            return this;
        }
    }
}
