package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MW7 {

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(LW7 lw7) {
            return Boolean.TRUE;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparable invoke(LW7 lw7) {
            return lw7.d();
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparable invoke(LW7 lw7) {
            return Integer.valueOf(lw7.f());
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparable invoke(LW7 lw7) {
            return Integer.valueOf(lw7.a().size());
        }
    }

    private static final List a(List list, UA2 ua2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LW7 lw7 = (LW7) it.next();
            List<LW7> listA = a(lw7.c(), ua2);
            ArrayList arrayList2 = new ArrayList();
            for (LW7 lw72 : listA) {
                AbstractC13610gX0.D(arrayList2, lw72.g() == null ? lw72.c() : AbstractC9766aX0.e(lw72));
            }
            AbstractC13610gX0.D(arrayList, ((Boolean) ua2.invoke(lw7)).booleanValue() ? AbstractC9766aX0.e(new LW7(lw7.d(), lw7.f(), lw7.b(), lw7.g(), arrayList2, lw7.e())) : AbstractC9766aX0.e(new LW7("<root>", -1, C25005za3.e.a(), null, arrayList2, null)));
        }
        return arrayList;
    }

    public static final String b(List list, int i, UA2 ua2) {
        String strI = AbstractC20153rZ6.I(Separators.DOT, i);
        StringBuilder sb = new StringBuilder();
        for (LW7 lw7 : AbstractC15401jX0.a1(a(list, ua2), AbstractC18050o01.b(b.e, c.e, d.e))) {
            if (lw7.g() != null) {
                sb.append(strI + '|' + lw7.d() + ':' + lw7.f());
                AbstractC13042fc3.h(sb, "append(...)");
                sb.append('\n');
                AbstractC13042fc3.h(sb, "append(...)");
            } else {
                sb.append(strI + "|<root>");
                AbstractC13042fc3.h(sb, "append(...)");
                sb.append('\n');
                AbstractC13042fc3.h(sb, "append(...)");
            }
            String string = AbstractC20762sZ6.n1(b(lw7.c(), i + 1, ua2)).toString();
            if (string.length() > 0) {
                sb.append(string);
                AbstractC13042fc3.h(sb, "append(...)");
                sb.append('\n');
                AbstractC13042fc3.h(sb, "append(...)");
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(List list, int i, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            ua2 = a.e;
        }
        return b(list, i, ua2);
    }
}
