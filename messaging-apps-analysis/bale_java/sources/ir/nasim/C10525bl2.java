package ir.nasim;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.SearchOuterClass$RequestSearchMessagesMore;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchStruct$MessageSearchItem;
import ai.bale.proto.SearchStruct$SearchCondition;
import ai.bale.proto.SearchStruct$SearchDocumentName;
import ai.bale.proto.SearchStruct$SearchPeerCondition;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.bl2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10525bl2 extends AbstractC15995kX3 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C6287Mz d;
    private final V25 e;
    private final EnumC7325Rf6 f;

    /* renamed from: ir.nasim.bl2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bl2$b */
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
            return C10525bl2.this.l(null, null, this);
        }
    }

    /* renamed from: ir.nasim.bl2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ C11458d25 i;
        final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = c11458d25;
            this.j = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10525bl2.this.new c(this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00f0  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10525bl2.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bl2$d */
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
            return C10525bl2.this.m(null, null, this);
        }
    }

    /* renamed from: ir.nasim.bl2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BytesValue c;
        final /* synthetic */ C10525bl2 d;
        final /* synthetic */ C11458d25 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(BytesValue bytesValue, C10525bl2 c10525bl2, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bytesValue;
            this.d = c10525bl2;
            this.e = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objB2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMessagesMore.newBuilder().B(this.c).A(PC.b).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/SearchMessageMore", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.d;
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
            C10525bl2 c10525bl2 = this.d;
            C11458d25 c11458d25 = this.e;
            if (C9475a16.j(objB)) {
                SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages = (SearchOuterClass$ResponseSearchMessages) objB;
                AbstractC13042fc3.f(searchOuterClass$ResponseSearchMessages);
                objB2 = C9475a16.b(new XV4(c10525bl2.n(c11458d25, searchOuterClass$ResponseSearchMessages), searchOuterClass$ResponseSearchMessages.getLoadMoreState()));
            } else {
                objB2 = C9475a16.b(objB);
            }
            return C9475a16.a(objB2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10525bl2(C4471Fg6 c4471Fg6, C20614sJ2 c20614sJ2, C6287Mz c6287Mz, V25 v25) {
        super(c4471Fg6, c20614sJ2);
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(c20614sJ2, "mediaMapper");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(v25, "peerToOutPeerMapper");
        this.d = c6287Mz;
        this.e = v25;
        this.f = EnumC7325Rf6.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set j(PeersStruct$OutPeer peersStruct$OutPeer, String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (peersStruct$OutPeer != null) {
            GeneratedMessageLite generatedMessageLiteA = SearchStruct$SearchCondition.newBuilder().E((SearchStruct$SearchPeerCondition) SearchStruct$SearchPeerCondition.newBuilder().A(peersStruct$OutPeer).a()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            linkedHashSet.add(generatedMessageLiteA);
        }
        if (str != null) {
            if ((AbstractC20762sZ6.n0(str) ^ true ? str : null) != null) {
                GeneratedMessageLite generatedMessageLiteA2 = SearchStruct$SearchCondition.newBuilder().C((SearchStruct$SearchDocumentName) SearchStruct$SearchDocumentName.newBuilder().A(str).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                linkedHashSet.add(generatedMessageLiteA2);
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r6, ir.nasim.C11458d25 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C10525bl2.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.bl2$b r0 = (ir.nasim.C10525bl2.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.bl2$b r0 = new ir.nasim.bl2$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = ir.nasim.C12366eV1.b()
            ir.nasim.bl2$c r2 = new ir.nasim.bl2$c
            r4 = 0
            r2.<init>(r7, r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            ir.nasim.XV4 r7 = new ir.nasim.XV4
            java.util.List r8 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r0 = com.google.protobuf.BytesValue.getDefaultInstance()
            r7.<init>(r8, r0)
            boolean r8 = ir.nasim.C9475a16.g(r6)
            if (r8 == 0) goto L61
            r6 = r7
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10525bl2.l(java.lang.String, ir.nasim.d25, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(ir.nasim.C11458d25 r6, com.google.protobuf.BytesValue r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C10525bl2.d
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.bl2$d r0 = (ir.nasim.C10525bl2.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.bl2$d r0 = new ir.nasim.bl2$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = ir.nasim.C12366eV1.b()
            ir.nasim.bl2$e r2 = new ir.nasim.bl2$e
            r4 = 0
            r2.<init>(r7, r5, r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            ir.nasim.XV4 r7 = new ir.nasim.XV4
            java.util.List r8 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r0 = com.google.protobuf.BytesValue.getDefaultInstance()
            r7.<init>(r8, r0)
            boolean r8 = ir.nasim.C9475a16.g(r6)
            if (r8 == 0) goto L61
            r6 = r7
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10525bl2.m(ir.nasim.d25, com.google.protobuf.BytesValue, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List n(C11458d25 c11458d25, SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages) {
        InterfaceC17445my6.c cVar;
        List<SearchStruct$MessageSearchItem> searchResultsList = searchOuterClass$ResponseSearchMessages.getSearchResultsList();
        AbstractC13042fc3.h(searchResultsList, "getSearchResultsList(...)");
        ArrayList arrayList = new ArrayList();
        for (SearchStruct$MessageSearchItem searchStruct$MessageSearchItem : searchResultsList) {
            C18732p92 c18732p92 = C18732p92.a;
            MessagingStruct$Message content = searchStruct$MessageSearchItem.getResult().getContent();
            AbstractC13042fc3.h(content, "getContent(...)");
            C24967zW1 c24967zW1F = AbstractC17457n0.h(c18732p92.A0(content)).f();
            if (c24967zW1F == null) {
                cVar = null;
            } else {
                long rid = searchStruct$MessageSearchItem.getResult().getRid();
                long date = searchStruct$MessageSearchItem.getResult().getDate();
                int senderId = searchStruct$MessageSearchItem.getResult().getSenderId();
                MessagingStruct$Message content2 = searchStruct$MessageSearchItem.getResult().getContent();
                AbstractC13042fc3.h(content2, "getContent(...)");
                C18823pJ2 c18823pJ2 = new C18823pJ2(c11458d25, rid, date, senderId, AbstractC17457n0.h(c18732p92.A0(content2)));
                String strY = c24967zW1F.y();
                AbstractC13042fc3.h(strY, "getName(...)");
                InterfaceC18505om2 interfaceC18505om2Z = c24967zW1F.z();
                AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
                FileReference fileReferenceB = ((C11920dm2) interfaceC18505om2Z).b();
                int iF = c24967zW1F.z().f();
                Long lR = c18823pJ2.r();
                AbstractC13042fc3.h(lR, "getDate(...)");
                long jLongValue = lR.longValue();
                String strU = c24967zW1F.u();
                AbstractC13042fc3.h(strU, "getExt(...)");
                cVar = new InterfaceC17445my6.c(strY, fileReferenceB, iF, jLongValue, strU, c18823pJ2, null, false, 192, null);
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC15995kX3
    public EnumC7325Rf6 c() {
        return this.f;
    }

    public final Object k(C11458d25 c11458d25, BytesValue bytesValue, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return bytesValue.getValue().isEmpty() ? l(str, c11458d25, interfaceC20295rm1) : m(c11458d25, bytesValue, interfaceC20295rm1);
    }
}
