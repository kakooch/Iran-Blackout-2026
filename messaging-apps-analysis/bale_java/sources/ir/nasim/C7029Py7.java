package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Py7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7029Py7 {
    private final List a;

    public C7029Py7(C12644ex5 c12644ex5) {
        AbstractC13042fc3.i(c12644ex5, "typeTable");
        List listD = c12644ex5.D();
        if (c12644ex5.E()) {
            int iY = c12644ex5.y();
            List listD2 = c12644ex5.D();
            AbstractC13042fc3.h(listD2, "typeTable.typeList");
            List list = listD2;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                C10647bx5 c10647bx5N = (C10647bx5) obj;
                if (i >= iY) {
                    c10647bx5N = c10647bx5N.toBuilder().D(true).a();
                }
                arrayList.add(c10647bx5N);
                i = i2;
            }
            listD = arrayList;
        }
        AbstractC13042fc3.h(listD, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.a = listD;
    }

    public final C10647bx5 a(int i) {
        return (C10647bx5) this.a.get(i);
    }
}
