package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AA3;
import ir.nasim.AbstractC12797fB3;
import ir.nasim.AbstractC4600Fv0;
import ir.nasim.InterfaceC22053ub1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Pv0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC6985Pv0 {

    /* renamed from: ir.nasim.Pv0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19391qG6 c19391qG6, String str, String str2, String str3, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC4600Fv0 abstractC4600Fv0D = AbstractC6985Pv0.d(this.g);
                AbstractC4600Fv0.c cVar = abstractC4600Fv0D instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) abstractC4600Fv0D : null;
                AbstractC12797fB3 abstractC12797fB3K = cVar != null ? cVar.k() : null;
                if (abstractC12797fB3K instanceof AbstractC12797fB3.a) {
                    if (((AbstractC12797fB3.a) abstractC12797fB3K).a()) {
                        C19391qG6 c19391qG6 = this.c;
                        String str = this.d;
                        this.b = 1;
                        if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
                            return objE;
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } else if (abstractC12797fB3K instanceof AbstractC12797fB3.b) {
                    C19391qG6 c19391qG62 = this.c;
                    String str2 = this.e;
                    this.b = 2;
                    if (C19391qG6.f(c19391qG62, str2, null, false, null, this, 14, null) == objE) {
                        return objE;
                    }
                } else {
                    if (AbstractC6985Pv0.d(this.g) instanceof AbstractC4600Fv0.d) {
                        C19391qG6 c19391qG63 = this.c;
                        String str3 = this.f;
                        this.b = 3;
                        if (C19391qG6.f(c19391qG63, str3, null, false, null, this, 14, null) == objE) {
                            return objE;
                        }
                    }
                    C19938rB7 c19938rB72 = C19938rB7.a;
                }
            } else if (i == 1) {
                AbstractC10685c16.b(obj);
                C19938rB7 c19938rB73 = C19938rB7.a;
            } else if (i == 2) {
                AbstractC10685c16.b(obj);
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C19938rB7 c19938rB722 = C19938rB7.a;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void c(final InterfaceC10258bL6 interfaceC10258bL6, final SA2 sa2, final UA2 ua2, final SA2 sa22, final SA2 sa23, final SA2 sa24, final UA2 ua22, final UA2 ua23, final SA2 sa25, final SA2 sa26, final String str, final String str2, final String str3, final String str4, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        int i5;
        AA3 aa3J;
        int i6;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "linkGenerationUiStateFlow");
        AbstractC13042fc3.i(sa2, "onShareLinkClicked");
        AbstractC13042fc3.i(ua2, "onJoinCallClicked");
        AbstractC13042fc3.i(sa22, "onRegenerateLinkPressed");
        AbstractC13042fc3.i(sa23, "onCopyLinkPressed");
        AbstractC13042fc3.i(sa24, "onBackPressed");
        AbstractC13042fc3.i(ua22, "onLinkTitleValueChanged");
        AbstractC13042fc3.i(ua23, "onContactsSelected");
        AbstractC13042fc3.i(sa25, "onNavigateToShareLinkWithContactClicked");
        AbstractC13042fc3.i(sa26, "onNavigateToGenerateLink");
        AbstractC13042fc3.i(str, "linkExpirationToastMessage");
        AbstractC13042fc3.i(str2, "linkGenerationFailedToastMessage");
        AbstractC13042fc3.i(str3, "linkCopiedToastMessage");
        AbstractC13042fc3.i(str4, "linkPlaceHolder");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1395375486);
        if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(sa24) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(ua23) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(sa25) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(sa26) ? 536870912 : 268435456;
        }
        int i7 = i4;
        if ((i3 & 6) == 0) {
            i5 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= interfaceC22053ub1J.V(str3) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= interfaceC22053ub1J.V(str4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        if ((i7 & 306783379) == 306783378 && (i5 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            int i8 = i5;
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i7 & 14, 7);
            interfaceC22053ub1J.W(-1097135923);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            InterfaceC3630Br2 interfaceC3630Br2 = (InterfaceC3630Br2) interfaceC22053ub1J.H(AbstractC13040fc1.h());
            AbstractC4600Fv0 abstractC4600Fv0D = d(interfaceC9664aL6C);
            interfaceC22053ub1J.W(-1097131159);
            boolean zV = interfaceC22053ub1J.V(abstractC4600Fv0D);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == aVar.a()) {
                AbstractC4600Fv0 abstractC4600Fv0D2 = d(interfaceC9664aL6C);
                if (abstractC4600Fv0D2 instanceof AbstractC4600Fv0.b) {
                    aa3J = AA3.b.a;
                } else if ((abstractC4600Fv0D2 instanceof AbstractC4600Fv0.a) || (abstractC4600Fv0D2 instanceof AbstractC4600Fv0.d)) {
                    aa3J = AA3.a.a;
                } else {
                    if (!(abstractC4600Fv0D2 instanceof AbstractC4600Fv0.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    aa3J = ((AbstractC4600Fv0.c) abstractC4600Fv0D2).j();
                }
                objB2 = AbstractC13472gH6.d(aa3J, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AA3 aa3E = e((InterfaceC9102Ym4) objB2);
            if (AbstractC13042fc3.d(aa3E, AA3.c.a)) {
                interfaceC22053ub1J.W(349279235);
                interfaceC22053ub1J.W(-1097109793);
                boolean z = (i7 & 1879048192) == 536870912;
                Object objB3 = interfaceC22053ub1J.B();
                if (z || objB3 == aVar.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Nv0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC6985Pv0.f(sa26);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                interfaceC22053ub1J.Q();
                AbstractC5944Lm6.d((SA2) objB3, UY6.c(BD5.features_call_contacts_list_title, interfaceC22053ub1J, 0), ua23, UY6.c(BD5.features_call_contacts_list_submit, interfaceC22053ub1J, 0), null, interfaceC22053ub1J, (i7 >> 15) & 896, 16);
                interfaceC22053ub1J.Q();
            } else if (AbstractC13042fc3.d(aa3E, AA3.b.a)) {
                interfaceC22053ub1J.W(349668781);
                int i9 = i7 >> 12;
                AbstractC5785Kv0.b(d(interfaceC9664aL6C), sa24, ua22, sa26, i, interfaceC3630Br2, interfaceC22053ub1J, (i9 & 896) | (i9 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i7 >> 18) & 7168) | (57344 & i8));
                interfaceC22053ub1J.Q();
            } else {
                if (!AbstractC13042fc3.d(aa3E, AA3.a.a)) {
                    interfaceC22053ub1J.W(-1097111526);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(350141934);
                int i10 = i7 << 15;
                AbstractC4366Ev0.b(interfaceC3630Br2, sa24, d(interfaceC9664aL6C), ua22, i, sa2, sa23, ua2, sa22, sa25, str4, c19391qG6, interfaceC22053ub1J, ((i7 >> 12) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i7 >> 9) & 7168) | (57344 & i8) | ((i7 << 12) & 458752) | ((i7 << 6) & 3670016) | (i10 & 29360128) | (i10 & 234881024) | ((i7 << 3) & 1879048192), ((i8 >> 9) & 14) | 48);
                AbstractC4600Fv0 abstractC4600Fv0D3 = d(interfaceC9664aL6C);
                interfaceC22053ub1J.W(-1097066561);
                boolean zV2 = interfaceC22053ub1J.V(interfaceC9664aL6C) | ((i8 & 14) == 4) | ((i8 & 896) == 256) | ((i8 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
                Object objB4 = interfaceC22053ub1J.B();
                if (zV2 || objB4 == aVar.a()) {
                    i6 = 0;
                    interfaceC22053ub12 = interfaceC22053ub1J;
                    a aVar2 = new a(c19391qG6, str, str3, str2, interfaceC9664aL6C, null);
                    interfaceC22053ub12.s(aVar2);
                    objB4 = aVar2;
                } else {
                    i6 = 0;
                    interfaceC22053ub12 = interfaceC22053ub1J;
                }
                interfaceC22053ub12.Q();
                AbstractC10721c52.e(abstractC4600Fv0D3, (InterfaceC14603iB2) objB4, interfaceC22053ub12, i6);
                interfaceC22053ub12.Q();
            }
            interfaceC22053ub12 = interfaceC22053ub1J;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ov0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6985Pv0.g(interfaceC10258bL6, sa2, ua2, sa22, sa23, sa24, ua22, ua23, sa25, sa26, str, str2, str3, str4, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC4600Fv0 d(InterfaceC9664aL6 interfaceC9664aL6) {
        return (AbstractC4600Fv0) interfaceC9664aL6.getValue();
    }

    private static final AA3 e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (AA3) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onNavigateToGenerateLink");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2, UA2 ua2, SA2 sa22, SA2 sa23, SA2 sa24, UA2 ua22, UA2 ua23, SA2 sa25, SA2 sa26, String str, String str2, String str3, String str4, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$linkGenerationUiStateFlow");
        AbstractC13042fc3.i(sa2, "$onShareLinkClicked");
        AbstractC13042fc3.i(ua2, "$onJoinCallClicked");
        AbstractC13042fc3.i(sa22, "$onRegenerateLinkPressed");
        AbstractC13042fc3.i(sa23, "$onCopyLinkPressed");
        AbstractC13042fc3.i(sa24, "$onBackPressed");
        AbstractC13042fc3.i(ua22, "$onLinkTitleValueChanged");
        AbstractC13042fc3.i(ua23, "$onContactsSelected");
        AbstractC13042fc3.i(sa25, "$onNavigateToShareLinkWithContactClicked");
        AbstractC13042fc3.i(sa26, "$onNavigateToGenerateLink");
        AbstractC13042fc3.i(str, "$linkExpirationToastMessage");
        AbstractC13042fc3.i(str2, "$linkGenerationFailedToastMessage");
        AbstractC13042fc3.i(str3, "$linkCopiedToastMessage");
        AbstractC13042fc3.i(str4, "$linkPlaceHolder");
        c(interfaceC10258bL6, sa2, ua2, sa22, sa23, sa24, ua22, ua23, sa25, sa26, str, str2, str3, str4, i, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3));
        return C19938rB7.a;
    }
}
