package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.l7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16345l7 {

    /* renamed from: ir.nasim.l7$a */
    public static final class a extends AbstractC16345l7 {
        private final FileReference a;
        private InterfaceC24823zG1 b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final long g;
        private final int h;
        private final int i;
        private final String j;
        private InterfaceC24823zG1 k;

        public /* synthetic */ a(FileReference fileReference, InterfaceC24823zG1 interfaceC24823zG1, String str, String str2, String str3, String str4, long j, int i, int i2, String str5, InterfaceC24823zG1 interfaceC24823zG12, int i3, ED1 ed1) {
            this(fileReference, (i3 & 2) != 0 ? null : interfaceC24823zG1, str, str2, str3, str4, j, i, i2, str5, (i3 & 1024) != 0 ? null : interfaceC24823zG12);
        }

        public final InterfaceC24823zG1 a() {
            return this.k;
        }

        public final String b() {
            return this.d;
        }

        public final String c() {
            return this.f;
        }

        public final InterfaceC24823zG1 d() {
            return this.b;
        }

        public final FileReference e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f) && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && AbstractC13042fc3.d(this.j, aVar.j) && AbstractC13042fc3.d(this.k, aVar.k);
        }

        public final String f() {
            return this.e;
        }

        public final String g() {
            return this.j;
        }

        public final int h() {
            return this.h;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            InterfaceC24823zG1 interfaceC24823zG1 = this.b;
            int iHashCode2 = (((((((((((((((((iHashCode + (interfaceC24823zG1 == null ? 0 : interfaceC24823zG1.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31;
            InterfaceC24823zG1 interfaceC24823zG12 = this.k;
            return iHashCode2 + (interfaceC24823zG12 != null ? interfaceC24823zG12.hashCode() : 0);
        }

        public final int i() {
            return this.i;
        }

        public final String j() {
            return this.c;
        }

        public final void k(InterfaceC24823zG1 interfaceC24823zG1) {
            this.k = interfaceC24823zG1;
        }

        public final void l(InterfaceC24823zG1 interfaceC24823zG1) {
            this.b = interfaceC24823zG1;
        }

        public String toString() {
            return "BaleCustomAd(imageFileReference=" + this.a + ", imageDrawable=" + this.b + ", title=" + this.c + ", description=" + this.d + ", link=" + this.e + ", id=" + this.f + ", accessHash=" + this.g + ", tag1=" + this.h + ", tag2=" + this.i + ", linkTitle=" + this.j + ", action=" + this.k + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FileReference fileReference, InterfaceC24823zG1 interfaceC24823zG1, String str, String str2, String str3, String str4, long j, int i, int i2, String str5, InterfaceC24823zG1 interfaceC24823zG12) {
            super(null);
            AbstractC13042fc3.i(fileReference, "imageFileReference");
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(str3, "link");
            AbstractC13042fc3.i(str4, "id");
            AbstractC13042fc3.i(str5, "linkTitle");
            this.a = fileReference;
            this.b = interfaceC24823zG1;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = j;
            this.h = i;
            this.i = i2;
            this.j = str5;
            this.k = interfaceC24823zG12;
        }
    }

    /* renamed from: ir.nasim.l7$b */
    public static final class b extends AbstractC16345l7 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 771688909;
        }

        public String toString() {
            return "NoAd";
        }
    }

    private AbstractC16345l7() {
    }

    public /* synthetic */ AbstractC16345l7(ED1 ed1) {
        this();
    }
}
