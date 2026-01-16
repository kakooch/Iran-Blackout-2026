package ir.nasim;

import ai.bale.proto.MagazineOuterClass$RequestGetMyUpvotes;
import ai.bale.proto.MagazineOuterClass$RequestRevokeUpvotedPost;
import ai.bale.proto.MagazineOuterClass$RequestUpvotePost;
import ai.bale.proto.MagazineOuterClass$ResponseGetMyUpvotes;
import ai.bale.proto.MagazineOuterClass$ResponseRevokeUpvotedPost;
import ai.bale.proto.MagazineOuterClass$ResponseUpvotePost;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.Z06;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tM3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21245tM3 implements InterfaceC20642sM3 {
    private final AbstractC13778go1 a;
    private final C6287Mz b;
    private final int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final InterfaceC9336Zm4 h;
    private int i;

    /* renamed from: ir.nasim.tM3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21245tM3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String str = C21245tM3.this.g;
                MagazineOuterClass$RequestGetMyUpvotes defaultInstance = MagazineOuterClass$RequestGetMyUpvotes.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                MagazineOuterClass$ResponseGetMyUpvotes defaultInstance2 = MagazineOuterClass$ResponseGetMyUpvotes.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5(str, defaultInstance, defaultInstance2);
                C6287Mz c6287Mz = C21245tM3.this.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
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
            if (!(z06 instanceof Z06.a)) {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                MagazineOuterClass$ResponseGetMyUpvotes magazineOuterClass$ResponseGetMyUpvotes = (MagazineOuterClass$ResponseGetMyUpvotes) ((Z06.b) z06).a();
                C21245tM3.this.l(magazineOuterClass$ResponseGetMyUpvotes.getUpvotes().getUpvotesLimit());
                List<MessagingStruct$HistoryMessageIdentifier> messagesList = magazineOuterClass$ResponseGetMyUpvotes.getUpvotes().getMessagesList();
                InterfaceC9336Zm4 interfaceC9336Zm4F = C21245tM3.this.f();
                do {
                    value = interfaceC9336Zm4F.getValue();
                    AbstractC13042fc3.f(messagesList);
                } while (!interfaceC9336Zm4F.f(value, messagesList));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tM3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;
        final /* synthetic */ EnumC16311l35 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ C21245tM3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, int i, EnumC16311l35 enumC16311l35, long j2, long j3, C21245tM3 c21245tM3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = i;
            this.e = enumC16311l35;
            this.f = j2;
            this.g = j3;
            this.h = c21245tM3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = MessagingStruct$HistoryMessageIdentifier.newBuilder().A(this.f).D(this.g).B(PeersStruct$OutPeer.newBuilder().A(this.c).B(this.d).C(this.e)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                String str = this.h.f;
                GeneratedMessageLite generatedMessageLiteA2 = MagazineOuterClass$RequestRevokeUpvotedPost.newBuilder().A((MessagingStruct$HistoryMessageIdentifier) generatedMessageLiteA).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                MagazineOuterClass$ResponseRevokeUpvotedPost defaultInstance = MagazineOuterClass$ResponseRevokeUpvotedPost.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5(str, generatedMessageLiteA2, defaultInstance);
                C6287Mz c6287Mz = this.h.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
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
            if (!(z06 instanceof Z06.a)) {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                MagazineOuterClass$ResponseRevokeUpvotedPost magazineOuterClass$ResponseRevokeUpvotedPost = (MagazineOuterClass$ResponseRevokeUpvotedPost) ((Z06.b) z06).a();
                this.h.l(magazineOuterClass$ResponseRevokeUpvotedPost.getUpvotes().getUpvotesLimit());
                List<MessagingStruct$HistoryMessageIdentifier> messagesList = magazineOuterClass$ResponseRevokeUpvotedPost.getUpvotes().getMessagesList();
                InterfaceC9336Zm4 interfaceC9336Zm4F = this.h.f();
                do {
                    value = interfaceC9336Zm4F.getValue();
                    AbstractC13042fc3.f(messagesList);
                } while (!interfaceC9336Zm4F.f(value, messagesList));
            }
            return z06;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tM3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;
        final /* synthetic */ EnumC16311l35 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ C21245tM3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, int i, EnumC16311l35 enumC16311l35, long j2, long j3, C21245tM3 c21245tM3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = i;
            this.e = enumC16311l35;
            this.f = j2;
            this.g = j3;
            this.h = c21245tM3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = MessagingStruct$HistoryMessageIdentifier.newBuilder().A(this.f).D(this.g).B(PeersStruct$OutPeer.newBuilder().A(this.c).B(this.d).C(this.e)).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                String str = this.h.e;
                GeneratedMessageLite generatedMessageLiteA2 = MagazineOuterClass$RequestUpvotePost.newBuilder().A((MessagingStruct$HistoryMessageIdentifier) generatedMessageLiteA).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                MagazineOuterClass$ResponseUpvotePost defaultInstance = MagazineOuterClass$ResponseUpvotePost.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5(str, generatedMessageLiteA2, defaultInstance);
                C6287Mz c6287Mz = this.h.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
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
            if (!(z06 instanceof Z06.a)) {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                MagazineOuterClass$ResponseUpvotePost magazineOuterClass$ResponseUpvotePost = (MagazineOuterClass$ResponseUpvotePost) ((Z06.b) z06).a();
                this.h.l(magazineOuterClass$ResponseUpvotePost.getUpvotes().getUpvotesLimit());
                List<MessagingStruct$HistoryMessageIdentifier> messagesList = magazineOuterClass$ResponseUpvotePost.getUpvotes().getMessagesList();
                AbstractC13042fc3.h(messagesList, "getMessagesList(...)");
                InterfaceC9336Zm4 interfaceC9336Zm4F = this.h.f();
                do {
                    value = interfaceC9336Zm4F.getValue();
                } while (!interfaceC9336Zm4F.f(value, messagesList));
            }
            return z06;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21245tM3(AbstractC13778go1 abstractC13778go1, C6287Mz c6287Mz) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = abstractC13778go1;
        this.b = c6287Mz;
        this.c = 5;
        this.d = "/bale.magazine.v1.Magazine/";
        this.e = "/bale.magazine.v1.Magazine/UpvotePost";
        this.f = "/bale.magazine.v1.Magazine/RevokeUpvotedPost";
        this.g = "/bale.magazine.v1.Magazine/GetMyUpvotes";
        this.h = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.i = 5;
    }

    @Override // ir.nasim.InterfaceC20642sM3
    public Object a(long j, long j2, long j3, int i, EnumC16311l35 enumC16311l35, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new c(j3, i, enumC16311l35, j, j2, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC20642sM3
    public Object b(long j, long j2, long j3, int i, EnumC16311l35 enumC16311l35, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new b(j3, i, enumC16311l35, j, j2, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC20642sM3
    public int c() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC20642sM3
    public boolean d(long j) {
        boolean z;
        Iterable iterable = (Iterable) f().getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            z = true;
        } else {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((MessagingStruct$HistoryMessageIdentifier) it.next()).getRandomId() == j) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return !z;
    }

    @Override // ir.nasim.InterfaceC20642sM3
    public Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new a(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20642sM3
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public InterfaceC9336Zm4 f() {
        return this.h;
    }

    public void l(int i) {
        this.i = i;
    }
}
