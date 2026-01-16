package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.my6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC17445my6 {
    public static final b a = b.a;

    /* renamed from: ir.nasim.my6$b */
    public static final class b {
        static final /* synthetic */ b a = new b();
        private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ny6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return InterfaceC17445my6.b.d();
            }
        });

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC24602yt4 d() {
            return (InterfaceC24602yt4) C92.a(C5721Ko.a.d(), InterfaceC24602yt4.class);
        }

        public final void b(InterfaceC17445my6 interfaceC17445my6) {
            AbstractC13042fc3.i(interfaceC17445my6, "<this>");
            c().J0().c(interfaceC17445my6.b());
        }

        protected final InterfaceC24602yt4 c() {
            return (InterfaceC24602yt4) b.getValue();
        }

        public final void e(InterfaceC17445my6 interfaceC17445my6) {
            AbstractC13042fc3.i(interfaceC17445my6, "<this>");
            C10249bK6.b(c().t(), interfaceC17445my6.b(), null, false, 6, null);
        }
    }

    boolean a();

    FileReference b();

    void c(boolean z);

    TY1 d();

    void e(TY1 ty1);

    int f();

    C18823pJ2 getContent();

    long h();

    /* renamed from: ir.nasim.my6$a */
    public static final class a implements InterfaceC17445my6 {
        private String b;
        private FileReference c;
        private int d;
        private final long e;
        private String f;
        private C18823pJ2 g;
        private TY1 h;
        private boolean i;

        public a(String str, FileReference fileReference, int i, long j, String str2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(c18823pJ2, "content");
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = j;
            this.f = str2;
            this.g = c18823pJ2;
            this.h = ty1;
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public boolean a() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public FileReference b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void c(boolean z) {
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public TY1 d() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void e(TY1 ty1) {
            this.h = ty1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f) && AbstractC13042fc3.d(this.g, aVar.g) && AbstractC13042fc3.d(this.h, aVar.h) && this.i == aVar.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public int f() {
            return this.d;
        }

        public final String g() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public C18823pJ2 getContent() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public long h() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = ((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31;
            String str = this.f;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            TY1 ty1 = this.h;
            return ((iHashCode2 + (ty1 != null ? ty1.hashCode() : 0)) * 31) + Boolean.hashCode(this.i);
        }

        public String i() {
            return this.b;
        }

        public String toString() {
            return "Audio(name=" + this.b + ", fileReference=" + this.c + ", size=" + this.d + ", date=" + this.e + ", artist=" + this.f + ", content=" + this.g + ", downloadState=" + this.h + ", isSelected=" + this.i + Separators.RPAREN;
        }

        public /* synthetic */ a(String str, FileReference fileReference, int i, long j, String str2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z, int i2, ED1 ed1) {
            this(str, fileReference, i, j, str2, c18823pJ2, (i2 & 64) != 0 ? null : ty1, (i2 & 128) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.my6$c */
    public static final class c implements InterfaceC17445my6 {
        private final String b;
        private final FileReference c;
        private final int d;
        private final long e;
        private final String f;
        private final C18823pJ2 g;
        private TY1 h;
        private boolean i;

        public c(String str, FileReference fileReference, int i, long j, String str2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(str2, "ext");
            AbstractC13042fc3.i(c18823pJ2, "content");
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = j;
            this.f = str2;
            this.g = c18823pJ2;
            this.h = ty1;
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public boolean a() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public FileReference b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void c(boolean z) {
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public TY1 d() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void e(TY1 ty1) {
            this.h = ty1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f) && AbstractC13042fc3.d(this.g, cVar.g) && AbstractC13042fc3.d(this.h, cVar.h) && this.i == cVar.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public int f() {
            return this.d;
        }

        public final String g() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public C18823pJ2 getContent() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public long h() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            TY1 ty1 = this.h;
            return ((iHashCode + (ty1 == null ? 0 : ty1.hashCode())) * 31) + Boolean.hashCode(this.i);
        }

        public String i() {
            return this.b;
        }

        public String toString() {
            return "File(name=" + this.b + ", fileReference=" + this.c + ", size=" + this.d + ", date=" + this.e + ", ext=" + this.f + ", content=" + this.g + ", downloadState=" + this.h + ", isSelected=" + this.i + Separators.RPAREN;
        }

        public /* synthetic */ c(String str, FileReference fileReference, int i, long j, String str2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z, int i2, ED1 ed1) {
            this(str, fileReference, i, j, str2, c18823pJ2, (i2 & 64) != 0 ? null : ty1, (i2 & 128) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.my6$d */
    public static final class d implements InterfaceC17445my6 {
        private final String b;
        private final FileReference c;
        private final int d;
        private final C18823pJ2 e;
        private final long f;
        private final Bitmap g;
        private TY1 h;
        private boolean i;

        public d(String str, FileReference fileReference, int i, C18823pJ2 c18823pJ2, long j, Bitmap bitmap, TY1 ty1, boolean z) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(c18823pJ2, "content");
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = c18823pJ2;
            this.f = j;
            this.g = bitmap;
            this.h = ty1;
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public boolean a() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public FileReference b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void c(boolean z) {
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public TY1 d() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void e(TY1 ty1) {
            this.h = ty1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c) && this.d == dVar.d && AbstractC13042fc3.d(this.e, dVar.e) && this.f == dVar.f && AbstractC13042fc3.d(this.g, dVar.g) && AbstractC13042fc3.d(this.h, dVar.h) && this.i == dVar.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public int f() {
            return this.d;
        }

        public final Bitmap g() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public C18823pJ2 getContent() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public long h() {
            return this.f;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31;
            Bitmap bitmap = this.g;
            int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
            TY1 ty1 = this.h;
            return ((iHashCode2 + (ty1 != null ? ty1.hashCode() : 0)) * 31) + Boolean.hashCode(this.i);
        }

        public String toString() {
            return "Photo(name=" + this.b + ", fileReference=" + this.c + ", size=" + this.d + ", content=" + this.e + ", date=" + this.f + ", thumbnail=" + this.g + ", downloadState=" + this.h + ", isSelected=" + this.i + Separators.RPAREN;
        }

        public /* synthetic */ d(String str, FileReference fileReference, int i, C18823pJ2 c18823pJ2, long j, Bitmap bitmap, TY1 ty1, boolean z, int i2, ED1 ed1) {
            this(str, fileReference, i, c18823pJ2, j, bitmap, (i2 & 64) != 0 ? null : ty1, (i2 & 128) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.my6$f */
    public static final class f implements InterfaceC17445my6 {
        private String b;
        private FileReference c;
        private int d;
        private final long e;
        private int f;
        private C18823pJ2 g;
        private TY1 h;
        private boolean i;

        public f(String str, FileReference fileReference, int i, long j, int i2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(c18823pJ2, "content");
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = j;
            this.f = i2;
            this.g = c18823pJ2;
            this.h = ty1;
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public boolean a() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public FileReference b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void c(boolean z) {
            this.i = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public TY1 d() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void e(TY1 ty1) {
            this.h = ty1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.b, fVar.b) && AbstractC13042fc3.d(this.c, fVar.c) && this.d == fVar.d && this.e == fVar.e && this.f == fVar.f && AbstractC13042fc3.d(this.g, fVar.g) && AbstractC13042fc3.d(this.h, fVar.h) && this.i == fVar.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public int f() {
            return this.d;
        }

        public final int g() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public C18823pJ2 getContent() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public long h() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
            TY1 ty1 = this.h;
            return ((iHashCode + (ty1 == null ? 0 : ty1.hashCode())) * 31) + Boolean.hashCode(this.i);
        }

        public String i() {
            return this.b;
        }

        public String toString() {
            return "Voice(name=" + this.b + ", fileReference=" + this.c + ", size=" + this.d + ", date=" + this.e + ", duration=" + this.f + ", content=" + this.g + ", downloadState=" + this.h + ", isSelected=" + this.i + Separators.RPAREN;
        }

        public /* synthetic */ f(String str, FileReference fileReference, int i, long j, int i2, C18823pJ2 c18823pJ2, TY1 ty1, boolean z, int i3, ED1 ed1) {
            this(str, fileReference, i, j, i2, c18823pJ2, (i3 & 64) != 0 ? null : ty1, (i3 & 128) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.my6$e */
    public static final class e implements InterfaceC17445my6 {
        private final String b;
        private final FileReference c;
        private final int d;
        private final long e;
        private final String f;
        private final Bitmap g;
        private final C18823pJ2 h;
        private TY1 i;
        private boolean j;

        public e(String str, FileReference fileReference, int i, long j, String str2, Bitmap bitmap, C18823pJ2 c18823pJ2, TY1 ty1, boolean z) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(str2, "duration");
            AbstractC13042fc3.i(c18823pJ2, "content");
            this.b = str;
            this.c = fileReference;
            this.d = i;
            this.e = j;
            this.f = str2;
            this.g = bitmap;
            this.h = c18823pJ2;
            this.i = ty1;
            this.j = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public boolean a() {
            return this.j;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public FileReference b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void c(boolean z) {
            this.j = z;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public TY1 d() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public void e(TY1 ty1) {
            this.i = ty1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && this.d == eVar.d && this.e == eVar.e && AbstractC13042fc3.d(this.f, eVar.f) && AbstractC13042fc3.d(this.g, eVar.g) && AbstractC13042fc3.d(this.h, eVar.h) && AbstractC13042fc3.d(this.i, eVar.i) && this.j == eVar.j;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public int f() {
            return this.d;
        }

        public final String g() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public C18823pJ2 getContent() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC17445my6
        public long h() {
            return this.e;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
            Bitmap bitmap = this.g;
            int iHashCode2 = (((iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + this.h.hashCode()) * 31;
            TY1 ty1 = this.i;
            return ((iHashCode2 + (ty1 != null ? ty1.hashCode() : 0)) * 31) + Boolean.hashCode(this.j);
        }

        public final Bitmap i() {
            return this.g;
        }

        public String toString() {
            return "Video(name=" + this.b + ", fileReference=" + this.c + ", size=" + this.d + ", date=" + this.e + ", duration=" + this.f + ", thumbnail=" + this.g + ", content=" + this.h + ", downloadState=" + this.i + ", isSelected=" + this.j + Separators.RPAREN;
        }

        public /* synthetic */ e(String str, FileReference fileReference, int i, long j, String str2, Bitmap bitmap, C18823pJ2 c18823pJ2, TY1 ty1, boolean z, int i2, ED1 ed1) {
            this(str, fileReference, i, j, str2, bitmap, c18823pJ2, (i2 & 128) != 0 ? null : ty1, (i2 & 256) != 0 ? false : z);
        }
    }
}
