package ir.nasim;

import ir.nasim.AB2;
import ir.nasim.AQ7;
import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class BB2 extends AbstractC14602iB1 implements AB2 {
    private final InterfaceC15194jA0.a A;
    private AB2 B;
    protected Map D;
    private List e;
    private List f;
    private AbstractC4099Dr3 g;
    private ZI5 h;
    private ZI5 i;
    private EnumC11067cg4 j;
    private RI1 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Collection x;
    private volatile SA2 y;
    private final AB2 z;

    class a implements SA2 {
        final /* synthetic */ C5585Jy7 a;

        a(C5585Jy7 c5585Jy7) {
            this.a = c5585Jy7;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection invoke() {
            CE6 ce6 = new CE6();
            Iterator it = BB2.this.d().iterator();
            while (it.hasNext()) {
                ce6.add(((AB2) it.next()).c(this.a));
            }
            return ce6;
        }
    }

    static class b implements SA2 {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List invoke() {
            return this.a;
        }
    }

    public class c implements AB2.a {
        protected AbstractC5117Hy7 a;
        protected InterfaceC12795fB1 b;
        protected EnumC11067cg4 c;
        protected RI1 d;
        protected AB2 e;
        protected InterfaceC15194jA0.a f;
        protected List g;
        protected ZI5 h;
        protected ZI5 i;
        protected AbstractC4099Dr3 j;
        protected C6432No4 k;
        protected boolean l;
        protected boolean m;
        protected boolean n;
        protected boolean o;
        private boolean p;
        private List q;
        private InterfaceC4356Eu r;
        private boolean s;
        private Map t;
        private Boolean u;
        protected boolean v;
        final /* synthetic */ BB2 w;

        public c(BB2 bb2, AbstractC5117Hy7 abstractC5117Hy7, InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, List list, ZI5 zi5, AbstractC4099Dr3 abstractC4099Dr3, C6432No4 c6432No4) {
            if (abstractC5117Hy7 == null) {
                u(0);
            }
            if (interfaceC12795fB1 == null) {
                u(1);
            }
            if (enumC11067cg4 == null) {
                u(2);
            }
            if (ri1 == null) {
                u(3);
            }
            if (aVar == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (abstractC4099Dr3 == null) {
                u(6);
            }
            this.w = bb2;
            this.e = null;
            this.i = bb2.i;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = bb2.B0();
            this.q = null;
            this.r = null;
            this.s = bb2.E0();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = abstractC5117Hy7;
            this.b = interfaceC12795fB1;
            this.c = enumC11067cg4;
            this.d = ri1;
            this.f = aVar;
            this.g = list;
            this.h = zi5;
            this.j = abstractC4099Dr3;
            this.k = c6432No4;
        }

        private static /* synthetic */ void u(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(str2);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public c r(InterfaceC4356Eu interfaceC4356Eu) {
            if (interfaceC4356Eu == null) {
                u(32);
            }
            this.r = interfaceC4356Eu;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public c o(boolean z) {
            this.l = z;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public c e(ZI5 zi5) {
            this.i = zi5;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public c b() {
            this.o = true;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public c d(ZI5 zi5) {
            this.h = zi5;
            return this;
        }

        public c G(boolean z) {
            this.u = Boolean.valueOf(z);
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public c i() {
            this.s = true;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public c j() {
            this.p = true;
            return this;
        }

        public c J(boolean z) {
            this.v = z;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public c q(InterfaceC15194jA0.a aVar) {
            if (aVar == null) {
                u(13);
            }
            this.f = aVar;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public c s(EnumC11067cg4 enumC11067cg4) {
            if (enumC11067cg4 == null) {
                u(9);
            }
            this.c = enumC11067cg4;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public c l(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                u(16);
            }
            this.k = c6432No4;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public c k(InterfaceC15194jA0 interfaceC15194jA0) {
            this.e = (AB2) interfaceC15194jA0;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public c n(InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC12795fB1 == null) {
                u(7);
            }
            this.b = interfaceC12795fB1;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public c m() {
            this.n = true;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c f(AbstractC4099Dr3 abstractC4099Dr3) {
            if (abstractC4099Dr3 == null) {
                u(22);
            }
            this.j = abstractC4099Dr3;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.m = true;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: S, reason: merged with bridge method [inline-methods] */
        public c h(AbstractC5117Hy7 abstractC5117Hy7) {
            if (abstractC5117Hy7 == null) {
                u(34);
            }
            this.a = abstractC5117Hy7;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: T, reason: merged with bridge method [inline-methods] */
        public c p(List list) {
            if (list == null) {
                u(20);
            }
            this.q = list;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: U, reason: merged with bridge method [inline-methods] */
        public c c(List list) {
            if (list == null) {
                u(18);
            }
            this.g = list;
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public c g(RI1 ri1) {
            if (ri1 == null) {
                u(11);
            }
            this.d = ri1;
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2 a() {
            return this.w.L0(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected BB2(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, jh6);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (c6432No4 == null) {
            x(2);
        }
        if (aVar == null) {
            x(3);
        }
        if (jh6 == null) {
            x(4);
        }
        this.k = QI1.i;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = null;
        this.y = null;
        this.B = null;
        this.D = null;
        this.z = ab2 == null ? this : ab2;
        this.A = aVar;
    }

    private JH6 M0(boolean z, AB2 ab2) {
        JH6 jh6I;
        if (z) {
            if (ab2 == null) {
                ab2 = a();
            }
            jh6I = ab2.i();
        } else {
            jh6I = JH6.a;
        }
        if (jh6I == null) {
            x(25);
        }
        return jh6I;
    }

    public static List N0(AB2 ab2, List list, C5585Jy7 c5585Jy7) {
        if (list == null) {
            x(26);
        }
        if (c5585Jy7 == null) {
            x(27);
        }
        return O0(ab2, list, c5585Jy7, false, false, null);
    }

    public static List O0(AB2 ab2, List list, C5585Jy7 c5585Jy7, boolean z, boolean z2, boolean[] zArr) {
        if (list == null) {
            x(28);
        }
        if (c5585Jy7 == null) {
            x(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) it.next();
            AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
            KQ7 kq7 = KQ7.IN_VARIANCE;
            AbstractC4099Dr3 abstractC4099Dr3P = c5585Jy7.p(type, kq7);
            AbstractC4099Dr3 abstractC4099Dr3U0 = interfaceC24919zQ7.u0();
            AbstractC4099Dr3 abstractC4099Dr3P2 = abstractC4099Dr3U0 == null ? null : c5585Jy7.p(abstractC4099Dr3U0, kq7);
            if (abstractC4099Dr3P == null) {
                return null;
            }
            if ((abstractC4099Dr3P != interfaceC24919zQ7.getType() || abstractC4099Dr3U0 != abstractC4099Dr3P2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(AQ7.J0(ab2, z ? null : interfaceC24919zQ7, interfaceC24919zQ7.getIndex(), interfaceC24919zQ7.getAnnotations(), interfaceC24919zQ7.getName(), abstractC4099Dr3P, interfaceC24919zQ7.y0(), interfaceC24919zQ7.r0(), interfaceC24919zQ7.p0(), abstractC4099Dr3P2, z2 ? interfaceC24919zQ7.i() : JH6.a, interfaceC24919zQ7 instanceof AQ7.b ? new b(((AQ7.b) interfaceC24919zQ7).M0()) : null));
        }
        return arrayList;
    }

    private void S0() {
        SA2 sa2 = this.y;
        if (sa2 != null) {
            this.x = (Collection) sa2.invoke();
            this.y = null;
        }
    }

    private void Z0(boolean z) {
        this.t = z;
    }

    private void a1(boolean z) {
        this.s = z;
    }

    private void c1(AB2 ab2) {
        this.B = ab2;
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.AB2
    public boolean B0() {
        return this.s;
    }

    @Override // ir.nasim.AB2
    public boolean C() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public Object C0(InterfaceC14592iA0.a aVar) {
        Map map = this.D;
        if (map == null) {
            return null;
        }
        return map.get(aVar);
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public void D0(Collection collection) {
        if (collection == null) {
            x(15);
        }
        this.x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((AB2) it.next()).E0()) {
                this.t = true;
                return;
            }
        }
    }

    @Override // ir.nasim.AB2
    public boolean E0() {
        return this.t;
    }

    public AB2 J0(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        AB2 ab2A = t().n(interfaceC12795fB1).s(enumC11067cg4).g(ri1).q(aVar).o(z).a();
        if (ab2A == null) {
            x(24);
        }
        return ab2A;
    }

    protected abstract BB2 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6);

    protected AB2 L0(c cVar) {
        C9645aJ5 c9645aJ5;
        ZI5 zi5;
        AbstractC4099Dr3 abstractC4099Dr3P;
        if (cVar == null) {
            x(23);
        }
        boolean[] zArr = new boolean[1];
        InterfaceC4356Eu interfaceC4356EuA = cVar.r != null ? AbstractC4839Gu.a(getAnnotations(), cVar.r) : getAnnotations();
        InterfaceC12795fB1 interfaceC12795fB1 = cVar.b;
        AB2 ab2 = cVar.e;
        BB2 bb2K0 = K0(interfaceC12795fB1, ab2, cVar.f, cVar.k, interfaceC4356EuA, M0(cVar.n, ab2));
        List typeParameters = cVar.q == null ? getTypeParameters() : cVar.q;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        C5585Jy7 c5585Jy7C = MI1.c(typeParameters, cVar.a, bb2K0, arrayList, zArr);
        if (c5585Jy7C == null) {
            return null;
        }
        ZI5 zi52 = cVar.h;
        if (zi52 != null) {
            AbstractC4099Dr3 abstractC4099Dr3P2 = c5585Jy7C.p(zi52.getType(), KQ7.IN_VARIANCE);
            if (abstractC4099Dr3P2 == null) {
                return null;
            }
            C9645aJ5 c9645aJ52 = new C9645aJ5(bb2K0, new C6340Ne2(bb2K0, abstractC4099Dr3P2, cVar.h.getValue()), cVar.h.getAnnotations());
            zArr[0] = (abstractC4099Dr3P2 != cVar.h.getType()) | zArr[0];
            c9645aJ5 = c9645aJ52;
        } else {
            c9645aJ5 = null;
        }
        ZI5 zi53 = cVar.i;
        if (zi53 != null) {
            ZI5 zi5C = zi53.c(c5585Jy7C);
            if (zi5C == null) {
                return null;
            }
            zArr[0] = zArr[0] | (zi5C != cVar.i);
            zi5 = zi5C;
        } else {
            zi5 = null;
        }
        List listO0 = O0(bb2K0, cVar.g, c5585Jy7C, cVar.o, cVar.n, zArr);
        if (listO0 == null || (abstractC4099Dr3P = c5585Jy7C.p(cVar.j, KQ7.OUT_VARIANCE)) == null) {
            return null;
        }
        boolean z = zArr[0] | (abstractC4099Dr3P != cVar.j);
        zArr[0] = z;
        if (!z && cVar.v) {
            return this;
        }
        bb2K0.Q0(c9645aJ5, zi5, arrayList, listO0, abstractC4099Dr3P, cVar.c, cVar.d);
        bb2K0.e1(this.l);
        bb2K0.b1(this.m);
        bb2K0.W0(this.n);
        bb2K0.d1(this.o);
        bb2K0.h1(this.p);
        bb2K0.g1(this.u);
        bb2K0.V0(this.q);
        bb2K0.U0(this.r);
        bb2K0.X0(this.v);
        bb2K0.a1(cVar.p);
        bb2K0.Z0(cVar.s);
        bb2K0.Y0(cVar.u != null ? cVar.u.booleanValue() : this.w);
        if (!cVar.t.isEmpty() || this.D != null) {
            Map map = cVar.t;
            Map map2 = this.D;
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                bb2K0.D = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                bb2K0.D = map;
            }
        }
        if (cVar.m || s0() != null) {
            bb2K0.c1((s0() != null ? s0() : this).c(c5585Jy7C));
        }
        if (cVar.l && !a().d().isEmpty()) {
            if (cVar.a.f()) {
                SA2 sa2 = this.y;
                if (sa2 != null) {
                    bb2K0.y = sa2;
                } else {
                    bb2K0.D0(d());
                }
            } else {
                bb2K0.y = new a(c5585Jy7C);
            }
        }
        return bb2K0;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 N() {
        return this.i;
    }

    public boolean P0() {
        return this.v;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 Q() {
        return this.h;
    }

    public BB2 Q0(ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1) {
        if (list == null) {
            x(5);
        }
        if (list2 == null) {
            x(6);
        }
        if (ri1 == null) {
            x(7);
        }
        this.e = AbstractC15401jX0.m1(list);
        this.f = AbstractC15401jX0.m1(list2);
        this.g = abstractC4099Dr3;
        this.j = enumC11067cg4;
        this.k = ri1;
        this.h = zi5;
        this.i = zi52;
        for (int i = 0; i < list.size(); i++) {
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) list.get(i);
            if (interfaceC22882vy7.getIndex() != i) {
                throw new IllegalStateException(interfaceC22882vy7 + " index is " + interfaceC22882vy7.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) list2.get(i2);
            if (interfaceC24919zQ7.getIndex() != i2) {
                throw new IllegalStateException(interfaceC24919zQ7 + "index is " + interfaceC24919zQ7.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    protected c R0(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(22);
        }
        return new c(this, c5585Jy7.j(), b(), r(), getVisibility(), f(), h(), Q(), getReturnType(), null);
    }

    public void T0(InterfaceC14592iA0.a aVar, Object obj) {
        if (this.D == null) {
            this.D = new LinkedHashMap();
        }
        this.D.put(aVar, obj);
    }

    public void U0(boolean z) {
        this.r = z;
    }

    public void V0(boolean z) {
        this.q = z;
    }

    public void W0(boolean z) {
        this.n = z;
    }

    public void X0(boolean z) {
        this.v = z;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return this.r;
    }

    public void Y0(boolean z) {
        this.w = z;
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.AbstractC13413gB1, ir.nasim.InterfaceC12795fB1
    public AB2 a() {
        AB2 ab2 = this.z;
        AB2 ab2A = ab2 == this ? this : ab2.a();
        if (ab2A == null) {
            x(18);
        }
        return ab2A;
    }

    public void b1(boolean z) {
        this.m = z;
    }

    @Override // ir.nasim.AB2, ir.nasim.InterfaceC15194jA0, ir.nasim.InterfaceC14592iA0
    public Collection d() {
        S0();
        Collection collectionEmptyList = this.x;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList == null) {
            x(12);
        }
        return collectionEmptyList;
    }

    public void d1(boolean z) {
        this.o = z;
    }

    public void e1(boolean z) {
        this.l = z;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public InterfaceC15194jA0.a f() {
        InterfaceC15194jA0.a aVar = this.A;
        if (aVar == null) {
            x(19);
        }
        return aVar;
    }

    public void f1(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            x(10);
        }
        this.g = abstractC4099Dr3;
    }

    public void g1(boolean z) {
        this.u = z;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List getTypeParameters() {
        List list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = this.k;
        if (ri1 == null) {
            x(14);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List h() {
        List list = this.f;
        if (list == null) {
            x(17);
        }
        return list;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return this.w;
    }

    public void h1(boolean z) {
        this.p = z;
    }

    public void i1(RI1 ri1) {
        if (ri1 == null) {
            x(9);
        }
        this.k = ri1;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return this.n;
    }

    @Override // ir.nasim.AB2
    public boolean isInfix() {
        if (this.m) {
            return true;
        }
        Iterator it = a().d().iterator();
        while (it.hasNext()) {
            if (((AB2) it.next()).isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.AB2
    public boolean isInline() {
        return this.o;
    }

    @Override // ir.nasim.AB2
    public boolean isOperator() {
        if (this.l) {
            return true;
        }
        Iterator it = a().d().iterator();
        while (it.hasNext()) {
            if (((AB2) it.next()).isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.AB2
    public boolean isSuspend() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.b(this, obj);
    }

    @Override // ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = this.j;
        if (enumC11067cg4 == null) {
            x(13);
        }
        return enumC11067cg4;
    }

    @Override // ir.nasim.AB2
    public AB2 s0() {
        return this.B;
    }

    @Override // ir.nasim.AB2
    public AB2.a t() {
        c cVarR0 = R0(C5585Jy7.b);
        if (cVarR0 == null) {
            x(21);
        }
        return cVarR0;
    }

    @Override // ir.nasim.InterfaceC19829r07
    public AB2 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(20);
        }
        return c5585Jy7.k() ? this : R0(c5585Jy7).k(a()).m().J(true).a();
    }
}
