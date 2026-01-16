package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* loaded from: classes8.dex */
public abstract class CV7 {

    public static final class a extends CV7 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1486571338;
        }

        public String toString() {
            return "Hidden";
        }
    }

    public static final class b extends CV7 {
        private final byte[] a;
        private final C15539jl1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(byte[] bArr, C15539jl1 c15539jl1) {
            super(null);
            AbstractC13042fc3.i(c15539jl1, "contentSize");
            this.a = bArr;
            this.b = c15539jl1;
        }

        public final C15539jl1 a() {
            return this.b;
        }

        public final byte[] b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!AbstractC13042fc3.d(b.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.videoplayer.ui.model.VideoThumbnailState.Visible");
            return this.a == ((b) obj).a;
        }

        public int hashCode() {
            byte[] bArr = this.a;
            if (bArr != null) {
                return Arrays.hashCode(bArr);
            }
            return 0;
        }

        public String toString() {
            byte[] bArr = this.a;
            return "Visible(thumbnailSize=" + (bArr != null ? Integer.valueOf(bArr.length) : null) + Separators.RPAREN;
        }
    }

    private CV7() {
    }

    public /* synthetic */ CV7(ED1 ed1) {
        this();
    }
}
