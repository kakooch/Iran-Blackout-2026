package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.Q12;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.entity.ContactEntity;

/* renamed from: ir.nasim.He3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4933He3 {
    private final SettingsModule a;
    private final FD7 b;
    private final InterfaceC20315ro1 c;
    private final InterfaceC10258bL6 d;

    /* renamed from: ir.nasim.He3$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.He3$a$a, reason: collision with other inner class name */
        public static final class C0403a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.He3$a$a$a, reason: collision with other inner class name */
            public static final class C0404a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0404a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0403a.this.a(null, this);
                }
            }

            public C0403a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C4933He3.a.C0403a.C0404a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.He3$a$a$a r0 = (ir.nasim.C4933He3.a.C0403a.C0404a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.He3$a$a$a r0 = new ir.nasim.He3$a$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L4e
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    r2 = r6
                    ir.nasim.eF7 r2 = (ir.nasim.C12228eF7) r2
                    java.lang.String r2 = r2.a()
                    java.lang.String r4 = "privacy.last_seen"
                    boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r4)
                    if (r2 == 0) goto L4e
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L4e
                    return r1
                L4e:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4933He3.a.C0403a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0403a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.He3$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.He3$b$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.He3$b$a$a, reason: collision with other inner class name */
            public static final class C0405a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0405a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C4933He3.b.a.C0405a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.He3$b$a$a r0 = (ir.nasim.C4933He3.b.a.C0405a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.He3$b$a$a r0 = new ir.nasim.He3$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.C12228eF7
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4933He3.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.He3$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C4933He3 b;

        /* renamed from: ir.nasim.He3$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C4933He3 b;

            /* renamed from: ir.nasim.He3$c$a$a, reason: collision with other inner class name */
            public static final class C0406a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0406a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C4933He3 c4933He3) {
                this.a = interfaceC4806Gq2;
                this.b = c4933He3;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C4933He3.c.a.C0406a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.He3$c$a$a r0 = (ir.nasim.C4933He3.c.a.C0406a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.He3$c$a$a r0 = new ir.nasim.He3$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L53
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.eF7 r5 = (ir.nasim.C12228eF7) r5
                    java.lang.String r5 = r5.b()
                    if (r5 == 0) goto L45
                    ir.nasim.He3 r2 = r4.b
                    boolean r5 = ir.nasim.C4933He3.a(r2, r5)
                    goto L46
                L45:
                    r5 = 0
                L46:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L53
                    return r1
                L53:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4933He3.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C4933He3 c4933He3) {
            this.a = interfaceC4557Fq2;
            this.b = c4933He3;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C4933He3(SettingsModule settingsModule, FD7 fd7, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(fd7, "updateGateway");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = settingsModule;
        this.b = fd7;
        this.c = interfaceC20315ro1;
        c cVar = new c(new a(new b(fd7.c())), this);
        InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
        Q12.a aVar2 = Q12.b;
        this.d = AbstractC6459Nq2.o0(cVar, interfaceC20315ro1, InterfaceC16863lz6.a.b(aVar, Q12.A(T12.s(5, W12.f)), 0L, 2, null), Boolean.valueOf(c(settingsModule.L2())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(String str) {
        return AbstractC4597Fu6.i("always", ContactEntity.TABLE_NAME).contains(str);
    }

    public final InterfaceC10258bL6 b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4933He3)) {
            return false;
        }
        C4933He3 c4933He3 = (C4933He3) obj;
        return AbstractC13042fc3.d(this.a, c4933He3.a) && AbstractC13042fc3.d(this.b, c4933He3.b) && AbstractC13042fc3.d(this.c, c4933He3.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "IsUserEligibleToSortContactsListByLastSeenUseCase(settingsModule=" + this.a + ", updateGateway=" + this.b + ", scope=" + this.c + Separators.RPAREN;
    }
}
