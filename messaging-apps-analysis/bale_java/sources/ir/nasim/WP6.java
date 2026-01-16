package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.RecommenderOuterClass$RelatedChannel;
import ai.bale.proto.RecommenderOuterClass$RequestGetRelatedChannels;
import ai.bale.proto.RecommenderOuterClass$ResponseGetRelatedChannels;
import ai.bale.proto.StoryOuterClass$RequestAddBotStory;
import ai.bale.proto.StoryOuterClass$RequestAddChannelStory;
import ai.bale.proto.StoryOuterClass$RequestAddStory;
import ai.bale.proto.StoryOuterClass$RequestCanAddBotStory;
import ai.bale.proto.StoryOuterClass$RequestGetBotStories;
import ai.bale.proto.StoryOuterClass$RequestGetChannelStories;
import ai.bale.proto.StoryOuterClass$RequestGetMostPopularStories;
import ai.bale.proto.StoryOuterClass$RequestGetStories;
import ai.bale.proto.StoryOuterClass$RequestGetStoryById;
import ai.bale.proto.StoryOuterClass$RequestGetStoryTags;
import ai.bale.proto.StoryOuterClass$RequestGetUserPrivacyConfig;
import ai.bale.proto.StoryOuterClass$RequestRemoveStory;
import ai.bale.proto.StoryOuterClass$RequestSetUserPrivacyConfig;
import ai.bale.proto.StoryOuterClass$ResponseAddStory;
import ai.bale.proto.StoryOuterClass$ResponseCanAddBotStory;
import ai.bale.proto.StoryOuterClass$ResponseGetBotStories;
import ai.bale.proto.StoryOuterClass$ResponseGetChannelStories;
import ai.bale.proto.StoryOuterClass$ResponseGetMostPopularStories;
import ai.bale.proto.StoryOuterClass$ResponseGetStories;
import ai.bale.proto.StoryOuterClass$ResponseGetStoryById;
import ai.bale.proto.StoryOuterClass$ResponseGetStoryTags;
import ai.bale.proto.StoryOuterClass$ResponseGetUserPrivacyConfig;
import ai.bale.proto.StoryOuterClass$ResponseSetUserPrivacyConfig;
import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$TextStory;
import ai.bale.proto.StoryStruct$UserPrivacyConfig;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class WP6 implements VP6 {
    public static final a b = new a(null);
    public static final int c = C6287Mz.e;
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
        final /* synthetic */ StoryStruct$MediaStory c;
        final /* synthetic */ PeersStruct$ExPeer d;
        final /* synthetic */ C14189hV6 e;
        final /* synthetic */ WP6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(StoryStruct$MediaStory storyStruct$MediaStory, PeersStruct$ExPeer peersStruct$ExPeer, C14189hV6 c14189hV6, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = storyStruct$MediaStory;
            this.d = peersStruct$ExPeer;
            this.e = c14189hV6;
            this.f = wp6;
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
                StoryOuterClass$RequestAddBotStory.a aVarNewBuilder = StoryOuterClass$RequestAddBotStory.newBuilder();
                aVarNewBuilder.C(this.c);
                aVarNewBuilder.B(this.d);
                C14189hV6 c14189hV6 = this.e;
                if (c14189hV6 != null) {
                    aVarNewBuilder.A(c14189hV6.a());
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseAddStory defaultInstance = StoryOuterClass$ResponseAddStory.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/AddBotStory", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.f.a;
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
        final /* synthetic */ StoryStruct$MediaStory c;
        final /* synthetic */ PeersStruct$ExPeer d;
        final /* synthetic */ C14189hV6 e;
        final /* synthetic */ WP6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(StoryStruct$MediaStory storyStruct$MediaStory, PeersStruct$ExPeer peersStruct$ExPeer, C14189hV6 c14189hV6, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = storyStruct$MediaStory;
            this.d = peersStruct$ExPeer;
            this.e = c14189hV6;
            this.f = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestAddChannelStory.a aVarNewBuilder = StoryOuterClass$RequestAddChannelStory.newBuilder();
                aVarNewBuilder.C(this.c);
                aVarNewBuilder.B(this.d);
                C14189hV6 c14189hV6 = this.e;
                if (c14189hV6 != null) {
                    aVarNewBuilder.A(c14189hV6.a());
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseAddStory defaultInstance = StoryOuterClass$ResponseAddStory.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/AddChannelStory", generatedMessageLiteA, defaultInstance);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ StoryStruct$MediaStory c;
        final /* synthetic */ C14189hV6 d;
        final /* synthetic */ WP6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = storyStruct$MediaStory;
            this.d = c14189hV6;
            this.e = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestAddStory.a aVarNewBuilder = StoryOuterClass$RequestAddStory.newBuilder();
                aVarNewBuilder.C(this.c);
                C14189hV6 c14189hV6 = this.d;
                if (c14189hV6 != null) {
                    aVarNewBuilder.A(c14189hV6.a());
                    if (c14189hV6.b()) {
                        aVarNewBuilder.B(EnumC21337tU6.ExceptionType_All);
                    }
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseAddStory defaultInstance = StoryOuterClass$ResponseAddStory.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/AddStory", generatedMessageLiteA, defaultInstance);
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PeersStruct$ExPeer c;
        final /* synthetic */ StoryStruct$TextStory d;
        final /* synthetic */ WP6 e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC10088b35.values().length];
                try {
                    iArr[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PeersStruct$ExPeer peersStruct$ExPeer, StoryStruct$TextStory storyStruct$TextStory, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = peersStruct$ExPeer;
            this.d = storyStruct$TextStory;
            this.e = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            GeneratedMessageLite generatedMessageLiteA;
            String str;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                EnumC10088b35 type = this.c.getType();
                int i2 = type == null ? -1 : a.a[type.ordinal()];
                if (i2 == 1) {
                    generatedMessageLiteA = StoryOuterClass$RequestAddStory.newBuilder().D(this.d).a();
                    str = "AddStory";
                } else if (i2 != 2) {
                    generatedMessageLiteA = StoryOuterClass$RequestAddChannelStory.newBuilder().B(this.c).D(this.d).a();
                    str = "AddChannelStory";
                } else {
                    generatedMessageLiteA = StoryOuterClass$RequestAddBotStory.newBuilder().B(this.c).D(this.d).a();
                    str = "AddBotStory";
                }
                AbstractC13042fc3.f(generatedMessageLiteA);
                StoryOuterClass$ResponseAddStory defaultInstance = StoryOuterClass$ResponseAddStory.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/" + str, generatedMessageLiteA, defaultInstance);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            Object objC = WP6.this.c(0, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = wp6;
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
                StoryOuterClass$RequestCanAddBotStory storyOuterClass$RequestCanAddBotStory = (StoryOuterClass$RequestCanAddBotStory) StoryOuterClass$RequestCanAddBotStory.newBuilder().A(this.c).a();
                AbstractC13042fc3.f(storyOuterClass$RequestCanAddBotStory);
                StoryOuterClass$ResponseCanAddBotStory defaultInstance = StoryOuterClass$ResponseCanAddBotStory.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/CanAddBotStory", storyOuterClass$RequestCanAddBotStory, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC6392Nk0.a(((StoryOuterClass$ResponseCanAddBotStory) ((Z06.b) z06).a()).getCanAddBotStory()));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WP6.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetBotStories.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetBotStories defaultInstance = StoryOuterClass$ResponseGetBotStories.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetBotStories", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = WP6.this.a;
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WP6.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetChannelStories.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetChannelStories defaultInstance = StoryOuterClass$ResponseGetChannelStories.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetChannelStories", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = WP6.this.a;
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(boolean z, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryOuterClass$RequestGetMostPopularStories.a aVarNewBuilder = StoryOuterClass$RequestGetMostPopularStories.newBuilder();
                if (this.c) {
                    aVarNewBuilder.A(LU6.StoryOptimization_SpecialStoriesList);
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetMostPopularStories defaultInstance = StoryOuterClass$ResponseGetMostPopularStories.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetMostPopularStories", generatedMessageLiteA, defaultInstance);
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objK = WP6.this.k(null, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PeersStruct$ExPeer c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(PeersStruct$ExPeer peersStruct$ExPeer, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = peersStruct$ExPeer;
            this.d = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    GeneratedMessageLite generatedMessageLiteA = RecommenderOuterClass$RequestGetRelatedChannels.newBuilder().A(this.c).a();
                    AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                    RecommenderOuterClass$ResponseGetRelatedChannels defaultInstance = RecommenderOuterClass$ResponseGetRelatedChannels.getDefaultInstance();
                    AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                    C22871vx5 c22871vx5 = new C22871vx5("/bale.recommender.v1.Recommender/GetRelatedChannels", generatedMessageLiteA, defaultInstance);
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
                    C9475a16.a aVar = C9475a16.b;
                    objB = C9475a16.b(AbstractC10685c16.a(((Z06.a) z06).a()));
                } else {
                    if (!(z06 instanceof Z06.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<RecommenderOuterClass$RelatedChannel> relatedChannelsList = ((RecommenderOuterClass$ResponseGetRelatedChannels) ((Z06.b) z06).a()).getRelatedChannelsList();
                    AbstractC13042fc3.h(relatedChannelsList, "getRelatedChannelsList(...)");
                    List<RecommenderOuterClass$RelatedChannel> list = relatedChannelsList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((RecommenderOuterClass$RelatedChannel) it.next()).getExPeer().getId()));
                    }
                    objB = C9475a16.b(arrayList);
                }
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    throw e;
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(e));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WP6.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetStories.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetStories defaultInstance = StoryOuterClass$ResponseGetStories.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetStories", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = WP6.this.a;
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(String str, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetStoryById.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetStoryById defaultInstance = StoryOuterClass$ResponseGetStoryById.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetStoryById", generatedMessageLiteA, defaultInstance);
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WP6.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetUserPrivacyConfig.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetUserPrivacyConfig defaultInstance = StoryOuterClass$ResponseGetUserPrivacyConfig.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetUserPrivacyConfig", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = WP6.this.a;
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
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return WP6.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestGetStoryTags.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseGetStoryTags defaultInstance = StoryOuterClass$ResponseGetStoryTags.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/GetStoryTags", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = WP6.this.a;
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
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new q(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestRemoveStory.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/RemoveStory", generatedMessageLiteA, defaultInstance);
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
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ StoryStruct$UserPrivacyConfig c;
        final /* synthetic */ WP6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig, WP6 wp6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = storyStruct$UserPrivacyConfig;
            this.d = wp6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new r(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = StoryOuterClass$RequestSetUserPrivacyConfig.newBuilder().A(this.c).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                StoryOuterClass$ResponseSetUserPrivacyConfig defaultInstance = StoryOuterClass$ResponseSetUserPrivacyConfig.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.story.v1.Story/SetUserPrivacyConfig", generatedMessageLiteA, defaultInstance);
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
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public WP6(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    @Override // ir.nasim.VP6
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new m(null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new i(null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.VP6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.WP6.f
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.WP6$f r0 = (ir.nasim.WP6.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.WP6$f r0 = new ir.nasim.WP6$f
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
            ir.nasim.WP6$g r2 = new ir.nasim.WP6$g
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WP6.c(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.VP6
    public Object d(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new j(z, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object e(StoryStruct$TextStory storyStruct$TextStory, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new e(peersStruct$ExPeer, storyStruct$TextStory, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object f(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new r(storyStruct$UserPrivacyConfig, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object g(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new h(null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object h(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new o(null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object i(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new n(str, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object j(StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new d(storyStruct$MediaStory, c14189hV6, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.VP6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(ai.bale.proto.PeersStruct$ExPeer r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.WP6.k
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.WP6$k r0 = (ir.nasim.WP6.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.WP6$k r0 = new ir.nasim.WP6$k
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
            ir.nasim.WP6$l r2 = new ir.nasim.WP6$l
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.WP6.k(ai.bale.proto.PeersStruct$ExPeer, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.VP6
    public Object l(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new q(str, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object m(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new p(null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object n(StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(storyStruct$MediaStory, peersStruct$ExPeer, c14189hV6, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.VP6
    public Object o(PeersStruct$ExPeer peersStruct$ExPeer, StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(storyStruct$MediaStory, peersStruct$ExPeer, c14189hV6, this, null), interfaceC20295rm1);
    }
}
