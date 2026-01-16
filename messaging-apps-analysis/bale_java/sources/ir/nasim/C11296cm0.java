package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.cm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11296cm0 implements InterfaceC21651tu {
    private final AbstractC19738qr3 a;
    private final C9424Zw2 b;
    private final Map c;
    private final InterfaceC9173Yu3 d;

    /* renamed from: ir.nasim.cm0$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke() {
            return C11296cm0.this.a.o(C11296cm0.this.e()).p();
        }
    }

    public C11296cm0(AbstractC19738qr3 abstractC19738qr3, C9424Zw2 c9424Zw2, Map map) {
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(map, "allValueArguments");
        this.a = abstractC19738qr3;
        this.b = c9424Zw2;
        this.c = map;
        this.d = AbstractC13269fw3.b(EnumC4870Gx3.b, new a());
    }

    @Override // ir.nasim.InterfaceC21651tu
    public C9424Zw2 e() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public AbstractC4099Dr3 getType() {
        Object value = this.d.getValue();
        AbstractC13042fc3.h(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (AbstractC4099Dr3) value;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public JH6 i() {
        JH6 jh6 = JH6.a;
        AbstractC13042fc3.h(jh6, "NO_SOURCE");
        return jh6;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public Map j() {
        return this.c;
    }
}
