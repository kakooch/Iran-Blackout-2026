package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.u80, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21788u80 extends AbstractC17457n0 {
    public static final a d = new a(null);
    private final EnumC22974w80 c;

    /* renamed from: ir.nasim.u80$a */
    public static final class a {

        /* renamed from: ir.nasim.u80$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1624a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC9412Zv.values().length];
                try {
                    iArr[EnumC9412Zv.SCAM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC9412Zv.SPAM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC9412Zv.IMMORAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC9412Zv.DISINFORMATION.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC22974w80 a(EnumC9412Zv enumC9412Zv) {
            int i = enumC9412Zv == null ? -1 : C1624a.a[enumC9412Zv.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? EnumC22974w80.f : EnumC22974w80.e : EnumC22974w80.d : EnumC22974w80.c : EnumC22974w80.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21788u80(C11909dl1 c11909dl1, EnumC22974w80 enumC22974w80) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC13042fc3.i(enumC22974w80, "bannedType");
        this.c = enumC22974w80;
    }

    public static final EnumC22974w80 r(EnumC9412Zv enumC9412Zv) {
        return d.a(enumC9412Zv);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.blocked_message);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C21788u80) && super.equals(obj) && this.c == ((C21788u80) obj).c;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.c.hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final EnumC22974w80 s() {
        return this.c;
    }
}
