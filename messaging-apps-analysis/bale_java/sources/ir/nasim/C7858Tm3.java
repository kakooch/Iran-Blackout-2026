package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Tm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7858Tm3 {
    public static final a c = new a(null);
    public static final C7858Tm3 d = new C7858Tm3(null, null);
    private final EnumC8326Vm3 a;
    private final InterfaceC5941Lm3 b;

    /* renamed from: ir.nasim.Tm3$a */
    public static final class a {
        private a() {
        }

        public final C7858Tm3 a(InterfaceC5941Lm3 interfaceC5941Lm3) {
            AbstractC13042fc3.i(interfaceC5941Lm3, "type");
            return new C7858Tm3(EnumC8326Vm3.b, interfaceC5941Lm3);
        }

        public final C7858Tm3 b(InterfaceC5941Lm3 interfaceC5941Lm3) {
            AbstractC13042fc3.i(interfaceC5941Lm3, "type");
            return new C7858Tm3(EnumC8326Vm3.c, interfaceC5941Lm3);
        }

        public final C7858Tm3 c() {
            return C7858Tm3.d;
        }

        public final C7858Tm3 d(InterfaceC5941Lm3 interfaceC5941Lm3) {
            AbstractC13042fc3.i(interfaceC5941Lm3, "type");
            return new C7858Tm3(EnumC8326Vm3.a, interfaceC5941Lm3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Tm3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8326Vm3.values().length];
            try {
                iArr[EnumC8326Vm3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8326Vm3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8326Vm3.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C7858Tm3(EnumC8326Vm3 enumC8326Vm3, InterfaceC5941Lm3 interfaceC5941Lm3) {
        String str;
        this.a = enumC8326Vm3;
        this.b = interfaceC5941Lm3;
        if ((enumC8326Vm3 == null) == (interfaceC5941Lm3 == null)) {
            return;
        }
        if (enumC8326Vm3 == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + enumC8326Vm3 + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final EnumC8326Vm3 a() {
        return this.a;
    }

    public final InterfaceC5941Lm3 b() {
        return this.b;
    }

    public final InterfaceC5941Lm3 c() {
        return this.b;
    }

    public final EnumC8326Vm3 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7858Tm3)) {
            return false;
        }
        C7858Tm3 c7858Tm3 = (C7858Tm3) obj;
        return this.a == c7858Tm3.a && AbstractC13042fc3.d(this.b, c7858Tm3.b);
    }

    public int hashCode() {
        EnumC8326Vm3 enumC8326Vm3 = this.a;
        int iHashCode = (enumC8326Vm3 == null ? 0 : enumC8326Vm3.hashCode()) * 31;
        InterfaceC5941Lm3 interfaceC5941Lm3 = this.b;
        return iHashCode + (interfaceC5941Lm3 != null ? interfaceC5941Lm3.hashCode() : 0);
    }

    public String toString() {
        EnumC8326Vm3 enumC8326Vm3 = this.a;
        int i = enumC8326Vm3 == null ? -1 : b.a[enumC8326Vm3.ordinal()];
        if (i == -1) {
            return Separators.STAR;
        }
        if (i == 1) {
            return String.valueOf(this.b);
        }
        if (i == 2) {
            return "in " + this.b;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.b;
    }
}
