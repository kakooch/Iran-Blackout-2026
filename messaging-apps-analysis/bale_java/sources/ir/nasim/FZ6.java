package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes5.dex */
public final class FZ6 implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10088b35.values().length];
            try {
                iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExPeerType a(EnumC10088b35 enumC10088b35) {
        AbstractC13042fc3.i(enumC10088b35, "input");
        int i = a.a[enumC10088b35.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? ExPeerType.UNKNOWN : ExPeerType.PRIVATE : ExPeerType.CHANNEL : ExPeerType.GROUP : ExPeerType.BOT;
    }
}
