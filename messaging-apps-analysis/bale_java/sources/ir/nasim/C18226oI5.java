package ir.nasim;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.ContextThemeWrapper;
import ir.nasim.R62;
import ir.nasim.VH5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.oI5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18226oI5 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final InterfaceC9173Yu3 a;
    private final InterfaceC9173Yu3 b;

    /* renamed from: ir.nasim.oI5$a */
    public static final class a {
        private a() {
        }

        public final Map a(Context context, C13518gM7 c13518gM7, Set set) {
            CI7 ci7A;
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c13518gM7, "usersProcessor");
            AbstractC13042fc3.i(set, "userIds");
            Map mapD = AbstractC19460qO3.d();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (!mapD.containsKey(Integer.valueOf(iIntValue)) && (ci7A = c13518gM7.a(iIntValue)) != null) {
                    mapD.put(Integer.valueOf(ci7A.c()), AbstractC13591gV.a(ci7A, context));
                }
            }
            return AbstractC19460qO3.c(mapD);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C18226oI5(final Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mI5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18226oI5.j(context);
            }
        });
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nI5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18226oI5.l(context);
            }
        });
    }

    private final VH5 c(boolean z, long j, GG5 gg5, int i, int i2, Integer num, int i3, List list, boolean z2) {
        if (z && AbstractC15401jX0.j0(gg5.y()).size() == j) {
            List list2 = list;
            if (!list2.isEmpty()) {
                R62.b bVarA = R62.A(gg5.u());
                if (bVarA == null) {
                    return null;
                }
                List listT0 = AbstractC15401jX0.T0(list);
                VH5.a aVar = VH5.q;
                return new LG5(bVarA, i, i2, num, i3, 0, null, 0.0f, 0, 0, 0, 0, 0, aVar.e() + (aVar.f() * (list2.size() - 1)), 0, 0, listT0, z2, 57312, null);
            }
        }
        R62.b bVarA2 = R62.A(gg5.u());
        if (bVarA2 != null) {
            return new VH5(AbstractC20655sN7.g(j), bVarA2, i, num, i3, 0, null, 0.0f, 0, 0, 0, 0, 0, 0, 0, 32736, null);
        }
        return null;
    }

    private final int e(boolean z, Context context) {
        return OY0.b(context, z ? AbstractC21139tA5.bubble_forth : AbstractC21139tA5.bubble_third);
    }

    private final int f(boolean z, Context context) {
        XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(AbstractC21139tA5.bubble_primary), Integer.valueOf(z ? AbstractC21139tA5.bubble_forth : AbstractC21139tA5.bubble_third));
        return OY0.a(OY0.b(context, ((Number) xv4A.e()).intValue()), OY0.b(context, ((Number) xv4A.f()).intValue()));
    }

    private final ContextThemeWrapper g() {
        return (ContextThemeWrapper) this.a.getValue();
    }

    private final ContextThemeWrapper h() {
        return (ContextThemeWrapper) this.b.getValue();
    }

    private final Integer i(boolean z, Context context) {
        Integer numValueOf = z ? Integer.valueOf(AbstractC21139tA5.bubble_secondary) : null;
        if (numValueOf != null) {
            return Integer.valueOf(OY0.b(context, numValueOf.intValue()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper j(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming);
    }

    private final boolean k(GG5 gg5) {
        return PG5.a.f(gg5.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper l(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme_Outgoing);
    }

    private final List m(List list) {
        return AbstractC15401jX0.T0(AbstractC15401jX0.a1(list, AbstractC18050o01.b(new C25226zw5() { // from class: ir.nasim.oI5.b
            @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
            public Object get(Object obj) {
                return Long.valueOf(((GG5) obj).s());
            }
        }, new C25226zw5() { // from class: ir.nasim.oI5.c
            @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
            public Object get(Object obj) {
                return ((GG5) obj).u();
            }
        })));
    }

    public final XV4 d(boolean z, int i, int i2, List list, Map map, boolean z2) {
        String str;
        ArrayList arrayList;
        C18226oI5 c18226oI5 = this;
        AbstractC13042fc3.i(list, "reactions");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ContextThemeWrapper contextThemeWrapperG = i2 != i ? g() : h();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (c18226oI5.k((GG5) obj)) {
                arrayList2.add(obj);
            }
        }
        String strU = null;
        for (GG5 gg5 : c18226oI5.m(arrayList2)) {
            boolean zContains = strU == null ? gg5.y().contains(Integer.valueOf(i)) : false;
            if (zContains) {
                strU = gg5.u();
            }
            String str2 = strU;
            int iE = c18226oI5.e(zContains, contextThemeWrapperG);
            int iF = c18226oI5.f(zContains, contextThemeWrapperG);
            Integer numI = c18226oI5.i(zContains, contextThemeWrapperG);
            int iB = OY0.b(contextThemeWrapperG, AbstractC21139tA5.bubble_low_text);
            String str3 = gg5.u() + "-" + gg5.s() + "-" + zContains;
            spannableStringBuilder.append((CharSequence) str3);
            long jW = gg5.w();
            if (map != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Iterator it2 = it;
                    String str4 = str3;
                    if (gg5.y().contains(Integer.valueOf(((Number) entry.getKey()).intValue()))) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                    it = it2;
                    str3 = str4;
                }
                str = str3;
                arrayList = new ArrayList(linkedHashMap.size());
                Iterator it3 = linkedHashMap.entrySet().iterator();
                while (it3.hasNext()) {
                    arrayList.add((C20610sI7) ((Map.Entry) it3.next()).getValue());
                }
            } else {
                str = str3;
                arrayList = null;
            }
            String str5 = str;
            spannableStringBuilder.setSpan(c(z, jW, gg5, iE, iF, numI, iB, arrayList == null ? AbstractC10360bX0.m() : arrayList, z2), spannableStringBuilder.length() - str5.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.setSpan(new MG5(gg5.u(), zContains), spannableStringBuilder.length() - str5.length(), spannableStringBuilder.length(), 17);
            spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
            c18226oI5 = this;
            strU = str2;
        }
        return AbstractC4616Fw7.a(spannableStringBuilder, strU);
    }
}
