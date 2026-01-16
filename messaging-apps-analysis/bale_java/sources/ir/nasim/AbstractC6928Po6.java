package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Po6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC6928Po6 {
    public static /* synthetic */ String a(Object[] objArr, Class cls, String str) {
        String[] strArrSplit = str.length() == 0 ? new String[0] : str.split(Separators.SEMICOLON);
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName());
        sb.append("[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append(Separators.EQUALS);
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
