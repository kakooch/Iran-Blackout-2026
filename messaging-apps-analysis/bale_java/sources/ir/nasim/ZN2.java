package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes5.dex */
public enum ZN2 {
    GROUP,
    CHANNEL;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ZN2.values().length];
            a = iArr;
            try {
                iArr[ZN2.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ZN2.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ExPeerType j() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return ExPeerType.GROUP;
        }
        if (i == 2) {
            return ExPeerType.CHANNEL;
        }
        throw new IncompatibleClassChangeError();
    }

    public EnumC24932zS2 p() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return EnumC24932zS2.GroupType_GROUP;
        }
        if (i == 2) {
            return EnumC24932zS2.GroupType_CHANNEL;
        }
        throw new IncompatibleClassChangeError();
    }
}
