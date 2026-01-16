package ir.nasim;

import android.os.Build;
import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.t44, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC21078t44 {
    public static final EnumC21078t44 c = new EnumC21078t44("Copy", 0, 0);
    public static final EnumC21078t44 d = new EnumC21078t44("Paste", 1, 1);
    public static final EnumC21078t44 e = new EnumC21078t44("Cut", 2, 2);
    public static final EnumC21078t44 f = new EnumC21078t44("SelectAll", 3, 3);
    public static final EnumC21078t44 g = new EnumC21078t44("Autofill", 4, 4);
    private static final /* synthetic */ EnumC21078t44[] h;
    private static final /* synthetic */ F92 i;
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.t44$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC21078t44.values().length];
            try {
                iArr[EnumC21078t44.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21078t44.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21078t44.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC21078t44.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC21078t44.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        EnumC21078t44[] enumC21078t44ArrA = a();
        h = enumC21078t44ArrA;
        i = G92.a(enumC21078t44ArrA);
    }

    private EnumC21078t44(String str, int i2, int i3) {
        this.a = i3;
        this.b = i3;
    }

    private static final /* synthetic */ EnumC21078t44[] a() {
        return new EnumC21078t44[]{c, d, e, f, g};
    }

    public static EnumC21078t44 valueOf(String str) {
        return (EnumC21078t44) Enum.valueOf(EnumC21078t44.class, str);
    }

    public static EnumC21078t44[] values() {
        return (EnumC21078t44[]) h.clone();
    }

    public final int j() {
        return this.a;
    }

    public final int p() {
        return this.b;
    }

    public final int q() {
        int i2 = a.a[ordinal()];
        if (i2 == 1) {
            return android.R.string.copy;
        }
        if (i2 == 2) {
            return android.R.string.paste;
        }
        if (i2 == 3) {
            return android.R.string.cut;
        }
        if (i2 == 4) {
            return android.R.string.selectAll;
        }
        if (i2 == 5) {
            return Build.VERSION.SDK_INT <= 26 ? AbstractC9600aE5.autofill : android.R.string.autofill;
        }
        throw new NoWhenBranchMatchedException();
    }
}
