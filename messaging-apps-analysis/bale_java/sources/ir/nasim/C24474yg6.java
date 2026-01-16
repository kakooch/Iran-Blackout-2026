package ir.nasim;

import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.SearchOuterClass$RequestSearchMessages;
import ai.bale.proto.SearchOuterClass$RequestSearchMessagesMore;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchStruct$SearchAndCondition;
import ai.bale.proto.SearchStruct$SearchCondition;
import ai.bale.proto.SearchStruct$SearchDateCondition;
import ai.bale.proto.SearchStruct$SearchPeerCondition;
import ai.bale.proto.SearchStruct$SearchPieceText;
import ai.bale.proto.SearchStruct$SearchSenderCondition;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: ir.nasim.yg6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24474yg6 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final V25 c;
    private final Context d;

    /* renamed from: ir.nasim.yg6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yg6$b */
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
            Object objE = C24474yg6.this.e(null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.yg6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BytesValue c;
        final /* synthetic */ C24474yg6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(BytesValue bytesValue, C24474yg6 c24474yg6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bytesValue;
            this.d = c24474yg6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMessagesMore.newBuilder().B(this.c).A(AbstractC10360bX0.p(EnumC16902m35.UpdateOptimization_STRIP_ENTITIES, EnumC16902m35.UpdateOptimization_STRIP_COUNTERS, EnumC16902m35.UpdateOptimization_COMPACT_USERS)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/SearchMessageMore", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
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
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.yg6$d */
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
            Object objF = C24474yg6.this.f(null, null, null, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.yg6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ C11458d25 i;
        final /* synthetic */ String j;
        final /* synthetic */ Long k;
        final /* synthetic */ Integer l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C11458d25 c11458d25, String str, Long l, Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = c11458d25;
            this.j = str;
            this.k = l;
            this.l = num;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24474yg6.this.new e(this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String str;
            Object objA;
            SearchStruct$SearchAndCondition.a aVar;
            C24474yg6 c24474yg6;
            SearchOuterClass$RequestSearchMessages.b bVar;
            SearchStruct$SearchCondition.a aVar2;
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.g;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                SearchOuterClass$RequestSearchMessages.b bVarNewBuilder = SearchOuterClass$RequestSearchMessages.newBuilder();
                SearchStruct$SearchCondition.a aVarNewBuilder = SearchStruct$SearchCondition.newBuilder();
                SearchStruct$SearchAndCondition.a aVarNewBuilder2 = SearchStruct$SearchAndCondition.newBuilder();
                C24474yg6 c24474yg62 = C24474yg6.this;
                V25 v25 = c24474yg62.c;
                C11458d25 c11458d25 = this.i;
                str = "/bale.search.v1.Search/SearchMessages";
                this.b = "/bale.search.v1.Search/SearchMessages";
                this.c = bVarNewBuilder;
                this.d = aVarNewBuilder;
                this.e = aVarNewBuilder2;
                this.f = c24474yg62;
                this.g = 1;
                objA = v25.a(c11458d25, this);
                if (objA == objE) {
                    return objE;
                }
                aVar = aVarNewBuilder2;
                c24474yg6 = c24474yg62;
                bVar = bVarNewBuilder;
                aVar2 = aVarNewBuilder;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objB = ((C9475a16) obj).l();
                    return C9475a16.a(objB);
                }
                c24474yg6 = (C24474yg6) this.f;
                SearchStruct$SearchAndCondition.a aVar3 = (SearchStruct$SearchAndCondition.a) this.e;
                SearchStruct$SearchCondition.a aVar4 = (SearchStruct$SearchCondition.a) this.d;
                SearchOuterClass$RequestSearchMessages.b bVar2 = (SearchOuterClass$RequestSearchMessages.b) this.c;
                String str2 = (String) this.b;
                AbstractC10685c16.b(obj);
                str = str2;
                bVar = bVar2;
                aVar2 = aVar4;
                aVar = aVar3;
                objA = obj;
            }
            GeneratedMessageLite generatedMessageLiteA = bVar.B(aVar2.A((SearchStruct$SearchAndCondition) aVar.A(c24474yg6.d((PeersStruct$OutPeer) objA, this.j, this.k, this.l)).a())).A(AbstractC10360bX0.p(EnumC16902m35.UpdateOptimization_FASTER_MESSAGES, EnumC16902m35.UpdateOptimization_STRIP_COUNTERS, EnumC16902m35.UpdateOptimization_COMPACT_USERS)).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            C22871vx5 c22871vx5 = new C22871vx5(str, generatedMessageLiteA, defaultInstance);
            C6287Mz c6287Mz = C24474yg6.this.a;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = 2;
            objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
            if (objB == objE) {
                return objE;
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24474yg6(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, V25 v25, Context context) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        AbstractC13042fc3.i(context, "context");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = v25;
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set d(PeersStruct$OutPeer peersStruct$OutPeer, String str, Long l, Integer num) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (peersStruct$OutPeer != null) {
            GeneratedMessageLite generatedMessageLiteA = SearchStruct$SearchCondition.newBuilder().E((SearchStruct$SearchPeerCondition) SearchStruct$SearchPeerCondition.newBuilder().A(peersStruct$OutPeer).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            linkedHashSet.add(generatedMessageLiteA);
        }
        if (str != null) {
            if ((AbstractC20762sZ6.n0(str) ^ true ? str : null) != null) {
                GeneratedMessageLite generatedMessageLiteA2 = SearchStruct$SearchCondition.newBuilder().G((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A(str).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                linkedHashSet.add(generatedMessageLiteA2);
            }
        }
        if (l != null) {
            GeneratedMessageLite generatedMessageLiteA3 = SearchStruct$SearchCondition.newBuilder().B((SearchStruct$SearchDateCondition) SearchStruct$SearchDateCondition.newBuilder().A(l.longValue()).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA3, "build(...)");
            linkedHashSet.add(generatedMessageLiteA3);
        }
        if (num != null) {
            GeneratedMessageLite generatedMessageLiteA4 = SearchStruct$SearchCondition.newBuilder().H((SearchStruct$SearchSenderCondition) SearchStruct$SearchSenderCondition.newBuilder().A(num.intValue()).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA4, "build(...)");
            linkedHashSet.add(generatedMessageLiteA4);
        }
        return linkedHashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.google.protobuf.BytesValue r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C24474yg6.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.yg6$b r0 = (ir.nasim.C24474yg6.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.yg6$b r0 = new ir.nasim.yg6$b
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
            ir.nasim.yg6$c r2 = new ir.nasim.yg6$c
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24474yg6.e(com.google.protobuf.BytesValue, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.C11458d25 r14, java.lang.String r15, java.lang.Long r16, java.lang.Integer r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r13 = this;
            r7 = r13
            r0 = r18
            boolean r1 = r0 instanceof ir.nasim.C24474yg6.d
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.yg6$d r1 = (ir.nasim.C24474yg6.d) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r8 = r1
            goto L1d
        L17:
            ir.nasim.yg6$d r1 = new ir.nasim.yg6$d
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r8.a
            java.lang.Object r9 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r8.c
            r10 = 1
            if (r1 == 0) goto L36
            if (r1 != r10) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L52
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r11 = r7.b
            ir.nasim.yg6$e r12 = new ir.nasim.yg6$e
            r6 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r0.<init>(r2, r3, r4, r5, r6)
            r8.c = r10
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r11, r12, r8)
            if (r0 != r9) goto L52
            return r9
        L52:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24474yg6.f(ir.nasim.d25, java.lang.String, java.lang.Long, java.lang.Integer, ir.nasim.rm1):java.lang.Object");
    }
}
