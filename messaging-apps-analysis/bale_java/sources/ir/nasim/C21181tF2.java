package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tF2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21181tF2 {
    private final PE a;
    private final SettingsModule b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.tF2$a */
    public static final class a {
        public static final a a = new a("GIF", 0);
        public static final a b = new a("IMAGE", 1);
        public static final a c = new a("VIDEO", 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    /* renamed from: ir.nasim.tF2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC19739qr4.values().length];
            try {
                iArr[EnumC19739qr4.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC19739qr4.WI_FI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[a.values().length];
            try {
                iArr2[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public C21181tF2(PE pe, SettingsModule settingsModule) {
        AbstractC13042fc3.i(pe, "appStateModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = pe;
        this.b = settingsModule;
    }

    private final boolean b(a aVar) {
        EnumC19739qr4 enumC19739qr4 = (EnumC19739qr4) this.a.E().h().b();
        int i = enumC19739qr4 == null ? -1 : b.a[enumC19739qr4.ordinal()];
        if (i == 1) {
            int i2 = b.b[aVar.ordinal()];
            if (i2 == 1) {
                return this.b.k5();
            }
            if (i2 == 2) {
                return this.b.l5();
            }
            if (i2 == 3) {
                return this.b.m5();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i != 2) {
            return false;
        }
        int i3 = b.b[aVar.ordinal()];
        if (i3 == 1) {
            return this.b.p5();
        }
        if (i3 == 2) {
            return this.b.q5();
        }
        if (i3 == 3) {
            return this.b.r5();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(a aVar, InterfaceC18505om2 interfaceC18505om2) {
        AbstractC13042fc3.i(aVar, "mediaType");
        AbstractC13042fc3.i(interfaceC18505om2, "fileSource");
        return b(aVar) && ((float) interfaceC18505om2.f()) / 1048576.0f <= ((float) this.b.B0());
    }
}
