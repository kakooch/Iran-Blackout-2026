package ir.nasim;

import java.util.HashMap;

/* renamed from: ir.nasim.hq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14396hq6 {
    public static final C14396hq6 a = new C14396hq6();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.hq6$a */
    public static final class a {
        public static final a b = new a("RIGHT", 0, 1);
        public static final a c = new a("LEFT", 1, 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;
        private final int a;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i, int i2) {
            this.a = i2;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.hq6$b */
    public static final class b {
        public static final b b = new b("BACK", 0, "back");
        public static final b c = new b("OPTION_MENU", 1, "option_menu");
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;
        private final String a;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i, String str2) {
            this.a = str2;
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        public final String j() {
            return this.a;
        }
    }

    private C14396hq6() {
    }

    public static final HashMap a(long j, int i, b bVar, a aVar) {
        AbstractC13042fc3.i(bVar, "eventType");
        AbstractC13042fc3.i(aVar, "actionType");
        return AbstractC20051rO3.m(AbstractC4616Fw7.a("date", Long.valueOf(j)), AbstractC4616Fw7.a("user_id", Integer.valueOf(i)), AbstractC4616Fw7.a("event_type", bVar.j()), AbstractC4616Fw7.a("action_type", Integer.valueOf(aVar.j())));
    }
}
