package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C5680Kj3;
import ir.nasim.InterfaceC5446Jj3;
import java.util.Hashtable;
import java.util.StringTokenizer;

/* renamed from: ir.nasim.rf2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20224rf2 {
    static Hashtable e;
    private static Object[] f;
    static /* synthetic */ Class g;
    Class a;
    ClassLoader b;
    String c;
    int d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        e = hashtable;
        hashtable.put("void", Void.TYPE);
        e.put("boolean", Boolean.TYPE);
        e.put("byte", Byte.TYPE);
        e.put("char", Character.TYPE);
        e.put("short", Short.TYPE);
        e.put("int", Integer.TYPE);
        e.put("long", Long.TYPE);
        e.put("float", Float.TYPE);
        e.put("double", Double.TYPE);
        f = new Object[0];
    }

    public C20224rf2(String str, Class cls) {
        this.c = str;
        this.a = cls;
        this.b = cls.getClassLoader();
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    static Class b(String str, ClassLoader classLoader) {
        if (str.equals(Separators.STAR)) {
            return null;
        }
        Class cls = (Class) e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return classLoader == null ? Class.forName(str) : Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = g;
            if (cls2 != null) {
                return cls2;
            }
            Class clsA = a("java.lang.ClassNotFoundException");
            g = clsA;
            return clsA;
        }
    }

    public static InterfaceC5446Jj3 c(InterfaceC5446Jj3.a aVar, Object obj, Object obj2) {
        return new C5680Kj3(aVar, obj, obj2, f);
    }

    public static InterfaceC5446Jj3 d(InterfaceC5446Jj3.a aVar, Object obj, Object obj2, Object obj3) {
        return new C5680Kj3(aVar, obj, obj2, new Object[]{obj3});
    }

    public InterfaceC5870Le4 e(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws NumberFormatException {
        int i = Integer.parseInt(str, 16);
        Class clsB = b(str3, this.b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = b(stringTokenizer.nextToken(), this.b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int iCountTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[iCountTokens2];
        for (int i3 = 0; i3 < iCountTokens2; i3++) {
            strArr[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int iCountTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[iCountTokens3];
        for (int i4 = 0; i4 < iCountTokens3; i4++) {
            clsArr2[i4] = b(stringTokenizer3.nextToken(), this.b);
        }
        return new C6342Ne4(i, str2, clsB, clsArr, strArr, clsArr2, b(str7, this.b));
    }

    public InterfaceC5446Jj3.a f(String str, InterfaceC16991mC6 interfaceC16991mC6, int i) {
        int i2 = this.d;
        this.d = i2 + 1;
        return new C5680Kj3.a(i2, str, interfaceC16991mC6, g(i, -1));
    }

    public SH6 g(int i, int i2) {
        return new UH6(this.a, this.c, i);
    }
}
