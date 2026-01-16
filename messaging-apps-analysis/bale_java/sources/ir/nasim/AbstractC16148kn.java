package ir.nasim;

import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.kn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16148kn {
    public static final void a(C13766gn c13766gn, SparseArray sparseArray) {
        if (c13766gn.b().a().isEmpty()) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            AutofillValue autofillValueA = AbstractC14359hn.a(sparseArray.get(iKeyAt));
            C13582gU c13582gU = C13582gU.a;
            if (c13582gU.e(autofillValueA)) {
                c13766gn.b().b(iKeyAt, c13582gU.B(autofillValueA).toString());
            } else {
                if (c13582gU.c(autofillValueA)) {
                    throw new C22420vC4("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (c13582gU.d(autofillValueA)) {
                    throw new C22420vC4("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (c13582gU.f(autofillValueA)) {
                    throw new C22420vC4("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    public static final void b(C13766gn c13766gn, ViewStructure viewStructure) {
        if (c13766gn.b().a().isEmpty()) {
            return;
        }
        C13582gU c13582gU = C13582gU.a;
        int iA = c13582gU.a(viewStructure, c13766gn.b().a().size());
        Iterator it = c13766gn.b().a().entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int iIntValue = ((Number) entry.getKey()).intValue();
            AbstractC18350oW3.a(entry.getValue());
            ViewStructure viewStructureG = c13582gU.g(viewStructure, iA);
            c13582gU.i(viewStructureG, c13766gn.c(), iIntValue);
            c13582gU.v(viewStructureG, iIntValue, c13766gn.d().getContext().getPackageName(), null, null);
            c13582gU.j(viewStructureG, AbstractC22733vk1.b(InterfaceC22143uk1.a.a()));
            throw null;
        }
    }
}
