package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.uw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC22268uw7 {

    /* renamed from: ir.nasim.uw7$a */
    public static final class a {
        public final String a;
        public final int b;
        public final byte[] c;

        public a(String str, int i, byte[] bArr) {
            this.a = str;
            this.b = i;
            this.c = bArr;
        }
    }

    /* renamed from: ir.nasim.uw7$b */
    public static final class b {
        public final int a;
        public final String b;
        public final List c;
        public final byte[] d;

        public b(int i, String str, List list, byte[] bArr) {
            this.a = i;
            this.b = str;
            this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    /* renamed from: ir.nasim.uw7$c */
    public interface c {
        SparseArray a();

        InterfaceC22268uw7 b(int i, b bVar);
    }

    /* renamed from: ir.nasim.uw7$d */
    public static final class d {
        private final String a;
        private final int b;
        private final int c;
        private int d;
        private String e;

        public d(int i, int i2) {
            this(RecyclerView.UNDEFINED_DURATION, i, i2);
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.a + this.d;
        }

        public String b() {
            d();
            return this.e;
        }

        public int c() {
            d();
            return this.d;
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + Separators.SLASH;
            } else {
                str = "";
            }
            this.a = str;
            this.b = i2;
            this.c = i3;
            this.d = RecyclerView.UNDEFINED_DURATION;
            this.e = "";
        }
    }

    void a(EW4 ew4, int i);

    void b();

    void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, d dVar);
}
