package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.Ub2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7992Ub2 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.Ub2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC8893Xt7 a(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, "input");
        int i = a.a[exPeerType.ordinal()];
        if (i == 1) {
            return EnumC8893Xt7.d;
        }
        if (i == 2) {
            return EnumC8893Xt7.f;
        }
        if (i == 3) {
            return EnumC8893Xt7.g;
        }
        if (i != 4) {
            return null;
        }
        return EnumC8893Xt7.h;
    }
}
