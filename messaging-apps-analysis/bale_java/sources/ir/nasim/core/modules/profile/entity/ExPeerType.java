package ir.nasim.core.modules.profile.entity;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.EnumC10088b35;
import ir.nasim.EnumC9196Yx;
import ir.nasim.W25;

@Keep
@KeepName
/* loaded from: classes5.dex */
public enum ExPeerType {
    UNKNOWN(0),
    PRIVATE(1),
    GROUP(2),
    CHANNEL(3),
    BOT(4),
    THREAD(6);

    private int value;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            a = iArr;
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ExPeerType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ExPeerType.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ExPeerType.THREAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    ExPeerType(int i) {
        this.value = i;
    }

    public static ExPeerType fromValue(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 6 ? UNKNOWN : THREAD : BOT : CHANNEL : GROUP : PRIVATE;
    }

    public W25 getPeerType() {
        int i = a.a[ordinal()];
        return (i == 1 || i == 2 || i == 5) ? W25.a : W25.b;
    }

    public int getValue() {
        return this.value;
    }

    public Boolean isPrivate() {
        int i = a.a[ordinal()];
        return (i == 1 || i == 2 || i == 5) ? Boolean.TRUE : Boolean.FALSE;
    }

    public EnumC9196Yx toApi() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? EnumC9196Yx.UNSUPPORTED_VALUE : EnumC9196Yx.THREAD : EnumC9196Yx.CHANNEL : EnumC9196Yx.GROUP : EnumC9196Yx.BOT : EnumC9196Yx.PRIVATE;
    }

    public EnumC10088b35 toProtoApi() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? EnumC10088b35.ExPeerType_UNKNOWN : EnumC10088b35.ExPeerType_THREAD : EnumC10088b35.ExPeerType_CHANNEL : EnumC10088b35.ExPeerType_GROUP : EnumC10088b35.ExPeerType_BOT : EnumC10088b35.ExPeerType_PRIVATE;
    }
}
