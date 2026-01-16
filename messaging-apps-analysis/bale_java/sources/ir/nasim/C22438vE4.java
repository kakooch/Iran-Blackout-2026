package ir.nasim;

import ai.bale.proto.StoryOuterClass$ResponseSetUserStoryConfig;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC9599aE4;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.vE4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22438vE4 extends VW7 {
    private final CR6 b;
    private InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;

    /* renamed from: ir.nasim.vE4$a */
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
            return C22438vE4.this.W0(this);
        }
    }

    /* renamed from: ir.nasim.vE4$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C22438vE4.this.Y0(this);
        }
    }

    /* renamed from: ir.nasim.vE4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22438vE4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C22438vE4.this.Z0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vE4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22438vE4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C22438vE4.this.a1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vE4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        int g;
        boolean h;
        int i;
        private /* synthetic */ Object j;

        /* renamed from: ir.nasim.vE4$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C22438vE4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22438vE4 c22438vE4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c22438vE4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C22438vE4 c22438vE4 = this.c;
                    this.b = 1;
                    obj = c22438vE4.W0(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vE4$e$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C22438vE4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C22438vE4 c22438vE4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c22438vE4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C22438vE4 c22438vE4 = this.c;
                    this.b = 1;
                    obj = c22438vE4.Y0(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C22438vE4.this.new e(interfaceC20295rm1);
            eVar.j = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00a9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00ce A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00cf -> B:7:0x0031). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22438vE4.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vE4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22438vE4.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object value;
            C21848uE4 c21848uE4;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CR6 cr6 = C22438vE4.this.b;
                XU6 xu6 = XU6.UserConfigKey_LikeStoryNotification;
                boolean z = this.d;
                this.b = 1;
                obj = cr6.c(xu6, z, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b((StoryOuterClass$ResponseSetUserStoryConfig) ((Z06.b) z06).a());
            }
            if (C9475a16.j(objB)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C22438vE4.this.c;
                boolean z2 = this.d;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c21848uE4 = (C21848uE4) value;
                } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : z2, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.vE4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22438vE4.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object value;
            C21848uE4 c21848uE4;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CR6 cr6 = C22438vE4.this.b;
                XU6 xu6 = XU6.UserConfigKey_ContactsStoryNotification;
                boolean z = this.d;
                this.b = 1;
                obj = cr6.c(xu6, z, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b((StoryOuterClass$ResponseSetUserStoryConfig) ((Z06.b) z06).a());
            }
            if (C9475a16.j(objB)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C22438vE4.this.c;
                boolean z2 = this.d;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c21848uE4 = (C21848uE4) value;
                } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : z2, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22438vE4(CR6 cr6) {
        AbstractC13042fc3.i(cr6, "storyNotificationRemoteDataSource");
        this.b = cr6;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C21848uE4(false, false, false, false, null, false, false, false, 255, null));
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.o0(AbstractC6459Nq2.v(AbstractC6459Nq2.c0(AbstractC6459Nq2.c0(interfaceC9336Zm4A, new c(null)), new d(null))), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), new C21848uE4(false, false, false, false, null, false, false, false, 255, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C22438vE4.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.vE4$a r0 = (ir.nasim.C22438vE4.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vE4$a r0 = new ir.nasim.vE4$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.CR6 r5 = r4.b
            ir.nasim.XU6 r2 = ir.nasim.XU6.UserConfigKey_ContactsStoryNotification
            java.util.List r2 = ir.nasim.ZW0.e(r2)
            r0.c = r3
            java.lang.Object r5 = r5.b(r2, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            ir.nasim.Z06 r5 = (ir.nasim.Z06) r5
            boolean r0 = r5 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L5c
            ir.nasim.Z06$a r5 = (ir.nasim.Z06.a) r5
            ir.nasim.core.network.RpcException r5 = r5.a()
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            java.lang.Object r5 = ir.nasim.AbstractC10685c16.a(r5)
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            goto L6e
        L5c:
            boolean r0 = r5 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L99
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r5 = (ir.nasim.Z06.b) r5
            com.google.protobuf.P r5 = r5.a()
            ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig r5 = (ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig) r5
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
        L6e:
            java.lang.Throwable r0 = ir.nasim.C9475a16.e(r5)
            r1 = 0
            if (r0 != 0) goto L94
            ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig r5 = (ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig) r5
            java.util.List r5 = r5.getConfigList()
            if (r5 == 0) goto L8f
            java.lang.Object r5 = ir.nasim.ZW0.s0(r5)
            ai.bale.proto.StoryStruct$UserStoryConfig r5 = (ai.bale.proto.StoryStruct$UserStoryConfig) r5
            if (r5 == 0) goto L8f
            ai.bale.proto.StoryStruct$NotificationConfig r5 = r5.getNotificationConfig()
            if (r5 == 0) goto L8f
            boolean r1 = r5.getIsActive()
        L8f:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r1)
            goto L98
        L94:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r1)
        L98:
            return r5
        L99:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22438vE4.W0(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C22438vE4.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.vE4$b r0 = (ir.nasim.C22438vE4.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.vE4$b r0 = new ir.nasim.vE4$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.CR6 r5 = r4.b
            ir.nasim.XU6 r2 = ir.nasim.XU6.UserConfigKey_LikeStoryNotification
            java.util.List r2 = ir.nasim.ZW0.e(r2)
            r0.c = r3
            java.lang.Object r5 = r5.b(r2, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            ir.nasim.Z06 r5 = (ir.nasim.Z06) r5
            boolean r0 = r5 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L5c
            ir.nasim.Z06$a r5 = (ir.nasim.Z06.a) r5
            ir.nasim.core.network.RpcException r5 = r5.a()
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            java.lang.Object r5 = ir.nasim.AbstractC10685c16.a(r5)
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            goto L6e
        L5c:
            boolean r0 = r5 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L99
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r5 = (ir.nasim.Z06.b) r5
            com.google.protobuf.P r5 = r5.a()
            ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig r5 = (ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig) r5
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
        L6e:
            java.lang.Throwable r0 = ir.nasim.C9475a16.e(r5)
            r1 = 0
            if (r0 != 0) goto L94
            ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig r5 = (ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig) r5
            java.util.List r5 = r5.getConfigList()
            if (r5 == 0) goto L8f
            java.lang.Object r5 = ir.nasim.ZW0.s0(r5)
            ai.bale.proto.StoryStruct$UserStoryConfig r5 = (ai.bale.proto.StoryStruct$UserStoryConfig) r5
            if (r5 == 0) goto L8f
            ai.bale.proto.StoryStruct$NotificationConfig r5 = r5.getNotificationConfig()
            if (r5 == 0) goto L8f
            boolean r1 = r5.getIsActive()
        L8f:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r1)
            goto L98
        L94:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r1)
        L98:
            return r5
        L99:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22438vE4.Y0(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a aVar;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
            aVar = AbstractC9599aE4.a;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : aVar.t(), (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : aVar.r(), (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : aVar.k().toString(), (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : aVar.v(), (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : aVar.u(), (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : aVar.s())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final InterfaceC10258bL6 X0() {
        return this.d;
    }

    public final void b1(boolean z) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.c();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : z)));
    }

    public final void c1(boolean z) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.d();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : z, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
    }

    public final void d1(boolean z) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.f();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : z, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
    }

    public final void e1(boolean z) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.b();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : z, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
    }

    public final void f1(boolean z) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(z, null), 3, null);
    }

    public final void g1(boolean z) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(z, null), 3, null);
    }

    public final void h1(boolean z) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.e();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : z, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : null, (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
    }

    public final void i1(Uri uri) {
        Object value;
        C21848uE4 c21848uE4;
        AbstractC9599aE4.a.B(uri);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
            c21848uE4 = (C21848uE4) value;
        } while (!interfaceC9336Zm4.f(value, c21848uE4.a((WKSRecord.Service.SUR_MEAS & 1) != 0 ? c21848uE4.a : false, (WKSRecord.Service.SUR_MEAS & 2) != 0 ? c21848uE4.b : false, (WKSRecord.Service.SUR_MEAS & 4) != 0 ? c21848uE4.c : false, (WKSRecord.Service.SUR_MEAS & 8) != 0 ? c21848uE4.d : false, (WKSRecord.Service.SUR_MEAS & 16) != 0 ? c21848uE4.e : AbstractC9599aE4.a.k().toString(), (WKSRecord.Service.SUR_MEAS & 32) != 0 ? c21848uE4.f : false, (WKSRecord.Service.SUR_MEAS & 64) != 0 ? c21848uE4.g : false, (WKSRecord.Service.SUR_MEAS & 128) != 0 ? c21848uE4.h : false)));
    }
}
