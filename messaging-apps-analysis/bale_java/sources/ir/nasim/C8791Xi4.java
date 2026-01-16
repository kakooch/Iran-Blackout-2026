package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xi4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8791Xi4 implements InterfaceC14123hO3 {
    public static final C8791Xi4 a = new C8791Xi4();

    /* renamed from: ir.nasim.Xi4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8525Wi4.values().length];
            try {
                iArr[EnumC8525Wi4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8525Wi4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8525Wi4.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private C8791Xi4() {
    }

    private final io.sentry.Y2 b(EnumC8525Wi4 enumC8525Wi4) {
        int i = a.a[enumC8525Wi4.ordinal()];
        if (i == 1) {
            return io.sentry.Y2.WARNING;
        }
        if (i == 2) {
            return io.sentry.Y2.ERROR;
        }
        if (i == 3) {
            return io.sentry.Y2.FATAL;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public io.sentry.L2 a(InterfaceC8291Vi4 interfaceC8291Vi4) {
        AbstractC13042fc3.i(interfaceC8291Vi4, "input");
        io.sentry.L2 l2 = new io.sentry.L2();
        l2.d0("Classification", interfaceC8291Vi4.getTag());
        l2.f0(interfaceC8291Vi4.c());
        l2.D0(a.b(interfaceC8291Vi4.a()));
        io.sentry.protocol.k kVar = new io.sentry.protocol.k();
        kVar.f(interfaceC8291Vi4.b());
        l2.E0(kVar);
        return l2;
    }
}
