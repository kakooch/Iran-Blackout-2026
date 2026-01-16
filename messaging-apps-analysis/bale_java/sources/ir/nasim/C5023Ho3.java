package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Ho3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5023Ho3 {
    public static final C5023Ho3 c = new C5023Ho3("COMPOSITION");
    private final List a;
    private InterfaceC5257Io3 b;

    public C5023Ho3(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public C5023Ho3 a(String str) {
        C5023Ho3 c5023Ho3 = new C5023Ho3(this);
        c5023Ho3.a.add(str);
        return c5023Ho3;
    }

    public boolean c(String str, int i) {
        if (i >= this.a.size()) {
            return false;
        }
        boolean z = i == this.a.size() - 1;
        String str2 = (String) this.a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals(Separators.STAR));
        }
        if (!z && ((String) this.a.get(i + 1)).equals(str)) {
            return i == this.a.size() + (-2) || (i == this.a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.a.size() - 1) {
            return false;
        }
        return ((String) this.a.get(i2)).equals(str);
    }

    public InterfaceC5257Io3 d() {
        return this.b;
    }

    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.a.get(i)).equals("**")) {
            return (i != this.a.size() - 1 && ((String) this.a.get(i + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5023Ho3 c5023Ho3 = (C5023Ho3) obj;
        if (!this.a.equals(c5023Ho3.a)) {
            return false;
        }
        InterfaceC5257Io3 interfaceC5257Io3 = this.b;
        InterfaceC5257Io3 interfaceC5257Io32 = c5023Ho3.b;
        return interfaceC5257Io3 != null ? interfaceC5257Io3.equals(interfaceC5257Io32) : interfaceC5257Io32 == null;
    }

    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.a.size()) {
            return false;
        }
        return ((String) this.a.get(i)).equals(str) || ((String) this.a.get(i)).equals("**") || ((String) this.a.get(i)).equals(Separators.STAR);
    }

    public boolean h(String str, int i) {
        return "__container".equals(str) || i < this.a.size() - 1 || ((String) this.a.get(i)).equals("**");
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        InterfaceC5257Io3 interfaceC5257Io3 = this.b;
        return iHashCode + (interfaceC5257Io3 != null ? interfaceC5257Io3.hashCode() : 0);
    }

    public C5023Ho3 i(InterfaceC5257Io3 interfaceC5257Io3) {
        C5023Ho3 c5023Ho3 = new C5023Ho3(this);
        c5023Ho3.b = interfaceC5257Io3;
        return c5023Ho3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    private C5023Ho3(C5023Ho3 c5023Ho3) {
        this.a = new ArrayList(c5023Ho3.a);
        this.b = c5023Ho3.b;
    }
}
