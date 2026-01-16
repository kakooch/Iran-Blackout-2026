package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestCreateFolder;
import ai.bale.proto.MessagingOuterClass$RequestCreateReservedFolder;
import ai.bale.proto.MessagingOuterClass$RequestDeleteFolder;
import ai.bale.proto.MessagingOuterClass$RequestEditFolder;
import ai.bale.proto.MessagingOuterClass$RequestLoadFolders;
import ai.bale.proto.MessagingOuterClass$RequestReorderFolders;
import ai.bale.proto.MessagingOuterClass$ResponseCreateFolder;
import ai.bale.proto.MessagingOuterClass$ResponseCreateReservedFolder;
import ai.bale.proto.MessagingOuterClass$ResponseEditFolder;
import ai.bale.proto.MessagingOuterClass$ResponseLoadFolders;
import ai.bale.proto.MessagingOuterClass$ResponseReorderFolders;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.UO1;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Ks2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5760Ks2 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final InterfaceC14123hO3 c;

    /* renamed from: ir.nasim.Ks2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ks2$b */
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
            Object objE = C5760Ks2.this.e(null, null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.Ks2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;
        final /* synthetic */ C5760Ks2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, List list, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = list;
            this.e = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestCreateFolder.a aVarB = MessagingOuterClass$RequestCreateFolder.newBuilder().B(this.c);
                List list = this.d;
                C5760Ks2 c5760Ks2 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((PeersStruct$ExPeer) c5760Ks2.c.a((ExPeer) it.next()));
                }
                MessagingOuterClass$RequestCreateFolder messagingOuterClass$RequestCreateFolder = (MessagingOuterClass$RequestCreateFolder) aVarB.A(arrayList).a();
                C5760Ks2 c5760Ks22 = this.e;
                AbstractC13042fc3.f(messagingOuterClass$RequestCreateFolder);
                MessagingOuterClass$ResponseCreateFolder defaultInstance = MessagingOuterClass$ResponseCreateFolder.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c5760Ks22.i("/bale.messaging.v2.Messaging/CreateFolder", messagingOuterClass$RequestCreateFolder, defaultInstance, this);
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
            String str = this.c;
            List list2 = this.d;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                MessagingOuterClass$ResponseCreateFolder messagingOuterClass$ResponseCreateFolder = (MessagingOuterClass$ResponseCreateFolder) ((Z06.b) z06).a();
                UO1.e.b(UO1.e.a, "create Folder " + str + " successful. Number of Peers " + list2.size(), null, 2, null);
                objB = C9475a16.b(messagingOuterClass$ResponseCreateFolder);
            }
            String str2 = this.c;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("Create Folder failed. folderName: " + str2, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$d */
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
            Object objF = C5760Ks2.this.f(0, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.Ks2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C5760Ks2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestCreateReservedFolder messagingOuterClass$RequestCreateReservedFolder = (MessagingOuterClass$RequestCreateReservedFolder) MessagingOuterClass$RequestCreateReservedFolder.newBuilder().A(this.c).a();
                C5760Ks2 c5760Ks2 = this.d;
                AbstractC13042fc3.f(messagingOuterClass$RequestCreateReservedFolder);
                MessagingOuterClass$ResponseCreateReservedFolder defaultInstance = MessagingOuterClass$ResponseCreateReservedFolder.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c5760Ks2.i("/bale.messaging.v2.Messaging/CreateReservedFolder", messagingOuterClass$RequestCreateReservedFolder, defaultInstance, this);
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
            int i2 = this.c;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                MessagingOuterClass$ResponseCreateReservedFolder messagingOuterClass$ResponseCreateReservedFolder = (MessagingOuterClass$ResponseCreateReservedFolder) ((Z06.b) z06).a();
                UO1.e.b(UO1.e.a, "create Reserved Folder successful. folderId: " + i2 + " ,", null, 2, null);
                objB = C9475a16.b(messagingOuterClass$ResponseCreateReservedFolder);
            }
            int i3 = this.c;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("create Reserved Folders failed. folderId: " + i3, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = C5760Ks2.this.g(0, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    /* renamed from: ir.nasim.Ks2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C5760Ks2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestDeleteFolder messagingOuterClass$RequestDeleteFolder = (MessagingOuterClass$RequestDeleteFolder) MessagingOuterClass$RequestDeleteFolder.newBuilder().A(this.c).a();
                C5760Ks2 c5760Ks2 = this.d;
                AbstractC13042fc3.f(messagingOuterClass$RequestDeleteFolder);
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c5760Ks2.i("/bale.messaging.v2.Messaging/DeleteFolder", messagingOuterClass$RequestDeleteFolder, defaultInstance, this);
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
            int i2 = this.c;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                UO1.e.b(UO1.e.a, "Delete Folder successful. folderId: " + i2, null, 2, null);
                objB = C9475a16.b(C19938rB7.a);
            }
            int i3 = this.c;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("Delete Folder failed. folderId: " + i3, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objH = C5760Ks2.this.h(0, null, null, null, this);
            return objH == AbstractC14862ic3.e() ? objH : C9475a16.a(objH);
        }
    }

    /* renamed from: ir.nasim.Ks2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ List e;
        final /* synthetic */ List f;
        final /* synthetic */ C5760Ks2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, String str, List list, List list2, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = list;
            this.f = list2;
            this.g = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestEditFolder.a aVarD = MessagingOuterClass$RequestEditFolder.newBuilder().C(this.c).D(this.d);
                List list = this.e;
                C5760Ks2 c5760Ks2 = this.g;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((PeersStruct$ExPeer) c5760Ks2.c.a((ExPeer) it.next()));
                }
                MessagingOuterClass$RequestEditFolder.a aVarB = aVarD.B(arrayList);
                List list2 = this.f;
                C5760Ks2 c5760Ks22 = this.g;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((PeersStruct$ExPeer) c5760Ks22.c.a((ExPeer) it2.next()));
                }
                MessagingOuterClass$RequestEditFolder messagingOuterClass$RequestEditFolder = (MessagingOuterClass$RequestEditFolder) aVarB.A(arrayList2).a();
                C5760Ks2 c5760Ks23 = this.g;
                AbstractC13042fc3.f(messagingOuterClass$RequestEditFolder);
                MessagingOuterClass$ResponseEditFolder defaultInstance = MessagingOuterClass$ResponseEditFolder.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c5760Ks23.i("/bale.messaging.v2.Messaging/EditFolder", messagingOuterClass$RequestEditFolder, defaultInstance, this);
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
            String str = this.d;
            List list3 = this.f;
            List list4 = this.e;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                MessagingOuterClass$ResponseEditFolder messagingOuterClass$ResponseEditFolder = (MessagingOuterClass$ResponseEditFolder) ((Z06.b) z06).a();
                UO1.e.b(UO1.e.a, "edit Folder " + str + " successful. Peer update - Added: " + list3.size() + ", Removed: " + list4.size(), null, 2, null);
                objB = C9475a16.b(messagingOuterClass$ResponseEditFolder.getUnreadPeersList());
            }
            int i2 = this.c;
            String str2 = this.d;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("Edit Folder failed. folderId: " + i2 + " , folderName: " + str2, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ com.google.protobuf.P d;
        final /* synthetic */ com.google.protobuf.P e;
        final /* synthetic */ C5760Ks2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, com.google.protobuf.P p, com.google.protobuf.P p2, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = p;
            this.e = p2;
            this.f = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22871vx5 c22871vx5 = new C22871vx5(this.c, this.d, this.e);
                C6287Mz c6287Mz = this.f.a;
                this.b = 1;
                obj = AbstractC6547Nz.c(c6287Mz, c22871vx5, (2 & 2) != 0 ? 16500L : 0L, 16500, 2, 10, this);
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$k */
    static final class k extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C5760Ks2.this.j(null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Ks2$l */
    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objL = C5760Ks2.this.l(this);
            return objL == AbstractC14862ic3.e() ? objL : C9475a16.a(objL);
        }
    }

    /* renamed from: ir.nasim.Ks2$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5760Ks2.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestLoadFolders messagingOuterClass$RequestLoadFolders = (MessagingOuterClass$RequestLoadFolders) MessagingOuterClass$RequestLoadFolders.newBuilder().A(true).a();
                C5760Ks2 c5760Ks2 = C5760Ks2.this;
                AbstractC13042fc3.f(messagingOuterClass$RequestLoadFolders);
                MessagingOuterClass$ResponseLoadFolders defaultInstance = MessagingOuterClass$ResponseLoadFolders.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = C5760Ks2.k(c5760Ks2, "/bale.messaging.v2.Messaging/LoadFolders", messagingOuterClass$RequestLoadFolders, defaultInstance, null, this, 8, null);
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
                MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders = (MessagingOuterClass$ResponseLoadFolders) ((Z06.b) z06).a();
                UO1.e.b(UO1.e.a, "loadFolders successful. Number of folders: " + messagingOuterClass$ResponseLoadFolders.getFoldersList().size(), null, 2, null);
                objB = C9475a16.b(messagingOuterClass$ResponseLoadFolders);
            }
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("load All Folders failed", thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ks2$n */
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
            Object objM = C5760Ks2.this.m(null, this);
            return objM == AbstractC14862ic3.e() ? objM : C9475a16.a(objM);
        }
    }

    /* renamed from: ir.nasim.Ks2$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C5760Ks2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(List list, C5760Ks2 c5760Ks2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c5760Ks2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new o(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MessagingOuterClass$RequestReorderFolders messagingOuterClass$RequestReorderFolders = (MessagingOuterClass$RequestReorderFolders) MessagingOuterClass$RequestReorderFolders.newBuilder().A(this.c).a();
                C5760Ks2 c5760Ks2 = this.d;
                AbstractC13042fc3.f(messagingOuterClass$RequestReorderFolders);
                MessagingOuterClass$ResponseReorderFolders defaultInstance = MessagingOuterClass$ResponseReorderFolders.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c5760Ks2.i("/bale.messaging.v2.Messaging/ReorderFolders", messagingOuterClass$RequestReorderFolders, defaultInstance, this);
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
                MessagingOuterClass$ResponseReorderFolders messagingOuterClass$ResponseReorderFolders = (MessagingOuterClass$ResponseReorderFolders) ((Z06.b) z06).a();
                UO1.e.b(UO1.e.a, "reorder Folders successful. Number of folders: " + messagingOuterClass$ResponseReorderFolders.getFolderIdsList().size(), null, 2, null);
                objB = C9475a16.b(messagingOuterClass$ResponseReorderFolders.getFolderIdsList());
            }
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                UO1.e.a.c("reorder Folders failed", thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C5760Ks2(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(c6287Mz, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerToStructExPeerMapper");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = interfaceC14123hO3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(String str, com.google.protobuf.P p, com.google.protobuf.P p2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new j(str, p, p2, this, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:13:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r20, com.google.protobuf.P r21, com.google.protobuf.P r22, ir.nasim.C23270we2 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.j(java.lang.String, com.google.protobuf.P, com.google.protobuf.P, ir.nasim.we2, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object k(C5760Ks2 c5760Ks2, String str, com.google.protobuf.P p, com.google.protobuf.P p2, C23270we2 c23270we2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        return c5760Ks2.j(str, p, p2, (i2 & 8) != 0 ? new C23270we2(0L, 0L, 0.0d, 0.0f, 15, null) : c23270we2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C5760Ks2.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Ks2$b r0 = (ir.nasim.C5760Ks2.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ks2$b r0 = new ir.nasim.Ks2$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.b
            ir.nasim.Ks2$c r2 = new ir.nasim.Ks2$c
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.e(java.lang.String, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C5760Ks2.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Ks2$d r0 = (ir.nasim.C5760Ks2.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ks2$d r0 = new ir.nasim.Ks2$d
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
            ir.nasim.Ks2$e r2 = new ir.nasim.Ks2$e
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.f(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C5760Ks2.f
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Ks2$f r0 = (ir.nasim.C5760Ks2.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ks2$f r0 = new ir.nasim.Ks2$f
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
            ir.nasim.Ks2$g r2 = new ir.nasim.Ks2$g
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.g(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(int r14, java.lang.String r15, java.util.List r16, java.util.List r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r13 = this;
            r7 = r13
            r0 = r18
            boolean r1 = r0 instanceof ir.nasim.C5760Ks2.h
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.Ks2$h r1 = (ir.nasim.C5760Ks2.h) r1
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
            ir.nasim.Ks2$h r1 = new ir.nasim.Ks2$h
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
            ir.nasim.Ks2$i r12 = new ir.nasim.Ks2$i
            r6 = 0
            r0 = r12
            r1 = r14
            r2 = r15
            r3 = r17
            r4 = r16
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.c = r10
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r11, r12, r8)
            if (r0 != r9) goto L52
            return r9
        L52:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.h(int, java.lang.String, java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C5760Ks2.l
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Ks2$l r0 = (ir.nasim.C5760Ks2.l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ks2$l r0 = new ir.nasim.Ks2$l
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.b
            ir.nasim.Ks2$m r2 = new ir.nasim.Ks2$m
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.l(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C5760Ks2.n
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Ks2$n r0 = (ir.nasim.C5760Ks2.n) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ks2$n r0 = new ir.nasim.Ks2$n
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
            ir.nasim.Ks2$o r2 = new ir.nasim.Ks2$o
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5760Ks2.m(java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
