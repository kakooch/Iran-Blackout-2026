package ir.nasim;

import ir.nasim.C21753u45;
import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.o68, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC18117o68 {
    public static final a b;
    public static final EnumC18117o68 c = new EnumC18117o68("CAMERA", 0, 5);
    public static final EnumC18117o68 d = new EnumC18117o68("RECORD_AUDIO", 1, 6);
    public static final EnumC18117o68 e = new EnumC18117o68("CAMERA_AND_RECORD_AUDIO", 2, 7);
    public static final EnumC18117o68 f = new EnumC18117o68("LOCATION", 3, 8);
    public static final EnumC18117o68 g = new EnumC18117o68("CHOOSE_FILE", 4, 9);
    private static final /* synthetic */ EnumC18117o68[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    /* renamed from: ir.nasim.o68$a */
    public static final class a {

        /* renamed from: ir.nasim.o68$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1418a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C21753u45.g.values().length];
                try {
                    iArr[C21753u45.g.e.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[C21753u45.g.f.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[C21753u45.g.g.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[C21753u45.g.h.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC18117o68 a(C21753u45.g gVar) {
            AbstractC13042fc3.i(gVar, "<this>");
            int i = C1418a.a[gVar.ordinal()];
            if (i == 1) {
                return EnumC18117o68.c;
            }
            if (i == 2) {
                return EnumC18117o68.d;
            }
            if (i == 3) {
                return EnumC18117o68.f;
            }
            if (i == 4) {
                return EnumC18117o68.e;
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC18117o68[] enumC18117o68ArrA = a();
        h = enumC18117o68ArrA;
        i = G92.a(enumC18117o68ArrA);
        b = new a(null);
    }

    private EnumC18117o68(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC18117o68[] a() {
        return new EnumC18117o68[]{c, d, e, f, g};
    }

    public static EnumC18117o68 valueOf(String str) {
        return (EnumC18117o68) Enum.valueOf(EnumC18117o68.class, str);
    }

    public static EnumC18117o68[] values() {
        return (EnumC18117o68[]) h.clone();
    }

    public final int j() {
        return this.a;
    }
}
