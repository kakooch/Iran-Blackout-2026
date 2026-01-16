package ir.nasim;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import ai.bale.proto.StoryOuterClass$ResponseGetDefaultStoryBackgrounds;
import ai.bale.proto.StoryOuterClass$ResponseGetUserPrivacyConfig;
import ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig;
import ai.bale.proto.StoryOuterClass$ResponseGetViewers;
import ai.bale.proto.StoryOuterClass$ResponseGetViewersCount;
import ai.bale.proto.StoryStruct$Coordinate;
import ai.bale.proto.StoryStruct$LinkWidget;
import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$Position;
import ai.bale.proto.StoryStruct$PostWidget;
import ai.bale.proto.StoryStruct$TextStory;
import ai.bale.proto.StoryStruct$UserPrivacyConfig;
import ai.bale.proto.StoryStruct$UserStoryConfig;
import ai.bale.proto.StoryStruct$VideoStory;
import ai.bale.proto.StoryStruct$Viewer;
import ai.bale.proto.StoryStruct$Widget;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.GeneratedMessageLite;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14180hU6;
import ir.nasim.AbstractC23640xG2;
import ir.nasim.C10366bX6;
import ir.nasim.C12335eR6;
import ir.nasim.DX6;
import ir.nasim.FQ6;
import ir.nasim.InterfaceC10294bP6;
import ir.nasim.InterfaceC14190hV7;
import ir.nasim.InterfaceC22036uZ3;
import ir.nasim.LA3;
import ir.nasim.Q12;
import ir.nasim.RY1;
import ir.nasim.W9;
import ir.nasim.Z06;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.story.model.StoryWidget;
import ir.nasim.story.repository.StoryRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.bX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10366bX6 extends VW7 {
    public static final C10368b w1 = new C10368b(null);
    public static final int x1 = 8;
    private static final XV4 y1 = new XV4(40, 22);
    private C18502om A;
    private ConcurrentHashMap A0;
    private final InterfaceC9336Zm4 B;
    private final ArrayList B0;
    private final InterfaceC9336Zm4 C0;
    private final InterfaceC10258bL6 D;
    private final InterfaceC10258bL6 D0;
    private final InterfaceC9336Zm4 E0;
    private final InterfaceC10258bL6 F0;
    private final InterfaceC8327Vm4 G;
    private final InterfaceC9336Zm4 G0;
    private final InterfaceC10040ay6 H;
    private final InterfaceC10258bL6 H0;
    private final InterfaceC9336Zm4 I0;
    private final InterfaceC8327Vm4 J;
    private final InterfaceC10258bL6 J0;
    private final InterfaceC9336Zm4 K0;
    private final InterfaceC10258bL6 L0;
    private final C17628nH7 M0;
    private final InterfaceC9336Zm4 N0;
    private final InterfaceC10258bL6 O0;
    private final C20298rm4 P0;
    private final androidx.lifecycle.r Q0;
    private final InterfaceC8327Vm4 R0;
    private final InterfaceC10040ay6 S0;
    private final InterfaceC8327Vm4 T0;
    private final InterfaceC10040ay6 U0;
    private final InterfaceC9336Zm4 V0;
    private final InterfaceC10258bL6 W0;
    private boolean X0;
    private final InterfaceC10040ay6 Y;
    private C22548vQ6 Y0;
    private final InterfaceC9336Zm4 Z;
    private final List Z0;
    private final List a1;
    private final HP5 b;
    private final String b1;
    private final StoryRepository c;
    private final InterfaceC10040ay6 c1;
    private final JX7 d;
    private final InterfaceC9173Yu3 d1;
    private final BH7 e;
    private final InterfaceC9173Yu3 e1;
    private final C6409Nm f;
    private final InterfaceC9173Yu3 f1;
    private final InterfaceC3570Bk5 g;
    private final InterfaceC9173Yu3 g1;
    private final SettingsModule h;
    private final boolean h1;
    private final C14970in2 i;
    private PeersStruct$ExPeer i1;
    private final InterfaceC12532em2 j;
    private final HashMap j1;
    private final MC k;
    private int k1;
    private final C21670tw l;
    private List l1;
    private final NC m;
    private List m1;
    private final InterfaceC14123hO3 n;
    private int n1;
    private final DX6.b o;
    private String o1;
    private final C6559Oa2 p;
    private final Map p1;
    private final IT7 q;
    private int q1;
    private final IT7 r;
    private int r1;
    private final int s;
    private final InterfaceC9173Yu3 s1;
    private final InterfaceC19567qa2 t;
    private InterfaceC3817Cm0 t1;
    private final JE2 u;
    private final InterfaceC19699qn4 u1;
    private final InterfaceC5409Jf2 v;
    private boolean v1;
    private final C9847af4 w;
    private final C15753k68 x;
    private final C13011fZ1 y;
    private final InterfaceC8327Vm4 z;
    private final InterfaceC9336Zm4 z0;

    /* renamed from: ir.nasim.bX6$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(List list, C11692dR6 c11692dR6, C11692dR6 c11692dR62) {
            return list.indexOf(c11692dR6) > list.indexOf(c11692dR62) ? 1 : -1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new A(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List listA;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C18502om c18502om = C10366bX6.this.A;
            if (c18502om == null || (listA = c18502om.a()) == null) {
                return AbstractC10360bX0.m();
            }
            List list = listA;
            final ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((C12335eR6) it.next()).b());
            }
            Collection collectionValues = AbstractC19460qO3.j(C10366bX6.this.A0, new Comparator() { // from class: ir.nasim.eX6
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return C10366bX6.A.y(arrayList, (C11692dR6) obj2, (C11692dR6) obj3);
                }
            }).values();
            AbstractC13042fc3.h(collectionValues, "<get-values>(...)");
            return AbstractC10976cX0.z(collectionValues);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ String i;
        final /* synthetic */ PeersStruct$ExPeer j;
        final /* synthetic */ Long k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(String str, PeersStruct$ExPeer peersStruct$ExPeer, Long l, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = str;
            this.j = peersStruct$ExPeer;
            this.k = l;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean D(Long l, C17428mw7 c17428mw7) {
            return l != null && ((QQ6) c17428mw7.f()).i() == l.longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean G(Long l, QQ6 qq6) {
            return AbstractC13042fc3.d(qq6.l(), l.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean H(Long l, QQ6 qq6) {
            return AbstractC13042fc3.d(qq6.l(), l.toString());
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new B(this.i, this.j, this.k, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[Catch: all -> 0x0024, TRY_ENTER, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x001f, B:22:0x008b, B:25:0x0093, B:27:0x00a2, B:33:0x00e8, B:35:0x00ed, B:38:0x011f, B:40:0x012b, B:41:0x0132, B:43:0x013e, B:44:0x014a, B:46:0x015d, B:47:0x0165, B:48:0x0174, B:61:0x01d5, B:28:0x00bc, B:30:0x00cb, B:49:0x0178, B:51:0x017c, B:54:0x01a0, B:56:0x01ac, B:57:0x01b8, B:59:0x01cb, B:60:0x01d2, B:64:0x01dd, B:65:0x01e2), top: B:72:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0178 A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x001f, B:22:0x008b, B:25:0x0093, B:27:0x00a2, B:33:0x00e8, B:35:0x00ed, B:38:0x011f, B:40:0x012b, B:41:0x0132, B:43:0x013e, B:44:0x014a, B:46:0x015d, B:47:0x0165, B:48:0x0174, B:61:0x01d5, B:28:0x00bc, B:30:0x00cb, B:49:0x0178, B:51:0x017c, B:54:0x01a0, B:56:0x01ac, B:57:0x01b8, B:59:0x01cb, B:60:0x01d2, B:64:0x01dd, B:65:0x01e2), top: B:72:0x001f }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 490
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.B.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;

        /* renamed from: ir.nasim.bX6$C$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((AbstractC23640xG2) this.c) instanceof AbstractC23640xG2.b);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC23640xG2 abstractC23640xG2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC23640xG2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C c = C10366bX6.this.new C(this.e, interfaceC20295rm1);
            c.c = obj;
            return c;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC16204ks5 interfaceC16204ks5;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                InterfaceC10258bL6 interfaceC10258bL6H3 = C10366bX6.this.H3();
                a aVar = new a(null);
                this.c = interfaceC16204ks5;
                this.b = 1;
                obj = AbstractC6459Nq2.J(interfaceC10258bL6H3, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC10685c16.b(obj);
            }
            if (((AbstractC23640xG2) obj) == null) {
                List listM = AbstractC10360bX0.m();
                this.c = null;
                this.b = 2;
                if (interfaceC16204ks5.o(listM, this) == objE) {
                    return objE;
                }
            } else {
                List listP4 = C10366bX6.this.p4(this.e);
                this.c = null;
                this.b = 3;
                if (interfaceC16204ks5.o(listP4, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new D(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BH7 bh7 = C10366bX6.this.e;
                this.b = 1;
                obj = bh7.e(this);
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
                ArrayList arrayList = new ArrayList();
                for (StoryStruct$MediaStory storyStruct$MediaStory : ((StoryOuterClass$ResponseGetDefaultStoryBackgrounds) ((Z06.b) z06).a()).getDefaultStoryBackgroundsList()) {
                    C10366bX6 c10366bX6 = C10366bX6.this;
                    AbstractC13042fc3.f(storyStruct$MediaStory);
                    arrayList.add(c10366bX6.b3(storyStruct$MediaStory));
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = C10366bX6.this.Z;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, arrayList));
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(String str, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new E(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                JX7 jx7 = C10366bX6.this.d;
                String str = this.d;
                int i2 = this.e;
                int i3 = this.f;
                this.b = 1;
                obj = jx7.e(str, i2, i3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                Z06.b bVar = (Z06.b) z06;
                C10366bX6.this.P5(((StoryOuterClass$ResponseGetViewers) bVar.a()).getLikeCount());
                C10366bX6.this.b6(((StoryOuterClass$ResponseGetViewers) bVar.a()).getViewCount() != 0 ? ((StoryOuterClass$ResponseGetViewers) bVar.a()).getViewCount() - 1 : 0);
                C10366bX6.this.O5(this.d);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C10366bX6.this.G;
                String strN3 = C10366bX6.this.N3();
                List<StoryStruct$Viewer> viewersList = ((StoryOuterClass$ResponseGetViewers) bVar.a()).getViewersList();
                AbstractC13042fc3.h(viewersList, "getViewersList(...)");
                C10366bX6 c10366bX6 = C10366bX6.this;
                ArrayList<StoryStruct$Viewer> arrayList = new ArrayList();
                for (Object obj2 : viewersList) {
                    if (((StoryStruct$Viewer) obj2).getUserId() != c10366bX6.W3()) {
                        arrayList.add(obj2);
                    }
                }
                C10366bX6 c10366bX62 = C10366bX6.this;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                for (StoryStruct$Viewer storyStruct$Viewer : arrayList) {
                    NC nc = c10366bX62.m;
                    AbstractC13042fc3.f(storyStruct$Viewer);
                    arrayList2.add(nc.a(storyStruct$Viewer));
                }
                C21364tX6 c21364tX6 = new C21364tX6(strN3, arrayList2);
                this.b = 2;
                if (interfaceC8327Vm4.a(c21364tX6, this) == objE) {
                    return objE;
                }
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QQ6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qq6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new F(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                JX7 jx7 = C10366bX6.this.d;
                QQ6 qq6 = this.d;
                this.b = 1;
                obj = jx7.f(qq6, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC8327Vm4 interfaceC8327Vm4 = C10366bX6.this.T0;
            this.b = 2;
            if (interfaceC8327Vm4.a((List) obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$G */
    static final class G extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        G(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new G(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryRepository storyRepository = C10366bX6.this.c;
                this.b = 1;
                obj = storyRepository.J(this);
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
                Z06.b bVar = (Z06.b) z06;
                if (((StoryOuterClass$ResponseGetUserPrivacyConfig) bVar.a()).getResultList() != null) {
                    C10366bX6.this.l1.clear();
                    for (StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig : ((StoryOuterClass$ResponseGetUserPrivacyConfig) bVar.a()).getResultList()) {
                        List list = C10366bX6.this.l1;
                        C10366bX6 c10366bX6 = C10366bX6.this;
                        AbstractC13042fc3.f(storyStruct$UserPrivacyConfig);
                        list.add(c10366bX6.Y2(storyStruct$UserPrivacyConfig));
                    }
                    C10366bX6.this.P0.n(C10366bX6.this.l1);
                }
            } else {
                if (!(z06 instanceof Z06.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                C10366bX6.this.P0.n(new ArrayList());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((G) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ QQ6 e;
        final /* synthetic */ C10366bX6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(QQ6 qq6, C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = qq6;
            this.f = c10366bX6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new H(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            FileReference fileReferenceD3;
            Object objL;
            C20091rS7 c20091rS7;
            InterfaceC3346Am2 interfaceC3346Am2A;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            String descriptor = null;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20091rS7 c20091rS7C = this.e.C();
                if (c20091rS7C == null || (fileReferenceD3 = this.f.d3(this.e)) == null) {
                    return null;
                }
                InterfaceC12532em2 interfaceC12532em2 = this.f.j;
                long fileId = fileReferenceD3.getFileId();
                long accessHash = fileReferenceD3.getAccessHash();
                boolean zZb = C8386Vt0.a.zb();
                this.b = c20091rS7C;
                this.c = fileReferenceD3;
                this.d = 1;
                objL = interfaceC12532em2.l(fileId, accessHash, zZb, this);
                if (objL == objE) {
                    return objE;
                }
                c20091rS7 = c20091rS7C;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FileReference fileReference = (FileReference) this.c;
                c20091rS7 = (C20091rS7) this.b;
                AbstractC10685c16.b(obj);
                fileReferenceD3 = fileReference;
                objL = obj;
            }
            RY1 ry1 = (RY1) objL;
            boolean z = ry1 instanceof RY1.a;
            RY1.a aVar = z ? (RY1.a) ry1 : null;
            if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null) {
                descriptor = interfaceC3346Am2A.getDescriptor();
            }
            if (descriptor != null && !AbstractC20762sZ6.n0(descriptor)) {
                return new InterfaceC14190hV7.a(descriptor, c20091rS7.b().q());
            }
            InterfaceC14190hV7.b bVar = new InterfaceC14190hV7.b(fileReferenceD3.getFileId(), fileReferenceD3.getFileSize(), fileReferenceD3.getFileName(), fileReferenceD3.getAccessHash(), z, this.f.r.a(fileReferenceD3.getFileId(), fileReferenceD3.getAccessHash()), c20091rS7.b().q());
            C10366bX6 c10366bX6 = this.f;
            QQ6 qq6 = this.e;
            StoryRepository storyRepository = c10366bX6.c;
            String strA = bVar.a();
            AbstractC13042fc3.f(strA);
            storyRepository.m(strA, qq6.f());
            return bVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$I */
    public static final class I implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.bX6$I$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.bX6$I$a$a, reason: collision with other inner class name */
            public static final class C0910a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0910a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C10366bX6.I.a.C0910a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.bX6$I$a$a r0 = (ir.nasim.C10366bX6.I.a.C0910a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.bX6$I$a$a r0 = new ir.nasim.bX6$I$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.uZ3 r5 = (ir.nasim.InterfaceC22036uZ3) r5
                    float r5 = r5.a()
                    java.lang.Float r5 = ir.nasim.AbstractC6392Nk0.c(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.I.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public I(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bX6$J */
    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.bX6$J$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10366bX6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10366bX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.G0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, new FQ6.d(interfaceC3346Am2)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC3346Am2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.bX6$J$b */
        static final class b extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ C10366bX6 c;
            final /* synthetic */ InterfaceC20315ro1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C10366bX6 c10366bX6, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = c10366bX6;
                this.d = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c.G0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, FQ6.a.a));
                AbstractC20906so1.d(this.d, null, 1, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        J(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            J j = C10366bX6.this.new J(interfaceC20295rm1);
            j.c = obj;
            return j;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            XV4 xv4B = C10326bT2.a.b();
            if (xv4B != null) {
                C10366bX6 c10366bX6 = C10366bX6.this;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10366bX6.G0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, FQ6.b.a));
                c10366bX6.E2(c10366bX6.c3((C24890zN5) xv4B.e()), null, !C8386Vt0.a.Wa(), new a(c10366bX6, null), new b(c10366bX6, interfaceC20315ro1, null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$K */
    public static final class K implements InterfaceC10223bH7 {
        final /* synthetic */ long b;
        final /* synthetic */ C17037mH7 c;

        K(long j, C17037mH7 c17037mH7) {
            this.b = j;
            this.c = c17037mH7;
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void b() {
            C10366bX6.this.i.l0(this.b, this);
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void f(float f, int i) {
            this.c.b().c(Integer.valueOf((int) (f * 100)));
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void g(boolean z) {
            C10366bX6.this.i.l0(this.b, this);
        }
    }

    /* renamed from: ir.nasim.bX6$L */
    static final class L extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.bX6$L$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C10366bX6 a;

            /* renamed from: ir.nasim.bX6$L$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0911a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[ExPeerType.values().length];
                    try {
                        iArr[ExPeerType.PRIVATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ExPeerType.CHANNEL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ExPeerType.GROUP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ExPeerType.BOT.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            /* renamed from: ir.nasim.bX6$L$a$b */
            static final class b extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C10366bX6 c10366bX6) {
                this.a = c10366bX6;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00e1  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0138  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x0188  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.InterfaceC24244yH7 r14, ir.nasim.InterfaceC20295rm1 r15) {
                /*
                    Method dump skipped, instructions count: 412
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.L.a.a(ir.nasim.yH7, ir.nasim.rm1):java.lang.Object");
            }
        }

        L(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new L(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6J = C10366bX6.this.e.j();
                a aVar = new a(C10366bX6.this);
                this.b = 1;
                if (interfaceC10040ay6J.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((L) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$M */
    static final class M extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        M(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C10366bX6.this.l5(this);
        }
    }

    /* renamed from: ir.nasim.bX6$N */
    static final class N extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        final /* synthetic */ QQ6 e;
        final /* synthetic */ C10366bX6 f;
        final /* synthetic */ FileReference g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        N(QQ6 qq6, C10366bX6 c10366bX6, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = qq6;
            this.f = c10366bX6;
            this.g = fileReference;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strQ;
            EnumC21310tR6 enumC21310tR6B;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
            if (!this.d) {
                if (this.e.k()) {
                    this.f.y4(this.e);
                }
                C23144wQ6 c23144wQ6 = C23144wQ6.a;
                String strL = this.e.l();
                YV6 yv6 = YV6.i;
                XV6 xv6A = XV6.b.a(this.e.e());
                int iF = interfaceC3346Am2.f();
                PeersStruct$ExPeer peersStruct$ExPeerG = this.e.g();
                c23144wQ6.k(yv6, null, null, xv6A, strL, null, AbstractC6392Nk0.d(iF), peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getType() : null);
                InterfaceC19567qa2 interfaceC19567qa2 = this.f.t;
                XV4 xv4A = AbstractC4616Fw7.a("origin", AbstractC6392Nk0.d(EnumC8893Xt7.c.p()));
                XV4 xv4A2 = AbstractC4616Fw7.a("file_hash", this.f.u.a(this.g.getFileId(), this.g.getAccessHash()));
                C20091rS7 c20091rS7C = this.e.C();
                if (c20091rS7C == null || (enumC21310tR6B = c20091rS7C.b()) == null || (strQ = enumC21310tR6B.q()) == null) {
                    strQ = EnumC21310tR6.d.a(this.g.getFileName()).q();
                }
                interfaceC19567qa2.a("download_traffic", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("file_mime_type", strQ), AbstractC4616Fw7.a("file_size", AbstractC6392Nk0.d(interfaceC3346Am2.f()))));
            }
            return C19938rB7.a;
        }

        public final Object n(InterfaceC3346Am2 interfaceC3346Am2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            N n = new N(this.e, this.f, this.g, interfaceC20295rm1);
            n.c = interfaceC3346Am2;
            n.d = z;
            return n.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC3346Am2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.bX6$O */
    static final class O extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        O(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new O(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryRepository storyRepository = C10366bX6.this.c;
                String str = this.d;
                this.b = 1;
                obj = storyRepository.W(str, this);
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
            if (!(z06 instanceof Z06.b) && !(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            C10366bX6.this.p5(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((O) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$P */
    static final class P extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        P(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(String str, QQ6 qq6) {
            return AbstractC13042fc3.d(qq6.l(), str);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new P(this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0086 -> B:23:0x0089). Please report as a decompilation issue!!! */
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
                r3 = 0
                if (r1 == 0) goto L28
                if (r1 != r2) goto L20
                java.lang.Object r1 = r7.e
                ir.nasim.bX6 r1 = (ir.nasim.C10366bX6) r1
                java.lang.Object r4 = r7.d
                ir.nasim.qn4 r4 = (ir.nasim.InterfaceC19699qn4) r4
                java.lang.Object r5 = r7.c
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r6 = r7.b
                java.util.Iterator r6 = (java.util.Iterator) r6
                ir.nasim.AbstractC10685c16.b(r8)
                goto L89
            L20:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L28:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.bX6 r8 = ir.nasim.C10366bX6.this
                java.util.Map r8 = ir.nasim.C10366bX6.w1(r8)
                java.util.Set r8 = r8.entrySet()
                java.util.Iterator r8 = r8.iterator()
                r6 = r8
            L3a:
                boolean r8 = r6.hasNext()
                if (r8 == 0) goto La6
                java.lang.Object r8 = r6.next()
                r5 = r8
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                ir.nasim.bX6 r8 = ir.nasim.C10366bX6.this
                java.util.concurrent.ConcurrentHashMap r8 = ir.nasim.C10366bX6.E1(r8)
                java.lang.Object r1 = r5.getValue()
                ir.nasim.QQ6 r1 = (ir.nasim.QQ6) r1
                ir.nasim.dR6 r1 = ir.nasim.AbstractC24369yV6.c(r1)
                java.lang.Object r8 = r8.get(r1)
                ir.nasim.AbstractC13042fc3.f(r8)
                java.util.List r8 = (java.util.List) r8
                java.lang.String r1 = r7.h
                ir.nasim.iX6 r4 = new ir.nasim.iX6
                r4.<init>()
                ir.nasim.ZW0.K(r8, r4)
                boolean r8 = r8.isEmpty()
                if (r8 == 0) goto L3a
                ir.nasim.bX6 r8 = ir.nasim.C10366bX6.this
                ir.nasim.qn4 r4 = ir.nasim.C10366bX6.v1(r8)
                ir.nasim.bX6 r1 = ir.nasim.C10366bX6.this
                r7.b = r6
                r7.c = r5
                r7.d = r4
                r7.e = r1
                r7.f = r2
                java.lang.Object r8 = r4.a(r3, r7)
                if (r8 != r0) goto L89
                return r0
            L89:
                java.util.concurrent.ConcurrentHashMap r8 = ir.nasim.C10366bX6.E1(r1)     // Catch: java.lang.Throwable -> La1
                java.lang.Object r1 = r5.getValue()     // Catch: java.lang.Throwable -> La1
                ir.nasim.QQ6 r1 = (ir.nasim.QQ6) r1     // Catch: java.lang.Throwable -> La1
                ir.nasim.dR6 r1 = ir.nasim.AbstractC24369yV6.c(r1)     // Catch: java.lang.Throwable -> La1
                java.lang.Object r8 = r8.remove(r1)     // Catch: java.lang.Throwable -> La1
                java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> La1
                r4.e(r3)
                goto L3a
            La1:
                r8 = move-exception
                r4.e(r3)
                throw r8
            La6:
                ir.nasim.bX6 r8 = ir.nasim.C10366bX6.this
                ir.nasim.C10366bX6.p2(r8)
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.P.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((P) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$Q */
    static final class Q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        Object c;
        int d;
        final /* synthetic */ QQ6 f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Q(QQ6 qq6, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = qq6;
            this.g = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new Q(this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            int i;
            C17428mw7 c17428mw7;
            int i2;
            Object objE = AbstractC14862ic3.e();
            int i3 = this.d;
            if (i3 == 0) {
                AbstractC10685c16.b(obj);
                ArrayList arrayList = C10366bX6.this.B0;
                long j = this.g;
                Iterator it = arrayList.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (((QQ6) ((C17428mw7) it.next()).f()).i() == j) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i >= 0) {
                    Object obj2 = C10366bX6.this.B0.get(i);
                    AbstractC13042fc3.h(obj2, "get(...)");
                    c17428mw7 = (C17428mw7) obj2;
                    C10366bX6 c10366bX6 = C10366bX6.this;
                    QQ6 qq6 = this.f;
                    QQ6 qq62 = (QQ6) c17428mw7.f();
                    this.c = c17428mw7;
                    this.b = i;
                    this.d = 1;
                    if (c10366bX6.s5(qq6, qq62, this) == objE) {
                        return objE;
                    }
                    i2 = i;
                }
                return C19938rB7.a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.b;
            c17428mw7 = (C17428mw7) this.c;
            AbstractC10685c16.b(obj);
            C10366bX6.this.B0.set(i2, C17428mw7.e(c17428mw7, this.f, null, null, 6, null));
            C10366bX6.this.m6();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$R */
    static final class R extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ OP5 f;

        /* renamed from: ir.nasim.bX6$R$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10366bX6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10366bX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((C9475a16) obj).l(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Object objL = ((C9475a16) this.c).l();
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.E0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C9475a16.j(objL) ? AbstractC14180hU6.b.a : AbstractC14180hU6.a.a));
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(C9475a16.a(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        R(String str, String str2, OP5 op5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
            this.f = op5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new R(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = C10366bX6.this.b.a(this.d, this.e, this.f);
                a aVar = new a(C10366bX6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, aVar, this) == objE) {
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
            return ((R) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$S */
    static final class S extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        S(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C10366bX6.this.A5(null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.bX6$T */
    static final class T extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        T(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C10366bX6.this.B5(null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.bX6$U */
    static final class U extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        long d;
        /* synthetic */ Object e;
        int g;

        U(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C10366bX6.this.C5(null, null, 0L, this);
        }
    }

    /* renamed from: ir.nasim.bX6$V */
    static final class V extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        V(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new V(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C10366bX6.this.z;
                String str = this.d;
                this.b = 1;
                if (interfaceC8327Vm4.a(str, this) == objE) {
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
            return ((V) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$W */
    static final class W extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ZI7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        W(ZI7 zi7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = zi7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new W(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfigY3 = C10366bX6.this.y3(this.d);
                StoryRepository storyRepository = C10366bX6.this.c;
                this.b = 1;
                obj = storyRepository.e0(storyStruct$UserPrivacyConfigY3, this);
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
                C10366bX6.this.J4();
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((W) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$X */
    static final class X extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11692dR6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        X(C11692dR6 c11692dR6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11692dR6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new X(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            QQ6 qq6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = (List) C10366bX6.this.A0.get(this.d);
                if (list == null || (qq6 = (QQ6) AbstractC15401jX0.F0(list)) == null) {
                    return C19938rB7.a;
                }
                if (!AbstractC13042fc3.d(qq6.s(), AbstractC11710dT6.a.a)) {
                    return C19938rB7.a;
                }
                qq6.K(AbstractC11710dT6.c.a);
                C10366bX6.this.m6();
                StoryRepository storyRepository = C10366bX6.this.c;
                ConcurrentHashMap concurrentHashMap = C10366bX6.this.A0;
                this.b = 1;
                if (storyRepository.j0(concurrentHashMap, this) == objE) {
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
            return ((X) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$Y */
    public static final class Y implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((QQ6) obj).f()), Long.valueOf(((QQ6) obj2).f()));
        }
    }

    /* renamed from: ir.nasim.bX6$Z */
    static final class Z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.bX6$Z$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((C12335eR6) obj2).a().f()), Long.valueOf(((C12335eR6) obj).a().f()));
            }
        }

        /* renamed from: ir.nasim.bX6$Z$b */
        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((C12335eR6) obj2).a().f()), Long.valueOf(((C12335eR6) obj).a().f()));
            }
        }

        /* renamed from: ir.nasim.bX6$Z$c */
        public static final class c implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((C12335eR6) obj2).a().f()), Long.valueOf(((C12335eR6) obj).a().f()));
            }
        }

        Z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new Z(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }
            AbstractC10685c16.b(obj);
            if (C8386Vt0.a.ab()) {
                InterfaceC13730gj3 interfaceC13730gj3N6 = C10366bX6.this.n6();
                this.b = 1;
                if (interfaceC13730gj3N6.k0(this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            C10366bX6.this.p1.clear();
            C10366bX6.this.e6();
            C10366bX6 c10366bX6 = C10366bX6.this;
            c10366bX6.A2(c10366bX6.A0);
            C10366bX6 c10366bX62 = C10366bX6.this;
            c10366bX62.w2(c10366bX62.A0);
            C12335eR6 c12335eR6 = null;
            for (Map.Entry entry : C10366bX6.this.A0.entrySet()) {
                if (((C11692dR6) entry.getKey()).c() == EnumC23779xV6.e) {
                    if (!AbstractC13042fc3.d(((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).s(), AbstractC11710dT6.a.a)) {
                        AbstractC6392Nk0.a(arrayList3.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()))));
                    } else if (C8386Vt0.a.e6()) {
                        arrayList2.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue())));
                    } else if (AbstractC10360bX0.p(AbstractC6392Nk0.d(178536948), AbstractC6392Nk0.d(645784619)).contains(AbstractC6392Nk0.d(((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).p()))) {
                        arrayList4.add(0, new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue())));
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } else {
                        AbstractC6392Nk0.a(arrayList4.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()))));
                    }
                } else if (((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).p() == C10366bX6.this.W3() && !((C11692dR6) entry.getKey()).f()) {
                    concurrentHashMap.put(entry.getKey(), AbstractC15401jX0.C0((List) entry.getValue()));
                    C19938rB7 c19938rB72 = C19938rB7.a;
                } else if (((C11692dR6) entry.getKey()).a() == C10366bX6.this.W3()) {
                    c12335eR6 = new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()));
                    C19938rB7 c19938rB73 = C19938rB7.a;
                } else if (((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).p() == C10366bX6.this.W3() && ((C11692dR6) entry.getKey()).d()) {
                    concurrentHashMap2.put(entry.getKey(), AbstractC15401jX0.C0((List) entry.getValue()));
                    C19938rB7 c19938rB74 = C19938rB7.a;
                } else if (C10366bX6.this.I3().contains(((C11692dR6) entry.getKey()).toString()) && AbstractC13042fc3.d(((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).s(), AbstractC11710dT6.a.a)) {
                    AbstractC6392Nk0.a(arrayList.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()))));
                } else if (AbstractC13042fc3.d(((QQ6) AbstractC15401jX0.C0((List) entry.getValue())).s(), AbstractC11710dT6.a.a)) {
                    AbstractC6392Nk0.a(arrayList2.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()))));
                } else {
                    AbstractC6392Nk0.a(arrayList3.add(new C12335eR6((C11692dR6) entry.getKey(), (QQ6) AbstractC15401jX0.C0((List) entry.getValue()))));
                }
            }
            if (arrayList.size() > 1) {
                AbstractC12992fX0.B(arrayList, new a());
            }
            if (arrayList2.size() > 1) {
                AbstractC12992fX0.B(arrayList2, new b());
            }
            if (arrayList3.size() > 1) {
                AbstractC12992fX0.B(arrayList3, new c());
            }
            if (c12335eR6 != null) {
            }
            C10366bX6 c10366bX63 = C10366bX6.this;
            for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                c10366bX63.p1.put(entry2.getKey(), entry2.getValue());
            }
            C10366bX6 c10366bX64 = C10366bX6.this;
            for (Map.Entry entry3 : concurrentHashMap2.entrySet()) {
                c10366bX64.p1.put(entry3.getKey(), entry3.getValue());
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10366bX6.this.B;
            C12335eR6.a aVar = C12335eR6.c;
            AbstractC23640xG2.b bVar = new AbstractC23640xG2.b(new C18502om(c12335eR6, aVar.a(concurrentHashMap), aVar.a(concurrentHashMap2), AbstractC15401jX0.R0(AbstractC15401jX0.R0(arrayList, arrayList4), arrayList2), arrayList3));
            this.b = 2;
            if (interfaceC9336Zm4.a(bVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$a, reason: case insensitive filesystem */
    static final class C10367a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.bX6$a$a, reason: collision with other inner class name */
        static final class C0912a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C10366bX6 c;

            /* renamed from: ir.nasim.bX6$a$a$a, reason: collision with other inner class name */
            static final class C0913a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C10366bX6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0913a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c10366bX6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0913a c0913a = new C0913a(this.d, interfaceC20295rm1);
                    c0913a.c = obj;
                    return c0913a;
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x00c6 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                    /*
                        r7 = this;
                        java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                        int r1 = r7.b
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L2c
                        if (r1 == r4) goto L27
                        if (r1 == r3) goto L22
                        if (r1 != r2) goto L1a
                        java.lang.Object r0 = r7.c
                        java.util.List r0 = (java.util.List) r0
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto Lc9
                    L1a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r0)
                        throw r8
                    L22:
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto Lb4
                    L27:
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto Lce
                    L2c:
                        ir.nasim.AbstractC10685c16.b(r8)
                        java.lang.Object r8 = r7.c
                        ir.nasim.xG2 r8 = (ir.nasim.AbstractC23640xG2) r8
                        r1 = 0
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.String r5 = "story"
                        java.lang.String r6 = "G S R C VM"
                        ir.nasim.C19406qI3.a(r5, r6, r1)
                        boolean r1 = r8 instanceof ir.nasim.AbstractC23640xG2.a
                        if (r1 == 0) goto L5b
                        ir.nasim.bX6 r1 = r7.d
                        ir.nasim.Zm4 r1 = ir.nasim.C10366bX6.P1(r1)
                        ir.nasim.xG2$a r2 = new ir.nasim.xG2$a
                        ir.nasim.xG2$a r8 = (ir.nasim.AbstractC23640xG2.a) r8
                        java.lang.Exception r8 = r8.a()
                        r2.<init>(r8)
                        r7.b = r4
                        java.lang.Object r8 = r1.a(r2, r7)
                        if (r8 != r0) goto Lce
                        return r0
                    L5b:
                        boolean r1 = r8 instanceof ir.nasim.AbstractC23640xG2.b
                        if (r1 == 0) goto Lce
                        ir.nasim.bX6 r1 = r7.d
                        ir.nasim.xG2$b r8 = (ir.nasim.AbstractC23640xG2.b) r8
                        java.lang.Object r8 = r8.a()
                        java.util.Map r8 = (java.util.Map) r8
                        java.util.Set r8 = r8.entrySet()
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.concurrent.ConcurrentHashMap r4 = new java.util.concurrent.ConcurrentHashMap
                        r4.<init>()
                        java.util.Iterator r8 = r8.iterator()
                    L78:
                        boolean r5 = r8.hasNext()
                        if (r5 == 0) goto La2
                        java.lang.Object r5 = r8.next()
                        java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                        java.lang.Object r6 = r5.getKey()
                        java.lang.Object r5 = r5.getValue()
                        java.util.Collection r5 = (java.util.Collection) r5
                        java.util.List r5 = ir.nasim.ZW0.p1(r5)
                        ir.nasim.XV4 r5 = ir.nasim.AbstractC4616Fw7.a(r6, r5)
                        java.lang.Object r6 = r5.e()
                        java.lang.Object r5 = r5.f()
                        r4.put(r6, r5)
                        goto L78
                    La2:
                        ir.nasim.C10366bX6.n2(r1, r4)
                        ir.nasim.bX6 r8 = r7.d
                        ir.nasim.gj3 r8 = ir.nasim.C10366bX6.p2(r8)
                        r7.b = r3
                        java.lang.Object r8 = r8.k0(r7)
                        if (r8 != r0) goto Lb4
                        return r0
                    Lb4:
                        ir.nasim.bX6 r8 = r7.d
                        java.util.List r8 = ir.nasim.C10366bX6.K1(r8)
                        ir.nasim.bX6 r1 = r7.d
                        r7.c = r8
                        r7.b = r2
                        java.lang.Object r1 = ir.nasim.C10366bX6.f2(r1, r7)
                        if (r1 != r0) goto Lc7
                        return r0
                    Lc7:
                        r0 = r8
                        r8 = r1
                    Lc9:
                        java.util.Collection r8 = (java.util.Collection) r8
                        r0.addAll(r8)
                    Lce:
                        ir.nasim.bX6 r8 = r7.d
                        ir.nasim.story.repository.StoryRepository r8 = ir.nasim.C10366bX6.I1(r8)
                        r8.X()
                        ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10367a.C0912a.C0913a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC23640xG2 abstractC23640xG2, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0913a) create(abstractC23640xG2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0912a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c10366bX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0912a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(this.c.c.B());
                    C0913a c0913a = new C0913a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c0913a, this) == objE) {
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
                return ((C0912a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.bX6$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C10366bX6 c;

            /* renamed from: ir.nasim.bX6$a$b$a, reason: collision with other inner class name */
            static final class C0914a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C10366bX6 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0914a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c10366bX6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0914a c0914a = new C0914a(this.d, interfaceC20295rm1);
                    c0914a.c = obj;
                    return c0914a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC23640xG2 abstractC23640xG2 = (AbstractC23640xG2) this.c;
                    this.d.A = abstractC23640xG2 instanceof AbstractC23640xG2.b ? (C18502om) ((AbstractC23640xG2.b) abstractC23640xG2).a() : null;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC23640xG2 abstractC23640xG2, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0914a) create(abstractC23640xG2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c10366bX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(this.c.H3());
                    C0914a c0914a = new C0914a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c0914a, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C10367a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C10367a c10367a = C10366bX6.this.new C10367a(interfaceC20295rm1);
            c10367a.c = obj;
            return c10367a;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0912a(C10366bX6.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C10366bX6.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10367a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$a0 */
    static final class a0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int D(C11692dR6 c11692dR6, C11692dR6 c11692dR62) {
            return (c11692dR6.b() == null || c11692dR62.b() == null || c11692dR6.b().floatValue() >= c11692dR62.b().floatValue()) ? -1 : 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int z(C11692dR6 c11692dR6, C11692dR6 c11692dR62) {
            return (c11692dR6.b() == null || c11692dR62.b() == null || c11692dR6.b().floatValue() >= c11692dR62.b().floatValue()) ? -1 : 1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new a0(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C12335eR6 c12335eR6;
            C12335eR6.a aVar;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12889fL5 c12889fL5 = new C12889fL5();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            C10366bX6.this.p1.clear();
            C10366bX6.this.e6();
            C10366bX6 c10366bX6 = C10366bX6.this;
            c10366bX6.A2(c10366bX6.A0);
            C10366bX6 c10366bX62 = C10366bX6.this;
            c10366bX62.w2(c10366bX62.A0);
            for (Map.Entry entry : C10366bX6.this.A0.entrySet()) {
                C11692dR6 c11692dR6 = (C11692dR6) entry.getKey();
                List list = (List) entry.getValue();
                if (list.isEmpty()) {
                    return C19938rB7.a;
                }
                if (c11692dR6.c() == EnumC23779xV6.e) {
                    if (AbstractC13042fc3.d(((QQ6) AbstractC15401jX0.C0(list)).s(), AbstractC11710dT6.a.a)) {
                        linkedHashMap3.put(c11692dR6, AbstractC15401jX0.C0(list));
                    } else {
                        linkedHashMap4.put(c11692dR6, AbstractC15401jX0.C0(list));
                    }
                } else if (((QQ6) AbstractC15401jX0.C0(list)).p() == C10366bX6.this.W3() && !c11692dR6.f()) {
                    linkedHashMap.put(c11692dR6, AbstractC15401jX0.C0(list));
                } else if (c11692dR6.a() == C10366bX6.this.W3()) {
                    c12889fL5.a = new C12335eR6(c11692dR6, (QQ6) AbstractC15401jX0.C0(list));
                } else if (((QQ6) AbstractC15401jX0.C0(list)).p() == C10366bX6.this.W3() && c11692dR6.d()) {
                    linkedHashMap2.put(c11692dR6, AbstractC15401jX0.C0(list));
                } else {
                    AbstractC11710dT6 abstractC11710dT6S = ((QQ6) AbstractC15401jX0.C0(list)).s();
                    AbstractC11710dT6.a aVar2 = AbstractC11710dT6.a.a;
                    if (AbstractC13042fc3.d(abstractC11710dT6S, aVar2)) {
                        linkedHashMap3.put(c11692dR6, AbstractC15401jX0.C0(list));
                    } else if (AbstractC13042fc3.d(((QQ6) AbstractC15401jX0.C0(list)).s(), aVar2)) {
                        linkedHashMap3.put(c11692dR6, AbstractC15401jX0.C0(list));
                    } else {
                        linkedHashMap4.put(c11692dR6, AbstractC15401jX0.C0(list));
                    }
                }
            }
            SortedMap sortedMapJ = AbstractC19460qO3.j(linkedHashMap3, new Comparator() { // from class: ir.nasim.jX6
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return C10366bX6.a0.z((C11692dR6) obj2, (C11692dR6) obj3);
                }
            });
            SortedMap sortedMapJ2 = AbstractC19460qO3.j(linkedHashMap4, new Comparator() { // from class: ir.nasim.kX6
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return C10366bX6.a0.D((C11692dR6) obj2, (C11692dR6) obj3);
                }
            });
            C12335eR6 c12335eR62 = (C12335eR6) c12889fL5.a;
            if (c12335eR62 != null) {
            }
            C10366bX6 c10366bX63 = C10366bX6.this;
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                c10366bX63.p1.put(entry2.getKey(), entry2.getValue());
            }
            C10366bX6 c10366bX64 = C10366bX6.this;
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                c10366bX64.p1.put(entry3.getKey(), entry3.getValue());
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10366bX6.this.B;
            do {
                value = interfaceC9336Zm4.getValue();
                c12335eR6 = (C12335eR6) c12889fL5.a;
                aVar = C12335eR6.c;
            } while (!interfaceC9336Zm4.f(value, new AbstractC23640xG2.b(new C18502om(c12335eR6, aVar.a(linkedHashMap), aVar.a(linkedHashMap2), aVar.a(sortedMapJ), aVar.a(sortedMapJ2)))));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$b, reason: case insensitive filesystem */
    public static final class C10368b {
        private C10368b() {
        }

        public /* synthetic */ C10368b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bX6$b0 */
    static final class b0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ YK6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(long j, YK6 yk6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = yk6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new b0(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QQ6 qq6N4 = C10366bX6.this.n4(this.d);
                if (qq6N4 != null) {
                    InterfaceC13730gj3 interfaceC13730gj3Q5 = C10366bX6.this.q5(qq6N4.i(), qq6N4.b((1048575 & 1) != 0 ? qq6N4.a : 0L, (1048575 & 2) != 0 ? qq6N4.b : null, (1048575 & 4) != 0 ? qq6N4.c : null, (1048575 & 8) != 0 ? qq6N4.d : null, (1048575 & 16) != 0 ? qq6N4.e : 0L, (1048575 & 32) != 0 ? qq6N4.f : 0, (1048575 & 64) != 0 ? qq6N4.g : null, (1048575 & 128) != 0 ? qq6N4.h : null, (1048575 & 256) != 0 ? qq6N4.i : this.e, (1048575 & 512) != 0 ? qq6N4.j : null, (1048575 & 1024) != 0 ? qq6N4.k : null, (1048575 & 2048) != 0 ? qq6N4.l : false, (1048575 & 4096) != 0 ? qq6N4.m : null, (1048575 & 8192) != 0 ? qq6N4.n : null, (1048575 & 16384) != 0 ? qq6N4.o : false, (1048575 & 32768) != 0 ? qq6N4.p : null, (1048575 & 65536) != 0 ? qq6N4.q : false, (1048575 & 131072) != 0 ? qq6N4.r : null, (1048575 & 262144) != 0 ? qq6N4.s : null, (1048575 & 524288) != 0 ? qq6N4.t : null));
                    this.b = 1;
                    if (interfaceC13730gj3Q5.k0(this) == objE) {
                        return objE;
                    }
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
            return ((b0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$c, reason: case insensitive filesystem */
    public /* synthetic */ class C10369c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;

        static {
            int[] iArr = new int[EnumC21337tU6.values().length];
            try {
                iArr[EnumC21337tU6.ExceptionType_Contact.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21337tU6.ExceptionType_Exclude.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21337tU6.ExceptionType_Include.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC5052Hr5.values().length];
            try {
                iArr2[EnumC5052Hr5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC5052Hr5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC5052Hr5.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
            int[] iArr3 = new int[X9.values().length];
            try {
                iArr3[X9.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[X9.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[X9.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            c = iArr3;
            int[] iArr4 = new int[FP6.values().length];
            try {
                iArr4[FP6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[FP6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[FP6.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[FP6.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            d = iArr4;
            int[] iArr5 = new int[EnumC23779xV6.values().length];
            try {
                iArr5[EnumC23779xV6.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[EnumC23779xV6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[EnumC23779xV6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr5[EnumC23779xV6.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr5[EnumC23779xV6.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[EnumC23779xV6.a.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            e = iArr5;
            int[] iArr6 = new int[EnumC10088b35.values().length];
            try {
                iArr6[EnumC10088b35.ExPeerType_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_SUPERGROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr6[EnumC10088b35.ExPeerType_THREAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr6[EnumC10088b35.UNRECOGNIZED.ordinal()] = 8;
            } catch (NoSuchFieldError unused27) {
            }
            f = iArr6;
        }
    }

    /* renamed from: ir.nasim.bX6$c0 */
    static final class c0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new c0(this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            QQ6 qq6N4;
            ir.nasim.tgwidgets.editor.messenger.H h;
            InterfaceC10294bP6 interfaceC10294bP6B;
            ExPeer exPeer;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                qq6N4 = C10366bX6.this.n4(this.f);
                if (qq6N4 == null) {
                    return C19938rB7.a;
                }
                ir.nasim.tgwidgets.editor.messenger.H hV4 = C10366bX6.this.v4(this.f);
                if (hV4 == null) {
                    return C19938rB7.a;
                }
                C22548vQ6 c22548vQ6M4 = C10366bX6.this.m4();
                if (c22548vQ6M4 != null && (interfaceC10294bP6B = c22548vQ6M4.b()) != null) {
                    C10366bX6 c10366bX6 = C10366bX6.this;
                    if (interfaceC10294bP6B.i()) {
                        c10366bX6.H5(new InterfaceC10294bP6.i(interfaceC10294bP6B.e()));
                    } else {
                        c10366bX6.H5(new InterfaceC10294bP6.n(interfaceC10294bP6B.e()));
                    }
                }
                InterfaceC13730gj3 interfaceC13730gj3Q5 = C10366bX6.this.q5(this.f, qq6N4.b((1048575 & 1) != 0 ? qq6N4.a : 0L, (1048575 & 2) != 0 ? qq6N4.b : null, (1048575 & 4) != 0 ? qq6N4.c : null, (1048575 & 8) != 0 ? qq6N4.d : null, (1048575 & 16) != 0 ? qq6N4.e : 0L, (1048575 & 32) != 0 ? qq6N4.f : 0, (1048575 & 64) != 0 ? qq6N4.g : null, (1048575 & 128) != 0 ? qq6N4.h : null, (1048575 & 256) != 0 ? qq6N4.i : YK6.a, (1048575 & 512) != 0 ? qq6N4.j : null, (1048575 & 1024) != 0 ? qq6N4.k : null, (1048575 & 2048) != 0 ? qq6N4.l : false, (1048575 & 4096) != 0 ? qq6N4.m : null, (1048575 & 8192) != 0 ? qq6N4.n : null, (1048575 & 16384) != 0 ? qq6N4.o : false, (1048575 & 32768) != 0 ? qq6N4.p : null, (1048575 & 65536) != 0 ? qq6N4.q : false, (1048575 & 131072) != 0 ? qq6N4.r : null, (1048575 & 262144) != 0 ? qq6N4.s : null, (1048575 & 524288) != 0 ? qq6N4.t : null));
                this.b = qq6N4;
                this.c = hV4;
                this.d = 1;
                if (interfaceC13730gj3Q5.k0(this) == objE) {
                    return objE;
                }
                h = hV4;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h = (ir.nasim.tgwidgets.editor.messenger.H) this.c;
                qq6N4 = (QQ6) this.b;
                AbstractC10685c16.b(obj);
            }
            C19406qI3.a("story", "uploadVideoStory rid=" + this.f, new Object[0]);
            C10366bX6 c10366bX62 = C10366bX6.this;
            long j = Long.parseLong(qq6N4.l());
            C10366bX6 c10366bX63 = C10366bX6.this;
            PeersStruct$ExPeer peersStruct$ExPeerG = qq6N4.g();
            if (peersStruct$ExPeerG != null) {
                EnumC10088b35 type = peersStruct$ExPeerG.getType();
                AbstractC13042fc3.h(type, "getType(...)");
                exPeer = new ExPeer(c10366bX63.h5(type), peersStruct$ExPeerG.getId());
            } else {
                exPeer = new ExPeer(ExPeerType.PRIVATE, qq6N4.p());
            }
            String strR = qq6N4.r();
            AbstractC13042fc3.f(strR);
            c10366bX62.r6(j, exPeer, strR, EnumC21310tR6.e, h.a());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c0) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$d, reason: case insensitive filesystem */
    static final class C10370d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ String e;
        final /* synthetic */ C20091rS7 f;
        final /* synthetic */ AbstractC2383g g;
        final /* synthetic */ List h;
        final /* synthetic */ C14189hV6 i;
        final /* synthetic */ PeersStruct$ExPeer j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10370d(FileReference fileReference, String str, C20091rS7 c20091rS7, AbstractC2383g abstractC2383g, List list, C14189hV6 c14189hV6, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = str;
            this.f = c20091rS7;
            this.g = abstractC2383g;
            this.h = list;
            this.i = c14189hV6;
            this.j = peersStruct$ExPeer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10370d(this.d, this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryRepository storyRepository = C10366bX6.this.c;
                StoryStruct$MediaStory storyStruct$MediaStoryH3 = C10366bX6.this.h3(this.d, this.e, this.f, this.g, this.h);
                C14189hV6 c14189hV6 = this.i;
                PeersStruct$ExPeer peersStruct$ExPeer = this.j;
                this.b = 1;
                obj = storyRepository.l(storyStruct$MediaStoryH3, c14189hV6, peersStruct$ExPeer, this);
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
            return ((C10370d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$d0 */
    static final class d0 extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.bX6$d0$a */
        /* synthetic */ class a implements InterfaceC4806Gq2, InterfaceC22409vB2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            @Override // ir.nasim.InterfaceC22409vB2
            public final InterfaceC18751pB2 b() {
                return new EB2(2, this.a, InterfaceC4806Gq2.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC10891cN5 interfaceC10891cN5, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objA = this.a.a(interfaceC10891cN5, interfaceC20295rm1);
                return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof InterfaceC4806Gq2) && (obj instanceof InterfaceC22409vB2)) {
                    return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
                }
                return false;
            }

            public final int hashCode() {
                return b().hashCode();
            }
        }

        d0(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d0 d0Var = C10366bX6.this.new d0(interfaceC20295rm1);
            d0Var.c = obj;
            return d0Var;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC10258bL6 interfaceC10258bL6O = C10366bX6.this.c.O();
                a aVar = new a(interfaceC4806Gq2);
                this.b = 1;
                if (interfaceC10258bL6O.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d0) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$e, reason: case insensitive filesystem */
    static final class C10371e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ String e;
        final /* synthetic */ C20091rS7 f;
        final /* synthetic */ AbstractC2383g g;
        final /* synthetic */ List h;
        final /* synthetic */ C14189hV6 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10371e(FileReference fileReference, String str, C20091rS7 c20091rS7, AbstractC2383g abstractC2383g, List list, C14189hV6 c14189hV6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = str;
            this.f = c20091rS7;
            this.g = abstractC2383g;
            this.h = list;
            this.i = c14189hV6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10371e(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryRepository storyRepository = C10366bX6.this.c;
                StoryStruct$MediaStory storyStruct$MediaStoryH3 = C10366bX6.this.h3(this.d, this.e, this.f, this.g, this.h);
                C14189hV6 c14189hV6 = this.i;
                this.b = 1;
                obj = storyRepository.r(storyStruct$MediaStoryH3, c14189hV6, this);
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
            return ((C10371e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$f, reason: case insensitive filesystem */
    static final class C10372f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ FileReference g;
        final /* synthetic */ String h;
        final /* synthetic */ C20091rS7 i;
        final /* synthetic */ C14189hV6 j;
        final /* synthetic */ List k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10372f(long j, String str, FileReference fileReference, String str2, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
            this.f = str;
            this.g = fileReference;
            this.h = str2;
            this.i = c20091rS7;
            this.j = c14189hV6;
            this.k = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10372f(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x011e A[SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 311
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10372f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10372f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$g, reason: case insensitive filesystem */
    static final class C10373g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        long e;
        int f;
        final /* synthetic */ String h;
        final /* synthetic */ PeersStruct$ExPeer i;
        final /* synthetic */ long j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10373g(String str, PeersStruct$ExPeer peersStruct$ExPeer, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = str;
            this.i = peersStruct$ExPeer;
            this.j = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(long j, QQ6 qq6) {
            return AbstractC13042fc3.d(qq6.l(), String.valueOf(j));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10373g(this.h, this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0106 A[Catch: all -> 0x011f, TryCatch #0 {all -> 0x011f, blocks: (B:32:0x00e2, B:34:0x0106, B:36:0x0112, B:39:0x0121, B:41:0x0134, B:42:0x013b), top: B:50:0x00e2 }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10373g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10373g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$h, reason: case insensitive filesystem */
    static final class C10374h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C10374h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C10374h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10374h) create(interfaceC3346Am2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$i, reason: case insensitive filesystem */
    static final class C10375i extends AbstractC19859r37 implements UA2 {
        int b;

        C10375i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new C10375i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10375i) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$j, reason: case insensitive filesystem */
    static final class C10376j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ HS7 d;
        final /* synthetic */ C10366bX6 e;
        final /* synthetic */ FileReference f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ UA2 i;

        /* renamed from: ir.nasim.bX6$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ String d;
            final /* synthetic */ InterfaceC14603iB2 e;
            final /* synthetic */ InterfaceC20315ro1 f;
            final /* synthetic */ FileReference g;
            final /* synthetic */ C11637dL5 h;
            final /* synthetic */ C10366bX6 i;
            final /* synthetic */ boolean j;
            final /* synthetic */ boolean k;
            final /* synthetic */ UA2 l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20315ro1 interfaceC20315ro1, FileReference fileReference, C11637dL5 c11637dL5, C10366bX6 c10366bX6, boolean z, boolean z2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = str;
                this.e = interfaceC14603iB2;
                this.f = interfaceC20315ro1;
                this.g = fileReference;
                this.h = c11637dL5;
                this.i = c10366bX6;
                this.j = z;
                this.k = z2;
                this.l = ua2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x00d9 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    Method dump skipped, instructions count: 261
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10376j.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10376j(HS7 hs7, C10366bX6 c10366bX6, FileReference fileReference, InterfaceC14603iB2 interfaceC14603iB2, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = hs7;
            this.e = c10366bX6;
            this.f = fileReference;
            this.g = interfaceC14603iB2;
            this.h = z;
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C10376j c10376j = new C10376j(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
            c10376j.c = obj;
            return c10376j;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                boolean z = this.d != null && C8386Vt0.a.zb();
                String strA = this.e.q.a(this.f.getFileId(), this.f.getAccessHash());
                if (z) {
                    StoryRepository storyRepository = this.e.c;
                    HS7 hs7 = this.d;
                    AbstractC13042fc3.f(hs7);
                    storyRepository.m(strA, hs7.a());
                }
                C11637dL5 c11637dL5 = new C11637dL5();
                InterfaceC4557Fq2 interfaceC4557Fq2G = this.e.j.g(this.f, z);
                a aVar = new a(strA, this.g, interfaceC20315ro1, this.f, c11637dL5, this.e, z, this.h, this.i, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2G, aVar, this) == objE) {
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
            return ((C10376j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$k, reason: case insensitive filesystem */
    static final class C10377k extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        final /* synthetic */ QQ6 e;
        final /* synthetic */ FileReference f;
        final /* synthetic */ C10366bX6 g;
        final /* synthetic */ InterfaceC14603iB2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10377k(QQ6 qq6, FileReference fileReference, C10366bX6 c10366bX6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = qq6;
            this.f = fileReference;
            this.g = c10366bX6;
            this.h = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strQ;
            EnumC21310tR6 enumC21310tR6B;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
            boolean z = this.d;
            if (!z) {
                C23144wQ6 c23144wQ6 = C23144wQ6.a;
                String strL = this.e.l();
                YV6 yv6 = YV6.j;
                XV6 xv6A = XV6.b.a(this.e.e());
                int fileSize = this.f.getFileSize();
                PeersStruct$ExPeer peersStruct$ExPeerG = this.e.g();
                c23144wQ6.k(yv6, null, null, xv6A, strL, null, AbstractC6392Nk0.d(fileSize), peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getType() : null);
                InterfaceC19567qa2 interfaceC19567qa2 = this.g.t;
                XV4 xv4A = AbstractC4616Fw7.a("origin", AbstractC6392Nk0.d(EnumC8893Xt7.c.p()));
                XV4 xv4A2 = AbstractC4616Fw7.a("file_hash", this.g.u.a(this.f.getFileId(), this.f.getAccessHash()));
                C20091rS7 c20091rS7C = this.e.C();
                if (c20091rS7C == null || (enumC21310tR6B = c20091rS7C.b()) == null || (strQ = enumC21310tR6B.q()) == null) {
                    strQ = EnumC21310tR6.d.a(this.f.getFileName()).q();
                }
                interfaceC19567qa2.a("download_traffic", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("file_mime_type", strQ), AbstractC4616Fw7.a("file_size", AbstractC6392Nk0.d(this.f.getFileSize()))));
            }
            InterfaceC14603iB2 interfaceC14603iB2 = this.h;
            if (interfaceC14603iB2 != null) {
                interfaceC14603iB2.invoke(interfaceC3346Am2, AbstractC6392Nk0.a(z));
            }
            return C19938rB7.a;
        }

        public final Object n(InterfaceC3346Am2 interfaceC3346Am2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            C10377k c10377k = new C10377k(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            c10377k.c = interfaceC3346Am2;
            c10377k.d = z;
            return c10377k.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC3346Am2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.bX6$l, reason: case insensitive filesystem */
    /* synthetic */ class C10378l extends EB2 implements UA2 {
        C10378l(Object obj) {
            super(1, obj, AbstractC13042fc3.a.class, "suspendConversion0", "bindIfNotDownloaded$lambda$14$suspendConversion0(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.L2((SA2) this.receiver, interfaceC20295rm1);
        }
    }

    /* renamed from: ir.nasim.bX6$m, reason: case insensitive filesystem */
    static final class C10379m extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        boolean f;
        boolean g;
        /* synthetic */ Object h;
        int j;

        C10379m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return C10366bX6.this.H2(null, null, false, null, null, false, this);
        }
    }

    /* renamed from: ir.nasim.bX6$n, reason: case insensitive filesystem */
    static final class C10380n extends AbstractC19859r37 implements UA2 {
        int b;

        C10380n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new C10380n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10380n) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$o, reason: case insensitive filesystem */
    static final class C10381o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ InterfaceC15796kB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10381o(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C10381o c10381o = new C10381o(this.d, interfaceC20295rm1);
            c10381o.c = obj;
            return c10381o;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
                InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                if (interfaceC15796kB2 != null) {
                    Boolean boolA = AbstractC6392Nk0.a(false);
                    this.b = 1;
                    if (interfaceC15796kB2.q(interfaceC3346Am2, boolA, this) == objE) {
                        return objE;
                    }
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
        public final Object invoke(InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10381o) create(interfaceC3346Am2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$p, reason: case insensitive filesystem */
    static final class C10382p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ StoryWidget.LinkWidget d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10382p(StoryWidget.LinkWidget linkWidget, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = linkWidget;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10382p(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5409Jf2 interfaceC5409Jf2 = C10366bX6.this.v;
                String strA = this.d.a();
                this.b = 1;
                objA = interfaceC5409Jf2.a(strA, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objA)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C10366bX6.this.V0;
                String strA2 = this.d.a();
                EnumC4458Ff2 enumC4458Ff2 = EnumC4458Ff2.c;
                if (C9475a16.g(objA)) {
                    objA = enumC4458Ff2;
                }
                interfaceC9336Zm4.setValue(new LA3.b(strA2, (EnumC4458Ff2) objA));
            } else {
                C10366bX6.this.V0.setValue(new LA3.a(this.d.a()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10382p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$q, reason: case insensitive filesystem */
    static final class C10383q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.bX6$q$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC20315ro1 a;
            final /* synthetic */ C10366bX6 b;

            a(InterfaceC20315ro1 interfaceC20315ro1, C10366bX6 c10366bX6) {
                this.a = interfaceC20315ro1;
                this.b = c10366bX6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                if (list != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : list) {
                        String strB = ((JX6) obj).b();
                        Object arrayList = linkedHashMap.get(strB);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            linkedHashMap.put(strB, arrayList);
                        }
                        ((List) arrayList).add(obj);
                    }
                    C10366bX6 c10366bX6 = this.b;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        List list2 = (List) entry.getValue();
                        Iterator it = c10366bX6.A0.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                qq6 = null;
                                break;
                            }
                            for (QQ6 qq6 : (Iterable) ((Map.Entry) it.next()).getValue()) {
                                if (AbstractC13042fc3.d(qq6.l(), str)) {
                                    break;
                                }
                            }
                        }
                        if (qq6 != null) {
                            List list3 = list2;
                            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                            Iterator it2 = list3.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(((JX6) it2.next()).c());
                            }
                            qq6.M(arrayList2);
                        }
                    }
                }
                return C19938rB7.a;
            }
        }

        C10383q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C10383q c10383q = C10366bX6.this.new C10383q(interfaceC20295rm1);
            c10383q.c = obj;
            return c10383q;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10040ay6 interfaceC10040ay6Z4 = C10366bX6.this.z4();
                a aVar = new a(interfaceC20315ro1, C10366bX6.this);
                this.b = 1;
                if (interfaceC10040ay6Z4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10383q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$r, reason: case insensitive filesystem */
    static final class C10384r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QQ6 c;
        final /* synthetic */ C10366bX6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10384r(QQ6 qq6, C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = qq6;
            this.d = c10366bX6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C10384r(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Bitmap bitmapE;
            ExPeer exPeer;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                bitmapE = V13.e(this.c.m());
            } catch (IOException unused) {
                this.d.o6(this.c.i(), YK6.b);
            }
            if (bitmapE == null) {
                this.d.o6(this.c.i(), YK6.b);
                C19406qI3.b("story", "compress image failed #" + this.c.i());
                return C19938rB7.a;
            }
            String strL = C4053Dm2.l("image", "jpg");
            if (strL == null) {
                return C19938rB7.a;
            }
            V13.g(bitmapE, strL, 100);
            C10366bX6 c10366bX6 = this.d;
            long jI = this.c.i();
            C10366bX6 c10366bX62 = this.d;
            QQ6 qq6 = this.c;
            PeersStruct$ExPeer peersStruct$ExPeerG = qq6.g();
            if (peersStruct$ExPeerG != null) {
                EnumC10088b35 type = peersStruct$ExPeerG.getType();
                AbstractC13042fc3.h(type, "getType(...)");
                exPeer = new ExPeer(c10366bX62.h5(type), peersStruct$ExPeerG.getId());
            } else {
                exPeer = new ExPeer(ExPeerType.PRIVATE, qq6.p());
            }
            c10366bX6.r6(jI, exPeer, strL, EnumC21310tR6.f, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10384r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$s, reason: case insensitive filesystem */
    static final class C10385s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C10385s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10385s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                JX7 jx7 = C10366bX6.this.d;
                Q12.a aVar = Q12.b;
                long jR = Q12.R(T12.t(System.currentTimeMillis(), W12.d), W12.e);
                this.b = 1;
                if (jx7.b(jR, this) == objE) {
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
            return ((C10385s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$t, reason: case insensitive filesystem */
    static final class C10386t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        int c;
        Object d;
        Object e;
        int f;
        final /* synthetic */ QQ6 h;

        /* renamed from: ir.nasim.bX6$t$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ boolean d;
            final /* synthetic */ QQ6 e;
            final /* synthetic */ C10366bX6 f;
            final /* synthetic */ FileReference g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(QQ6 qq6, C10366bX6 c10366bX6, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = qq6;
                this.f = c10366bX6;
                this.g = fileReference;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                String strQ;
                EnumC21310tR6 enumC21310tR6B;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
                boolean z = this.d;
                if (this.e.k() && this.e.D() == null) {
                    this.f.y4(this.e);
                }
                if (!z) {
                    C23144wQ6 c23144wQ6 = C23144wQ6.a;
                    String strL = this.e.l();
                    YV6 yv6 = YV6.i;
                    XV6 xv6A = XV6.b.a(this.e.e());
                    int iF = interfaceC3346Am2.f();
                    PeersStruct$ExPeer peersStruct$ExPeerG = this.e.g();
                    c23144wQ6.k(yv6, null, null, xv6A, strL, null, AbstractC6392Nk0.d(iF), peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getType() : null);
                    InterfaceC19567qa2 interfaceC19567qa2 = this.f.t;
                    XV4 xv4A = AbstractC4616Fw7.a("origin", AbstractC6392Nk0.d(EnumC8893Xt7.c.p()));
                    XV4 xv4A2 = AbstractC4616Fw7.a("file_hash", this.f.u.a(this.g.getFileId(), this.g.getAccessHash()));
                    C20091rS7 c20091rS7C = this.e.C();
                    if (c20091rS7C == null || (enumC21310tR6B = c20091rS7C.b()) == null || (strQ = enumC21310tR6B.q()) == null) {
                        strQ = EnumC21310tR6.d.a(this.g.getFileName()).q();
                    }
                    interfaceC19567qa2.a("download_traffic", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("file_mime_type", strQ), AbstractC4616Fw7.a("file_size", AbstractC6392Nk0.d(interfaceC3346Am2.f()))));
                }
                this.f.Z0.remove(AbstractC6392Nk0.e(this.g.getFileId()));
                return C19938rB7.a;
            }

            public final Object n(InterfaceC3346Am2 interfaceC3346Am2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = interfaceC3346Am2;
                aVar.d = z;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n((InterfaceC3346Am2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10386t(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = qq6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10386t(this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00c0  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10386t.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10386t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$u, reason: case insensitive filesystem */
    static final class C10387u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* renamed from: ir.nasim.bX6$u$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C10366bX6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10366bX6 c10366bX6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c10366bX6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC3346Am2 interfaceC3346Am2 = (InterfaceC3346Am2) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.I0;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.S0((List) value, interfaceC3346Am2)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC3346Am2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.bX6$u$b */
        static final class b extends AbstractC19859r37 implements UA2 {
            int b;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10387u(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10387u(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C10366bX6 c10366bX6 = C10366bX6.this;
            C10366bX6.F2(c10366bX6, this.d, null, false, new a(c10366bX6, null), new b(null), 4, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10387u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$v, reason: case insensitive filesystem */
    static final class C10388v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C10388v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C10366bX6 c10366bX6, int i, RY1 ry1) {
            if (ry1 instanceof RY1.a) {
                c10366bX6.C3().put(Integer.valueOf(i), ((RY1.a) ry1).a());
            } else if (!(ry1 instanceof RY1.b) && !(ry1 instanceof RY1.c)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10388v(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BH7 bh7 = C10366bX6.this.e;
                this.b = 1;
                obj = bh7.f(this);
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
                Z06.b bVar = (Z06.b) z06;
                if (((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList().isEmpty()) {
                    return C19938rB7.a;
                }
                List<StoryStruct$UserStoryConfig> configList = ((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList();
                AbstractC13042fc3.h(configList, "getConfigList(...)");
                List<StoryStruct$MediaStory> backgroundsList = ((StoryStruct$UserStoryConfig) AbstractC15401jX0.q0(configList)).getTextStoryBackgroundConfig().getBackgroundsList();
                C10366bX6.this.K5(backgroundsList.size());
                AbstractC13042fc3.f(backgroundsList);
                List<StoryStruct$MediaStory> list = backgroundsList;
                final C10366bX6 c10366bX6 = C10366bX6.this;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                final int i2 = 0;
                for (Object obj2 : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        AbstractC10360bX0.w();
                    }
                    StoryStruct$MediaStory storyStruct$MediaStory = (StoryStruct$MediaStory) obj2;
                    AbstractC13042fc3.f(storyStruct$MediaStory);
                    arrayList.add(new C12402eZ1(c10366bX6.b3(storyStruct$MediaStory), false, false, new UA2() { // from class: ir.nasim.dX6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj3) {
                            return C10366bX6.C10388v.y(c10366bX6, i2, (RY1) obj3);
                        }
                    }));
                    i2 = i3;
                }
                C13011fZ1.i(C10366bX6.this.y, arrayList, 0, 2, null);
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10388v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$w, reason: case insensitive filesystem */
    public static final class C10389w implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.bX6$w$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.bX6$w$a$a, reason: collision with other inner class name */
            public static final class C0915a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0915a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C10366bX6.C10389w.a.C0915a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.bX6$w$a$a r0 = (ir.nasim.C10366bX6.C10389w.a.C0915a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.bX6$w$a$a r0 = new ir.nasim.bX6$w$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L5f
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.RY1 r6 = (ir.nasim.RY1) r6
                    boolean r2 = r6 instanceof ir.nasim.RY1.a
                    r4 = 100
                    if (r2 == 0) goto L3f
                    goto L52
                L3f:
                    boolean r2 = r6 instanceof ir.nasim.RY1.b
                    if (r2 == 0) goto L4d
                    ir.nasim.RY1$b r6 = (ir.nasim.RY1.b) r6
                    float r6 = r6.a()
                    float r2 = (float) r4
                    float r6 = r6 * r2
                    int r4 = (int) r6
                    goto L52
                L4d:
                    boolean r6 = r6 instanceof ir.nasim.RY1.c
                    if (r6 == 0) goto L62
                    r4 = 0
                L52:
                    java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r4)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                L62:
                    kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                    r6.<init>()
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C10389w.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public C10389w(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bX6$x, reason: case insensitive filesystem */
    static final class C10390x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10390x(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10390x(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Map map = C10366bX6.this.p1;
            C10366bX6 c10366bX6 = C10366bX6.this;
            long j = this.d;
            Iterator it = map.entrySet().iterator();
            do {
                obj2 = null;
                if (!it.hasNext()) {
                    break;
                }
                List list = (List) c10366bX6.A0.get(AbstractC24369yV6.c((QQ6) ((Map.Entry) it.next()).getValue()));
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (AbstractC13042fc3.d(((QQ6) next).l(), String.valueOf(j))) {
                            obj2 = next;
                            break;
                        }
                    }
                    obj2 = (QQ6) obj2;
                }
            } while (obj2 == null);
            return obj2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10390x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$y, reason: case insensitive filesystem */
    static final class C10391y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10391y(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10391y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                JX7 jx7 = C10366bX6.this.d;
                String str = this.d;
                this.b = 1;
                obj = jx7.c(str, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C10366bX6.this.O5(this.d);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C10366bX6.this.J;
                Z06.b bVar = (Z06.b) z06;
                C5439Ji5 c5439Ji5 = new C5439Ji5(((StoryOuterClass$ResponseGetViewersCount) bVar.a()).getViewCount(), ((StoryOuterClass$ResponseGetViewersCount) bVar.a()).getLikeCount());
                this.b = 2;
                if (interfaceC8327Vm4.a(c5439Ji5, this) == objE) {
                    return objE;
                }
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10391y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bX6$z, reason: case insensitive filesystem */
    static final class C10392z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C10392z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10366bX6.this.new C10392z(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                StoryRepository storyRepository = C10366bX6.this.c;
                this.b = 1;
                if (storyRepository.H(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C10366bX6.this.j5();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C10392z) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10366bX6(HP5 hp5, StoryRepository storyRepository, JX7 jx7, BH7 bh7, C6409Nm c6409Nm, InterfaceC3570Bk5 interfaceC3570Bk5, SettingsModule settingsModule, C14970in2 c14970in2, InterfaceC12532em2 interfaceC12532em2, MC mc, C21670tw c21670tw, NC nc, InterfaceC14123hO3 interfaceC14123hO3, DX6.b bVar, C6559Oa2 c6559Oa2, IT7 it7, IT7 it72, int i, WF2 wf2, InterfaceC19567qa2 interfaceC19567qa2, JE2 je2, InterfaceC5409Jf2 interfaceC5409Jf2, InterfaceC9824ad1 interfaceC9824ad1, C9847af4 c9847af4, C15753k68 c15753k68) {
        AbstractC13042fc3.i(hp5, "reportStoryUseCase");
        AbstractC13042fc3.i(storyRepository, "storyRepository");
        AbstractC13042fc3.i(jx7, "viewStoryRepository");
        AbstractC13042fc3.i(bh7, "uploadStoryRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(mc, "apiStoryToStoryItemMapper");
        AbstractC13042fc3.i(c21670tw, "apiBotStoryToStoryItemMapper");
        AbstractC13042fc3.i(nc, "apiStoryViewerItemToStoryViewerItemMapper");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerToStructExPeerMapper");
        AbstractC13042fc3.i(bVar, "storyViewersPagingSource");
        AbstractC13042fc3.i(c6559Oa2, "eventBus");
        AbstractC13042fc3.i(it7, "videoPlayerCacheIdGenerator");
        AbstractC13042fc3.i(it72, "cacheIdGenerator");
        AbstractC13042fc3.i(wf2, "getGalleryResultUseCase");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(je2, "generateFileHashUseCase");
        AbstractC13042fc3.i(interfaceC5409Jf2, "falakeRepository");
        AbstractC13042fc3.i(interfaceC9824ad1, "configurationRepository");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        AbstractC13042fc3.i(c15753k68, "minimizeManager");
        this.b = hp5;
        this.c = storyRepository;
        this.d = jx7;
        this.e = bh7;
        this.f = c6409Nm;
        this.g = interfaceC3570Bk5;
        this.h = settingsModule;
        this.i = c14970in2;
        this.j = interfaceC12532em2;
        this.k = mc;
        this.l = c21670tw;
        this.m = nc;
        this.n = interfaceC14123hO3;
        this.o = bVar;
        this.p = c6559Oa2;
        this.q = it7;
        this.r = it72;
        this.s = i;
        this.t = interfaceC19567qa2;
        this.u = je2;
        this.v = interfaceC5409Jf2;
        this.w = c9847af4;
        this.x = c15753k68;
        this.y = new C13011fZ1(AbstractC9773aX7.a(this), C12366eV1.b(), interfaceC12532em2, AbstractC4430Fc1.c(interfaceC9824ad1, c9847af4.b()), 5);
        this.z = AbstractC11420cy6.b(0, 0, null, 7, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.B = interfaceC9336Zm4A;
        this.D = interfaceC9336Zm4A;
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.G = interfaceC8327Vm4B;
        this.H = interfaceC8327Vm4B;
        InterfaceC8327Vm4 interfaceC8327Vm4B2 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.J = interfaceC8327Vm4B2;
        this.Y = interfaceC8327Vm4B2;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.Z = interfaceC9336Zm4A2;
        this.z0 = interfaceC9336Zm4A2;
        this.A0 = new ConcurrentHashMap();
        this.B0 = new ArrayList();
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(W9.b.a);
        this.C0 = interfaceC9336Zm4A3;
        this.D0 = interfaceC9336Zm4A3;
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(null);
        this.E0 = interfaceC9336Zm4A4;
        this.F0 = interfaceC9336Zm4A4;
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(FQ6.c.a);
        this.G0 = interfaceC9336Zm4A5;
        this.H0 = interfaceC9336Zm4A5;
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.I0 = interfaceC9336Zm4A6;
        this.J0 = interfaceC9336Zm4A6;
        InterfaceC9336Zm4 interfaceC9336Zm4A7 = AbstractC12281eL6.a(Boolean.FALSE);
        this.K0 = interfaceC9336Zm4A7;
        this.L0 = interfaceC9336Zm4A7;
        this.M0 = new C17628nH7();
        InterfaceC9336Zm4 interfaceC9336Zm4A8 = AbstractC12281eL6.a(null);
        this.N0 = interfaceC9336Zm4A8;
        this.O0 = interfaceC9336Zm4A8;
        C20298rm4 c20298rm4 = new C20298rm4();
        this.P0 = c20298rm4;
        this.Q0 = c20298rm4;
        InterfaceC8327Vm4 interfaceC8327Vm4B3 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.R0 = interfaceC8327Vm4B3;
        this.S0 = interfaceC8327Vm4B3;
        InterfaceC8327Vm4 interfaceC8327Vm4B4 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.T0 = interfaceC8327Vm4B4;
        this.U0 = interfaceC8327Vm4B4;
        InterfaceC9336Zm4 interfaceC9336Zm4A9 = AbstractC12281eL6.a(null);
        this.V0 = interfaceC9336Zm4A9;
        this.W0 = AbstractC6459Nq2.c(interfaceC9336Zm4A9);
        this.Z0 = new ArrayList();
        this.a1 = new ArrayList();
        this.b1 = "StoryAdderFragment";
        this.c1 = AbstractC9370Zq2.h(wf2.a("StoryAdderFragment"), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.d(), 0, 4, null);
        this.d1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10366bX6.T4(this.a);
            }
        });
        this.e1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.VW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C10366bX6.E5(this.a));
            }
        });
        this.f1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C10366bX6.u6(this.a));
            }
        });
        this.g1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10366bX6.i5();
            }
        });
        this.h1 = settingsModule.B5(EnumC4716Gg2.T0);
        this.i1 = T3();
        this.j1 = new HashMap();
        this.k1 = 1;
        this.l1 = new ArrayList();
        this.m1 = new ArrayList();
        this.o1 = "";
        this.p1 = new LinkedHashMap();
        this.s1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10366bX6.b5();
            }
        });
        r3();
        s4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10367a(null), 2, null);
        f5();
        if (settingsModule.B5(EnumC4716Gg2.S0)) {
            InterfaceC3817Cm0 interfaceC3817Cm0 = new InterfaceC3817Cm0() { // from class: ir.nasim.ZW6
                @Override // ir.nasim.InterfaceC3817Cm0
                /* renamed from: g */
                public final void T(AbstractC18385oa2 abstractC18385oa2) {
                    C10366bX6.Y0(this.a, abstractC18385oa2);
                }
            };
            this.t1 = interfaceC3817Cm0;
            c6559Oa2.h(interfaceC3817Cm0, "STORY_APP_BAR_HIDDEN");
        }
        S2();
        this.u1 = AbstractC20899sn4.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void A2(Map map) {
        for (List list : map.values()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    QQ6 qq6 = (QQ6) it.next();
                    if (qq6.w() != null) {
                        C14189hV6 c14189hV6W = qq6.w();
                        AbstractC13042fc3.f(c14189hV6W);
                        ((QQ6) AbstractC15401jX0.C0(list)).L(Integer.valueOf(c14189hV6W.a()));
                        break;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A5(ir.nasim.core.modules.file.entity.FileReference r20, ir.nasim.QQ6 r21, long r22, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.A5(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.QQ6, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B5(ir.nasim.QQ6 r11, ir.nasim.core.modules.file.entity.FileReference r12, long r13, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof ir.nasim.C10366bX6.T
            if (r0 == 0) goto L14
            r0 = r15
            ir.nasim.bX6$T r0 = (ir.nasim.C10366bX6.T) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.g = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            ir.nasim.bX6$T r0 = new ir.nasim.bX6$T
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r15 = r9.e
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r9.g
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3c
            long r13 = r9.d
            java.lang.Object r11 = r9.c
            r12 = r11
            ir.nasim.core.modules.file.entity.FileReference r12 = (ir.nasim.core.modules.file.entity.FileReference) r12
            java.lang.Object r11 = r9.b
            ir.nasim.QQ6 r11 = (ir.nasim.QQ6) r11
            java.lang.Object r0 = r9.a
            ir.nasim.bX6 r0 = (ir.nasim.C10366bX6) r0
            ir.nasim.AbstractC10685c16.b(r15)
        L39:
            r1 = r12
            r3 = r13
            goto L92
        L3c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L44:
            ir.nasim.AbstractC10685c16.b(r15)
            ai.bale.proto.PeersStruct$ExPeer r15 = r11.g()
            ir.nasim.AbstractC13042fc3.f(r15)
            java.lang.String r4 = r11.m()
            ir.nasim.rS7 r5 = r11.C()
            ir.nasim.hV6 r1 = r11.w()
            if (r1 == 0) goto L6b
            ir.nasim.hV6 r3 = new ir.nasim.hV6
            int r6 = r1.a()
            boolean r1 = r1.b()
            r3.<init>(r6, r1)
            r6 = r3
            goto L6d
        L6b:
            r1 = 0
            r6 = r1
        L6d:
            java.util.List r1 = r11.D()
            if (r1 != 0) goto L77
            java.util.List r1 = ir.nasim.ZW0.m()
        L77:
            r7 = r1
            com.google.protobuf.g r8 = r11.z()
            r9.a = r10
            r9.b = r11
            r9.c = r12
            r9.d = r13
            r9.g = r2
            r1 = r10
            r2 = r15
            r3 = r12
            java.lang.Object r15 = r1.v2(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r15 != r0) goto L90
            return r0
        L90:
            r0 = r10
            goto L39
        L92:
            ir.nasim.Z06 r15 = (ir.nasim.Z06) r15
            boolean r12 = r15 instanceof ir.nasim.Z06.b
            if (r12 == 0) goto Lc4
            ir.nasim.Z06$b r15 = (ir.nasim.Z06.b) r15
            com.google.protobuf.P r12 = r15.a()
            ai.bale.proto.StoryOuterClass$ResponseAddStory r12 = (ai.bale.proto.StoryOuterClass$ResponseAddStory) r12
            java.lang.String r2 = r12.getStoryId()
            java.lang.String r12 = "getStoryId(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r12)
            java.lang.String r5 = r11.m()
            ir.nasim.rS7 r6 = r11.C()
            ir.nasim.hV6 r7 = r11.w()
            java.util.List r11 = r11.D()
            if (r11 != 0) goto Lbf
            java.util.List r11 = ir.nasim.ZW0.m()
        Lbf:
            r8 = r11
            r0.y2(r1, r2, r3, r5, r6, r7, r8)
            goto Ld6
        Lc4:
            boolean r12 = r15 instanceof ir.nasim.Z06.a
            if (r12 == 0) goto Ld9
            long r11 = r11.i()
            ir.nasim.YK6 r13 = ir.nasim.YK6.b
            r0.o6(r11, r13)
            ir.nasim.Z06$a r15 = (ir.nasim.Z06.a) r15
            r0.U4(r15)
        Ld6:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            return r11
        Ld9:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.B5(ir.nasim.QQ6, ir.nasim.core.modules.file.entity.FileReference, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C5(ir.nasim.core.modules.file.entity.FileReference r19, ir.nasim.QQ6 r20, long r21, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.C5(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.QQ6, long, ir.nasim.rm1):java.lang.Object");
    }

    private final void D2(QQ6 qq6, ir.nasim.tgwidgets.editor.messenger.H h) {
        this.B0.add(new C17428mw7(qq6, this.Y0, h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E5(C10366bX6 c10366bX6) {
        AbstractC13042fc3.i(c10366bX6, "this$0");
        return c10366bX6.h.P3();
    }

    public static /* synthetic */ InterfaceC13730gj3 F2(C10366bX6 c10366bX6, FileReference fileReference, HS7 hs7, boolean z, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            interfaceC14603iB2 = new C10374h(null);
        }
        InterfaceC14603iB2 interfaceC14603iB22 = interfaceC14603iB2;
        if ((i & 16) != 0) {
            ua2 = new C10375i(null);
        }
        return c10366bX6.E2(fileReference, hs7, z2, interfaceC14603iB22, ua2);
    }

    public static /* synthetic */ Object J2(C10366bX6 c10366bX6, FileReference fileReference, HS7 hs7, boolean z, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, boolean z2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        return c10366bX6.H2(fileReference, hs7, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : interfaceC15796kB2, (i & 16) != 0 ? new C10380n(null) : ua2, (i & 32) != 0 ? false : z2, interfaceC20295rm1);
    }

    private final void J5(int i, InterfaceC10294bP6 interfaceC10294bP6, int i2, int i3) {
        C23144wQ6 c23144wQ6 = C23144wQ6.a;
        int iE = interfaceC10294bP6.e();
        String strC = interfaceC10294bP6.c();
        Integer numB = interfaceC10294bP6.b();
        Integer numH = interfaceC10294bP6.h();
        String strA = interfaceC10294bP6.a();
        Integer numValueOf = Integer.valueOf(i2);
        if (numValueOf.intValue() == T3().getId()) {
            numValueOf = null;
        }
        c23144wQ6.i(i, iE, strC, numB, numH, strA, numValueOf, Integer.valueOf(i3), this.i1.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K2() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object L2(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        sa2.invoke();
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 S2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C10383q(null), 3, null);
    }

    private final WK S3() {
        return (WK) this.s1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List T4(C10366bX6 c10366bX6) {
        AbstractC13042fc3.i(c10366bX6, "this$0");
        return AbstractC20762sZ6.N0(c10366bX6.h.l4(), new String[]{","}, false, 0, 6, null);
    }

    private final InterfaceC13730gj3 U2(QQ6 qq6) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10384r(qq6, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object U3(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.a(), new C10390x(j, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U4(Z06.a aVar) {
        Object value;
        if (aVar.a().getCode() == 7) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, W9.a.a));
        }
    }

    private final void W4() {
        InterfaceC10294bP6 interfaceC10294bP6B;
        C22548vQ6 c22548vQ6 = this.Y0;
        if (c22548vQ6 == null || (interfaceC10294bP6B = c22548vQ6.b()) == null) {
            return;
        }
        if (interfaceC10294bP6B.i()) {
            H5(new InterfaceC10294bP6.f(interfaceC10294bP6B.e()));
        } else if (interfaceC10294bP6B.j()) {
            H5(new InterfaceC10294bP6.l(interfaceC10294bP6B.e()));
        } else if (interfaceC10294bP6B.g()) {
            H5(new InterfaceC10294bP6.r(interfaceC10294bP6B.e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X4(String str, C22548vQ6 c22548vQ6, int i) {
        if (c22548vQ6 != null) {
            int iD = c22548vQ6.d();
            InterfaceC10294bP6 interfaceC10294bP6B = c22548vQ6.b();
            if (interfaceC10294bP6B == null) {
                return;
            }
            if (interfaceC10294bP6B.i() && interfaceC10294bP6B.f()) {
                J5(iD, new InterfaceC10294bP6.g(interfaceC10294bP6B.e(), str), c22548vQ6.c(), i);
                return;
            }
            if (interfaceC10294bP6B.i() && interfaceC10294bP6B.d()) {
                J5(iD, new InterfaceC10294bP6.j(interfaceC10294bP6B.e(), str), c22548vQ6.c(), i);
                return;
            }
            if (interfaceC10294bP6B.j() && interfaceC10294bP6B.f()) {
                J5(iD, new InterfaceC10294bP6.m(interfaceC10294bP6B.e(), str), c22548vQ6.c(), i);
                return;
            }
            if (interfaceC10294bP6B.j() && interfaceC10294bP6B.d()) {
                J5(iD, new InterfaceC10294bP6.o(interfaceC10294bP6B.e(), str), c22548vQ6.c(), i);
            } else if (interfaceC10294bP6B.g()) {
                J5(iD, new InterfaceC10294bP6.s(interfaceC10294bP6B.e(), str), c22548vQ6.c(), i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C10366bX6 c10366bX6, AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(c10366bX6, "this$0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZI7 Y2(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        EnumC21337tU6 exception = storyStruct$UserPrivacyConfig.getException();
        int i = exception == null ? -1 : C10369c.a[exception.ordinal()];
        EnumC5052Hr5 enumC5052Hr5 = i != 1 ? i != 2 ? i != 3 ? EnumC5052Hr5.d : EnumC5052Hr5.c : EnumC5052Hr5.b : EnumC5052Hr5.a;
        int exceptionUserIdsCount = storyStruct$UserPrivacyConfig.getExceptionUserIdsCount();
        List<Integer> exceptionUserIdsList = storyStruct$UserPrivacyConfig.getExceptionUserIdsList();
        AbstractC13042fc3.h(exceptionUserIdsList, "getExceptionUserIdsList(...)");
        return new ZI7(enumC5052Hr5, exceptionUserIdsCount, exceptionUserIdsList, storyStruct$UserPrivacyConfig.getIsActive());
    }

    private final QQ6 Y3(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            QQ6 qq6 = (QQ6) it.next();
            if (AbstractC13042fc3.d(qq6.s(), AbstractC11710dT6.a.a)) {
                return qq6;
            }
        }
        return (QQ6) AbstractC15401jX0.q0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoryStruct$TextStory a3(String str) {
        GeneratedMessageLite generatedMessageLiteA = StoryStruct$TextStory.newBuilder().A(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (StoryStruct$TextStory) generatedMessageLiteA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileReference b3(StoryStruct$MediaStory storyStruct$MediaStory) {
        return new FileReference(new C12056dy(storyStruct$MediaStory.getFileLocation().getFileId(), storyStruct$MediaStory.getFileLocation().getAccessHash(), Integer.valueOf(storyStruct$MediaStory.getFileLocation().getFileStorageVersion().getValue())), "story_const_" + storyStruct$MediaStory.getFileLocation().getFileId() + Separators.DOT + EnumC21310tR6.f.p(), "", (int) storyStruct$MediaStory.getFileSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK b5() {
        DB3 db3M0 = AbstractC5969Lp4.e().A().m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileReference c3(C24890zN5 c24890zN5) {
        return new FileReference(new C12056dy(c24890zN5.b(), c24890zN5.a(), Integer.valueOf(c24890zN5.c())), "story_" + c24890zN5.b() + Separators.DOT + EnumC21310tR6.f.p(), "", c24890zN5.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileReference d3(QQ6 qq6) {
        EnumC21310tR6 enumC21310tR6B;
        boolean zG = qq6.G();
        StoryStruct$MediaStory storyStruct$MediaStoryD = qq6.d();
        if (storyStruct$MediaStoryD == null) {
            return null;
        }
        C12056dy c12056dy = zG ? new C12056dy(storyStruct$MediaStoryD.getVideo().getFileLocation().getFileId(), storyStruct$MediaStoryD.getVideo().getFileLocation().getAccessHash(), Integer.valueOf(storyStruct$MediaStoryD.getVideo().getFileLocation().getFileStorageVersion().getValue())) : new C12056dy(storyStruct$MediaStoryD.getFileLocation().getFileId(), storyStruct$MediaStoryD.getFileLocation().getAccessHash(), Integer.valueOf(storyStruct$MediaStoryD.getFileLocation().getFileStorageVersion().getValue()));
        long fileId = (zG ? storyStruct$MediaStoryD.getVideo().getFileLocation() : storyStruct$MediaStoryD.getFileLocation()).getFileId();
        if (zG) {
            C20091rS7 c20091rS7C = qq6.C();
            AbstractC13042fc3.f(c20091rS7C);
            enumC21310tR6B = c20091rS7C.b();
        } else {
            enumC21310tR6B = EnumC21310tR6.f;
        }
        return new FileReference(c12056dy, "story_" + fileId + Separators.DOT + enumC21310tR6B.p(), "", (int) (zG ? storyStruct$MediaStoryD.getVideo().getFileSize() : storyStruct$MediaStoryD.getFileSize()));
    }

    private final StoryStruct$MediaStory e3(String str, FileReference fileReference, AbstractC2383g abstractC2383g, List list) {
        ArrayList arrayList;
        List widgetCoordinates;
        StoryStruct$MediaStory.a aVarNewBuilder = StoryStruct$MediaStory.newBuilder();
        StoryWidget.Unknown unknown = StoryWidget.Unknown.a;
        StoryWidget.LinkWidget linkWidgetF0 = unknown.f0(list);
        if (linkWidgetF0 != null) {
            aVarNewBuilder.B((StoryStruct$Widget) StoryStruct$Widget.newBuilder().A((StoryStruct$LinkWidget) StoryStruct$LinkWidget.newBuilder().A(linkWidgetF0.a()).B(linkWidgetF0.getTitle()).a()).D(EnumC13598gV6.WidgetType_Link).a());
        }
        StoryWidget.PostWidget postWidgetK0 = unknown.k0(list);
        if (postWidgetK0 != null) {
            StoryStruct$Widget.a aVarC = StoryStruct$Widget.newBuilder().D(EnumC13598gV6.WidgetType_Post).C((StoryStruct$PostWidget) StoryStruct$PostWidget.newBuilder().A(postWidgetK0.getLink()).a());
            StoryWidget.PostWidget postWidgetK02 = unknown.k0(list);
            if (postWidgetK02 == null || (widgetCoordinates = postWidgetK02.getWidgetCoordinates()) == null) {
                arrayList = null;
            } else {
                List<WidgetCoordinate> list2 = widgetCoordinates;
                arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (WidgetCoordinate widgetCoordinate : list2) {
                    arrayList.add((StoryStruct$Coordinate) StoryStruct$Coordinate.newBuilder().A(widgetCoordinate.getX()).B(widgetCoordinate.getY()).a());
                }
            }
            aVarC.B((StoryStruct$Position) StoryStruct$Position.newBuilder().A(arrayList).a());
            StoryStruct$MediaStory.a aVarA = aVarNewBuilder.A(aVarC);
            if (aVarA != null) {
            }
        }
        if (abstractC2383g == null) {
            abstractC2383g = str != null ? AbstractC2383g.F(g3(str)) : null;
        }
        if (abstractC2383g != null) {
            aVarNewBuilder.C((FilesStruct$FastThumb) FilesStruct$FastThumb.newBuilder().A(abstractC2383g).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.E(fileReference.getFileSize()).D(FilesStruct$FileLocation.newBuilder().B(fileReference.getFileId()).A(fileReference.getAccessHash())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (StoryStruct$MediaStory) generatedMessageLiteA;
    }

    private final void e5(long j) {
        this.i.G(j, new K(j, this.M0.b(j, new C17037mH7(j, null, 2, null))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void e6() {
        for (Map.Entry entry : this.A0.entrySet()) {
            QQ6 qq6 = (QQ6) AbstractC15401jX0.F0((List) entry.getValue());
            if (qq6 != null && !qq6.E()) {
                List list = (List) entry.getValue();
                if (list.size() > 1) {
                    AbstractC12992fX0.B(list, new Y());
                }
            }
        }
    }

    private final InterfaceC13730gj3 f5() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new L(null), 2, null);
    }

    private final void f6(long j) {
        this.e.l(j);
    }

    private final byte[] g3(String str) {
        byte[] bArrI = V13.i(V13.o(V13.e(str), 30, 30));
        AbstractC13042fc3.h(bArrI, "save(...)");
        return bArrI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoryStruct$MediaStory h3(FileReference fileReference, String str, C20091rS7 c20091rS7, AbstractC2383g abstractC2383g, List list) {
        return c20091rS7 != null ? n3(str, c20091rS7, fileReference, StoryWidget.Unknown.a.f0(list), abstractC2383g) : e3(str, fileReference, abstractC2383g, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h4(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.a(), new A(null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExPeerType h5(EnumC10088b35 enumC10088b35) {
        switch (C10369c.f[enumC10088b35.ordinal()]) {
            case 1:
                return ExPeerType.UNKNOWN;
            case 2:
                return ExPeerType.PRIVATE;
            case 3:
                return ExPeerType.GROUP;
            case 4:
                return ExPeerType.CHANNEL;
            case 5:
                return ExPeerType.BOT;
            case 6:
                return ExPeerType.GROUP;
            case 7:
                return ExPeerType.THREAD;
            case 8:
                return ExPeerType.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ StoryStruct$MediaStory i3(C10366bX6 c10366bX6, FileReference fileReference, String str, C20091rS7 c20091rS7, AbstractC2383g abstractC2383g, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            abstractC2383g = null;
        }
        return c10366bX6.h3(fileReference, str, c20091rS7, abstractC2383g, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeersStruct$ExPeer i5() {
        return (PeersStruct$ExPeer) PeersStruct$ExPeer.newBuilder().B(AbstractC5969Lp4.f()).C(EnumC10088b35.ExPeerType_PRIVATE).A(0L).a();
    }

    private final void i6() {
        int i = C10369c.c[X9.b.a(this.h.b0()).ordinal()];
        if (i == 1) {
            this.h.b6(X9.d.j());
        } else if (i == 2) {
            this.h.b6(X9.e.j());
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQ6 j3(String str, FileReference fileReference, PeersStruct$ExPeer peersStruct$ExPeer, String str2, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list, AbstractC2383g abstractC2383g) {
        return new QQ6(0L, str, i3(this, fileReference, str2, c20091rS7, null, list, 8, null), null, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), this.s, AbstractC11710dT6.a.a, str2, null, peersStruct$ExPeer, c20091rS7, false, c14189hV6, null, false, list, false, abstractC2383g, null, null, 878857, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j5() {
        this.g.g("GET_STORY_TRIGGER", true);
    }

    private final QQ6 l3(String str, PeersStruct$ExPeer peersStruct$ExPeer, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list, Boolean bool, Long l, byte[] bArr, Object obj) {
        return new QQ6(l != null ? l.longValue() : C20590sG5.a(), null, null, null, System.currentTimeMillis() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.s, AbstractC11710dT6.a.a, str, (bool == null || !bool.booleanValue()) ? YK6.a : YK6.d, peersStruct$ExPeer, c20091rS7, false, c14189hV6, null, false, list == null ? AbstractC10360bX0.m() : list, false, bArr != null ? AbstractC2383g.F(bArr) : null, null, obj, 354314, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l4(String str, PeersStruct$ExPeer peersStruct$ExPeer, Long l) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new B(str, peersStruct$ExPeer, l, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l5(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C10366bX6.M
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.bX6$M r0 = (ir.nasim.C10366bX6.M) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.bX6$M r0 = new ir.nasim.bX6$M
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.b
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.a
            ir.nasim.bX6 r5 = (ir.nasim.C10366bX6) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L89
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.om r8 = r7.A
            if (r8 == 0) goto Lcb
            java.util.List r8 = r8.a()
            if (r8 != 0) goto L4c
            goto Lcb
        L4c:
            ir.nasim.core.modules.settings.SettingsModule r2 = r7.h
            int r2 = r2.m4()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "preDownloadStories limit="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "story"
            ir.nasim.C19406qI3.a(r6, r2, r5)
            ir.nasim.core.modules.settings.SettingsModule r2 = r7.h
            int r2 = r2.m4()
            int r5 = r8.size()
            int r2 = java.lang.Math.min(r2, r5)
            java.util.List r8 = r8.subList(r4, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
            r5 = r7
            r4 = r2
            r2 = r8
        L89:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto Lca
            java.lang.Object r8 = r2.next()
            ir.nasim.eR6 r8 = (ir.nasim.C12335eR6) r8
            java.util.concurrent.ConcurrentHashMap r6 = r5.A0
            ir.nasim.dR6 r8 = r8.b()
            java.lang.Object r8 = r6.get(r8)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L89
            r6 = r8
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L89
            ir.nasim.QQ6 r8 = r5.Y3(r8)
            ir.nasim.core.modules.file.entity.FileReference r6 = r5.d3(r8)
            if (r6 != 0) goto Lb8
            goto L89
        Lb8:
            r4.add(r6)
            r0.a = r5
            r0.b = r4
            r0.c = r2
            r0.f = r3
            java.lang.Object r8 = r5.m5(r8, r6, r0)
            if (r8 != r1) goto L89
            return r1
        Lca:
            return r4
        Lcb:
            java.util.List r8 = ir.nasim.ZW0.m()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.l5(ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ QQ6 m3(C10366bX6 c10366bX6, String str, PeersStruct$ExPeer peersStruct$ExPeer, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list, Boolean bool, Long l, byte[] bArr, Object obj, int i, Object obj2) {
        return c10366bX6.l3((i & 1) != 0 ? null : str, peersStruct$ExPeer, (i & 4) != 0 ? null : c20091rS7, (i & 8) != 0 ? null : c14189hV6, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : bArr, (i & 256) != 0 ? null : obj);
    }

    private final Object m5(QQ6 qq6, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        C19406qI3.a("story", "requested to download story: " + qq6.l(), new Object[0]);
        Object objJ2 = J2(this, fileReference, qq6.G() ? new HS7(qq6.f()) : null, !C8386Vt0.a.Wa(), new N(qq6, this, fileReference, null), null, false, interfaceC20295rm1, 48, null);
        return objJ2 == AbstractC14862ic3.e() ? objJ2 : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 m6() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new Z(null), 2, null);
    }

    private final StoryStruct$MediaStory n3(String str, C20091rS7 c20091rS7, FileReference fileReference, StoryWidget.LinkWidget linkWidget, AbstractC2383g abstractC2383g) {
        StoryStruct$MediaStory.a aVarNewBuilder = StoryStruct$MediaStory.newBuilder();
        if (linkWidget != null) {
            aVarNewBuilder.B((StoryStruct$Widget) StoryStruct$Widget.newBuilder().A((StoryStruct$LinkWidget) StoryStruct$LinkWidget.newBuilder().A(linkWidget.a()).B(linkWidget.getTitle()).a()).D(EnumC13598gV6.WidgetType_Link).a());
        }
        StoryStruct$VideoStory.a aVarC = StoryStruct$VideoStory.newBuilder().A(c20091rS7.a()).E(c20091rS7.b().p()).D(fileReference.getFileSize()).C(FilesStruct$FileLocation.newBuilder().B(fileReference.getFileId()).A(fileReference.getAccessHash()));
        if (abstractC2383g == null) {
            abstractC2383g = str != null ? AbstractC2383g.F(o3(str)) : null;
        }
        if (abstractC2383g != null) {
            aVarC.B((FilesStruct$FastThumb) FilesStruct$FastThumb.newBuilder().A(abstractC2383g).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.F((StoryStruct$VideoStory) aVarC.a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (StoryStruct$MediaStory) generatedMessageLiteA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQ6 n4(long j) {
        Object next;
        Iterator it = this.B0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((QQ6) ((C17428mw7) next).f()).i() == j) {
                break;
            }
        }
        C17428mw7 c17428mw7 = (C17428mw7) next;
        if (c17428mw7 != null) {
            return (QQ6) c17428mw7.f();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 n6() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new a0(null), 2, null);
    }

    private final byte[] o3(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        byte[] bArrI = V13.i(V13.o(mediaMetadataRetriever.getFrameAtTime(0L), 30, 30));
        AbstractC13042fc3.h(bArrI, "save(...)");
        return bArrI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 o6(long j, YK6 yk6) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b0(j, yk6, null), 3, null);
    }

    private final InterfaceC4557Fq2 p3(final String str) {
        return new C12960fT4(new MT4(20, 0, false, 40, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.TW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10366bX6.q3(this.a, str);
            }
        }, 2, null).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 p5(String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new P(str, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 q3(C10366bX6 c10366bX6, String str) {
        AbstractC13042fc3.i(c10366bX6, "this$0");
        AbstractC13042fc3.i(str, "$storyId");
        return c10366bX6.o.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 q5(long j, QQ6 qq6) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new Q(qq6, j, null), 3, null);
    }

    private final InterfaceC13730gj3 r3() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10385s(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r6(long j, ExPeer exPeer, String str, EnumC21310tR6 enumC21310tR6, ir.nasim.tgwidgets.editor.messenger.H h) {
        this.e.m(j, exPeer, str, enumC21310tR6.q(), enumC21310tR6.r() ? EnumC4543Fo6.c : EnumC4543Fo6.b, h);
        e5(j);
    }

    private final void s4() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new D(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s5(QQ6 qq6, QQ6 qq62, InterfaceC20295rm1 interfaceC20295rm1) {
        List list = (List) this.A0.get(AbstractC24369yV6.c(qq6));
        if (list != null) {
            int iIndexOf = list.indexOf(qq62);
            if (iIndexOf >= 0) {
                list.remove(iIndexOf);
                list.add(iIndexOf, qq6);
            } else {
                AbstractC6392Nk0.a(list.add(qq6));
            }
        } else {
            this.A0.put(AbstractC24369yV6.c(qq6), AbstractC10360bX0.s(qq6));
        }
        Object objA = this.R0.a(qq6.b((1048575 & 1) != 0 ? qq6.a : qq62.i(), (1048575 & 2) != 0 ? qq6.b : null, (1048575 & 4) != 0 ? qq6.c : null, (1048575 & 8) != 0 ? qq6.d : null, (1048575 & 16) != 0 ? qq6.e : 0L, (1048575 & 32) != 0 ? qq6.f : 0, (1048575 & 64) != 0 ? qq6.g : null, (1048575 & 128) != 0 ? qq6.h : null, (1048575 & 256) != 0 ? qq6.i : null, (1048575 & 512) != 0 ? qq6.j : null, (1048575 & 1024) != 0 ? qq6.k : null, (1048575 & 2048) != 0 ? qq6.l : false, (1048575 & 4096) != 0 ? qq6.m : null, (1048575 & 8192) != 0 ? qq6.n : null, (1048575 & 16384) != 0 ? qq6.o : false, (1048575 & 32768) != 0 ? qq6.p : null, (1048575 & 65536) != 0 ? qq6.q : false, (1048575 & 131072) != 0 ? qq6.r : null, (1048575 & 262144) != 0 ? qq6.s : null, (1048575 & 524288) != 0 ? qq6.t : null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    private final InterfaceC13730gj3 s6(long j) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c0(j, null), 3, null);
    }

    private final Object u2(FileReference fileReference, String str, C20091rS7 c20091rS7, C14189hV6 c14189hV6, AbstractC2383g abstractC2383g, List list, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC10533bm0.b(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10370d(fileReference, str, c20091rS7, abstractC2383g, list, c14189hV6, peersStruct$ExPeer, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u6(C10366bX6 c10366bX6) {
        AbstractC13042fc3.i(c10366bX6, "this$0");
        return (c10366bX6.h.H4() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) + 900;
    }

    private final Object v2(PeersStruct$ExPeer peersStruct$ExPeer, FileReference fileReference, String str, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list, AbstractC2383g abstractC2383g, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.c.o(peersStruct$ExPeer, h3(fileReference, str, c20091rS7, abstractC2383g, list), c14189hV6, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.tgwidgets.editor.messenger.H v4(long j) {
        Object next;
        Iterator it = this.B0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((QQ6) ((C17428mw7) next).f()).i() == j) {
                break;
            }
        }
        C17428mw7 c17428mw7 = (C17428mw7) next;
        if (c17428mw7 != null) {
            return (ir.nasim.tgwidgets.editor.messenger.H) c17428mw7.j();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(Map map) {
        for (List list : map.values()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((QQ6) it.next()).e() == EnumC14144hQ6.c) {
                        ((QQ6) AbstractC15401jX0.C0(list)).J(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    private final Object x2(FileReference fileReference, String str, C20091rS7 c20091rS7, C14189hV6 c14189hV6, AbstractC2383g abstractC2383g, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC10533bm0.b(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10371e(fileReference, str, c20091rS7, abstractC2383g, list, c14189hV6, null), 2, null);
    }

    private final InterfaceC13730gj3 y2(FileReference fileReference, String str, long j, String str2, C20091rS7 c20091rS7, C14189hV6 c14189hV6, List list) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10372f(j, str, fileReference, str2, c20091rS7, c14189hV6, list, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoryStruct$UserPrivacyConfig y3(ZI7 zi7) {
        StoryStruct$UserPrivacyConfig.a aVarNewBuilder = StoryStruct$UserPrivacyConfig.newBuilder();
        int i = C10369c.b[zi7.a().ordinal()];
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.B(i != 1 ? i != 2 ? i != 3 ? EnumC21337tU6.UNRECOGNIZED : EnumC21337tU6.ExceptionType_Include : EnumC21337tU6.ExceptionType_Exclude : EnumC21337tU6.ExceptionType_Contact).A(zi7.c()).C(zi7.d()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (StoryStruct$UserPrivacyConfig) generatedMessageLiteA;
    }

    public final InterfaceC10258bL6 A3() {
        return this.D0;
    }

    public final boolean A4() {
        return this.c.N();
    }

    public final int B3() {
        return this.k1;
    }

    public final InterfaceC10258bL6 B4() {
        return this.J0;
    }

    public final InterfaceC13730gj3 C2(String str, long j, PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(peersStruct$ExPeer, "exPeer");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C10373g(str, peersStruct$ExPeer, j, null), 3, null);
    }

    public final HashMap C3() {
        return this.j1;
    }

    public final String C4() {
        return this.e.h();
    }

    public final boolean D3() {
        return this.c.x();
    }

    public final void D5(String str) {
        AbstractC13042fc3.i(str, "storyId");
        C23144wQ6.a.d(str);
    }

    public final InterfaceC13730gj3 E2(FileReference fileReference, HS7 hs7, boolean z, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(interfaceC14603iB2, "onDownloaded");
        AbstractC13042fc3.i(ua2, "onDownloadFailed");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C10376j(hs7, this, fileReference, interfaceC14603iB2, z, ua2, null), 3, null);
    }

    public final InterfaceC4557Fq2 E3(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        FileReference fileReferenceD3 = d3(qq6);
        if (fileReferenceD3 == null) {
            return null;
        }
        return new C10389w(this.j.g(fileReferenceD3, qq6.G()));
    }

    public final boolean E4() {
        return this.e.i();
    }

    public final InterfaceC10040ay6 F3() {
        return this.c1;
    }

    public final String F4() {
        return this.c.P();
    }

    public final void F5(String str) {
        AbstractC13042fc3.i(str, "storyId");
        C23144wQ6.a.c(str);
    }

    public final Object G2(QQ6 qq6, HS7 hs7, boolean z, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
        FileReference fileReferenceD3 = d3(qq6);
        if (fileReferenceD3 == null) {
            return null;
        }
        Object objH2 = H2(fileReferenceD3, hs7, z, new C10377k(qq6, fileReferenceD3, this, interfaceC14603iB2, null), new C10378l(sa2), z2, interfaceC20295rm1);
        return objH2 == AbstractC14862ic3.e() ? objH2 : C19938rB7.a;
    }

    public final String G3() {
        return this.b1;
    }

    public final InterfaceC10040ay6 G4() {
        return this.S0;
    }

    public final void G5(QQ6 qq6) {
        int i;
        AbstractC13042fc3.i(qq6, "storyItem");
        HashMap map = new HashMap();
        map.put("story_id", qq6.l());
        map.put("widget_type", "link");
        switch (C10369c.e[AbstractC24369yV6.c(qq6).c().ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 6:
                i = 0;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        map.put("story_type", Integer.valueOf(i));
        map.put("action_type", 1);
        this.f.d("story_widget", map);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H2(ir.nasim.core.modules.file.entity.FileReference r17, ir.nasim.HS7 r18, boolean r19, ir.nasim.InterfaceC15796kB2 r20, ir.nasim.UA2 r21, boolean r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.H2(ir.nasim.core.modules.file.entity.FileReference, ir.nasim.HS7, boolean, ir.nasim.kB2, ir.nasim.UA2, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 H3() {
        return this.D;
    }

    public final C17628nH7 H4() {
        return this.M0;
    }

    public final void H5(InterfaceC10294bP6 interfaceC10294bP6) {
        AbstractC13042fc3.i(interfaceC10294bP6, "storyAdderEvents");
        C22548vQ6 c22548vQ6 = this.Y0;
        if (c22548vQ6 != null) {
            c22548vQ6.e(interfaceC10294bP6);
            C23144wQ6 c23144wQ6 = C23144wQ6.a;
            int iD = c22548vQ6.d();
            int iE = interfaceC10294bP6.e();
            String strC = interfaceC10294bP6.c();
            Integer numB = interfaceC10294bP6.b();
            Integer numH = interfaceC10294bP6.h();
            String strA = interfaceC10294bP6.a();
            Integer numValueOf = Integer.valueOf(c22548vQ6.c());
            if (numValueOf.intValue() == T3().getId()) {
                numValueOf = null;
            }
            c23144wQ6.i(iD, iE, strC, numB, numH, (128 & 32) != 0 ? "" : strA, (128 & 64) != 0 ? null : numValueOf, (128 & 128) != 0 ? null : null, (128 & 256) != 0 ? null : this.i1.getType());
        }
    }

    public final List I3() {
        return (List) this.d1.getValue();
    }

    public final List I4(C11692dR6 c11692dR6) {
        ArrayList arrayList;
        AbstractC13042fc3.i(c11692dR6, "storyKey");
        C18502om c18502om = this.A;
        if (c18502om == null) {
            return AbstractC10360bX0.m();
        }
        C12335eR6 c12335eR6D = c18502om.d();
        if (AbstractC13042fc3.d(c12335eR6D != null ? c12335eR6D.b() : null, c11692dR6)) {
            return AbstractC10360bX0.g(Integer.valueOf(c18502om.d().b().a()));
        }
        List listC = c18502om.c();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C12335eR6) it.next()).b());
        }
        if (arrayList2.contains(c11692dR6)) {
            List listC2 = c18502om.c();
            arrayList = new ArrayList(AbstractC10976cX0.x(listC2, 10));
            Iterator it2 = listC2.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((C12335eR6) it2.next()).b().a()));
            }
        } else {
            List listB = c18502om.b();
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(listB, 10));
            Iterator it3 = listB.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((C12335eR6) it3.next()).b());
            }
            if (arrayList3.contains(c11692dR6)) {
                List listB2 = c18502om.b();
                arrayList = new ArrayList(AbstractC10976cX0.x(listB2, 10));
                Iterator it4 = listB2.iterator();
                while (it4.hasNext()) {
                    arrayList.add(Integer.valueOf(((C12335eR6) it4.next()).b().a()));
                }
            } else {
                List listE = c18502om.e();
                ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(listE, 10));
                Iterator it5 = listE.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(((C12335eR6) it5.next()).b());
                }
                if (arrayList4.contains(c11692dR6)) {
                    List listE2 = c18502om.e();
                    arrayList = new ArrayList(AbstractC10976cX0.x(listE2, 10));
                    Iterator it6 = listE2.iterator();
                    while (it6.hasNext()) {
                        arrayList.add(Integer.valueOf(((C12335eR6) it6.next()).b().a()));
                    }
                } else {
                    List listF = c18502om.f();
                    ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(listF, 10));
                    Iterator it7 = listF.iterator();
                    while (it7.hasNext()) {
                        arrayList5.add(((C12335eR6) it7.next()).b());
                    }
                    if (!arrayList5.contains(c11692dR6)) {
                        return AbstractC10360bX0.m();
                    }
                    List listF2 = c18502om.f();
                    arrayList = new ArrayList(AbstractC10976cX0.x(listF2, 10));
                    Iterator it8 = listF2.iterator();
                    while (it8.hasNext()) {
                        arrayList.add(Integer.valueOf(((C12335eR6) it8.next()).b().a()));
                    }
                }
            }
        }
        return arrayList;
    }

    public final void I5() {
        C23144wQ6.a.l();
    }

    public final boolean J3() {
        return this.c.C();
    }

    public final void J4() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new G(null), 3, null);
    }

    public final C14733iO2 K3(int i) {
        return (C14733iO2) AbstractC5969Lp4.b().n(i);
    }

    public final androidx.lifecycle.r K4() {
        return this.Q0;
    }

    public final void K5(int i) {
        this.k1 = i;
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        super.L0();
        this.p.i(this.t1);
    }

    public final boolean L3() {
        return this.h.t2();
    }

    public final int L4() {
        return ((Number) this.f1.getValue()).intValue();
    }

    public final void L5() {
        this.c.Y();
    }

    public final boolean M2() {
        return this.B0.isEmpty();
    }

    public final Object M4(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new H(qq6, this, null), interfaceC20295rm1);
    }

    public final void M5() {
        this.c.b0();
    }

    public final boolean N2() {
        return this.h.b0() == X9.d.j() || this.h.i4() == FP6.e.j();
    }

    public final String N3() {
        return this.o1;
    }

    public final InterfaceC10258bL6 N4() {
        return this.L0;
    }

    public final void N5() {
        this.h.W6(true);
    }

    public final void O2() {
        this.y.e();
    }

    public final InterfaceC10258bL6 O3() {
        return this.O0;
    }

    public final InterfaceC4557Fq2 O4() {
        return new I(this.c.Q());
    }

    public final void O5(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.o1 = str;
    }

    public final InterfaceC13730gj3 P2(StoryWidget.LinkWidget linkWidget) {
        AbstractC13042fc3.i(linkWidget, "widget");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C10382p(linkWidget, null), 3, null);
    }

    public final int P3() {
        return this.q1;
    }

    public final InterfaceC4557Fq2 P4(String str) {
        AbstractC13042fc3.i(str, "storyId");
        return AbstractC9395Zt0.a(p3(str), AbstractC9773aX7.a(this));
    }

    public final void P5(int i) {
        this.q1 = i;
    }

    public final void Q2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.E0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final boolean Q3() {
        return this.X0;
    }

    public final void Q5(boolean z) {
        this.X0 = z;
    }

    public final void R2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.G0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, FQ6.c.a));
    }

    public final InterfaceC10258bL6 R3() {
        return this.W0;
    }

    public final int R4() {
        return this.r1;
    }

    public final InterfaceC13730gj3 R5(String str) {
        AbstractC13042fc3.i(str, "msg");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new V(str, null), 3, null);
    }

    public final void S5(int i, ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, "exPeer");
        this.i1 = (PeersStruct$ExPeer) this.n.a(new ExPeer(exPeerType, i));
    }

    public final PeersStruct$ExPeer T3() {
        Object value = this.g1.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (PeersStruct$ExPeer) value;
    }

    public final void T5(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "exPeer");
        this.i1 = peersStruct$ExPeer;
    }

    public final void U5() {
        this.e.k();
    }

    public final InterfaceC13730gj3 V4() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new J(null), 2, null);
    }

    public final void V5() {
        this.c.f0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W2(ir.nasim.tgwidgets.editor.ui.stories.recorder.l r42, ir.nasim.tgwidgets.editor.messenger.H r43) {
        /*
            r41 = this;
            r12 = r41
            r13 = r42
            r14 = r43
            java.lang.String r0 = "entry"
            ir.nasim.AbstractC13042fc3.i(r13, r0)
            java.lang.String r0 = "videoEditedInfo"
            ir.nasim.AbstractC13042fc3.i(r14, r0)
            long r0 = r14.q
            java.io.File r2 = r13.I
            r3 = 0
            if (r2 == 0) goto L41
            java.lang.String r2 = r2.getPath()
            if (r2 == 0) goto L41
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)
            ir.nasim.XV4 r4 = ir.nasim.C10366bX6.y1
            java.lang.Object r5 = r4.e()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Object r4 = r4.f()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            android.graphics.Bitmap r2 = ir.nasim.V13.o(r2, r5, r4)
            byte[] r2 = ir.nasim.V13.i(r2)
            r8 = r2
            goto L42
        L41:
            r8 = r3
        L42:
            ai.bale.proto.PeersStruct$ExPeer r2 = r41.i4()
            ir.nasim.rS7 r4 = new ir.nasim.rS7
            ir.nasim.tR6 r5 = ir.nasim.EnumC21310tR6.e
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MICROSECONDS
            long r0 = r6.toSeconds(r0)
            float r0 = (float) r0
            r4.<init>(r5, r0)
            ir.nasim.qV6 r0 = r13.g
            if (r0 == 0) goto L71
            boolean r1 = r0.e()
            if (r1 == 0) goto L5f
            goto L60
        L5f:
            r0 = r3
        L60:
            if (r0 == 0) goto L71
            ir.nasim.hV6 r1 = new ir.nasim.hV6
            int r3 = r0.d()
            boolean r0 = r0.f()
            r1.<init>(r3, r0)
            r5 = r1
            goto L72
        L71:
            r5 = r3
        L72:
            ir.nasim.rR6 r0 = new ir.nasim.rR6
            r0.<init>()
            ir.nasim.qR6 r1 = r13.f
            java.lang.String r3 = "storyLinkEditor"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.util.List r6 = r0.a(r1)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r10 = 320(0x140, float:4.48E-43)
            r11 = 0
            r1 = 0
            r9 = 0
            r15 = 0
            r0 = r41
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            r9 = r15
            ir.nasim.QQ6 r16 = m3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            java.io.File r0 = r13.q
            java.lang.String r37 = r0.getPath()
            r39 = 786431(0xbffff, float:1.102025E-39)
            r40 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            ir.nasim.QQ6 r0 = ir.nasim.QQ6.c(r16, r17, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r12.z2(r0)
            java.io.File r1 = r13.K
            java.lang.String r1 = r1.getPath()
            r14.y = r1
            r12.D2(r0, r14)
            long r0 = r0.i()
            r12.s6(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10366bX6.W2(ir.nasim.tgwidgets.editor.ui.stories.recorder.l, ir.nasim.tgwidgets.editor.messenger.H):void");
    }

    public final int W3() {
        return this.s;
    }

    public final void W5() {
        this.c.g0();
    }

    public final InterfaceC3346Am2 X3() {
        if (this.n1 == this.j1.size() - 1) {
            this.n1 = 0;
        } else {
            this.n1++;
        }
        return (InterfaceC3346Am2) this.j1.get(Integer.valueOf(this.n1));
    }

    public final void X5(String str) {
        this.c.h0(str);
    }

    public final void Y4() {
        this.x.f();
    }

    public final void Y5(ZI7 zi7) {
        AbstractC13042fc3.i(zi7, "userPrivacyConfig");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new W(zi7, null), 3, null);
    }

    public final InterfaceC10040ay6 Z3() {
        return this.Y;
    }

    public final boolean Z4(String str) {
        AbstractC13042fc3.i(str, "fileAddress");
        Object[] array = EnumC21310tR6.j().toArray(new EnumC21310tR6[0]);
        ArrayList<EnumC21310tR6> arrayList = new ArrayList();
        for (Object obj : array) {
            if (true ^ ((EnumC21310tR6) obj).r()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (EnumC21310tR6 enumC21310tR6 : arrayList) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (AbstractC20153rZ6.C(lowerCase, enumC21310tR6.p(), false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC13730gj3 Z5(C11692dR6 c11692dR6) {
        AbstractC13042fc3.i(c11692dR6, "storyKey");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new X(c11692dR6, null), 3, null);
    }

    public final void a4(String str) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10391y(str, null), 2, null);
    }

    public final boolean a5() {
        return this.h1;
    }

    public final void a6(boolean z) {
        this.c.i0(z ? InterfaceC22036uZ3.b.a : InterfaceC22036uZ3.a.a);
    }

    public final ZI7 b4(EnumC5052Hr5 enumC5052Hr5) {
        AbstractC13042fc3.i(enumC5052Hr5, "type");
        List<ZI7> list = this.l1;
        if (list.isEmpty()) {
            return new ZI7(EnumC5052Hr5.a, 0, null, false, 14, null);
        }
        for (ZI7 zi7 : list) {
            if (zi7.a() == enumC5052Hr5) {
                this.m1 = zi7.c();
                return zi7;
            }
        }
        return new ZI7(EnumC5052Hr5.a, 0, null, false, 14, null);
    }

    public final void b6(int i) {
        this.r1 = i;
    }

    public final boolean c6() {
        return C8386Vt0.Bb() && this.d.d() < 3 && !this.v1;
    }

    public final InterfaceC10258bL6 d4() {
        return this.F0;
    }

    public final void d6() {
        this.x.i();
    }

    public final int e4() {
        return ((Number) this.e1.getValue()).intValue();
    }

    public final InterfaceC10040ay6 f4() {
        return AbstractC6459Nq2.b(this.z);
    }

    public final void g4() {
        C19406qI3.a("story", "G S C VM", new Object[0]);
        if (!this.B0.isEmpty()) {
            C19406qI3.a("story", "R F G S", new Object[0]);
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10392z(null), 2, null);
        }
    }

    public final List g5() {
        if (S3().k() == null) {
            return AbstractC10360bX0.m();
        }
        List listK = S3().k();
        AbstractC13042fc3.f(listK);
        return listK;
    }

    public final void g6() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.K0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
    }

    public final void h6(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        o6(qq6.i(), YK6.a);
        f6(qq6.i());
        if (qq6.G()) {
            s6(qq6.i());
        } else {
            U2(qq6);
        }
    }

    public final PeersStruct$ExPeer i4() {
        return this.i1;
    }

    public final boolean j4() {
        return this.e.g();
    }

    public final void j6() {
        if (X9.b.a(this.h.b0()) == X9.d) {
            i6();
        }
    }

    public final void k3(PeersStruct$ExPeer peersStruct$ExPeer, long j) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "exPeer");
        QQ6 qq6M3 = m3(this, null, peersStruct$ExPeer, null, null, null, Boolean.TRUE, Long.valueOf(j), null, null, 413, null);
        D2(qq6M3, null);
        z2(qq6M3);
    }

    public final void k5() {
        this.v1 = true;
        JX7 jx7 = this.d;
        jx7.g(jx7.d() + 1);
    }

    public final void k6(QQ6 qq6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.N0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, qq6));
    }

    public final void l6() {
        int i = C10369c.d[FP6.b.a(this.h.i4()).ordinal()];
        if (i == 1) {
            this.h.G7(FP6.d.j());
            return;
        }
        if (i == 2) {
            this.h.G7(FP6.e.j());
        } else if (i == 3) {
            this.h.G7(FP6.f.j());
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final C22548vQ6 m4() {
        return this.Y0;
    }

    public final void n5(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        f6(qq6.i());
        Iterator it = this.B0.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((QQ6) ((C17428mw7) it.next()).f()).i() == qq6.i()) {
                break;
            } else {
                i++;
            }
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
        }
        this.M0.c(qq6.i());
        p5(qq6.l());
    }

    public final InterfaceC10258bL6 o4() {
        return this.H0;
    }

    public final void o5(String str) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new O(str, null), 3, null);
    }

    public final List p4(int i) {
        List list;
        Iterator it = this.A0.entrySet().iterator();
        do {
            list = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((C11692dR6) entry.getKey()).a() == i) {
                list = (List) entry.getValue();
            }
        } while (list == null);
        return list == null ? new ArrayList() : list;
    }

    public final void p6(String str, PeersStruct$ExPeer peersStruct$ExPeer, C14189hV6 c14189hV6, List list, Object obj) {
        AbstractC13042fc3.i(str, "imagePath");
        AbstractC13042fc3.i(peersStruct$ExPeer, "exPeer");
        QQ6 qq6M3 = m3(this, str, peersStruct$ExPeer, null, c14189hV6, list, null, null, null, obj, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER, null);
        D2(qq6M3, null);
        z2(qq6M3);
        W4();
        U2(qq6M3);
    }

    public final InterfaceC4557Fq2 q4(int i) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.j(new C(i, null)), C12366eV1.b());
    }

    public final InterfaceC9336Zm4 r4() {
        return this.z0;
    }

    public final void s3() {
        this.e.d();
    }

    public final InterfaceC13730gj3 t3(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "currentStory");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new C10386t(qq6, null), 2, null);
    }

    public final boolean t4() {
        return this.c.K();
    }

    public final void t5(String str, OP5 op5, String str2) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(str2, "description");
        z5();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new R(str, str2, op5, null), 3, null);
    }

    public final InterfaceC4557Fq2 t6() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.R(new d0(null)), C12366eV1.b());
    }

    public final void u3(List list) {
        AbstractC13042fc3.i(list, "fileReferences");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10387u((FileReference) it.next(), null), 2, null);
        }
    }

    public final EnumC23779xV6 u4(int i) {
        EnumC23779xV6 enumC23779xV6C;
        Iterator it = this.A0.entrySet().iterator();
        do {
            enumC23779xV6C = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((C11692dR6) entry.getKey()).a() == i) {
                enumC23779xV6C = ((C11692dR6) entry.getKey()).c();
            }
        } while (enumC23779xV6C == null);
        return enumC23779xV6C == null ? EnumC23779xV6.a : enumC23779xV6C;
    }

    public final void u5() {
        this.n1 = 0;
    }

    public final List v3(List list, String str) {
        AbstractC13042fc3.i(list, "storyList");
        AbstractC13042fc3.i(str, "selectedStoryId");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            QQ6 qq6 = (QQ6) it.next();
            if (AbstractC13042fc3.d(qq6.l(), str)) {
                return AbstractC10360bX0.s(qq6);
            }
        }
        return new ArrayList();
    }

    public final void v5() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.B;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final InterfaceC13730gj3 w3() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new C10388v(null), 2, null);
    }

    public final InterfaceC13730gj3 w4(String str, int i, int i2) {
        AbstractC13042fc3.i(str, "storyId");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new E(str, i, i2, null), 2, null);
    }

    public final void w5() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.V0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final QQ6 x3(int i) {
        QQ6 qq6;
        Iterator it = this.p1.entrySet().iterator();
        do {
            qq6 = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((C11692dR6) entry.getKey()).a() == i) {
                qq6 = (QQ6) entry.getValue();
            }
        } while (qq6 == null);
        return qq6;
    }

    public final InterfaceC10040ay6 x4() {
        return this.H;
    }

    public final void x5(int i, int i2) {
        this.Y0 = new C22548vQ6(AbstractC17026mG5.a.j(0, Integer.MAX_VALUE), i, i2, null);
    }

    public final InterfaceC13730gj3 y4(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new F(qq6, null), 2, null);
    }

    public final void y5() {
        C19406qI3.a("story", "resetVideoEditedPathFlow", new Object[0]);
    }

    public final void z2(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        C11692dR6 c11692dR6C = AbstractC24369yV6.c(qq6);
        if (this.A0.containsKey(c11692dR6C)) {
            List list = (List) this.A0.get(c11692dR6C);
            if (list != null) {
                list.add(qq6);
            }
        } else {
            this.A0.put(c11692dR6C, AbstractC10360bX0.s(qq6));
        }
        m6();
    }

    public final File z3(String str) {
        AbstractC13042fc3.i(str, "format");
        File file = new File(C4053Dm2.u());
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return new File(file.getPath() + File.separator + "capture_" + C20590sG5.a() + Separators.DOT + str);
    }

    public final InterfaceC10040ay6 z4() {
        return this.U0;
    }

    public final void z5() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.K0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
    }
}
