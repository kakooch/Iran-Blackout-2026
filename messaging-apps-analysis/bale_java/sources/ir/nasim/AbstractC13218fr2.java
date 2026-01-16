package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.fr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13218fr2 {
    private final a a;
    private final int b;
    private final int c;
    private final UA2 d;
    private final UA2 e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.fr2$a */
    public static final class a {
        public static final a a = new a("Visible", 0);
        public static final a b = new a("Clip", 1);
        public static final a c = new a("ExpandIndicator", 2);
        public static final a d = new a("ExpandOrCollapseIndicator", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.fr2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ AbstractC13218fr2(a aVar, int i, int i2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(aVar, i, i2, ua2, ua22);
    }

    public final void a(C13809gr2 c13809gr2, List list) {
        UA2 ua2 = this.d;
        InterfaceC14603iB2 interfaceC14603iB2 = ua2 != null ? (InterfaceC14603iB2) ua2.invoke(c13809gr2) : null;
        UA2 ua22 = this.e;
        InterfaceC14603iB2 interfaceC14603iB22 = ua22 != null ? (InterfaceC14603iB2) ua22.invoke(c13809gr2) : null;
        int i = b.a[this.a.ordinal()];
        if (i == 1) {
            if (interfaceC14603iB2 != null) {
                list.add(interfaceC14603iB2);
            }
        } else {
            if (i != 2) {
                return;
            }
            if (interfaceC14603iB2 != null) {
                list.add(interfaceC14603iB2);
            }
            if (interfaceC14603iB22 != null) {
                list.add(interfaceC14603iB22);
            }
        }
    }

    public final C13809gr2 b() {
        return new C13809gr2(this.a, this.b, this.c);
    }

    private AbstractC13218fr2(a aVar, int i, int i2, UA2 ua2, UA2 ua22) {
        this.a = aVar;
        this.b = i;
        this.c = i2;
        this.d = ua2;
        this.e = ua22;
    }
}
