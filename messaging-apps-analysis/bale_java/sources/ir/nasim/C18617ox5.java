package ir.nasim;

import ir.nasim.C10647bx5;
import ir.nasim.C12053dx5;
import ir.nasim.C6526Nw5;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ox5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18617ox5 {
    public static final C18617ox5 a = new C18617ox5();

    /* renamed from: ir.nasim.ox5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;
        public static final /* synthetic */ int[] h;

        static {
            int[] iArr = new int[EnumC8418Vw5.values().length];
            iArr[EnumC8418Vw5.FINAL.ordinal()] = 1;
            iArr[EnumC8418Vw5.OPEN.ordinal()] = 2;
            iArr[EnumC8418Vw5.ABSTRACT.ordinal()] = 3;
            iArr[EnumC8418Vw5.SEALED.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[EnumC11067cg4.valuesCustom().length];
            iArr2[EnumC11067cg4.FINAL.ordinal()] = 1;
            iArr2[EnumC11067cg4.OPEN.ordinal()] = 2;
            iArr2[EnumC11067cg4.ABSTRACT.ordinal()] = 3;
            iArr2[EnumC11067cg4.SEALED.ordinal()] = 4;
            b = iArr2;
            int[] iArr3 = new int[EnumC15071ix5.values().length];
            iArr3[EnumC15071ix5.INTERNAL.ordinal()] = 1;
            iArr3[EnumC15071ix5.PRIVATE.ordinal()] = 2;
            iArr3[EnumC15071ix5.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[EnumC15071ix5.PROTECTED.ordinal()] = 4;
            iArr3[EnumC15071ix5.PUBLIC.ordinal()] = 5;
            iArr3[EnumC15071ix5.LOCAL.ordinal()] = 6;
            c = iArr3;
            int[] iArr4 = new int[C6526Nw5.c.values().length];
            iArr4[C6526Nw5.c.CLASS.ordinal()] = 1;
            iArr4[C6526Nw5.c.INTERFACE.ordinal()] = 2;
            iArr4[C6526Nw5.c.ENUM_CLASS.ordinal()] = 3;
            iArr4[C6526Nw5.c.ENUM_ENTRY.ordinal()] = 4;
            iArr4[C6526Nw5.c.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[C6526Nw5.c.OBJECT.ordinal()] = 6;
            iArr4[C6526Nw5.c.COMPANION_OBJECT.ordinal()] = 7;
            d = iArr4;
            int[] iArr5 = new int[AU0.values().length];
            iArr5[AU0.CLASS.ordinal()] = 1;
            iArr5[AU0.INTERFACE.ordinal()] = 2;
            iArr5[AU0.ENUM_CLASS.ordinal()] = 3;
            iArr5[AU0.ENUM_ENTRY.ordinal()] = 4;
            iArr5[AU0.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[AU0.OBJECT.ordinal()] = 6;
            e = iArr5;
            int[] iArr6 = new int[C12053dx5.c.values().length];
            iArr6[C12053dx5.c.IN.ordinal()] = 1;
            iArr6[C12053dx5.c.OUT.ordinal()] = 2;
            iArr6[C12053dx5.c.INV.ordinal()] = 3;
            f = iArr6;
            int[] iArr7 = new int[C10647bx5.b.c.values().length];
            iArr7[C10647bx5.b.c.IN.ordinal()] = 1;
            iArr7[C10647bx5.b.c.OUT.ordinal()] = 2;
            iArr7[C10647bx5.b.c.INV.ordinal()] = 3;
            iArr7[C10647bx5.b.c.STAR.ordinal()] = 4;
            g = iArr7;
            int[] iArr8 = new int[KQ7.valuesCustom().length];
            iArr8[KQ7.IN_VARIANCE.ordinal()] = 1;
            iArr8[KQ7.OUT_VARIANCE.ordinal()] = 2;
            iArr8[KQ7.INVARIANT.ordinal()] = 3;
            h = iArr8;
        }
    }

    private C18617ox5() {
    }

    public final AU0 a(C6526Nw5.c cVar) {
        switch (cVar == null ? -1 : a.d[cVar.ordinal()]) {
        }
        return AU0.CLASS;
    }

    public final EnumC11067cg4 b(EnumC8418Vw5 enumC8418Vw5) {
        int i = enumC8418Vw5 == null ? -1 : a.a[enumC8418Vw5.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? EnumC11067cg4.FINAL : EnumC11067cg4.SEALED : EnumC11067cg4.ABSTRACT : EnumC11067cg4.OPEN : EnumC11067cg4.FINAL;
    }

    public final KQ7 c(C10647bx5.b.c cVar) {
        AbstractC13042fc3.i(cVar, "projection");
        int i = a.g[cVar.ordinal()];
        if (i == 1) {
            return KQ7.IN_VARIANCE;
        }
        if (i == 2) {
            return KQ7.OUT_VARIANCE;
        }
        if (i == 3) {
            return KQ7.INVARIANT;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(AbstractC13042fc3.q("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }

    public final KQ7 d(C12053dx5.c cVar) {
        AbstractC13042fc3.i(cVar, "variance");
        int i = a.f[cVar.ordinal()];
        if (i == 1) {
            return KQ7.IN_VARIANCE;
        }
        if (i == 2) {
            return KQ7.OUT_VARIANCE;
        }
        if (i == 3) {
            return KQ7.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
