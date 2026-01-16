package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class RY6 {
    public static List a(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        ArrayList arrayList = new ArrayList();
        for (int iIndexOf = lowerCase.indexOf(lowerCase2); iIndexOf >= 0; iIndexOf = lowerCase.indexOf(lowerCase2, iIndexOf + 1)) {
            arrayList.add(new QY6(iIndexOf, lowerCase2.length()));
        }
        return arrayList;
    }
}
