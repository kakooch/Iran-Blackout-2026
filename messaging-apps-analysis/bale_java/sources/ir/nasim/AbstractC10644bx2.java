package ir.nasim;

/* renamed from: ir.nasim.bx2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10644bx2 {

    /* renamed from: ir.nasim.bx2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ZK6.valuesCustom().length];
            iArr[ZK6.BEGINNING.ordinal()] = 1;
            iArr[ZK6.AFTER_DOT.ordinal()] = 2;
            iArr[ZK6.MIDDLE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final boolean a(C9424Zw2 c9424Zw2, C9424Zw2 c9424Zw22) {
        AbstractC13042fc3.i(c9424Zw2, "<this>");
        AbstractC13042fc3.i(c9424Zw22, "packageName");
        if (AbstractC13042fc3.d(c9424Zw2, c9424Zw22) || c9424Zw22.d()) {
            return true;
        }
        String strB = c9424Zw2.b();
        AbstractC13042fc3.h(strB, "this.asString()");
        String strB2 = c9424Zw22.b();
        AbstractC13042fc3.h(strB2, "packageName.asString()");
        return b(strB, strB2);
    }

    private static final boolean b(String str, String str2) {
        return AbstractC20153rZ6.S(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean c(String str) {
        if (str == null) {
            return false;
        }
        ZK6 zk6 = ZK6.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            int i2 = a.a[zk6.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
                zk6 = ZK6.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (cCharAt == '.') {
                zk6 = ZK6.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
        }
        return zk6 != ZK6.AFTER_DOT;
    }

    public static final C9424Zw2 d(C9424Zw2 c9424Zw2, C9424Zw2 c9424Zw22) {
        AbstractC13042fc3.i(c9424Zw2, "<this>");
        AbstractC13042fc3.i(c9424Zw22, "prefix");
        if (!a(c9424Zw2, c9424Zw22) || c9424Zw22.d()) {
            return c9424Zw2;
        }
        if (AbstractC13042fc3.d(c9424Zw2, c9424Zw22)) {
            C9424Zw2 c9424Zw23 = C9424Zw2.c;
            AbstractC13042fc3.h(c9424Zw23, "ROOT");
            return c9424Zw23;
        }
        String strB = c9424Zw2.b();
        AbstractC13042fc3.h(strB, "asString()");
        String strSubstring = strB.substring(c9424Zw22.b().length() + 1);
        AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return new C9424Zw2(strSubstring);
    }
}
