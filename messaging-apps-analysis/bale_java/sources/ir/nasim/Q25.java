package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class Q25 implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[P25.values().length];
            try {
                iArr[P25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[P25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[P25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[P25.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LP5 a(P25 p25) {
        AbstractC13042fc3.i(p25, "input");
        int i = a.a[p25.ordinal()];
        if (i == 1) {
            return LP5.PeerSource_DIALOGS;
        }
        if (i == 2) {
            return LP5.PeerSource_VITRINE;
        }
        if (i == 3) {
            return LP5.PeerSource_MARKET;
        }
        if (i == 4) {
            return LP5.PeerSource_PRIVACY_BAR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
