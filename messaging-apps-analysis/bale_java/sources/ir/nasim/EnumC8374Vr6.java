package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Vr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC8374Vr6 {
    MCI(1),
    IRANCELL(2),
    RIGHTEL(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    /* renamed from: ir.nasim.Vr6$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8374Vr6.values().length];
            a = iArr;
            try {
                iArr[EnumC8374Vr6.MCI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC8374Vr6.RIGHTEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC8374Vr6.IRANCELL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC8374Vr6.UNSUPPORTED_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    EnumC8374Vr6(int i) {
        this.a = i;
    }

    public static String j(EnumC8374Vr6 enumC8374Vr6, Context context) {
        int i = a.a[enumC8374Vr6.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : context.getString(AbstractC12217eE5.unkown_operator) : context.getString(AbstractC12217eE5.irancell) : context.getString(AbstractC12217eE5.rightel) : context.getString(AbstractC12217eE5.mci);
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = this.a;
        return i != 1 ? i != 2 ? i != 3 ? "" : "RIGHTEL" : "IRANCELL" : "MCI";
    }
}
