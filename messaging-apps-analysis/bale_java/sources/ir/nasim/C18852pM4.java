package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.pM4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18852pM4 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final InterfaceC3570Bk5 a;
    private final InterfaceC11621dJ7 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.pM4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pM4$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C18852pM4.this.f(this);
        }
    }

    public C18852pM4(InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = interfaceC3570Bk5;
        this.b = interfaceC11621dJ7;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mM4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18852pM4.j(this.a);
            }
        });
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nM4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18852pM4.i(this.a);
            }
        });
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oM4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C18852pM4.h(this.a));
            }
        });
    }

    private final List e() {
        return (List) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(c18852pM4, "this$0");
        return (c18852pM4.e().isEmpty() ^ true) && c18852pM4.e().contains("PackageItem_ORGANIZATIONAL_CONTACT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(c18852pM4, "this$0");
        return c18852pM4.a.e("MY_ORGANIZATION_NAME_ARG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(c18852pM4, "this$0");
        Set setL = c18852pM4.a.l("MY_ORGANIZATIONAL_FEATURE_ARG");
        if (setL == null) {
            setL = AbstractC4597Fu6.d();
        }
        return AbstractC15401jX0.n0(setL);
    }

    public final String d() {
        return (String) this.d.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C18852pM4.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.pM4$b r0 = (ir.nasim.C18852pM4.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.pM4$b r0 = new ir.nasim.pM4$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.a
            ir.nasim.pM4 r0 = (ir.nasim.C18852pM4) r0
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            goto L4c
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3b:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.dJ7 r6 = r5.b
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r5
        L4c:
            boolean r1 = ir.nasim.C9475a16.j(r6)
            if (r1 == 0) goto Lab
            ai.bale.proto.OrganizationsStruct$UserOrganization r6 = (ai.bale.proto.OrganizationsStruct$UserOrganization) r6
            ir.nasim.Bk5 r1 = r0.a
            ai.bale.proto.OrganizationsStruct$Organization r2 = r6.getOrganization()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "MY_ORGANIZATION_NAME_ARG"
            r1.putString(r3, r2)
            ir.nasim.Bk5 r1 = r0.a
            ai.bale.proto.OrganizationsStruct$Organization r2 = r6.getOrganization()
            java.util.List r2 = r2.getOrgPackageList()
            java.lang.String r3 = "getOrgPackageList(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = ir.nasim.ZW0.x(r2, r4)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L83:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L97
            java.lang.Object r4 = r2.next()
            ir.nasim.vM4 r4 = (ir.nasim.EnumC22510vM4) r4
            java.lang.String r4 = r4.name()
            r3.add(r4)
            goto L83
        L97:
            java.util.Set r2 = ir.nasim.ZW0.r1(r3)
            java.lang.String r3 = "MY_ORGANIZATIONAL_FEATURE_ARG"
            r1.putStringSet(r3, r2)
            ir.nasim.Bk5 r0 = r0.a
            java.lang.String r1 = "MY_ORGANIZATIONAL_NAME_ARG"
            java.lang.String r6 = r6.getOrganizationalName()
            r0.putString(r1, r6)
        Lab:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18852pM4.f(ir.nasim.rm1):java.lang.Object");
    }

    public final boolean g() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }
}
