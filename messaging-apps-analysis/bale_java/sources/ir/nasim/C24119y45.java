package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.y45, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24119y45 {
    public static final a q = new a(null);
    public static final int r = 8;
    private boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;

    /* renamed from: ir.nasim.y45$a */
    public static final class a {
        private a() {
        }

        public final C24119y45 a() {
            return new C24119y45(true, true, true, true, false, false, true, true, true, true, true, true, false, true, false, false, 53296, null);
        }

        public final C24119y45 b() {
            return new C24119y45(true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 65534, null);
        }

        public final C24119y45 c() {
            return new C24119y45(true, true, true, true, false, false, true, true, true, true, true, true, false, false, false, false, 61488, null);
        }

        public final C24119y45 d() {
            return new C24119y45(true, true, true, true, true, true, true, true, true, false, true, true, false, false, true, true, 12800, null);
        }

        public final C24119y45 e() {
            return new C24119y45(true, true, false, true, true, false, true, true, true, false, true, true, false, false, true, true, 12836, null);
        }

        public final C24119y45 f() {
            return new C24119y45(true, false, false, true, false, false, true, true, true, false, true, true, false, false, true, true, 12854, null);
        }

        public final C24119y45 g() {
            return new C24119y45(true, true, false, true, true, false, true, true, true, false, true, true, false, false, true, true, 12836, null);
        }

        public final C24119y45 h() {
            return new C24119y45(true, false, false, false, true, false, false, true, true, false, true, true, false, false, false, false, 62062, null);
        }

        public final C24119y45 i() {
            return new C24119y45(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 65535, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.y45$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC3698By7.values().length];
            try {
                iArr[EnumC3698By7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC3698By7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC3698By7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC3698By7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC3698By7.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC3698By7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC3698By7.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC3698By7.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC3698By7.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC3698By7.j.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC3698By7.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC3698By7.l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC3698By7.m.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC3698By7.n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC3698By7.o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EnumC3698By7.p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            a = iArr;
        }
    }

    public C24119y45() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 65535, null);
    }

    public final boolean a(C24119y45 c24119y45) {
        AbstractC13042fc3.i(c24119y45, "permissions");
        return c24119y45.g == this.g && c24119y45.d == this.d && c24119y45.k == this.k && c24119y45.e == this.e && c24119y45.h == this.h && c24119y45.l == this.l && c24119y45.o == this.o && c24119y45.p == this.p;
    }

    public final boolean b() {
        return this.f;
    }

    public final boolean c() {
        return this.n;
    }

    public final DA d() {
        return new DA(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, Boolean.valueOf(this.k), Boolean.valueOf(this.l), Boolean.valueOf(this.m), null, null, Boolean.valueOf(this.o), null, null, Boolean.valueOf(this.n), Boolean.valueOf(this.p));
    }

    public final boolean e() {
        return this.p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24119y45)) {
            return false;
        }
        C24119y45 c24119y45 = (C24119y45) obj;
        return this.a == c24119y45.a && this.b == c24119y45.b && this.c == c24119y45.c && this.d == c24119y45.d && this.e == c24119y45.e && this.f == c24119y45.f && this.g == c24119y45.g && this.h == c24119y45.h && this.i == c24119y45.i && this.j == c24119y45.j && this.k == c24119y45.k && this.l == c24119y45.l && this.m == c24119y45.m && this.n == c24119y45.n && this.o == c24119y45.o && this.p == c24119y45.p;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.b;
    }

    public final boolean h() {
        return this.j;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + Boolean.hashCode(this.n)) * 31) + Boolean.hashCode(this.o)) * 31) + Boolean.hashCode(this.p);
    }

    public final boolean i() {
        return this.e;
    }

    public final boolean j() {
        return this.c;
    }

    public final boolean k() {
        return this.d;
    }

    public final boolean l() {
        return this.m;
    }

    public final boolean m() {
        return this.i;
    }

    public final boolean n() {
        return this.a;
    }

    public final boolean o() {
        return this.l;
    }

    public final boolean p() {
        return this.k;
    }

    public final boolean q() {
        return this.h;
    }

    public final boolean r() {
        return this.o;
    }

    public final boolean s(EnumC3698By7 enumC3698By7) {
        AbstractC13042fc3.i(enumC3698By7, "typePermission");
        switch (b.a[enumC3698By7.ordinal()]) {
            case 1:
                return this.a;
            case 2:
                return this.b;
            case 3:
                return this.c;
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
            case 7:
                return this.g;
            case 8:
                return this.h;
            case 9:
                return this.i;
            case 10:
                return this.j;
            case 11:
                return this.k;
            case 12:
                return this.l;
            case 13:
                return this.m;
            case 14:
                return this.n;
            case 15:
                return this.o;
            case 16:
                return this.p;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String toString() {
        return "Permissions(seeMessage=" + this.a + ", deleteMessage=" + this.b + ", kickUser=" + this.c + ", pinMessage=" + this.d + ", inviteUser=" + this.e + ", addAdmin=" + this.f + ", changeInfo=" + this.g + ", sendMessage=" + this.h + ", seeMembers=" + this.i + ", editMessage=" + this.j + ", sendMedia=" + this.k + ", sendGifStickers=" + this.l + ", replyToStory=" + this.m + ", addStory=" + this.n + ", startCall=" + this.o + ", callManagement=" + this.p + Separators.RPAREN;
    }

    public C24119y45(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
        this.i = z9;
        this.j = z10;
        this.k = z11;
        this.l = z12;
        this.m = z13;
        this.n = z14;
        this.o = z15;
        this.p = z16;
    }

    public /* synthetic */ C24119y45(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7, (i & 128) != 0 ? false : z8, (i & 256) != 0 ? false : z9, (i & 512) != 0 ? false : z10, (i & 1024) != 0 ? false : z11, (i & 2048) != 0 ? false : z12, (i & 4096) != 0 ? false : z13, (i & 8192) != 0 ? false : z14, (i & 16384) != 0 ? false : z15, (i & 32768) != 0 ? false : z16);
    }
}
