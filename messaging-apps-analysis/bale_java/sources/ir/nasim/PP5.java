package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class PP5 implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OP5.values().length];
            try {
                iArr[OP5.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OP5.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OP5.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OP5.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OP5.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MP5 a(OP5 op5) {
        AbstractC13042fc3.i(op5, "input");
        int i = a.a[op5.ordinal()];
        if (i == 1) {
            return MP5.ReportKind_SCAM;
        }
        if (i == 2) {
            return MP5.ReportKind_INAPPROPRIATE_CONTENT;
        }
        if (i == 3) {
            return MP5.ReportKind_VIOLENCE;
        }
        if (i == 4) {
            return MP5.ReportKind_FALSE_INFORMATION;
        }
        if (i == 5) {
            return MP5.ReportKind_SPAM;
        }
        throw new NoWhenBranchMatchedException();
    }
}
