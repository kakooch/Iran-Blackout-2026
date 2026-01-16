package ir.nasim;

import android.app.Activity;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.AbstractC1970f;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC16345l7;
import ir.nasim.AbstractC20016rK4;
import ir.nasim.AbstractC4820Gr7;
import ir.nasim.C20085rS1;
import ir.nasim.InterfaceC19425qK4;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.eventbar.data.model.EventBarData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rS1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20085rS1 extends VW7 {
    public static final e W0 = new e(null);
    public static final int X0 = 8;
    private final InterfaceC9336Zm4 A;
    private final androidx.lifecycle.r A0;
    private final androidx.lifecycle.r B;
    private final androidx.lifecycle.r B0;
    private final InterfaceC9336Zm4 C0;
    private final InterfaceC9336Zm4 D;
    private final C20298rm4 D0;
    private final C20298rm4 E0;
    private C21167tD6 F0;
    private final androidx.lifecycle.r G;
    private androidx.lifecycle.r G0;
    private final InterfaceC9336Zm4 H;
    private final InterfaceC10258bL6 H0;
    private final androidx.lifecycle.r I0;
    private final androidx.lifecycle.r J;
    private final InterfaceC10258bL6 J0;
    private final InterfaceC9336Zm4 K0;
    private final androidx.lifecycle.r L0;
    private final InterfaceC9336Zm4 M0;
    private final androidx.lifecycle.r N0;
    private final InterfaceC9336Zm4 O0;
    private final androidx.lifecycle.r P0;
    private final InterfaceC9336Zm4 Q0;
    private final androidx.lifecycle.r R0;
    private final InterfaceC9336Zm4 S0;
    private final InterfaceC9336Zm4 T0;
    private final InterfaceC9336Zm4 U0;
    private final androidx.lifecycle.r V0;
    private final InterfaceC8327Vm4 Y;
    private final InterfaceC10040ay6 Z;
    private final OK7 b;
    private final PE c;
    private final SettingsModule d;
    private final InterfaceC3570Bk5 e;
    private final InterfaceC13266fw0 f;
    private final InterfaceC8038Ug3 g;
    private final HO1 h;
    private final C22091uf i;
    private final C4413Fa2 j;
    private final C6409Nm k;
    private final E84 l;
    private final C4471Fg6 m;
    private final C10299bQ2 n;
    private final C8054Ui1 o;
    private final C18804pH1 p;
    private final C18656p16 q;
    private final C15732k47 r;
    private final InterfaceC19567qa2 s;
    private final C12720f53 t;
    private final InterfaceC8327Vm4 u;
    private final androidx.lifecycle.r v;
    private final InterfaceC9336Zm4 w;
    private final androidx.lifecycle.r x;
    private final InterfaceC9173Yu3 y;
    private final InterfaceC9336Zm4 z;
    private final InterfaceC8327Vm4 z0;

    /* renamed from: ir.nasim.rS1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rS1$a$a, reason: collision with other inner class name */
        static final class C1497a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20085rS1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1497a(C20085rS1 c20085rS1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20085rS1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1497a c1497a = new C1497a(this.d, interfaceC20295rm1);
                c1497a.c = obj;
                return c1497a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                Object value2;
                Object value3;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Integer num = (Integer) this.c;
                if (num == null && ((Boolean) this.d.A.getValue()).booleanValue()) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.A;
                    do {
                        value3 = interfaceC9336Zm4.getValue();
                        ((Boolean) value3).booleanValue();
                    } while (!interfaceC9336Zm4.f(value3, AbstractC6392Nk0.a(false)));
                } else {
                    if ((num != null ? num.intValue() : 0) < 3 || ((Boolean) this.d.A.getValue()).booleanValue()) {
                        if ((num != null ? num.intValue() : 0) < 3 && ((Boolean) this.d.A.getValue()).booleanValue()) {
                            InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.A;
                            do {
                                value = interfaceC9336Zm42.getValue();
                                ((Boolean) value).booleanValue();
                            } while (!interfaceC9336Zm42.f(value, AbstractC6392Nk0.a(false)));
                        }
                    } else {
                        InterfaceC9336Zm4 interfaceC9336Zm43 = this.d.A;
                        do {
                            value2 = interfaceC9336Zm43.getValue();
                            ((Boolean) value2).booleanValue();
                        } while (!interfaceC9336Zm43.f(value2, AbstractC6392Nk0.a(true)));
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1497a) create(num, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20085rS1.this.z;
                C1497a c1497a = new C1497a(C20085rS1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4, c1497a, this) == objE) {
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

    /* renamed from: ir.nasim.rS1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rS1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC18160oB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ boolean d;
            /* synthetic */ boolean e;
            final /* synthetic */ C20085rS1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20085rS1 c20085rS1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(5, interfaceC20295rm1);
                this.f = c20085rS1;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EnumC5838Lb enumC5838Lb = (EnumC5838Lb) this.c;
                boolean z = this.d;
                boolean z2 = this.e;
                if (z || !z2) {
                    return AbstractC16345l7.b.a;
                }
                return this.f.i.j(enumC5838Lb == EnumC5838Lb.b);
            }

            public final Object n(EnumC5838Lb enumC5838Lb, boolean z, boolean z2, C17637nI7 c17637nI7, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.f, interfaceC20295rm1);
                aVar.c = enumC5838Lb;
                aVar.d = z;
                aVar.e = z2;
                return aVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC18160oB2
            public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return n((EnumC5838Lb) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (C17637nI7) obj4, (InterfaceC20295rm1) obj5);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C20085rS1 c20085rS1 = C20085rS1.this;
            c20085rS1.s2(AbstractC1970f.c(AbstractC6459Nq2.n(AbstractC1970f.a(c20085rS1.F0), C20085rS1.this.i.k(), C20085rS1.this.A, AbstractC6459Nq2.F(AbstractC1970f.a(C20085rS1.this.H1())), new a(C20085rS1.this, null)), AbstractC9773aX7.a(C20085rS1.this).getCoroutineContext(), 0L, 2, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C20085rS1.this.F0.n(EnumC5838Lb.a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rS1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C20085rS1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20085rS1 c20085rS1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20085rS1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
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
                    boolean z = this.c;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.w;
                    Boolean boolA = AbstractC6392Nk0.a(z);
                    this.b = 1;
                    if (interfaceC9336Zm4.a(boolA, this) == objE) {
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
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6H = C20085rS1.this.c.D().h();
                a aVar = new a(C20085rS1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6H, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$e */
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rS1$f */
    public static final class f {
        private final ExPeerType a;
        private final Throwable b;

        public f(ExPeerType exPeerType, Throwable th) {
            AbstractC13042fc3.i(exPeerType, "exPeer");
            AbstractC13042fc3.i(th, ParameterNames.CAUSE);
            this.a = exPeerType;
            this.b = th;
        }

        public final Throwable a() {
            return this.b;
        }

        public final ExPeerType b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a == fVar.a && AbstractC13042fc3.d(this.b, fVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "UiState(exPeer=" + this.a + ", cause=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.rS1$g */
    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC11273cj7.values().length];
            try {
                iArr2[EnumC11273cj7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC11273cj7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC11273cj7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC11273cj7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC11273cj7.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnumC11273cj7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.rS1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5U = C20085rS1.this.b.U(this.d);
                this.b = 1;
                if (AbstractC6756Ov5.d(c6517Nv5U, null, this, 1, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C11458d25 c11458d25, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new i(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5R0 = C20085rS1.this.l.r0(this.e);
                AbstractC13042fc3.h(c6517Nv5R0, "deleteChat(...)");
                this.c = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5R0, null, this, 1, null);
                if (objD == objE) {
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
                objD = ((C9475a16) obj).l();
            }
            SA2 sa2 = this.f;
            if (C9475a16.j(objD)) {
                if (sa2 != null) {
                    sa2.invoke();
                }
            }
            C20085rS1 c20085rS1 = C20085rS1.this;
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                InterfaceC8327Vm4 interfaceC8327Vm4 = c20085rS1.u;
                f fVar = new f(ExPeerType.PRIVATE, thE);
                this.b = objD;
                this.c = 2;
                if (interfaceC8327Vm4.a(fVar, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new j(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18804pH1 c18804pH1 = C20085rS1.this.p;
                int i2 = this.e;
                this.c = 1;
                objC = c18804pH1.c(i2, this);
                if (objC == objE) {
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
                objC = ((C9475a16) obj).l();
            }
            C20085rS1 c20085rS1 = C20085rS1.this;
            int i3 = this.f;
            Throwable thE = C9475a16.e(objC);
            if (thE != null) {
                InterfaceC8327Vm4 interfaceC8327Vm4 = c20085rS1.u;
                ExPeerType exPeerType = ExPeerType.GROUP;
                if (i3 != exPeerType.getValue()) {
                    exPeerType = ExPeerType.CHANNEL;
                }
                f fVar = new f(exPeerType, thE);
                this.b = objC;
                this.c = 2;
                if (interfaceC8327Vm4.a(fVar, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5K0 = C20085rS1.this.b.k0();
                this.b = 1;
                obj = AbstractC6756Ov5.a(c6517Nv5K0, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C20085rS1.this.D0.n((C17637nI7) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ AbstractC16345l7.a d;
        final /* synthetic */ Activity e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ C20085rS1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(AbstractC16345l7.a aVar, Activity activity, int i, String str, C20085rS1 c20085rS1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
            this.e = activity;
            this.f = i;
            this.g = str;
            this.h = c20085rS1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 225
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20085rS1.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rS1$m$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C20085rS1 a;

            a(C20085rS1 c20085rS1) {
                this.a = c20085rS1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean h(AbstractC20556sC7 abstractC20556sC7, C17067mL1 c17067mL1) {
                AbstractC13042fc3.i(abstractC20556sC7, "$update");
                AbstractC13042fc3.i(c17067mL1, "dialog");
                return c17067mL1.R().getPeerId() == ((WD7) abstractC20556sC7).b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean i(AbstractC20556sC7 abstractC20556sC7, C17067mL1 c17067mL1) {
                AbstractC13042fc3.i(abstractC20556sC7, "$update");
                AbstractC13042fc3.i(c17067mL1, "dialog");
                return c17067mL1.R().getPeerId() == ((WD7) abstractC20556sC7).b();
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public final Object a(final AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
                Object obj;
                Object next;
                Object value;
                ArrayList arrayList;
                Object value2;
                ArrayList arrayList2;
                if (abstractC20556sC7 instanceof WD7) {
                    UA2 ua2 = new UA2() { // from class: ir.nasim.sS1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(C20085rS1.m.a.h(abstractC20556sC7, (C17067mL1) obj2));
                        }
                    };
                    Iterator it = ((Iterable) this.a.g.a().getValue()).iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((Boolean) ua2.invoke(next)).booleanValue()) {
                            break;
                        }
                    }
                    C17067mL1 c17067mL1 = (C17067mL1) next;
                    if (c17067mL1 != null) {
                        C20085rS1 c20085rS1 = this.a;
                        InterfaceC9336Zm4 interfaceC9336Zm4A = c20085rS1.g.a();
                        do {
                            value2 = interfaceC9336Zm4A.getValue();
                            arrayList2 = new ArrayList();
                            for (Object obj2 : (List) value2) {
                                if (!((Boolean) ua2.invoke(obj2)).booleanValue()) {
                                    arrayList2.add(obj2);
                                }
                            }
                        } while (!interfaceC9336Zm4A.f(value2, AbstractC15401jX0.p1(arrayList2)));
                        AbstractC6392Nk0.a(((List) c20085rS1.g.a().getValue()).remove(c17067mL1));
                    }
                    UA2 ua22 = new UA2() { // from class: ir.nasim.tS1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj3) {
                            return Boolean.valueOf(C20085rS1.m.a.i(abstractC20556sC7, (C17067mL1) obj3));
                        }
                    };
                    Iterator it2 = ((Iterable) this.a.g.c().getValue()).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((Boolean) ua22.invoke(next2)).booleanValue()) {
                            obj = next2;
                            break;
                        }
                    }
                    C17067mL1 c17067mL12 = (C17067mL1) obj;
                    if (c17067mL12 != null) {
                        C20085rS1 c20085rS12 = this.a;
                        InterfaceC9336Zm4 interfaceC9336Zm4C = c20085rS12.g.c();
                        do {
                            value = interfaceC9336Zm4C.getValue();
                            arrayList = new ArrayList();
                            for (Object obj3 : (List) value) {
                                if (!((Boolean) ua22.invoke(obj3)).booleanValue()) {
                                    arrayList.add(obj3);
                                }
                            }
                        } while (!interfaceC9336Zm4C.f(value, AbstractC15401jX0.p1(arrayList)));
                        ((List) c20085rS12.g.c().getValue()).remove(c17067mL12);
                    }
                }
                return C19938rB7.a;
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4A = InterfaceC8038Ug3.a.a();
                a aVar = new a(C20085rS1.this);
                this.b = 1;
                if (interfaceC8327Vm4A.b(aVar, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$n */
    static final class n extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        /* synthetic */ boolean e;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return n((EventBarData) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (InterfaceC20295rm1) obj4);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            EventBarData eventBarData = (EventBarData) this.c;
            boolean z = this.d;
            boolean z2 = this.e;
            if (C8386Vt0.J5()) {
                z = eventBarData instanceof EventBarData.Enabled;
            }
            return AbstractC6392Nk0.a(z || z2);
        }

        public final Object n(EventBarData eventBarData, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = new n(interfaceC20295rm1);
            nVar.c = eventBarData;
            nVar.d = z;
            nVar.e = z2;
            return nVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC24823zG1 c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(InterfaceC24823zG1 interfaceC24823zG1, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC24823zG1;
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new o(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC24823zG1 interfaceC24823zG1 = this.c;
                this.b = 1;
                obj = interfaceC24823zG1.y(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.d.invoke((Drawable) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rS1$p$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20085rS1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20085rS1 c20085rS1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20085rS1;
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
                this.d.p2("chat_tab_selection", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(((EnumC11273cj7) this.c).ordinal() + 1))));
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.T0;
                do {
                    value = interfaceC9336Zm4.getValue();
                    ((Boolean) value).booleanValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.a(false)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC11273cj7 enumC11273cj7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC11273cj7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20085rS1.this.S0;
                a aVar = new a(C20085rS1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4, aVar, this) == objE) {
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
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.rS1$q$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20085rS1 c;
            final /* synthetic */ InterfaceC20315ro1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20085rS1 c20085rS1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20085rS1;
                this.d = interfaceC20315ro1;
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
                    InterfaceC8038Ug3 interfaceC8038Ug3 = this.c.g;
                    this.b = 1;
                    if (interfaceC8038Ug3.b(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC20906so1.d(this.d, null, 1, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC11273cj7 enumC11273cj7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC11273cj7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.rS1$q$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.rS1$q$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.rS1$q$b$a$a, reason: collision with other inner class name */
                public static final class C1498a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1498a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r7 instanceof ir.nasim.C20085rS1.q.b.a.C1498a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.rS1$q$b$a$a r0 = (ir.nasim.C20085rS1.q.b.a.C1498a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.rS1$q$b$a$a r0 = new ir.nasim.rS1$q$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L46
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.cj7 r2 = (ir.nasim.EnumC11273cj7) r2
                        ir.nasim.cj7 r4 = ir.nasim.EnumC11273cj7.d
                        if (r2 != r4) goto L46
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L46
                        return r1
                    L46:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20085rS1.q.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = C20085rS1.this.new q(interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (C8386Vt0.H9()) {
                    b bVar = new b(C20085rS1.this.S0);
                    a aVar = new a(C20085rS1.this, interfaceC20315ro1, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.rS1$r$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20085rS1 c;
            final /* synthetic */ InterfaceC20315ro1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20085rS1 c20085rS1, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20085rS1;
                this.d = interfaceC20315ro1;
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
                    InterfaceC8038Ug3 interfaceC8038Ug3 = this.c.g;
                    NJ5 nj5 = NJ5.RecommendationSource_DIALOGS;
                    this.b = 1;
                    if (interfaceC8038Ug3.d(nj5, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC20906so1.d(this.d, null, 1, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC11273cj7 enumC11273cj7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC11273cj7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.rS1$r$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.rS1$r$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.rS1$r$b$a$a, reason: collision with other inner class name */
                public static final class C1499a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1499a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r7 instanceof ir.nasim.C20085rS1.r.b.a.C1499a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.rS1$r$b$a$a r0 = (ir.nasim.C20085rS1.r.b.a.C1499a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.rS1$r$b$a$a r0 = new ir.nasim.rS1$r$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L46
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.cj7 r2 = (ir.nasim.EnumC11273cj7) r2
                        ir.nasim.cj7 r4 = ir.nasim.EnumC11273cj7.e
                        if (r2 != r4) goto L46
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L46
                        return r1
                    L46:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20085rS1.r.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            r rVar = C20085rS1.this.new r(interfaceC20295rm1);
            rVar.c = obj;
            return rVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (C8386Vt0.J9()) {
                    b bVar = new b(C20085rS1.this.S0);
                    a aVar = new a(C20085rS1.this, interfaceC20315ro1, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C20085rS1.this.z0;
                EnumC14280hf2 enumC14280hf2 = EnumC14280hf2.b;
                this.b = 1;
                if (interfaceC8327Vm4.a(enumC14280hf2, this) == objE) {
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
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C20085rS1.this.z0;
                EnumC14280hf2 enumC14280hf2 = EnumC14280hf2.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(enumC14280hf2, this) == objE) {
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
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC16345l7.a c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(AbstractC16345l7.a aVar, int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new u(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.b
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L18
                if (r1 != r2) goto L10
                ir.nasim.AbstractC10685c16.b(r15)
                goto L2c
            L10:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L18:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.l7$a r15 = r14.c
                ir.nasim.zG1 r15 = r15.a()
                if (r15 == 0) goto L2f
                r14.b = r2
                java.lang.Object r15 = r15.y(r14)
                if (r15 != r0) goto L2c
                return r0
            L2c:
                ir.nasim.bA3 r15 = (ir.nasim.InterfaceC10156bA3) r15
                goto L30
            L2f:
                r15 = r3
            L30:
                ir.nasim.m7 r4 = ir.nasim.C16936m7.a
                ir.nasim.l7$a r0 = r14.c
                java.lang.String r5 = r0.j()
                ir.nasim.l7$a r0 = r14.c
                java.lang.String r6 = r0.c()
                ir.nasim.l7$a r0 = r14.c
                int r7 = r0.h()
                ir.nasim.l7$a r0 = r14.c
                int r8 = r0.i()
                int r9 = r14.d
                java.lang.String r10 = r14.e
                if (r15 == 0) goto L82
                boolean r0 = r15 instanceof ir.nasim.InterfaceC10156bA3.a
                if (r0 == 0) goto L57
                java.lang.String r0 = "external_url"
                goto L7d
            L57:
                boolean r0 = r15 instanceof ir.nasim.C12179eA3
                if (r0 == 0) goto L5e
                java.lang.String r0 = "deep_link"
                goto L7d
            L5e:
                ir.nasim.core.modules.profile.entity.ExPeer r0 = r15.c()
                if (r0 == 0) goto L7c
                ir.nasim.core.modules.profile.entity.ExPeerType r0 = r0.getExPeerType()
                if (r0 == 0) goto L7c
                java.lang.String r0 = r0.name()
                if (r0 == 0) goto L7c
                java.util.Locale r1 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r1)
                java.lang.String r1 = "toLowerCase(...)"
                ir.nasim.AbstractC13042fc3.h(r0, r1)
                goto L7d
            L7c:
                r0 = r3
            L7d:
                if (r0 != 0) goto L80
                goto L82
            L80:
                r12 = r0
                goto L85
            L82:
                java.lang.String r0 = ""
                goto L80
            L85:
                if (r15 == 0) goto L95
                ir.nasim.core.modules.profile.entity.ExPeer r15 = r15.c()
                if (r15 == 0) goto L95
                int r15 = r15.getPeerId()
                java.lang.Integer r3 = ir.nasim.AbstractC6392Nk0.d(r15)
            L95:
                r13 = r3
                java.lang.String r11 = "ad_dialogue_view"
                r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20085rS1.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new v(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C20085rS1.this.Y;
                EnumC3635Br7 enumC3635Br7 = EnumC3635Br7.b;
                this.b = 1;
                if (interfaceC8327Vm4.a(enumC3635Br7, this) == objE) {
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
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new w(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C20085rS1.this.Y;
                EnumC3635Br7 enumC3635Br7 = EnumC3635Br7.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(enumC3635Br7, this) == objE) {
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
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(FileReference fileReference, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new x(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18656p16 c18656p16 = C20085rS1.this.q;
                FileReference fileReference = this.d;
                InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(C20085rS1.this);
                this.b = 1;
                obj = c18656p16.b(fileReference, interfaceC20315ro1A, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.e.invoke((Drawable) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rS1$y */
    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC11273cj7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(EnumC11273cj7 enumC11273cj7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC11273cj7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20085rS1.this.new y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20085rS1.this.S0;
                EnumC11273cj7 enumC11273cj7 = this.d;
                this.b = 1;
                if (interfaceC9336Zm4.a(enumC11273cj7, this) == objE) {
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
            return ((y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C20085rS1(OK7 ok7, PE pe, SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC13266fw0 interfaceC13266fw0, InterfaceC8038Ug3 interfaceC8038Ug3, HO1 ho1, C22091uf c22091uf, C4413Fa2 c4413Fa2, C6409Nm c6409Nm, E84 e84, C4471Fg6 c4471Fg6, C10299bQ2 c10299bQ2, C8054Ui1 c8054Ui1, C18804pH1 c18804pH1, C18656p16 c18656p16, C15732k47 c15732k47, InterfaceC19567qa2 interfaceC19567qa2, C12720f53 c12720f53) {
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(pe, "appStateModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(interfaceC13266fw0, "callLogDao");
        AbstractC13042fc3.i(interfaceC8038Ug3, "jaryanRepository");
        AbstractC13042fc3.i(ho1, "dialogListTopSpotStateManager");
        AbstractC13042fc3.i(c22091uf, "advertisementRepository");
        AbstractC13042fc3.i(c4413Fa2, "eventBarStateManager");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c8054Ui1, "contactModule");
        AbstractC13042fc3.i(c18804pH1, "deleteAndLeaveGroupUseCase");
        AbstractC13042fc3.i(c18656p16, "retrieveCustomAdImageUseCase");
        AbstractC13042fc3.i(c15732k47, "syncOnGoingCallUseCase");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(c12720f53, "inAppUpdateStateManager");
        this.b = ok7;
        this.c = pe;
        this.d = settingsModule;
        this.e = interfaceC3570Bk5;
        this.f = interfaceC13266fw0;
        this.g = interfaceC8038Ug3;
        this.h = ho1;
        this.i = c22091uf;
        this.j = c4413Fa2;
        this.k = c6409Nm;
        this.l = e84;
        this.m = c4471Fg6;
        this.n = c10299bQ2;
        this.o = c8054Ui1;
        this.p = c18804pH1;
        this.q = c18656p16;
        this.r = c15732k47;
        this.s = interfaceC19567qa2;
        this.t = c12720f53;
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 4, null);
        this.u = interfaceC8327Vm4B;
        this.v = AbstractC1970f.c(interfaceC8327Vm4B, null, 0L, 3, null);
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        this.w = interfaceC9336Zm4A;
        this.x = AbstractC1970f.c(interfaceC9336Zm4A, null, 0L, 3, null);
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qS1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20085rS1.j1(this.a);
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(-1);
        this.z = interfaceC9336Zm4A2;
        this.A = AbstractC12281eL6.a(bool);
        this.B = AbstractC1970f.c(AbstractC6459Nq2.F(interfaceC9336Zm4A2), null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(new ArrayList());
        this.D = interfaceC9336Zm4A3;
        this.G = AbstractC1970f.c(interfaceC9336Zm4A3, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(AbstractC4820Gr7.b.a);
        this.H = interfaceC9336Zm4A4;
        this.J = AbstractC1970f.c(interfaceC9336Zm4A4, null, 0L, 3, null);
        InterfaceC8327Vm4 interfaceC8327Vm4B2 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.Y = interfaceC8327Vm4B2;
        this.Z = interfaceC8327Vm4B2;
        InterfaceC8327Vm4 interfaceC8327Vm4B3 = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.z0 = interfaceC8327Vm4B3;
        this.A0 = AbstractC1970f.c(interfaceC8327Vm4B3, null, 0L, 3, null);
        this.B0 = AbstractC1970f.c(c4413Fa2.f(), null, 0L, 3, null);
        this.C0 = AbstractC12281eL6.a(bool);
        C20298rm4 c20298rm4 = new C20298rm4();
        this.D0 = c20298rm4;
        this.E0 = c20298rm4;
        this.F0 = new C21167tD6();
        this.G0 = new C20298rm4(null);
        this.H0 = ho1.a();
        X1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        if (!C8386Vt0.D5()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
        this.I0 = AbstractC1970f.c(c12720f53.k(), null, 0L, 3, null);
        this.J0 = c12720f53.l();
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(EnumC20553sC4.a);
        this.K0 = interfaceC9336Zm4A5;
        this.L0 = AbstractC1970f.c(interfaceC9336Zm4A5, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(EnumC7306Rd5.c);
        this.M0 = interfaceC9336Zm4A6;
        this.N0 = AbstractC1970f.c(interfaceC9336Zm4A6, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A7 = AbstractC12281eL6.a(EnumC18517on4.a);
        this.O0 = interfaceC9336Zm4A7;
        this.P0 = AbstractC1970f.c(interfaceC9336Zm4A7, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A8 = AbstractC12281eL6.a(0);
        this.Q0 = interfaceC9336Zm4A8;
        this.R0 = AbstractC1970f.c(interfaceC9336Zm4A8, null, 0L, 3, null);
        this.S0 = AbstractC12281eL6.a(EnumC11273cj7.b);
        this.T0 = AbstractC12281eL6.a(bool);
        InterfaceC9336Zm4 interfaceC9336Zm4A9 = AbstractC12281eL6.a(AbstractC20016rK4.a.b);
        this.U0 = interfaceC9336Zm4A9;
        this.V0 = AbstractC1970f.c(interfaceC9336Zm4A9, null, 0L, 3, null);
        G1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
        c2();
        d2();
        e2();
    }

    private final C14733iO2 D1(int i2) {
        return (C14733iO2) this.n.Y1().n(i2);
    }

    public static /* synthetic */ void D2(C20085rS1 c20085rS1, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = false;
        }
        c20085rS1.C2(z, i2);
    }

    private final void G1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    private final void X1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new m(null), 2, null);
    }

    private final void c2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new p(null), 3, null);
    }

    private final InterfaceC13730gj3 d2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new q(null), 3, null);
    }

    private final InterfaceC13730gj3 e2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new r(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.r j1(C20085rS1 c20085rS1) {
        AbstractC13042fc3.i(c20085rS1, "this$0");
        return AbstractC17418mv7.a(AbstractC1970f.c(AbstractC6459Nq2.o0(AbstractC6459Nq2.V(c20085rS1.f.e(), C12366eV1.b()), AbstractC9773aX7.a(c20085rS1), InterfaceC16863lz6.a.c(), -1), null, 0L, 3, null));
    }

    public final androidx.lifecycle.r A1() {
        return this.A0;
    }

    public final void A2(EnumC7306Rd5 enumC7306Rd5) {
        Object value;
        AbstractC13042fc3.i(enumC7306Rd5, "pinState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.M0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, enumC7306Rd5));
    }

    public final InterfaceC10258bL6 B1() {
        return AbstractC6459Nq2.c(this.T0);
    }

    public final ZN2 C1(int i2, W25 w25) {
        C14733iO2 c14733iO2D1;
        ZN2 zn2Q;
        AbstractC13042fc3.i(w25, "peerType");
        return (w25 != W25.b || (c14733iO2D1 = D1(i2)) == null || (zn2Q = c14733iO2D1.q()) == null) ? ZN2.GROUP : zn2Q;
    }

    public final void C2(boolean z, int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.Q0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(z ? 0 : ((Number) value).intValue() + i2)));
    }

    public final androidx.lifecycle.r E1() {
        return this.v;
    }

    public final void E2(AbstractC4820Gr7 abstractC4820Gr7) {
        Object value;
        AbstractC13042fc3.i(abstractC4820Gr7, "toolbarMode");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, abstractC4820Gr7));
    }

    public final androidx.lifecycle.r F1() {
        return this.I0;
    }

    public final C20298rm4 H1() {
        return this.E0;
    }

    public final androidx.lifecycle.r I1() {
        return this.L0;
    }

    public final androidx.lifecycle.r J1() {
        return this.V0;
    }

    public final InterfaceC9336Zm4 K1() {
        return this.g.a();
    }

    public final InterfaceC9336Zm4 L1() {
        return this.g.c();
    }

    public final androidx.lifecycle.r M1() {
        return this.G;
    }

    public final androidx.lifecycle.r N1() {
        return this.R0;
    }

    public final androidx.lifecycle.r O1() {
        return this.x;
    }

    public final InterfaceC10040ay6 P1() {
        return this.Z;
    }

    public final androidx.lifecycle.r Q1() {
        return this.J;
    }

    public final androidx.lifecycle.r R1() {
        return this.P0;
    }

    public final androidx.lifecycle.r S1() {
        return this.N0;
    }

    public final void T1(AbstractC16345l7.a aVar, int i2, String str, Activity activity) {
        AbstractC13042fc3.i(aVar, "baleCustomAd");
        AbstractC13042fc3.i(str, "finalLinkTitle");
        AbstractC13042fc3.i(activity, "activity");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(aVar, activity, i2, str, this, null), 3, null);
    }

    public final void U1(IO1 io1) {
        AbstractC13042fc3.i(io1, "topSpotUiAction");
        this.h.b(io1);
    }

    public final void V1() {
        this.r.d();
    }

    public final void W1(InterfaceC19425qK4 interfaceC19425qK4) {
        AbstractC20016rK4.b bVar;
        Object value;
        Object value2;
        InterfaceC19425qK4.a aVar;
        Object value3;
        InterfaceC19425qK4.d dVar;
        AbstractC13042fc3.i(interfaceC19425qK4, "uiAction");
        if (interfaceC19425qK4 instanceof InterfaceC19425qK4.d) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.U0;
            do {
                value3 = interfaceC9336Zm4.getValue();
                dVar = (InterfaceC19425qK4.d) interfaceC19425qK4;
            } while (!interfaceC9336Zm4.f(value3, new AbstractC20016rK4.b(dVar.c().p(), dVar.c(), dVar.b(), dVar.a())));
            return;
        }
        if (interfaceC19425qK4 instanceof InterfaceC19425qK4.a) {
            Object value4 = this.U0.getValue();
            bVar = value4 instanceof AbstractC20016rK4.b ? (AbstractC20016rK4.b) value4 : null;
            if (bVar != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.U0;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    aVar = (InterfaceC19425qK4.a) interfaceC19425qK4;
                } while (!interfaceC9336Zm42.f(value2, AbstractC20016rK4.b.e(bVar, aVar.a().p(), aVar.a(), 0, null, 12, null)));
                return;
            }
            return;
        }
        if (interfaceC19425qK4 instanceof InterfaceC19425qK4.e) {
            Object value5 = this.U0.getValue();
            bVar = value5 instanceof AbstractC20016rK4.b ? (AbstractC20016rK4.b) value5 : null;
            if (bVar != null) {
                AbstractC20016rK4.b.a aVar2 = AbstractC20016rK4.b.f;
                if (aVar2.a()) {
                    SettingsModule settingsModule = this.d;
                    settingsModule.j7(settingsModule.t3() + 1);
                    aVar2.b(false);
                }
                XV4 xv4A = AbstractC4616Fw7.a("client_name", ConstantDeviceInfo.APP_PLATFORM);
                XV4 xv4A2 = AbstractC4616Fw7.a("scenario_id", Integer.valueOf(bVar.g()));
                String lowerCase = bVar.h().name().toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                this.k.d("onboarding_old_users", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("tab_title", lowerCase), AbstractC4616Fw7.a("action_type", 3)));
                return;
            }
            return;
        }
        if (interfaceC19425qK4 instanceof InterfaceC19425qK4.b) {
            Object value6 = this.U0.getValue();
            bVar = value6 instanceof AbstractC20016rK4.b ? (AbstractC20016rK4.b) value6 : null;
            if (bVar != null) {
                this.d.i7(true);
                XV4 xv4A3 = AbstractC4616Fw7.a("client_name", ConstantDeviceInfo.APP_PLATFORM);
                XV4 xv4A4 = AbstractC4616Fw7.a("scenario_id", Integer.valueOf(bVar.g()));
                String lowerCase2 = bVar.h().name().toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                this.k.d("onboarding_old_users", AbstractC20051rO3.n(xv4A3, xv4A4, AbstractC4616Fw7.a("tab_title", lowerCase2), AbstractC4616Fw7.a("action_type", 2)));
                return;
            }
            return;
        }
        if (!(interfaceC19425qK4 instanceof InterfaceC19425qK4.c)) {
            throw new NoWhenBranchMatchedException();
        }
        Object value7 = this.U0.getValue();
        bVar = value7 instanceof AbstractC20016rK4.b ? (AbstractC20016rK4.b) value7 : null;
        if (bVar != null) {
            this.d.i7(true);
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.U0;
            do {
                value = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value, AbstractC20016rK4.a.b));
            XV4 xv4A5 = AbstractC4616Fw7.a("client_name", ConstantDeviceInfo.APP_PLATFORM);
            XV4 xv4A6 = AbstractC4616Fw7.a("scenario_id", Integer.valueOf(bVar.g()));
            String lowerCase3 = bVar.h().name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
            this.k.d("onboarding_old_users", AbstractC20051rO3.n(xv4A5, xv4A6, AbstractC4616Fw7.a("tab_title", lowerCase3), AbstractC4616Fw7.a("action_type", 1)));
        }
    }

    public final androidx.lifecycle.r Y1() {
        return AbstractC1970f.c(AbstractC6459Nq2.o(this.j.f(), this.C0, this.J0, new n(null)), null, 0L, 3, null);
    }

    public final boolean Z1(int i2, int i3, W25 w25) {
        C14733iO2 c14733iO2D1;
        C14733iO2 c14733iO2D12;
        AbstractC13042fc3.i(w25, "peerType");
        return w25 == W25.b && ((c14733iO2D1 = D1(i2)) == null || c14733iO2D1.x() != 0) && (c14733iO2D12 = D1(i2)) != null && c14733iO2D12.x() == i3;
    }

    public final void a2(InterfaceC24823zG1 interfaceC24823zG1, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC24823zG1, "drawable");
        AbstractC13042fc3.i(ua2, "afterLoaded");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o(interfaceC24823zG1, ua2, null), 3, null);
    }

    public final void f2(EnumC11273cj7 enumC11273cj7) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(enumC11273cj7, "tabType");
        AbstractC4820Gr7 abstractC4820Gr7 = (AbstractC4820Gr7) this.H.getValue();
        if (abstractC4820Gr7 instanceof AbstractC4820Gr7.a) {
            switch (g.b[enumC11273cj7.ordinal()]) {
                case 1:
                    if (((AbstractC4820Gr7.a) abstractC4820Gr7).a() != EnumC11273cj7.a) {
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.H;
                        do {
                            value = interfaceC9336Zm4.getValue();
                        } while (!interfaceC9336Zm4.f(value, AbstractC4820Gr7.c.a));
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (((AbstractC4820Gr7.a) abstractC4820Gr7).a() == EnumC11273cj7.a) {
                        InterfaceC9336Zm4 interfaceC9336Zm42 = this.H;
                        do {
                            value2 = interfaceC9336Zm42.getValue();
                        } while (!interfaceC9336Zm42.f(value2, AbstractC4820Gr7.c.a));
                        n2();
                        return;
                    }
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final void g2(C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(c17067mL1, "dialog");
        this.l.K0().N(c17067mL1);
    }

    public final void h2(C17067mL1 c17067mL1) {
        String name;
        AbstractC13042fc3.i(c17067mL1, "dialog");
        this.l.J0().d(c17067mL1);
        this.m.O(AbstractC9766aX0.e(new C25254zz6(c17067mL1)));
        ExPeerType exPeerTypeA = (c17067mL1.getExPeerType() == null || c17067mL1.getExPeerType() == ExPeerType.UNKNOWN) ? X25.a(c17067mL1.R()) : c17067mL1.getExPeerType();
        int i2 = exPeerTypeA == null ? -1 : g.a[exPeerTypeA.ordinal()];
        if (i2 == 1) {
            this.l.S0().d(c17067mL1);
            return;
        }
        if (i2 == 2) {
            this.l.M0().d(c17067mL1);
            return;
        }
        if (i2 == 3) {
            this.l.D0().d(c17067mL1);
            return;
        }
        if (i2 == 4) {
            this.l.C0().d(c17067mL1);
            return;
        }
        if (C20085rS1.class.isAnonymousClass()) {
            name = C20085rS1.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C20085rS1.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.a(name, "else in restoreLocallyDeletedChat", new Object[0]);
    }

    public final InterfaceC13730gj3 i1(int i2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(i2, null), 3, null);
    }

    public final void i2(C17067mL1 c17067mL1) {
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(c17067mL1, "dialog");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D;
        do {
            value = interfaceC9336Zm4.getValue();
            arrayList = new ArrayList();
            arrayList.addAll((List) value);
            arrayList.add(c17067mL1);
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    public final InterfaceC13730gj3 j2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new s(null), 3, null);
    }

    public final boolean k1() {
        return !this.d.N4() && C8386Vt0.U7();
    }

    public final InterfaceC13730gj3 k2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new t(null), 3, null);
    }

    public final void l1(int i2) {
        C10431bb8.a.b(i2);
    }

    public final void l2(AbstractC16345l7.a aVar, int i2, String str) {
        AbstractC13042fc3.i(aVar, "baleCustomAd");
        AbstractC13042fc3.i(str, "finalLinkTitle");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new u(aVar, i2, str, null), 3, null);
        this.i.p(aVar.c());
    }

    public final void m1(boolean z) {
        this.F0.n(z ? EnumC5838Lb.b : EnumC5838Lb.c);
    }

    public final void m2(EnumC16185kq6 enumC16185kq6) {
        AbstractC13042fc3.i(enumC16185kq6, "fabricEventType");
        HashMap map = new HashMap();
        map.put("origin", Integer.valueOf(enumC16185kq6.j()));
        C3343Am.i("contacts_permission", map);
    }

    public final InterfaceC13730gj3 n2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new v(null), 3, null);
    }

    public final void o1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new ArrayList()));
    }

    public final InterfaceC13730gj3 o2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new w(null), 3, null);
    }

    public final void p1(C17067mL1 c17067mL1) {
        Object value;
        ArrayList arrayList;
        AbstractC13042fc3.i(c17067mL1, "dialog");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D;
        do {
            value = interfaceC9336Zm4.getValue();
            arrayList = new ArrayList();
            arrayList.addAll((List) value);
            arrayList.remove(c17067mL1);
        } while (!interfaceC9336Zm4.f(value, arrayList));
    }

    public final void p2(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        this.s.a(str, map);
    }

    public final InterfaceC13730gj3 q1(C11458d25 c11458d25, SA2 sa2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(c11458d25, sa2, null), 3, null);
    }

    public final void r2(FileReference fileReference, UA2 ua2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(ua2, "afterLoaded");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new x(fileReference, ua2, null), 3, null);
    }

    public final void s1(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.p.a(c11458d25);
    }

    public final void s2(androidx.lifecycle.r rVar) {
        AbstractC13042fc3.i(rVar, "<set-?>");
        this.G0 = rVar;
    }

    public final InterfaceC13730gj3 t1(int i2, int i3) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(i2, i3, null), 3, null);
    }

    public final void t2(int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.z;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i2)));
    }

    public final androidx.lifecycle.r u1() {
        return (androidx.lifecycle.r) this.y.getValue();
    }

    public final void u2(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.C0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final androidx.lifecycle.r v1() {
        return this.G0;
    }

    public final void v2() {
        Object value;
        p2("recommend_group_view", AbstractC20051rO3.k());
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.T0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
    }

    public final InterfaceC10258bL6 w1() {
        return AbstractC6459Nq2.c(this.S0);
    }

    public final void w2(int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.Q0;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Number) value).intValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i2)));
    }

    public final InterfaceC10258bL6 x1() {
        return this.H0;
    }

    public final InterfaceC13730gj3 x2(EnumC11273cj7 enumC11273cj7) {
        AbstractC13042fc3.i(enumC11273cj7, "tabType");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new y(enumC11273cj7, null), 3, null);
    }

    public final androidx.lifecycle.r y1() {
        return this.B;
    }

    public final void y2(EnumC18517on4 enumC18517on4) {
        Object value;
        AbstractC13042fc3.i(enumC18517on4, "muteState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.O0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, enumC18517on4));
    }

    public final androidx.lifecycle.r z1() {
        return this.B0;
    }

    public final void z2(EnumC20553sC4 enumC20553sC4) {
        Object value;
        AbstractC13042fc3.i(enumC20553sC4, "normalToolbarState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.K0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, enumC20553sC4));
    }
}
