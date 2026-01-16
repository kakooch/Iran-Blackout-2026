package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import ir.nasim.CV7;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.hk1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14329hk1 {
    private AbstractC14329hk1() {
    }

    public abstract Spannable a();

    public abstract String b();

    public abstract List c();

    public /* synthetic */ AbstractC14329hk1(ED1 ed1) {
        this();
    }

    /* renamed from: ir.nasim.hk1$a */
    public static final class a extends AbstractC14329hk1 {
        private final byte[] a;
        private final String b;
        private final String c;
        private final Spannable d;
        private final boolean e;
        private final String f;
        private final List g;

        public /* synthetic */ a(byte[] bArr, String str, String str2, Spannable spannable, boolean z, String str3, List list, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : bArr, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) == 0 ? spannable : null, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? AbstractC10360bX0.m() : list);
        }

        @Override // ir.nasim.AbstractC14329hk1
        public Spannable a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public String b() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public List c() {
            return this.g;
        }

        public final String d() {
            return this.b;
        }

        public String e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f) && AbstractC13042fc3.d(this.g, aVar.g);
        }

        public final boolean f() {
            return this.e;
        }

        public final byte[] g() {
            return this.a;
        }

        public int hashCode() {
            byte[] bArr = this.a;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.b;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
            Spannable spannable = this.d;
            return ((((((iHashCode2 + (spannable != null ? spannable.hashCode() : 0)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public String toString() {
            String string = Arrays.toString(this.a);
            String str = this.b;
            String str2 = this.c;
            Spannable spannable = this.d;
            return "Gif(thumbnail=" + string + ", fileDescription=" + str + ", senderName=" + str2 + ", caption=" + ((Object) spannable) + ", showControllerButton=" + this.e + ", returningTransitionName=" + this.f + ", toolbarItems=" + this.g + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(byte[] bArr, String str, String str2, Spannable spannable, boolean z, String str3, List list) {
            super(null);
            AbstractC13042fc3.i(str2, "senderName");
            AbstractC13042fc3.i(str3, "returningTransitionName");
            AbstractC13042fc3.i(list, "toolbarItems");
            this.a = bArr;
            this.b = str;
            this.c = str2;
            this.d = spannable;
            this.e = z;
            this.f = str3;
            this.g = list;
        }
    }

    /* renamed from: ir.nasim.hk1$b */
    public static final class b extends AbstractC14329hk1 {
        private final byte[] a;
        private final String b;
        private final String c;
        private final Spannable d;
        private final boolean e;
        private final String f;
        private final List g;

        public /* synthetic */ b(byte[] bArr, String str, String str2, Spannable spannable, boolean z, String str3, List list, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : bArr, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) == 0 ? spannable : null, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? AbstractC10360bX0.m() : list);
        }

        @Override // ir.nasim.AbstractC14329hk1
        public Spannable a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public String b() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public List c() {
            return this.g;
        }

        public final String d() {
            return this.b;
        }

        public String e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && this.e == bVar.e && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g);
        }

        public final boolean f() {
            return this.e;
        }

        public final byte[] g() {
            return this.a;
        }

        public int hashCode() {
            byte[] bArr = this.a;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.b;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
            Spannable spannable = this.d;
            return ((((((iHashCode2 + (spannable != null ? spannable.hashCode() : 0)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public String toString() {
            String string = Arrays.toString(this.a);
            String str = this.b;
            String str2 = this.c;
            Spannable spannable = this.d;
            return "Image(thumbnail=" + string + ", fileDescription=" + str + ", senderName=" + str2 + ", caption=" + ((Object) spannable) + ", showControllerButton=" + this.e + ", returningTransitionName=" + this.f + ", toolbarItems=" + this.g + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(byte[] bArr, String str, String str2, Spannable spannable, boolean z, String str3, List list) {
            super(null);
            AbstractC13042fc3.i(str2, "senderName");
            AbstractC13042fc3.i(str3, "returningTransitionName");
            AbstractC13042fc3.i(list, "toolbarItems");
            this.a = bArr;
            this.b = str;
            this.c = str2;
            this.d = spannable;
            this.e = z;
            this.f = str3;
            this.g = list;
        }
    }

    /* renamed from: ir.nasim.hk1$c */
    public static final class c extends AbstractC14329hk1 {
        private final InterfaceC17266mg5 a;
        private final String b;
        private final Spannable c;
        private final boolean d;
        private final C12372eV7 e;
        private final String f;
        private final C8792Xi5 g;
        private final EnumC9274Zf5 h;
        private final List i;
        private final CV7 j;

        public /* synthetic */ c(InterfaceC17266mg5 interfaceC17266mg5, String str, Spannable spannable, boolean z, C12372eV7 c12372eV7, String str2, C8792Xi5 c8792Xi5, EnumC9274Zf5 enumC9274Zf5, List list, CV7 cv7, int i, ED1 ed1) {
            this(interfaceC17266mg5, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : spannable, (i & 8) != 0 ? false : z, (i & 16) != 0 ? C12372eV7.e : c12372eV7, (i & 32) == 0 ? str2 : "", (i & 64) != 0 ? new C8792Xi5(false, false, 0L, 0L, null, 31, null) : c8792Xi5, (i & 128) != 0 ? EnumC9274Zf5.c.a() : enumC9274Zf5, (i & 256) != 0 ? AbstractC10360bX0.m() : list, (i & 512) != 0 ? CV7.a.a : cv7);
        }

        @Override // ir.nasim.AbstractC14329hk1
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public String b() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC14329hk1
        public List c() {
            return this.i;
        }

        public final EnumC9274Zf5 d() {
            return this.h;
        }

        public final InterfaceC17266mg5 e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && this.d == cVar.d && AbstractC13042fc3.d(this.e, cVar.e) && AbstractC13042fc3.d(this.f, cVar.f) && AbstractC13042fc3.d(this.g, cVar.g) && this.h == cVar.h && AbstractC13042fc3.d(this.i, cVar.i) && AbstractC13042fc3.d(this.j, cVar.j);
        }

        public final C8792Xi5 f() {
            return this.g;
        }

        public String g() {
            return this.f;
        }

        public final boolean h() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Spannable spannable = this.c;
            return ((((((((((((((iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }

        public final CV7 i() {
            return this.j;
        }

        public final C12372eV7 j() {
            return this.e;
        }

        public String toString() {
            InterfaceC17266mg5 interfaceC17266mg5 = this.a;
            String str = this.b;
            Spannable spannable = this.c;
            return "Video(playerState=" + interfaceC17266mg5 + ", senderName=" + str + ", caption=" + ((Object) spannable) + ", showControllerButton=" + this.d + ", videoSize=" + this.e + ", returningTransitionName=" + this.f + ", positionState=" + this.g + ", playbackSpeed=" + this.h + ", toolbarItems=" + this.i + ", thumbnailState=" + this.j + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC17266mg5 interfaceC17266mg5, String str, Spannable spannable, boolean z, C12372eV7 c12372eV7, String str2, C8792Xi5 c8792Xi5, EnumC9274Zf5 enumC9274Zf5, List list, CV7 cv7) {
            super(null);
            AbstractC13042fc3.i(interfaceC17266mg5, "playerState");
            AbstractC13042fc3.i(str, "senderName");
            AbstractC13042fc3.i(c12372eV7, "videoSize");
            AbstractC13042fc3.i(str2, "returningTransitionName");
            AbstractC13042fc3.i(c8792Xi5, "positionState");
            AbstractC13042fc3.i(enumC9274Zf5, "playbackSpeed");
            AbstractC13042fc3.i(list, "toolbarItems");
            AbstractC13042fc3.i(cv7, "thumbnailState");
            this.a = interfaceC17266mg5;
            this.b = str;
            this.c = spannable;
            this.d = z;
            this.e = c12372eV7;
            this.f = str2;
            this.g = c8792Xi5;
            this.h = enumC9274Zf5;
            this.i = list;
            this.j = cv7;
        }
    }
}
