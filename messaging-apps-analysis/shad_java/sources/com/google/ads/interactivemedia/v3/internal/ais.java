package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ais extends alb {
    private static final Reader b = new air();
    private static final Object c = new Object();
    private Object[] d;
    private int e;
    private String[] f;
    private int[] g;

    public ais(agj agjVar) {
        super(b);
        this.d = new Object[32];
        this.e = 0;
        this.f = new String[32];
        this.g = new int[32];
        w(agjVar);
    }

    private final Object u() {
        return this.d[this.e - 1];
    }

    private final Object v() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private final void w(Object obj) {
        int i = this.e;
        Object[] objArr = this.d;
        if (i == objArr.length) {
            int i2 = i + i;
            Object[] objArr2 = new Object[i2];
            int[] iArr = new int[i2];
            String[] strArr = new String[i2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.g, 0, iArr, 0, this.e);
            System.arraycopy(this.f, 0, strArr, 0, this.e);
            this.d = objArr2;
            this.g = iArr;
            this.f = strArr;
        }
        Object[] objArr3 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        objArr3[i3] = obj;
    }

    private final String x() {
        return " at path " + o();
    }

    private final void y(int i) throws IOException {
        if (p() == i) {
            return;
        }
        throw new IllegalStateException("Expected " + ((Object) alc.a(i)) + " but was " + ((Object) alc.a(p())) + x());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void a() throws IOException {
        y(1);
        w(((agh) u()).iterator());
        this.g[this.e - 1] = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void b() throws IOException {
        y(2);
        v();
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void c() throws IOException {
        y(3);
        w(((agm) u()).b().iterator());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.d = new Object[]{c};
        this.e = 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void d() throws IOException {
        y(4);
        v();
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final boolean e() throws IOException {
        int iP = p();
        return (iP == 4 || iP == 2) ? false : true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final String f() throws IOException {
        y(5);
        Map.Entry entry = (Map.Entry) ((Iterator) u()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        w(entry.getValue());
        return str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final String g() throws IOException {
        int iP = p();
        if (iP == 6 || iP == 7) {
            String strH = ((ago) v()).h();
            int i = this.e;
            if (i > 0) {
                int[] iArr = this.g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strH;
        }
        throw new IllegalStateException("Expected " + ((Object) "STRING") + " but was " + ((Object) alc.a(iP)) + x());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final boolean h() throws IOException {
        y(8);
        boolean zD = ((ago) v()).d();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zD;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void i() throws IOException {
        y(9);
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final double j() throws IOException {
        int iP = p();
        if (iP != 7 && iP != 6) {
            throw new IllegalStateException("Expected " + ((Object) "NUMBER") + " but was " + ((Object) alc.a(iP)) + x());
        }
        ago agoVar = (ago) u();
        double dDoubleValue = agoVar.e() ? agoVar.f().doubleValue() : Double.parseDouble(agoVar.h());
        if (!r() && (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dDoubleValue);
        }
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dDoubleValue;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final long k() throws IOException {
        int iP = p();
        if (iP != 7 && iP != 6) {
            throw new IllegalStateException("Expected " + ((Object) "NUMBER") + " but was " + ((Object) alc.a(iP)) + x());
        }
        ago agoVar = (ago) u();
        long jLongValue = agoVar.e() ? agoVar.f().longValue() : Long.parseLong(agoVar.h());
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jLongValue;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final int l() throws IOException {
        int iP = p();
        if (iP != 7 && iP != 6) {
            throw new IllegalStateException("Expected " + ((Object) "NUMBER") + " but was " + ((Object) alc.a(iP)) + x());
        }
        ago agoVar = (ago) u();
        int iIntValue = agoVar.e() ? agoVar.f().intValue() : Integer.parseInt(agoVar.h());
        v();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iIntValue;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final void m() throws IOException {
        if (p() == 5) {
            f();
            this.f[this.e - 2] = "null";
        } else {
            v();
            int i = this.e;
            if (i > 0) {
                this.f[i - 1] = "null";
            }
        }
        int i2 = this.e;
        if (i2 > 0) {
            int[] iArr = this.g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void n() throws IOException {
        y(5);
        Map.Entry entry = (Map.Entry) ((Iterator) u()).next();
        w(entry.getValue());
        w(new ago((String) entry.getKey()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final String o() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.e) {
            Object[] objArr = this.d;
            Object obj = objArr[i];
            if (obj instanceof agh) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.g[i]);
                    sb.append(']');
                }
            } else if (obj instanceof agm) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String str = this.f[i];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final int p() throws IOException {
        if (this.e == 0) {
            return 10;
        }
        Object objU = u();
        if (objU instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof agm;
            Iterator it = (Iterator) objU;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            }
            if (z) {
                return 5;
            }
            w(it.next());
            return p();
        }
        if (objU instanceof agm) {
            return 3;
        }
        if (objU instanceof agh) {
            return 1;
        }
        if (!(objU instanceof ago)) {
            if (objU instanceof agl) {
                return 9;
            }
            if (objU == c) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        ago agoVar = (ago) objU;
        if (agoVar.g()) {
            return 6;
        }
        if (agoVar.b()) {
            return 8;
        }
        if (agoVar.e()) {
            return 7;
        }
        throw new AssertionError();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alb
    public final String toString() {
        return ais.class.getSimpleName();
    }
}
