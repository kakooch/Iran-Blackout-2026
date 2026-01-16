package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC10156bA3;
import ir.nasim.InterfaceC4662Ga2;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.eventbar.data.model.EventBarData;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Fa2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4413Fa2 {
    private final SettingsModule a;
    private final C6409Nm b;
    private final RF2 c;
    private final InterfaceC20315ro1 d;
    private final InterfaceC9336Zm4 e;

    /* renamed from: ir.nasim.Fa2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.Fa2$a$a, reason: collision with other inner class name */
        static final class C0372a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C4413Fa2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0372a(C4413Fa2 c4413Fa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c4413Fa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0372a c0372a = new C0372a(this.d, interfaceC20295rm1);
                c0372a.c = obj;
                return c0372a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                EventBarData.Enabled enabled;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    EventBarData.Enabled enabled2 = (EventBarData.Enabled) this.c;
                    if (enabled2.getEventBarType() == EventBarData.Enabled.a.a) {
                        this.d.a.E6(true);
                    }
                    InterfaceC10156bA3 contentLinkAction = enabled2.getContentLinkAction();
                    this.c = enabled2;
                    this.b = 1;
                    if (InterfaceC10156bA3.b(contentLinkAction, null, false, this, 3, null) == objE) {
                        return objE;
                    }
                    enabled = enabled2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    enabled = (EventBarData.Enabled) this.c;
                    AbstractC10685c16.b(obj);
                }
                this.d.l(enabled, 3);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EventBarData.Enabled enabled, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0372a) create(enabled, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4413Fa2.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                ir.nasim.AbstractC10685c16.b(r7)
                goto L5f
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.b
                ir.nasim.Zm4 r1 = (ir.nasim.InterfaceC9336Zm4) r1
                ir.nasim.AbstractC10685c16.b(r7)
                goto L54
            L26:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L3d
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Fa2$a$a r1 = new ir.nasim.Fa2$a$a
                r1.<init>(r7, r2)
                r6.c = r5
                java.lang.Object r7 = ir.nasim.C4413Fa2.d(r7, r1, r6)
                if (r7 != r0) goto L3d
                return r0
            L3d:
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Zm4 r1 = ir.nasim.C4413Fa2.c(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.RF2 r7 = ir.nasim.C4413Fa2.a(r7)
                r6.b = r1
                r6.c = r4
                java.lang.Object r7 = r7.g(r6)
                if (r7 != r0) goto L54
                return r0
            L54:
                r6.b = r2
                r6.c = r3
                java.lang.Object r7 = r1.a(r7, r6)
                if (r7 != r0) goto L5f
                return r0
            L5f:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4413Fa2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fa2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.Fa2$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C4413Fa2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C4413Fa2 c4413Fa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c4413Fa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EventBarData.Enabled enabled = (EventBarData.Enabled) this.c;
                if (enabled.getEventBarType() == EventBarData.Enabled.a.a) {
                    this.d.a.E6(true);
                } else {
                    C7183Qq.p().putLong("update_event_bar_last_close_in_ms", System.currentTimeMillis());
                }
                this.d.l(enabled, 2);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EventBarData.Enabled enabled, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enabled, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4413Fa2.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                ir.nasim.AbstractC10685c16.b(r7)
                goto L5f
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.b
                ir.nasim.Zm4 r1 = (ir.nasim.InterfaceC9336Zm4) r1
                ir.nasim.AbstractC10685c16.b(r7)
                goto L54
            L26:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L3d
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Fa2$b$a r1 = new ir.nasim.Fa2$b$a
                r1.<init>(r7, r2)
                r6.c = r5
                java.lang.Object r7 = ir.nasim.C4413Fa2.d(r7, r1, r6)
                if (r7 != r0) goto L3d
                return r0
            L3d:
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Zm4 r1 = ir.nasim.C4413Fa2.c(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.RF2 r7 = ir.nasim.C4413Fa2.a(r7)
                r6.b = r1
                r6.c = r4
                java.lang.Object r7 = r7.g(r6)
                if (r7 != r0) goto L54
                return r0
            L54:
                r6.b = r2
                r6.c = r3
                java.lang.Object r7 = r1.a(r7, r6)
                if (r7 != r0) goto L5f
                return r0
            L5f:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4413Fa2.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fa2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.Fa2$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C4413Fa2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C4413Fa2 c4413Fa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c4413Fa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EventBarData.Enabled enabled = (EventBarData.Enabled) this.c;
                if (enabled.getEventBarType() == EventBarData.Enabled.a.a) {
                    SettingsModule settingsModule = this.d.a;
                    settingsModule.F6(settingsModule.D1() + 1);
                }
                this.d.l(enabled, 1);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EventBarData.Enabled enabled, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enabled, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4413Fa2.this.new c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2a
                if (r1 == r5) goto L22
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                ir.nasim.AbstractC10685c16.b(r7)
                goto L5f
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L4f
            L22:
                java.lang.Object r1 = r6.b
                ir.nasim.Zm4 r1 = (ir.nasim.InterfaceC9336Zm4) r1
                ir.nasim.AbstractC10685c16.b(r7)
                goto L44
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Zm4 r1 = ir.nasim.C4413Fa2.c(r7)
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.RF2 r7 = ir.nasim.C4413Fa2.a(r7)
                r6.b = r1
                r6.c = r5
                java.lang.Object r7 = r7.g(r6)
                if (r7 != r0) goto L44
                return r0
            L44:
                r6.b = r2
                r6.c = r4
                java.lang.Object r7 = r1.a(r7, r6)
                if (r7 != r0) goto L4f
                return r0
            L4f:
                ir.nasim.Fa2 r7 = ir.nasim.C4413Fa2.this
                ir.nasim.Fa2$c$a r1 = new ir.nasim.Fa2$c$a
                r1.<init>(r7, r2)
                r6.c = r3
                java.lang.Object r7 = ir.nasim.C4413Fa2.d(r7, r1, r6)
                if (r7 != r0) goto L5f
                return r0
            L5f:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4413Fa2.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fa2$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C4413Fa2.this.k(null, this);
        }
    }

    public C4413Fa2(SettingsModule settingsModule, C6409Nm c6409Nm, RF2 rf2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(rf2, "getEventBarDataUseCase");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = settingsModule;
        this.b = c6409Nm;
        this.c = rf2;
        this.d = interfaceC20315ro1;
        this.e = AbstractC12281eL6.a(EventBarData.Idle.INSTANCE);
    }

    private final void g(InterfaceC4662Ga2.a aVar) {
        AbstractC10533bm0.d(this.d, null, null, new a(null), 3, null);
    }

    private final void h(InterfaceC4662Ga2.b bVar) {
        AbstractC10533bm0.d(this.d, null, null, new b(null), 3, null);
    }

    private final void j(InterfaceC4662Ga2.c cVar) {
        AbstractC10533bm0.d(this.d, null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.InterfaceC14603iB2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C4413Fa2.d
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Fa2$d r0 = (ir.nasim.C4413Fa2.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Fa2$d r0 = new ir.nasim.Fa2$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Zm4 r6 = r4.e
            java.lang.Object r6 = r6.getValue()
            boolean r2 = r6 instanceof ir.nasim.features.eventbar.data.model.EventBarData.Enabled
            if (r2 == 0) goto L41
            ir.nasim.features.eventbar.data.model.EventBarData$Enabled r6 = (ir.nasim.features.eventbar.data.model.EventBarData.Enabled) r6
            goto L42
        L41:
            r6 = 0
        L42:
            if (r6 == 0) goto L4d
            r0.c = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4413Fa2.k(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(EventBarData.Enabled enabled, int i) {
        String lowerCase;
        ExPeerType exPeerType;
        String strName;
        XV4 xv4A = AbstractC4616Fw7.a("notif_id", Long.valueOf(enabled.getEventBarId()));
        XV4 xv4A2 = AbstractC4616Fw7.a("action_type", Integer.valueOf(i));
        ExPeer exPeerC = enabled.getContentLinkAction().c();
        XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(exPeerC != null ? exPeerC.getPeerId() : 0));
        InterfaceC10156bA3 contentLinkAction = enabled.getContentLinkAction();
        if (contentLinkAction instanceof InterfaceC10156bA3.a) {
            lowerCase = "external_url";
        } else if (contentLinkAction instanceof C12179eA3) {
            lowerCase = "deep_link";
        } else {
            ExPeer exPeerC2 = contentLinkAction.c();
            if (exPeerC2 == null || (exPeerType = exPeerC2.getExPeerType()) == null || (strName = exPeerType.name()) == null) {
                lowerCase = null;
            } else {
                lowerCase = strName.toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            }
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        this.b.d("event_bar", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("message_type", enabled.getTitleText()), AbstractC4616Fw7.a("msg_info", enabled.getButtonText())));
    }

    public final InterfaceC10258bL6 f() {
        return AbstractC6459Nq2.c(this.e);
    }

    public final void i(InterfaceC4662Ga2 interfaceC4662Ga2) {
        AbstractC13042fc3.i(interfaceC4662Ga2, "eventBarUiAction");
        if (interfaceC4662Ga2 instanceof InterfaceC4662Ga2.c) {
            j((InterfaceC4662Ga2.c) interfaceC4662Ga2);
        } else if (interfaceC4662Ga2 instanceof InterfaceC4662Ga2.a) {
            g((InterfaceC4662Ga2.a) interfaceC4662Ga2);
        } else {
            if (!(interfaceC4662Ga2 instanceof InterfaceC4662Ga2.b)) {
                throw new NoWhenBranchMatchedException();
            }
            h((InterfaceC4662Ga2.b) interfaceC4662Ga2);
        }
    }
}
