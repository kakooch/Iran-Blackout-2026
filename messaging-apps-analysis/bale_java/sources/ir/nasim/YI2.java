package ir.nasim;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes2.dex */
public class YI2 implements InterfaceC14373ho3 {
    private final SU2 b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public YI2(URL url) {
        this(url, SU2.b);
    }

    private byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(InterfaceC14373ho3.a);
        }
        return this.g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.e)) {
            String string = this.d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) AbstractC3322Aj5.d(this.c)).toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private URL g() {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.d;
        return str != null ? str : ((URL) AbstractC3322Aj5.d(this.c)).toString();
    }

    public Map e() {
        return this.b.a();
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (!(obj instanceof YI2)) {
            return false;
        }
        YI2 yi2 = (YI2) obj;
        return c().equals(yi2.c()) && this.b.equals(yi2.b);
    }

    public URL h() {
        return g();
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        if (this.h == 0) {
            int iHashCode = c().hashCode();
            this.h = iHashCode;
            this.h = (iHashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }

    public YI2(String str) {
        this(str, SU2.b);
    }

    public YI2(URL url, SU2 su2) {
        this.c = (URL) AbstractC3322Aj5.d(url);
        this.d = null;
        this.b = (SU2) AbstractC3322Aj5.d(su2);
    }

    public YI2(String str, SU2 su2) {
        this.c = null;
        this.d = AbstractC3322Aj5.b(str);
        this.b = (SU2) AbstractC3322Aj5.d(su2);
    }
}
