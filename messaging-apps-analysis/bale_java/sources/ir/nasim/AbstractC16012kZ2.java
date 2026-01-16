package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.G15;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.kZ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16012kZ2 {

    /* renamed from: ir.nasim.kZ2$a */
    static class a {
        private int a;
        private int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* renamed from: ir.nasim.kZ2$b */
    public static class b {
        private String a;
        private boolean b;

        b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    static List a(String str) {
        ArrayList arrayList = new ArrayList();
        RU3 ru3A = G15.a.a(str);
        int iStart = 0;
        int i = 0;
        int i2 = 0;
        while (iStart < str.length() && ru3A.d() && ru3A.c() > 0) {
            String strE = ru3A.e();
            iStart = iStart + ru3A.start() + strE.indexOf(Separators.GREATER_THAN) + 1;
            if (strE.startsWith("</")) {
                if (i == 1) {
                    arrayList.add(new a(i2, iStart - 7));
                }
                i--;
            } else {
                if (i == 0) {
                    i2 = iStart;
                }
                i++;
            }
            ru3A = G15.a.a(str.substring(iStart));
        }
        return arrayList;
    }

    public static List b(String str) {
        ArrayList arrayList = new ArrayList();
        List listA = a(str);
        if (listA.isEmpty()) {
            arrayList.add(new b(str, true));
            return arrayList;
        }
        int size = listA.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) listA.get(i2);
            arrayList.add(new b(str.substring(i, aVar.a), true));
            i = aVar.b;
            arrayList.add(new b(str.substring(aVar.a, i), false));
        }
        arrayList.add(new b(str.substring(((a) listA.get(size - 1)).b), true));
        return arrayList;
    }
}
