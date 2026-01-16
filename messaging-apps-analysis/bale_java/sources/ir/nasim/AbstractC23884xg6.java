package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.Size;

/* renamed from: ir.nasim.xg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23884xg6 implements Comparable {

    /* renamed from: ir.nasim.xg6$a */
    public static final class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Size size, long j, long j2, long j3, int i, String str, String str2, byte[] bArr, InterfaceC18505om2 interfaceC18505om2) {
            super(size, j, j2, j3, i, str, str2, bArr, interfaceC18505om2);
            AbstractC13042fc3.i(size, "size");
            AbstractC13042fc3.i(interfaceC18505om2, "fileSource");
        }

        @Override // ir.nasim.AbstractC23884xg6.c
        public String toString() {
            return "Gif(size=" + t() + ", duration=" + s() + ", rid=" + p() + ", date=" + i() + ", senderId=" + q() + ", caption=" + h() + ", mimeType=" + o() + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.xg6$b */
    public static final class b extends AbstractC23884xg6 {
        private final Size a;
        private final long b;
        private final long c;
        private final int d;
        private final String e;
        private final String f;
        private final byte[] g;
        private final InterfaceC18505om2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Size size, long j, long j2, int i, String str, String str2, byte[] bArr, InterfaceC18505om2 interfaceC18505om2) {
            super(null);
            AbstractC13042fc3.i(size, "size");
            AbstractC13042fc3.i(interfaceC18505om2, "fileSource");
            this.a = size;
            this.b = j;
            this.c = j2;
            this.d = i;
            this.e = str;
            this.f = str2;
            this.g = bArr;
            this.h = interfaceC18505om2;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public String h() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public long i() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public InterfaceC18505om2 j() {
            return this.h;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public String o() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public long p() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public int q() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public byte[] r() {
            return this.g;
        }

        public final Size s() {
            return this.a;
        }

        public String toString() {
            return "Image(size=" + this.a + ", rid=" + p() + ", date=" + i() + ", senderId=" + q() + ", caption=" + h() + ", mimeType=" + o() + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.xg6$c */
    public static class c extends AbstractC23884xg6 {
        private final Size a;
        private final long b;
        private final long c;
        private final long d;
        private final int e;
        private final String f;
        private final String g;
        private final byte[] h;
        private final InterfaceC18505om2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Size size, long j, long j2, long j3, int i, String str, String str2, byte[] bArr, InterfaceC18505om2 interfaceC18505om2) {
            super(null);
            AbstractC13042fc3.i(size, "size");
            AbstractC13042fc3.i(interfaceC18505om2, "fileSource");
            this.a = size;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = i;
            this.f = str;
            this.g = str2;
            this.h = bArr;
            this.i = interfaceC18505om2;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public String h() {
            return this.f;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public long i() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public InterfaceC18505om2 j() {
            return this.i;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public String o() {
            return this.g;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public long p() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public int q() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC23884xg6
        public byte[] r() {
            return this.h;
        }

        public final long s() {
            return this.b;
        }

        public final Size t() {
            return this.a;
        }

        public String toString() {
            return "Video(size=" + this.a + ", duration=" + this.b + ", rid=" + p() + ", date=" + i() + ", senderId=" + q() + ", caption=" + h() + ", mimeType=" + o() + Separators.RPAREN;
        }
    }

    private AbstractC23884xg6() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC23884xg6 abstractC23884xg6) {
        AbstractC13042fc3.i(abstractC23884xg6, "other");
        return AbstractC13042fc3.l(i(), abstractC23884xg6.i());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.data.model.search.SearchMessage");
        AbstractC23884xg6 abstractC23884xg6 = (AbstractC23884xg6) obj;
        return p() == abstractC23884xg6.p() && i() == abstractC23884xg6.i() && q() == abstractC23884xg6.q();
    }

    public abstract String h();

    public int hashCode() {
        return (((Long.hashCode(p()) * 31) + Long.hashCode(i())) * 31) + q();
    }

    public abstract long i();

    public abstract InterfaceC18505om2 j();

    public abstract String o();

    public abstract long p();

    public abstract int q();

    public abstract byte[] r();

    public /* synthetic */ AbstractC23884xg6(ED1 ed1) {
        this();
    }
}
