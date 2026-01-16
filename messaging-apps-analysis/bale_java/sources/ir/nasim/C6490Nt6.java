package ir.nasim;

import ai.bale.proto.KifpoolOuterClass$ResponseGetMyKifpools;
import ai.bale.proto.KifpoolStruct$Kifpool;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C6490Nt6;
import ir.nasim.C7112Qi0;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC20370rt6;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.bank.mybank.model.ServiceBannerEntity;
import ir.nasim.features.bank.mybank.model.ServiceShortcutEntity;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Nt6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6490Nt6 extends VW7 {
    public static final C6494d t = new C6494d(null);
    public static final int u = 8;
    private final C22828vt6 b;
    private final SettingsModule c;
    private final InterfaceC11621dJ7 d;
    private final NR e;
    private final AbstractC13778go1 f;
    private final Context g;
    private InterfaceC9336Zm4 h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private final Map m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC10258bL6 o;
    private final InterfaceC17639nJ0 p;
    private final InterfaceC9173Yu3 q;
    private InterfaceC13730gj3 r;
    private final int s;

    /* renamed from: ir.nasim.Nt6$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            A a = new A(interfaceC20295rm1);
            a.c = obj;
            return a;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C17428mw7 c17428mw7 = (C17428mw7) this.c;
            ServicesPageSectionEntity.ServiceItemsExtra serviceItemsExtra = (ServicesPageSectionEntity.ServiceItemsExtra) c17428mw7.f();
            List<Integer> servicesIDs = serviceItemsExtra != null ? serviceItemsExtra.getServicesIDs() : null;
            Set set = servicesIDs;
            if (set == null || set.isEmpty()) {
                return AbstractC10360bX0.m();
            }
            List list = (List) c17428mw7.g();
            Set set2 = (Set) c17428mw7.j();
            if (set2 != null) {
                set = set2;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Iterator<Integer> it = servicesIDs.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        C5988Lr6 c5988Lr6 = (C5988Lr6) next;
                        if (c5988Lr6.g() == iIntValue) {
                            C5721Ko c5721Ko = C5721Ko.a;
                            if (c5721Ko.h() <= c5988Lr6.h() || c5988Lr6.h() == 0) {
                                if (c5721Ko.h() >= c5988Lr6.j()) {
                                    break;
                                }
                            }
                        }
                    }
                    C5988Lr6 c5988Lr62 = (C5988Lr6) next;
                    if (c5988Lr62 != null) {
                        AbstractC6392Nk0.a(arrayList.add(C6472Nr6.q.a(c5988Lr62, !set.contains(AbstractC6392Nk0.d(iIntValue)))));
                    }
                }
            } catch (Exception e) {
                C19406qI3.b("ServicesViewModel", "e: " + e.getMessage());
                if (e instanceof CancellationException) {
                    throw e;
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C17428mw7 c17428mw7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(c17428mw7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            B b = new B(this.d, interfaceC20295rm1);
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
            List list = (List) this.c;
            if (list.isEmpty()) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C c = new C(interfaceC20295rm1);
            c.c = obj;
            return c;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list == null) {
                return null;
            }
            try {
                List list2 = list;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(C12596es6.h.a((ServiceShortcutEntity) it.next()));
                }
                return arrayList;
            } catch (Exception e) {
                C19406qI3.b("ServicesViewModel", "e: " + e.getMessage());
                if (e instanceof CancellationException) {
                    throw e;
                }
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        D(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            D d = new D(this.d, interfaceC20295rm1);
            d.c = obj;
            return d;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Nt6$E$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6490Nt6 d;

            /* renamed from: ir.nasim.Nt6$E$a$a, reason: collision with other inner class name */
            static final class C0540a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ Map.Entry c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0540a(Map.Entry entry, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = entry;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0540a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        UA2 ua2 = (UA2) this.c.getValue();
                        this.b = 1;
                        if (ua2.invoke(this) == objE) {
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
                    return ((C0540a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$b */
            static final class b extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C6490Nt6 c6490Nt6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.c2();
                    this.c.x1();
                    this.c.v1();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.UA2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$c */
            static final class c extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.Shortcut shortcut = (ServicesPageSectionEntity.Shortcut) servicesPageSectionEntity;
                        if (mapA.containsKey(shortcut.getTitle())) {
                            mapA.put(shortcut.getTitle(), new InterfaceC20370rt6.f(shortcut.getSectionID(), shortcut.getTitle(), EnumC19761qt6.b, AbstractC12710f43.O(list)));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new c(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        final C6490Nt6 c6490Nt6 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.Ot6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.c.y(c6490Nt6, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.M1(ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$d */
            static final class d extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.CustomServices customServices = (ServicesPageSectionEntity.CustomServices) servicesPageSectionEntity;
                        if (mapA.containsKey(customServices.getTitle())) {
                            mapA.put(customServices.getTitle(), new InterfaceC20370rt6.d(customServices.getSectionID(), customServices.getTitle(), EnumC19761qt6.b, list));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6490Nt6 c6490Nt6 = this.c;
                        String title = ((ServicesPageSectionEntity.CustomServices) this.d).getTitle();
                        final C6490Nt6 c6490Nt62 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.Pt6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.d.y(c6490Nt62, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.G1(title, ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((d) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$e */
            static final class e extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.Banner banner = (ServicesPageSectionEntity.Banner) servicesPageSectionEntity;
                        if (mapA.containsKey(banner.getTitle())) {
                            mapA.put(banner.getTitle(), new InterfaceC20370rt6.a(banner.getSectionID(), banner.getTitle(), EnumC19761qt6.b, AbstractC12710f43.O(list)));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new e(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        final C6490Nt6 c6490Nt6 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.Qt6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.e.y(c6490Nt6, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.D1(ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((e) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$f */
            static final class f extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.BotsVitrine botsVitrine = (ServicesPageSectionEntity.BotsVitrine) servicesPageSectionEntity;
                        if (mapA.containsKey(botsVitrine.getTitle())) {
                            mapA.put(botsVitrine.getTitle(), new InterfaceC20370rt6.b(botsVitrine.getSectionID(), botsVitrine.getTitle(), EnumC19761qt6.b, list));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new f(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6490Nt6 c6490Nt6 = this.c;
                        String title = ((ServicesPageSectionEntity.BotsVitrine) this.d).getTitle();
                        final C6490Nt6 c6490Nt62 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.Rt6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.f.y(c6490Nt62, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.E1(title, ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((f) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$g */
            static final class g extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.ServiceItemsExtra serviceItemsExtra = (ServicesPageSectionEntity.ServiceItemsExtra) servicesPageSectionEntity;
                        if (mapA.containsKey(serviceItemsExtra.getTitle())) {
                            String title = serviceItemsExtra.getTitle();
                            int sectionID = serviceItemsExtra.getSectionID();
                            String title2 = serviceItemsExtra.getTitle();
                            EnumC19761qt6 enumC19761qt6 = EnumC19761qt6.b;
                            String buttonText = serviceItemsExtra.getButtonText();
                            EnumC19170pt6 enumC19170pt6 = (EnumC19170pt6) EnumC19170pt6.p().get(serviceItemsExtra.getBadgeType());
                            mapA.put(title, new InterfaceC20370rt6.e(sectionID, title2, enumC19761qt6, buttonText, (EnumC18579ot6) EnumC18579ot6.j().get(serviceItemsExtra.getButtonNavigationType()), serviceItemsExtra.getServiceCategoryID(), enumC19170pt6, list));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new g(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6490Nt6 c6490Nt6 = this.c;
                        String title = ((ServicesPageSectionEntity.ServiceItemsExtra) this.d).getTitle();
                        final C6490Nt6 c6490Nt62 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.St6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.g.y(c6490Nt62, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.H1(title, ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((g) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Nt6$E$a$h */
            static final class h extends AbstractC19859r37 implements UA2 {
                int b;
                final /* synthetic */ C6490Nt6 c;
                final /* synthetic */ ServicesPageSectionEntity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                h(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(1, interfaceC20295rm1);
                    this.c = c6490Nt6;
                    this.d = servicesPageSectionEntity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 y(C6490Nt6 c6490Nt6, ServicesPageSectionEntity servicesPageSectionEntity, List list) {
                    Object value;
                    C4837Gt6 c4837Gt6B;
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        c4837Gt6B = (C4837Gt6) value;
                        Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
                        ServicesPageSectionEntity.BotsVitrineExtra botsVitrineExtra = (ServicesPageSectionEntity.BotsVitrineExtra) servicesPageSectionEntity;
                        if (mapA.containsKey(botsVitrineExtra.getTitle())) {
                            String title = botsVitrineExtra.getTitle();
                            int sectionID = botsVitrineExtra.getSectionID();
                            String title2 = botsVitrineExtra.getTitle();
                            EnumC19761qt6 enumC19761qt6 = EnumC19761qt6.b;
                            String buttonText = botsVitrineExtra.getButtonText();
                            EnumC19170pt6 enumC19170pt6 = (EnumC19170pt6) EnumC19170pt6.p().get(botsVitrineExtra.getBadgeType());
                            mapA.put(title, new InterfaceC20370rt6.c(sectionID, title2, enumC19761qt6, buttonText, (EnumC18579ot6) EnumC18579ot6.j().get(botsVitrineExtra.getButtonNavigationType()), botsVitrineExtra.getButtonNavigationDestinationUrl(), botsVitrineExtra.getServiceCategoryID(), enumC19170pt6, list));
                            AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                            AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                            c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
                        }
                    } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
                    return C19938rB7.a;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                    return new h(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6490Nt6 c6490Nt6 = this.c;
                        String title = ((ServicesPageSectionEntity.BotsVitrineExtra) this.d).getTitle();
                        final C6490Nt6 c6490Nt62 = this.c;
                        final ServicesPageSectionEntity servicesPageSectionEntity = this.d;
                        UA2 ua2 = new UA2() { // from class: ir.nasim.Tt6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C6490Nt6.E.a.h.y(c6490Nt62, servicesPageSectionEntity, (List) obj2);
                            }
                        };
                        this.b = 1;
                        if (c6490Nt6.F1(title, ua2, this) == objE) {
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

                @Override // ir.nasim.UA2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((h) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6490Nt6 c6490Nt6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6490Nt6;
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
                Object value2;
                AbstractC13937h43 abstractC13937h43E;
                InterfaceC20370rt6.e eVarB;
                InterfaceC20370rt6.c cVarB;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List<ServicesPageSectionEntity> list = (List) this.c;
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return C19938rB7.a;
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.n;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C4837Gt6.b((C4837Gt6) value, null, null, list.size(), false, false, null, 59, null)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (ServicesPageSectionEntity servicesPageSectionEntity : list) {
                    if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Wallet) {
                        Object obj2 = ((C4837Gt6) this.d.n.getValue()).d().get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
                        InterfaceC20370rt6.g gVar = obj2 instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj2 : null;
                        if (gVar == null) {
                            ServicesPageSectionEntity.Wallet wallet = (ServicesPageSectionEntity.Wallet) servicesPageSectionEntity;
                            gVar = new InterfaceC20370rt6.g(wallet.getSectionID(), wallet.getTitle(), ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a, null, null, null, 56, null);
                            linkedHashMap2.put(gVar, new b(this.d, null));
                        }
                        linkedHashMap.put(gVar.f(), gVar);
                    } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Shortcut) {
                        Object obj3 = ((C4837Gt6) this.d.n.getValue()).d().get(ServicesPageSectionEntity.SHORTCUTS_SECTION_TITLE);
                        InterfaceC20370rt6.f fVar = obj3 instanceof InterfaceC20370rt6.f ? (InterfaceC20370rt6.f) obj3 : null;
                        if (fVar == null) {
                            ServicesPageSectionEntity.Shortcut shortcut = (ServicesPageSectionEntity.Shortcut) servicesPageSectionEntity;
                            fVar = new InterfaceC20370rt6.f(shortcut.getSectionID(), shortcut.getTitle(), ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a, null, 8, null);
                            linkedHashMap2.put(fVar, new c(this.d, servicesPageSectionEntity, null));
                        }
                        linkedHashMap.put(fVar.d(), fVar);
                    } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.CustomServices) {
                        Object obj4 = ((C4837Gt6) this.d.n.getValue()).d().get(ServicesPageSectionEntity.CUSTOM_SERVICES_SECTION_TITLE);
                        InterfaceC20370rt6.d dVar = obj4 instanceof InterfaceC20370rt6.d ? (InterfaceC20370rt6.d) obj4 : null;
                        if (dVar == null) {
                            ServicesPageSectionEntity.CustomServices customServices = (ServicesPageSectionEntity.CustomServices) servicesPageSectionEntity;
                            dVar = new InterfaceC20370rt6.d(customServices.getSectionID(), customServices.getTitle(), ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a, null, 8, null);
                            linkedHashMap2.put(dVar, new d(this.d, servicesPageSectionEntity, null));
                        }
                        linkedHashMap.put(dVar.d(), dVar);
                    } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Banner) {
                        Object obj5 = ((C4837Gt6) this.d.n.getValue()).d().get(ServicesPageSectionEntity.BANNERS_SECTION_TITLE);
                        InterfaceC20370rt6.a aVar = obj5 instanceof InterfaceC20370rt6.a ? (InterfaceC20370rt6.a) obj5 : null;
                        if (aVar == null) {
                            ServicesPageSectionEntity.Banner banner = (ServicesPageSectionEntity.Banner) servicesPageSectionEntity;
                            aVar = new InterfaceC20370rt6.a(banner.getSectionID(), banner.getTitle(), ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a, null, 8, null);
                            linkedHashMap2.put(aVar, new e(this.d, servicesPageSectionEntity, null));
                        }
                        linkedHashMap.put(aVar.d(), aVar);
                    } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.BotsVitrine) {
                        Object obj6 = ((C4837Gt6) this.d.n.getValue()).d().get(ServicesPageSectionEntity.BOTS_VITRINE_SECTION_TITLE);
                        InterfaceC20370rt6.b bVar = obj6 instanceof InterfaceC20370rt6.b ? (InterfaceC20370rt6.b) obj6 : null;
                        if (bVar == null) {
                            ServicesPageSectionEntity.BotsVitrine botsVitrine = (ServicesPageSectionEntity.BotsVitrine) servicesPageSectionEntity;
                            bVar = new InterfaceC20370rt6.b(botsVitrine.getSectionID(), botsVitrine.getTitle(), ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a, null, 8, null);
                            linkedHashMap2.put(bVar, new f(this.d, servicesPageSectionEntity, null));
                        }
                        linkedHashMap.put(bVar.d(), bVar);
                    } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.ServiceItemsExtra) {
                        ServicesPageSectionEntity.ServiceItemsExtra serviceItemsExtra = (ServicesPageSectionEntity.ServiceItemsExtra) servicesPageSectionEntity;
                        Object obj7 = ((C4837Gt6) this.d.n.getValue()).d().get(serviceItemsExtra.getTitle());
                        InterfaceC20370rt6.e eVar = obj7 instanceof InterfaceC20370rt6.e ? (InterfaceC20370rt6.e) obj7 : null;
                        if (eVar != null) {
                            eVarB = eVar.b((135 & 1) != 0 ? eVar.a : 0, (135 & 2) != 0 ? eVar.b : null, (135 & 4) != 0 ? eVar.c : null, (135 & 8) != 0 ? eVar.d : serviceItemsExtra.getButtonText(), (135 & 16) != 0 ? eVar.e : (EnumC18579ot6) EnumC18579ot6.j().get(serviceItemsExtra.getButtonNavigationType()), (135 & 32) != 0 ? eVar.f : serviceItemsExtra.getServiceCategoryID(), (135 & 64) != 0 ? eVar.g : (EnumC19170pt6) EnumC19170pt6.p().get(serviceItemsExtra.getBadgeType()), (135 & 128) != 0 ? eVar.h : null);
                        } else {
                            int sectionID = serviceItemsExtra.getSectionID();
                            String title = serviceItemsExtra.getTitle();
                            EnumC19761qt6 enumC19761qt6 = ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a;
                            InterfaceC20370rt6.e eVar2 = new InterfaceC20370rt6.e(sectionID, title, enumC19761qt6, serviceItemsExtra.getButtonText(), (EnumC18579ot6) EnumC18579ot6.j().get(serviceItemsExtra.getButtonNavigationType()), serviceItemsExtra.getServiceCategoryID(), (EnumC19170pt6) EnumC19170pt6.p().get(serviceItemsExtra.getBadgeType()), null, 128, null);
                            g gVar2 = new g(this.d, servicesPageSectionEntity, null);
                            eVarB = eVar2;
                            linkedHashMap2.put(eVarB, gVar2);
                        }
                        linkedHashMap.put(eVarB.j(), eVarB);
                    } else {
                        if (!(servicesPageSectionEntity instanceof ServicesPageSectionEntity.BotsVitrineExtra)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ServicesPageSectionEntity.BotsVitrineExtra botsVitrineExtra = (ServicesPageSectionEntity.BotsVitrineExtra) servicesPageSectionEntity;
                        Object obj8 = ((C4837Gt6) this.d.n.getValue()).d().get(botsVitrineExtra.getTitle());
                        InterfaceC20370rt6.c cVar = obj8 instanceof InterfaceC20370rt6.c ? (InterfaceC20370rt6.c) obj8 : null;
                        if (cVar != null) {
                            cVarB = cVar.b((295 & 1) != 0 ? cVar.a : 0, (295 & 2) != 0 ? cVar.b : null, (295 & 4) != 0 ? cVar.c : null, (295 & 8) != 0 ? cVar.d : botsVitrineExtra.getButtonText(), (295 & 16) != 0 ? cVar.e : (EnumC18579ot6) EnumC18579ot6.j().get(botsVitrineExtra.getButtonNavigationType()), (295 & 32) != 0 ? cVar.f : null, (295 & 64) != 0 ? cVar.g : botsVitrineExtra.getServiceCategoryID(), (295 & 128) != 0 ? cVar.h : (EnumC19170pt6) EnumC19170pt6.p().get(botsVitrineExtra.getBadgeType()), (295 & 256) != 0 ? cVar.i : null);
                        } else {
                            int sectionID2 = botsVitrineExtra.getSectionID();
                            String title2 = botsVitrineExtra.getTitle();
                            EnumC19761qt6 enumC19761qt62 = ((C4837Gt6) this.d.n.getValue()).g() ? EnumC19761qt6.b : EnumC19761qt6.a;
                            InterfaceC20370rt6.c cVar2 = new InterfaceC20370rt6.c(sectionID2, title2, enumC19761qt62, botsVitrineExtra.getButtonText(), (EnumC18579ot6) EnumC18579ot6.j().get(botsVitrineExtra.getButtonNavigationType()), botsVitrineExtra.getButtonNavigationDestinationUrl(), botsVitrineExtra.getServiceCategoryID(), (EnumC19170pt6) EnumC19170pt6.p().get(botsVitrineExtra.getBadgeType()), null, 256, null);
                            h hVar = new h(this.d, servicesPageSectionEntity, null);
                            cVarB = cVar2;
                            linkedHashMap2.put(cVarB, hVar);
                        }
                        linkedHashMap.put(cVarB.k(), cVarB);
                    }
                }
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.n;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    abstractC13937h43E = AbstractC13937h43.e(linkedHashMap);
                    AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                } while (!interfaceC9336Zm42.f(value2, C4837Gt6.b((C4837Gt6) value2, null, abstractC13937h43E, 0, false, false, null, 61, null)));
                Iterator it = linkedHashMap2.entrySet().iterator();
                while (it.hasNext()) {
                    AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), this.d.f, null, new C0540a((Map.Entry) it.next(), null), 2, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        E(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new E(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22828vt6 c22828vt6 = C6490Nt6.this.b;
                this.b = 1;
                if (c22828vt6.p(this) == objE) {
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
            InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.v(C6490Nt6.this.b.G()), C6490Nt6.this.f);
            a aVar = new a(C6490Nt6.this, null);
            this.b = 2;
            if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$F */
    static final class F extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Integer c;
        final /* synthetic */ String d;
        final /* synthetic */ Integer e;
        final /* synthetic */ Integer f;
        final /* synthetic */ Integer g;
        final /* synthetic */ Integer h;
        final /* synthetic */ EnumC19170pt6 i;
        final /* synthetic */ Integer j;
        final /* synthetic */ Integer k;
        final /* synthetic */ Integer l;
        final /* synthetic */ String m;
        final /* synthetic */ String n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        F(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, EnumC19170pt6 enumC19170pt6, Integer num6, Integer num7, Integer num8, String str2, String str3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = num;
            this.d = str;
            this.e = num2;
            this.f = num3;
            this.g = num4;
            this.h = num5;
            this.i = enumC19170pt6;
            this.j = num6;
            this.k = num7;
            this.l = num8;
            this.m = str2;
            this.n = str3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new F(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (!C8386Vt0.a.la()) {
                return C19938rB7.a;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Integer num = this.c;
            if (num != null) {
                linkedHashMap.put("id", AbstractC6392Nk0.d(num.intValue()));
            }
            String str = this.d;
            if (str != null) {
                linkedHashMap.put("title", str);
            }
            Integer num2 = this.e;
            if (num2 != null) {
                linkedHashMap.put("component_type", AbstractC6392Nk0.d(num2.intValue()));
            }
            Integer num3 = this.f;
            if (num3 != null) {
                linkedHashMap.put("file_id", AbstractC6392Nk0.d(num3.intValue()));
            }
            Integer num4 = this.g;
            if (num4 != null) {
                linkedHashMap.put("index", AbstractC6392Nk0.d(num4.intValue()));
            }
            Integer num5 = this.h;
            if (num5 != null) {
                linkedHashMap.put("action_type", AbstractC6392Nk0.d(num5.intValue()));
            }
            EnumC19170pt6 enumC19170pt6 = this.i;
            if (enumC19170pt6 != null) {
                linkedHashMap.put("badge_type", AbstractC6392Nk0.d(enumC19170pt6.ordinal()));
            }
            Integer num6 = this.j;
            if (num6 != null) {
                linkedHashMap.put("section", AbstractC6392Nk0.d(num6.intValue()));
            }
            Integer num7 = this.k;
            if (num7 != null) {
                linkedHashMap.put("peer_id", AbstractC6392Nk0.d(num7.intValue()));
            }
            Integer num8 = this.l;
            if (num8 != null) {
                linkedHashMap.put("peer_type", AbstractC6392Nk0.d(num8.intValue()));
            }
            String str2 = this.m;
            if (str2 != null) {
                linkedHashMap.put("link_title", str2);
            }
            C3343Am.i(this.n, linkedHashMap);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((F) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$G */
    static final class G extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ SA2 h;
        final /* synthetic */ UA2 i;

        /* renamed from: ir.nasim.Nt6$G$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[RQ.values().length];
                try {
                    iArr[RQ.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RQ.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RQ.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        G(SA2 sa2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = sa2;
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            G g = C6490Nt6.this.new G(this.h, this.i, interfaceC20295rm1);
            g.f = obj;
            return g;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            QJ2 qj2E;
            C6490Nt6 c6490Nt6;
            SA2 sa2;
            UA2 ua2;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                Object obj2 = ((C4837Gt6) C6490Nt6.this.n.getValue()).d().get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
                InterfaceC20370rt6.g gVar = obj2 instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj2 : null;
                if (gVar != null && (qj2E = gVar.e()) != null) {
                    c6490Nt6 = C6490Nt6.this;
                    SA2 sa22 = this.h;
                    UA2 ua22 = this.i;
                    if (qj2E.e()) {
                        return C19938rB7.a;
                    }
                    c6490Nt6.X1(true);
                    NR nr = c6490Nt6.e;
                    this.f = interfaceC20315ro1;
                    this.b = c6490Nt6;
                    this.c = sa22;
                    this.d = ua22;
                    this.e = 1;
                    obj = nr.g(this);
                    if (obj == objE) {
                        return objE;
                    }
                    sa2 = sa22;
                    ua2 = ua22;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua2 = (UA2) this.d;
            sa2 = (SA2) this.c;
            c6490Nt6 = (C6490Nt6) this.b;
            AbstractC10685c16.b(obj);
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) obj).a();
            if (c19493qS0 == null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C4837Gt6.b((C4837Gt6) value, null, null, 0, false, false, c6490Nt6.g.getString(PD5.error_unknown), 31, null)));
                return C19938rB7.a;
            }
            int i2 = a.a[AbstractC20084rS0.a(c19493qS0).ordinal()];
            if (i2 == 1) {
                sa2.invoke();
            } else if (i2 == 2) {
                ua2.invoke(AbstractC6392Nk0.a(true));
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                ua2.invoke(AbstractC6392Nk0.a(false));
            }
            c6490Nt6.X1(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((G) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new H(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6490Nt6 c6490Nt6 = C6490Nt6.this;
                C12889fL5 c12889fL5 = this.d;
                this.b = 1;
                if (C6490Nt6.e2(c6490Nt6, c12889fL5, this) == objE) {
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
            C6490Nt6 c6490Nt62 = C6490Nt6.this;
            C12889fL5 c12889fL52 = this.d;
            this.b = 2;
            if (C6490Nt6.d2(c6490Nt62, c12889fL52, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$I */
    static final class I extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        I(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C6490Nt6.d2(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Nt6$J */
    static final class J extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        J(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C6490Nt6.e2(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Nt6$a, reason: case insensitive filesystem */
    static final class C6491a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Nt6$a$a, reason: collision with other inner class name */
        static final class C0541a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            C0541a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0541a c0541a = new C0541a(interfaceC20295rm1);
                c0541a.c = obj;
                return c0541a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((C4837Gt6) this.c).g());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4837Gt6 c4837Gt6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0541a) create(c4837Gt6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Nt6$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C6490Nt6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6490Nt6 c6490Nt6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6490Nt6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = ((Boolean) obj).booleanValue();
                return bVar;
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
                    this.d.g2(EnumC17988nt6.c, 0, 0);
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C6491a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6491a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.X(C6490Nt6.this.n, new C0541a(null)));
                b bVar = new b(C6490Nt6.this, null);
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
            return ((C6491a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$b, reason: case insensitive filesystem */
    static final class C6492b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C6492b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6492b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (!((C4837Gt6) C6490Nt6.this.O1().getValue()).g()) {
                C6490Nt6.this.g2(EnumC17988nt6.b, 0, 1500);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6492b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$c, reason: case insensitive filesystem */
    static final class C6493c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;

        C6493c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6493c(interfaceC20295rm1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
        
            r2 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d1 A[LOOP:0: B:25:0x0098->B:33:0x00d1, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[EDGE_INSN: B:37:0x00bb->B:27:0x00bb BREAK  A[LOOP:0: B:25:0x0098->B:33:0x00d1], SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 216
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6490Nt6.C6493c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6493c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$d, reason: case insensitive filesystem */
    public static final class C6494d {
        private C6494d() {
        }

        public /* synthetic */ C6494d(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Nt6$e, reason: case insensitive filesystem */
    static final class C6495e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C6495e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6495e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C6490Nt6.this.b.o(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6495e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$f, reason: case insensitive filesystem */
    static final class C6496f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C6496f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6496f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22828vt6 c22828vt6 = C6490Nt6.this.b;
                this.b = 1;
                objA = c22828vt6.A(this);
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
            C6490Nt6 c6490Nt6 = C6490Nt6.this;
            if (C9475a16.j(objA)) {
                c6490Nt6.f2(new QJ2(true, AbstractC6392Nk0.e(((Number) objA).longValue()), false, 4, null));
                c6490Nt6.U1(6);
            }
            C6490Nt6 c6490Nt62 = C6490Nt6.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.b("NON_FATAL_EXCEPTION", thE.getMessage());
                c6490Nt62.f2(new QJ2(true, AbstractC6392Nk0.e(-1L), false, 4, null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6496f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$g, reason: case insensitive filesystem */
    static final class C6497g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        C6497g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6497g(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.c
                r2 = -1
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2a
                if (r1 == r5) goto L26
                if (r1 != r4) goto L1e
                java.lang.Object r0 = r12.b
                ir.nasim.Nt6 r0 = (ir.nasim.C6490Nt6) r0
                ir.nasim.AbstractC10685c16.b(r13)
                ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
                java.lang.Object r13 = r13.l()
                goto L54
            L1e:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L26:
                ir.nasim.AbstractC10685c16.b(r13)
                goto L3e
            L2a:
                ir.nasim.AbstractC10685c16.b(r13)
                ir.nasim.Nt6 r13 = ir.nasim.C6490Nt6.this
                ir.nasim.NR r13 = ir.nasim.C6490Nt6.W0(r13)
                ir.nasim.SR r1 = ir.nasim.SR.b
                r12.c = r5
                java.lang.Object r13 = r13.c(r1, r12)
                if (r13 != r0) goto L3e
                return r0
            L3e:
                java.lang.String r13 = (java.lang.String) r13
                if (r13 == 0) goto L97
                ir.nasim.Nt6 r1 = ir.nasim.C6490Nt6.this
                ir.nasim.vt6 r5 = ir.nasim.C6490Nt6.g1(r1)
                r12.b = r1
                r12.c = r4
                java.lang.Object r13 = r5.B(r13, r12)
                if (r13 != r0) goto L53
                return r0
            L53:
                r0 = r1
            L54:
                boolean r1 = ir.nasim.C9475a16.j(r13)
                if (r1 == 0) goto L76
                r1 = r13
                java.lang.Number r1 = (java.lang.Number) r1
                long r4 = r1.longValue()
                ir.nasim.QJ2 r1 = new ir.nasim.QJ2
                java.lang.Long r8 = ir.nasim.AbstractC6392Nk0.e(r4)
                r10 = 4
                r11 = 0
                r7 = 1
                r9 = 0
                r6 = r1
                r6.<init>(r7, r8, r9, r10, r11)
                ir.nasim.C6490Nt6.o1(r0, r1)
                r1 = 6
                r0.U1(r1)
            L76:
                java.lang.Throwable r13 = ir.nasim.C9475a16.e(r13)
                if (r13 == 0) goto Laa
                java.lang.String r1 = "NON_FATAL_EXCEPTION"
                java.lang.String r13 = r13.getMessage()
                ir.nasim.C19406qI3.b(r1, r13)
                ir.nasim.QJ2 r13 = new ir.nasim.QJ2
                java.lang.Long r6 = ir.nasim.AbstractC6392Nk0.e(r2)
                r8 = 4
                r9 = 0
                r5 = 1
                r7 = 0
                r4 = r13
                r4.<init>(r5, r6, r7, r8, r9)
                ir.nasim.C6490Nt6.o1(r0, r13)
                goto Laa
            L97:
                ir.nasim.Nt6 r13 = ir.nasim.C6490Nt6.this
                ir.nasim.QJ2 r0 = new ir.nasim.QJ2
                java.lang.Long r6 = ir.nasim.AbstractC6392Nk0.e(r2)
                r8 = 4
                r9 = 0
                r5 = 0
                r7 = 0
                r4 = r0
                r4.<init>(r5, r6, r7, r8, r9)
                ir.nasim.C6490Nt6.o1(r13, r0)
            Laa:
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6490Nt6.C6497g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6497g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$h, reason: case insensitive filesystem */
    static final class C6498h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C6498h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6498h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            Object value;
            C4837Gt6 c4837Gt6B;
            Object value2;
            C4837Gt6 c4837Gt6B2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22828vt6 c22828vt6 = C6490Nt6.this.b;
                this.b = 1;
                Object objJ = c22828vt6.J(this);
                if (objJ == objE) {
                    return objE;
                }
                objL = objJ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C6490Nt6 c6490Nt6 = C6490Nt6.this;
            if (C9475a16.j(objL)) {
                List<KifpoolStruct$Kifpool> myWalletsList = ((KifpoolOuterClass$ResponseGetMyKifpools) objL).getMyWalletsList();
                AbstractC13042fc3.f(myWalletsList);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : myWalletsList) {
                    if (!((KifpoolStruct$Kifpool) obj2).getIsMerchant()) {
                        arrayList.add(obj2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    myWalletsList = arrayList;
                }
                List<KifpoolStruct$Kifpool> list = myWalletsList;
                int size = list.size();
                long balance = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    KifpoolStruct$Kifpool kifpoolStruct$Kifpool = list.get(i2);
                    if (kifpoolStruct$Kifpool.getBalance() > balance) {
                        balance = kifpoolStruct$Kifpool.getBalance();
                    }
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = c6490Nt6.n;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    c4837Gt6B2 = (C4837Gt6) value2;
                    Map mapA = AbstractC20051rO3.A(c4837Gt6B2.d());
                    Object obj3 = mapA.get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
                    InterfaceC20370rt6.g gVar = obj3 instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj3 : null;
                    if (gVar != null) {
                        mapA.put(ServicesPageSectionEntity.WALLET_SECTION_TITLE, InterfaceC20370rt6.g.c(gVar, 0, ServicesPageSectionEntity.WALLET_SECTION_TITLE, null, AbstractC6392Nk0.e(balance), null, null, 53, null));
                        AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                        AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                        c4837Gt6B2 = C4837Gt6.b(c4837Gt6B2, null, abstractC13937h43E, 0, false, false, null, 61, null);
                    }
                } while (!interfaceC9336Zm4.f(value2, c4837Gt6B2));
            }
            C6490Nt6 c6490Nt62 = C6490Nt6.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                C19406qI3.b("NON_FATAL_EXCEPTION", thE.getMessage());
                InterfaceC9336Zm4 interfaceC9336Zm42 = c6490Nt62.n;
                do {
                    value = interfaceC9336Zm42.getValue();
                    c4837Gt6B = (C4837Gt6) value;
                    Map mapA2 = AbstractC20051rO3.A(c4837Gt6B.d());
                    Object obj4 = mapA2.get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
                    InterfaceC20370rt6.g gVar2 = obj4 instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj4 : null;
                    if (gVar2 != null) {
                        mapA2.put(ServicesPageSectionEntity.WALLET_SECTION_TITLE, InterfaceC20370rt6.g.c(gVar2, 0, ServicesPageSectionEntity.WALLET_SECTION_TITLE, null, AbstractC6392Nk0.e(-1L), null, null, 53, null));
                        AbstractC13937h43 abstractC13937h43E2 = AbstractC13937h43.e(mapA2);
                        AbstractC13042fc3.h(abstractC13937h43E2, "copyOf(...)");
                        c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E2, 0, false, false, null, 61, null);
                    }
                } while (!interfaceC9336Zm42.f(value, c4837Gt6B));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6498h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$i, reason: case insensitive filesystem */
    static final class C6499i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C6499i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6499i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22828vt6 c22828vt6 = C6490Nt6.this.b;
                this.b = 1;
                if (c22828vt6.y(this) == objE) {
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
            return ((C6499i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$j, reason: case insensitive filesystem */
    static final class C6500j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C6500j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6490Nt6.this.new C6500j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (C6490Nt6.this.h.getValue() == null) {
                Set setR1 = AbstractC15401jX0.r1(C6490Nt6.this.b.I());
                InterfaceC9336Zm4 interfaceC9336Zm4 = C6490Nt6.this.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, setR1));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C6500j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list == null) {
                return null;
            }
            try {
                List list2 = list;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(C5746Kq6.g.a((ServiceBannerEntity) it.next()));
                }
                return arrayList;
            } catch (Exception e) {
                C19406qI3.b("ServicesViewModel", "e: " + e.getMessage());
                if (e instanceof CancellationException) {
                    throw e;
                }
                return null;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(this.d, interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list == null) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = new m(this.d, interfaceC20295rm1);
            mVar.c = obj;
            return mVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            List<Integer> botsIDs;
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list != null) {
                String str = this.d;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((ServicesPageSectionEntity) next).getTitle(), str)) {
                        break;
                    }
                }
                obj2 = (ServicesPageSectionEntity) next;
            } else {
                obj2 = null;
            }
            ServicesPageSectionEntity.BotsVitrine botsVitrine = obj2 instanceof ServicesPageSectionEntity.BotsVitrine ? (ServicesPageSectionEntity.BotsVitrine) obj2 : null;
            return (botsVitrine == null || (botsIDs = botsVitrine.getBotsIDs()) == null) ? AbstractC10360bX0.m() : botsIDs;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = C6490Nt6.this.new n(interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List list;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list2 = (List) this.c;
                InterfaceC11621dJ7 interfaceC11621dJ7 = C6490Nt6.this.d;
                this.c = list2;
                this.b = 1;
                Object objL = interfaceC11621dJ7.l(list2, false, this);
                if (objL == objE) {
                    return objE;
                }
                list = list2;
                obj = objL;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.c;
                AbstractC10685c16.b(obj);
            }
            List list3 = (List) obj;
            if (list.size() != list3.size()) {
                List list4 = list;
                List list5 = list3;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list5, 10));
                Iterator it = list5.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((C17637nI7) it.next()).n0()));
                }
                C19406qI3.j("ServicesViewModel", "Couldn't fetch all bots. Missed bots id: " + AbstractC15401jX0.N0(list4, AbstractC15401jX0.r1(arrayList)), new Object[0]);
            }
            List<C17637nI7> list6 = list3;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list6, 10));
            for (C17637nI7 c17637nI7 : list6) {
                C7112Qi0.a aVar = C7112Qi0.e;
                int iN0 = c17637nI7.n0();
                String strR = c17637nI7.R();
                if (strR == null) {
                    strR = "";
                }
                arrayList2.add(aVar.a(iN0, strR, c17637nI7.getName(), c17637nI7.S()));
            }
            return arrayList2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$o */
    static final class o extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.b("ServicesViewModel", "e: " + ((Throwable) this.c).getMessage());
            new ArrayList();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            o oVar = new o(interfaceC20295rm1);
            oVar.c = th;
            return oVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            p pVar = new p(this.d, interfaceC20295rm1);
            pVar.c = obj;
            return pVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list.isEmpty()) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = new q(this.d, interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            List<Integer> botsIDs;
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list != null) {
                String str = this.d;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((ServicesPageSectionEntity) next).getTitle(), str)) {
                        break;
                    }
                }
                obj2 = (ServicesPageSectionEntity) next;
            } else {
                obj2 = null;
            }
            ServicesPageSectionEntity.BotsVitrineExtra botsVitrineExtra = obj2 instanceof ServicesPageSectionEntity.BotsVitrineExtra ? (ServicesPageSectionEntity.BotsVitrineExtra) obj2 : null;
            return (botsVitrineExtra == null || (botsIDs = botsVitrineExtra.getBotsIDs()) == null) ? AbstractC10360bX0.m() : botsIDs;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            r rVar = C6490Nt6.this.new r(interfaceC20295rm1);
            rVar.c = obj;
            return rVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List list;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list2 = (List) this.c;
                InterfaceC11621dJ7 interfaceC11621dJ7 = C6490Nt6.this.d;
                this.c = list2;
                this.b = 1;
                Object objL = interfaceC11621dJ7.l(list2, false, this);
                if (objL == objE) {
                    return objE;
                }
                list = list2;
                obj = objL;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.c;
                AbstractC10685c16.b(obj);
            }
            List list3 = (List) obj;
            if (list.size() != list3.size()) {
                List list4 = list;
                List list5 = list3;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list5, 10));
                Iterator it = list5.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((C17637nI7) it.next()).n0()));
                }
                C19406qI3.j("ServicesViewModel", "Couldn't fetch all bots. Missed bots id: " + AbstractC15401jX0.N0(list4, AbstractC15401jX0.r1(arrayList)), new Object[0]);
            }
            List<C17637nI7> list6 = list3;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list6, 10));
            for (C17637nI7 c17637nI7 : list6) {
                C7112Qi0.a aVar = C7112Qi0.e;
                int iN0 = c17637nI7.n0();
                String strR = c17637nI7.R();
                if (strR == null) {
                    strR = "";
                }
                arrayList2.add(aVar.a(iN0, strR, c17637nI7.getName(), c17637nI7.S()));
            }
            return arrayList2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$s */
    static final class s extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.b("ServicesViewModel", "e: " + ((Throwable) this.c).getMessage());
            new ArrayList();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            s sVar = new s(interfaceC20295rm1);
            sVar.c = th;
            return sVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            t tVar = new t(this.d, interfaceC20295rm1);
            tVar.c = obj;
            return tVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list.isEmpty()) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            u uVar = new u(this.d, interfaceC20295rm1);
            uVar.c = obj;
            return uVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ServicesPageSectionEntity servicesPageSectionEntity;
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list != null) {
                String str = this.d;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((ServicesPageSectionEntity) next).getTitle(), str)) {
                        break;
                    }
                }
                servicesPageSectionEntity = (ServicesPageSectionEntity) next;
            } else {
                servicesPageSectionEntity = null;
            }
            if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.CustomServices) {
                return (ServicesPageSectionEntity.CustomServices) servicesPageSectionEntity;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$v */
    static final class v extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return new C17428mw7((ServicesPageSectionEntity.CustomServices) this.c, (List) this.d, (Set) this.e);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object e(ServicesPageSectionEntity.CustomServices customServices, List list, Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            v vVar = new v(interfaceC20295rm1);
            vVar.c = customServices;
            vVar.d = list;
            vVar.e = set;
            return vVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            w wVar = new w(interfaceC20295rm1);
            wVar.c = obj;
            return wVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Exception {
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C17428mw7 c17428mw7 = (C17428mw7) this.c;
            ServicesPageSectionEntity.CustomServices customServices = (ServicesPageSectionEntity.CustomServices) c17428mw7.f();
            List<Integer> servicesIDs = customServices != null ? customServices.getServicesIDs() : null;
            List<Integer> list = servicesIDs;
            if (list == null || list.isEmpty()) {
                return AbstractC10360bX0.m();
            }
            List list2 = (List) c17428mw7.g();
            if (((Set) c17428mw7.j()) == null) {
                return AbstractC10360bX0.m();
            }
            ArrayList arrayList = new ArrayList();
            try {
                Iterator<Integer> it = servicesIDs.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    Iterator it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        C5988Lr6 c5988Lr6 = (C5988Lr6) next;
                        if (c5988Lr6.g() == iIntValue) {
                            C5721Ko c5721Ko = C5721Ko.a;
                            if (c5721Ko.h() <= c5988Lr6.h() || c5988Lr6.h() == 0) {
                                if (c5721Ko.h() >= c5988Lr6.j()) {
                                    break;
                                }
                            }
                        }
                    }
                    C5988Lr6 c5988Lr62 = (C5988Lr6) next;
                    if (c5988Lr62 != null) {
                        AbstractC6392Nk0.a(arrayList.add(C6472Nr6.q.a(c5988Lr62, !r12.contains(AbstractC6392Nk0.d(iIntValue)))));
                    }
                }
            } catch (Exception e) {
                C19406qI3.b("ServicesViewModel", "e: " + e.getMessage());
                if (e instanceof CancellationException) {
                    throw e;
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C17428mw7 c17428mw7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(c17428mw7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            x xVar = new x(this.d, interfaceC20295rm1);
            xVar.c = obj;
            return xVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list.isEmpty()) {
                return C19938rB7.a;
            }
            this.d.invoke(list);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$y */
    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            y yVar = new y(this.d, interfaceC20295rm1);
            yVar.c = obj;
            return yVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ServicesPageSectionEntity servicesPageSectionEntity;
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (list != null) {
                String str = this.d;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((ServicesPageSectionEntity) next).getTitle(), str)) {
                        break;
                    }
                }
                servicesPageSectionEntity = (ServicesPageSectionEntity) next;
            } else {
                servicesPageSectionEntity = null;
            }
            if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.ServiceItemsExtra) {
                return (ServicesPageSectionEntity.ServiceItemsExtra) servicesPageSectionEntity;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((y) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Nt6$z */
    static final class z extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;

        z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return new C17428mw7((ServicesPageSectionEntity.ServiceItemsExtra) this.c, (List) this.d, (Set) this.e);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object e(ServicesPageSectionEntity.ServiceItemsExtra serviceItemsExtra, List list, Set set, InterfaceC20295rm1 interfaceC20295rm1) {
            z zVar = new z(interfaceC20295rm1);
            zVar.c = serviceItemsExtra;
            zVar.d = list;
            zVar.e = set;
            return zVar.invokeSuspend(C19938rB7.a);
        }
    }

    public C6490Nt6(C22828vt6 c22828vt6, SettingsModule settingsModule, InterfaceC11621dJ7 interfaceC11621dJ7, NR nr, AbstractC13778go1 abstractC13778go1, Context context) {
        AbstractC13042fc3.i(c22828vt6, "servicesRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(context, "context");
        this.b = c22828vt6;
        this.c = settingsModule;
        this.d = interfaceC11621dJ7;
        this.e = nr;
        this.f = abstractC13778go1;
        this.g = context;
        this.h = AbstractC12281eL6.a(null);
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ht6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6490Nt6.t1(this.a);
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.It6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6490Nt6.s1(this.a);
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Jt6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(C6490Nt6.P1(this.a));
            }
        });
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Kt6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6490Nt6.Q1(this.a);
            }
        });
        this.m = new LinkedHashMap();
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C4837Gt6(null, null, 0, false, settingsModule.S3() < 10, null, 43, null));
        this.n = interfaceC9336Zm4A;
        this.o = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.p = DJ0.b(5, null, null, 6, null);
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Lt6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6490Nt6.R1();
            }
        });
        z1();
        y1();
        N1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), abstractC13778go1, null, new C6491a(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), abstractC13778go1, null, new C6492b(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), abstractC13778go1, null, new C6493c(null), 2, null);
        this.s = AbstractC17026mG5.a.g(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D1(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.X(AbstractC6459Nq2.v(this.b.z()), new k(null))), this.f), new l(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E1(String str, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.v(AbstractC6459Nq2.h(AbstractC6459Nq2.X(AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.b.G(), new m(str, null))), new n(null)), new o(null)))), this.f), new p(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object F1(String str, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.v(AbstractC6459Nq2.h(AbstractC6459Nq2.X(AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.b.G(), new q(str, null))), new r(null)), new s(null)))), this.f), new t(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G1(String str, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.v(AbstractC6459Nq2.X(AbstractC6459Nq2.v(AbstractC6459Nq2.o(AbstractC6459Nq2.X(this.b.G(), new u(str, null)), this.b.E(), this.h, new v(null))), new w(null)))), this.f), new x(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H1(String str, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.v(AbstractC6459Nq2.X(AbstractC6459Nq2.v(AbstractC6459Nq2.o(AbstractC6459Nq2.X(this.b.G(), new y(str, null)), this.b.E(), this.h, new z(null))), new A(null)))), this.f), new B(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M1(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.V(AbstractC6459Nq2.g(AbstractC6459Nq2.X(AbstractC6459Nq2.v(this.b.F()), new C(null))), this.f), new D(ua2, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    private final void N1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new E(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long P1(C6490Nt6 c6490Nt6) {
        AbstractC13042fc3.i(c6490Nt6, "this$0");
        return c6490Nt6.c.m2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q1(C6490Nt6 c6490Nt6) {
        AbstractC13042fc3.i(c6490Nt6, "this$0");
        return c6490Nt6.c.o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KS2 R1() {
        return new KS2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(boolean z2) {
        Object value;
        C4837Gt6 c4837Gt6B;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c4837Gt6B = (C4837Gt6) value;
            Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
            Object obj = mapA.get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
            InterfaceC20370rt6.g gVar = obj instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj : null;
            if (gVar != null) {
                mapA.put(ServicesPageSectionEntity.WALLET_SECTION_TITLE, InterfaceC20370rt6.g.c(gVar, 0, ServicesPageSectionEntity.WALLET_SECTION_TITLE, null, null, QJ2.b(gVar.e(), false, null, z2, 3, null), null, 45, null));
                AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
            }
        } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a2(C6490Nt6 c6490Nt6, boolean z2) {
        AbstractC13042fc3.i(c6490Nt6, "this$0");
        if (z2) {
            c6490Nt6.w1();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d2(ir.nasim.C6490Nt6 r22, ir.nasim.C12889fL5 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6490Nt6.d2(ir.nasim.Nt6, ir.nasim.fL5, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e2(ir.nasim.C6490Nt6 r13, ir.nasim.C12889fL5 r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6490Nt6.e2(ir.nasim.Nt6, ir.nasim.fL5, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(QJ2 qj2) {
        Object value;
        C4837Gt6 c4837Gt6B;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c4837Gt6B = (C4837Gt6) value;
            Map mapA = AbstractC20051rO3.A(c4837Gt6B.d());
            Object obj = mapA.get(ServicesPageSectionEntity.WALLET_SECTION_TITLE);
            InterfaceC20370rt6.g gVar = obj instanceof InterfaceC20370rt6.g ? (InterfaceC20370rt6.g) obj : null;
            if (gVar != null) {
                mapA.put(ServicesPageSectionEntity.WALLET_SECTION_TITLE, InterfaceC20370rt6.g.c(gVar, 0, ServicesPageSectionEntity.WALLET_SECTION_TITLE, null, null, qj2, null, 45, null));
                AbstractC13937h43 abstractC13937h43E = AbstractC13937h43.e(mapA);
                AbstractC13042fc3.h(abstractC13937h43E, "copyOf(...)");
                c4837Gt6B = C4837Gt6.b(c4837Gt6B, null, abstractC13937h43E, 0, false, false, null, 61, null);
            }
        } while (!interfaceC9336Zm4.f(value, c4837Gt6B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(EnumC17988nt6 enumC17988nt6, int i, int i2) {
        this.p.h(new C17428mw7(enumC17988nt6, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s1(C6490Nt6 c6490Nt6) {
        AbstractC13042fc3.i(c6490Nt6, "this$0");
        return c6490Nt6.c.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t1(C6490Nt6 c6490Nt6) {
        AbstractC13042fc3.i(c6490Nt6, "this$0");
        return c6490Nt6.c.l0();
    }

    private final void w1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new C6497g(null), 2, null);
    }

    private final void z1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new C6500j(null), 2, null);
    }

    public final String A1() {
        return (String) this.j.getValue();
    }

    public final String B1() {
        return (String) this.i.getValue();
    }

    public final Map C1() {
        return this.m;
    }

    public final long I1() {
        return ((Number) this.k.getValue()).longValue();
    }

    public final int J1() {
        return this.s;
    }

    public final String K1() {
        return (String) this.l.getValue();
    }

    public final boolean L1() {
        return this.c.X3() < 2;
    }

    public final InterfaceC10258bL6 O1() {
        return this.o;
    }

    public final void S1() {
        SettingsModule settingsModule = this.c;
        settingsModule.w7(settingsModule.S3() + 1);
    }

    public final void T1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C4837Gt6.b((C4837Gt6) value, null, null, 0, false, false, null, 31, null)));
    }

    public final void U1(int i) {
        C3343Am.i("gold_wallet", AbstractC19460qO3.g(AbstractC4616Fw7.a("event_type", Integer.valueOf(i))));
    }

    public final void V1(String str, Integer num, String str2, Integer num2, Integer num3, Integer num4, Integer num5, EnumC19170pt6 enumC19170pt6, Integer num6, Integer num7, Integer num8, String str3) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new F(num, str2, num2, num3, num4, num5, enumC19170pt6, num6, num7, num8, str3, str, null), 2, null);
    }

    public final void Y1(boolean z2) {
        if (z2) {
            return;
        }
        SettingsModule settingsModule = this.c;
        settingsModule.x7(settingsModule.X3() + 1);
    }

    public final void Z1(SA2 sa2, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(sa2, "navigateToCreatePass");
        AbstractC13042fc3.i(ua2, "navigateToValidatePass");
        AbstractC13042fc3.i(ua22, "registerNavigateResult");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new G(sa2, ua2, null), 3, null);
        ua22.invoke(new UA2() { // from class: ir.nasim.Mt6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6490Nt6.a2(this.a, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void c2() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new H(new C12889fL5(), null), 2, null);
    }

    public final void h2(UA2 ua2) {
        Object value;
        AbstractC13042fc3.i(ua2, "update");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, (C4837Gt6) ua2.invoke((C4837Gt6) value)));
    }

    public final void q1(int i) {
        Object value;
        LinkedHashSet linkedHashSet;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            Set set = (Set) value;
            if (set == null) {
                linkedHashSet = null;
            } else {
                linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll(set);
                linkedHashSet.add(Integer.valueOf(i));
            }
        } while (!interfaceC9336Zm4.f(value, linkedHashSet));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new C6495e(i, null), 2, null);
    }

    public final boolean u1() {
        return !this.c.N4() && C8386Vt0.U7();
    }

    public final void v1() {
        if (C8386Vt0.a.M6()) {
            w1();
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new C6496f(null), 2, null);
        }
    }

    public final void x1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new C6498h(null), 2, null);
    }

    public final void y1() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.r;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.r = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new C6499i(null), 3, null);
    }
}
