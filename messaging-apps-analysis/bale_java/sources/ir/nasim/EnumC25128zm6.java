package ir.nasim;

import ir.nasim.EnumC25128zm6;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.zm6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC25128zm6 {
    public static final a a;
    public static final EnumC25128zm6 b = new EnumC25128zm6("SPEAKER", 0);
    public static final EnumC25128zm6 c = new EnumC25128zm6("EARPIECE", 1);
    public static final EnumC25128zm6 d = new EnumC25128zm6("BLUETOOTH", 2);
    private static final /* synthetic */ EnumC25128zm6[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.zm6$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int c(EnumC25128zm6 enumC25128zm6, EnumC25128zm6 enumC25128zm62) {
            return enumC25128zm6.ordinal() - enumC25128zm62.ordinal();
        }

        public final Comparator b() {
            return new Comparator() { // from class: ir.nasim.ym6
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return EnumC25128zm6.a.c((EnumC25128zm6) obj, (EnumC25128zm6) obj2);
                }
            };
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC25128zm6[] enumC25128zm6ArrA = a();
        e = enumC25128zm6ArrA;
        f = G92.a(enumC25128zm6ArrA);
        a = new a(null);
    }

    private EnumC25128zm6(String str, int i) {
    }

    private static final /* synthetic */ EnumC25128zm6[] a() {
        return new EnumC25128zm6[]{b, c, d};
    }

    public static EnumC25128zm6 valueOf(String str) {
        return (EnumC25128zm6) Enum.valueOf(EnumC25128zm6.class, str);
    }

    public static EnumC25128zm6[] values() {
        return (EnumC25128zm6[]) e.clone();
    }
}
