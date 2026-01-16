package ir.nasim;

import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.ImagesOuterClass$RequestAddStickerPack;
import ai.bale.proto.ImagesOuterClass$RequestLoadOwnStickers;
import ai.bale.proto.ImagesOuterClass$RequestLoadStickerCollection;
import ai.bale.proto.ImagesOuterClass$RequestRemoveStickerPack;
import ai.bale.proto.ImagesOuterClass$ResponseLoadOwnStickers;
import ai.bale.proto.ImagesOuterClass$ResponseLoadStickerCollection;
import ai.bale.proto.ImagesStruct$StickerCollection;
import ai.bale.proto.Misc$ResponseSeq;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.Z06;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class BN6 {
    public static final b e = new b(null);
    public static final int f = 8;
    private static final InterfaceC8327Vm4 g = AbstractC11420cy6.b(0, 1, null, 5, null);
    private static volatile BN6 h;
    private final CN6 a;
    private final C14080hJ5 b;
    private final C6287Mz c;
    private final InterfaceC3570Bk5 d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.BN6$a$a, reason: collision with other inner class name */
        static final class C0290a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ BN6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0290a(BN6 bn6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = bn6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0290a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    BN6 bn6 = this.c;
                    this.b = 1;
                    if (bn6.u(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0290a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BN6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4B = BN6.e.b();
                C0290a c0290a = new C0290a(BN6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC8327Vm4B, c0290a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b {
        private b() {
        }

        public final BN6 a(C6287Mz c6287Mz, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC3570Bk5 interfaceC3570Bk52) {
            AbstractC13042fc3.i(c6287Mz, "apiModule");
            AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
            AbstractC13042fc3.i(interfaceC3570Bk52, "emojiPreferencesStorage");
            if (BN6.h == null) {
                synchronized (BN6.class) {
                    if (BN6.h == null) {
                        try {
                            BN6.h = new BN6(CN6.d.a(interfaceC3570Bk5), new C14080hJ5(interfaceC3570Bk52), c6287Mz, interfaceC3570Bk5);
                        } catch (Exception e) {
                            C19406qI3.a("StickersRepository", "Error in stickers repository getInstance e: " + e, new Object[0]);
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            }
            BN6 bn6 = BN6.h;
            AbstractC13042fc3.f(bn6);
            return bn6;
        }

        public final InterfaceC8327Vm4 b() {
            return BN6.g;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C23698xM6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23698xM6 c23698xM6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c23698xM6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BN6.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List listP1 = AbstractC15401jX0.p1(BN6.this.b.w());
            C23698xM6 c23698xM6 = this.d;
            Iterator it = listP1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((C12871fJ5) next).q(), c23698xM6)) {
                    break;
                }
            }
            C12871fJ5 c12871fJ5 = (C12871fJ5) next;
            int iR = c12871fJ5 != null ? c12871fJ5.r() : 0;
            if (iR == 0 && listP1.size() >= 20) {
                listP1.remove(AbstractC10360bX0.o(listP1));
            }
            C12871fJ5 c12871fJ52 = new C12871fJ5(this.d, iR + 1);
            if (c12871fJ5 != null) {
                listP1.remove(c12871fJ5);
            }
            listP1.add(0, c12871fJ52);
            BN6.this.b.C(AbstractC13489gJ5.a(listP1, 20));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return BN6.this.k(null, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ OM6 c;
        final /* synthetic */ BN6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(OM6 om6, BN6 bn6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = om6;
            this.d = bn6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19406qI3.a("StickersRepository", "AddStickersCollection id : " + this.c.u(), new Object[0]);
                GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestAddStickerPack.newBuilder().A(this.c.u()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.v1.Images/AddStickerPack", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.c;
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
            if (z06 instanceof Z06.b) {
                this.d.a.s(this.c);
            }
            return z06;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BN6.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            BN6.this.b.r();
            return AbstractC6392Nk0.a(C14080hJ5.z(BN6.this.b, null, 1, null));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String d;
        final /* synthetic */ BN6 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, BN6 bn6, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = bn6;
            this.f = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, this.e, this.f, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                if (!AbstractC20906so1.g(interfaceC20315ro12)) {
                    return C19938rB7.a;
                }
                C19406qI3.a("StickersRepository", "loadOwnStickers  offset : " + this.d, new Object[0]);
                ImagesOuterClass$RequestLoadOwnStickers.a aVarNewBuilder = ImagesOuterClass$RequestLoadOwnStickers.newBuilder();
                String str = this.d;
                if (str != null) {
                    aVarNewBuilder.A((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(str).a());
                }
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                ImagesOuterClass$ResponseLoadOwnStickers defaultInstance = ImagesOuterClass$ResponseLoadOwnStickers.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.v1.Images/LoadOwnStickers", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.c;
                this.c = interfaceC20315ro12;
                this.b = 1;
                interfaceC20315ro1 = interfaceC20315ro12;
                objC = InterfaceC16847ly.c(c6287Mz, c22871vx5, 16500L, null, this, 4, null);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.e.d.g("key_sp_stickers_loaded_v2.1", true);
                    return C19938rB7.a;
                }
                InterfaceC20315ro1 interfaceC20315ro13 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = interfaceC20315ro13;
                objC = obj;
            }
            Z06 z06 = (Z06) objC;
            if (z06 instanceof Z06.b) {
                ImagesOuterClass$ResponseLoadOwnStickers imagesOuterClass$ResponseLoadOwnStickers = (ImagesOuterClass$ResponseLoadOwnStickers) ((Z06.b) z06).a();
                if (imagesOuterClass$ResponseLoadOwnStickers == null) {
                    return C19938rB7.a;
                }
                String text = imagesOuterClass$ResponseLoadOwnStickers.getOffset().getText();
                ArrayList arrayList = new ArrayList();
                List list = this.f;
                if (list != null) {
                    arrayList.addAll(list);
                }
                List<ImagesStruct$StickerCollection> ownStickersList = imagesOuterClass$ResponseLoadOwnStickers.getOwnStickersList();
                AbstractC13042fc3.h(ownStickersList, "getOwnStickersList(...)");
                for (ImagesStruct$StickerCollection imagesStruct$StickerCollection : ownStickersList) {
                    if (imagesStruct$StickerCollection != null) {
                        GC gcA1 = C18732p92.a1(imagesStruct$StickerCollection);
                        AbstractC13042fc3.f(gcA1);
                        OM6 om6 = new OM6(gcA1);
                        if (!arrayList.contains(om6)) {
                            arrayList.add(om6);
                        }
                    }
                }
                if (text == null || text.length() == 0) {
                    if (!AbstractC20906so1.g(interfaceC20315ro1)) {
                        return C19938rB7.a;
                    }
                    CN6 cn6 = this.e.a;
                    this.c = null;
                    this.b = 3;
                    if (cn6.y(arrayList, this) == objE) {
                        return objE;
                    }
                    this.e.d.g("key_sp_stickers_loaded_v2.1", true);
                } else {
                    BN6 bn6 = this.e;
                    this.c = null;
                    this.b = 2;
                    if (bn6.n(text, arrayList, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (!(z06 instanceof Z06.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                C19406qI3.a("StickersRepository", "loadOwnStickers  failure : " + ((Z06.a) z06).a(), new Object[0]);
                this.e.d.g("key_sp_stickers_loaded_v2.1", false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            return BN6.this.q(this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ BN6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, long j, BN6 bn6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = j;
            this.e = bn6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19406qI3.a("StickersRepository", "LoadStickersCollection id : " + this.c, new Object[0]);
                GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestLoadStickerCollection.newBuilder().B(this.c).A(this.d).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                ImagesOuterClass$ResponseLoadStickerCollection defaultInstance = ImagesOuterClass$ResponseLoadStickerCollection.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.v1.Images/LoadStickerCollection", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.e.c;
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
        final /* synthetic */ OM6 c;
        final /* synthetic */ BN6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(OM6 om6, BN6 bn6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = om6;
            this.d = bn6;
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
                C19406qI3.a("StickersRepository", "RemoveStickersCollection id : " + this.c.u(), new Object[0]);
                GeneratedMessageLite generatedMessageLiteA = ImagesOuterClass$RequestRemoveStickerPack.newBuilder().A(this.c.u()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.v1.Images/RemoveStickerPack", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.c;
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
            if (z06 instanceof Z06.b) {
                this.d.a.w(this.c);
            }
            return z06;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public BN6(CN6 cn6, C14080hJ5 c14080hJ5, C6287Mz c6287Mz, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(cn6, "stickersStorage");
        AbstractC13042fc3.i(c14080hJ5, "recentStickersStorage");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        this.a = cn6;
        this.b = c14080hJ5;
        this.c = c6287Mz;
        this.d = interfaceC3570Bk5;
        AbstractC10533bm0.d(C17050mJ2.a, null, null, new a(null), 3, null);
    }

    private final Object j(C23698xM6 c23698xM6, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.a(), new c(c23698xM6, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(String str, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.b(), new g(str, this, list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public static final BN6 o(C6287Mz c6287Mz, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC3570Bk5 interfaceC3570Bk52) {
        return e.a(c6287Mz, interfaceC3570Bk5, interfaceC3570Bk52);
    }

    public static final InterfaceC8327Vm4 r() {
        return e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(InterfaceC20295rm1 interfaceC20295rm1) {
        if (this.d.h("key_sp_stickers_loaded_v2.1", false)) {
            return C19938rB7.a;
        }
        Object objN = n(null, null, interfaceC20295rm1);
        return objN == AbstractC14862ic3.e() ? objN : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.C23698xM6 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.BN6.d
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.BN6$d r0 = (ir.nasim.BN6.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.BN6$d r0 = new ir.nasim.BN6$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.BN6 r5 = (ir.nasim.BN6) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r4.j(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            ir.nasim.hJ5 r5 = r5.b
            r6 = 0
            boolean r5 = ir.nasim.C14080hJ5.z(r5, r6, r3, r6)
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BN6.k(ir.nasim.xM6, ir.nasim.rm1):java.lang.Object");
    }

    public final Object l(OM6 om6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new e(om6, this, null), interfaceC20295rm1);
    }

    public final Object m(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.b(), new f(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final InterfaceC10258bL6 p() {
        return this.a.u();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.BN6.h
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.BN6$h r0 = (ir.nasim.BN6.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.BN6$h r0 = new ir.nasim.BN6$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.hJ5 r5 = r4.b
            r0.c = r3
            java.lang.Object r5 = r5.u(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r5, r1)
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L50:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r5.next()
            ir.nasim.fJ5 r1 = (ir.nasim.C12871fJ5) r1
            ir.nasim.xM6 r1 = r1.q()
            r0.add(r1)
            goto L50
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BN6.q(ir.nasim.rm1):java.lang.Object");
    }

    public final Object s(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objN = n(null, null, interfaceC20295rm1);
        return objN == AbstractC14862ic3.e() ? objN : C19938rB7.a;
    }

    public final boolean t(int i2) {
        Iterable iterable = (Iterable) this.a.u().getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((OM6) it.next()).u() == i2) {
                return true;
            }
        }
        return false;
    }

    public final Object v(int i2, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new i(i2, j2, this, null), interfaceC20295rm1);
    }

    public final Object w(OM6 om6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new j(om6, this, null), interfaceC20295rm1);
    }
}
