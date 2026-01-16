package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.PresenceOuterClass$RequestGetUsersPresence;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeToOnline;
import ai.bale.proto.PresenceOuterClass$ResponseGetUsersPresence;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.eo5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12555eo5 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.eo5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.eo5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C12555eo5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, C12555eo5 c12555eo5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c12555eo5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = PresenceOuterClass$RequestGetUsersPresence.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                PresenceOuterClass$ResponseGetUsersPresence defaultInstance = PresenceOuterClass$ResponseGetUsersPresence.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.presence.v1.Presence/GetUsersPresence", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 16500L, null, this, 4, null);
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

    /* renamed from: ir.nasim.eo5$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C12555eo5.this.c(null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.eo5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C12555eo5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, C12555eo5 c12555eo5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c12555eo5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PresenceOuterClass$RequestSubscribeToOnline.a aVarNewBuilder = PresenceOuterClass$RequestSubscribeToOnline.newBuilder();
                List list = this.c;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(((Number) it.next()).intValue()).a());
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.A(arrayList).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.presence.v1.Presence/SubscribeToOnline", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 16500L, null, this, 4, null);
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
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12555eo5(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
    }

    public final Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(list, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C12555eo5.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.eo5$c r0 = (ir.nasim.C12555eo5.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eo5$c r0 = new ir.nasim.eo5$c
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
            ir.nasim.go1 r7 = r5.b
            ir.nasim.eo5$d r2 = new ir.nasim.eo5$d
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12555eo5.c(java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
