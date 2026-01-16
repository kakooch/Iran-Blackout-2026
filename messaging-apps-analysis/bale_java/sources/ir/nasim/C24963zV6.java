package ir.nasim;

import ai.bale.proto.StoryOuterClass$RequestGetDefaultStoryBackgrounds;
import ai.bale.proto.StoryOuterClass$RequestGetUserStoryConfig;
import ai.bale.proto.StoryOuterClass$ResponseGetDefaultStoryBackgrounds;
import ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: ir.nasim.zV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24963zV6 {
    public static final int b = C6287Mz.e;
    private final C6287Mz a;

    /* renamed from: ir.nasim.zV6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24963zV6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetUserStoryConfig.newBuilder().B(XU6.UserConfigKey_TextStoryBackgrounds).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetUserStoryConfig defaultInstance = StoryOuterClass$ResponseGetUserStoryConfig.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetUserStoryConfig", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C24963zV6.this.a;
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

    /* renamed from: ir.nasim.zV6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24963zV6.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetDefaultStoryBackgrounds.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetDefaultStoryBackgrounds defaultInstance = StoryOuterClass$ResponseGetDefaultStoryBackgrounds.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetDefaultStoryBackgrounds", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = C24963zV6.this.a;
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

    public C24963zV6(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    public final Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new a(null), interfaceC20295rm1);
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(null), interfaceC20295rm1);
    }
}
