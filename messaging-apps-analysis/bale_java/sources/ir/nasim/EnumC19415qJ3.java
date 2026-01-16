package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qJ3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class EnumC19415qJ3 {
    public static final EnumC19415qJ3 a;
    public static final EnumC19415qJ3 b;
    private static final /* synthetic */ EnumC19415qJ3[] c;

    /* renamed from: ir.nasim.qJ3$a */
    enum a extends EnumC19415qJ3 {
        a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        a = aVar;
        EnumC19415qJ3 enumC19415qJ3 = new EnumC19415qJ3("STRING", 1) { // from class: ir.nasim.qJ3.b
            {
                a aVar2 = null;
            }
        };
        b = enumC19415qJ3;
        c = new EnumC19415qJ3[]{aVar, enumC19415qJ3};
    }

    private EnumC19415qJ3(String str, int i) {
    }

    public static EnumC19415qJ3 valueOf(String str) {
        return (EnumC19415qJ3) Enum.valueOf(EnumC19415qJ3.class, str);
    }

    public static EnumC19415qJ3[] values() {
        return (EnumC19415qJ3[]) c.clone();
    }

    /* synthetic */ EnumC19415qJ3(String str, int i, a aVar) {
        this(str, i);
    }
}
