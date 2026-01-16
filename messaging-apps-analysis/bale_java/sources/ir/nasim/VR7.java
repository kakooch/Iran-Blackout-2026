package ir.nasim;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class VR7 implements Comparable {
    public static final b f = new b(null);
    private static final VR7 g = new VR7(0, 0, 0, "");
    private static final VR7 h = new VR7(0, 1, 0, "");
    private static final VR7 i;
    private static final VR7 j;
    private final int a;
    private final int b;
    private final int c;
    private final String d;
    private final InterfaceC9173Yu3 e;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BigInteger invoke() {
            return BigInteger.valueOf(VR7.this.j()).shiftLeft(32).or(BigInteger.valueOf(VR7.this.o())).shiftLeft(32).or(BigInteger.valueOf(VR7.this.p()));
        }
    }

    public static final class b {
        private b() {
        }

        public final VR7 a() {
            return VR7.h;
        }

        public final VR7 b(String str) {
            if (str == null || AbstractC20762sZ6.n0(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String strGroup = matcher.group(1);
            Integer numValueOf = strGroup == null ? null : Integer.valueOf(Integer.parseInt(strGroup));
            if (numValueOf == null) {
                return null;
            }
            int iIntValue = numValueOf.intValue();
            String strGroup2 = matcher.group(2);
            Integer numValueOf2 = strGroup2 == null ? null : Integer.valueOf(Integer.parseInt(strGroup2));
            if (numValueOf2 == null) {
                return null;
            }
            int iIntValue2 = numValueOf2.intValue();
            String strGroup3 = matcher.group(3);
            Integer numValueOf3 = strGroup3 == null ? null : Integer.valueOf(Integer.parseInt(strGroup3));
            if (numValueOf3 == null) {
                return null;
            }
            int iIntValue3 = numValueOf3.intValue();
            String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
            AbstractC13042fc3.h(strGroup4, "description");
            return new VR7(iIntValue, iIntValue2, iIntValue3, strGroup4, null);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static {
        VR7 vr7 = new VR7(1, 0, 0, "");
        i = vr7;
        j = vr7;
    }

    public /* synthetic */ VR7(int i2, int i3, int i4, String str, ED1 ed1) {
        this(i2, i3, i4, str);
    }

    private final BigInteger i() {
        Object value = this.e.getValue();
        AbstractC13042fc3.h(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VR7)) {
            return false;
        }
        VR7 vr7 = (VR7) obj;
        return this.a == vr7.a && this.b == vr7.b && this.c == vr7.c;
    }

    @Override // java.lang.Comparable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(VR7 vr7) {
        AbstractC13042fc3.i(vr7, "other");
        return i().compareTo(vr7.i());
    }

    public int hashCode() {
        return ((((527 + this.a) * 31) + this.b) * 31) + this.c;
    }

    public final int j() {
        return this.a;
    }

    public final int o() {
        return this.b;
    }

    public final int p() {
        return this.c;
    }

    public String toString() {
        return this.a + '.' + this.b + '.' + this.c + (AbstractC20762sZ6.n0(this.d) ^ true ? AbstractC13042fc3.q("-", this.d) : "");
    }

    private VR7(int i2, int i3, int i4, String str) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = str;
        this.e = AbstractC13269fw3.a(new a());
    }
}
