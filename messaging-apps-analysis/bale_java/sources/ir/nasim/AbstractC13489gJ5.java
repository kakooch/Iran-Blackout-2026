package ir.nasim;

import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.gJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13489gJ5 {

    /* renamed from: ir.nasim.gJ5$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((C12871fJ5) obj2).r()), Integer.valueOf(((C12871fJ5) obj).r()));
        }
    }

    public static final List a(List list, int i) {
        AbstractC13042fc3.i(list, "<this>");
        List listA1 = AbstractC15401jX0.a1(list, new a());
        return listA1.size() > i ? AbstractC15401jX0.Y0(listA1, new C24411ya3(0, i)) : listA1;
    }
}
