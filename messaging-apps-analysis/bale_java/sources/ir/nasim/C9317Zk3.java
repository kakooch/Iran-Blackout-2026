package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.IZ6;
import java.util.Arrays;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Zk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9317Zk3 {
    private Object[] a = new Object[8];
    private int[] b;
    private int c;

    /* renamed from: ir.nasim.Zk3$a */
    private static final class a {
        public static final a a = new a();

        private a() {
        }
    }

    public C9317Zk3() {
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        this.b = iArr;
        this.c = -1;
    }

    private final void e() {
        int i = this.c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.a, i);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        this.a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.b, i);
        AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
        this.b = iArrCopyOf;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i = this.c + 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = this.a[i2];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!AbstractC13042fc3.d(serialDescriptor.f(), IZ6.b.a)) {
                    int i3 = this.b[i2];
                    if (i3 >= 0) {
                        sb.append(Separators.DOT);
                        sb.append(serialDescriptor.e(i3));
                    }
                } else if (this.b[i2] != -1) {
                    sb.append("[");
                    sb.append(this.b[i2]);
                    sb.append("]");
                }
            } else if (obj != a.a) {
                sb.append("[");
                sb.append(Separators.QUOTE);
                sb.append(obj);
                sb.append(Separators.QUOTE);
                sb.append("]");
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final void b() {
        int i = this.c;
        int[] iArr = this.b;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            this.c = i - 1;
        }
        int i2 = this.c;
        if (i2 != -1) {
            this.c = i2 - 1;
        }
    }

    public final void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "sd");
        int i = this.c + 1;
        this.c = i;
        if (i == this.a.length) {
            e();
        }
        this.a[i] = serialDescriptor;
    }

    public final void d() {
        int[] iArr = this.b;
        int i = this.c;
        if (iArr[i] == -2) {
            this.a[i] = a.a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.b;
        int i = this.c;
        if (iArr[i] != -2) {
            int i2 = i + 1;
            this.c = i2;
            if (i2 == this.a.length) {
                e();
            }
        }
        Object[] objArr = this.a;
        int i3 = this.c;
        objArr[i3] = obj;
        this.b[i3] = -2;
    }

    public final void g(int i) {
        this.b[this.c] = i;
    }

    public String toString() {
        return a();
    }
}
