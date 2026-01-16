package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C5614Kc0;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.entity.ChangeLogData;
import ir.nasim.core.runtime.AccountInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Kc0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5614Kc0 extends VW7 {
    public static final m s = new m(null);
    public static final int t = 8;
    private final int b;
    private final InterfaceC11621dJ7 c;
    private final DG2 d;
    private final LQ e;
    private final KM2 f;
    private final SettingsModule g;
    private final C15346jR h;
    private final C6287Mz i;
    private final OK7 j;
    private final C12720f53 k;
    private final InterfaceC3570Bk5 l;
    private final YA6 m;
    private final InterfaceC5943Lm5 n;
    private final AbstractC13778go1 o;
    private InterfaceC9102Ym4 p;
    private final InterfaceC9664aL6 q;
    private final InterfaceC14371ho1 r;

    /* renamed from: ir.nasim.Kc0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kc0$a$a, reason: collision with other inner class name */
        static final class C0467a implements InterfaceC4806Gq2 {
            final /* synthetic */ C5614Kc0 a;

            C0467a(C5614Kc0 c5614Kc0) {
                this.a = c5614Kc0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C3254Ac0 g(boolean z, C3254Ac0 c3254Ac0) {
                AbstractC13042fc3.i(c3254Ac0, "it");
                return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : z, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return e(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object e(final boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                C5614Kc0 c5614Kc0 = this.a;
                c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Jc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C5614Kc0.a.C0467a.g(z, (C3254Ac0) obj);
                    }
                });
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2G = C5614Kc0.this.n.g();
                C0467a c0467a = new C0467a(C5614Kc0.this);
                this.b = 1;
                if (interfaceC4557Fq2G.b(c0467a, this) == objE) {
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

    /* renamed from: ir.nasim.Kc0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kc0$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C5614Kc0 a;

            a(C5614Kc0 c5614Kc0) {
                this.a = c5614Kc0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C3254Ac0 g(long j, C3254Ac0 c3254Ac0) {
                AbstractC13042fc3.i(c3254Ac0, "it");
                return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : j);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return e(((Number) obj).longValue(), interfaceC20295rm1);
            }

            public final Object e(final long j, InterfaceC20295rm1 interfaceC20295rm1) {
                C5614Kc0 c5614Kc0 = this.a;
                c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Lc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C5614Kc0.b.a.g(j, (C3254Ac0) obj);
                    }
                });
                return C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2C = C5614Kc0.this.n.c();
                a aVar = new a(C5614Kc0.this);
                this.b = 1;
                if (interfaceC4557Fq2C.b(aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Kc0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kc0$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C5614Kc0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C5614Kc0 c5614Kc0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c5614Kc0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C3254Ac0 y(String str, C3254Ac0 c3254Ac0) {
                return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : C3727Cc0.b(c3254Ac0.l(), 0, null, null, null, null, str, 31, null), (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                final String str = (String) this.c;
                C5614Kc0 c5614Kc0 = this.d;
                c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Mc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C5614Kc0.c.a.y(str, (C3254Ac0) obj2);
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Kc0$c$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C5614Kc0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, C5614Kc0 c5614Kc0) {
                super(3, interfaceC20295rm1);
                this.e = c5614Kc0;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    XV4 xv4 = (XV4) this.d;
                    InterfaceC4557Fq2 interfaceC4557Fq2L = this.e.n.l(((Number) xv4.a()).longValue(), (String) xv4.b());
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2L, this) == objE) {
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
                b bVar = new b(interfaceC20295rm1, this.e);
                bVar.c = interfaceC4806Gq2;
                bVar.d = obj;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(C5614Kc0.this.n.h(), new b(null, C5614Kc0.this));
                a aVar = new a(C5614Kc0.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S0, aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(int i, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : EnumC6196Mo7.b.a(i), (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final int iW1 = C5614Kc0.this.w1();
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Ic0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.d.y(iW1, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kc0$e$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C5614Kc0 a;

            a(C5614Kc0 c5614Kc0) {
                this.a = c5614Kc0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C3254Ac0 g(AbstractC12129e53 abstractC12129e53, C3254Ac0 c3254Ac0) {
                AbstractC13042fc3.i(abstractC12129e53, "$inAppUpdateState");
                AbstractC13042fc3.i(c3254Ac0, "it");
                return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : abstractC12129e53, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(final AbstractC12129e53 abstractC12129e53, InterfaceC20295rm1 interfaceC20295rm1) {
                C5614Kc0 c5614Kc0 = this.a;
                c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Nc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C5614Kc0.e.a.g(abstractC12129e53, (C3254Ac0) obj);
                    }
                });
                return C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6K = C5614Kc0.this.k.k();
                a aVar = new a(C5614Kc0.this);
                this.b = 1;
                if (interfaceC10258bL6K.b(aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            OK7 ok7 = C5614Kc0.this.j;
            Set setO = C13923h3.a.o();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setO, 10));
            Iterator it = setO.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC6392Nk0.d(Integer.parseInt((String) it.next())));
            }
            ok7.w0(arrayList, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5614Kc0 c5614Kc0 = C5614Kc0.this;
                this.b = 1;
                if (c5614Kc0.J1(this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(String str, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : str, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final String strU1 = C5614Kc0.this.u1();
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Oc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.h.y(strU1, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(boolean z, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : z, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final boolean zR7 = C5614Kc0.this.g.R7();
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Pc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.i.y(zR7, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(ChangeLogData changeLogData, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : new PI0(changeLogData != null ? changeLogData.getVersionName() : null, changeLogData != null ? changeLogData.getChangeLog() : null), (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final ChangeLogData changeLogDataF1 = C5614Kc0.this.g.f1();
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Qc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.j.y(changeLogDataF1, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(boolean z, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : z, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5614Kc0 c5614Kc0 = C5614Kc0.this;
                this.b = 1;
                obj = c5614Kc0.M1(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            C5614Kc0 c5614Kc02 = C5614Kc0.this;
            c5614Kc02.S1(c5614Kc02.p, new UA2() { // from class: ir.nasim.Rc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.k.y(zBooleanValue, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(C5614Kc0 c5614Kc0, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : c5614Kc0.g.G0(), (12287 & 1024) != 0 ? c3254Ac0.k : c5614Kc0.g.E0(), (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            InterfaceC9102Ym4 interfaceC9102Ym4 = c5614Kc0.p;
            final C5614Kc0 c5614Kc02 = C5614Kc0.this;
            c5614Kc0.S1(interfaceC9102Ym4, new UA2() { // from class: ir.nasim.Sc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.l.y(c5614Kc02, (C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$m */
    public static final class m {
        private m() {
        }

        public /* synthetic */ m(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kc0$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC6196Mo7 d;

        /* renamed from: ir.nasim.Kc0$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ EnumC6196Mo7 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(EnumC6196Mo7 enumC6196Mo7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = enumC6196Mo7;
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
                C7183Qq.q(EnumC18608ow5.d).putInt("Theme_Pref", this.c.p());
                C19406qI3.a("BaseSettingsViewModel", "Change app theme preferences", new Object[0]);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(EnumC6196Mo7 enumC6196Mo7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC6196Mo7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new n(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5614Kc0 c5614Kc0 = C5614Kc0.this;
                c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Tc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C5614Kc0.n.y((C3254Ac0) obj2);
                    }
                });
                C3493Bc0.a.a((C3254Ac0) C5614Kc0.this.x1().getValue());
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C5495Jo7.K2(this.d.p(), C5721Ko.a.d());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC6196Mo7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(EnumC6196Mo7 enumC6196Mo7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC6196Mo7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 D(C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : true, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 z(EnumC6196Mo7 enumC6196Mo7, C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : enumC6196Mo7, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            boolean z = ((C3254Ac0) C5614Kc0.this.x1().getValue()).k() != this.d;
            boolean z2 = ((C3254Ac0) C5614Kc0.this.x1().getValue()).k().q() != this.d.q();
            C19406qI3.a("BaseSettingsViewModel", "Change screen theme, new mode: " + this.d.name(), new Object[0]);
            C19406qI3.a("BaseSettingsViewModel", "Change screen theme, theme changed: " + z, new Object[0]);
            C19406qI3.a("BaseSettingsViewModel", "Change screen theme, night changed: " + z2, new Object[0]);
            if (!z) {
                return C19938rB7.a;
            }
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            InterfaceC9102Ym4 interfaceC9102Ym4 = c5614Kc0.p;
            final EnumC6196Mo7 enumC6196Mo7 = this.d;
            c5614Kc0.S1(interfaceC9102Ym4, new UA2() { // from class: ir.nasim.Uc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.o.z(enumC6196Mo7, (C3254Ac0) obj2);
                }
            });
            if (z2) {
                C5614Kc0 c5614Kc02 = C5614Kc0.this;
                c5614Kc02.S1(c5614Kc02.p, new UA2() { // from class: ir.nasim.Vc0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C5614Kc0.o.D((C3254Ac0) obj2);
                    }
                });
            } else {
                C5614Kc0.this.m1(this.d);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5614Kc0.this.H1(true);
                LQ lq = C5614Kc0.this.e;
                this.b = 1;
                objG = lq.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                c5614Kc0.N1(QD5.base_settings_logout_failed_toast);
                C19406qI3.d("BaseSettingsViewModel-ExceptionHandler", thE);
            }
            C5614Kc0.this.H1(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new q(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C11458d25 c11458d25;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25R = C11458d25.r(C5614Kc0.this.g.H0());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeA = X25.a(c11458d25R);
                if (exPeerTypeA != null) {
                    this.e.invoke(c11458d25R, exPeerTypeA);
                    return C19938rB7.a;
                }
                KM2 km2 = C5614Kc0.this.f;
                int peerId = c11458d25R.getPeerId();
                this.b = c11458d25R;
                this.c = 1;
                Object objH = KM2.h(km2, peerId, false, this, 2, null);
                if (objH == objE) {
                    return objE;
                }
                c11458d25 = c11458d25R;
                objL = objH;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c11458d25 = (C11458d25) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            if (C9475a16.j(objL)) {
                ExPeerType exPeerTypeA2 = X25.a(c11458d25);
                AbstractC13042fc3.f(exPeerTypeA2);
                interfaceC14603iB2.invoke(c11458d25, exPeerTypeA2);
            }
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            if (C9475a16.e(objL) != null) {
                c5614Kc0.N1(QD5.error_unknown);
            }
            C9475a16.a(objL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new r(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C11458d25 c11458d25;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C5614Kc0.this.H1(true);
                C11458d25 c11458d25R = C11458d25.r(C5614Kc0.this.g.M0());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                ExPeerType exPeerTypeA = X25.a(c11458d25R);
                if (exPeerTypeA != null) {
                    this.e.invoke(c11458d25R, exPeerTypeA);
                    C5614Kc0.this.H1(false);
                    return C19938rB7.a;
                }
                InterfaceC11621dJ7 interfaceC11621dJ7 = C5614Kc0.this.c;
                long peerId = c11458d25R.getPeerId();
                this.b = c11458d25R;
                this.c = 1;
                Object objQ = InterfaceC11621dJ7.q(interfaceC11621dJ7, peerId, false, this, 2, null);
                if (objQ == objE) {
                    return objE;
                }
                c11458d25 = c11458d25R;
                objL = objQ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c11458d25 = (C11458d25) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            if (C9475a16.j(objL)) {
                ExPeerType exPeerTypeA2 = X25.a(c11458d25);
                AbstractC13042fc3.f(exPeerTypeA2);
                interfaceC14603iB2.invoke(c11458d25, exPeerTypeA2);
            }
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            if (C9475a16.e(objL) != null) {
                c5614Kc0.N1(QD5.error_unknown);
            }
            C9475a16.a(objL);
            C5614Kc0.this.H1(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kc0$s$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C5614Kc0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C5614Kc0 c5614Kc0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c5614Kc0;
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
                this.c.g.E7(false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C3254Ac0 y(C3254Ac0 c3254Ac0) {
            return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (((C3254Ac0) C5614Kc0.this.p.getValue()).i()) {
                    AbstractC13778go1 abstractC13778go1 = C5614Kc0.this.o;
                    a aVar = new a(C5614Kc0.this, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C5614Kc0 c5614Kc0 = C5614Kc0.this;
            c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Wc0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C5614Kc0.s.y((C3254Ac0) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$t */
    static final class t extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C5614Kc0.this.J1(this);
        }
    }

    /* renamed from: ir.nasim.Kc0$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5614Kc0.this.new u(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(C5614Kc0.this.m.a());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kc0$v */
    public static final class v extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C5614Kc0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(InterfaceC14371ho1.a aVar, C5614Kc0 c5614Kc0) {
            super(aVar);
            this.b = c5614Kc0;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            this.b.N1(QD5.error_unknown);
            C19406qI3.c("BaseSettingsViewModel-ExceptionHandler", "Unknown", th);
        }
    }

    /* renamed from: ir.nasim.Kc0$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new w(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC20507s76.F(this.c, new Intent());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C5614Kc0(int i2, InterfaceC11621dJ7 interfaceC11621dJ7, DG2 dg2, LQ lq, KM2 km2, SettingsModule settingsModule, C15346jR c15346jR, C6287Mz c6287Mz, OK7 ok7, C12720f53 c12720f53, InterfaceC3570Bk5 interfaceC3570Bk5, YA6 ya6, InterfaceC5943Lm5 interfaceC5943Lm5, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(dg2, "getUserVmUseCase");
        AbstractC13042fc3.i(lq, "authRepository");
        AbstractC13042fc3.i(km2, "groupsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(c12720f53, "inAppUpdateStateManager");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(ya6, "shouldShowFoldersBadgeUseCase");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = i2;
        this.c = interfaceC11621dJ7;
        this.d = dg2;
        this.e = lq;
        this.f = km2;
        this.g = settingsModule;
        this.h = c15346jR;
        this.i = c6287Mz;
        this.j = ok7;
        this.k = c12720f53;
        this.l = interfaceC3570Bk5;
        this.m = ya6;
        this.n = interfaceC5943Lm5;
        this.o = abstractC13778go1;
        C3254Ac0 c3254Ac0B = C3493Bc0.a.b();
        InterfaceC9102Ym4 interfaceC9102Ym4D = AbstractC13472gH6.d(c3254Ac0B == null ? new C3254Ac0(null, null, false, false, false, null, null, null, false, null, null, null, false, 0L, 16383, null) : c3254Ac0B, null, 2, null);
        this.p = interfaceC9102Ym4D;
        this.q = interfaceC9102Ym4D;
        this.r = new v(InterfaceC14371ho1.h0, this);
        D1(new d(null));
        D1(new e(null));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
        D1(new g(null));
        D1(new h(null));
        D1(new i(null));
        D1(new j(null));
        D1(new k(null));
        D1(new l(null));
        D1(new a(null));
        D1(new b(null));
        if (C8386Vt0.a.n9()) {
            D1(new c(null));
        }
    }

    private final InterfaceC13730gj3 D1(InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.r, null, interfaceC14603iB2, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(final boolean z) {
        S1(this.p, new UA2() { // from class: ir.nasim.Dc0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5614Kc0.I1(z, (C3254Ac0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3254Ac0 I1(boolean z, C3254Ac0 c3254Ac0) {
        AbstractC13042fc3.i(c3254Ac0, "it");
        return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : z, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J1(ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof ir.nasim.C5614Kc0.t
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.Kc0$t r0 = (ir.nasim.C5614Kc0.t) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Kc0$t r0 = new ir.nasim.Kc0$t
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r0 = r0.a
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            r12.l()
            goto Lb3
        L36:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3e:
            java.lang.Object r2 = r0.a
            ir.nasim.Kc0 r2 = (ir.nasim.C5614Kc0) r2
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r12 = r12.l()
            goto L5d
        L4c:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.DG2 r12 = r11.d
            r0.a = r11
            r0.d = r4
            java.lang.Object r12 = r12.a(r0)
            if (r12 != r1) goto L5c
            return r1
        L5c:
            r2 = r11
        L5d:
            boolean r4 = ir.nasim.C9475a16.j(r12)
            if (r4 == 0) goto L85
            r4 = r12
            ir.nasim.tK7 r4 = (ir.nasim.C21231tK7) r4
            if (r4 == 0) goto L85
            ir.nasim.sp4 r5 = new ir.nasim.sp4
            r5.<init>()
            ir.nasim.bZ6 r6 = r4.r()
            ir.nasim.bZ6 r7 = r4.s()
            ir.nasim.qQ7 r8 = r4.h()
            ir.nasim.qQ7 r9 = r4.u()
            ir.nasim.Fc0 r10 = new ir.nasim.Fc0
            r10.<init>()
            r5.v(r6, r7, r8, r9, r10)
        L85:
            ir.nasim.a16 r12 = ir.nasim.C9475a16.a(r12)
            r12.l()
            ir.nasim.Ym4 r4 = r2.p
            java.lang.Object r4 = r4.getValue()
            ir.nasim.Ac0 r4 = (ir.nasim.C3254Ac0) r4
            ir.nasim.Cc0 r4 = r4.l()
            java.lang.String r4 = r4.f()
            if (r4 == 0) goto La4
            int r4 = r4.length()
            if (r4 != 0) goto Lb3
        La4:
            ir.nasim.dJ7 r4 = r2.c
            int r2 = r2.b
            r0.a = r12
            r0.d = r3
            java.lang.Object r12 = r4.o(r2, r0)
            if (r12 != r1) goto Lb3
            return r1
        Lb3:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5614Kc0.J1(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(C21231tK7 c21231tK7, C5614Kc0 c5614Kc0, String str, AbstractC13554gQ7 abstractC13554gQ7, String str2, AbstractC13554gQ7 abstractC13554gQ72, Avatar avatar, AbstractC13554gQ7 abstractC13554gQ73, ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ74) {
        AbstractC13042fc3.i(c5614Kc0, "this$0");
        int iO = c21231tK7.o();
        AbstractC13042fc3.f(str);
        AbstractC13042fc3.f(arrayList);
        NI7 ni7 = (NI7) AbstractC15401jX0.s0(arrayList);
        final C3727Cc0 c3727Cc0 = new C3727Cc0(iO, str, str2 != null ? c5614Kc0.t1(str2) : null, ni7 != null ? c5614Kc0.s1(ni7.a()) : null, avatar, null, 32, null);
        c5614Kc0.S1(c5614Kc0.p, new UA2() { // from class: ir.nasim.Hc0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5614Kc0.L1(c3727Cc0, (C3254Ac0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3254Ac0 L1(C3727Cc0 c3727Cc0, C3254Ac0 c3254Ac0) {
        AbstractC13042fc3.i(c3727Cc0, "$userData");
        AbstractC13042fc3.i(c3254Ac0, "it");
        return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : C3727Cc0.b(c3254Ac0.l(), c3727Cc0.d(), c3727Cc0.e(), c3727Cc0.h(), c3727Cc0.f(), c3727Cc0.c(), null, 32, null), (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M1(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.o, new u(null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3254Ac0 O1(int i2, C3254Ac0 c3254Ac0) {
        AbstractC13042fc3.i(c3254Ac0, "it");
        return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : Integer.valueOf(i2), (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3254Ac0 Q1(C3254Ac0 c3254Ac0) {
        AbstractC13042fc3.i(c3254Ac0, "it");
        return c3254Ac0.a((12287 & 1) != 0 ? c3254Ac0.a : null, (12287 & 2) != 0 ? c3254Ac0.b : null, (12287 & 4) != 0 ? c3254Ac0.c : false, (12287 & 8) != 0 ? c3254Ac0.d : false, (12287 & 16) != 0 ? c3254Ac0.e : false, (12287 & 32) != 0 ? c3254Ac0.f : null, (12287 & 64) != 0 ? c3254Ac0.g : null, (12287 & 128) != 0 ? c3254Ac0.h : null, (12287 & 256) != 0 ? c3254Ac0.i : false, (12287 & 512) != 0 ? c3254Ac0.j : null, (12287 & 1024) != 0 ? c3254Ac0.k : null, (12287 & 2048) != 0 ? c3254Ac0.l : null, (12287 & 4096) != 0 ? c3254Ac0.m : false, (12287 & 8192) != 0 ? c3254Ac0.n : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
        interfaceC9102Ym4.setValue(ua2.invoke(interfaceC9102Ym4.getValue()));
    }

    private final String s1(long j2) {
        return AbstractC12152e76.b("+" + j2);
    }

    private final String t1(String str) {
        return Separators.AT + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u1() {
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        String strK = new C20644sM5("-").k(strR, "");
        if (JF5.g()) {
            strK = XY6.e(strK);
        }
        return Separators.SP + strK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w1() {
        return C7183Qq.q(EnumC18608ow5.d).getInt("Theme_Pref", 1);
    }

    public final void A1() {
        D1(new p(null));
    }

    public final void B1(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "navigateToChat");
        D1(new q(interfaceC14603iB2, null));
    }

    public final void C1(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "navigateToChat");
        D1(new r(interfaceC14603iB2, null));
    }

    public final void E1() {
        C3343Am.g("add_account_click");
    }

    public final void F1(int i2) {
        C19482qQ7 c19482qQ7U;
        ArrayList arrayList;
        NI7 ni7;
        Map mapD = AbstractC19460qO3.d();
        mapD.put("intended_user_id", String.valueOf(i2));
        C21231tK7 c21231tK7 = (C21231tK7) this.j.o0().n(this.b);
        mapD.put("hashed_phone", String.valueOf((c21231tK7 == null || (c19482qQ7U = c21231tK7.u()) == null || (arrayList = (ArrayList) c19482qQ7U.b()) == null || (ni7 = (NI7) AbstractC15401jX0.s0(arrayList)) == null) ? 0L : ni7.a()));
        mapD.put("intended_hashed_phone", String.valueOf(C13923h3.a.i(i2).getPhone()));
        C3343Am.e("switch_account", AbstractC19460qO3.c(mapD));
    }

    public final void G1() {
        D1(new s(null));
    }

    public final void N1(final int i2) {
        S1(this.p, new UA2() { // from class: ir.nasim.Gc0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5614Kc0.O1(i2, (C3254Ac0) obj);
            }
        });
    }

    public final void P1() {
        S1(this.p, new UA2() { // from class: ir.nasim.Ec0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5614Kc0.Q1((C3254Ac0) obj);
            }
        });
    }

    public final void R1(int i2) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new w(i2, null), 3, null);
    }

    public final boolean l1() {
        return !this.g.N4() && C8386Vt0.U7();
    }

    public final void m1(EnumC6196Mo7 enumC6196Mo7) {
        AbstractC13042fc3.i(enumC6196Mo7, "newThemeMode");
        D1(new n(enumC6196Mo7, null));
    }

    public final void o1(boolean z) {
        this.g.Q7(z);
        C15225jD4.b().c(C15225jD4.G, new Object[0]);
    }

    public final void p1(EnumC6196Mo7 enumC6196Mo7) {
        AbstractC13042fc3.i(enumC6196Mo7, "newThemeMode");
        D1(new o(enumC6196Mo7, null));
    }

    public final void q1() {
        AccountInfo accountInfoK = C13923h3.a.k();
        if (this.h.h() != accountInfoK.getAuthId()) {
            this.i.L();
            C6287Mz c6287Mz = this.i;
            long authId = accountInfoK.getAuthId();
            byte[] masterKey = accountInfoK.getMasterKey();
            if (masterKey == null) {
                masterKey = new byte[0];
            }
            c6287Mz.I(authId, masterKey);
        }
    }

    public final C11458d25 v1() {
        return new C11458d25(W25.a, this.b);
    }

    public final InterfaceC9664aL6 x1() {
        return this.q;
    }

    public final C17637nI7 y1(int i2) {
        C17637nI7 c17637nI7 = (C17637nI7) this.j.p0().d(i2);
        return c17637nI7 == null ? (C17637nI7) AbstractC16720ll0.b((AbstractC17902nl0) C17637nI7.D.a(), C13923h3.a.i(i2).getUser()) : c17637nI7;
    }

    public final void z1(InterfaceC13356g53 interfaceC13356g53) {
        AbstractC13042fc3.i(interfaceC13356g53, "inAppUpdateUiAction");
        this.k.o(interfaceC13356g53);
    }
}
