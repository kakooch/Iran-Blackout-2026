package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Hl0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4993Hl0 {
    private static final a c = new a(null);
    public static final int d = 8;
    private final Context a;
    private final boolean b;

    /* renamed from: ir.nasim.Hl0$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Hl0$b */
    public interface b {
        C4993Hl0 a(Context context);
    }

    public C4993Hl0(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = JF5.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(C9588aD2 c9588aD2) {
        AbstractC13042fc3.i(c9588aD2, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(C9588aD2 c9588aD2) {
        AbstractC13042fc3.i(c9588aD2, "galleryItem");
        return !(c9588aD2.b() != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(C9588aD2 c9588aD2) {
        AbstractC13042fc3.i(c9588aD2, "galleryItem");
        return c9588aD2.b() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(C3808Cl0 c3808Cl0, C9588aD2 c9588aD2) {
        AbstractC13042fc3.i(c3808Cl0, "$bucket");
        AbstractC13042fc3.i(c9588aD2, "galleryItem");
        return c9588aD2.a() == c3808Cl0.d();
    }

    public final List e(List list, List list2) {
        long j;
        C5227Il0 c5227Il0;
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(list2, "buckets");
        if (list.isEmpty() || list2.isEmpty()) {
            return AbstractC10360bX0.m();
        }
        HashMap map = new HashMap(list2.size());
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        C9588aD2 c9588aD2 = null;
        C9588aD2 c9588aD22 = null;
        while (it.hasNext()) {
            C9588aD2 c9588aD23 = (C9588aD2) it.next();
            if (c9588aD23.b() != null) {
                i2++;
                if (c9588aD22 == null) {
                    c9588aD22 = c9588aD23;
                }
            } else {
                i++;
                if (c9588aD2 == null) {
                    c9588aD2 = c9588aD23;
                }
            }
            if (!map.containsKey(Long.valueOf(c9588aD23.a()))) {
                map.put(Long.valueOf(c9588aD23.a()), c9588aD23);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (c9588aD2 == null || c9588aD22 == null) {
            j = Long.MAX_VALUE;
        } else {
            String strF = ((C9588aD2) AbstractC15401jX0.q0(list)).f();
            String string = this.a.getString(GD5.gallery_bottom_sheet_title_default);
            AbstractC13042fc3.h(string, "getString(...)");
            j = 9223372036854775806L;
            arrayList.add(new C5227Il0(9223372036854775806L, string, XY6.v(Separators.LPAREN + list.size() + Separators.RPAREN), strF, new UA2() { // from class: ir.nasim.Dl0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C4993Hl0.f((C9588aD2) obj));
                }
            }));
        }
        if (c9588aD2 != null) {
            j--;
            String strF2 = c9588aD2.f();
            String string2 = this.a.getString(GD5.bucket_all_images);
            AbstractC13042fc3.h(string2, "getString(...)");
            arrayList.add(new C5227Il0(j, string2, XY6.v(Separators.LPAREN + i + Separators.RPAREN), strF2, new UA2() { // from class: ir.nasim.El0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C4993Hl0.g((C9588aD2) obj));
                }
            }));
        }
        if (c9588aD22 != null) {
            String strF3 = c9588aD22.f();
            String string3 = this.a.getString(GD5.bucket_all_videos);
            AbstractC13042fc3.h(string3, "getString(...)");
            arrayList.add(new C5227Il0(j - 1, string3, XY6.v(Separators.LPAREN + i2 + Separators.RPAREN), strF3, new UA2() { // from class: ir.nasim.Fl0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C4993Hl0.h((C9588aD2) obj));
                }
            }));
        }
        List<C3808Cl0> list3 = list2;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
        for (final C3808Cl0 c3808Cl0 : list3) {
            C9588aD2 c9588aD24 = (C9588aD2) map.get(Long.valueOf(c3808Cl0.d()));
            if (c9588aD24 == null) {
                c5227Il0 = null;
            } else {
                long jD = c3808Cl0.d();
                String strF4 = c9588aD24.f();
                String strC = c3808Cl0.c();
                if (strC == null) {
                    strC = "Bucket " + c3808Cl0.d();
                }
                c5227Il0 = new C5227Il0(jD, strC, XY6.v(Separators.LPAREN + c3808Cl0.e() + Separators.RPAREN), strF4, new UA2() { // from class: ir.nasim.Gl0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C4993Hl0.i(c3808Cl0, (C9588aD2) obj));
                    }
                });
            }
            arrayList2.add(c5227Il0);
        }
        return AbstractC15401jX0.R0(arrayList, AbstractC15401jX0.n0(arrayList2));
    }
}
