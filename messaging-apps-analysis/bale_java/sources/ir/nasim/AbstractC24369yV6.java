package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24369yV6 {

    /* renamed from: ir.nasim.yV6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC10088b35.values().length];
            try {
                iArr[EnumC10088b35.ExPeerType_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_SUPERGROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC10088b35.ExPeerType_THREAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC10088b35.UNRECOGNIZED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC23779xV6.values().length];
            try {
                iArr2[EnumC23779xV6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnumC23779xV6.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[EnumC23779xV6.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[EnumC23779xV6.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[EnumC23779xV6.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[EnumC23779xV6.a.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            b = iArr2;
        }
    }

    public static final EnumC10088b35 a(EnumC23779xV6 enumC23779xV6) {
        AbstractC13042fc3.i(enumC23779xV6, "<this>");
        switch (a.b[enumC23779xV6.ordinal()]) {
            case 1:
                return EnumC10088b35.ExPeerType_PRIVATE;
            case 2:
                return EnumC10088b35.ExPeerType_GROUP;
            case 3:
            case 4:
                return EnumC10088b35.ExPeerType_CHANNEL;
            case 5:
                return EnumC10088b35.ExPeerType_BOT;
            case 6:
                return EnumC10088b35.ExPeerType_UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final EnumC23779xV6 b(EnumC10088b35 enumC10088b35) {
        AbstractC13042fc3.i(enumC10088b35, "<this>");
        switch (a.a[enumC10088b35.ordinal()]) {
            case 1:
                return EnumC23779xV6.a;
            case 2:
                return EnumC23779xV6.b;
            case 3:
                return EnumC23779xV6.c;
            case 4:
                return EnumC23779xV6.d;
            case 5:
                return EnumC23779xV6.f;
            case 6:
                return EnumC23779xV6.a;
            case 7:
                return EnumC23779xV6.a;
            case 8:
                return EnumC23779xV6.a;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final C11692dR6 c(QQ6 qq6) {
        EnumC23779xV6 enumC23779xV6B;
        EnumC10088b35 type;
        AbstractC13042fc3.i(qq6, "<this>");
        if (qq6.E()) {
            return new C11692dR6(qq6.p(), EnumC23779xV6.e, null, 4, null);
        }
        PeersStruct$ExPeer peersStruct$ExPeerG = qq6.g();
        int id = peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getId() : qq6.p();
        PeersStruct$ExPeer peersStruct$ExPeerG2 = qq6.g();
        if (peersStruct$ExPeerG2 == null || (type = peersStruct$ExPeerG2.getType()) == null || (enumC23779xV6B = b(type)) == null) {
            enumC23779xV6B = EnumC23779xV6.b;
        }
        return new C11692dR6(id, enumC23779xV6B, null, 4, null);
    }

    public static final boolean d(C11692dR6 c11692dR6, PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(c11692dR6, "<this>");
        AbstractC13042fc3.i(peersStruct$ExPeer, "exPeer");
        EnumC23779xV6 enumC23779xV6C = c11692dR6.c();
        EnumC10088b35 type = peersStruct$ExPeer.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        return enumC23779xV6C == b(type);
    }
}
