package ir.nasim;

import ai.bale.proto.GroupsStruct$Group;
import ai.bale.proto.SearchOuterClass$RequestSearchMessages;
import ai.bale.proto.SearchOuterClass$RequestSearchMessagesMore;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchStruct$MessageSearchItem;
import ai.bale.proto.SearchStruct$SearchCondition;
import ai.bale.proto.SearchStruct$SearchPieceText;
import ai.bale.proto.UsersStruct$User;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.t74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21108t74 implements RT4 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C6287Mz a;
    private final C10299bQ2 b;
    private final OK7 c;
    private final UG7 d;
    private final C20505s74 e;
    private final String f;

    /* renamed from: ir.nasim.t74$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.t74$b */
    public interface b {
        C21108t74 a(String str);
    }

    /* renamed from: ir.nasim.t74$c */
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
            return C21108t74.this.k(this);
        }
    }

    /* renamed from: ir.nasim.t74$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21108t74.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objB2;
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMessages.newBuilder().C((SearchStruct$SearchCondition) SearchStruct$SearchCondition.newBuilder().G((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A(C21108t74.this.f).a()).a()).A(AbstractC10360bX0.p(EnumC16902m35.UpdateOptimization_STRIP_ENTITIES, EnumC16902m35.UpdateOptimization_STRIP_COUNTERS, EnumC16902m35.UpdateOptimization_COMPACT_USERS)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/SearchMessages", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C21108t74.this.a;
                this.c = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    searchOuterClass$ResponseSearchMessages = (SearchOuterClass$ResponseSearchMessages) this.b;
                    AbstractC10685c16.b(obj);
                    objB2 = C9475a16.b(new XV4(obj, searchOuterClass$ResponseSearchMessages.getLoadMoreState()));
                    return C9475a16.a(objB2);
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            C21108t74 c21108t74 = C21108t74.this;
            if (!C9475a16.j(objB)) {
                objB2 = C9475a16.b(objB);
                return C9475a16.a(objB2);
            }
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages2 = (SearchOuterClass$ResponseSearchMessages) objB;
            AbstractC13042fc3.f(searchOuterClass$ResponseSearchMessages2);
            this.b = searchOuterClass$ResponseSearchMessages2;
            this.c = 2;
            Object objM = c21108t74.m(searchOuterClass$ResponseSearchMessages2, this);
            if (objM == objE) {
                return objE;
            }
            searchOuterClass$ResponseSearchMessages = searchOuterClass$ResponseSearchMessages2;
            obj = objM;
            objB2 = C9475a16.b(new XV4(obj, searchOuterClass$ResponseSearchMessages.getLoadMoreState()));
            return C9475a16.a(objB2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.t74$e */
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
            return C21108t74.this.l(null, this);
        }
    }

    /* renamed from: ir.nasim.t74$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ BytesValue d;
        final /* synthetic */ C21108t74 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(BytesValue bytesValue, C21108t74 c21108t74, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bytesValue;
            this.e = c21108t74;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objB2;
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = SearchOuterClass$RequestSearchMessagesMore.newBuilder().B(this.d).A(AbstractC10360bX0.p(EnumC16902m35.UpdateOptimization_STRIP_ENTITIES, EnumC16902m35.UpdateOptimization_STRIP_COUNTERS, EnumC16902m35.UpdateOptimization_COMPACT_USERS)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                SearchOuterClass$ResponseSearchMessages defaultInstance = SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.search.v1.Search/SearchMessageMore", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.a;
                this.c = 1;
                objB = AbstractC6547Nz.b(c22871vx5, c6287Mz, 0L, this, 2, null);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    searchOuterClass$ResponseSearchMessages = (SearchOuterClass$ResponseSearchMessages) this.b;
                    AbstractC10685c16.b(obj);
                    objB2 = C9475a16.b(new XV4(obj, searchOuterClass$ResponseSearchMessages.getLoadMoreState()));
                    return C9475a16.a(objB2);
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            C21108t74 c21108t74 = this.e;
            if (!C9475a16.j(objB)) {
                objB2 = C9475a16.b(objB);
                return C9475a16.a(objB2);
            }
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages2 = (SearchOuterClass$ResponseSearchMessages) objB;
            AbstractC13042fc3.f(searchOuterClass$ResponseSearchMessages2);
            this.b = searchOuterClass$ResponseSearchMessages2;
            this.c = 2;
            Object objM = c21108t74.m(searchOuterClass$ResponseSearchMessages2, this);
            if (objM == objE) {
                return objE;
            }
            searchOuterClass$ResponseSearchMessages = searchOuterClass$ResponseSearchMessages2;
            obj = objM;
            objB2 = C9475a16.b(new XV4(obj, searchOuterClass$ResponseSearchMessages.getLoadMoreState()));
            return C9475a16.a(objB2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.t74$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ SearchOuterClass$ResponseSearchMessages g;

        /* renamed from: ir.nasim.t74$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SearchOuterClass$ResponseSearchMessages c;
            final /* synthetic */ C21108t74 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, C21108t74 c21108t74, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = searchOuterClass$ResponseSearchMessages;
                this.d = c21108t74;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List<SearchStruct$MessageSearchItem> searchResultsList = this.c.getSearchResultsList();
                    AbstractC13042fc3.h(searchResultsList, "getSearchResultsList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : searchResultsList) {
                        if (((SearchStruct$MessageSearchItem) obj2).getResult().getPeer().getType() == EnumC16311l35.PeerType_PRIVATE) {
                            arrayList.add(obj2);
                        }
                    }
                    OK7 ok7 = this.d.c;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(AbstractC6392Nk0.d(((SearchStruct$MessageSearchItem) it.next()).getResult().getPeer().getId()));
                    }
                    C6517Nv5 c6517Nv5W0 = ok7.w0(arrayList2, false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
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
                return C9475a16.a(objD);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.t74$g$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SearchOuterClass$ResponseSearchMessages c;
            final /* synthetic */ C21108t74 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, C21108t74 c21108t74, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = searchOuterClass$ResponseSearchMessages;
                this.d = c21108t74;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List<SearchStruct$MessageSearchItem> searchResultsList = this.c.getSearchResultsList();
                    AbstractC13042fc3.h(searchResultsList, "getSearchResultsList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : searchResultsList) {
                        if (((SearchStruct$MessageSearchItem) obj2).getResult().getPeer().getType() == EnumC16311l35.PeerType_GROUP) {
                            arrayList.add(obj2);
                        }
                    }
                    C10299bQ2 c10299bQ2 = this.d.b;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(AbstractC6392Nk0.d(((SearchStruct$MessageSearchItem) it.next()).getResult().getPeer().getId()));
                    }
                    C6517Nv5 c6517Nv5B2 = c10299bQ2.B2(new ArrayList(arrayList2), false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5B2, null, this, 1, null);
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
                return C9475a16.a(objD);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.t74$g$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            int f;
            final /* synthetic */ HE0 g;
            final /* synthetic */ SearchOuterClass$ResponseSearchMessages h;
            final /* synthetic */ C21108t74 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(HE0 he0, SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, C21108t74 c21108t74, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = he0;
                this.h = searchOuterClass$ResponseSearchMessages;
                this.i = c21108t74;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.g, this.h, this.i, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0068 -> B:14:0x006b). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.f
                    r2 = 1
                    if (r1 == 0) goto L27
                    if (r1 != r2) goto L1f
                    java.lang.Object r1 = r7.e
                    ir.nasim.HE0 r1 = (ir.nasim.HE0) r1
                    java.lang.Object r3 = r7.d
                    java.util.Iterator r3 = (java.util.Iterator) r3
                    java.lang.Object r4 = r7.c
                    java.util.Collection r4 = (java.util.Collection) r4
                    java.lang.Object r5 = r7.b
                    ir.nasim.t74 r5 = (ir.nasim.C21108t74) r5
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L6b
                L1f:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L27:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.HE0 r8 = r7.g
                    ai.bale.proto.SearchOuterClass$ResponseSearchMessages r1 = r7.h
                    java.util.List r1 = r1.getSearchResultsList()
                    java.lang.String r3 = "getSearchResultsList(...)"
                    ir.nasim.AbstractC13042fc3.h(r1, r3)
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    ir.nasim.t74 r3 = r7.i
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r1 = r1.iterator()
                    r5 = r3
                    r3 = r1
                    r1 = r8
                L47:
                    boolean r8 = r3.hasNext()
                    if (r8 == 0) goto L73
                    java.lang.Object r8 = r3.next()
                    ai.bale.proto.SearchStruct$MessageSearchItem r8 = (ai.bale.proto.SearchStruct$MessageSearchItem) r8
                    ir.nasim.s74 r6 = ir.nasim.C21108t74.d(r5)
                    ir.nasim.AbstractC13042fc3.f(r8)
                    r7.b = r5
                    r7.c = r4
                    r7.d = r3
                    r7.e = r1
                    r7.f = r2
                    java.lang.Object r8 = r6.a(r8, r7)
                    if (r8 != r0) goto L6b
                    return r0
                L6b:
                    ir.nasim.Cg6 r8 = (ir.nasim.AbstractC3769Cg6) r8
                    if (r8 == 0) goto L47
                    r4.add(r8)
                    goto L47
                L73:
                    java.util.List r4 = (java.util.List) r4
                    ir.nasim.AbstractC24549yo1.c(r1, r4)
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21108t74.g.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = searchOuterClass$ResponseSearchMessages;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C21108t74.this.new g(this.g, interfaceC20295rm1);
            gVar.e = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                UG7 ug7 = C21108t74.this.d;
                List<UsersStruct$User> usersList = this.g.getUsersList();
                AbstractC13042fc3.h(usersList, "getUsersList(...)");
                List<UsersStruct$User> list = usersList;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (UsersStruct$User usersStruct$User : list) {
                    AbstractC13042fc3.f(usersStruct$User);
                    arrayList.add(C18732p92.d(usersStruct$User));
                }
                List<GroupsStruct$Group> groupsList = this.g.getGroupsList();
                AbstractC13042fc3.h(groupsList, "getGroupsList(...)");
                List<GroupsStruct$Group> list2 = groupsList;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (GroupsStruct$Group groupsStruct$Group : list2) {
                    AbstractC13042fc3.f(groupsStruct$Group);
                    arrayList2.add(C18732p92.b(groupsStruct$Group));
                }
                ug7.R(arrayList, arrayList2);
                List listP = AbstractC10360bX0.p(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(this.g, C21108t74.this, null), 3, null), AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(this.g, C21108t74.this, null), 3, null));
                this.e = interfaceC20315ro1;
                this.d = 1;
                if (DV.a(listP, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                AbstractC10685c16.b(obj);
            }
            InterfaceC20315ro1 interfaceC20315ro12 = interfaceC20315ro1;
            SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages = this.g;
            C21108t74 c21108t74 = C21108t74.this;
            this.e = interfaceC20315ro12;
            this.b = searchOuterClass$ResponseSearchMessages;
            this.c = c21108t74;
            this.d = 2;
            IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
            ie0.w();
            AbstractC10533bm0.d(interfaceC20315ro12, null, null, new c(ie0, searchOuterClass$ResponseSearchMessages, c21108t74, null), 3, null);
            obj = ie0.t();
            if (obj == AbstractC14862ic3.e()) {
                WA1.c(this);
            }
            return obj == objE ? objE : obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21108t74(C6287Mz c6287Mz, C10299bQ2 c10299bQ2, OK7 ok7, UG7 ug7, C20505s74 c20505s74, String str) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(ug7, "updateModule");
        AbstractC13042fc3.i(c20505s74, "mapper");
        AbstractC13042fc3.i(str, "query");
        this.a = c6287Mz;
        this.b = c10299bQ2;
        this.c = ok7;
        this.d = ug7;
        this.e = c20505s74;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C21108t74.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.t74$c r0 = (ir.nasim.C21108t74.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.t74$c r0 = new ir.nasim.t74$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.b()
            ir.nasim.t74$d r2 = new ir.nasim.t74$d
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            ir.nasim.XV4 r0 = new ir.nasim.XV4
            java.util.List r1 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r2 = com.google.protobuf.BytesValue.getDefaultInstance()
            r0.<init>(r1, r2)
            boolean r1 = ir.nasim.C9475a16.g(r6)
            if (r1 == 0) goto L61
            r6 = r0
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21108t74.k(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(com.google.protobuf.BytesValue r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21108t74.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.t74$e r0 = (ir.nasim.C21108t74.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.t74$e r0 = new ir.nasim.t74$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = ir.nasim.C12366eV1.b()
            ir.nasim.t74$f r2 = new ir.nasim.t74$f
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            ir.nasim.XV4 r7 = new ir.nasim.XV4
            java.util.List r0 = ir.nasim.ZW0.m()
            com.google.protobuf.BytesValue r1 = com.google.protobuf.BytesValue.getDefaultInstance()
            r7.<init>(r0, r1)
            boolean r0 = ir.nasim.C9475a16.g(r6)
            if (r0 == 0) goto L61
            r6 = r7
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21108t74.l(com.google.protobuf.BytesValue, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new g(searchOuterClass$ResponseSearchMessages, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.RT4
    public Object a(BytesValue bytesValue, InterfaceC20295rm1 interfaceC20295rm1) {
        return bytesValue.getValue().isEmpty() ? k(interfaceC20295rm1) : l(bytesValue, interfaceC20295rm1);
    }
}
