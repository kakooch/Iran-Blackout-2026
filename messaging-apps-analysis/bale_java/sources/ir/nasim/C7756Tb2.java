package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Tb2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7756Tb2 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.Tb2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC10088b35 a(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, "input");
        switch (a.a[exPeerType.ordinal()]) {
            case 1:
                return EnumC10088b35.ExPeerType_UNKNOWN;
            case 2:
                return EnumC10088b35.ExPeerType_PRIVATE;
            case 3:
                return EnumC10088b35.ExPeerType_GROUP;
            case 4:
                return EnumC10088b35.ExPeerType_CHANNEL;
            case 5:
                return EnumC10088b35.ExPeerType_BOT;
            case 6:
                return EnumC10088b35.ExPeerType_THREAD;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
