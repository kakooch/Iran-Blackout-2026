package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yD, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24200yD implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.yD$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CG.values().length];
            try {
                iArr[CG.FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CG.COMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CG.FULL_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CG.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC23552x68 a(CG cg) {
        AbstractC13042fc3.i(cg, "input");
        int i = a.a[cg.ordinal()];
        if (i == 1) {
            return EnumC23552x68.b;
        }
        if (i == 2) {
            return EnumC23552x68.d;
        }
        if (i == 3 || i == 4) {
            return EnumC23552x68.c;
        }
        throw new NoWhenBranchMatchedException();
    }
}
