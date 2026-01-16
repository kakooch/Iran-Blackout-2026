package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.kZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16016kZ6 extends AbstractC15425jZ6 {

    /* renamed from: ir.nasim.kZ6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            AbstractC13042fc3.i(str, "line");
            return str;
        }
    }

    /* renamed from: ir.nasim.kZ6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.e = str;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            AbstractC13042fc3.i(str, "line");
            return this.e + str;
        }
    }

    private static final UA2 c(String str) {
        return str.length() == 0 ? a.e : new b(str);
    }

    private static final int d(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!AbstractC10868cL0.d(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String e(String str, String str2) {
        String str3;
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "newIndent");
        List listU0 = AbstractC20762sZ6.u0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listU0) {
            if (!AbstractC20762sZ6.n0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(d((String) it.next())));
        }
        Integer num = (Integer) AbstractC15401jX0.K0(arrayList2);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listU0.size());
        UA2 ua2C = c(str2);
        int iO = AbstractC10360bX0.o(listU0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listU0) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == iO) && AbstractC20762sZ6.n0(str4)) {
                str4 = null;
            } else {
                String strQ1 = AbstractC22039uZ6.q1(str4, iIntValue);
                if (strQ1 != null && (str3 = (String) ua2C.invoke(strQ1)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        String string = ((StringBuilder) AbstractC15401jX0.x0(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : Separators.RETURN, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static final String f(String str, String str2, String str3) {
        int i;
        String str4;
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "newIndent");
        AbstractC13042fc3.i(str3, "marginPrefix");
        if (!(!AbstractC20762sZ6.n0(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List listU0 = AbstractC20762sZ6.u0(str);
        int length = str.length() + (str2.length() * listU0.size());
        UA2 ua2C = c(str2);
        int iO = AbstractC10360bX0.o(listU0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listU0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            String str5 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iO) && AbstractC20762sZ6.n0(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!AbstractC10868cL0.d(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (AbstractC20153rZ6.R(str5, str3, i, false, 4, null)) {
                        int length3 = i5 + str3.length();
                        AbstractC13042fc3.g(str5, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str5.substring(length3);
                        AbstractC13042fc3.h(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (str4 = (String) ua2C.invoke(strSubstring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) AbstractC15401jX0.x0(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : Separators.RETURN, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static String g(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return e(str, "");
    }

    public static final String h(String str, String str2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "marginPrefix");
        return f(str, "", str2);
    }

    public static /* synthetic */ String i(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return h(str, str2);
    }
}
