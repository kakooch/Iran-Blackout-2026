package ir.nasim;

import androidx.lifecycle.AbstractC1970f;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C23891xh3;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.runtime.ScreenStateObserver;
import ir.nasim.features.eventbar.data.model.EventBarData;
import ir.nasim.jaryan.search.data.TooltipConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.xh3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23891xh3 extends VW7 {
    public static final a G = new a(null);
    public static final int H = 8;
    private final androidx.lifecycle.r A;
    private final InterfaceC9336Zm4 B;
    private final androidx.lifecycle.r D;
    private final E84 b;
    private final C10299bQ2 c;
    private final SettingsModule d;
    private final InterfaceC8038Ug3 e;
    private final C18804pH1 f;
    private final C4413Fa2 g;
    private final C6559Oa2 h;
    private final ScreenStateObserver i;
    private final C12720f53 j;
    private final InterfaceC19699qn4 k;
    private boolean l;
    private final InterfaceC3570Bk5 m;
    private InterfaceC8327Vm4 n;
    private final InterfaceC8327Vm4 o;
    private boolean p;
    private final InterfaceC10258bL6 q;
    private final InterfaceC9336Zm4 r;
    private final InterfaceC10258bL6 s;
    private final InterfaceC9336Zm4 t;
    private final androidx.lifecycle.r u;
    private final InterfaceC9336Zm4 v;
    private final androidx.lifecycle.r w;
    private final InterfaceC9336Zm4 x;
    private final androidx.lifecycle.r y;
    private final InterfaceC9336Zm4 z;

    /* renamed from: ir.nasim.xh3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.xh3$b */
    public static final class b {
        public static final b a = new b("Mute", 0);
        public static final b b = new b("UnMute", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.xh3$c */
    public static final class c {
        public static final c a = new c("Pin", 0);
        public static final c b = new c("UnPin", 1);
        public static final c c = new c("None", 2);
        private static final /* synthetic */ c[] d;
        private static final /* synthetic */ F92 e;

        static {
            c[] cVarArrA = a();
            d = cVarArrA;
            e = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) d.clone();
        }
    }

    /* renamed from: ir.nasim.xh3$d */
    public static abstract class d {

        /* renamed from: ir.nasim.xh3$d$a */
        public static final class a extends d {
            public static final a a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: ir.nasim.xh3$d$b */
        public static final class b extends d {
            public static final b a = new b();

            private b() {
                super(null);
            }
        }

        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xh3$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C23891xh3.this.V0(this);
        }
    }

    /* renamed from: ir.nasim.xh3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C23891xh3.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            EnumC22705vh3 enumC22705vh3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String string = C23891xh3.this.m.getString("LAST_JARYAN_TAB_SELECTED_KEY", "FEED");
                AbstractC13042fc3.h(string, "getString(...)");
                InterfaceC8327Vm4 interfaceC8327Vm4F1 = C23891xh3.this.f1();
                EnumC22705vh3[] enumC22705vh3ArrValues = EnumC22705vh3.values();
                int length = enumC22705vh3ArrValues.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        enumC22705vh3 = null;
                        break;
                    }
                    enumC22705vh3 = enumC22705vh3ArrValues[i2];
                    if (AbstractC13042fc3.d(enumC22705vh3.name(), string)) {
                        break;
                    }
                    i2++;
                }
                if (enumC22705vh3 == null) {
                    C23891xh3 c23891xh3 = C23891xh3.this;
                    enumC22705vh3 = EnumC22705vh3.c;
                    c23891xh3.m1(enumC22705vh3);
                }
                this.b = 1;
                if (interfaceC8327Vm4F1.a(enumC22705vh3, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xh3$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23891xh3.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C23891xh3.this.o;
                this.b = 1;
                if (interfaceC8327Vm4.a(null, this) == objE) {
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

    /* renamed from: ir.nasim.xh3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.xh3$h$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C23891xh3 a;

            a(C23891xh3 c23891xh3) {
                this.a = c23891xh3;
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
                    UA2 ua2 = new UA2() { // from class: ir.nasim.yh3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(C23891xh3.h.a.h(abstractC20556sC7, (C17067mL1) obj2));
                        }
                    };
                    Iterator it = ((Iterable) this.a.e.a().getValue()).iterator();
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
                        C23891xh3 c23891xh3 = this.a;
                        InterfaceC9336Zm4 interfaceC9336Zm4A = c23891xh3.e.a();
                        do {
                            value2 = interfaceC9336Zm4A.getValue();
                            arrayList2 = new ArrayList();
                            for (Object obj2 : (List) value2) {
                                if (!((Boolean) ua2.invoke(obj2)).booleanValue()) {
                                    arrayList2.add(obj2);
                                }
                            }
                        } while (!interfaceC9336Zm4A.f(value2, AbstractC15401jX0.p1(arrayList2)));
                        AbstractC6392Nk0.a(((List) c23891xh3.e.a().getValue()).remove(c17067mL1));
                    }
                    UA2 ua22 = new UA2() { // from class: ir.nasim.zh3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj3) {
                            return Boolean.valueOf(C23891xh3.h.a.i(abstractC20556sC7, (C17067mL1) obj3));
                        }
                    };
                    Iterator it2 = ((Iterable) this.a.e.c().getValue()).iterator();
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
                        C23891xh3 c23891xh32 = this.a;
                        InterfaceC9336Zm4 interfaceC9336Zm4C = c23891xh32.e.c();
                        do {
                            value = interfaceC9336Zm4C.getValue();
                            arrayList = new ArrayList();
                            for (Object obj3 : (List) value) {
                                if (!((Boolean) ua22.invoke(obj3)).booleanValue()) {
                                    arrayList.add(obj3);
                                }
                            }
                        } while (!interfaceC9336Zm4C.f(value, AbstractC15401jX0.p1(arrayList)));
                        ((List) c23891xh32.e.c().getValue()).remove(c17067mL12);
                    }
                }
                return C19938rB7.a;
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23891xh3.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4A = InterfaceC8038Ug3.a.a();
                a aVar = new a(C23891xh3.this);
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xh3$i */
    static final class i extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;
        /* synthetic */ boolean e;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
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
            i iVar = new i(interfaceC20295rm1);
            iVar.c = eventBarData;
            iVar.d = z;
            iVar.e = z2;
            return iVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xh3$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC22705vh3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(EnumC22705vh3 enumC22705vh3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC22705vh3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23891xh3.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C23891xh3.this.m.putString("LAST_JARYAN_TAB_SELECTED_KEY", this.d.name());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xh3$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23891xh3.this.new k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C23891xh3.this.m.putString("LAST_JARYAN_TAB_SELECTED_KEY", this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23891xh3(E84 e84, C10299bQ2 c10299bQ2, SettingsModule settingsModule, InterfaceC8038Ug3 interfaceC8038Ug3, C18804pH1 c18804pH1, C4413Fa2 c4413Fa2, C6559Oa2 c6559Oa2, ScreenStateObserver screenStateObserver, C12720f53 c12720f53) {
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC8038Ug3, "jaryanRepository");
        AbstractC13042fc3.i(c18804pH1, "deleteAndLeaveGroupUseCase");
        AbstractC13042fc3.i(c4413Fa2, "eventBarStateManager");
        AbstractC13042fc3.i(c6559Oa2, "eventBus");
        AbstractC13042fc3.i(screenStateObserver, "screenStateObserver");
        AbstractC13042fc3.i(c12720f53, "inAppUpdateStateManager");
        this.b = e84;
        this.c = c10299bQ2;
        this.d = settingsModule;
        this.e = interfaceC8038Ug3;
        this.f = c18804pH1;
        this.g = c4413Fa2;
        this.h = c6559Oa2;
        this.i = screenStateObserver;
        this.j = c12720f53;
        this.k = AbstractC20899sn4.b(false, 1, null);
        this.l = true;
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.m = interfaceC3570Bk5Q;
        this.n = AbstractC11420cy6.b(1, 0, null, 6, null);
        this.o = AbstractC11420cy6.b(1, 0, null, 6, null);
        this.p = true;
        this.q = screenStateObserver.c();
        a1();
        j1();
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        this.r = interfaceC9336Zm4A;
        this.s = AbstractC6459Nq2.o0(AbstractC6459Nq2.o(c4413Fa2.f(), interfaceC9336Zm4A, c12720f53.l(), new i(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.d(), bool);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(new ArrayList());
        this.t = interfaceC9336Zm4A2;
        this.u = AbstractC1970f.c(interfaceC9336Zm4A2, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(d.a.a);
        this.v = interfaceC9336Zm4A3;
        this.w = AbstractC1970f.c(interfaceC9336Zm4A3, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(0);
        this.x = interfaceC9336Zm4A4;
        this.y = AbstractC1970f.c(interfaceC9336Zm4A4, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A5 = AbstractC12281eL6.a(c.c);
        this.z = interfaceC9336Zm4A5;
        this.A = AbstractC1970f.c(interfaceC9336Zm4A5, null, 0L, 3, null);
        InterfaceC9336Zm4 interfaceC9336Zm4A6 = AbstractC12281eL6.a(b.a);
        this.B = interfaceC9336Zm4A6;
        this.D = AbstractC1970f.c(interfaceC9336Zm4A6, null, 0L, 3, null);
    }

    private final TooltipConfig b1() {
        TooltipConfig tooltipConfigA = TooltipConfig.INSTANCE.a(this.d.F2());
        if (tooltipConfigA == null || tooltipConfigA.getDate() < System.currentTimeMillis() || this.m.l("showed_tooltip_ids").contains(String.valueOf(tooltipConfigA.getUid()))) {
            return null;
        }
        return tooltipConfigA;
    }

    private final void j1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new h(null), 2, null);
    }

    public static /* synthetic */ void q1(C23891xh3 c23891xh3, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = null;
        }
        c23891xh3.p1(l);
    }

    public final boolean T0() {
        return !this.d.N4() && C8386Vt0.U7();
    }

    public final XV4 U0() {
        return new XV4(Boolean.valueOf(this.m.h("new_search_tool_tip_shown", true)), b1());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V0(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C23891xh3.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.xh3$e r0 = (ir.nasim.C23891xh3.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.xh3$e r0 = new ir.nasim.xh3$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r0 = r0.a
            ir.nasim.xh3 r0 = (ir.nasim.C23891xh3) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L47
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qn4 r6 = r5.k
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = ir.nasim.InterfaceC19699qn4.a.a(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L46
            return r1
        L46:
            r0 = r5
        L47:
            boolean r6 = r0.l
            r1 = 0
            if (r6 != 0) goto L56
            ir.nasim.qn4 r6 = r0.k
            ir.nasim.InterfaceC19699qn4.a.c(r6, r3, r4, r3)
            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r1)
            return r6
        L56:
            r0.l = r1
            ir.nasim.qn4 r6 = r0.k
            ir.nasim.InterfaceC19699qn4.a.c(r6, r3, r4, r3)
            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23891xh3.V0(ir.nasim.rm1):java.lang.Object");
    }

    public final void W0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.t;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new ArrayList()));
    }

    public final boolean X0() {
        return C7183Qq.q(EnumC18608ow5.k).h("clicked_on_new_jaryan_search", false);
    }

    public final void Y0() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new f(null), 2, null);
    }

    public final EnumC17739nU1 Z0() {
        try {
            return EnumC17739nU1.valueOf(this.d.G1());
        } catch (Exception unused) {
            return EnumC17739nU1.a;
        }
    }

    public final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new g(null), 2, null);
    }

    public final InterfaceC10258bL6 c1() {
        return this.q;
    }

    public final androidx.lifecycle.r d1() {
        return this.u;
    }

    public final androidx.lifecycle.r e1() {
        return this.y;
    }

    public final InterfaceC8327Vm4 f1() {
        return this.n;
    }

    public final androidx.lifecycle.r g1() {
        return this.w;
    }

    public final androidx.lifecycle.r h1() {
        return this.D;
    }

    public final androidx.lifecycle.r i1() {
        return this.A;
    }

    public final InterfaceC10258bL6 k1() {
        return this.s;
    }

    public final void l1(C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(c17067mL1, "dialog");
        this.b.K0().N(c17067mL1);
    }

    public final void m1(EnumC22705vh3 enumC22705vh3) {
        AbstractC13042fc3.i(enumC22705vh3, "currentTab");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new j(enumC22705vh3, null), 2, null);
    }

    public final void o1(String str) {
        AbstractC13042fc3.i(str, "tabName");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new k(str, null), 2, null);
    }

    public final void p1(Long l) {
        if (l == null) {
            this.m.g("new_search_tool_tip_shown", false);
            return;
        }
        Set setL = this.m.l("showed_tooltip_ids");
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.m;
        AbstractC13042fc3.f(setL);
        interfaceC3570Bk5.putStringSet("showed_tooltip_ids", AbstractC4846Gu6.m(setL, l.toString()));
    }

    public final void s1() {
        C7183Qq.q(EnumC18608ow5.k).g("clicked_on_new_jaryan_search", true);
    }

    public final void t1(EnumC17739nU1 enumC17739nU1) {
        AbstractC13042fc3.i(enumC17739nU1, "value");
        SettingsModule settingsModule = this.d;
        String upperCase = enumC17739nU1.toString().toUpperCase(Locale.ROOT);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        settingsModule.G6(upperCase);
    }

    public final void u1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void v1(boolean z, int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.x;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, Integer.valueOf(z ? 0 : ((Number) value).intValue() + i2)));
    }

    public final void w1(d dVar) {
        Object value;
        AbstractC13042fc3.i(dVar, "toolbarMode");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.v;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, dVar));
    }
}
