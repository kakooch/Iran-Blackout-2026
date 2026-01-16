package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Modifier;
import okhttp3.HttpUrl;

/* loaded from: classes8.dex */
class OY6 {
    static OY6 j;
    static OY6 k;
    static OY6 l;
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    boolean f = true;
    boolean g = true;
    boolean h = true;
    int i;

    static {
        OY6 oy6 = new OY6();
        j = oy6;
        oy6.a = true;
        oy6.b = false;
        oy6.c = false;
        oy6.d = false;
        oy6.e = true;
        oy6.f = false;
        oy6.g = false;
        oy6.i = 0;
        OY6 oy62 = new OY6();
        k = oy62;
        oy62.a = true;
        oy62.b = true;
        oy62.c = false;
        oy62.d = false;
        oy62.e = false;
        j.i = 1;
        OY6 oy63 = new OY6();
        l = oy63;
        oy63.a = false;
        oy63.b = true;
        oy63.c = false;
        oy63.d = true;
        oy63.e = false;
        oy63.h = false;
        oy63.i = 2;
    }

    OY6() {
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (this.b) {
            stringBuffer.append(Separators.LPAREN);
            c(stringBuffer, clsArr);
            stringBuffer.append(Separators.RPAREN);
        } else if (clsArr.length == 0) {
            stringBuffer.append("()");
        } else {
            stringBuffer.append("(..)");
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        c(stringBuffer, clsArr);
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(g(clsArr[i]));
        }
    }

    String d(String str) {
        int iLastIndexOf = str.lastIndexOf(45);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    String e(int i) {
        if (!this.d) {
            return "";
        }
        String string = Modifier.toString(i);
        if (string.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(Separators.SP);
        return stringBuffer.toString();
    }

    public String f(Class cls, String str) {
        return h(cls, str, this.e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.a);
    }

    String h(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            return z ? i(str).replace('$', '.') : str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h(componentType, componentType.getName(), z));
        stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return stringBuffer.toString();
    }

    String i(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }
}
