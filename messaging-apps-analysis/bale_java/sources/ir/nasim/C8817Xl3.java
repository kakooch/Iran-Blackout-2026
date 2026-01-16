package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC8317Vl3;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C8817Xl3 implements InterfaceC8551Wl3 {
    public static final C8817Xl3 a = new C8817Xl3();

    /* renamed from: ir.nasim.Xl3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4809Gq5.valuesCustom().length];
            iArr[EnumC4809Gq5.BOOLEAN.ordinal()] = 1;
            iArr[EnumC4809Gq5.CHAR.ordinal()] = 2;
            iArr[EnumC4809Gq5.BYTE.ordinal()] = 3;
            iArr[EnumC4809Gq5.SHORT.ordinal()] = 4;
            iArr[EnumC4809Gq5.INT.ordinal()] = 5;
            iArr[EnumC4809Gq5.FLOAT.ordinal()] = 6;
            iArr[EnumC4809Gq5.LONG.ordinal()] = 7;
            iArr[EnumC4809Gq5.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    private C8817Xl3() {
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3 b(AbstractC8317Vl3 abstractC8317Vl3) {
        AbstractC13042fc3.i(abstractC8317Vl3, "possiblyPrimitiveType");
        if (!(abstractC8317Vl3 instanceof AbstractC8317Vl3.d)) {
            return abstractC8317Vl3;
        }
        AbstractC8317Vl3.d dVar = (AbstractC8317Vl3.d) abstractC8317Vl3;
        if (dVar.i() == null) {
            return abstractC8317Vl3;
        }
        String strF = C4996Hl3.c(dVar.i().u()).f();
        AbstractC13042fc3.h(strF, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return d(strF);
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3 a(String str) {
        EnumC7376Rl3 enumC7376Rl3;
        AbstractC8317Vl3 cVar;
        AbstractC13042fc3.i(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        EnumC7376Rl3[] enumC7376Rl3ArrValues = EnumC7376Rl3.values();
        int length = enumC7376Rl3ArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                enumC7376Rl3 = null;
                break;
            }
            enumC7376Rl3 = enumC7376Rl3ArrValues[i];
            if (enumC7376Rl3.q().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (enumC7376Rl3 != null) {
            return new AbstractC8317Vl3.d(enumC7376Rl3);
        }
        if (cCharAt == 'V') {
            return new AbstractC8317Vl3.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
            cVar = new AbstractC8317Vl3.a(a(strSubstring));
        } else {
            if (cCharAt == 'L') {
                AbstractC20762sZ6.b0(str, ';', false, 2, null);
            }
            String strSubstring2 = str.substring(1, str.length() - 1);
            AbstractC13042fc3.h(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new AbstractC8317Vl3.c(strSubstring2);
        }
        return cVar;
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3.c d(String str) {
        AbstractC13042fc3.i(str, "internalName");
        return new AbstractC8317Vl3.c(str);
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3 e(EnumC4809Gq5 enumC4809Gq5) {
        AbstractC13042fc3.i(enumC4809Gq5, "primitiveType");
        switch (a.a[enumC4809Gq5.ordinal()]) {
            case 1:
                return AbstractC8317Vl3.a.a();
            case 2:
                return AbstractC8317Vl3.a.c();
            case 3:
                return AbstractC8317Vl3.a.b();
            case 4:
                return AbstractC8317Vl3.a.h();
            case 5:
                return AbstractC8317Vl3.a.f();
            case 6:
                return AbstractC8317Vl3.a.e();
            case 7:
                return AbstractC8317Vl3.a.g();
            case 8:
                return AbstractC8317Vl3.a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC8317Vl3 f() {
        return d("java/lang/Class");
    }

    @Override // ir.nasim.InterfaceC8551Wl3
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String c(AbstractC8317Vl3 abstractC8317Vl3) {
        String strQ;
        AbstractC13042fc3.i(abstractC8317Vl3, "type");
        if (abstractC8317Vl3 instanceof AbstractC8317Vl3.a) {
            return AbstractC13042fc3.q("[", c(((AbstractC8317Vl3.a) abstractC8317Vl3).i()));
        }
        if (abstractC8317Vl3 instanceof AbstractC8317Vl3.d) {
            EnumC7376Rl3 enumC7376Rl3I = ((AbstractC8317Vl3.d) abstractC8317Vl3).i();
            return (enumC7376Rl3I == null || (strQ = enumC7376Rl3I.q()) == null) ? TokenNames.V : strQ;
        }
        if (!(abstractC8317Vl3 instanceof AbstractC8317Vl3.c)) {
            throw new NoWhenBranchMatchedException();
        }
        return 'L' + ((AbstractC8317Vl3.c) abstractC8317Vl3).i() + ';';
    }
}
