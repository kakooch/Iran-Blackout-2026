package ir.nasim;

import ai.bale.proto.MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates;
import ai.bale.proto.MessagingOuterClass$RequestGetMessagesRepliesInfo;
import ai.bale.proto.MessagingOuterClass$ResponseGetMessagesRepliesInfo;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class F84 {
    public static final a l = new a(null);
    public static final int m = 8;
    private static J44 n;
    private final InterfaceC20315ro1 a;
    private final Context b;
    private final AbstractC13778go1 c;
    private final E84 d;
    private final InterfaceC16847ly e;
    private final C10299bQ2 f;
    private final OK7 g;
    private final CB7 h;
    private final InterfaceC19483qR i;
    private final SB3 j;
    private C10508bj5 k;

    public static final class a {
        private a() {
        }

        public final J44 a() {
            return F84.n;
        }

        public final void b(J44 j44) {
            F84.n = j44;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC4707Gf2.values().length];
            try {
                iArr2[EnumC4707Gf2.LinkStatus_APPROVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC4707Gf2.LinkStatus_BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC4707Gf2.LinkStatus_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC4707Gf2.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        long b;
        long c;
        int d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return F84.this.k(0L, 0L, 0, 0, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        long b;
        long c;
        int d;
        /* synthetic */ Object e;
        int g;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return F84.this.l(0L, 0L, 0, this);
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
            Object objN = F84.this.n(null, this);
            return objN == AbstractC14862ic3.e() ? objN : C9475a16.a(objN);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = F84.this.new f(interfaceC20295rm1);
            fVar.d = obj;
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0129  */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objR = F84.this.r(null, null, null, this);
            return objR == AbstractC14862ic3.e() ? objR : C9475a16.a(objR);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ J44 f;
        final /* synthetic */ F84 g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C11458d25 c11458d25, J44 j44, F84 f84, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = j44;
            this.g = f84;
            this.h = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d3 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instructions count: 479
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ String e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;
        final /* synthetic */ String h;
        final /* synthetic */ Long i;
        final /* synthetic */ Long j;
        final /* synthetic */ C7880To7 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C11458d25 c11458d25, String str, List list, List list2, String str2, Long l, Long l2, C7880To7 c7880To7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = str;
            this.f = list;
            this.g = list2;
            this.h = str2;
            this.i = l;
            this.j = l2;
            this.k = c7880To7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return F84.this.new i(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            F84.this.d.r2(this.d, this.e, new ArrayList(this.f), new ArrayList(this.g), this.h, this.i, this.j, this.k);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ KW3[] g;
        final /* synthetic */ F84 h;
        final /* synthetic */ C11458d25 i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ C7880To7 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(KW3[] kw3Arr, F84 f84, C11458d25 c11458d25, long j, long j2, C7880To7 c7880To7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = kw3Arr;
            this.h = f84;
            this.i = c11458d25;
            this.j = j;
            this.k = j2;
            this.l = c7880To7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
            jVar.f = obj;
            return jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004a -> B:13:0x004d). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.e
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L28
                if (r2 != r4) goto L20
                int r2 = r0.d
                int r5 = r0.c
                java.lang.Object r6 = r0.b
                ir.nasim.KW3[] r6 = (ir.nasim.KW3[]) r6
                java.lang.Object r7 = r0.f
                ir.nasim.ro1 r7 = (ir.nasim.InterfaceC20315ro1) r7
                ir.nasim.AbstractC10685c16.b(r18)
                r8 = r18
                goto L4d
            L20:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L28:
                ir.nasim.AbstractC10685c16.b(r18)
                java.lang.Object r2 = r0.f
                ir.nasim.ro1 r2 = (ir.nasim.InterfaceC20315ro1) r2
                ir.nasim.KW3[] r5 = r0.g
                int r6 = r5.length
                r7 = r2
                r2 = r6
                r6 = r5
                r5 = r3
            L36:
                if (r5 >= r2) goto Lbf
                r8 = r6[r5]
                ir.nasim.F84 r9 = r0.h
                r0.f = r7
                r0.b = r6
                r0.c = r5
                r0.d = r2
                r0.e = r4
                java.lang.Object r8 = ir.nasim.F84.a(r9, r8, r0)
                if (r8 != r1) goto L4d
                return r1
            L4d:
                r15 = r8
                ir.nasim.zW1 r15 = (ir.nasim.C24967zW1) r15
                if (r15 != 0) goto La9
                java.lang.String r8 = "FiSeCoFl"
                java.lang.String r9 = "sendMedia(): Failed to create content"
                ir.nasim.C19406qI3.b(r8, r9)
                java.lang.Class r8 = r7.getClass()
                boolean r8 = r8.isAnonymousClass()
                java.lang.String r9 = "substring(...)"
                r10 = 23
                if (r8 != 0) goto L81
                java.lang.Class r8 = r7.getClass()
                java.lang.String r8 = r8.getSimpleName()
                int r11 = r8.length()
                ir.nasim.AbstractC13042fc3.f(r8)
                if (r11 > r10) goto L79
                goto La3
            L79:
                java.lang.String r8 = r8.substring(r3, r10)
                ir.nasim.AbstractC13042fc3.h(r8, r9)
                goto La3
            L81:
                java.lang.Class r8 = r7.getClass()
                java.lang.String r8 = r8.getName()
                int r11 = r8.length()
                ir.nasim.AbstractC13042fc3.f(r8)
                if (r11 > r10) goto L93
                goto La3
            L93:
                int r11 = r8.length()
                int r11 = r11 - r10
                int r10 = r8.length()
                java.lang.String r8 = r8.substring(r11, r10)
                ir.nasim.AbstractC13042fc3.h(r8, r9)
            La3:
                java.lang.String r9 = "Failed to create content"
                ir.nasim.C19406qI3.b(r8, r9)
                goto Lbc
            La9:
                ir.nasim.F84 r8 = r0.h
                ir.nasim.E84 r9 = ir.nasim.F84.e(r8)
                ir.nasim.d25 r10 = r0.i
                long r11 = r0.j
                long r13 = r0.k
                ir.nasim.To7 r8 = r0.l
                r16 = r8
                r9.t2(r10, r11, r13, r15, r16)
            Lbc:
                int r5 = r5 + r4
                goto L36
            Lbf:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        long d;
        int e;
        int f;
        int g;
        private /* synthetic */ Object h;
        final /* synthetic */ KW3[] i;
        final /* synthetic */ F84 j;
        final /* synthetic */ C11458d25 k;
        final /* synthetic */ long l;
        final /* synthetic */ long m;
        final /* synthetic */ C7880To7 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(KW3[] kw3Arr, F84 f84, C11458d25 c11458d25, long j, long j2, C7880To7 c7880To7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = kw3Arr;
            this.j = f84;
            this.k = c11458d25;
            this.l = j;
            this.m = j2;
            this.n = c7880To7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.i, this.j, this.k, this.l, this.m, this.n, interfaceC20295rm1);
            kVar.h = obj;
            return kVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0064 -> B:14:0x0067). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 317
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return F84.this.w(null, this);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Integer c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ F84 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Integer num, long j, long j2, F84 f84, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = num;
            this.d = j;
            this.e = j2;
            this.f = f84;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates = (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates.newBuilder().A(PeersStruct$ExPeer.newBuilder().B(this.c.intValue()).C(EnumC10088b35.ExPeerType_GROUP)).B((MessagingStruct$MessageId) MessagingStruct$MessageId.newBuilder().A(this.d).B(this.e).a()).a();
                InterfaceC16847ly interfaceC16847ly = this.f.e;
                AbstractC13042fc3.f(mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates);
                MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates defaultInstance = MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.maviz.v1.MavizStream/UnsubscribeFromThreadUpdates", mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates, defaultInstance);
                this.b = 1;
                if (InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objY = F84.this.y(null, null, null, this);
            return objY == AbstractC14862ic3.e() ? objY : C9475a16.a(objY);
        }
    }

    public F84(InterfaceC20315ro1 interfaceC20315ro1, Context context, AbstractC13778go1 abstractC13778go1, E84 e84, InterfaceC16847ly interfaceC16847ly, C10299bQ2 c10299bQ2, OK7 ok7, CB7 cb7, InterfaceC19483qR interfaceC19483qR, SB3 sb3) {
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(cb7, "unlockedProtectedContentPref");
        AbstractC13042fc3.i(interfaceC19483qR, "authenticatorLocalDataSource");
        AbstractC13042fc3.i(sb3, "messageIdToStructMessageIdMapper");
        this.a = interfaceC20315ro1;
        this.b = context;
        this.c = abstractC13778go1;
        this.d = e84;
        this.e = interfaceC16847ly;
        this.f = c10299bQ2;
        this.g = ok7;
        this.h = cb7;
        this.i = interfaceC19483qR;
        this.j = sb3;
        this.k = new C10508bj5(0L, 0L, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(KW3 kw3, InterfaceC20295rm1 interfaceC20295rm1) {
        return RW1.t(RW1.a, this.b, kw3.b(), kw3.a(), kw3.c(), null, interfaceC20295rm1, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(ir.nasim.C11458d25 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.w(ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    public final void i(C11458d25 c11458d25, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        this.d.H0(c11458d25).v(j44);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(long r16, long r18, int r20, int r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.k(long, long, int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6 A[PHI: r1
      0x00f6: PHI (r1v20 java.lang.Object) = (r1v18 java.lang.Object), (r1v1 java.lang.Object) binds: [B:39:0x00f3, B:14:0x0032] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(long r19, long r21, int r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.l(long, long, int, ir.nasim.rm1):java.lang.Object");
    }

    public final Long m(C11458d25 c11458d25) {
        J44 j44;
        AbstractC13042fc3.i(c11458d25, "peer");
        List listK = this.d.H0(c11458d25).k();
        if (listK == null || (j44 = (J44) AbstractC15401jX0.q0(listK)) == null) {
            return null;
        }
        return Long.valueOf(j44.h());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.F84.e
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.F84$e r0 = (ir.nasim.F84.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.F84$e r0 = new ir.nasim.F84$e
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r9 = 1
            if (r1 == 0) goto L33
            if (r1 != r9) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L67
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus$a r12 = ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus.newBuilder()
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus$a r11 = r12.A(r11)
            com.google.protobuf.GeneratedMessageLite r11 = r11.a()
            ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus r11 = (ai.bale.proto.FalakeOuterClass$RequestGetLinkStatus) r11
            ir.nasim.vx5 r2 = new ir.nasim.vx5
            ir.nasim.AbstractC13042fc3.f(r11)
            ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus r12 = ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus.getDefaultInstance()
            java.lang.String r1 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r1)
            java.lang.String r1 = "/bale.falake.v1.Falake/GetLinkStatus"
            r2.<init>(r1, r11, r12)
            ir.nasim.ly r1 = r10.e
            r6.c = r9
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto L67
            return r0
        L67:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r11 = r12 instanceof ir.nasim.Z06.a
            if (r11 == 0) goto L7e
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r11 = r12.a()
            ir.nasim.a16$a r12 = ir.nasim.C9475a16.b
            java.lang.Object r11 = ir.nasim.AbstractC10685c16.a(r11)
            java.lang.Object r11 = ir.nasim.C9475a16.b(r11)
            goto Lba
        L7e:
            boolean r11 = r12 instanceof ir.nasim.Z06.b
            if (r11 == 0) goto Lbb
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r11 = r12.a()
            ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus r11 = (ai.bale.proto.FalakeOuterClass$ResponseGetLinkStatus) r11
            ir.nasim.Gf2 r11 = r11.getLinkStatus()
            if (r11 != 0) goto L94
            r11 = -1
            goto L9c
        L94:
            int[] r12 = ir.nasim.F84.b.b
            int r11 = r11.ordinal()
            r11 = r12[r11]
        L9c:
            if (r11 == r9) goto Lb4
            r12 = 2
            if (r11 == r12) goto Lb1
            r12 = 3
            if (r11 == r12) goto Lae
            r12 = 4
            if (r11 != r12) goto La8
            goto Lae
        La8:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        Lae:
            ir.nasim.NA3 r11 = ir.nasim.NA3.d
            goto Lb6
        Lb1:
            ir.nasim.NA3 r11 = ir.nasim.NA3.c
            goto Lb6
        Lb4:
            ir.nasim.NA3 r11 = ir.nasim.NA3.b
        Lb6:
            java.lang.Object r11 = ir.nasim.C9475a16.b(r11)
        Lba:
            return r11
        Lbb:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.n(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final C10508bj5 o() {
        return this.k;
    }

    public final Object p(List list, int i2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = MessagingOuterClass$RequestGetMessagesRepliesInfo.newBuilder().B(PeersStruct$ExPeer.newBuilder().B(i2).C(z ? EnumC10088b35.ExPeerType_CHANNEL : EnumC10088b35.ExPeerType_GROUP)).A((List) this.j.a(list)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MessagingOuterClass$ResponseGetMessagesRepliesInfo defaultInstance = MessagingOuterClass$ResponseGetMessagesRepliesInfo.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.e, new C22871vx5("/bale.messaging.v2.Messaging/GetMessagesRepliesInfo", generatedMessageLiteA, defaultInstance), 0L, null, interfaceC20295rm1, 6, null);
    }

    public final Object q(InterfaceC20295rm1 interfaceC20295rm1) {
        if (!C8386Vt0.v9()) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(this.c, new f(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(ir.nasim.J44 r11, ir.nasim.C11458d25 r12, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.F84.g
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.F84$g r0 = (ir.nasim.F84.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.F84$g r0 = new ir.nasim.F84$g
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.c
            ir.nasim.F84$h r2 = new ir.nasim.F84$h
            r9 = 0
            r4 = r2
            r5 = r12
            r6 = r11
            r7 = r10
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.r(ir.nasim.J44, ir.nasim.d25, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final Object s(C11458d25 c11458d25, String str, List list, List list2, String str2, Long l2, Long l3, C7880To7 c7880To7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new i(c11458d25, str, list, list2, str2, l2, l3, c7880To7, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final InterfaceC13730gj3 u(C11458d25 c11458d25, long j2, long j3, C7880To7 c7880To7, KW3... kw3Arr) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(kw3Arr, "mediaContents");
        return AbstractC10533bm0.d(this.a, this.c, null, new j(kw3Arr, this, c11458d25, j2, j3, c7880To7, null), 2, null);
    }

    public final InterfaceC13730gj3 v(C11458d25 c11458d25, long j2, long j3, C7880To7 c7880To7, KW3... kw3Arr) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(kw3Arr, "mediaContents");
        return AbstractC10533bm0.d(this.a, this.c, null, new k(kw3Arr, this, c11458d25, j2, j3, c7880To7, null), 2, null);
    }

    public final void x(Integer num, long j2, long j3) {
        if (num != null) {
            AbstractC10533bm0.d(C17050mJ2.a, null, null, new m(num, j3, j2, this, null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(ir.nasim.C11458d25 r5, java.lang.String r6, ir.nasim.J44 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.F84.n
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.F84$n r0 = (ir.nasim.F84.n) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.F84$n r0 = new ir.nasim.F84$n
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L4f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.E84 r8 = r4.d
            ir.nasim.Nv5 r5 = r8.N2(r5, r6, r7)
            java.lang.String r6 = "updateMessage(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r6)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F84.y(ir.nasim.d25, java.lang.String, ir.nasim.J44, ir.nasim.rm1):java.lang.Object");
    }
}
