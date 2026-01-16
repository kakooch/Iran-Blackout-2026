package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Bl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3577Bl3 extends AbstractC19738qr3 {
    static final /* synthetic */ InterfaceC5239Im3[] i = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3577Bl3.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    private SA2 g;
    private final InterfaceC23016wC4 h;

    /* renamed from: ir.nasim.Bl3$a */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* renamed from: ir.nasim.Bl3$b */
    public static final class b {
        private final InterfaceC8507Wg4 a;
        private final boolean b;

        public b(InterfaceC8507Wg4 interfaceC8507Wg4, boolean z) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "ownerModuleDescriptor");
            this.a = interfaceC8507Wg4;
            this.b = z;
        }

        public final InterfaceC8507Wg4 a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bl3$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[a.FALLBACK.ordinal()] = 3;
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Bl3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ON6 f;

        /* renamed from: ir.nasim.Bl3$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C3577Bl3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3577Bl3 c3577Bl3) {
                super(0);
                this.e = c3577Bl3;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b invoke() {
                SA2 sa2 = this.e.g;
                if (sa2 == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) sa2.invoke();
                this.e.g = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ON6 on6) {
            super(0);
            this.f = on6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3811Cl3 invoke() {
            C8773Xg4 c8773Xg4R = C3577Bl3.this.r();
            AbstractC13042fc3.h(c8773Xg4R, "builtInsModule");
            return new C3811Cl3(c8773Xg4R, this.f, new a(C3577Bl3.this));
        }
    }

    /* renamed from: ir.nasim.Bl3$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC8507Wg4 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC8507Wg4 interfaceC8507Wg4, boolean z) {
            super(0);
            this.e = interfaceC8507Wg4;
            this.f = z;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(this.e, this.f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3577Bl3(ON6 on6, a aVar) {
        super(on6);
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(aVar, "kind");
        this.h = on6.c(new d(on6));
        int i2 = c.a[aVar.ordinal()];
        if (i2 == 2) {
            f(false);
        } else {
            if (i2 != 3) {
                return;
            }
            f(true);
        }
    }

    @Override // ir.nasim.AbstractC19738qr3
    protected InterfaceC8256Ve5 M() {
        return P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC19738qr3
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public List v() {
        Iterable iterableV = super.v();
        AbstractC13042fc3.h(iterableV, "super.getClassDescriptorFactories()");
        ON6 on6T = T();
        AbstractC13042fc3.h(on6T, "storageManager");
        C8773Xg4 c8773Xg4R = r();
        AbstractC13042fc3.h(c8773Xg4R, "builtInsModule");
        return AbstractC15401jX0.Q0(iterableV, new C3338Al3(on6T, c8773Xg4R, null, 4, null));
    }

    public final C3811Cl3 P0() {
        return (C3811Cl3) MN6.a(this.h, this, i[0]);
    }

    public final void Q0(InterfaceC8507Wg4 interfaceC8507Wg4, boolean z) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        R0(new e(interfaceC8507Wg4, z));
    }

    public final void R0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "computation");
        this.g = sa2;
    }

    @Override // ir.nasim.AbstractC19738qr3
    protected InterfaceC15427ja g() {
        return P0();
    }
}
