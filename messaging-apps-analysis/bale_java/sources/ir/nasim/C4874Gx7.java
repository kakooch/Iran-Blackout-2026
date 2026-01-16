package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Patterns;
import ir.nasim.P72;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Gx7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4874Gx7 extends VW7 {
    public static final a n = new a(null);
    public static final int o = 8;
    private final MQ b;
    private final Context c;
    private final InterfaceC19567qa2 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC9336Zm4 j;
    private String k;
    private final InterfaceC9336Zm4 l;
    private String m;

    /* renamed from: ir.nasim.Gx7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Gx7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SA2 sa2, SA2 sa22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
            this.e = sa22;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            String message;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MQ mq = C4874Gx7.this.b;
                this.b = 1;
                objL = mq.l(this);
                if (objL == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            SA2 sa2 = this.d;
            if (C9475a16.j(objL)) {
                c4874Gx7.d.b("disable_2fa_password");
                sa2.invoke();
            }
            SA2 sa22 = this.e;
            Throwable thE = C9475a16.e(objL);
            if (thE != null && (message = thE.getMessage()) != null && AbstractC20762sZ6.X(message, "PermissionDenied", false, 2, null)) {
                sa22.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4874Gx7.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objB;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4874Gx7.this.f;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, P72.c.a));
                MQ mq = C4874Gx7.this.b;
                this.b = 1;
                objB = mq.b(this);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            if (C9475a16.j(objB)) {
                boolean zBooleanValue = ((Boolean) objB).booleanValue();
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx7.f;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, new P72.d(zBooleanValue)));
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c4874Gx72.f;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, new P72.a(thE)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objI;
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4874Gx7.this.d.a("email_validation_code", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                C4874Gx7.this.d.a("click_2fa_forget_password", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(2))));
                MQ mq = C4874Gx7.this.b;
                this.b = 1;
                objI = mq.i(null, this);
                if (objI == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objI = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            if (C9475a16.j(objI)) {
                String str = (String) objI;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c4874Gx7.l;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, C12880fK5.b((C12880fK5) value2, str, null, null, false, null, null, 90, 60, null)));
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            if (C9475a16.e(objI) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx72.l;
                do {
                    value = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value, C12880fK5.b((C12880fK5) value, null, c4874Gx72.c.getString(QD5.auth_error_unknown), null, false, null, null, 0, 125, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MQ mq = C4874Gx7.this.b;
                String strC = ((N52) C4874Gx7.this.i.getValue()).c();
                String strD = ((A05) C4874Gx7.this.h.getValue()).d();
                this.b = 1;
                objF = mq.f(strC, strD, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            if (C9475a16.j(objF)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c4874Gx7.j;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, C10902cO7.b((C10902cO7) value2, null, null, false, false, 90, 13, null)));
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            if (C9475a16.e(objF) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx72.j;
                do {
                    value = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value, C10902cO7.b((C10902cO7) value, null, c4874Gx72.c.getString(QD5.auth_error_unknown), false, false, 0, 29, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ String g;
        final /* synthetic */ SA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = str;
            this.h = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new g(this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                java.lang.Object r0 = r7.d
                ir.nasim.SA2 r0 = (ir.nasim.SA2) r0
                java.lang.Object r1 = r7.c
                ir.nasim.Gx7 r1 = (ir.nasim.C4874Gx7) r1
                java.lang.Object r2 = r7.b
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
                r8.l()
                goto L6c
            L21:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L29:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
                java.lang.Object r8 = r8.l()
                goto L48
            L33:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.Gx7 r8 = ir.nasim.C4874Gx7.this
                ir.nasim.MQ r8 = ir.nasim.C4874Gx7.P0(r8)
                java.lang.String r1 = r7.g
                r7.e = r3
                r4 = 0
                java.lang.Object r8 = r8.m(r1, r4, r7)
                if (r8 != r0) goto L48
                return r0
            L48:
                ir.nasim.Gx7 r1 = ir.nasim.C4874Gx7.this
                java.lang.String r4 = r7.g
                ir.nasim.SA2 r5 = r7.h
                boolean r6 = ir.nasim.C9475a16.j(r8)
                if (r6 == 0) goto L87
                r6 = r8
                ir.nasim.rB7 r6 = (ir.nasim.C19938rB7) r6
                ir.nasim.MQ r6 = ir.nasim.C4874Gx7.P0(r1)
                r7.b = r8
                r7.c = r1
                r7.d = r5
                r7.e = r2
                java.lang.Object r2 = r6.d(r4, r7)
                if (r2 != r0) goto L6a
                return r0
            L6a:
                r2 = r8
                r0 = r5
            L6c:
                ir.nasim.qa2 r8 = ir.nasim.C4874Gx7.S0(r1)
                java.lang.String r1 = "action_type"
                java.lang.Integer r3 = ir.nasim.AbstractC6392Nk0.d(r3)
                ir.nasim.XV4 r1 = ir.nasim.AbstractC4616Fw7.a(r1, r3)
                java.util.Map r1 = ir.nasim.AbstractC18278oO3.g(r1)
                java.lang.String r3 = "set_2fa_password"
                r8.a(r3, r1)
                r0.invoke()
                r8 = r2
            L87:
                ir.nasim.Gx7 r0 = ir.nasim.C4874Gx7.this
                java.lang.Throwable r8 = ir.nasim.C9475a16.e(r8)
                if (r8 == 0) goto La1
                android.content.Context r8 = ir.nasim.C4874Gx7.R0(r0)
                int r1 = ir.nasim.QD5.auth_error_unknown
                java.lang.String r8 = r8.getString(r1)
                java.lang.String r1 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r8, r1)
                r0.x1(r8)
            La1:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4874Gx7.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objD;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4874Gx7.this.d.a("click_2fa_enter_button", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(2))));
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4874Gx7.this.e;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C17100mO7.b((C17100mO7) value, null, null, false, true, 7, null)));
                MQ mq = C4874Gx7.this.b;
                String str = this.d;
                this.b = 1;
                objD = mq.d(str, this);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            if (C9475a16.j(objD)) {
                c4874Gx7.d.a("success_2fa_enter", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(2))));
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx7.e;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, C17100mO7.b((C17100mO7) value3, null, null, true, false, 1, null)));
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            if (C9475a16.e(objD) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c4874Gx72.e;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, C17100mO7.b((C17100mO7) value2, null, c4874Gx72.c.getString(QD5.two_f_a_in_correct), false, false, 5, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objH;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4874Gx7.this.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C10902cO7.b((C10902cO7) value, null, null, true, false, 0, 27, null)));
                MQ mq = C4874Gx7.this.b;
                String strC = ((N52) C4874Gx7.this.i.getValue()).c();
                String strB = GY6.b(this.d);
                this.b = 1;
                objH = mq.h(strC, strB, this);
                if (objH == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objH = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            if (C9475a16.j(objH)) {
                c4874Gx7.d.a("set_2fa_password", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(2))));
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx7.j;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, C10902cO7.b((C10902cO7) value3, null, null, false, true, 0, 17, null)));
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            if (C9475a16.e(objH) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c4874Gx72.j;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, C10902cO7.b((C10902cO7) value2, null, c4874Gx72.c.getString(QD5.two_f_a_code_email_invalid), false, false, 0, 25, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Gx7$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4874Gx7.this.new j(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objJ;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4874Gx7.this.l;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C12880fK5.b((C12880fK5) value, null, null, null, true, null, null, 0, 119, null)));
                MQ mq = C4874Gx7.this.b;
                String strB = GY6.b(this.d);
                this.b = 1;
                objJ = mq.j(strB, null, this);
                if (objJ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objJ = ((C9475a16) obj).l();
            }
            C4874Gx7 c4874Gx7 = C4874Gx7.this;
            SA2 sa2 = this.e;
            if (C9475a16.j(objJ)) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4874Gx7.l;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value2, C12880fK5.b((C12880fK5) value2, null, null, null, true, null, null, 0, WKSRecord.Service.UUCP_PATH, null)));
                sa2.invoke();
            }
            C4874Gx7 c4874Gx72 = C4874Gx7.this;
            if (C9475a16.e(objJ) != null) {
                String string = c4874Gx72.c.getString(QD5.two_f_a_code_email_invalid);
                AbstractC13042fc3.h(string, "getString(...)");
                c4874Gx72.C1(string);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4874Gx7(MQ mq, Context context, InterfaceC19567qa2 interfaceC19567qa2) {
        AbstractC13042fc3.i(mq, "authRepository");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        this.b = mq;
        this.c = context;
        this.d = interfaceC19567qa2;
        this.e = AbstractC12281eL6.a(new C17100mO7(null, null, false, false, 15, null));
        this.f = AbstractC12281eL6.a(P72.b.a);
        this.g = AbstractC12281eL6.a(new A05(null, null, 3, null));
        this.h = AbstractC12281eL6.a(new A05(null, null, 3, null));
        this.i = AbstractC12281eL6.a(new N52(null, null, false, false, 15, null));
        this.j = AbstractC12281eL6.a(new C10902cO7(null, null, false, false, 0, 31, null));
        this.k = "";
        this.l = AbstractC12281eL6.a(new C12880fK5(null, null, null, false, null, null, 0, 127, null));
        this.m = "";
    }

    public final void A1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, A05.b((A05) value, null, str, 1, null)));
    }

    public final void B1(String str) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ((A05) value).a(str, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.h;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, ((A05) value2).a("", null)));
    }

    public final void C1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b((C12880fK5) value, null, str, null, false, null, null, 0, WKSRecord.Service.UUCP_PATH, null)));
    }

    public final void D1(String str) {
        Object value;
        C12880fK5 c12880fK5;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
            c12880fK5 = (C12880fK5) value;
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b(c12880fK5, null, null, null, false, c12880fK5.g().a(str, null), null, 0, WKSRecord.Service.SUNRPC, null)));
    }

    public final void E1(String str) {
        Object value;
        C12880fK5 c12880fK5;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
            c12880fK5 = (C12880fK5) value;
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b(c12880fK5, null, null, null, false, A05.b(c12880fK5.g(), null, str, 1, null), null, 0, WKSRecord.Service.SUNRPC, null)));
    }

    public final void F1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C10902cO7.b((C10902cO7) value, null, null, false, false, r2.e() - 1, 15, null)));
    }

    public final void G1(String str) {
        Object value;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17100mO7.b((C17100mO7) value, str, null, false, false, 14, null)));
    }

    public final void H1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C10902cO7.b((C10902cO7) value, null, str, false, false, 0, 29, null)));
    }

    public final void I1(String str) {
        Object value;
        C10902cO7 c10902cO7;
        AbstractC13042fc3.i(str, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
            c10902cO7 = (C10902cO7) value;
            if (str.length() == 6 && !AbstractC13042fc3.d(this.k, str)) {
                this.k = str;
                K1(AbstractC20762sZ6.n1(str).toString());
            }
        } while (!interfaceC9336Zm4.f(value, C10902cO7.b(c10902cO7, AbstractC12152e76.b(str), null, false, false, 0, 28, null)));
    }

    public final InterfaceC13730gj3 J1(String str) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(str, null), 3, null);
    }

    public final InterfaceC13730gj3 K1(String str) {
        AbstractC13042fc3.i(str, "code");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(str, null), 3, null);
    }

    public final InterfaceC13730gj3 L1(String str, SA2 sa2) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(sa2, "codeValidated");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(str, sa2, null), 3, null);
    }

    public final InterfaceC13730gj3 Z0(SA2 sa2, SA2 sa22) {
        AbstractC13042fc3.i(sa2, "onSuccess");
        AbstractC13042fc3.i(sa22, "codeExpired");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(sa2, sa22, null), 3, null);
    }

    public final InterfaceC13730gj3 a1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final InterfaceC10258bL6 b1() {
        return AbstractC6459Nq2.c(this.h);
    }

    public final InterfaceC10258bL6 c1() {
        return AbstractC6459Nq2.c(this.f);
    }

    public final InterfaceC10258bL6 d1() {
        return AbstractC6459Nq2.c(this.e);
    }

    public final InterfaceC10258bL6 e1() {
        return AbstractC6459Nq2.c(this.g);
    }

    public final InterfaceC10258bL6 f1() {
        return AbstractC6459Nq2.c(this.l);
    }

    public final InterfaceC10258bL6 g1() {
        return AbstractC6459Nq2.c(this.i);
    }

    public final InterfaceC10258bL6 h1() {
        return AbstractC6459Nq2.c(this.j);
    }

    public final InterfaceC13730gj3 i1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    public final boolean j1(String str) {
        AbstractC13042fc3.i(str, "target");
        if (!(!(str.length() == 0))) {
            str = null;
        }
        if (str != null) {
            return Patterns.EMAIL_ADDRESS.matcher(str).matches();
        }
        return false;
    }

    public final void k1() {
        Object value;
        Object value2;
        Object value3;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, N52.b((N52) value, null, null, false, false, 7, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.j;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, C10902cO7.b((C10902cO7) value2, null, null, false, false, 0, 23, null)));
        InterfaceC9336Zm4 interfaceC9336Zm43 = this.e;
        do {
            value3 = interfaceC9336Zm43.getValue();
        } while (!interfaceC9336Zm43.f(value3, C17100mO7.b((C17100mO7) value3, null, null, false, false, 11, null)));
    }

    public final InterfaceC13730gj3 l1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final InterfaceC13730gj3 m1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    public final void o1() {
        Object value;
        Object value2;
        Object value3;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new A05(null, null, 3, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.h;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, new A05(null, null, 3, null)));
        InterfaceC9336Zm4 interfaceC9336Zm43 = this.i;
        do {
            value3 = interfaceC9336Zm43.getValue();
        } while (!interfaceC9336Zm43.f(value3, new N52(null, null, false, false, 15, null)));
    }

    public final InterfaceC13730gj3 p1(String str, SA2 sa2) {
        AbstractC13042fc3.i(str, "newPassword");
        AbstractC13042fc3.i(sa2, "onDone");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(str, sa2, null), 3, null);
    }

    public final void q1(String str, SA2 sa2) {
        Object value;
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(sa2, "codeValidated");
        if (str.length() == 6 && !AbstractC13042fc3.d(this.m, str)) {
            this.m = str;
            L1(AbstractC20762sZ6.n1(str).toString(), sa2);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b((C12880fK5) value, null, null, AbstractC12152e76.b(str), false, null, null, 0, WKSRecord.Service.ERPC, null)));
    }

    public final void s1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, N52.b((N52) value, null, str, false, false, 13, null)));
    }

    public final void t1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "email");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, N52.b((N52) value, str, null, false, false, 12, null)));
    }

    public final void u1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, A05.b((A05) value, null, str, 1, null)));
    }

    public final void v1(String str) {
        Object value;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ((A05) value).a(str, null)));
    }

    public final void w1(String str) {
        Object value;
        C12880fK5 c12880fK5;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
            c12880fK5 = (C12880fK5) value;
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b(c12880fK5, null, null, null, false, null, c12880fK5.d().a(str, null), 0, 95, null)));
    }

    public final void x1(String str) {
        Object value;
        C12880fK5 c12880fK5;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
            c12880fK5 = (C12880fK5) value;
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b(c12880fK5, null, null, null, false, null, A05.b(c12880fK5.d(), null, str, 1, null), 0, 95, null)));
    }

    public final void y1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C12880fK5.b((C12880fK5) value, null, null, null, false, null, null, r2.h() - 1, 63, null)));
    }

    public final void z1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C17100mO7.b((C17100mO7) value, null, str, false, false, 13, null)));
    }
}
