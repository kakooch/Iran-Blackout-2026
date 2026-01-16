package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.cO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10897cO2 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.cO2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24932zS2.values().length];
            try {
                iArr[EnumC24932zS2.GroupType_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC24932zS2.GroupType_CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC24932zS2.GroupType_SUPER_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC24932zS2.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC3690By a(EnumC24932zS2 enumC24932zS2) {
        AbstractC13042fc3.i(enumC24932zS2, "input");
        int i = a.a[enumC24932zS2.ordinal()];
        if (i == 1) {
            return EnumC3690By.GROUP;
        }
        if (i == 2) {
            return EnumC3690By.CHANNEL;
        }
        if (i == 3) {
            return EnumC3690By.SUPER_GROUP;
        }
        if (i == 4) {
            return EnumC3690By.UNSUPPORTED_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
