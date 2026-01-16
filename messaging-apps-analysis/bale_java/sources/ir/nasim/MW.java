package ir.nasim;

import ai.bale.proto.PremiumOuterClass$ResponseGetBadges;
import ai.bale.proto.PremiumStruct$Badge;
import ai.bale.proto.PremiumStruct$BadgeCategory;
import android.content.Context;
import ir.nasim.AbstractC5909Li7;
import ir.nasim.HW;
import ir.nasim.LW;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MW extends VW7 {
    private static final a g = new a(null);
    public static final int h = 8;
    private final InterfaceC5943Lm5 b;
    private final Context c;
    private final InterfaceC9336Zm4 d;
    private final C23078wJ3 e;
    private final C23078wJ3 f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PremiumStruct$BadgeCategory d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PremiumStruct$BadgeCategory premiumStruct$BadgeCategory, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumStruct$BadgeCategory;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5943Lm5 interfaceC5943Lm5 = MW.this.b;
                long id = this.d.getId();
                String mediaUrl = this.d.getMediaUrl();
                AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
                int number = this.d.getMediaFormat().getNumber();
                this.b = 1;
                if (interfaceC5943Lm5.d(id, mediaUrl, number, this) == objE) {
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PremiumStruct$Badge d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PremiumStruct$Badge premiumStruct$Badge, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = premiumStruct$Badge;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5943Lm5 interfaceC5943Lm5 = MW.this.b;
                long badgeId = this.d.getBadgeId();
                String mediaUrl = this.d.getMediaUrl();
                AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
                int number = this.d.getMediaFormat().getNumber();
                this.b = 1;
                if (interfaceC5943Lm5.d(badgeId, mediaUrl, number, this) == objE) {
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

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = MW.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objL;
            Object value;
            String string;
            Object value2;
            InterfaceC20315ro1 interfaceC20315ro12;
            boolean z;
            Iterator it;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            boolean z2 = true;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro13 = (InterfaceC20315ro1) this.c;
                MW.this.e1();
                InterfaceC5943Lm5 interfaceC5943Lm5 = MW.this.b;
                this.c = interfaceC20315ro13;
                this.b = 1;
                Object objF = interfaceC5943Lm5.f(this);
                if (objF == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro13;
                objL = objF;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            MW mw = MW.this;
            if (C9475a16.j(objL)) {
                PremiumOuterClass$ResponseGetBadges premiumOuterClass$ResponseGetBadges = (PremiumOuterClass$ResponseGetBadges) objL;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<PremiumStruct$BadgeCategory> categoriesList = premiumOuterClass$ResponseGetBadges.getCategoriesList();
                AbstractC13042fc3.h(categoriesList, "getCategoriesList(...)");
                Iterator it2 = categoriesList.iterator();
                int size = 0;
                while (it2.hasNext()) {
                    PremiumStruct$BadgeCategory premiumStruct$BadgeCategory = (PremiumStruct$BadgeCategory) it2.next();
                    List<PremiumStruct$Badge> badgesList = premiumStruct$BadgeCategory.getBadgesList();
                    AbstractC13042fc3.h(badgesList, "getBadgesList(...)");
                    if (badgesList.isEmpty() ^ z2) {
                        AbstractC13042fc3.f(premiumStruct$BadgeCategory);
                        HW.b bVarB = DW.b(premiumStruct$BadgeCategory);
                        arrayList.add(bVarB);
                        List<PremiumStruct$Badge> badgesList2 = premiumStruct$BadgeCategory.getBadgesList();
                        AbstractC13042fc3.h(badgesList2, "getBadgesList(...)");
                        List<PremiumStruct$Badge> list = badgesList2;
                        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list, 10));
                        Iterator it3 = list.iterator();
                        while (it3.hasNext()) {
                            PremiumStruct$Badge premiumStruct$Badge = (PremiumStruct$Badge) it3.next();
                            AbstractC13042fc3.f(premiumStruct$Badge);
                            long id = premiumStruct$BadgeCategory.getId();
                            InterfaceC5943Lm5 interfaceC5943Lm52 = mw.b;
                            Iterator it4 = it2;
                            long badgeId = premiumStruct$Badge.getBadgeId();
                            Iterator it5 = it3;
                            String mediaUrl = premiumStruct$Badge.getMediaUrl();
                            AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
                            arrayList3.add(DW.a(premiumStruct$Badge, id, interfaceC5943Lm52.l(badgeId, mediaUrl)));
                            interfaceC20315ro1 = interfaceC20315ro1;
                            it2 = it4;
                            size = size;
                            it3 = it5;
                        }
                        interfaceC20315ro12 = interfaceC20315ro1;
                        it = it2;
                        int i2 = size;
                        arrayList.addAll(arrayList3);
                        InterfaceC5943Lm5 interfaceC5943Lm53 = mw.b;
                        long id2 = premiumStruct$BadgeCategory.getId();
                        String mediaUrl2 = premiumStruct$BadgeCategory.getMediaUrl();
                        AbstractC13042fc3.h(mediaUrl2, "getMediaUrl(...)");
                        AbstractC5909Li7.a aVarC = DW.c(premiumStruct$BadgeCategory, interfaceC5943Lm53.l(id2, mediaUrl2));
                        arrayList2.add(aVarC);
                        C23078wJ3 c23078wJ3 = mw.f;
                        long jA = bVarB.a();
                        z = true;
                        c23078wJ3.h(jA, arrayList2.size() - 1);
                        mw.e.h(aVarC.d(), i2);
                        size = i2 + 1;
                    } else {
                        interfaceC20315ro12 = interfaceC20315ro1;
                        z = z2;
                        it = it2;
                    }
                    size += premiumStruct$BadgeCategory.getBadgesList().size();
                    interfaceC20315ro1 = interfaceC20315ro12;
                    z2 = z;
                    it2 = it;
                }
                InterfaceC20315ro1 interfaceC20315ro14 = interfaceC20315ro1;
                InterfaceC9336Zm4 interfaceC9336Zm4 = mw.d;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, new LW.d(arrayList, arrayList2)));
                mw.X0(interfaceC20315ro14, premiumOuterClass$ResponseGetBadges);
            }
            MW mw2 = MW.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = mw2.d;
                do {
                    value = interfaceC9336Zm42.getValue();
                    string = mw2.c.getString(AbstractC12217eE5.error_unknown);
                    AbstractC13042fc3.h(string, "getString(...)");
                } while (!interfaceC9336Zm42.f(value, new LW.a(string)));
                C19406qI3.c("BadgeViewModel", "Failed to get badges", thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object value;
            String string;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5943Lm5 interfaceC5943Lm5 = MW.this.b;
                long j = this.d;
                String str = this.e;
                this.b = 1;
                objB = interfaceC5943Lm5.b(j, str, this);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            MW mw = MW.this;
            if (C9475a16.j(objB)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = mw.d;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, new LW.a("Badge Set")));
            }
            MW mw2 = MW.this;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = mw2.d;
                do {
                    value = interfaceC9336Zm42.getValue();
                    string = mw2.c.getString(AbstractC12217eE5.error_unknown);
                    AbstractC13042fc3.h(string, "getString(...)");
                } while (!interfaceC9336Zm42.f(value, new LW.a(string)));
                C19406qI3.c("BadgeViewModel", "Failed to set badge", thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public MW(InterfaceC5943Lm5 interfaceC5943Lm5, Context context) {
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(context, "context");
        this.b = interfaceC5943Lm5;
        this.c = context;
        this.d = AbstractC12281eL6.a(LW.b.a);
        this.e = new C23078wJ3();
        this.f = new C23078wJ3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(InterfaceC20315ro1 interfaceC20315ro1, PremiumOuterClass$ResponseGetBadges premiumOuterClass$ResponseGetBadges) {
        List<PremiumStruct$BadgeCategory> categoriesList = premiumOuterClass$ResponseGetBadges.getCategoriesList();
        AbstractC13042fc3.h(categoriesList, "getCategoriesList(...)");
        List<PremiumStruct$BadgeCategory> list = categoriesList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b((PremiumStruct$BadgeCategory) it.next(), null), 3, null));
        }
        List<PremiumStruct$BadgeCategory> categoriesList2 = premiumOuterClass$ResponseGetBadges.getCategoriesList();
        AbstractC13042fc3.h(categoriesList2, "getCategoriesList(...)");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = categoriesList2.iterator();
        while (it2.hasNext()) {
            List<PremiumStruct$Badge> badgesList = ((PremiumStruct$BadgeCategory) it2.next()).getBadgesList();
            AbstractC13042fc3.h(badgesList, "getBadgesList(...)");
            AbstractC13610gX0.D(arrayList2, badgesList);
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c((PremiumStruct$Badge) it3.next(), null), 3, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        Object value;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HW.c.b(0L, "header-shimmer", 1, null));
        ArrayList arrayList2 = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            arrayList2.add(new HW.c.a(0L, "shimmer-" + i, 1, null));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList3.add(new AbstractC5909Li7.b("tab-shimmer-" + i2));
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new LW.c(arrayList, arrayList3)));
    }

    public final InterfaceC13730gj3 Y0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    public final InterfaceC10258bL6 Z0() {
        return AbstractC6459Nq2.c(this.d);
    }

    public final int a1(long j) {
        return this.e.e(j, 0);
    }

    public final int b1(long j) {
        return this.f.e(j, 0);
    }

    public final void c1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, LW.b.a));
        this.e.c();
        this.f.c();
    }

    public final InterfaceC13730gj3 d1(long j, String str) {
        AbstractC13042fc3.i(str, "url");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(j, str, null), 3, null);
    }
}
