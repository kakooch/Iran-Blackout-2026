package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.C13555gR;
import ir.nasim.InterfaceC18892pR;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.OA2;
import ir.nasim.QR;
import ir.nasim.TR;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class SO7 extends VW7 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final NR b;
    private final C13555gR c;
    private final C3514Be3 d;
    private final C6409Nm e;
    private final SettingsModule f;
    private final Context g;
    private TR h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C13555gR.b.values().length];
            try {
                iArr[C13555gR.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C13555gR.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C13555gR.b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C13555gR.b.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SO7.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE;
            Object value2;
            Object value3;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = SO7.this.i;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, true, false, null, false, false, null, false, null, false, null, 4091, null)));
                TR tr = SO7.this.h;
                if (tr == null) {
                    AbstractC13042fc3.y("sourceType");
                    tr = null;
                }
                SR srC = tr.c();
                if (srC == null) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = SO7.this.i;
                    do {
                        value2 = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value2, b.b((b) value2, null, false, false, false, null, false, false, AbstractC6392Nk0.d(AbstractC24800zD5.error_unknown), false, null, false, null, 3963, null)));
                    return C19938rB7.a;
                }
                NR nr = SO7.this.b;
                this.b = 1;
                objE = nr.e(srC, this);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objE = obj;
            }
            QR qr = (QR) objE;
            if (qr instanceof QR.c) {
                boolean zBooleanValue = ((Boolean) ((QR.c) qr).b()).booleanValue();
                if (zBooleanValue) {
                    SO7.this.m1(EnumC3466Az5.b);
                }
                InterfaceC9336Zm4 interfaceC9336Zm43 = SO7.this.i;
                while (true) {
                    Object value4 = interfaceC9336Zm43.getValue();
                    InterfaceC9336Zm4 interfaceC9336Zm44 = interfaceC9336Zm43;
                    if (interfaceC9336Zm44.f(value4, b.b((b) value4, null, false, false, !zBooleanValue, null, zBooleanValue, false, null, false, null, false, null, 4051, null))) {
                        break;
                    }
                    interfaceC9336Zm43 = interfaceC9336Zm44;
                }
            } else {
                if (!(qr instanceof QR.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC9336Zm4 interfaceC9336Zm45 = SO7.this.i;
                do {
                    value3 = interfaceC9336Zm45.getValue();
                } while (!interfaceC9336Zm45.f(value3, b.b((b) value3, null, false, false, false, AbstractC6392Nk0.a(false), false, false, AbstractC6392Nk0.d(AbstractC24800zD5.passcode_not_matched), false, null, false, null, 3947, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = SO7.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            b bVar = (b) this.c;
            return new PO7(!bVar.m(), bVar.h(), bVar.e(), 6, SO7.this.e1(bVar), SO7.this.g1(bVar), SO7.this.i1(bVar), bVar.j(), bVar.c());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SO7.this.new f(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0050 -> B:6:0x0020). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.f
                r3 = 1
                if (r2 == 0) goto L2a
                if (r2 != r3) goto L22
                java.lang.Object r2 = r0.e
                ir.nasim.SO7$b r2 = (ir.nasim.SO7.b) r2
                java.lang.Object r4 = r0.d
                java.lang.Object r5 = r0.c
                ir.nasim.SO7 r5 = (ir.nasim.SO7) r5
                java.lang.Object r6 = r0.b
                ir.nasim.Zm4 r6 = (ir.nasim.InterfaceC9336Zm4) r6
                ir.nasim.AbstractC10685c16.b(r24)
                r7 = r24
            L20:
                r8 = r2
                goto L53
            L22:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L2a:
                ir.nasim.AbstractC10685c16.b(r24)
                ir.nasim.SO7 r2 = ir.nasim.SO7.this
                ir.nasim.Zm4 r2 = ir.nasim.SO7.V0(r2)
                ir.nasim.SO7 r4 = ir.nasim.SO7.this
                r6 = r2
                r5 = r4
            L37:
                java.lang.Object r4 = r6.getValue()
                r2 = r4
                ir.nasim.SO7$b r2 = (ir.nasim.SO7.b) r2
                ir.nasim.NR r7 = ir.nasim.SO7.T0(r5)
                r0.b = r6
                r0.c = r5
                r0.d = r4
                r0.e = r2
                r0.f = r3
                java.lang.Object r7 = r7.f(r0)
                if (r7 != r1) goto L20
                return r1
            L53:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
                ir.nasim.Be3 r7 = ir.nasim.SO7.Y0(r5)
                boolean r15 = r7.a()
                java.lang.Boolean r13 = ir.nasim.AbstractC6392Nk0.a(r2)
                r21 = 4015(0xfaf, float:5.626E-42)
                r22 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                ir.nasim.SO7$b r2 = ir.nasim.SO7.b.b(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                boolean r2 = r6.f(r4, r2)
                if (r2 == 0) goto L37
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SO7.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SO7.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object value;
            Object value2;
            Object value3;
            Object value4;
            Object value5;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TR tr = SO7.this.h;
                if (tr == null) {
                    AbstractC13042fc3.y("sourceType");
                    tr = null;
                }
                SR srC = tr.c();
                if (srC == null) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = SO7.this.i;
                    do {
                        value = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, false, false, null, false, false, AbstractC6392Nk0.d(AbstractC24800zD5.error_unknown), false, null, false, null, 3963, null)));
                    return C19938rB7.a;
                }
                boolean zD = AbstractC13042fc3.d(this.d.d(), AbstractC6392Nk0.a(false));
                NR nr = SO7.this.b;
                String strF = this.d.f();
                this.b = 1;
                objD = nr.d(strF, srC, zD, this);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = obj;
            }
            QR qr = (QR) objD;
            if (qr instanceof QR.c) {
                SO7.this.m1(EnumC3466Az5.c);
                InterfaceC9336Zm4 interfaceC9336Zm42 = SO7.this.i;
                do {
                    value5 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value5, b.b((b) value5, null, false, false, false, null, true, false, null, false, null, false, null, 3035, null)));
            } else {
                if (!(qr instanceof QR.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC18892pR interfaceC18892pRB = ((QR.b) qr).b();
                if (AbstractC13042fc3.d(interfaceC18892pRB, InterfaceC18892pR.d.a)) {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = SO7.this.i;
                    do {
                        value4 = interfaceC9336Zm43.getValue();
                    } while (!interfaceC9336Zm43.f(value4, b.b((b) value4, null, false, false, false, null, false, false, AbstractC6392Nk0.d(AbstractC24800zD5.error_time_out), false, null, true, null, 891, null)));
                } else if (AbstractC13042fc3.d(interfaceC18892pRB, InterfaceC18892pR.c.a)) {
                    InterfaceC9336Zm4 interfaceC9336Zm44 = SO7.this.i;
                    do {
                        value3 = interfaceC9336Zm44.getValue();
                    } while (!interfaceC9336Zm44.f(value3, b.b((b) value3, null, false, false, false, null, false, false, null, false, null, true, AbstractC6392Nk0.d(AbstractC24800zD5.password_retry_limit_exceeded), 1019, null)));
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm45 = SO7.this.i;
                    do {
                        value2 = interfaceC9336Zm45.getValue();
                    } while (!interfaceC9336Zm45.f(value2, b.b((b) value2, null, false, false, false, null, false, false, null, false, null, true, AbstractC6392Nk0.d(AbstractC24800zD5.password_in_correct), 1019, null)));
                }
                C19406qI3.a("ValidatePasswordViewModel", interfaceC18892pRB.toString(), new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public SO7(NR nr, C13555gR c13555gR, C3514Be3 c3514Be3, C6409Nm c6409Nm, SettingsModule settingsModule, Context context) {
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(c13555gR, "authenticateBiometricUseCase");
        AbstractC13042fc3.i(c3514Be3, "isBiometricAuthenticationAvailableUseCase");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(context, "context");
        this.b = nr;
        this.c = c13555gR;
        this.d = c3514Be3;
        this.e = c6409Nm;
        this.f = settingsModule;
        this.g = context;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new b(null, false, false, false, null, false, false, null, false, null, false, null, 4095, null));
        this.i = interfaceC9336Zm4A;
        this.j = AbstractC6459Nq2.o0(AbstractC6459Nq2.c0(AbstractC6459Nq2.X(interfaceC9336Zm4A, new e(null)), new f(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), new PO7(false, false, false, 0, null, null, null, null, null, 511, null));
    }

    private final void a1(FragmentActivity fragmentActivity) {
        C13555gR c13555gR = this.c;
        String string = fragmentActivity.getString(AbstractC24800zD5.features_authenticator_validate_password_biometric_authentication_title);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = fragmentActivity.getString(AbstractC24800zD5.features_authenticator_validate_password_biometric_authentication_description);
        String string3 = fragmentActivity.getString(AbstractC24800zD5.features_authenticator_validate_password_biometric_authentication_negative_button);
        AbstractC13042fc3.h(string3, "getString(...)");
        c13555gR.b(string, string3, fragmentActivity, string2, new UA2() { // from class: ir.nasim.RO7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return SO7.b1(this.a, (C13555gR.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b1(SO7 so7, C13555gR.b bVar) {
        AbstractC13042fc3.i(so7, "this$0");
        AbstractC13042fc3.i(bVar, "result");
        int i = c.a[bVar.ordinal()];
        if (i == 1) {
            so7.d1();
        } else if (i == 2) {
            so7.c1();
        } else if (i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 c1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C23868xf0 e1(b bVar) {
        if (bVar.l() && AbstractC13042fc3.d(bVar.d(), Boolean.TRUE)) {
            return new C23868xf0(AbstractC24800zD5.features_authenticator_validate_password_finger_print_button, JB5.fingerprint, new UA2() { // from class: ir.nasim.QO7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return SO7.f1(this.a, (FragmentActivity) obj);
                }
            }, bVar.m() ? InterfaceC19114po0.a.b.a : InterfaceC19114po0.b.C1454b.a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f1(SO7 so7, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(so7, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "fragmentActivity");
        so7.a1(fragmentActivity);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19114po0 g1(b bVar) {
        return bVar.m() ? OA2.a.b : (bVar.f().length() != 6 || bVar.m()) ? InterfaceC19114po0.a.C1453a.a : InterfaceC19114po0.b.a.a;
    }

    private final void h1() {
        TR tr = this.h;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        String strN2 = tr instanceof TR.c ? this.f.n2() : "";
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, b.b((b) value, null, false, false, false, null, false, false, null, false, strN2, false, null, 3583, null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC14472hy4 i1(b bVar) {
        return (bVar.f().length() != 6 || bVar.i()) ? bVar.f().length() > 0 ? bVar.f().length() == 6 ? bVar.k() != null ? new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.g.getString(bVar.k().intValue()), null, 4, null) : new AbstractC14472hy4.a(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.g.getString(AbstractC24800zD5.passwords_length_error), null, 4, null) : bVar.g() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null) : bVar.g() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null);
    }

    private final void l1(TR.a aVar) {
        this.e.d("authentication_bot", AbstractC20051rO3.m(AbstractC4616Fw7.a("peer_id", Integer.valueOf(aVar.f())), AbstractC4616Fw7.a("peer_type", aVar.b()), AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Integer.valueOf(aVar.d())), AbstractC4616Fw7.a("random_id", Integer.valueOf(aVar.a())), AbstractC4616Fw7.a("source_type", Integer.valueOf(aVar.e().j()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(EnumC3466Az5 enumC3466Az5) {
        TR tr = this.h;
        TR tr2 = null;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        TR.a aVar = tr instanceof TR.a ? (TR.a) tr : null;
        if (aVar != null) {
            l1(aVar);
        }
        HashMap map = new HashMap();
        map.put("action_type", Integer.valueOf(EnumC18301oR.c.j()));
        TR tr3 = this.h;
        if (tr3 == null) {
            AbstractC13042fc3.y("sourceType");
            tr3 = null;
        }
        map.put("source_type", tr3.b());
        map.put("query_type", Integer.valueOf(enumC3466Az5.j()));
        TR tr4 = this.h;
        if (tr4 == null) {
            AbstractC13042fc3.y("sourceType");
        } else {
            tr2 = tr4;
        }
        map.put("random_id", Integer.valueOf(tr2.a()));
        this.e.d("authenticator", map);
    }

    public final void d1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, false, false, null, false, false, null, false, null, false, null, 4031, null)));
    }

    public final InterfaceC10258bL6 j1() {
        return this.j;
    }

    public final void k1(String str) {
        AbstractC13042fc3.i(str, "pass");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, b.b((b) value, str, true, false, false, null, false, false, null, false, null, false, null, 1020, null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final void o1(TR tr) {
        AbstractC13042fc3.i(tr, "eventSourceType");
        this.h = tr;
        h1();
    }

    public final void p1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, false, false, false, null, false, false, null, false, null, false, null, 3967, null)));
    }

    public final void q1() {
        Object value;
        b bVarB;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            bVarB = b.b((b) value, null, false, true, false, null, false, false, null, false, null, false, null, 4091, null);
        } while (!interfaceC9336Zm4.f(value, bVarB));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(bVarB, null), 3, null);
    }

    private static final class b {
        private final String a;
        private final boolean b;
        private final boolean c;
        private final boolean d;
        private final Boolean e;
        private final boolean f;
        private final boolean g;
        private final Integer h;
        private final boolean i;
        private final String j;
        private final boolean k;
        private final Integer l;

        public b(String str, boolean z, boolean z2, boolean z3, Boolean bool, boolean z4, boolean z5, Integer num, boolean z6, String str2, boolean z7, Integer num2) {
            AbstractC13042fc3.i(str, "pass");
            AbstractC13042fc3.i(str2, "descriptionText");
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = bool;
            this.f = z4;
            this.g = z5;
            this.h = num;
            this.i = z6;
            this.j = str2;
            this.k = z7;
            this.l = num2;
        }

        public static /* synthetic */ b b(b bVar, String str, boolean z, boolean z2, boolean z3, Boolean bool, boolean z4, boolean z5, Integer num, boolean z6, String str2, boolean z7, Integer num2, int i, Object obj) {
            return bVar.a((i & 1) != 0 ? bVar.a : str, (i & 2) != 0 ? bVar.b : z, (i & 4) != 0 ? bVar.c : z2, (i & 8) != 0 ? bVar.d : z3, (i & 16) != 0 ? bVar.e : bool, (i & 32) != 0 ? bVar.f : z4, (i & 64) != 0 ? bVar.g : z5, (i & 128) != 0 ? bVar.h : num, (i & 256) != 0 ? bVar.i : z6, (i & 512) != 0 ? bVar.j : str2, (i & 1024) != 0 ? bVar.k : z7, (i & 2048) != 0 ? bVar.l : num2);
        }

        public final b a(String str, boolean z, boolean z2, boolean z3, Boolean bool, boolean z4, boolean z5, Integer num, boolean z6, String str2, boolean z7, Integer num2) {
            AbstractC13042fc3.i(str, "pass");
            AbstractC13042fc3.i(str2, "descriptionText");
            return new b(str, z, z2, z3, bool, z4, z5, num, z6, str2, z7, num2);
        }

        public final String c() {
            return this.j;
        }

        public final Boolean d() {
            return this.e;
        }

        public final boolean e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && this.f == bVar.f && this.g == bVar.g && AbstractC13042fc3.d(this.h, bVar.h) && this.i == bVar.i && AbstractC13042fc3.d(this.j, bVar.j) && this.k == bVar.k && AbstractC13042fc3.d(this.l, bVar.l);
        }

        public final String f() {
            return this.a;
        }

        public final boolean g() {
            return this.b;
        }

        public final boolean h() {
            return this.f;
        }

        public int hashCode() {
            int iHashCode = ((((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
            Boolean bool = this.e;
            int iHashCode2 = (((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31;
            Integer num = this.h;
            int iHashCode3 = (((((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Boolean.hashCode(this.k)) * 31;
            Integer num2 = this.l;
            return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
        }

        public final boolean i() {
            return this.k;
        }

        public final Integer j() {
            return this.h;
        }

        public final Integer k() {
            return this.l;
        }

        public final boolean l() {
            return this.g;
        }

        public final boolean m() {
            return this.c;
        }

        public String toString() {
            return "InnerState(pass=" + this.a + ", passHasFocus=" + this.b + ", isRequesting=" + this.c + ", localPasswordIsNotValid=" + this.d + ", hasLocalPassword=" + this.e + ", passwordValidationCompleted=" + this.f + ", isBiometricAuthenticationAvailable=" + this.g + ", snackbarMessage=" + this.h + ", isPasscodeMatched=" + this.i + ", descriptionText=" + this.j + ", shouldShowError=" + this.k + ", textFieldErrorMessage=" + this.l + Separators.RPAREN;
        }

        public /* synthetic */ b(String str, boolean z, boolean z2, boolean z3, Boolean bool, boolean z4, boolean z5, Integer num, boolean z6, String str2, boolean z7, Integer num2, int i, ED1 ed1) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? null : num, (i & 256) == 0 ? z6 : true, (i & 512) == 0 ? str2 : "", (i & 1024) == 0 ? z7 : false, (i & 2048) == 0 ? num2 : null);
        }
    }
}
