package ir.nasim;

import ai.bale.proto.StoryOuterClass$RequestGetStoryWidgets;
import ai.bale.proto.StoryOuterClass$RequestGetViewers;
import ai.bale.proto.StoryOuterClass$RequestGetViewersCount;
import ai.bale.proto.StoryOuterClass$ResponseGetStoryWidgets;
import ai.bale.proto.StoryOuterClass$ResponseGetViewers;
import ai.bale.proto.StoryOuterClass$ResponseGetViewersCount;
import ai.bale.proto.StoryStruct$ViewersPagination;
import com.google.protobuf.GeneratedMessageLite;

/* loaded from: classes7.dex */
public final class VV6 {
    public static final int b = C6287Mz.e;
    private final C6287Mz a;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ VV6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, VV6 vv6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = vv6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetViewersCount.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetViewersCount defaultInstance = StoryOuterClass$ResponseGetViewersCount.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetViewersCount", generatedMessageLiteA, defaultInstance);
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ VV6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i, int i2, VV6 vv6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = i;
            this.e = i2;
            this.f = vv6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetViewers.newBuilder().B(this.c).A((StoryStruct$ViewersPagination) StoryStruct$ViewersPagination.newBuilder().B(this.d).A(this.e).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetViewers defaultInstance = StoryOuterClass$ResponseGetViewers.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetViewers", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.f.a;
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ VV6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, VV6 vv6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = vv6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetStoryWidgets.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetStoryWidgets defaultInstance = StoryOuterClass$ResponseGetStoryWidgets.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetStoryWidgets", generatedMessageLiteA, defaultInstance);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public VV6(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public final Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(str, this, null), interfaceC20295rm1);
    }

    public final Object c(String str, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(str, i, i2, this, null), interfaceC20295rm1);
    }

    public final Object d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(str, this, null), interfaceC20295rm1);
    }
}
