package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.hd0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC14258hd0 {
    private final AbstractC20556sC7 a;

    /* renamed from: ir.nasim.hd0$a */
    public static final class a extends AbstractC14258hd0 {
        private final int b;
        private final AbstractC20556sC7 c;
        private final byte[] d;
        private final int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, AbstractC20556sC7 abstractC20556sC7, byte[] bArr, int i2) {
            super(abstractC20556sC7, null);
            AbstractC13042fc3.i(abstractC20556sC7, "update");
            AbstractC13042fc3.i(bArr, "state");
            this.b = i;
            this.c = abstractC20556sC7;
            this.d = bArr;
            this.e = i2;
        }

        public final int a() {
            return this.e;
        }

        public final int b() {
            return this.b;
        }

        public final byte[] c() {
            return this.d;
        }

        public AbstractC20556sC7 d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "LocalSequenceUpdate(seq=" + this.b + ", update=" + this.c + ", state=" + Arrays.toString(this.d) + ", routeId=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.hd0$b */
    public static final class b extends AbstractC14258hd0 {
        private final AbstractC20556sC7 b;
        private final long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC20556sC7 abstractC20556sC7, long j) {
            super(abstractC20556sC7, null);
            AbstractC13042fc3.i(abstractC20556sC7, "update");
            this.b = abstractC20556sC7;
            this.c = j;
        }

        public final long a() {
            return this.c;
        }

        public AbstractC20556sC7 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "WeakUpdate(update=" + this.b + ", date=" + this.c + Separators.RPAREN;
        }
    }

    public /* synthetic */ AbstractC14258hd0(AbstractC20556sC7 abstractC20556sC7, ED1 ed1) {
        this(abstractC20556sC7);
    }

    private AbstractC14258hd0(AbstractC20556sC7 abstractC20556sC7) {
        this.a = abstractC20556sC7;
    }
}
