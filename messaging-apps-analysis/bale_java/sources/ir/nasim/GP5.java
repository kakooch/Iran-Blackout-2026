package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.ReportOuterClass$RequestReportDismiss;
import ai.bale.proto.ReportOuterClass$RequestReportInappropriateContent;
import ai.bale.proto.ReportStruct$InappropriateContentReport;
import ai.bale.proto.ReportStruct$MessageReport;
import ai.bale.proto.ReportStruct$StoryReport;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.StringValue;
import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.List;

/* loaded from: classes5.dex */
public final class GP5 implements FP5 {
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private final C6287Mz c;
    private final InterfaceC14123hO3 d;
    private final InterfaceC14123hO3 e;
    private final InterfaceC14123hO3 f;
    private final SB3 g;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = GP5.this.a(null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ExPeer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = exPeer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GP5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ReportOuterClass$RequestReportDismiss reportOuterClass$RequestReportDismiss = (ReportOuterClass$RequestReportDismiss) ReportOuterClass$RequestReportDismiss.newBuilder().A((PeersStruct$ExPeer) GP5.this.d.a(this.d)).a();
                AbstractC13042fc3.f(reportOuterClass$RequestReportDismiss);
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.report.v1.Report/ReportDismiss", reportOuterClass$RequestReportDismiss, defaultInstance);
                C6287Mz c6287Mz = GP5.this.c;
                this.b = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
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
            if (C9475a16.j(objB)) {
                objB = C19938rB7.a;
            }
            return C9475a16.a(C9475a16.b(objB));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ReportStruct$InappropriateContentReport d;
        final /* synthetic */ InterfaceC8327Vm4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport, InterfaceC8327Vm4 interfaceC8327Vm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = reportStruct$InappropriateContentReport;
            this.e = interfaceC8327Vm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GP5.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objI;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GP5 gp5 = GP5.this;
                ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport = this.d;
                this.b = 1;
                objI = gp5.i(reportStruct$InappropriateContentReport, this);
                if (objI == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
                objI = ((C9475a16) obj).l();
            }
            InterfaceC8327Vm4 interfaceC8327Vm4 = this.e;
            C9475a16 c9475a16A = C9475a16.a(objI);
            this.b = 2;
            if (interfaceC8327Vm4.a(c9475a16A, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            Object objB = GP5.this.b(null, null, null, null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = GP5.this.i(null, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ReportStruct$InappropriateContentReport c;
        final /* synthetic */ GP5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport, GP5 gp5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = reportStruct$InappropriateContentReport;
            this.d = gp5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ReportOuterClass$RequestReportInappropriateContent reportOuterClass$RequestReportInappropriateContent = (ReportOuterClass$RequestReportInappropriateContent) ReportOuterClass$RequestReportInappropriateContent.newBuilder().A(this.c).a();
                AbstractC13042fc3.f(reportOuterClass$RequestReportInappropriateContent);
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.report.v1.Report/ReportInappropriateContent", reportOuterClass$RequestReportInappropriateContent, defaultInstance);
                C6287Mz c6287Mz = this.d.c;
                this.b = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
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
            if (C9475a16.j(objB)) {
                objB = C19938rB7.a;
            }
            return C9475a16.a(C9475a16.b(objB));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public GP5(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, C6287Mz c6287Mz, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33, SB3 sb3) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerToStructExPeerMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "peerSourceToStructPeerSourceMapper");
        AbstractC13042fc3.i(interfaceC14123hO33, "reportTypeToStructReportKindMapper");
        AbstractC13042fc3.i(sb3, "messageIdToStructMessageIdMapper");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
        this.c = c6287Mz;
        this.d = interfaceC14123hO3;
        this.e = interfaceC14123hO32;
        this.f = interfaceC14123hO33;
        this.g = sb3;
    }

    private final InterfaceC4557Fq2 h(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport) {
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        AbstractC10533bm0.d(this.b, null, null, new c(reportStruct$InappropriateContentReport, interfaceC8327Vm4B, null), 3, null);
        return interfaceC8327Vm4B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ai.bale.proto.ReportStruct$InappropriateContentReport r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.GP5.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.GP5$e r0 = (ir.nasim.GP5.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.GP5$e r0 = new ir.nasim.GP5$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.a
            ir.nasim.GP5$f r2 = new ir.nasim.GP5$f
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GP5.i(ai.bale.proto.ReportStruct$InappropriateContentReport, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.FP5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.core.modules.profile.entity.ExPeer r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.GP5.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.GP5$a r0 = (ir.nasim.GP5.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.GP5$a r0 = new ir.nasim.GP5$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.a
            ir.nasim.GP5$b r2 = new ir.nasim.GP5$b
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GP5.a(ir.nasim.core.modules.profile.entity.ExPeer, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.FP5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.core.modules.profile.entity.ExPeer r5, java.lang.String r6, ir.nasim.OP5 r7, ir.nasim.P25 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof ir.nasim.GP5.d
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.GP5$d r0 = (ir.nasim.GP5.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.GP5$d r0 = new ir.nasim.GP5$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r5 = r9.l()
            goto L86
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r9)
            ai.bale.proto.ReportStruct$PeerReport$a r9 = ai.bale.proto.ReportStruct$PeerReport.newBuilder()
            ir.nasim.hO3 r2 = r4.d
            java.lang.Object r5 = r2.a(r5)
            ai.bale.proto.PeersStruct$ExPeer r5 = (ai.bale.proto.PeersStruct$ExPeer) r5
            ai.bale.proto.ReportStruct$PeerReport$a r5 = r9.A(r5)
            ir.nasim.hO3 r9 = r4.e
            java.lang.Object r8 = r9.a(r8)
            ir.nasim.LP5 r8 = (ir.nasim.LP5) r8
            ai.bale.proto.ReportStruct$PeerReport$a r5 = r5.B(r8)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.ReportStruct$PeerReport r5 = (ai.bale.proto.ReportStruct$PeerReport) r5
            ai.bale.proto.ReportStruct$InappropriateContentReport$a r8 = ai.bale.proto.ReportStruct$InappropriateContentReport.newBuilder()
            ai.bale.proto.ReportStruct$InappropriateContentReport$a r6 = r8.A(r6)
            ai.bale.proto.ReportStruct$InappropriateContentReport$a r5 = r6.D(r5)
            ir.nasim.hO3 r6 = r4.f
            java.lang.Object r6 = r6.a(r7)
            ir.nasim.MP5 r6 = (ir.nasim.MP5) r6
            ai.bale.proto.ReportStruct$InappropriateContentReport$a r5 = r5.B(r6)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            ai.bale.proto.ReportStruct$InappropriateContentReport r5 = (ai.bale.proto.ReportStruct$InappropriateContentReport) r5
            ir.nasim.AbstractC13042fc3.f(r5)
            r0.c = r3
            java.lang.Object r5 = r4.i(r5, r0)
            if (r5 != r1) goto L86
            return r1
        L86:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GP5.b(ir.nasim.core.modules.profile.entity.ExPeer, java.lang.String, ir.nasim.OP5, ir.nasim.P25, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.FP5
    public InterfaceC4557Fq2 c(ExPeer exPeer, String str, OP5 op5, List list) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(list, "messageIds");
        ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport = (ReportStruct$InappropriateContentReport) ReportStruct$InappropriateContentReport.newBuilder().A(str).C((ReportStruct$MessageReport) ReportStruct$MessageReport.newBuilder().B((PeersStruct$ExPeer) this.d.a(exPeer)).A((Iterable) this.g.a(list)).a()).B((MP5) this.f.a(op5)).a();
        AbstractC13042fc3.f(reportStruct$InappropriateContentReport);
        return h(reportStruct$InappropriateContentReport);
    }

    @Override // ir.nasim.FP5
    public InterfaceC4557Fq2 d(String str, String str2, OP5 op5) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(op5, "reportType");
        ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport = (ReportStruct$InappropriateContentReport) ReportStruct$InappropriateContentReport.newBuilder().A(str2).E((ReportStruct$StoryReport) ReportStruct$StoryReport.newBuilder().A(StringValue.of(str)).a()).B((MP5) this.f.a(op5)).a();
        AbstractC13042fc3.f(reportStruct$InappropriateContentReport);
        return h(reportStruct$InappropriateContentReport);
    }
}
