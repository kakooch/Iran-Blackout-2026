package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.jB, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15202jB implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.jB$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FM7.values().length];
            try {
                iArr[FM7.Puppet_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FM7.Puppet_BALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FM7.Puppet_IGAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FM7.Puppet_GAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FM7.Puppet_EITTA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FM7.Puppet_RUBIKA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FM7.Puppet_SPLUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FM7.Puppet_M7.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FM7.Puppet_M8.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FM7.UNRECOGNIZED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ir.nasim.features.mxp.entity.a a(FM7 fm7) {
        AbstractC13042fc3.i(fm7, "input");
        switch (a.a[fm7.ordinal()]) {
            case 1:
                return ir.nasim.features.mxp.entity.a.e;
            case 2:
                return ir.nasim.features.mxp.entity.a.e;
            case 3:
                return ir.nasim.features.mxp.entity.a.f;
            case 4:
                return ir.nasim.features.mxp.entity.a.g;
            case 5:
                return ir.nasim.features.mxp.entity.a.h;
            case 6:
                return ir.nasim.features.mxp.entity.a.i;
            case 7:
                return ir.nasim.features.mxp.entity.a.j;
            case 8:
                return ir.nasim.features.mxp.entity.a.e;
            case 9:
                return ir.nasim.features.mxp.entity.a.e;
            case 10:
                return ir.nasim.features.mxp.entity.a.e;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
