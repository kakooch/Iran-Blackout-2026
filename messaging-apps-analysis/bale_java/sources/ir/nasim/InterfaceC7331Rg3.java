package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.Rg3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC7331Rg3 {

    /* renamed from: ir.nasim.Rg3$a */
    public static final class a implements InterfaceC7331Rg3 {
        private final long a;
        private final long b;
        private final int c;
        private final FileReference d;
        private final InterfaceC10258bL6 e;
        private final Bitmap f;

        public a(long j, long j2, int i, FileReference fileReference, InterfaceC10258bL6 interfaceC10258bL6, Bitmap bitmap) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(interfaceC10258bL6, "downloadState");
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = fileReference;
            this.e = interfaceC10258bL6;
            this.f = bitmap;
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public int a() {
            return this.c;
        }

        public final InterfaceC10258bL6 b() {
            return this.e;
        }

        public Bitmap c() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f);
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public long h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Bitmap bitmap = this.f;
            return iHashCode + (bitmap == null ? 0 : bitmap.hashCode());
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public long i() {
            return this.b;
        }

        public String toString() {
            return "PhotoContent(date=" + this.a + ", rid=" + this.b + ", peerId=" + this.c + ", fileReference=" + this.d + ", downloadState=" + this.e + ", fastThumb=" + this.f + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Rg3$b */
    public static final class b implements InterfaceC7331Rg3 {
        private final long a;
        private final long b;
        private final int c;
        private final int d;
        private final FileReference e;
        private final InterfaceC10258bL6 f;
        private final Bitmap g;

        public b(long j, long j2, int i, int i2, FileReference fileReference, InterfaceC10258bL6 interfaceC10258bL6, Bitmap bitmap) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = i2;
            this.e = fileReference;
            this.f = interfaceC10258bL6;
            this.g = bitmap;
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public int a() {
            return this.c;
        }

        public final InterfaceC10258bL6 b() {
            return this.f;
        }

        public final int c() {
            return this.d;
        }

        public Bitmap d() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g);
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public long h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
            InterfaceC10258bL6 interfaceC10258bL6 = this.f;
            int iHashCode2 = (iHashCode + (interfaceC10258bL6 == null ? 0 : interfaceC10258bL6.hashCode())) * 31;
            Bitmap bitmap = this.g;
            return iHashCode2 + (bitmap != null ? bitmap.hashCode() : 0);
        }

        @Override // ir.nasim.InterfaceC7331Rg3
        public long i() {
            return this.b;
        }

        public String toString() {
            return "VideoContent(date=" + this.a + ", rid=" + this.b + ", peerId=" + this.c + ", duration=" + this.d + ", fileReference=" + this.e + ", downloadState=" + this.f + ", fastThumb=" + this.g + Separators.RPAREN;
        }
    }

    int a();

    long h();

    long i();
}
