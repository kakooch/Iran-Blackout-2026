package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Size;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC14329hk1;
import ir.nasim.AbstractC23884xg6;
import ir.nasim.AbstractC3336Al1;
import ir.nasim.C21015sz4;
import ir.nasim.C21181tF2;
import ir.nasim.C21191tG3;
import ir.nasim.C21864uG2;
import ir.nasim.C6918Pn5;
import ir.nasim.C8721Xa6;
import ir.nasim.CV7;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC17266mg5;
import ir.nasim.InterfaceC18963pY7;
import ir.nasim.InterfaceC19554qY7;
import ir.nasim.RY1;
import ir.nasim.XE4;
import ir.nasim.core.modules.file.audio.audiofocus.a;
import ir.nasim.core.modules.file.audio.audiofocus.c;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.conversation.sharedmedia.old.SharedMediaActivity;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sz4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21015sz4 extends VW7 {
    private static final C21017b N0 = new C21017b(null);
    private final ExPeerType A;
    private com.google.android.exoplayer2.E0 A0;
    private final EnumC24384yX3 B;
    private final InterfaceC9336Zm4 B0;
    private final InterfaceC9336Zm4 C0;
    private final InterfaceC18963pY7 D;
    private final InterfaceC9336Zm4 D0;
    private final InterfaceC10258bL6 E0;
    private final InterfaceC10258bL6 F0;
    private final AbstractC23884xg6 G;
    private final HashMap G0;
    private final C6918Pn5 H;
    private final InterfaceC9336Zm4 H0;
    private final InterfaceC10258bL6 I0;
    private final C21191tG3 J;
    private final InterfaceC10258bL6 J0;
    private final InterfaceC4557Fq2 K0;
    private final InterfaceC9336Zm4 L0;
    private final InterfaceC10258bL6 M0;
    private final C21864uG2 Y;
    private final C8244Vd2 Z;
    private final int b;
    private final C14970in2 c;
    private final SettingsModule d;
    private final InterfaceC12532em2 e;
    private final InterfaceC11621dJ7 f;
    private final com.google.android.exoplayer2.E0 g;
    private final C7009Px6 h;
    private final VK4 i;
    private final HC6 j;
    private final C13590gU7 k;
    private final C22445vF2 l;
    private final AbstractC13778go1 m;
    private final AbstractC13778go1 n;
    private final C8721Xa6 o;
    private final C21181tF2 p;
    private final AbstractC13778go1 q;
    private final DF2 r;
    private final C16220ku1 s;
    private final C3535Bg6 t;
    private final C24440yd2 u;
    private final QF2 v;
    private final C10249bK6 w;
    private final C23620xE0 x;
    private final C14494i07 y;
    private final C11458d25 z;
    private boolean z0;

    /* renamed from: ir.nasim.sz4$A */
    static final class A extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            boolean z;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            XV4 xv4 = (XV4) this.c;
            C12486eh6 c12486eh6 = (C12486eh6) this.d;
            long jLongValue = ((Number) xv4.a()).longValue();
            long jLongValue2 = ((Number) xv4.b()).longValue();
            List listA = c12486eh6.a();
            boolean z2 = false;
            List<AbstractC23884xg6> listSubList = listA.subList(AbstractC23053wG5.e(listA.size() - 3, 0), listA.size());
            if ((listSubList instanceof Collection) && listSubList.isEmpty()) {
                z = false;
            } else {
                for (AbstractC23884xg6 abstractC23884xg6 : listSubList) {
                    if (abstractC23884xg6.p() == jLongValue && abstractC23884xg6.i() == jLongValue2) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            List listSubList2 = listA.subList(0, AbstractC23053wG5.i(3, listA.size()));
            if (!(listSubList2 instanceof Collection) || !listSubList2.isEmpty()) {
                Iterator it = listSubList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AbstractC23884xg6 abstractC23884xg62 = (AbstractC23884xg6) it.next();
                    if (abstractC23884xg62.p() == jLongValue && abstractC23884xg62.i() == jLongValue2) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z && z2) {
                C21015sz4.this.Y.l();
            } else if (z) {
                C21015sz4.this.Y.m();
            } else if (z2) {
                C21015sz4.this.Y.k();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(XV4 xv4, C12486eh6 c12486eh6, InterfaceC20295rm1 interfaceC20295rm1) {
            A a = C21015sz4.this.new A(interfaceC20295rm1);
            a.c = xv4;
            a.d = c12486eh6;
            return a.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        B(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            B b = C21015sz4.this.new B(interfaceC20295rm1);
            b.c = obj;
            return b;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC23884xg6 abstractC23884xg6 = (AbstractC23884xg6) ((C17428mw7) this.c).b();
            C21015sz4.this.J.r(C21015sz4.this.z, abstractC23884xg6.p(), abstractC23884xg6.i(), true);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C17428mw7 c17428mw7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(c17428mw7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ C12889fL5 d;
        final /* synthetic */ com.google.android.exoplayer2.E0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(C12889fL5 c12889fL5, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12889fL5;
            this.e = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C c = new C(this.d, this.e, interfaceC20295rm1);
            c.c = obj;
            return c;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            XE4 xe4 = (XE4) this.c;
            if (xe4 == null) {
                if (AbstractC13042fc3.d(this.d.a, AbstractC6392Nk0.a(true))) {
                    this.e.q();
                }
                this.d.a = null;
            } else if (xe4.a()) {
                this.d.a = AbstractC6392Nk0.a(this.e.X());
                this.e.h();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(XE4 xe4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(xe4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C21015sz4 e;

        /* renamed from: ir.nasim.sz4$D$b */
        static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    PlaybackException playbackExceptionD = ((C11068cg5) this.d).d();
                    if (playbackExceptionD != null) {
                        this.c = null;
                        this.b = 1;
                        if (interfaceC4806Gq2.a(playbackExceptionD, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, C11068cg5 c11068cg5, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1);
                bVar.c = interfaceC4806Gq2;
                bVar.d = c11068cg5;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$D$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ com.google.android.exoplayer2.E0 d;
            final /* synthetic */ C21015sz4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(com.google.android.exoplayer2.E0 e0, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = e0;
                this.e = c21015sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    PlaybackException playbackException = (PlaybackException) this.c;
                    int i2 = playbackException.a;
                    if (i2 == 2001 || i2 == 2002) {
                        if (this.d.X()) {
                            C21015sz4 c21015sz4 = this.e;
                            com.google.android.exoplayer2.E0 e0 = this.d;
                            this.b = 1;
                            if (c21015sz4.c2(e0, this) == objE) {
                                return objE;
                            }
                        }
                    } else if (i2 != 3001) {
                        C19406qI3.c("NewVideoPlayerViewModel", "Unhandled error(" + playbackException.e() + Separators.RPAREN, playbackException);
                        this.d.r();
                    } else {
                        this.d.r();
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
            public final Object invoke(PlaybackException playbackException, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(playbackException, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D(InterfaceC4557Fq2 interfaceC4557Fq2, com.google.android.exoplayer2.E0 e0, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = e0;
            this.e = c21015sz4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new D(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(AbstractC6459Nq2.x(this.c, new C25226zw5() { // from class: ir.nasim.sz4.D.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return ((C11068cg5) obj2).d();
                    }
                }), new b(null));
                c cVar = new c(this.d, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S0, cVar, this) == objE) {
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
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        E(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            E e = new E(interfaceC20295rm1);
            e.c = obj;
            return e;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((C11068cg5) this.c).l());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C11068cg5 c11068cg5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(c11068cg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ boolean c;

        F(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            F f = C21015sz4.this.new F(interfaceC20295rm1);
            f.c = ((Boolean) obj).booleanValue();
            return f;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                a.C0992a c0992a = ir.nasim.core.modules.file.audio.audiofocus.a.h;
                if (!c0992a.a().d(C21015sz4.this.Z)) {
                    c0992a.a().e(C21015sz4.this.Z);
                }
            }
            return C19938rB7.a;
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$G */
    static final class G extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ com.google.android.exoplayer2.E0 e;

        /* renamed from: ir.nasim.sz4$G$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC18448og5.values().length];
                try {
                    iArr[EnumC18448og5.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC18448og5.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC18448og5.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        G(com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            G g = C21015sz4.this.new G(this.e, interfaceC20295rm1);
            g.c = obj;
            return g;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            int i = a.a[((EnumC18448og5) this.c).ordinal()];
            if (i == 1) {
                C21015sz4.this.k.i();
            } else if (i == 2) {
                C21015sz4.this.k.m(true, this.e);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                C21015sz4.this.k.m(false, this.e);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EnumC18448og5 enumC18448og5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((G) create(enumC18448og5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;

        /* renamed from: ir.nasim.sz4$H$a */
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
                return (AbstractC23884xg6) ((C17428mw7) this.c).b();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17428mw7 c17428mw7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c17428mw7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$H$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ com.google.android.exoplayer2.E0 e;
            final /* synthetic */ C21015sz4 f;

            /* renamed from: ir.nasim.sz4$H$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ com.google.android.exoplayer2.E0 d;
                final /* synthetic */ C21015sz4 e;
                final /* synthetic */ AbstractC23884xg6 f;
                final /* synthetic */ boolean g;

                /* renamed from: ir.nasim.sz4$H$b$a$a, reason: collision with other inner class name */
                static final class C1553a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    int c;
                    private /* synthetic */ Object d;
                    final /* synthetic */ AbstractC23884xg6 e;
                    final /* synthetic */ C21015sz4 f;
                    final /* synthetic */ boolean g;
                    final /* synthetic */ com.google.android.exoplayer2.E0 h;

                    /* renamed from: ir.nasim.sz4$H$b$a$a$a, reason: collision with other inner class name */
                    static final class C1554a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        final /* synthetic */ C21015sz4 c;
                        final /* synthetic */ String d;
                        final /* synthetic */ InterfaceC14190hV7 e;
                        final /* synthetic */ com.google.android.exoplayer2.E0 f;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1554a(C21015sz4 c21015sz4, String str, InterfaceC14190hV7 interfaceC14190hV7, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.c = c21015sz4;
                            this.d = str;
                            this.e = interfaceC14190hV7;
                            this.f = e0;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            return new C1554a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            Object objE = AbstractC14862ic3.e();
                            int i = this.b;
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                C6918Pn5 c6918Pn5 = this.c.H;
                                String str = this.d;
                                InterfaceC14190hV7 interfaceC14190hV7 = this.e;
                                com.google.android.exoplayer2.E0 e0 = this.f;
                                this.b = 1;
                                if (c6918Pn5.g(str, interfaceC14190hV7, e0, this) == objE) {
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
                            return ((C1554a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* renamed from: ir.nasim.sz4$H$b$a$a$b, reason: collision with other inner class name */
                    static final class C1555b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        final /* synthetic */ C21015sz4 c;
                        final /* synthetic */ InterfaceC14190hV7 d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1555b(C21015sz4 c21015sz4, InterfaceC14190hV7 interfaceC14190hV7, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.c = c21015sz4;
                            this.d = interfaceC14190hV7;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            return new C1555b(this.c, this.d, interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            Object objE = AbstractC14862ic3.e();
                            int i = this.b;
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                C6918Pn5 c6918Pn5 = this.c.H;
                                InterfaceC14190hV7 interfaceC14190hV7 = this.d;
                                com.google.android.exoplayer2.E0 e0J2 = this.c.J2();
                                this.b = 1;
                                if (c6918Pn5.i(interfaceC14190hV7, e0J2, this) == objE) {
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
                            return ((C1555b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1553a(AbstractC23884xg6 abstractC23884xg6, C21015sz4 c21015sz4, boolean z, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.e = abstractC23884xg6;
                        this.f = c21015sz4;
                        this.g = z;
                        this.h = e0;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1553a c1553a = new C1553a(this.e, this.f, this.g, this.h, interfaceC20295rm1);
                        c1553a.d = obj;
                        return c1553a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        InterfaceC20315ro1 interfaceC20315ro1;
                        String str;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.c;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.d;
                            long jP = ((AbstractC23884xg6.c) this.e).p();
                            long jI = ((AbstractC23884xg6.c) this.e).i();
                            StringBuilder sb = new StringBuilder();
                            sb.append(jP);
                            sb.append(jI);
                            String string = sb.toString();
                            C3535Bg6 c3535Bg6 = this.f.t;
                            AbstractC23884xg6.c cVar = (AbstractC23884xg6.c) this.e;
                            this.d = interfaceC20315ro12;
                            this.b = string;
                            this.c = 1;
                            Object objC = c3535Bg6.a(cVar, this);
                            if (objC == objE) {
                                return objE;
                            }
                            interfaceC20315ro1 = interfaceC20315ro12;
                            str = string;
                            obj = objC;
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            String str2 = (String) this.b;
                            InterfaceC20315ro1 interfaceC20315ro13 = (InterfaceC20315ro1) this.d;
                            AbstractC10685c16.b(obj);
                            str = str2;
                            interfaceC20315ro1 = interfaceC20315ro13;
                        }
                        InterfaceC14190hV7 interfaceC14190hV7 = (InterfaceC14190hV7) obj;
                        if (this.g) {
                            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1554a(this.f, str, interfaceC14190hV7, this.h, null), 3, null);
                        }
                        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1555b(this.f, interfaceC14190hV7, null), 3, null);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1553a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(com.google.android.exoplayer2.E0 e0, C21015sz4 c21015sz4, AbstractC23884xg6 abstractC23884xg6, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = e0;
                    this.e = c21015sz4;
                    this.f = abstractC23884xg6;
                    this.g = z;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
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
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    this.d.D(true);
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1553a(this.f, this.e, this.g, this.d, null), 3, null);
                    this.e.U2(interfaceC20315ro1, this.d);
                    C21015sz4 c21015sz4 = this.e;
                    c21015sz4.S2(interfaceC20315ro1, c21015sz4.E0);
                    C21015sz4 c21015sz42 = this.e;
                    c21015sz42.R2(interfaceC20315ro1, c21015sz42.E0, this.d);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C12889fL5 c12889fL5, com.google.android.exoplayer2.E0 e0, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12889fL5;
                this.e = e0;
                this.f = c21015sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    AbstractC23884xg6 abstractC23884xg6 = (AbstractC23884xg6) this.c;
                    Object obj2 = this.d.a;
                    if (obj2 != null) {
                        AbstractC23884xg6.c cVar = (AbstractC23884xg6.c) obj2;
                        InterfaceC18505om2 interfaceC18505om2J = cVar != null ? cVar.j() : null;
                        C11920dm2 c11920dm2 = interfaceC18505om2J instanceof C11920dm2 ? (C11920dm2) interfaceC18505om2J : null;
                        if (c11920dm2 != null) {
                            this.f.c.m0(c11920dm2.b().getFileId(), c11920dm2.b().getAccessHash());
                        }
                        com.google.android.exoplayer2.E0 e0 = this.e;
                        e0.stop();
                        e0.t();
                        this.f.J2().stop();
                    }
                    if (!(abstractC23884xg6 instanceof AbstractC23884xg6.c)) {
                        this.d.a = null;
                        return C19938rB7.a;
                    }
                    boolean z = ((abstractC23884xg6 instanceof AbstractC23884xg6.a) || (this.d.a == null && AbstractC13042fc3.d(abstractC23884xg6, this.f.G) && this.e.p() != 1)) ? false : true;
                    this.d.a = abstractC23884xg6;
                    a aVar = new a(this.e, this.f, abstractC23884xg6, z, null);
                    this.b = 1;
                    if (AbstractC20906so1.e(aVar, this) == objE) {
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
            public final Object invoke(AbstractC23884xg6 abstractC23884xg6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(abstractC23884xg6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21015sz4.this.new H(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12889fL5 c12889fL5 = new C12889fL5();
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.X(C21015sz4.this.J0, new a(null)));
                b bVar = new b(c12889fL5, this.d, C21015sz4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, bVar, this) == objE) {
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
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$I */
    public static final class I implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ WA2 b;

        /* renamed from: ir.nasim.sz4$I$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC4557Fq2[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                super(0);
                this.e = interfaceC4557Fq2Arr;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new Object[this.e.length];
            }
        }

        /* renamed from: ir.nasim.sz4$I$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ WA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, WA2 wa2) {
                super(3, interfaceC20295rm1);
                this.e = wa2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objR;
                InterfaceC4806Gq2 interfaceC4806Gq2;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq22 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    WA2 wa2 = this.e;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    Object obj6 = objArr[4];
                    Object obj7 = objArr[5];
                    Object obj8 = objArr[6];
                    Object obj9 = objArr[7];
                    Object obj10 = objArr[8];
                    Object obj11 = objArr[9];
                    Object obj12 = objArr[10];
                    this.c = interfaceC4806Gq22;
                    this.b = 1;
                    Y73.c(6);
                    objR = wa2.r(obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, this);
                    Y73.c(7);
                    if (objR == objE) {
                        return objE;
                    }
                    interfaceC4806Gq2 = interfaceC4806Gq22;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    InterfaceC4806Gq2 interfaceC4806Gq23 = (InterfaceC4806Gq2) this.c;
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = interfaceC4806Gq23;
                    objR = obj;
                }
                this.c = null;
                this.b = 2;
                if (interfaceC4806Gq2.a(objR, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1, this.e);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public I(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, WA2 wa2) {
            this.a = interfaceC4557Fq2Arr;
            this.b = wa2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null, this.b), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sz4$J */
    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FragmentActivity d;
        final /* synthetic */ String e;
        final /* synthetic */ AbstractC23884xg6 f;
        final /* synthetic */ C8721Xa6.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(FragmentActivity fragmentActivity, String str, AbstractC23884xg6 abstractC23884xg6, C8721Xa6.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fragmentActivity;
            this.e = str;
            this.f = abstractC23884xg6;
            this.g = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21015sz4.this.new J(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8721Xa6 c8721Xa6 = C21015sz4.this.o;
                FragmentActivity fragmentActivity = this.d;
                String str = this.e;
                String strO = this.f.o();
                C8721Xa6.a aVar = this.g;
                this.b = 1;
                if (c8721Xa6.a(fragmentActivity, str, strO, aVar, this) == objE) {
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
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$K */
    public static final class K implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.sz4$K$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.sz4$K$a$a, reason: collision with other inner class name */
            public static final class C1556a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1556a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C21015sz4.K.a.C1556a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.sz4$K$a$a r0 = (ir.nasim.C21015sz4.K.a.C1556a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.sz4$K$a$a r0 = new ir.nasim.sz4$K$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.eh6 r5 = (ir.nasim.C12486eh6) r5
                    java.util.List r5 = r5.a()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.K.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public K(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sz4$L */
    public static final class L implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.sz4$L$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.sz4$L$a$a, reason: collision with other inner class name */
            public static final class C1557a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1557a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C21015sz4.L.a.C1557a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.sz4$L$a$a r0 = (ir.nasim.C21015sz4.L.a.C1557a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.sz4$L$a$a r0 = new ir.nasim.sz4$L$a$a
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
                    ir.nasim.eh6 r5 = (ir.nasim.C12486eh6) r5
                    int r5 = r5.b()
                    java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.L.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public L(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sz4$M */
    static final class M extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        M(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            XV4 xv4 = (XV4) this.c;
            List list = (List) this.d;
            long jLongValue = ((Number) xv4.a()).longValue();
            long jLongValue2 = ((Number) xv4.b()).longValue();
            Iterator it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                AbstractC23884xg6 abstractC23884xg6 = (AbstractC23884xg6) it.next();
                if (abstractC23884xg6.p() == jLongValue && abstractC23884xg6.i() == jLongValue2) {
                    break;
                }
                i++;
            }
            return new C17428mw7(AbstractC15401jX0.t0(list, i - 1), list.get(i), AbstractC15401jX0.t0(list, i + 1));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(XV4 xv4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            M m = new M(interfaceC20295rm1);
            m.c = xv4;
            m.d = list;
            return m.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$a, reason: case insensitive filesystem */
    static final class C21016a extends AbstractC19859r37 implements InterfaceC19342qB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ boolean e;
        /* synthetic */ Object f;
        /* synthetic */ int g;

        C21016a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(6, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C17428mw7 c17428mw7 = (C17428mw7) this.c;
            XE4 xe4 = (XE4) this.d;
            boolean z = this.e;
            RJ1 rj1 = (RJ1) this.f;
            return new C10776cA7(-1, this.g, xe4, (AbstractC3336Al1) c17428mw7.g(), (AbstractC3336Al1) c17428mw7.f(), (AbstractC3336Al1) c17428mw7.j(), rj1.b(), C21015sz4.this.K2(rj1, z));
        }

        @Override // ir.nasim.InterfaceC19342qB2
        public /* bridge */ /* synthetic */ Object j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return n((C17428mw7) obj, (XE4) obj2, ((Boolean) obj3).booleanValue(), (RJ1) obj4, ((Number) obj5).intValue(), (InterfaceC20295rm1) obj6);
        }

        public final Object n(C17428mw7 c17428mw7, XE4 xe4, boolean z, RJ1 rj1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            C21016a c21016a = C21015sz4.this.new C21016a(interfaceC20295rm1);
            c21016a.c = c17428mw7;
            c21016a.d = xe4;
            c21016a.e = z;
            c21016a.f = rj1;
            c21016a.g = i;
            return c21016a.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$b, reason: case insensitive filesystem */
    private static final class C21017b {
        private C21017b() {
        }

        public /* synthetic */ C21017b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sz4$c, reason: case insensitive filesystem */
    public /* synthetic */ class C21018c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC23696xM4.values().length];
            try {
                iArr[EnumC23696xM4.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23696xM4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC9274Zf5.values().length];
            try {
                iArr2[EnumC9274Zf5.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC9274Zf5.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC9274Zf5.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC9274Zf5.g.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.sz4$d, reason: case insensitive filesystem */
    static final class C21019d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ boolean c;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21019d(com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C21019d c21019d = new C21019d(this.d, interfaceC20295rm1);
            c21019d.c = ((Boolean) obj).booleanValue();
            return c21019d;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                this.d.q();
                C19406qI3.j("NewVideoPlayerViewModel", "autoPlayed after network is connected", new Object[0]);
            }
            return C19938rB7.a;
        }

        public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21019d) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$e, reason: case insensitive filesystem */
    static final class C21020e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.sz4$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21015sz4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21015sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(4000L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.c.Y2();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C21020e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C3345Am1 c3345Am1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                c3345Am1 = (C3345Am1) this.d;
                Boolean boolA = AbstractC6392Nk0.a(c3345Am1.h() || c3345Am1.g() || c3345Am1.c() || c3345Am1.d());
                this.c = c3345Am1;
                this.b = 1;
                if (interfaceC4806Gq2.a(boolA, this) == objE) {
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
                c3345Am1 = (C3345Am1) this.c;
                AbstractC10685c16.b(obj);
            }
            if (c3345Am1.h() && !c3345Am1.g() && !c3345Am1.c() && !c3345Am1.e() && !c3345Am1.d()) {
                a aVar = new a(C21015sz4.this, null);
                this.c = null;
                this.b = 2;
                if (AbstractC20906so1.e(aVar, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, C3345Am1 c3345Am1, InterfaceC20295rm1 interfaceC20295rm1) {
            C21020e c21020e = C21015sz4.this.new C21020e(interfaceC20295rm1);
            c21020e.c = interfaceC4806Gq2;
            c21020e.d = c3345Am1;
            return c21020e.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$f, reason: case insensitive filesystem */
    static final class C21021f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ AbstractC23884xg6 e;
        final /* synthetic */ C21015sz4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21021f(AbstractC23884xg6 abstractC23884xg6, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = abstractC23884xg6;
            this.f = c21015sz4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C21021f c21021f = new C21021f(this.e, this.f, interfaceC20295rm1);
            c21021f.d = obj;
            return c21021f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strH;
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq22 = (InterfaceC4806Gq2) this.d;
                strH = this.e.h();
                SpannableString spannableStringI = strH != null ? AbstractC17636nI6.i(strH) : null;
                this.d = interfaceC4806Gq22;
                this.b = strH;
                this.c = 1;
                if (interfaceC4806Gq22.a(spannableStringI, this) == objE) {
                    return objE;
                }
                interfaceC4806Gq2 = interfaceC4806Gq22;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                strH = (String) this.b;
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.d;
                AbstractC10685c16.b(obj);
            }
            if (strH != null) {
                C21015sz4 c21015sz4 = this.f;
                Spannable spannableF = AbstractC5730Kp.f(strH, c21015sz4.A, c21015sz4.z, null);
                if (spannableF != null) {
                    this.d = null;
                    this.b = null;
                    this.c = 2;
                    if (interfaceC4806Gq2.a(spannableF, this) == objE) {
                        return objE;
                    }
                    return C19938rB7.a;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21021f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$g, reason: case insensitive filesystem */
    public static final class C21022g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C21015sz4 b;
        final /* synthetic */ com.google.android.exoplayer2.E0 c;

        /* renamed from: ir.nasim.sz4$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C21015sz4 b;
            final /* synthetic */ com.google.android.exoplayer2.E0 c;

            /* renamed from: ir.nasim.sz4$g$a$a, reason: collision with other inner class name */
            public static final class C1558a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1558a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C21015sz4 c21015sz4, com.google.android.exoplayer2.E0 e0) {
                this.a = interfaceC4806Gq2;
                this.b = c21015sz4;
                this.c = e0;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r10, ir.nasim.InterfaceC20295rm1 r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof ir.nasim.C21015sz4.C21022g.a.C1558a
                    if (r0 == 0) goto L13
                    r0 = r11
                    ir.nasim.sz4$g$a$a r0 = (ir.nasim.C21015sz4.C21022g.a.C1558a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.sz4$g$a$a r0 = new ir.nasim.sz4$g$a$a
                    r0.<init>(r11)
                L18:
                    java.lang.Object r11 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L32
                    if (r2 != r3) goto L2a
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto Lbc
                L2a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L32:
                    ir.nasim.AbstractC10685c16.b(r11)
                    ir.nasim.Gq2 r11 = r9.a
                    ir.nasim.mw7 r10 = (ir.nasim.C17428mw7) r10
                    java.lang.Object r2 = r10.a()
                    ir.nasim.xg6 r2 = (ir.nasim.AbstractC23884xg6) r2
                    java.lang.Object r4 = r10.b()
                    ir.nasim.xg6 r4 = (ir.nasim.AbstractC23884xg6) r4
                    java.lang.Object r10 = r10.c()
                    ir.nasim.xg6 r10 = (ir.nasim.AbstractC23884xg6) r10
                    r5 = 0
                    if (r2 == 0) goto L65
                    ir.nasim.sz4 r6 = r9.b
                    java.util.HashMap r6 = ir.nasim.C21015sz4.j1(r6)
                    java.lang.Object r6 = r6.get(r2)
                    ir.nasim.Al1 r6 = (ir.nasim.AbstractC3336Al1) r6
                    if (r6 != 0) goto L66
                    ir.nasim.sz4 r6 = r9.b
                    com.google.android.exoplayer2.E0 r7 = r9.c
                    ir.nasim.Al1 r6 = ir.nasim.C21015sz4.c1(r6, r7, r2)
                    goto L66
                L65:
                    r6 = r5
                L66:
                    ir.nasim.sz4 r7 = r9.b
                    java.util.HashMap r7 = ir.nasim.C21015sz4.j1(r7)
                    java.lang.Object r7 = r7.get(r4)
                    ir.nasim.Al1 r7 = (ir.nasim.AbstractC3336Al1) r7
                    if (r7 != 0) goto L7c
                    ir.nasim.sz4 r7 = r9.b
                    com.google.android.exoplayer2.E0 r8 = r9.c
                    ir.nasim.Al1 r7 = ir.nasim.C21015sz4.c1(r7, r8, r4)
                L7c:
                    if (r10 == 0) goto L94
                    ir.nasim.sz4 r5 = r9.b
                    java.util.HashMap r5 = ir.nasim.C21015sz4.j1(r5)
                    java.lang.Object r5 = r5.get(r10)
                    ir.nasim.Al1 r5 = (ir.nasim.AbstractC3336Al1) r5
                    if (r5 != 0) goto L94
                    ir.nasim.sz4 r5 = r9.b
                    com.google.android.exoplayer2.E0 r8 = r9.c
                    ir.nasim.Al1 r5 = ir.nasim.C21015sz4.c1(r5, r8, r10)
                L94:
                    ir.nasim.sz4 r8 = r9.b
                    java.util.HashMap r8 = ir.nasim.C21015sz4.j1(r8)
                    r8.clear()
                    if (r2 == 0) goto La4
                    if (r6 == 0) goto La4
                    r8.put(r2, r6)
                La4:
                    r8.put(r4, r7)
                    if (r10 == 0) goto Lae
                    if (r5 == 0) goto Lae
                    r8.put(r10, r5)
                Lae:
                    ir.nasim.mw7 r10 = new ir.nasim.mw7
                    r10.<init>(r6, r7, r5)
                    r0.b = r3
                    java.lang.Object r10 = r11.a(r10, r0)
                    if (r10 != r1) goto Lbc
                    return r1
                Lbc:
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.C21022g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public C21022g(InterfaceC4557Fq2 interfaceC4557Fq2, C21015sz4 c21015sz4, com.google.android.exoplayer2.E0 e0) {
            this.a = interfaceC4557Fq2;
            this.b = c21015sz4;
            this.c = e0;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sz4$h, reason: case insensitive filesystem */
    static final class C21023h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ FileReference f;
        final /* synthetic */ boolean g;
        final /* synthetic */ AbstractC23884xg6 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21023h(FileReference fileReference, boolean z, AbstractC23884xg6 abstractC23884xg6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = fileReference;
            this.g = z;
            this.h = abstractC23884xg6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C21023h c21023h = C21015sz4.this.new C21023h(this.f, this.g, this.h, interfaceC20295rm1);
            c21023h.d = obj;
            return c21023h;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.C21023h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21023h) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$i, reason: case insensitive filesystem */
    static final class C21024i extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21024i(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21015sz4.this.x.c(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21015sz4.this.new C21024i(this.d, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$j, reason: case insensitive filesystem */
    static final class C21025j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC18505om2 e;
        final /* synthetic */ FragmentActivity f;
        final /* synthetic */ AbstractC23884xg6.c g;

        /* renamed from: ir.nasim.sz4$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21015sz4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21015sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                com.google.android.exoplayer2.E0 e0F2 = this.c.F2();
                if (e0F2 == null) {
                    return null;
                }
                e0F2.x(e0F2.D0());
                e0F2.h();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$j$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ InterfaceC18505om2 e;
            final /* synthetic */ InterfaceC16204ks5 f;
            final /* synthetic */ FragmentActivity g;
            final /* synthetic */ AbstractC23884xg6.c h;

            /* renamed from: ir.nasim.sz4$j$b$a */
            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC16204ks5 a;
                final /* synthetic */ InterfaceC20315ro1 b;
                final /* synthetic */ C21015sz4 c;
                final /* synthetic */ FragmentActivity d;
                final /* synthetic */ AbstractC23884xg6.c e;

                /* renamed from: ir.nasim.sz4$j$b$a$a, reason: collision with other inner class name */
                public static final class C1559a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ UA2 c;
                    final /* synthetic */ C21015sz4 d;
                    final /* synthetic */ FragmentActivity e;
                    final /* synthetic */ AbstractC23884xg6.c f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C1559a(UA2 ua2, C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = ua2;
                        this.d = c21015sz4;
                        this.e = fragmentActivity;
                        this.f = cVar;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1559a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object value;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            UA2 ua2 = this.c;
                            this.b = 1;
                            obj = ua2.invoke(this);
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
                        String str = (String) obj;
                        if (str != null) {
                            C8721Xa6 c8721Xa6 = this.d.o;
                            FragmentActivity fragmentActivity = this.e;
                            String strO = this.f.o();
                            C8721Xa6.a aVar = C8721Xa6.a.d;
                            this.b = 2;
                            if (c8721Xa6.a(fragmentActivity, str, strO, aVar, this) == objE) {
                                return objE;
                            }
                        } else {
                            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.L0;
                            C21015sz4 c21015sz4 = this.d;
                            FragmentActivity fragmentActivity2 = this.e;
                            AbstractC23884xg6.c cVar = this.f;
                            do {
                                value = interfaceC9336Zm4.getValue();
                            } while (!interfaceC9336Zm4.f(value, new XE4.a(c21015sz4.k2(fragmentActivity2, cVar))));
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1559a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.sz4$j$b$a$b, reason: collision with other inner class name */
                static final class C1560b extends AbstractC22163um1 {
                    Object a;
                    Object b;
                    /* synthetic */ Object c;
                    int e;

                    C1560b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.c = obj;
                        this.e |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                a(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20315ro1 interfaceC20315ro1, C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar) {
                    this.a = interfaceC16204ks5;
                    this.b = interfaceC20315ro1;
                    this.c = c21015sz4;
                    this.d = fragmentActivity;
                    this.e = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.RY1 r13, ir.nasim.InterfaceC20295rm1 r14) {
                    /*
                        r12 = this;
                        boolean r0 = r14 instanceof ir.nasim.C21015sz4.C21025j.b.a.C1560b
                        if (r0 == 0) goto L13
                        r0 = r14
                        ir.nasim.sz4$j$b$a$b r0 = (ir.nasim.C21015sz4.C21025j.b.a.C1560b) r0
                        int r1 = r0.e
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.e = r1
                        goto L18
                    L13:
                        ir.nasim.sz4$j$b$a$b r0 = new ir.nasim.sz4$j$b$a$b
                        r0.<init>(r14)
                    L18:
                        java.lang.Object r14 = r0.c
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.e
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r13 = r0.b
                        ir.nasim.RY1 r13 = (ir.nasim.RY1) r13
                        java.lang.Object r0 = r0.a
                        ir.nasim.sz4$j$b$a r0 = (ir.nasim.C21015sz4.C21025j.b.a) r0
                        ir.nasim.AbstractC10685c16.b(r14)
                        goto L6c
                    L31:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r14)
                        throw r13
                    L39:
                        ir.nasim.AbstractC10685c16.b(r14)
                        boolean r14 = r13 instanceof ir.nasim.RY1.c
                        if (r14 == 0) goto L42
                        r14 = 0
                        goto L58
                    L42:
                        boolean r14 = r13 instanceof ir.nasim.RY1.a
                        r2 = 100
                        if (r14 == 0) goto L4a
                        r14 = r2
                        goto L58
                    L4a:
                        boolean r14 = r13 instanceof ir.nasim.RY1.b
                        if (r14 == 0) goto Lab
                        r14 = r13
                        ir.nasim.RY1$b r14 = (ir.nasim.RY1.b) r14
                        float r14 = r14.a()
                        float r2 = (float) r2
                        float r14 = r14 * r2
                        int r14 = (int) r14
                    L58:
                        ir.nasim.ks5 r2 = r12.a
                        java.lang.Integer r14 = ir.nasim.AbstractC6392Nk0.d(r14)
                        r0.a = r12
                        r0.b = r13
                        r0.e = r3
                        java.lang.Object r14 = r2.o(r14, r0)
                        if (r14 != r1) goto L6b
                        return r1
                    L6b:
                        r0 = r12
                    L6c:
                        boolean r14 = r13 instanceof ir.nasim.RY1.a
                        if (r14 == 0) goto La8
                        ir.nasim.ks5 r14 = r0.a
                        ir.nasim.lo6 r14 = r14.j()
                        r1 = 0
                        ir.nasim.InterfaceC16756lo6.a.a(r14, r1, r3, r1)
                        ir.nasim.ro1 r14 = r0.b
                        boolean r14 = ir.nasim.AbstractC20906so1.g(r14)
                        if (r14 == 0) goto La8
                        ir.nasim.sz4 r3 = r0.c
                        androidx.fragment.app.FragmentActivity r4 = r0.d
                        ir.nasim.xg6$c r5 = r0.e
                        ir.nasim.UA2 r2 = ir.nasim.C21015sz4.t1(r3, r5, r13)
                        ir.nasim.ro1 r13 = ir.nasim.AbstractC9773aX7.a(r3)
                        ir.nasim.go1 r14 = ir.nasim.C21015sz4.A1(r3)
                        ir.nasim.fB4 r0 = ir.nasim.C12798fB4.b
                        ir.nasim.do1 r7 = r14.X(r0)
                        ir.nasim.sz4$j$b$a$a r9 = new ir.nasim.sz4$j$b$a$a
                        r6 = 0
                        r1 = r9
                        r1.<init>(r2, r3, r4, r5, r6)
                        r10 = 2
                        r11 = 0
                        r8 = 0
                        r6 = r13
                        ir.nasim.AbstractC9323Zl0.d(r6, r7, r8, r9, r10, r11)
                    La8:
                        ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                        return r13
                    Lab:
                        kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
                        r13.<init>()
                        throw r13
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.C21025j.b.a.a(ir.nasim.RY1, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C21015sz4 c21015sz4, InterfaceC18505om2 interfaceC18505om2, InterfaceC16204ks5 interfaceC16204ks5, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = interfaceC18505om2;
                this.f = interfaceC16204ks5;
                this.g = fragmentActivity;
                this.h = cVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2Q = this.d.y.q(false, ((C11920dm2) this.e).b(), true);
                    a aVar = new a(this.f, interfaceC20315ro1, this.d, this.g, this.h);
                    this.b = 1;
                    if (interfaceC4557Fq2Q.b(aVar, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21025j(InterfaceC18505om2 interfaceC18505om2, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC18505om2;
            this.f = fragmentActivity;
            this.g = cVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C21025j c21025j = C21015sz4.this.new C21025j(this.e, this.f, this.g, interfaceC20295rm1);
            c21025j.c = obj;
            return c21025j;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC16204ks5 interfaceC16204ks5;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC13778go1 abstractC13778go1 = C21015sz4.this.n;
                a aVar = new a(C21015sz4.this, null);
                this.c = interfaceC16204ks5;
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
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
                interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AbstractC10685c16.b(obj);
            }
            C10249bK6.b(C21015sz4.this.w, ((C11920dm2) this.e).b(), null, true, 2, null);
            InterfaceC16204ks5 interfaceC16204ks52 = interfaceC16204ks5;
            AbstractC10533bm0.d(interfaceC16204ks52, null, null, new b(C21015sz4.this, this.e, interfaceC16204ks5, this.f, this.g, null), 3, null);
            this.c = null;
            this.b = 2;
            if (AbstractC13822gs5.b(interfaceC16204ks5, null, this, 1, null) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21025j) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$k, reason: case insensitive filesystem */
    static final class C21026k extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        C21026k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.d("NewVideoPlayerViewModel", (Throwable) this.c);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            C21026k c21026k = new C21026k(interfaceC20295rm1);
            c21026k.c = th;
            return c21026k.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$l, reason: case insensitive filesystem */
    static final class C21027l extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        final /* synthetic */ InterfaceC18505om2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21027l(InterfaceC18505om2 interfaceC18505om2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = interfaceC18505om2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21015sz4.this.x.c(((C11920dm2) this.d).b());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21015sz4.this.new C21027l(this.d, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$m, reason: case insensitive filesystem */
    static final class C21028m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC23884xg6.a e;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.sz4$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC19342qB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            /* synthetic */ Object e;
            /* synthetic */ Object f;
            final /* synthetic */ String g;
            final /* synthetic */ AbstractC23884xg6.a h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, AbstractC23884xg6.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(6, interfaceC20295rm1);
                this.g = str;
                this.h = aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                String str;
                InterfaceC3346Am2 interfaceC3346Am2A;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Spannable spannable = (Spannable) this.c;
                List list = (List) this.d;
                RY1 ry1 = (RY1) this.e;
                String str2 = (String) this.f;
                AbstractC13042fc3.f(str2);
                boolean z = ry1 instanceof RY1.a;
                boolean z2 = !z;
                if (z) {
                    str = this.g;
                } else {
                    str = "thumb_" + this.g;
                }
                String str3 = str;
                byte[] bArrR = this.h.r();
                String descriptor = null;
                RY1.a aVar = z ? (RY1.a) ry1 : null;
                if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null) {
                    descriptor = interfaceC3346Am2A.getDescriptor();
                }
                return new AbstractC14329hk1.a(bArrR, descriptor, str2, spannable, z2, str3, list);
            }

            @Override // ir.nasim.InterfaceC19342qB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object j(Spannable spannable, List list, RY1 ry1, C19938rB7 c19938rB7, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.g, this.h, interfaceC20295rm1);
                aVar.c = spannable;
                aVar.d = list;
                aVar.e = ry1;
                aVar.f = str;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$m$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC16204ks5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.j().h((AbstractC14329hk1.a) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC14329hk1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$m$c */
        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C21015sz4 e;
            final /* synthetic */ AbstractC23884xg6.a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, C21015sz4 c21015sz4, AbstractC23884xg6.a aVar) {
                super(3, interfaceC20295rm1);
                this.e = c21015sz4;
                this.f = aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2G2 = ((Boolean) this.d).booleanValue() ? this.e.G2(this.f) : AbstractC6459Nq2.T(new C11068cg5(0.0f, false, false, 0L, false, false, null, null, false, new C12372eV7(this.f.t().getWidth(), this.f.t().getHeight()), 0, 1535, null));
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2G2, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1, this.e, this.f);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$m$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ AbstractC23884xg6.a b;

            /* renamed from: ir.nasim.sz4$m$d$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ AbstractC23884xg6.a b;

                /* renamed from: ir.nasim.sz4$m$d$a$a, reason: collision with other inner class name */
                public static final class C1561a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1561a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC23884xg6.a aVar) {
                    this.a = interfaceC4806Gq2;
                    this.b = aVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r11, ir.nasim.InterfaceC20295rm1 r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof ir.nasim.C21015sz4.C21028m.d.a.C1561a
                        if (r0 == 0) goto L13
                        r0 = r12
                        ir.nasim.sz4$m$d$a$a r0 = (ir.nasim.C21015sz4.C21028m.d.a.C1561a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.sz4$m$d$a$a r0 = new ir.nasim.sz4$m$d$a$a
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r12)
                        goto L70
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        ir.nasim.AbstractC10685c16.b(r12)
                        ir.nasim.Gq2 r12 = r10.a
                        ir.nasim.XV4 r11 = (ir.nasim.XV4) r11
                        java.lang.Object r2 = r11.a()
                        java.lang.Number r2 = (java.lang.Number) r2
                        long r4 = r2.longValue()
                        java.lang.Object r11 = r11.b()
                        java.lang.Number r11 = (java.lang.Number) r11
                        long r6 = r11.longValue()
                        ir.nasim.xg6$a r11 = r10.b
                        long r8 = r11.p()
                        int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                        if (r11 != 0) goto L62
                        ir.nasim.xg6$a r11 = r10.b
                        long r4 = r11.i()
                        int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r11 != 0) goto L62
                        r11 = r3
                        goto L63
                    L62:
                        r11 = 0
                    L63:
                        java.lang.Boolean r11 = ir.nasim.AbstractC6392Nk0.a(r11)
                        r0.b = r3
                        java.lang.Object r11 = r12.a(r11, r0)
                        if (r11 != r1) goto L70
                        return r1
                    L70:
                        ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.C21028m.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2, AbstractC23884xg6.a aVar) {
                this.a = interfaceC4557Fq2;
                this.b = aVar;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.sz4$m$e */
        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ AbstractC23884xg6.a e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(C21015sz4 c21015sz4, AbstractC23884xg6.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(this.d, this.e, interfaceC20295rm1);
                eVar.c = obj;
                return eVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC3346Am2 interfaceC3346Am2A;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                RY1 ry1 = (RY1) this.c;
                String descriptor = null;
                RY1.a aVar = ry1 instanceof RY1.a ? (RY1.a) ry1 : null;
                if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null) {
                    descriptor = interfaceC3346Am2A.getDescriptor();
                }
                return this.d.m2(this.e, descriptor);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$m$f */
        static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

            f(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                f fVar = new f(interfaceC20295rm1);
                fVar.c = obj;
                return fVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    List listM = AbstractC10360bX0.m();
                    this.b = 1;
                    if (interfaceC4806Gq2.a(listM, this) == objE) {
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
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C21028m(AbstractC23884xg6.a aVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = aVar;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C21028m c21028m = C21015sz4.this.new C21028m(this.e, this.f, interfaceC20295rm1);
            c21028m.c = obj;
            return c21028m;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new d(C21015sz4.this.H0, this.e));
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(interfaceC4557Fq2V, new c(null, C21015sz4.this, this.e));
                InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
                InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(interfaceC4557Fq2S0, interfaceC16204ks5, aVar.c(), new C11068cg5(0.0f, false, false, 0L, false, false, null, null, false, null, 0, 2047, null));
                InterfaceC4557Fq2 interfaceC4557Fq2G2 = C21015sz4.this.g2(this.e);
                InterfaceC4557Fq2 interfaceC4557Fq2I2 = C21015sz4.this.I2(interfaceC10258bL6O0, interfaceC4557Fq2V);
                InterfaceC10258bL6 interfaceC10258bL6O02 = AbstractC6459Nq2.o0(C21015sz4.this.j2(this.e), interfaceC16204ks5, aVar.c(), new RY1.c(null, 1, null));
                InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.m(interfaceC4557Fq2G2, AbstractC6459Nq2.v(AbstractC6459Nq2.c0(AbstractC6459Nq2.X(interfaceC10258bL6O02, new e(C21015sz4.this, this.e, null)), new f(null))), interfaceC10258bL6O02, interfaceC4557Fq2I2, C21015sz4.this.A2(this.e.q()), new a(this.f, this.e, null)), new b(interfaceC16204ks5, null));
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2B0, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C21028m) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FragmentActivity d;
        final /* synthetic */ String e;
        final /* synthetic */ AbstractC23884xg6.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(FragmentActivity fragmentActivity, String str, AbstractC23884xg6.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fragmentActivity;
            this.e = str;
            this.f = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21015sz4.this.new n(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21015sz4.this.i.a(this.d, this.e, this.f.o());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC23884xg6.b e;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.sz4$o$a */
        static final class a extends AbstractC19859r37 implements InterfaceC18160oB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            /* synthetic */ Object e;
            /* synthetic */ Object f;
            final /* synthetic */ AbstractC23884xg6.b g;
            final /* synthetic */ String h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC23884xg6.b bVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(5, interfaceC20295rm1);
                this.g = bVar;
                this.h = str;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                String str;
                InterfaceC3346Am2 interfaceC3346Am2A;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Spannable spannable = (Spannable) this.c;
                String str2 = (String) this.d;
                RY1 ry1 = (RY1) this.e;
                List list = (List) this.f;
                AbstractC13042fc3.f(str2);
                byte[] bArrR = this.g.r();
                boolean z = ry1 instanceof RY1.a;
                boolean z2 = !z;
                String descriptor = null;
                RY1.a aVar = z ? (RY1.a) ry1 : null;
                if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null) {
                    descriptor = interfaceC3346Am2A.getDescriptor();
                }
                if (z) {
                    str = this.h;
                } else {
                    str = "thumb_" + this.h;
                }
                return new AbstractC14329hk1.b(bArrR, descriptor, str2, spannable, z2, str, list);
            }

            @Override // ir.nasim.InterfaceC18160oB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object s(Spannable spannable, String str, RY1 ry1, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.g, this.h, interfaceC20295rm1);
                aVar.c = spannable;
                aVar.d = str;
                aVar.e = ry1;
                aVar.f = list;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$o$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC16204ks5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.j().h((AbstractC14329hk1.b) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC14329hk1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$o$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ AbstractC23884xg6.b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C21015sz4 c21015sz4, AbstractC23884xg6.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC3346Am2 interfaceC3346Am2A;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                RY1 ry1 = (RY1) this.c;
                String descriptor = null;
                RY1.a aVar = ry1 instanceof RY1.a ? (RY1.a) ry1 : null;
                if (aVar != null && (interfaceC3346Am2A = aVar.a()) != null) {
                    descriptor = interfaceC3346Am2A.getDescriptor();
                }
                return this.d.u2(this.e, descriptor);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$o$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

            d(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    List listM = AbstractC10360bX0.m();
                    this.b = 1;
                    if (interfaceC4806Gq2.a(listM, this) == objE) {
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
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(AbstractC23884xg6.b bVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = bVar;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            o oVar = C21015sz4.this.new o(this.e, this.f, interfaceC20295rm1);
            oVar.c = obj;
            return oVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(C21015sz4.this.j2(this.e), interfaceC16204ks5, InterfaceC16863lz6.a.c(), new RY1.c(null, 1, null));
                InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.n(C21015sz4.this.g2(this.e), C21015sz4.this.A2(this.e.q()), interfaceC10258bL6O0, AbstractC6459Nq2.v(AbstractC6459Nq2.c0(AbstractC6459Nq2.X(interfaceC10258bL6O0, new c(C21015sz4.this, this.e, null)), new d(null))), new a(this.e, this.f, null)), new b(interfaceC16204ks5, null));
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2B0, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ com.google.android.exoplayer2.E0 e;

        /* renamed from: ir.nasim.sz4$p$a */
        public static final class a implements z0.d {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC16204ks5 b;
            final /* synthetic */ com.google.android.exoplayer2.E0 c;

            a(C12889fL5 c12889fL5, InterfaceC16204ks5 interfaceC16204ks5, com.google.android.exoplayer2.E0 e0) {
                this.a = c12889fL5;
                this.b = interfaceC16204ks5;
                this.c = e0;
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void B(com.google.android.exoplayer2.y0 y0Var) {
                AbstractC13042fc3.i(y0Var, "playbackParameters");
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : y0Var.a, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void D4(C2018a0 c2018a0, int i) {
                if (i == 3) {
                    C12889fL5 c12889fL5 = this.a;
                    C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                    c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : c2018a0, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                    this.b.h(this.a.a);
                }
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void E0(int i) {
                com.google.android.exoplayer2.E0 e0 = this.c;
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : i == 3 ? e0.f() : c11068cg5.i(), (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : i);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void S4(boolean z, int i) {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : z, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void V2(boolean z) {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : z, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void f3(float f) {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : f <= 0.0f, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void l(C12372eV7 c12372eV7) {
                AbstractC13042fc3.i(c12372eV7, "videoSize");
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : c12372eV7, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void q2(PlaybackException playbackException) {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : playbackException, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void r5(boolean z) {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : z, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : false, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }

            @Override // com.google.android.exoplayer2.z0.d
            public void s() {
                C12889fL5 c12889fL5 = this.a;
                C11068cg5 c11068cg5 = (C11068cg5) c12889fL5.a;
                c12889fL5.a = c11068cg5.a((2046 & 1) != 0 ? c11068cg5.a : 0.0f, (2046 & 2) != 0 ? c11068cg5.b : false, (2046 & 4) != 0 ? c11068cg5.c : false, (2046 & 8) != 0 ? c11068cg5.d : 0L, (2046 & 16) != 0 ? c11068cg5.e : false, (2046 & 32) != 0 ? c11068cg5.f : false, (2046 & 64) != 0 ? c11068cg5.g : null, (2046 & 128) != 0 ? c11068cg5.h : null, (2046 & 256) != 0 ? c11068cg5.i : true, (2046 & 512) != 0 ? c11068cg5.j : null, (2046 & 1024) != 0 ? c11068cg5.k : 0);
                this.b.h(this.a.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = e0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(com.google.android.exoplayer2.E0 e0, a aVar) {
            e0.o(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            p pVar = C21015sz4.this.new p(this.e, interfaceC20295rm1);
            pVar.c = obj;
            return pVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                C12889fL5 c12889fL5 = new C12889fL5();
                C11068cg5 c11068cg5D2 = C21015sz4.this.D2(this.e);
                c12889fL5.a = c11068cg5D2;
                interfaceC16204ks5.h(c11068cg5D2);
                final a aVar = new a(c12889fL5, interfaceC16204ks5, this.e);
                this.e.m0(aVar);
                final com.google.android.exoplayer2.E0 e0 = this.e;
                SA2 sa2 = new SA2() { // from class: ir.nasim.tz4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21015sz4.p.y(e0, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = new q(interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a("NewVideoPlayerViewModel", "playerState: " + ((C11068cg5) this.c), new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C11068cg5 c11068cg5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(c11068cg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            r rVar = C21015sz4.this.new r(this.e, interfaceC20295rm1);
            rVar.c = obj;
            return rVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC11621dJ7 interfaceC11621dJ7 = C21015sz4.this.f;
                long j = this.e;
                this.c = interfaceC4806Gq2;
                this.b = 1;
                obj = interfaceC11621dJ7.a(j, this);
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
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC10685c16.b(obj);
            }
            C17637nI7 c17637nI7 = (C17637nI7) obj;
            if (c17637nI7 == null) {
                return C19938rB7.a;
            }
            String name = c17637nI7.getName();
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(name, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            s sVar = new s(interfaceC20295rm1);
            sVar.c = obj;
            return sVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                this.b = 1;
                if (interfaceC4806Gq2.a("", this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC23884xg6.c e;
        final /* synthetic */ String f;
        final /* synthetic */ com.google.android.exoplayer2.E0 g;

        /* renamed from: ir.nasim.sz4$t$a */
        static final class a extends AbstractC19859r37 implements WA2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            /* synthetic */ Object e;
            /* synthetic */ Object f;
            /* synthetic */ Object g;
            /* synthetic */ Object h;
            /* synthetic */ boolean i;
            /* synthetic */ Object j;
            /* synthetic */ boolean k;
            /* synthetic */ Object l;
            final /* synthetic */ C21015sz4 m;
            final /* synthetic */ com.google.android.exoplayer2.E0 n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21015sz4 c21015sz4, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(12, interfaceC20295rm1);
                this.m = c21015sz4;
                this.n = e0;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                List list;
                CV7 cv7;
                C8792Xi5 c8792Xi5;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Spannable spannable = (Spannable) this.c;
                Set set = (Set) this.d;
                List list2 = (List) this.e;
                CV7 cv72 = (CV7) this.f;
                C3345Am1 c3345Am1 = (C3345Am1) this.g;
                C11068cg5 c11068cg5 = (C11068cg5) this.h;
                boolean z = this.i;
                String str = (String) this.j;
                boolean z2 = this.k;
                String str2 = (String) this.l;
                AbstractC13042fc3.f(str2);
                C12372eV7 c12372eV7J = c11068cg5.j();
                EnumC9274Zf5 enumC9274Zf5B = EnumC9274Zf5.c.b(c11068cg5.h());
                InterfaceC17266mg5 interfaceC17266mg5H2 = this.m.H2(this.n.D0(), c11068cg5);
                boolean z3 = (z || !c11068cg5.l()) && !c3345Am1.f();
                if (!z2 || this.n.p() == 1) {
                    list = list2;
                    cv7 = cv72;
                    c8792Xi5 = new C8792Xi5(false, false, 0L, 0L, null, 31, null);
                } else {
                    list = list2;
                    cv7 = cv72;
                    c8792Xi5 = new C8792Xi5(c11068cg5.l(), c3345Am1.g(), AbstractC23053wG5.f(this.n.f(), 0L), this.n.D0(), this.m.a2(set, this.n));
                }
                return new AbstractC14329hk1.c(interfaceC17266mg5H2, str2, spannable, z3, c12372eV7J, str, c8792Xi5, enumC9274Zf5B, list, cv7);
            }

            public final Object n(Spannable spannable, Set set, List list, C19938rB7 c19938rB7, CV7 cv7, C3345Am1 c3345Am1, C11068cg5 c11068cg5, boolean z, String str, boolean z2, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.m, this.n, interfaceC20295rm1);
                aVar.c = spannable;
                aVar.d = set;
                aVar.e = list;
                aVar.f = cv7;
                aVar.g = c3345Am1;
                aVar.h = c11068cg5;
                aVar.i = z;
                aVar.j = str;
                aVar.k = z2;
                aVar.l = str2;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.WA2
            public /* bridge */ /* synthetic */ Object r(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                return n((Spannable) obj, (Set) obj2, (List) obj3, (C19938rB7) obj4, (CV7) obj5, (C3345Am1) obj6, (C11068cg5) obj7, ((Boolean) obj8).booleanValue(), (String) obj9, ((Boolean) obj10).booleanValue(), (String) obj11, (InterfaceC20295rm1) obj12);
            }
        }

        /* renamed from: ir.nasim.sz4$t$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC16204ks5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.j().h((AbstractC14329hk1.c) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC14329hk1.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(cVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Set setD = AbstractC4597Fu6.d();
                    this.b = 1;
                    if (interfaceC4806Gq2.a(setD, this) == objE) {
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
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C11920dm2 d;
            final /* synthetic */ C21015sz4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C11920dm2 c11920dm2, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c11920dm2;
                this.e = c21015sz4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(this.d, this.e, interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Set<C17942np0> set = (Set) this.c;
                if (this.d == null) {
                    return C19938rB7.a;
                }
                float fA = 0.0f;
                for (C17942np0 c17942np0 : set) {
                    fA += c17942np0.a() - c17942np0.b();
                }
                if ((1.0f - AbstractC23053wG5.l(fA, 0.0f, 1.0f)) * this.d.f() <= 1024.0f) {
                    this.e.c.m0(this.d.b().getFileId(), this.d.b().getAccessHash());
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(set, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$e */
        public static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C21015sz4 e;
            final /* synthetic */ AbstractC23884xg6.c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(InterfaceC20295rm1 interfaceC20295rm1, C21015sz4 c21015sz4, AbstractC23884xg6.c cVar) {
                super(3, interfaceC20295rm1);
                this.e = c21015sz4;
                this.f = cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2G2 = ((Boolean) this.d).booleanValue() ? this.e.G2(this.f) : AbstractC6459Nq2.T(new C11068cg5(0.0f, false, false, 0L, false, false, null, null, false, null, 0, 2047, null));
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2G2, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(interfaceC20295rm1, this.e, this.f);
                eVar.c = interfaceC4806Gq2;
                eVar.d = obj;
                return eVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$f */
        public static final class f implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ AbstractC23884xg6.c b;

            /* renamed from: ir.nasim.sz4$t$f$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ AbstractC23884xg6.c b;

                /* renamed from: ir.nasim.sz4$t$f$a$a, reason: collision with other inner class name */
                public static final class C1562a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1562a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC23884xg6.c cVar) {
                    this.a = interfaceC4806Gq2;
                    this.b = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r11, ir.nasim.InterfaceC20295rm1 r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof ir.nasim.C21015sz4.t.f.a.C1562a
                        if (r0 == 0) goto L13
                        r0 = r12
                        ir.nasim.sz4$t$f$a$a r0 = (ir.nasim.C21015sz4.t.f.a.C1562a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.sz4$t$f$a$a r0 = new ir.nasim.sz4$t$f$a$a
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r12)
                        goto L70
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        ir.nasim.AbstractC10685c16.b(r12)
                        ir.nasim.Gq2 r12 = r10.a
                        ir.nasim.XV4 r11 = (ir.nasim.XV4) r11
                        java.lang.Object r2 = r11.a()
                        java.lang.Number r2 = (java.lang.Number) r2
                        long r4 = r2.longValue()
                        java.lang.Object r11 = r11.b()
                        java.lang.Number r11 = (java.lang.Number) r11
                        long r6 = r11.longValue()
                        ir.nasim.xg6$c r11 = r10.b
                        long r8 = r11.p()
                        int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                        if (r11 != 0) goto L62
                        ir.nasim.xg6$c r11 = r10.b
                        long r4 = r11.i()
                        int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r11 != 0) goto L62
                        r11 = r3
                        goto L63
                    L62:
                        r11 = 0
                    L63:
                        java.lang.Boolean r11 = ir.nasim.AbstractC6392Nk0.a(r11)
                        r0.b = r3
                        java.lang.Object r11 = r12.a(r11, r0)
                        if (r11 != r1) goto L70
                        return r1
                    L70:
                        ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.t.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public f(InterfaceC4557Fq2 interfaceC4557Fq2, AbstractC23884xg6.c cVar) {
                this.a = interfaceC4557Fq2;
                this.b = cVar;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.sz4$t$g */
        static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ AbstractC23884xg6.c e;
            final /* synthetic */ String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(C21015sz4 c21015sz4, AbstractC23884xg6.c cVar, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = cVar;
                this.f = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                g gVar = new g(this.d, this.e, this.f, interfaceC20295rm1);
                gVar.c = obj;
                return gVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if ((((RY1) this.c) instanceof RY1.a) || this.d.p.a(C21181tF2.a.c, this.e.j())) {
                    return this.f;
                }
                return "thumb_" + this.f;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((g) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$h */
        static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ AbstractC23884xg6.c e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(C21015sz4 c21015sz4, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = cVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                h hVar = new h(this.d, this.e, interfaceC20295rm1);
                hVar.c = obj;
                return hVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.d.E2(this.e, (RY1) this.c);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((h) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$i */
        static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21015sz4 d;
            final /* synthetic */ AbstractC23884xg6.c e;

            /* renamed from: ir.nasim.sz4$t$i$a */
            public static final class a implements UA2 {
                final /* synthetic */ C21015sz4 a;
                final /* synthetic */ AbstractC23884xg6.c b;
                final /* synthetic */ UA2 c;

                /* renamed from: ir.nasim.sz4$t$i$a$a, reason: collision with other inner class name */
                public static final class C1563a implements SA2 {
                    final /* synthetic */ C21015sz4 a;
                    final /* synthetic */ FragmentActivity b;
                    final /* synthetic */ AbstractC23884xg6.c c;
                    final /* synthetic */ UA2 d;

                    /* renamed from: ir.nasim.sz4$t$i$a$a$a, reason: collision with other inner class name */
                    public static final class C1564a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        final /* synthetic */ UA2 c;
                        final /* synthetic */ C21015sz4 d;
                        final /* synthetic */ FragmentActivity e;
                        final /* synthetic */ AbstractC23884xg6.c f;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C1564a(UA2 ua2, C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.c = ua2;
                            this.d = c21015sz4;
                            this.e = fragmentActivity;
                            this.f = cVar;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            return new C1564a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            Object value;
                            Object objE = AbstractC14862ic3.e();
                            int i = this.b;
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                UA2 ua2 = this.c;
                                this.b = 1;
                                obj = ua2.invoke(this);
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
                            String str = (String) obj;
                            if (str != null) {
                                C8721Xa6 c8721Xa6 = this.d.o;
                                FragmentActivity fragmentActivity = this.e;
                                String strO = this.f.o();
                                C8721Xa6.a aVar = C8721Xa6.a.d;
                                this.b = 2;
                                if (c8721Xa6.a(fragmentActivity, str, strO, aVar, this) == objE) {
                                    return objE;
                                }
                            } else {
                                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.L0;
                                C21015sz4 c21015sz4 = this.d;
                                FragmentActivity fragmentActivity2 = this.e;
                                AbstractC23884xg6.c cVar = this.f;
                                do {
                                    value = interfaceC9336Zm4.getValue();
                                } while (!interfaceC9336Zm4.f(value, new XE4.a(c21015sz4.k2(fragmentActivity2, cVar))));
                            }
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C1564a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    public C1563a(C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, UA2 ua2) {
                        this.a = c21015sz4;
                        this.b = fragmentActivity;
                        this.c = cVar;
                        this.d = ua2;
                    }

                    public final void a() {
                        C21015sz4 c21015sz4 = this.a;
                        FragmentActivity fragmentActivity = this.b;
                        AbstractC23884xg6.c cVar = this.c;
                        AbstractC10533bm0.d(AbstractC9773aX7.a(c21015sz4), c21015sz4.m.X(C12798fB4.b), null, new C1564a(this.d, c21015sz4, fragmentActivity, cVar, null), 2, null);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.sz4$t$i$a$b */
                public static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ UA2 c;
                    final /* synthetic */ C21015sz4 d;
                    final /* synthetic */ FragmentActivity e;
                    final /* synthetic */ AbstractC23884xg6.c f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(UA2 ua2, C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = ua2;
                        this.d = c21015sz4;
                        this.e = fragmentActivity;
                        this.f = cVar;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object value;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            UA2 ua2 = this.c;
                            this.b = 1;
                            obj = ua2.invoke(this);
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
                        String str = (String) obj;
                        if (str != null) {
                            C8721Xa6 c8721Xa6 = this.d.o;
                            FragmentActivity fragmentActivity = this.e;
                            String strO = this.f.o();
                            C8721Xa6.a aVar = C8721Xa6.a.d;
                            this.b = 2;
                            if (c8721Xa6.a(fragmentActivity, str, strO, aVar, this) == objE) {
                                return objE;
                            }
                        } else {
                            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.L0;
                            C21015sz4 c21015sz4 = this.d;
                            FragmentActivity fragmentActivity2 = this.e;
                            AbstractC23884xg6.c cVar = this.f;
                            do {
                                value = interfaceC9336Zm4.getValue();
                            } while (!interfaceC9336Zm4.f(value, new XE4.a(c21015sz4.k2(fragmentActivity2, cVar))));
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                public a(C21015sz4 c21015sz4, AbstractC23884xg6.c cVar, UA2 ua2) {
                    this.a = c21015sz4;
                    this.b = cVar;
                    this.c = ua2;
                }

                public final void a(FragmentActivity fragmentActivity) {
                    Object value;
                    AbstractC13042fc3.i(fragmentActivity, "activity");
                    if (!this.a.b3(fragmentActivity)) {
                        C21015sz4 c21015sz4 = this.a;
                        AbstractC23884xg6.c cVar = this.b;
                        AbstractC10533bm0.d(AbstractC9773aX7.a(c21015sz4), c21015sz4.m.X(C12798fB4.b), null, new b(this.c, c21015sz4, fragmentActivity, cVar, null), 2, null);
                        return;
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.L0;
                    C21015sz4 c21015sz42 = this.a;
                    AbstractC23884xg6.c cVar2 = this.b;
                    UA2 ua2 = this.c;
                    do {
                        value = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value, new XE4.b("android.permission.WRITE_EXTERNAL_STORAGE", new C1563a(c21015sz42, fragmentActivity, cVar2, ua2))));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((FragmentActivity) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.sz4$t$i$b */
            public static final class b implements UA2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ AbstractC23884xg6.c b;
                final /* synthetic */ C21015sz4 c;

                /* renamed from: ir.nasim.sz4$t$i$b$a */
                public static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ UA2 c;
                    final /* synthetic */ AbstractC23884xg6.c d;
                    final /* synthetic */ FragmentActivity e;
                    final /* synthetic */ C21015sz4 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public a(UA2 ua2, AbstractC23884xg6.c cVar, FragmentActivity fragmentActivity, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = ua2;
                        this.d = cVar;
                        this.e = fragmentActivity;
                        this.f = c21015sz4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object value;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            UA2 ua2 = this.c;
                            this.b = 1;
                            obj = ua2.invoke(this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        String str = (String) obj;
                        if (str != null) {
                            String strO = this.d.o();
                            if (strO == null) {
                                strO = "video/mp4";
                            }
                            String string = this.e.getString(VD5.menu_share);
                            AbstractC13042fc3.h(string, "getString(...)");
                            C7009Px6.b(this.f.h, this.e, str, strO, string, this.d.h(), null, 32, null);
                        } else {
                            InterfaceC9336Zm4 interfaceC9336Zm4 = this.f.L0;
                            do {
                                value = interfaceC9336Zm4.getValue();
                            } while (!interfaceC9336Zm4.f(value, new XE4.c(VD5.retry_after_video_is_downloaded_completly)));
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                public b(UA2 ua2, AbstractC23884xg6.c cVar, C21015sz4 c21015sz4) {
                    this.a = ua2;
                    this.b = cVar;
                    this.c = c21015sz4;
                }

                public final void a(FragmentActivity fragmentActivity) {
                    AbstractC13042fc3.i(fragmentActivity, "activity");
                    AbstractC10533bm0.d(AbstractC19224pz3.a(fragmentActivity), null, null, new a(this.a, this.b, fragmentActivity, this.c, null), 3, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((FragmentActivity) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.sz4$t$i$c */
            public static final class c implements UA2 {
                final /* synthetic */ UA2 a;
                final /* synthetic */ C21015sz4 b;
                final /* synthetic */ AbstractC23884xg6.c c;

                /* renamed from: ir.nasim.sz4$t$i$c$a */
                public static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ UA2 c;
                    final /* synthetic */ C21015sz4 d;
                    final /* synthetic */ FragmentActivity e;
                    final /* synthetic */ AbstractC23884xg6.c f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public a(UA2 ua2, C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = ua2;
                        this.d = c21015sz4;
                        this.e = fragmentActivity;
                        this.f = cVar;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object value;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            UA2 ua2 = this.c;
                            this.b = 1;
                            obj = ua2.invoke(this);
                            if (obj == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        String str = (String) obj;
                        if (str != null) {
                            this.d.i.a(this.e, str, this.f.o());
                        } else {
                            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.L0;
                            do {
                                value = interfaceC9336Zm4.getValue();
                            } while (!interfaceC9336Zm4.f(value, new XE4.c(VD5.retry_after_video_is_downloaded_completly)));
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                public c(UA2 ua2, C21015sz4 c21015sz4, AbstractC23884xg6.c cVar) {
                    this.a = ua2;
                    this.b = c21015sz4;
                    this.c = cVar;
                }

                public final void a(FragmentActivity fragmentActivity) {
                    AbstractC13042fc3.i(fragmentActivity, "activity");
                    AbstractC10533bm0.d(AbstractC19224pz3.a(fragmentActivity), null, null, new a(this.a, this.b, fragmentActivity, this.c, null), 3, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((FragmentActivity) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(C21015sz4 c21015sz4, AbstractC23884xg6.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21015sz4;
                this.e = cVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                i iVar = new i(this.d, this.e, interfaceC20295rm1);
                iVar.c = obj;
                return iVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                UA2 ua2 = (UA2) this.c;
                C21015sz4 c21015sz4 = this.d;
                AbstractC23884xg6.c cVar = this.e;
                return AbstractC10360bX0.p(new C4337Er7(VD5.menu_item_show_all_media, AbstractC24778zB5.category, new C22292uz4(c21015sz4)), new C4337Er7(VD5.menu_item_save_to_gallary, AbstractC24778zB5.image, new a(c21015sz4, cVar, ua2)), new C4337Er7(VD5.menu_item_share, AbstractC24778zB5.share, new b(ua2, cVar, c21015sz4)), new C4337Er7(VD5.menu_item_play_in_external_app, AbstractC24778zB5.open_with, new c(ua2, c21015sz4, cVar)));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((i) create(ua2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.sz4$t$j */
        static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

            j(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                j jVar = new j(interfaceC20295rm1);
                jVar.c = obj;
                return jVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    List listM = AbstractC10360bX0.m();
                    this.b = 1;
                    if (interfaceC4806Gq2.a(listM, this) == objE) {
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
            public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((j) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(AbstractC23884xg6.c cVar, String str, com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = cVar;
            this.f = str;
            this.g = e0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            t tVar = C21015sz4.this.new t(this.e, this.f, this.g, interfaceC20295rm1);
            tVar.c = obj;
            return tVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i2 = this.b;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new f(C21015sz4.this.H0, this.e));
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(interfaceC4557Fq2V, new e(null, C21015sz4.this, this.e));
                InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
                InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(interfaceC4557Fq2S0, interfaceC16204ks5, aVar.c(), new C11068cg5(0.0f, false, false, 0L, false, false, null, null, false, null, 0, 2047, null));
                InterfaceC4557Fq2 interfaceC4557Fq2G2 = C21015sz4.this.g2(this.e);
                InterfaceC18505om2 interfaceC18505om2J = this.e.j();
                InterfaceC4557Fq2 interfaceC4557Fq2B0 = AbstractC6459Nq2.b0(AbstractC6459Nq2.c0(C21015sz4.this.l.d(this.e), new c(null)), new d(interfaceC18505om2J instanceof C11920dm2 ? (C11920dm2) interfaceC18505om2J : null, C21015sz4.this, null));
                InterfaceC4557Fq2 interfaceC4557Fq2I2 = C21015sz4.this.I2(interfaceC10258bL6O0, interfaceC4557Fq2V);
                InterfaceC4557Fq2 interfaceC4557Fq2L2 = C21015sz4.this.L2(interfaceC4557Fq2V, interfaceC10258bL6O0, this.e, new C15539jl1(this.e.t().getWidth(), this.e.t().getHeight()));
                InterfaceC10258bL6 interfaceC10258bL6O02 = AbstractC6459Nq2.o0(C21015sz4.this.j2(this.e), interfaceC16204ks5, aVar.c(), new RY1.c(null, 1, null));
                InterfaceC4557Fq2 interfaceC4557Fq2V2 = AbstractC6459Nq2.v(AbstractC6459Nq2.X(interfaceC10258bL6O02, new g(C21015sz4.this, this.e, this.f, null)));
                InterfaceC4557Fq2 interfaceC4557Fq2V3 = AbstractC6459Nq2.v(AbstractC6459Nq2.c0(AbstractC6459Nq2.X(AbstractC6459Nq2.X(interfaceC10258bL6O02, new h(C21015sz4.this, this.e, null)), new i(C21015sz4.this, this.e, null)), new j(null)));
                C21015sz4 c21015sz4 = C21015sz4.this;
                InterfaceC4557Fq2 interfaceC4557Fq2B02 = AbstractC6459Nq2.b0(c21015sz4.a3(interfaceC4557Fq2G2, interfaceC4557Fq2B0, interfaceC4557Fq2V3, interfaceC4557Fq2I2, interfaceC4557Fq2L2, c21015sz4.C0, interfaceC10258bL6O0, C21015sz4.this.F0, interfaceC4557Fq2V2, interfaceC4557Fq2V, C21015sz4.this.A2(this.e.q()), new a(C21015sz4.this, this.g, null)), new b(interfaceC16204ks5, null));
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2B02, this) == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$u */
    static final class u extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ AbstractC23884xg6.c c;
        final /* synthetic */ RY1 d;
        final /* synthetic */ C21015sz4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(AbstractC23884xg6.c cVar, RY1 ry1, C21015sz4 c21015sz4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.c = cVar;
            this.d = ry1;
            this.e = c21015sz4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new u(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18505om2 interfaceC18505om2J = this.c.j();
                if (interfaceC18505om2J instanceof C4512Fl2) {
                    return ((C4512Fl2) interfaceC18505om2J).c;
                }
                if (!(interfaceC18505om2J instanceof C11920dm2)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(this.d instanceof RY1.a)) {
                    return null;
                }
                C16220ku1 c16220ku1 = this.e.s;
                C11920dm2 c11920dm2 = (C11920dm2) interfaceC18505om2J;
                long fileId = c11920dm2.b().getFileId();
                long accessHash = c11920dm2.b().getAccessHash();
                long jF = c11920dm2.f();
                String strA = c11920dm2.a();
                this.b = 1;
                obj = c16220ku1.k(fileId, accessHash, jF, strA, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            File file = (File) obj;
            if (file != null) {
                return file.getAbsolutePath();
            }
            return null;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$v */
    public static final class v implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ String b;

        /* renamed from: ir.nasim.sz4$v$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ String b;

            /* renamed from: ir.nasim.sz4$v$a$a, reason: collision with other inner class name */
            public static final class C1565a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1565a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, String str) {
                this.a = interfaceC4806Gq2;
                this.b = str;
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
                    boolean r0 = r7 instanceof ir.nasim.C21015sz4.v.a.C1565a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.sz4$v$a$a r0 = (ir.nasim.C21015sz4.v.a.C1565a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.sz4$v$a$a r0 = new ir.nasim.sz4$v$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L54
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    r2 = r6
                    ir.nasim.cg5 r2 = (ir.nasim.C11068cg5) r2
                    com.google.android.exoplayer2.a0 r2 = r2.c()
                    if (r2 == 0) goto L42
                    java.lang.String r2 = r2.a
                    goto L43
                L42:
                    r2 = 0
                L43:
                    java.lang.String r4 = r5.b
                    boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r4)
                    if (r2 == 0) goto L54
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L54
                    return r1
                L54:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.v.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public v(InterfaceC4557Fq2 interfaceC4557Fq2, String str) {
            this.a = interfaceC4557Fq2;
            this.b = str;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sz4$w */
    public static final class w extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C21015sz4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(InterfaceC20295rm1 interfaceC20295rm1, C21015sz4 c21015sz4) {
            super(3, interfaceC20295rm1);
            this.e = c21015sz4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2R = ((Boolean) this.d).booleanValue() ? AbstractC6459Nq2.r(AbstractC3851Cp7.f(10L, 0L, this.e.m, null, 8, null)) : AbstractC6459Nq2.T(C19938rB7.a);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2R, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            w wVar = new w(interfaceC20295rm1, this.e);
            wVar.c = interfaceC4806Gq2;
            wVar.d = obj;
            return wVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sz4$x */
    static final class x extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;

        x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C11068cg5 c11068cg5 = (C11068cg5) this.c;
            return AbstractC6392Nk0.a(this.d && c11068cg5.g() == 3 && c11068cg5.l());
        }

        public final Object n(C11068cg5 c11068cg5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            x xVar = new x(interfaceC20295rm1);
            xVar.c = c11068cg5;
            xVar.d = z;
            return xVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((C11068cg5) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.sz4$y */
    static final class y extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC10258bL6 e;
        final /* synthetic */ AbstractC23884xg6 f;
        final /* synthetic */ C15539jl1 g;

        /* renamed from: ir.nasim.sz4$y$a */
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
                C11068cg5 c11068cg5 = (C11068cg5) this.c;
                return AbstractC6392Nk0.a(!AbstractC13042fc3.d(c11068cg5.j(), C12372eV7.e) && c11068cg5.e() && c11068cg5.l());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11068cg5 c11068cg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c11068cg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(InterfaceC10258bL6 interfaceC10258bL6, AbstractC23884xg6 abstractC23884xg6, C15539jl1 c15539jl1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC10258bL6;
            this.f = abstractC23884xg6;
            this.g = c15539jl1;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[RETURN] */
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
                r2 = 0
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L32
                if (r1 == r6) goto L2a
                if (r1 == r5) goto L22
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L82
            L22:
                java.lang.Object r1 = r7.c
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L5f
            L2a:
                java.lang.Object r1 = r7.c
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L52
            L32:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.c
                ir.nasim.Gq2 r8 = (ir.nasim.InterfaceC4806Gq2) r8
                boolean r1 = r7.d
                if (r1 == 0) goto L6c
                ir.nasim.bL6 r1 = r7.e
                ir.nasim.Fq2 r1 = (ir.nasim.InterfaceC4557Fq2) r1
                ir.nasim.sz4$y$a r3 = new ir.nasim.sz4$y$a
                r3.<init>(r2)
                r7.c = r8
                r7.b = r6
                java.lang.Object r1 = ir.nasim.AbstractC6459Nq2.H(r1, r3, r7)
                if (r1 != r0) goto L51
                return r0
            L51:
                r1 = r8
            L52:
                r7.c = r1
                r7.b = r5
                r5 = 200(0xc8, double:9.9E-322)
                java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                if (r8 != r0) goto L5f
                return r0
            L5f:
                ir.nasim.CV7$a r8 = ir.nasim.CV7.a.a
                r7.c = r2
                r7.b = r4
                java.lang.Object r8 = r1.a(r8, r7)
                if (r8 != r0) goto L82
                return r0
            L6c:
                ir.nasim.CV7$b r1 = new ir.nasim.CV7$b
                ir.nasim.xg6 r2 = r7.f
                byte[] r2 = r2.r()
                ir.nasim.jl1 r4 = r7.g
                r1.<init>(r2, r4)
                r7.b = r3
                java.lang.Object r8 = r8.a(r1, r7)
                if (r8 != r0) goto L82
                return r0
            L82:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21015sz4.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            y yVar = new y(this.e, this.f, this.g, interfaceC20295rm1);
            yVar.c = interfaceC4806Gq2;
            yVar.d = z;
            return yVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC4806Gq2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.sz4$z */
    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AbstractC23884xg6 d;
        final /* synthetic */ C15539jl1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(AbstractC23884xg6 abstractC23884xg6, C15539jl1 c15539jl1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC23884xg6;
            this.e = c15539jl1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            z zVar = new z(this.d, this.e, interfaceC20295rm1);
            zVar.c = obj;
            return zVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                CV7.b bVar = new CV7.b(this.d.r(), this.e);
                this.b = 1;
                if (interfaceC4806Gq2.a(bVar, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21015sz4(androidx.lifecycle.y yVar, int i, C14970in2 c14970in2, SettingsModule settingsModule, InterfaceC12532em2 interfaceC12532em2, InterfaceC11621dJ7 interfaceC11621dJ7, com.google.android.exoplayer2.E0 e0, C7009Px6 c7009Px6, C21191tG3.b bVar, VK4 vk4, HC6 hc6, C6918Pn5.a aVar, C13590gU7 c13590gU7, C22445vF2 c22445vF2, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C8721Xa6 c8721Xa6, C21181tF2 c21181tF2, AbstractC13778go1 abstractC13778go13, DF2 df2, C21864uG2.c cVar, C16220ku1 c16220ku1, C3535Bg6 c3535Bg6, C24440yd2 c24440yd2, QF2 qf2, C10249bK6 c10249bK6, C23620xE0 c23620xE0, C14494i07 c14494i07, C7992Ub2 c7992Ub2) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(e0, "previewPlayer");
        AbstractC13042fc3.i(c7009Px6, "shareFileUseCase");
        AbstractC13042fc3.i(bVar, "loadViewsUseCaseFactory");
        AbstractC13042fc3.i(vk4, "openForViewUseCase");
        AbstractC13042fc3.i(hc6, "simpleExoPlayerPool");
        AbstractC13042fc3.i(aVar, "prepareVideoPlayerUseCaseFactory");
        AbstractC13042fc3.i(c13590gU7, "videoPlayerRewinder");
        AbstractC13042fc3.i(c22445vF2, "getCachedSpansUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(c8721Xa6, "saveMediaToGalleryUseCase");
        AbstractC13042fc3.i(c21181tF2, "getAutoDownloadStateUseCase");
        AbstractC13042fc3.i(abstractC13778go13, "defaultDispatcher");
        AbstractC13042fc3.i(df2, "getConnectionStateUseCase");
        AbstractC13042fc3.i(cVar, "getSearchMessagesUseCaseFactory");
        AbstractC13042fc3.i(c16220ku1, "createVideoFileFromExoCacheUseCase");
        AbstractC13042fc3.i(c3535Bg6, "searchMessageVideoToVideoSourceMapper");
        AbstractC13042fc3.i(c24440yd2, "exoAnalytics");
        AbstractC13042fc3.i(qf2, "getDownloadedFileStateUsecase");
        AbstractC13042fc3.i(c10249bK6, "startDownloadFileUsecase");
        AbstractC13042fc3.i(c23620xE0, "cancelDownloadFileUsecase");
        AbstractC13042fc3.i(c14494i07, "subscribeDownloadFileStateUsecase");
        AbstractC13042fc3.i(c7992Ub2, "exPeerTypeToTrafficUsageOriginMapper");
        this.b = i;
        this.c = c14970in2;
        this.d = settingsModule;
        this.e = interfaceC12532em2;
        this.f = interfaceC11621dJ7;
        this.g = e0;
        this.h = c7009Px6;
        this.i = vk4;
        this.j = hc6;
        this.k = c13590gU7;
        this.l = c22445vF2;
        this.m = abstractC13778go1;
        this.n = abstractC13778go12;
        this.o = c8721Xa6;
        this.p = c21181tF2;
        this.q = abstractC13778go13;
        this.r = df2;
        this.s = c16220ku1;
        this.t = c3535Bg6;
        this.u = c24440yd2;
        this.v = qf2;
        this.w = c10249bK6;
        this.x = c23620xE0;
        this.y = c14494i07;
        Object objC = yVar.c("PEER_UNIQUE_ID_ARG");
        AbstractC13042fc3.f(objC);
        C11458d25 c11458d25R = C11458d25.r(((Number) objC).longValue());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.z = c11458d25R;
        Object objC2 = yVar.c("EX_PEER_TYPE_ARG");
        AbstractC13042fc3.f(objC2);
        ExPeerType exPeerType = (ExPeerType) objC2;
        this.A = exPeerType;
        Object objC3 = yVar.c("MEDIA_LOAD_TYPE_ARG");
        AbstractC13042fc3.f(objC3);
        EnumC24384yX3 enumC24384yX3 = (EnumC24384yX3) objC3;
        this.B = enumC24384yX3;
        Object objC4 = yVar.c("VIEWABLE_CONTENT_ARG");
        AbstractC13042fc3.f(objC4);
        InterfaceC18963pY7 interfaceC18963pY7 = (InterfaceC18963pY7) objC4;
        this.D = interfaceC18963pY7;
        AbstractC23884xg6 abstractC23884xg6B3 = B3(interfaceC18963pY7);
        this.G = abstractC23884xg6B3;
        this.H = aVar.a(c7992Ub2.a(exPeerType));
        this.J = bVar.a(AbstractC9773aX7.a(this));
        C21864uG2 c21864uG2A = cVar.a(c11458d25R, AbstractC9773aX7.a(this), abstractC23884xg6B3, enumC24384yX3);
        this.Y = c21864uG2A;
        C8244Vd2 c8244Vd2 = new C8244Vd2(c.a.e, false, 2, null);
        this.Z = c8244Vd2;
        this.B0 = AbstractC12281eL6.a(EnumC18448og5.a);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C3345Am1(false, false, false, false, false, false, 63, null));
        this.C0 = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(new RJ1(null, 1, null));
        this.D0 = interfaceC9336Zm4A2;
        InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.v(AbstractC6459Nq2.s0(interfaceC9336Zm4A, new C21020e(null))), abstractC13778go1);
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(interfaceC4557Fq2V, interfaceC20315ro1A, aVar2.d(), Boolean.FALSE);
        this.F0 = interfaceC10258bL6O0;
        HashMap map = new HashMap(3);
        this.G0 = map;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(AbstractC4616Fw7.a(Long.valueOf(abstractC23884xg6B3.p()), Long.valueOf(abstractC23884xg6B3.i())));
        this.H0 = interfaceC9336Zm4A3;
        InterfaceC10258bL6 interfaceC10258bL6O02 = AbstractC6459Nq2.o0(c21864uG2A.i(), AbstractC9773aX7.a(this), aVar2.c(), new C12486eh6(1, AbstractC9766aX0.e(abstractC23884xg6B3)));
        this.I0 = interfaceC10258bL6O02;
        this.J0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(AbstractC6459Nq2.p(interfaceC9336Zm4A3, new K(interfaceC10258bL6O02), new M(null)), abstractC13778go13), AbstractC9773aX7.a(this), aVar2.c(), new C17428mw7(null, AbstractC15401jX0.q0(((C12486eh6) interfaceC10258bL6O02.getValue()).a()), null));
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(null);
        this.L0 = interfaceC9336Zm4A4;
        com.google.android.exoplayer2.E0 e0C3 = c3();
        this.A0 = e0C3;
        c8244Vd2.a(e0C3);
        e0C3.E(c24440yd2);
        d2(e0C3);
        this.E0 = z2(e0C3);
        InterfaceC4557Fq2 interfaceC4557Fq2I2 = i2(e0C3);
        this.K0 = interfaceC4557Fq2I2;
        InterfaceC4557Fq2 interfaceC4557Fq2M = AbstractC6459Nq2.m(interfaceC4557Fq2I2, interfaceC9336Zm4A4, interfaceC10258bL6O0, interfaceC9336Zm4A2, new L(interfaceC10258bL6O02), new C21016a(null));
        InterfaceC20315ro1 interfaceC20315ro1A2 = AbstractC9773aX7.a(this);
        InterfaceC16863lz6 interfaceC16863lz6C = aVar2.c();
        AbstractC3336Al1 abstractC3336Al1H2 = h2(e0C3, abstractC23884xg6B3);
        map.put(abstractC23884xg6B3, abstractC3336Al1H2);
        C19938rB7 c19938rB7 = C19938rB7.a;
        this.M0 = AbstractC6459Nq2.o0(interfaceC4557Fq2M, interfaceC20315ro1A2, interfaceC16863lz6C, new C10776cA7(1, 1, null, abstractC3336Al1H2, null, null, null, null, SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER, null));
        P2();
        Q2(e0C3);
        W2(e0C3);
        if (C8386Vt0.B8()) {
            O2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 A2(int i) {
        return AbstractC6459Nq2.c0(AbstractC6459Nq2.V(AbstractC6459Nq2.R(new r(i, null)), this.n), new s(null));
    }

    private final AbstractC23884xg6 B3(InterfaceC18963pY7 interfaceC18963pY7) {
        InterfaceC18505om2 c11920dm2;
        InterfaceC18505om2 c11920dm22;
        InterfaceC18505om2 c11920dm23;
        if (interfaceC18963pY7 instanceof InterfaceC18963pY7.b) {
            InterfaceC18963pY7.b bVar = (InterfaceC18963pY7.b) interfaceC18963pY7;
            InterfaceC19554qY7 interfaceC19554qY7F = bVar.f();
            if (interfaceC19554qY7F instanceof InterfaceC19554qY7.a) {
                c11920dm23 = new C4512Fl2(bVar.getName(), (int) bVar.b(), ((InterfaceC19554qY7.a) interfaceC19554qY7F).a(), bVar.a());
            } else {
                if (!(interfaceC19554qY7F instanceof InterfaceC19554qY7.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC19554qY7.b bVar2 = (InterfaceC19554qY7.b) interfaceC19554qY7F;
                c11920dm23 = new C11920dm2(new FileReference(bVar2.b(), bVar2.a(), bVar.getName(), bVar.a(), (int) bVar.b()));
            }
            InterfaceC18505om2 interfaceC18505om2 = c11920dm23;
            long jI = bVar.i();
            long jH = bVar.h();
            String strA = bVar.a();
            String strC = bVar.c();
            return new AbstractC23884xg6.b(new Size(bVar.e().b(), bVar.e().a()), jI, jH, bVar.d(), strA, strC, bVar.g(), interfaceC18505om2);
        }
        if (interfaceC18963pY7 instanceof InterfaceC18963pY7.c) {
            InterfaceC18963pY7.c cVar = (InterfaceC18963pY7.c) interfaceC18963pY7;
            InterfaceC19554qY7 interfaceC19554qY7G = cVar.g();
            if (interfaceC19554qY7G instanceof InterfaceC19554qY7.a) {
                c11920dm22 = new C4512Fl2(cVar.getName(), (int) cVar.c(), ((InterfaceC19554qY7.a) interfaceC19554qY7G).a(), cVar.a());
            } else {
                if (!(interfaceC19554qY7G instanceof InterfaceC19554qY7.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC19554qY7.b bVar3 = (InterfaceC19554qY7.b) interfaceC19554qY7G;
                c11920dm22 = new C11920dm2(new FileReference(bVar3.b(), bVar3.a(), cVar.getName(), cVar.a(), (int) cVar.c()));
            }
            InterfaceC18505om2 interfaceC18505om22 = c11920dm22;
            long jI2 = cVar.i();
            long jH2 = cVar.h();
            String strA2 = cVar.a();
            int iE = cVar.e();
            String strD = cVar.d();
            return new AbstractC23884xg6.c(new Size(cVar.f().b(), cVar.f().a()), cVar.b(), jI2, jH2, iE, strA2, strD, cVar.j(), interfaceC18505om22);
        }
        if (!(interfaceC18963pY7 instanceof InterfaceC18963pY7.a)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC18963pY7.a aVar = (InterfaceC18963pY7.a) interfaceC18963pY7;
        InterfaceC19554qY7 interfaceC19554qY7G2 = aVar.g();
        if (interfaceC19554qY7G2 instanceof InterfaceC19554qY7.a) {
            c11920dm2 = new C4512Fl2(aVar.getName(), (int) aVar.c(), ((InterfaceC19554qY7.a) interfaceC19554qY7G2).a(), aVar.a());
        } else {
            if (!(interfaceC19554qY7G2 instanceof InterfaceC19554qY7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC19554qY7.b bVar4 = (InterfaceC19554qY7.b) interfaceC19554qY7G2;
            c11920dm2 = new C11920dm2(new FileReference(bVar4.b(), bVar4.a(), aVar.getName(), aVar.a(), (int) aVar.c()));
        }
        InterfaceC18505om2 interfaceC18505om23 = c11920dm2;
        long jI3 = aVar.i();
        long jH3 = aVar.h();
        String strA3 = aVar.a();
        int iE2 = aVar.e();
        String strD2 = aVar.d();
        return new AbstractC23884xg6.a(new Size(aVar.f().b(), aVar.f().a()), aVar.b(), jI3, jH3, iE2, strA3, strD2, aVar.j(), interfaceC18505om23);
    }

    private final InterfaceC4557Fq2 C2(com.google.android.exoplayer2.E0 e0, String str, AbstractC23884xg6.c cVar) {
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.j(new t(cVar, str, e0, null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.a(5000L, 0L), new AbstractC14329hk1.c(InterfaceC17266mg5.b.a, null, null, false, null, null, null, null, null, null, 1022, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C11068cg5 D2(com.google.android.exoplayer2.E0 e0) {
        float f = e0.c().a;
        boolean z2 = e0.f0() <= 0.0f;
        boolean zI = e0.i();
        long jF = e0.f();
        boolean zU0 = e0.U0();
        boolean zX = e0.X();
        ExoPlaybackException exoPlaybackExceptionA = e0.a();
        C12372eV7 c12372eV7E0 = e0.e0();
        AbstractC13042fc3.h(c12372eV7E0, "getVideoSize(...)");
        return new C11068cg5(f, z2, zI, jF, zU0, zX, exoPlaybackExceptionA, e0.n(), false, c12372eV7E0, e0.p(), 256, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UA2 E2(AbstractC23884xg6.c cVar, RY1 ry1) {
        return new u(cVar, ry1, this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 G2(AbstractC23884xg6.c cVar) {
        long jP = cVar.p();
        long jI = cVar.i();
        StringBuilder sb = new StringBuilder();
        sb.append(jP);
        sb.append(jI);
        return new v(this.E0, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC17266mg5 H2(long j, C11068cg5 c11068cg5) {
        int iG = (c11068cg5.k() || c11068cg5.d() == null) ? (c11068cg5.g() != 2 || c11068cg5.f()) ? c11068cg5.g() : 1 : 2;
        if (iG == 2) {
            return InterfaceC17266mg5.a.a;
        }
        if (iG != 3) {
            return InterfaceC17266mg5.b.a;
        }
        if (c11068cg5.l()) {
            return new InterfaceC17266mg5.d(j + 10000 <= c11068cg5.i(), j - 10000 >= 0);
        }
        return new InterfaceC17266mg5.c(j + 10000 <= c11068cg5.i(), j - 10000 >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 I2(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC4557Fq2 interfaceC4557Fq2) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.s0(AbstractC6459Nq2.p(interfaceC10258bL6, interfaceC4557Fq2, new x(null)), new w(null, this)), this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final G47 K2(RJ1 rj1, boolean z2) {
        int i = C21018c.a[rj1.b().ordinal()];
        if (i == 1) {
            return new G47(z2, true);
        }
        if (i == 2) {
            return new G47(z2, z2);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 L2(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC10258bL6 interfaceC10258bL6, AbstractC23884xg6 abstractC23884xg6, C15539jl1 c15539jl1) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.c0(AbstractC6459Nq2.s0(interfaceC4557Fq2, new y(interfaceC10258bL6, abstractC23884xg6, c15539jl1, null)), new z(abstractC23884xg6, c15539jl1, null)), this.m);
    }

    private final void O2() {
        AbstractC6459Nq2.W(AbstractC6459Nq2.p(this.H0, this.I0, new A(null)), AbstractC9773aX7.a(this));
    }

    private final InterfaceC13730gj3 P2() {
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.J0, new B(null)), AbstractC9773aX7.a(this));
    }

    private final void Q2(com.google.android.exoplayer2.E0 e0) {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.L0, new C(new C12889fL5(), e0, null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 R2(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC4557Fq2 interfaceC4557Fq2, com.google.android.exoplayer2.E0 e0) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new D(interfaceC4557Fq2, e0, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S2(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.X(interfaceC4557Fq2, new E(null)), new F(null)), interfaceC20315ro1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U2(InterfaceC20315ro1 interfaceC20315ro1, com.google.android.exoplayer2.E0 e0) {
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(this.B0, new G(e0, null)), interfaceC20315ro1);
    }

    private final InterfaceC13730gj3 W2(com.google.android.exoplayer2.E0 e0) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new H(e0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set a2(Set set, com.google.android.exoplayer2.E0 e0) {
        Long lValueOf = Long.valueOf(e0.f());
        Float fValueOf = null;
        if (lValueOf.longValue() > 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return set;
        }
        float fLongValue = lValueOf.longValue();
        float fD0 = e0.D0() / fLongValue;
        float fO0 = e0.o0() / fLongValue;
        if (fO0 <= 0.0f) {
            return set;
        }
        Iterator it = set.iterator();
        Float fValueOf2 = null;
        while (it.hasNext()) {
            C17942np0 c17942np0 = (C17942np0) it.next();
            if (fValueOf == null) {
                float fB = c17942np0.b();
                if (fD0 <= c17942np0.a() && fB <= fD0) {
                    fValueOf = Float.valueOf(c17942np0.a());
                }
            }
            if (fValueOf2 == null) {
                float fB2 = c17942np0.b();
                if (fO0 <= c17942np0.a() && fB2 <= fO0) {
                    fValueOf2 = Float.valueOf(c17942np0.b());
                }
            }
        }
        if (AbstractC13042fc3.c(fValueOf, fValueOf2)) {
            return set;
        }
        if (fValueOf != null) {
            fD0 = fValueOf.floatValue();
        }
        if (fValueOf2 != null) {
            fO0 = fValueOf2.floatValue();
        }
        return fD0 < fO0 ? AbstractC4846Gu6.m(set, new C17942np0(fD0, fO0)) : set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 a3(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC4557Fq2 interfaceC4557Fq23, InterfaceC4557Fq2 interfaceC4557Fq24, InterfaceC4557Fq2 interfaceC4557Fq25, InterfaceC4557Fq2 interfaceC4557Fq26, InterfaceC4557Fq2 interfaceC4557Fq27, InterfaceC4557Fq2 interfaceC4557Fq28, InterfaceC4557Fq2 interfaceC4557Fq29, InterfaceC4557Fq2 interfaceC4557Fq210, InterfaceC4557Fq2 interfaceC4557Fq211, WA2 wa2) {
        return new I(new InterfaceC4557Fq2[]{interfaceC4557Fq2, interfaceC4557Fq22, interfaceC4557Fq23, interfaceC4557Fq24, interfaceC4557Fq25, interfaceC4557Fq26, interfaceC4557Fq27, interfaceC4557Fq28, interfaceC4557Fq29, interfaceC4557Fq210, interfaceC4557Fq211}, wa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b3(Context context) {
        return Build.VERSION.SDK_INT <= 29 && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c2(com.google.android.exoplayer2.E0 e0, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(this.r.c(), new C21019d(e0, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    private final com.google.android.exoplayer2.E0 c3() {
        long jI = this.D.i();
        long jH = this.D.h();
        StringBuilder sb = new StringBuilder();
        sb.append(jI);
        sb.append(jH);
        com.google.android.exoplayer2.E0 e0E = HC6.e(this.j, sb.toString(), this, false, 4, null);
        if (e0E != null) {
            return e0E;
        }
        com.google.android.exoplayer2.E0 e0C = this.j.c();
        this.j.d(e0C, this);
        return e0C;
    }

    private final void d2(com.google.android.exoplayer2.E0 e0) {
        if (e0.f0() <= 0.0f) {
            e0.t();
        }
        if (e0.i()) {
            ir.nasim.core.modules.file.audio.audiofocus.a.h.a().e(this.Z);
        }
        e0.s(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 g2(AbstractC23884xg6 abstractC23884xg6) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.R(new C21021f(abstractC23884xg6, this, null)), this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC3336Al1 h2(com.google.android.exoplayer2.E0 e0, AbstractC23884xg6 abstractC23884xg6) {
        long jP = abstractC23884xg6.p();
        long jI = abstractC23884xg6.i();
        StringBuilder sb = new StringBuilder();
        sb.append(jP);
        sb.append(jI);
        String string = sb.toString();
        if (abstractC23884xg6 instanceof AbstractC23884xg6.b) {
            AbstractC23884xg6.b bVar = (AbstractC23884xg6.b) abstractC23884xg6;
            return new AbstractC3336Al1.b(string, new C15539jl1(bVar.s().getWidth(), bVar.s().getHeight()), t2(string, bVar));
        }
        if (abstractC23884xg6 instanceof AbstractC23884xg6.a) {
            AbstractC23884xg6.a aVar = (AbstractC23884xg6.a) abstractC23884xg6;
            return new AbstractC3336Al1.a(string, new C15539jl1(aVar.t().getWidth(), aVar.t().getHeight()), l2(string, aVar));
        }
        if (!(abstractC23884xg6 instanceof AbstractC23884xg6.c)) {
            throw new NoWhenBranchMatchedException();
        }
        return new AbstractC3336Al1.c(string, "thumb_" + string, C2(e0, string, (AbstractC23884xg6.c) abstractC23884xg6));
    }

    private final InterfaceC4557Fq2 i2(com.google.android.exoplayer2.E0 e0) {
        return AbstractC6459Nq2.V(new C21022g(this.J0, this, e0), this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 j2(AbstractC23884xg6 abstractC23884xg6) {
        boolean z2;
        InterfaceC18505om2 interfaceC18505om2J = abstractC23884xg6.j();
        if (interfaceC18505om2J instanceof C4512Fl2) {
            return AbstractC6459Nq2.T(new RY1.a(new C9115Yo(((C4512Fl2) interfaceC18505om2J).c)));
        }
        if (!(interfaceC18505om2J instanceof C11920dm2)) {
            throw new NoWhenBranchMatchedException();
        }
        FileReference fileReferenceB = ((C11920dm2) interfaceC18505om2J).b();
        if ((abstractC23884xg6 instanceof AbstractC23884xg6.b) || (abstractC23884xg6 instanceof AbstractC23884xg6.a)) {
            z2 = false;
        } else {
            if (!(abstractC23884xg6 instanceof AbstractC23884xg6.c)) {
                throw new NoWhenBranchMatchedException();
            }
            z2 = true;
        }
        return AbstractC6459Nq2.v(AbstractC6459Nq2.V(AbstractC6459Nq2.a0(AbstractC6459Nq2.R(new C21023h(fileReferenceB, z2, abstractC23884xg6, null)), new C21024i(fileReferenceB, null)), this.m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 k2(FragmentActivity fragmentActivity, AbstractC23884xg6.c cVar) {
        InterfaceC18505om2 interfaceC18505om2J = cVar.j();
        if (interfaceC18505om2J instanceof C4512Fl2) {
            return AbstractC6459Nq2.T(100);
        }
        if (interfaceC18505om2J instanceof C11920dm2) {
            return AbstractC6459Nq2.a0(AbstractC6459Nq2.h(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new C21025j(interfaceC18505om2J, fragmentActivity, cVar, null)), this.m), new C21026k(null)), new C21027l(interfaceC18505om2J, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void k3(C21015sz4 c21015sz4, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = false;
        }
        c21015sz4.j3(z2, z3);
    }

    private final InterfaceC4557Fq2 l2(String str, AbstractC23884xg6.a aVar) {
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.j(new C21028m(aVar, str, null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.a(5000L, 0L), new AbstractC14329hk1.a(null, null, null, null, false, null, null, 127, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List m2(final AbstractC23884xg6.a aVar, final String str) {
        List listS = AbstractC10360bX0.s(new C4337Er7(VD5.menu_item_show_all_media, AbstractC24778zB5.category, new UA2() { // from class: ir.nasim.jz4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21015sz4.n2(this.a, (FragmentActivity) obj);
            }
        }));
        if (str != null) {
            listS.add(new C4337Er7(VD5.menu_item_save_to_gallary, AbstractC24778zB5.image, new UA2() { // from class: ir.nasim.kz4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C21015sz4.o2(this.a, aVar, str, (FragmentActivity) obj);
                }
            }));
            listS.add(new C4337Er7(VD5.menu_item_share, AbstractC24778zB5.share, new UA2() { // from class: ir.nasim.lz4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C21015sz4.r2(aVar, this, str, (FragmentActivity) obj);
                }
            }));
            listS.add(new C4337Er7(VD5.menu_item_play_in_external_app, AbstractC24778zB5.open_with, new UA2() { // from class: ir.nasim.mz4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C21015sz4.s2(this.a, str, aVar, (FragmentActivity) obj);
                }
            }));
        }
        return listS;
    }

    public static /* synthetic */ void m3(C21015sz4 c21015sz4, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = false;
        }
        c21015sz4.l3(z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n2(C21015sz4 c21015sz4, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        fragmentActivity.startActivity(SharedMediaActivity.INSTANCE.a(fragmentActivity, c21015sz4.z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o2(final C21015sz4 c21015sz4, final AbstractC23884xg6.a aVar, final String str, final FragmentActivity fragmentActivity) {
        Object value;
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(aVar, "$searchMessage");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        if (!c21015sz4.b3(fragmentActivity)) {
            c21015sz4.q3(fragmentActivity, aVar, str, C8721Xa6.a.c);
            return C19938rB7.a;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = c21015sz4.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new XE4.b("android.permission.WRITE_EXTERNAL_STORAGE", new SA2() { // from class: ir.nasim.rz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21015sz4.p2(this.a, fragmentActivity, aVar, str);
            }
        })));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p2(C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.a aVar, String str) {
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "$activity");
        AbstractC13042fc3.i(aVar, "$searchMessage");
        c21015sz4.q3(fragmentActivity, aVar, str, C8721Xa6.a.c);
        return C19938rB7.a;
    }

    private final void p3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            this.j.a(this, e0);
            this.Z.e();
            e0.V0(this.u);
            this.A0 = null;
        }
    }

    private final void q3(FragmentActivity fragmentActivity, AbstractC23884xg6 abstractC23884xg6, String str, C8721Xa6.a aVar) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.m.X(C12798fB4.b), null, new J(fragmentActivity, str, abstractC23884xg6, aVar, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r2(AbstractC23884xg6.a aVar, C21015sz4 c21015sz4, String str, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(aVar, "$searchMessage");
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        String strO = aVar.o();
        if (strO == null) {
            strO = "image/gif";
        }
        String string = fragmentActivity.getString(VD5.menu_share);
        AbstractC13042fc3.h(string, "getString(...)");
        C7009Px6.b(c21015sz4.h, fragmentActivity, str, strO, string, aVar.h(), null, 32, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s2(C21015sz4 c21015sz4, String str, AbstractC23884xg6.a aVar, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(aVar, "$searchMessage");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        AbstractC10533bm0.d(AbstractC19224pz3.a(fragmentActivity), null, null, c21015sz4.new n(fragmentActivity, str, aVar, null), 3, null);
        return C19938rB7.a;
    }

    private final InterfaceC4557Fq2 t2(String str, AbstractC23884xg6.b bVar) {
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.j(new o(bVar, str, null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.a(5000L, 0L), new AbstractC14329hk1.b(null, null, null, null, false, null, null, 127, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List u2(final AbstractC23884xg6.b bVar, final String str) {
        List listS = AbstractC10360bX0.s(new C4337Er7(VD5.menu_item_show_all_media, AbstractC24778zB5.category, new UA2() { // from class: ir.nasim.nz4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21015sz4.y2(this.a, (FragmentActivity) obj);
            }
        }));
        if (str != null) {
            listS.add(new C4337Er7(VD5.menu_item_save_to_gallary, AbstractC24778zB5.image, new UA2() { // from class: ir.nasim.oz4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C21015sz4.w2(this.a, bVar, str, (FragmentActivity) obj);
                }
            }));
            listS.add(new C4337Er7(VD5.menu_item_share, AbstractC24778zB5.share, new UA2() { // from class: ir.nasim.pz4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C21015sz4.v2(bVar, this, str, (FragmentActivity) obj);
                }
            }));
        }
        return listS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v2(AbstractC23884xg6.b bVar, C21015sz4 c21015sz4, String str, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(bVar, "$searchMessage");
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        String strO = bVar.o();
        if (strO == null) {
            strO = "image/jpeg";
        }
        String string = fragmentActivity.getString(VD5.menu_share);
        AbstractC13042fc3.h(string, "getString(...)");
        C7009Px6.b(c21015sz4.h, fragmentActivity, str, strO, string, bVar.h(), null, 32, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w2(final C21015sz4 c21015sz4, final AbstractC23884xg6.b bVar, final String str, final FragmentActivity fragmentActivity) {
        Object value;
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(bVar, "$searchMessage");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        if (!c21015sz4.b3(fragmentActivity)) {
            c21015sz4.q3(fragmentActivity, bVar, str, C8721Xa6.a.b);
            return C19938rB7.a;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = c21015sz4.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new XE4.b("android.permission.WRITE_EXTERNAL_STORAGE", new SA2() { // from class: ir.nasim.qz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21015sz4.x2(this.a, fragmentActivity, bVar, str);
            }
        })));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x2(C21015sz4 c21015sz4, FragmentActivity fragmentActivity, AbstractC23884xg6.b bVar, String str) {
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "$activity");
        AbstractC13042fc3.i(bVar, "$searchMessage");
        c21015sz4.q3(fragmentActivity, bVar, str, C8721Xa6.a.b);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y2(C21015sz4 c21015sz4, FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(c21015sz4, "this$0");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        fragmentActivity.startActivity(SharedMediaActivity.INSTANCE.a(fragmentActivity, c21015sz4.z));
        return C19938rB7.a;
    }

    private final InterfaceC10258bL6 z2(com.google.android.exoplayer2.E0 e0) {
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.b0(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new p(e0, null)), this.n), new q(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), D2(e0));
    }

    public final void A3() {
        Object value;
        AbstractC23884xg6 abstractC23884xg6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H0;
        do {
            value = interfaceC9336Zm4.getValue();
            XV4 xv4 = (XV4) value;
            long jLongValue = ((Number) xv4.a()).longValue();
            long jLongValue2 = ((Number) xv4.b()).longValue();
            List listA = ((C12486eh6) this.I0.getValue()).a();
            Iterator it = listA.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                AbstractC23884xg6 abstractC23884xg62 = (AbstractC23884xg6) it.next();
                if (abstractC23884xg62.p() == jLongValue && abstractC23884xg62.i() == jLongValue2) {
                    break;
                } else {
                    i++;
                }
            }
            abstractC23884xg6 = (AbstractC23884xg6) AbstractC15401jX0.t0(listA, i + 1);
            if (abstractC23884xg6 == null) {
                return;
            }
        } while (!interfaceC9336Zm4.f(value, AbstractC4616Fw7.a(Long.valueOf(abstractC23884xg6.p()), Long.valueOf(abstractC23884xg6.i()))));
    }

    public final void C3(EnumC9274Zf5 enumC9274Zf5) {
        EnumC9274Zf5 enumC9274Zf52;
        AbstractC13042fc3.i(enumC9274Zf5, "playbackSpeed");
        int i = C21018c.b[enumC9274Zf5.ordinal()];
        if (i == 1) {
            enumC9274Zf52 = EnumC9274Zf5.e;
        } else if (i == 2) {
            enumC9274Zf52 = EnumC9274Zf5.f;
        } else if (i == 3) {
            enumC9274Zf52 = EnumC9274Zf5.g;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            enumC9274Zf52 = EnumC9274Zf5.d;
        }
        float fQ = enumC9274Zf52.q();
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.Q0(fQ);
        }
    }

    public final void D3(Configuration configuration) {
        Object value;
        AbstractC13042fc3.i(configuration, "configuration");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ((RJ1) value).a(EnumC23696xM4.a.b(configuration.orientation))));
    }

    public final com.google.android.exoplayer2.E0 F2() {
        return this.A0;
    }

    public final com.google.android.exoplayer2.E0 J2() {
        return this.g;
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        this.Z.e();
        p3();
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(this.Z);
        this.g.release();
        super.L0();
    }

    public final XV4 M2() {
        return this.d.I4();
    }

    public final InterfaceC10258bL6 N2() {
        return this.M0;
    }

    public final void Y2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new C3345Am1(false, false, false, ((C3345Am1) value).e(), false, false, 54, null)));
    }

    public final void d3() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void e2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, false, false, false, 59, null)));
    }

    public final void e3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        boolean z2 = false;
        if (e0 != null && e0.X()) {
            z2 = true;
        }
        this.z0 = z2;
        n3();
    }

    public final void f2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, true, false, true, false, false, false, 58, null)));
    }

    public final void g3() {
        if (this.z0) {
            o3();
        }
        this.z0 = false;
    }

    public final void h3(long j) {
        this.g.x(j);
    }

    public final void i3() {
        Y2();
        p3();
    }

    public final void j3(boolean z2, boolean z3) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, true, false, false, z2, false, z3, 22, null)));
    }

    public final void l3(boolean z2, boolean z3) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, z2, false, z3, 23, null)));
    }

    public final void n3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.h();
        }
    }

    public final void o3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.q();
            if (e0.D0() >= e0.f()) {
                e0.t();
            }
        }
    }

    public final void r3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.x(Math.max(e0.D0() - 10000, 0L));
        }
    }

    public final void s3() {
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.x(Math.min(e0.D0() + 10000, e0.f()));
        }
    }

    public final void t3() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, true, false, false, false, false, false, 62, null)));
    }

    public final void u3() {
        Object value;
        Object value2;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, false, true, false, 47, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.B0;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, EnumC18448og5.c));
    }

    public final void v3() {
        Object value;
        Object value2;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, false, true, false, 47, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.B0;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, EnumC18448og5.b));
    }

    public final void w3(long j) {
        Object value;
        com.google.android.exoplayer2.E0 e0 = this.g;
        if (e0.p() != 3) {
            this.g.r();
        }
        e0.x(j);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, true, false, false, false, false, 61, null)));
    }

    public final void x3() {
        Object value;
        Object value2;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, false, false, false, 47, null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.B0;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, EnumC18448og5.a));
    }

    public final void y3(long j) {
        Object value;
        com.google.android.exoplayer2.E0 e0 = this.A0;
        if (e0 != null) {
            e0.x(j);
            this.g.x(j);
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C3345Am1.b((C3345Am1) value, false, false, false, false, false, false, 61, null)));
        }
    }

    public final void z3() {
        Object value;
        AbstractC23884xg6 abstractC23884xg6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H0;
        do {
            value = interfaceC9336Zm4.getValue();
            XV4 xv4 = (XV4) value;
            long jLongValue = ((Number) xv4.a()).longValue();
            long jLongValue2 = ((Number) xv4.b()).longValue();
            List listA = ((C12486eh6) this.I0.getValue()).a();
            Iterator it = listA.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                AbstractC23884xg6 abstractC23884xg62 = (AbstractC23884xg6) it.next();
                if (abstractC23884xg62.p() == jLongValue && abstractC23884xg62.i() == jLongValue2) {
                    break;
                } else {
                    i++;
                }
            }
            abstractC23884xg6 = (AbstractC23884xg6) AbstractC15401jX0.t0(listA, i - 1);
            if (abstractC23884xg6 == null) {
                return;
            }
        } while (!interfaceC9336Zm4.f(value, AbstractC4616Fw7.a(Long.valueOf(abstractC23884xg6.p()), Long.valueOf(abstractC23884xg6.i()))));
    }
}
