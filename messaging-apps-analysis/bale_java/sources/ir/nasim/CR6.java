package ir.nasim;

import ai.bale.proto.StoryOuterClass$RequestGetUserStoryConfig;
import ai.bale.proto.StoryOuterClass$RequestSetUserStoryConfig;
import ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig;
import ai.bale.proto.StoryOuterClass$ResponseSetUserStoryConfig;
import ai.bale.proto.StoryStruct$NotificationConfig;
import ai.bale.proto.StoryStruct$UserStoryConfig;
import com.google.protobuf.GeneratedMessageLite;
import java.util.List;

/* loaded from: classes6.dex */
public final class CR6 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final C6287Mz a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ CR6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, CR6 cr6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = cr6;
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
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetUserStoryConfig.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetUserStoryConfig defaultInstance = StoryOuterClass$ResponseGetUserStoryConfig.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetUserStoryConfig", generatedMessageLiteA, defaultInstance);
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ XU6 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ CR6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(XU6 xu6, boolean z, CR6 cr6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = xu6;
            this.d = z;
            this.e = cr6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestSetUserStoryConfig.newBuilder().B(EnumC17153mU6.ConfigSetType_Replace).A((StoryStruct$UserStoryConfig) StoryStruct$UserStoryConfig.newBuilder().A(this.c).B((StoryStruct$NotificationConfig) StoryStruct$NotificationConfig.newBuilder().A(this.d).a()).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseSetUserStoryConfig defaultInstance = StoryOuterClass$ResponseSetUserStoryConfig.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/SetUserStoryConfig", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.a;
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

    public CR6(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public final Object b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(list, this, null), interfaceC20295rm1);
    }

    public final Object c(XU6 xu6, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(xu6, z, this, null), interfaceC20295rm1);
    }
}
