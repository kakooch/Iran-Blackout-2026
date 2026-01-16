package ir.nasim;

import ir.nasim.EnumC16492lN;
import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lN, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC16492lN {
    public static final a a;
    private static b b;
    public static final EnumC16492lN c = new EnumC16492lN("BLUETOOTH_AVAILABLE", 0);
    public static final EnumC16492lN d = new EnumC16492lN("SPEAKER", 1);
    public static final EnumC16492lN e = new EnumC16492lN("EARPIECE", 2);
    public static final EnumC16492lN f = new EnumC16492lN("WIRED", 3);
    public static final EnumC16492lN g = new EnumC16492lN("BLUETOOTH_CONNECTED", 4);
    private static final /* synthetic */ EnumC16492lN[] h;
    private static final /* synthetic */ F92 i;

    /* renamed from: ir.nasim.lN$a */
    public static final class a {

        /* renamed from: ir.nasim.lN$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1371a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;

            static {
                int[] iArr = new int[EnumC16492lN.values().length];
                try {
                    iArr[EnumC16492lN.d.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC16492lN.e.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
                int[] iArr2 = new int[b.values().length];
                try {
                    iArr2[b.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[b.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                b = iArr2;
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int d(EnumC16492lN enumC16492lN, EnumC16492lN enumC16492lN2) {
            return enumC16492lN.ordinal() - enumC16492lN2.ordinal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int e(EnumC16492lN enumC16492lN, EnumC16492lN enumC16492lN2) {
            int i = enumC16492lN == null ? -1 : C1371a.a[enumC16492lN.ordinal()];
            int iOrdinal = i != 1 ? i != 2 ? enumC16492lN.ordinal() : enumC16492lN.ordinal() - 1 : enumC16492lN.ordinal() + 1;
            int i2 = enumC16492lN2 != null ? C1371a.a[enumC16492lN2.ordinal()] : -1;
            return iOrdinal - (i2 != 1 ? i2 != 2 ? enumC16492lN2.ordinal() : enumC16492lN2.ordinal() - 1 : enumC16492lN2.ordinal() + 1);
        }

        public final Comparator c() {
            int i = C1371a.b[f().ordinal()];
            if (i == 1) {
                return new Comparator() { // from class: ir.nasim.jN
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return EnumC16492lN.a.d((EnumC16492lN) obj, (EnumC16492lN) obj2);
                    }
                };
            }
            if (i == 2) {
                return new Comparator() { // from class: ir.nasim.kN
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return EnumC16492lN.a.e((EnumC16492lN) obj, (EnumC16492lN) obj2);
                    }
                };
            }
            throw new NoWhenBranchMatchedException();
        }

        public final b f() {
            return EnumC16492lN.b;
        }

        public final void g(b bVar) {
            AbstractC13042fc3.i(bVar, "<set-?>");
            EnumC16492lN.b = bVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.lN$b */
    public static final class b {
        public static final b a = new b("NORMAL", 0);
        public static final b b = new b("SPEAKER_FIRST", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    static {
        EnumC16492lN[] enumC16492lNArrA = a();
        h = enumC16492lNArrA;
        i = G92.a(enumC16492lNArrA);
        a = new a(null);
        b = b.a;
    }

    private EnumC16492lN(String str, int i2) {
    }

    private static final /* synthetic */ EnumC16492lN[] a() {
        return new EnumC16492lN[]{c, d, e, f, g};
    }

    public static EnumC16492lN valueOf(String str) {
        return (EnumC16492lN) Enum.valueOf(EnumC16492lN.class, str);
    }

    public static EnumC16492lN[] values() {
        return (EnumC16492lN[]) h.clone();
    }
}
