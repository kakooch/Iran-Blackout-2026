package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class CU0 {
    public static final CU0 a = new CU0();
    private static final String b = AbstractC15401jX0.A0(AbstractC10360bX0.p('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
    private static final Map c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listP = AbstractC10360bX0.p("Boolean", "Z", "Char", TokenNames.C, "Byte", "B", "Short", TokenNames.S, "Int", TokenNames.I, "Float", TokenNames.F, "Long", "J", "Double", "D");
        int i = 0;
        int iC = AbstractC16234kv5.c(0, listP.size() - 1, 2);
        if (iC >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = b;
                sb.append(str);
                sb.append('/');
                sb.append((String) listP.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), listP.get(i4));
                linkedHashMap.put(str + '/' + ((String) listP.get(i2)) + "Array", AbstractC13042fc3.q("[", listP.get(i4)));
                if (i2 == iC) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        linkedHashMap.put(AbstractC13042fc3.q(b, "/Unit"), TokenNames.V);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : AbstractC10360bX0.p("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, AbstractC13042fc3.q("java/lang/", str2));
        }
        for (String str3 : AbstractC10360bX0.p("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, AbstractC13042fc3.q("collections/", str3), AbstractC13042fc3.q("java/util/", str3));
            a(linkedHashMap, AbstractC13042fc3.q("collections/Mutable", str3), AbstractC13042fc3.q("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String strQ = AbstractC13042fc3.q("Function", Integer.valueOf(i));
            StringBuilder sb2 = new StringBuilder();
            String str4 = b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i);
            a(linkedHashMap, strQ, sb2.toString());
            a(linkedHashMap, AbstractC13042fc3.q("reflect/KFunction", Integer.valueOf(i)), AbstractC13042fc3.q(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            } else {
                i = i5;
            }
        }
        for (String str5 : AbstractC10360bX0.p("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, AbstractC13042fc3.q(str5, ".Companion"), b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        c = linkedHashMap;
    }

    private CU0() {
    }

    private static final void a(Map map, String str, String str2) {
        map.put(b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String str) {
        AbstractC13042fc3.i(str, "classId");
        String str2 = (String) c.get(str);
        if (str2 != null) {
            return str2;
        }
        return 'L' + AbstractC20153rZ6.L(str, '.', '$', false, 4, null) + ';';
    }
}
