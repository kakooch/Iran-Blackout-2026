package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.qJ4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC19416qJ4 {

    /* renamed from: ir.nasim.qJ4$a */
    public static final class a implements InterfaceC19416qJ4 {
        public static final a a = new a();
        private static final boolean b = false;
        private static final int c = 0;

        private a() {
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public boolean a() {
            return b;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public int b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 594156648;
        }

        public String toString() {
            return "Header";
        }
    }

    /* renamed from: ir.nasim.qJ4$b */
    public static final class b implements InterfaceC19416qJ4 {
        private final String a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final String f;
        private final Long g;
        private final long h;
        private final boolean i;
        private final int j;

        public b(String str, int i, int i2, int i3, int i4, String str2, Long l, long j, boolean z, int i5) {
            AbstractC13042fc3.i(str2, "callLink");
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = str2;
            this.g = l;
            this.h = j;
            this.i = z;
            this.j = i5;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public boolean a() {
            return this.i;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public int b() {
            return this.j;
        }

        public long c() {
            return this.h;
        }

        public final String d() {
            return this.f;
        }

        public final Long e() {
            return this.g;
        }

        public final int f() {
            return this.b;
        }

        public final int g() {
            return this.d;
        }

        public final int h() {
            return this.e;
        }

        public final String i() {
            return this.a;
        }

        public final int j() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.qJ4$c */
    public static final class c implements InterfaceC19416qJ4 {
        private final String a;
        private final Avatar b;
        private final long c;
        private final int d;
        private final boolean e;
        private final int f;
        private final int g;

        public c(String str, Avatar avatar, long j, int i, boolean z, int i2, int i3) {
            AbstractC13042fc3.i(str, "name");
            this.a = str;
            this.b = avatar;
            this.c = j;
            this.d = i;
            this.e = z;
            this.f = i2;
            this.g = i3;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public boolean a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public int b() {
            return this.g;
        }

        public final Avatar c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public final int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g;
        }

        public final String f() {
            return this.a;
        }

        public final int g() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Avatar avatar = this.b;
            return ((((((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
        }

        public String toString() {
            return "OnGoingCall(name=" + this.a + ", avatar=" + this.b + ", callId=" + this.c + ", peerId=" + this.d + ", isCallRunning=" + this.e + ", descriptionRes=" + this.f + ", buttonTextRes=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qJ4$d */
    public static final class d implements InterfaceC19416qJ4 {
        private final String a;
        private final Avatar b;
        private final long c;
        private final boolean d;
        private final int e;
        private final int f;

        public d(String str, Avatar avatar, long j, boolean z, int i, int i2) {
            this.a = str;
            this.b = avatar;
            this.c = j;
            this.d = z;
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public boolean a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC19416qJ4
        public int b() {
            return this.f;
        }

        public final Avatar c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b) && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e && this.f == dVar.f;
        }

        public final String f() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Avatar avatar = this.b;
            return ((((((((iHashCode + (avatar != null ? avatar.hashCode() : 0)) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "OnGoingMultiPeerCall(title=" + this.a + ", avatar=" + this.b + ", callId=" + this.c + ", isCallRunning=" + this.d + ", descriptionRes=" + this.e + ", buttonTextRes=" + this.f + Separators.RPAREN;
        }
    }

    boolean a();

    int b();
}
