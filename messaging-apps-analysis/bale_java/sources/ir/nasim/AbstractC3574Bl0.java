package ir.nasim;

/* renamed from: ir.nasim.Bl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC3574Bl0 {
    private static EnumC19739qr4 a;

    /* renamed from: ir.nasim.Bl0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC19739qr4.values().length];
            try {
                iArr[EnumC19739qr4.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    private static final EnumC19739qr4 a() {
        EnumC19739qr4 enumC19739qr4 = (EnumC19739qr4) AbstractC5969Lp4.d().Y().v().E().h().b();
        if (a != enumC19739qr4) {
            C19406qI3.a("AutoDownload", "NetworkState: " + enumC19739qr4, new Object[0]);
            a = enumC19739qr4;
        }
        return enumC19739qr4;
    }

    public static final boolean b(EnumC18310oS enumC18310oS) {
        AbstractC13042fc3.i(enumC18310oS, "<this>");
        EnumC19739qr4 enumC19739qr4A = a();
        if ((enumC19739qr4A == null ? -1 : a.a[enumC19739qr4A.ordinal()]) == 1) {
            if (enumC18310oS != EnumC18310oS.d && enumC18310oS != EnumC18310oS.c) {
                return false;
            }
        } else if (enumC18310oS != EnumC18310oS.d && enumC18310oS != EnumC18310oS.b) {
            return false;
        }
        return true;
    }
}
