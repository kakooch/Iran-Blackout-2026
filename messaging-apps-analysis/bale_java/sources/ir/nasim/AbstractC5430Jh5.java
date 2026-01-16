package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.A98;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC5430Jh5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Jh5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5430Jh5 {

    /* renamed from: ir.nasim.Jh5$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(159008512);
            A98.a aVar = A98.a;
            A98 a98H = AbstractC21393ta8.h(AbstractC24416ya8.c(aVar, interfaceC22053ub1, 6), AbstractC24416ya8.b(aVar, interfaceC22053ub1, 6));
            interfaceC22053ub1.Q();
            return a98H;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.Jh5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ List d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ List g;
        final /* synthetic */ Context h;

        /* renamed from: ir.nasim.Jh5$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ int a;
            final /* synthetic */ String b;

            a(int i, String str) {
                this.a = i;
                this.b = str;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AbstractC9459a00.c(null, UY6.c(DD5.poll_question, interfaceC22053ub1, 0), AbstractC12152e76.c(String.valueOf(this.a)) + Separators.SP + this.b, interfaceC22053ub1, 0, 1);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Jh5$b$b, reason: collision with other inner class name */
        static final class C0450b implements InterfaceC15796kB2 {
            final /* synthetic */ String a;

            C0450b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                int i2 = G10.b;
                AbstractC9339Zm7.b(this.a, androidx.compose.foundation.layout.q.j(androidx.compose.ui.e.a, C17784nZ1.q(16), C17784nZ1.q(12)), g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), interfaceC22053ub1, 48, 0, 65528);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Jh5$b$c */
        static final class c implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ int b;
            final /* synthetic */ List c;
            final /* synthetic */ int d;
            final /* synthetic */ List e;

            c(List list, int i, List list2, int i2, List list3) {
                this.a = list;
                this.b = i;
                this.c = list2;
                this.d = i2;
                this.e = list3;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Iterator it = this.a.iterator();
                int iC = 0;
                while (it.hasNext()) {
                    iC += ((C19640qh5) it.next()).c();
                }
                int i2 = this.b;
                int iD = i2 > 0 ? AbstractC20723sV3.d((iC * 100.0f) / i2) : 0;
                String str = (String) this.c.get(this.d);
                List list = this.e;
                int i3 = this.d;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((C19640qh5) obj).a() == i3) {
                        arrayList.add(obj);
                    }
                }
                Iterator it2 = arrayList.iterator();
                int iC2 = 0;
                while (it2.hasNext()) {
                    iC2 += ((C19640qh5) it2.next()).c();
                }
                AbstractC9459a00.c(null, str, AbstractC12152e76.c(String.valueOf(iC2)) + Separators.SP + UY6.c(DD5.poll_vote, interfaceC22053ub1, 0) + " (" + AbstractC12152e76.b(String.valueOf(iD)) + UY6.c(DD5.percentage_symbol, interfaceC22053ub1, 0) + Separators.RPAREN, interfaceC22053ub1, 0, 1);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Jh5$b$d */
        static final class d implements InterfaceC16978mB2 {
            final /* synthetic */ C19640qh5 a;
            final /* synthetic */ List b;
            final /* synthetic */ Context c;

            d(C19640qh5 c19640qh5, List list, Context context) {
                this.a = c19640qh5;
                this.b = list;
                this.c = context;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                Object next;
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 48) == 0) {
                    i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C20449s18 c20449s18 = (C20449s18) this.a.b().get(i);
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((C17637nI7) next).n0() == c20449s18.a()) {
                            break;
                        }
                    }
                }
                C17637nI7 c17637nI7 = (C17637nI7) next;
                if (c17637nI7 == null) {
                    return;
                }
                Context context = this.c;
                interfaceC22053ub1.W(-764594729);
                if (c20449s18.b() > 0) {
                    AbstractC5430Jh5.k(null, c17637nI7, C14593iA1.a.T(c20449s18.b(), context), interfaceC22053ub1, 0, 1);
                }
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Jh5$b$e */
        static final class e implements InterfaceC15796kB2 {
            final /* synthetic */ C19640qh5 a;

            e(C19640qh5 c19640qh5) {
                this.a = c19640qh5;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC5430Jh5.m(null, this.a.c() - this.a.b().size(), interfaceC22053ub1, 0, 1);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(List list, boolean z, String str, List list2, int i, String str2, List list3, Context context) {
            this.a = list;
            this.b = z;
            this.c = str;
            this.d = list2;
            this.e = i;
            this.f = str2;
            this.g = list3;
            this.h = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(List list, Map map, int i, String str, String str2, List list2, List list3, Context context, InterfaceC15069ix3 interfaceC15069ix3) {
            final int i2;
            AbstractC13042fc3.i(list, "$fullResult");
            AbstractC13042fc3.i(map, "$groupedResults");
            AbstractC13042fc3.i(str, "$votersString");
            AbstractC13042fc3.i(str2, "$question");
            AbstractC13042fc3.i(list2, "$answers");
            AbstractC13042fc3.i(list3, "$voters");
            AbstractC13042fc3.i(context, "$context");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            boolean z = true;
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1675978341, true, new a(i, str)), 3, null);
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-882497714, true, new C0450b(str2)), 3, null);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((C19640qh5) it.next()).c();
            }
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                List list4 = (List) entry.getValue();
                List<C19640qh5> list5 = list4;
                Iterator it2 = list5.iterator();
                int iC = 0;
                while (it2.hasNext()) {
                    iC += ((C19640qh5) it2.next()).c();
                }
                if (iC > 0) {
                    boolean z2 = z;
                    z = z2;
                    i2 = iIntValue;
                    InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1401312785, z2, new c(list4, i, list2, iIntValue, list)), 3, null);
                } else {
                    i2 = iIntValue;
                }
                for (final C19640qh5 c19640qh5 : list5) {
                    InterfaceC15069ix3.g(interfaceC15069ix3, c19640qh5.b().size(), new UA2() { // from class: ir.nasim.Lh5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC5430Jh5.b.f(c19640qh5, i2, ((Integer) obj).intValue());
                        }
                    }, null, AbstractC19242q11.c(-1104746837, z, new d(c19640qh5, list3, context)), 4, null);
                    if (c19640qh5.c() > c19640qh5.b().size()) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1298156355, z, new e(c19640qh5)), 3, null);
                    }
                }
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object f(C19640qh5 c19640qh5, int i, int i2) {
            AbstractC13042fc3.i(c19640qh5, "$result");
            return Integer.valueOf(((C20449s18) c19640qh5.b().get(i2)).a() + i);
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            List list = this.a;
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                Integer numValueOf = Integer.valueOf(((C19640qh5) obj).a());
                Object arrayList = linkedHashMap.get(numValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(numValueOf, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            boolean z = this.b;
            final String str = this.c;
            final List list2 = this.d;
            final int i2 = this.e;
            final String str2 = this.f;
            final List list3 = this.a;
            final List list4 = this.g;
            final Context context = this.h;
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar2.g(), interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            float f = 16;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null), C17784nZ1.q(4)), C17784nZ1.q(44)), N46.d(C17784nZ1.q(f)));
            EnumC10352bW1 enumC10352bW1 = EnumC10352bW1.c;
            G10 g10 = G10.a;
            int i3 = G10.b;
            MY2.b(eVarA, enumC10352bW1, g10.a(interfaceC22053ub1, i3).E(), interfaceC22053ub1, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(10)), interfaceC22053ub1, 6);
            AbstractC9339Zm7.b(UY6.c(DD5.poll_result, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1, i3).B(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).l(), interfaceC22053ub1, 48, 0, 65016);
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(f)), interfaceC22053ub1, 6);
            if (z) {
                interfaceC22053ub1.W(1107589356);
                AbstractC5430Jh5.i(str, list2, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1107807162);
                interfaceC22053ub1.W(1282662709);
                boolean zE = interfaceC22053ub1.e(i2) | interfaceC22053ub1.V(str2) | interfaceC22053ub1.V(str) | interfaceC22053ub1.D(list3) | interfaceC22053ub1.D(linkedHashMap) | interfaceC22053ub1.D(list2) | interfaceC22053ub1.D(list4) | interfaceC22053ub1.D(context);
                Object objB = interfaceC22053ub1.B();
                if (zE || objB == InterfaceC22053ub1.a.a()) {
                    Object obj2 = new UA2() { // from class: ir.nasim.Kh5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj3) {
                            return AbstractC5430Jh5.b.d(list3, linkedHashMap, i2, str2, str, list2, list4, context, (InterfaceC15069ix3) obj3);
                        }
                    };
                    interfaceC22053ub1.s(obj2);
                    objB = obj2;
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 511);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final java.lang.String r39, final java.util.List r40, final java.util.List r41, final boolean r42, final ir.nasim.SA2 r43, final java.util.List r44, boolean r45, final int r46, ir.nasim.InterfaceC22053ub1 r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5430Jh5.f(java.lang.String, java.util.List, java.util.List, boolean, ir.nasim.SA2, java.util.List, boolean, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismiss");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(String str, List list, List list2, boolean z, SA2 sa2, List list3, boolean z2, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$question");
        AbstractC13042fc3.i(list, "$answers");
        AbstractC13042fc3.i(list2, "$fullResult");
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(list3, "$voters");
        f(str, list, list2, z, sa2, list3, z2, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final String str, List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub12;
        final List<String> list2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-550326595);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.V(str) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
            list2 = list;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f = 16;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f));
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC9339Zm7.b(str, androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(f), C17784nZ1.q(12)), g10.a(interfaceC22053ub1J, i4).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).b(), interfaceC22053ub1J, (i3 & 14) | 48, 0, 65528);
            interfaceC22053ub12 = interfaceC22053ub1J;
            interfaceC22053ub12.W(-1664651208);
            list2 = list;
            for (String str2 : list2) {
                e.a aVar3 = androidx.compose.ui.e.a;
                Object obj = null;
                float f2 = 8;
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), 0.0f, C17784nZ1.q(f2), 1, null);
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.m mVarH = c24254yJ.h();
                InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(mVarH, aVar4.k(), interfaceC22053ub12, 0);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub12.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarK);
                InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
                SA2 sa2A2 = aVar5.a();
                if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub12.G();
                if (interfaceC22053ub12.h()) {
                    interfaceC22053ub12.g(sa2A2);
                } else {
                    interfaceC22053ub12.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub12);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar5.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
                C9784aZ0 c9784aZ02 = C9784aZ0.a;
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C17784nZ1.q(f2), 7, null);
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.e(), aVar4.i(), interfaceC22053ub12, 54);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub12.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarM);
                SA2 sa2A3 = aVar5.a();
                if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub12.G();
                if (interfaceC22053ub12.h()) {
                    interfaceC22053ub12.g(sa2A3);
                } else {
                    interfaceC22053ub12.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub12);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B, aVar5.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
                float f3 = 20;
                float f4 = 14;
                androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.i(L66.b(M66.a, aVar3, 1.0f, false, 2, null), C17784nZ1.q(f3)), N46.c(AbstractC10554bo1.c(C17784nZ1.q(f4)))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub12, 0);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(f)), interfaceC22053ub12, 6);
                androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(60)), C17784nZ1.q(f)), N46.c(AbstractC10554bo1.c(C17784nZ1.q(f4)))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub12, 0);
                interfaceC22053ub12.u();
                interfaceC22053ub12.W(680823709);
                int i5 = 0;
                while (i5 < 3) {
                    e.a aVar6 = androidx.compose.ui.e.a;
                    float f5 = 4;
                    androidx.compose.ui.e eVarK2 = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar6, 0.0f, 1, obj), 0.0f, C17784nZ1.q(f5), 1, obj);
                    InterfaceC12529em.a aVar7 = InterfaceC12529em.a;
                    InterfaceC12529em.c cVarI = aVar7.i();
                    C24254yJ c24254yJ2 = C24254yJ.a;
                    InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ2.g(), cVarI, interfaceC22053ub12, 48);
                    int iA4 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub12.q();
                    androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarK2);
                    InterfaceC16030kb1.a aVar8 = InterfaceC16030kb1.d0;
                    SA2 sa2A4 = aVar8.a();
                    if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub12.G();
                    if (interfaceC22053ub12.h()) {
                        interfaceC22053ub12.g(sa2A4);
                    } else {
                        interfaceC22053ub12.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub12);
                    DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B2, aVar8.e());
                    DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar8.g());
                    InterfaceC14603iB2 interfaceC14603iB2B4 = aVar8.b();
                    if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                        interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                        interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                    }
                    DG7.c(interfaceC22053ub1A4, eVarE4, aVar8.f());
                    M66 m66 = M66.a;
                    androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.t(aVar6, C17784nZ1.q(50)), N46.g()), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub12, 0);
                    ZH6.a(androidx.compose.foundation.layout.t.y(aVar6, C17784nZ1.q(f)), interfaceC22053ub12, 6);
                    androidx.compose.ui.e eVarB = L66.b(m66, aVar6, 1.0f, false, 2, null);
                    InterfaceC10970cW3 interfaceC10970cW3A3 = XY0.a(c24254yJ2.h(), aVar7.k(), interfaceC22053ub12, 0);
                    int iA5 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub12.q();
                    androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarB);
                    SA2 sa2A5 = aVar8.a();
                    if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub12.G();
                    if (interfaceC22053ub12.h()) {
                        interfaceC22053ub12.g(sa2A5);
                    } else {
                        interfaceC22053ub12.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub12);
                    DG7.c(interfaceC22053ub1A5, interfaceC10970cW3A3, aVar8.e());
                    DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar8.g());
                    InterfaceC14603iB2 interfaceC14603iB2B5 = aVar8.b();
                    if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                        interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                        interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
                    }
                    DG7.c(interfaceC22053ub1A5, eVarE5, aVar8.f());
                    C9784aZ0 c9784aZ03 = C9784aZ0.a;
                    androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar6, C17784nZ1.q(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)), C17784nZ1.q(f3)), N46.c(AbstractC10554bo1.c(C17784nZ1.q(f4)))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub12, 0);
                    ZH6.a(androidx.compose.foundation.layout.t.i(aVar6, C17784nZ1.q(f5)), interfaceC22053ub12, 6);
                    androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar6, C17784nZ1.q(Type.TSIG)), C17784nZ1.q(18)), N46.c(AbstractC10554bo1.c(C17784nZ1.q(f4)))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub12, 0);
                    interfaceC22053ub12.u();
                    interfaceC22053ub12.u();
                    i5++;
                    obj = null;
                }
                interfaceC22053ub12.Q();
                interfaceC22053ub12.u();
            }
            interfaceC22053ub12.Q();
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ih5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC5430Jh5.j(str, list2, i, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(String str, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$question");
        AbstractC13042fc3.i(list, "$answers");
        i(str, list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(androidx.compose.ui.e eVar, final C17637nI7 c17637nI7, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(c17637nI7, "user");
        AbstractC13042fc3.i(str, "votedAt");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2044970037);
        if ((i2 & 2) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = (interfaceC22053ub1J.D(c17637nI7) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        int i4 = i3;
        if ((i4 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            eVar2 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c17637nI7.S(), null, false, 0, interfaceC22053ub1J, 0, 14);
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.e eVarG = c24254yJ.g();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            float fQ = C17784nZ1.q(50);
            UU uu = new UU(false, null, null, null, c17637nI7.getName(), 0, false, WKSRecord.Service.SUNRPC, null);
            G10 g10 = G10.a;
            int i5 = G10.b;
            TU.m(ev4H, uu, androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, i5).b().c()), fQ, 0.0f, 0.0f, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(16)), interfaceC22053ub1J, 6);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1J, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String name = c17637nI7.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            float f = 14;
            AbstractC9339Zm7.b(name, androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null), g10.a(interfaceC22053ub1J, i5).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).a(), interfaceC22053ub1J, 48, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(4)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1J, i5).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).c(), interfaceC22053ub1J, (i4 >> 6) & 14, 0, 65530);
            interfaceC22053ub1J = interfaceC22053ub1J;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(f)), interfaceC22053ub1J, 6);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar3 = eVar2;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fh5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5430Jh5.l(eVar3, c17637nI7, str, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(androidx.compose.ui.e eVar, C17637nI7 c17637nI7, String str, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c17637nI7, "$user");
        AbstractC13042fc3.i(str, "$votedAt");
        k(eVar, c17637nI7, str, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void m(androidx.compose.ui.e eVar, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-841032081);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((2 & i3) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i6 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1J, i6).b().c());
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), aVar.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.t(aVar3, C17784nZ1.q(50)), N46.g()), g10.a(interfaceC22053ub1J, i6).o(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            SA2 sa2A2 = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar2.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC11456d23.b(FV4.c(AbstractC15208jB5.ic_person, interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.t.t(aVar3, C17784nZ1.q(24)), null, InterfaceC13157fl1.a.e(), 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, C24381yX0.b.j(), 0, 2, null), interfaceC22053ub1J, 1597872, 40);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(16)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(AbstractC12152e76.c(String.valueOf(i)) + Separators.SP + UY6.c(DD5.voters_count, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i6).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i6).a(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Eh5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5430Jh5.n(eVar3, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(androidx.compose.ui.e eVar, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        m(eVar, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }
}
