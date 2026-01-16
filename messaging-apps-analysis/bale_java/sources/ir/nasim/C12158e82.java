package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import livekit.LivekitModels$VideoLayer;
import livekit.org.webrtc.RtpParameters;

/* renamed from: ir.nasim.e82, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12158e82 {
    public static final C12158e82 a = new C12158e82();
    private static final String[] b = {"q", "h", "f"};
    private static final List c = AbstractC10360bX0.p(EnumC4444Fd6.c, EnumC4444Fd6.e, EnumC4444Fd6.f, EnumC4444Fd6.h, EnumC4444Fd6.i);
    private static final List d;
    private static final List e;
    private static final List f;
    private static final List g;

    /* renamed from: ir.nasim.e82$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12833fF3.values().length];
            try {
                iArr[EnumC12833fF3.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12833fF3.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC12833fF3.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        EnumC17154mU7 enumC17154mU7 = EnumC17154mU7.c;
        EnumC17154mU7 enumC17154mU72 = EnumC17154mU7.d;
        EnumC17154mU7 enumC17154mU73 = EnumC17154mU7.e;
        EnumC17154mU7 enumC17154mU74 = EnumC17154mU7.f;
        d = AbstractC10360bX0.p(enumC17154mU7, enumC17154mU72, enumC17154mU73, enumC17154mU74, EnumC17154mU7.g, EnumC17154mU7.h, EnumC17154mU7.i, EnumC17154mU7.j, EnumC17154mU7.k);
        EnumC17745nU7 enumC17745nU7 = EnumC17745nU7.c;
        EnumC17745nU7 enumC17745nU72 = EnumC17745nU7.d;
        EnumC17745nU7 enumC17745nU73 = EnumC17745nU7.e;
        EnumC17745nU7 enumC17745nU74 = EnumC17745nU7.f;
        e = AbstractC10360bX0.p(enumC17745nU7, enumC17745nU72, enumC17745nU73, enumC17745nU74, EnumC17745nU7.g, EnumC17745nU7.h, EnumC17745nU7.i, EnumC17745nU7.j, EnumC17745nU7.k);
        f = AbstractC10360bX0.p(enumC17154mU72, enumC17154mU74);
        g = AbstractC10360bX0.p(enumC17745nU72, enumC17745nU74);
    }

    private C12158e82() {
    }

    public final List a(int i, int i2, C9737aT7 c9737aT7) {
        AbstractC13042fc3.i(c9737aT7, "originalEncoding");
        List<XV4> listE = AbstractC9766aX0.e(AbstractC4616Fw7.a(2, 3));
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE, 10));
        for (XV4 xv4 : listE) {
            int iIntValue = ((Number) xv4.a()).intValue();
            int iIntValue2 = ((Number) xv4.b()).intValue();
            arrayList.add(new C5804Kx1(new AS7(i / iIntValue, i2 / iIntValue, iIntValue2, false), new C9737aT7(c9737aT7.c() / (AbstractC20723sV3.d((float) Math.pow(iIntValue, 2)) * (c9737aT7.d() / iIntValue2)), iIntValue2)));
        }
        return arrayList;
    }

    public final List b(boolean z, int i, int i2) {
        if (z) {
            return c;
        }
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        return Math.abs(fMax - 1.7777778f) < Math.abs(fMax - 1.3333334f) ? d : e;
    }

    public final List c(boolean z, int i, int i2, C9737aT7 c9737aT7) {
        AbstractC13042fc3.i(c9737aT7, "originalEncoding");
        if (z) {
            return a(i, i2, c9737aT7);
        }
        float fMax = Math.max(i, i2) / Math.min(i, i2);
        return Math.abs(fMax - 1.7777778f) < Math.abs(fMax - 1.3333334f) ? f : g;
    }

    public final C9737aT7 d(boolean z, int i, int i2) {
        Object next;
        List listB = b(z, i, i2);
        int iMax = Math.max(i, i2);
        Iterator it = listB.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InterfaceC18336oU7) next).a().d() >= iMax) {
                break;
            }
        }
        InterfaceC18336oU7 interfaceC18336oU7 = (InterfaceC18336oU7) next;
        if (interfaceC18336oU7 == null) {
            interfaceC18336oU7 = (InterfaceC18336oU7) AbstractC15401jX0.C0(listB);
        }
        return interfaceC18336oU7.j();
    }

    public final String[] e() {
        return b;
    }

    public final String f(EnumC12833fF3 enumC12833fF3) {
        AbstractC13042fc3.i(enumC12833fF3, "quality");
        int i = a.a[enumC12833fF3.ordinal()];
        if (i == 1) {
            return "f";
        }
        if (i == 2) {
            return "h";
        }
        if (i != 3) {
            return null;
        }
        return "q";
    }

    public final List g(int i, int i2, List list, boolean z) {
        ArrayList arrayList;
        int iIntValue;
        AbstractC13042fc3.i(list, "encodings");
        if (list.isEmpty()) {
            LivekitModels$VideoLayer.a aVarNewBuilder = LivekitModels$VideoLayer.newBuilder();
            aVarNewBuilder.E(i);
            aVarNewBuilder.B(i2);
            aVarNewBuilder.C(EnumC12833fF3.HIGH);
            aVarNewBuilder.A(0);
            aVarNewBuilder.D(0);
            return AbstractC9766aX0.e(aVarNewBuilder.a());
        }
        if (z) {
            String str = ((RtpParameters.Encoding) AbstractC15401jX0.q0(list)).scalabilityMode;
            AbstractC13042fc3.f(str);
            C13663gc6 c13663gc6A = C13663gc6.Companion.a(str);
            Integer num = ((RtpParameters.Encoding) AbstractC15401jX0.q0(list)).maxBitrateBps;
            if (num == null) {
                num = 0;
            }
            int iIntValue2 = num.intValue();
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, c13663gc6A.b());
            arrayList = new ArrayList(AbstractC10976cX0.x(c24411ya3Y, 10));
            Iterator it = c24411ya3Y.iterator();
            while (it.hasNext()) {
                int iB = ((AbstractC18386oa3) it).b();
                LivekitModels$VideoLayer.a aVarNewBuilder2 = LivekitModels$VideoLayer.newBuilder();
                double d2 = 2.0f;
                double d3 = iB;
                aVarNewBuilder2.E(AbstractC20723sV3.d((float) Math.ceil(i / ((float) Math.pow(d2, d3)))));
                aVarNewBuilder2.B(AbstractC20723sV3.d((float) Math.ceil(i2 / ((float) Math.pow(d2, d3)))));
                aVarNewBuilder2.C(EnumC12833fF3.j(EnumC12833fF3.HIGH.getNumber() - iB));
                aVarNewBuilder2.A(AbstractC20723sV3.d((float) Math.ceil(iIntValue2 / ((float) Math.pow(3.0f, d3)))));
                aVarNewBuilder2.D(0);
                arrayList.add((LivekitModels$VideoLayer) aVarNewBuilder2.a());
            }
        } else {
            List<RtpParameters.Encoding> list2 = list;
            arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (RtpParameters.Encoding encoding : list2) {
                Double dValueOf = encoding.scaleResolutionDownBy;
                if (dValueOf == null) {
                    dValueOf = Double.valueOf(1.0d);
                }
                AbstractC13042fc3.f(dValueOf);
                double dDoubleValue = dValueOf.doubleValue();
                C12158e82 c12158e82 = a;
                String str2 = encoding.rid;
                if (str2 == null) {
                    str2 = "";
                }
                AbstractC13042fc3.f(str2);
                EnumC12833fF3 enumC12833fF3H = c12158e82.h(str2);
                if (enumC12833fF3H == EnumC12833fF3.UNRECOGNIZED && list.size() == 1) {
                    enumC12833fF3H = EnumC12833fF3.HIGH;
                }
                LivekitModels$VideoLayer.a aVarNewBuilder3 = LivekitModels$VideoLayer.newBuilder();
                aVarNewBuilder3.E((int) (i / dDoubleValue));
                aVarNewBuilder3.B((int) (i2 / dDoubleValue));
                aVarNewBuilder3.C(enumC12833fF3H);
                Integer num2 = encoding.maxBitrateBps;
                if (num2 == null) {
                    iIntValue = 0;
                } else {
                    AbstractC13042fc3.f(num2);
                    iIntValue = num2.intValue();
                }
                aVarNewBuilder3.A(iIntValue);
                aVarNewBuilder3.D(0);
                arrayList.add((LivekitModels$VideoLayer) aVarNewBuilder3.a());
            }
        }
        return arrayList;
    }

    public final EnumC12833fF3 h(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_RID);
        int iHashCode = str.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode == 113 && str.equals("q")) {
                    return EnumC12833fF3.LOW;
                }
            } else if (str.equals("h")) {
                return EnumC12833fF3.MEDIUM;
            }
        } else if (str.equals("f")) {
            return EnumC12833fF3.HIGH;
        }
        return EnumC12833fF3.UNRECOGNIZED;
    }
}
