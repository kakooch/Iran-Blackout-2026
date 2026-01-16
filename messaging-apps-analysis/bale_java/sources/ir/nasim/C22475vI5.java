package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.C21625tr3;
import ir.nasim.InterfaceC22805vr3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.vI5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22475vI5 implements InterfaceC22805vr3.c {
    private static final boolean j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map k;
    private int[] a = null;
    private C4513Fl3 b = null;
    private String c = null;
    private int d = 0;
    private String e = null;
    private String[] f = null;
    private String[] g = null;
    private String[] h = null;
    private C21625tr3.a i = null;

    /* renamed from: ir.nasim.vI5$b */
    private static abstract class b implements InterfaceC22805vr3.b {
        private final List a = new ArrayList();

        private static /* synthetic */ void e(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i != 2) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classLiteralValue";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i != 2) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.InterfaceC22805vr3.b
        public void a() {
            f((String[]) this.a.toArray(new String[0]));
        }

        @Override // ir.nasim.InterfaceC22805vr3.b
        public void b(BU0 bu0) {
            if (bu0 == null) {
                e(2);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.b
        public void c(Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.b
        public void d(C24948zU0 c24948zU0, C6432No4 c6432No4) {
            if (c24948zU0 == null) {
                e(0);
            }
            if (c6432No4 == null) {
                e(1);
            }
        }

        protected abstract void f(String[] strArr);
    }

    static {
        HashMap map = new HashMap();
        k = map;
        map.put(C24948zU0.m(new C9424Zw2("kotlin.jvm.internal.KotlinClass")), C21625tr3.a.CLASS);
        map.put(C24948zU0.m(new C9424Zw2("kotlin.jvm.internal.KotlinFileFacade")), C21625tr3.a.FILE_FACADE);
        map.put(C24948zU0.m(new C9424Zw2("kotlin.jvm.internal.KotlinMultifileClass")), C21625tr3.a.MULTIFILE_CLASS);
        map.put(C24948zU0.m(new C9424Zw2("kotlin.jvm.internal.KotlinMultifileClassPart")), C21625tr3.a.MULTIFILE_CLASS_PART);
        map.put(C24948zU0.m(new C9424Zw2("kotlin.jvm.internal.KotlinSyntheticClass")), C21625tr3.a.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void d(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean o() {
        C21625tr3.a aVar = this.i;
        return aVar == C21625tr3.a.CLASS || aVar == C21625tr3.a.FILE_FACADE || aVar == C21625tr3.a.MULTIFILE_CLASS_PART;
    }

    @Override // ir.nasim.InterfaceC22805vr3.c
    public InterfaceC22805vr3.a c(C24948zU0 c24948zU0, JH6 jh6) {
        C21625tr3.a aVar;
        if (c24948zU0 == null) {
            d(0);
        }
        if (jh6 == null) {
            d(1);
        }
        if (c24948zU0.b().equals(AbstractC24521yl3.a)) {
            return new c();
        }
        if (j || this.i != null || (aVar = (C21625tr3.a) k.get(c24948zU0)) == null) {
            return null;
        }
        this.i = aVar;
        return new d();
    }

    public C21625tr3 n() {
        if (this.i == null || this.a == null) {
            return null;
        }
        C6404Nl3 c6404Nl3 = new C6404Nl3(this.a, (this.d & 8) != 0);
        if (!c6404Nl3.h()) {
            this.h = this.f;
            this.f = null;
        } else if (o() && this.f == null) {
            return null;
        }
        C21625tr3.a aVar = this.i;
        C4513Fl3 c4513Fl3 = this.b;
        if (c4513Fl3 == null) {
            c4513Fl3 = C4513Fl3.h;
        }
        return new C21625tr3(aVar, c6404Nl3, c4513Fl3, this.f, this.h, this.g, this.c, this.d, this.e);
    }

    /* renamed from: ir.nasim.vI5$c */
    private class c implements InterfaceC22805vr3.a {

        /* renamed from: ir.nasim.vI5$c$a */
        class a extends b {
            a() {
            }

            private static /* synthetic */ void e(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // ir.nasim.C22475vI5.b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                C22475vI5.this.f = strArr;
            }
        }

        /* renamed from: ir.nasim.vI5$c$b */
        class b extends b {
            b() {
            }

            private static /* synthetic */ void e(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // ir.nasim.C22475vI5.b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                C22475vI5.this.g = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private InterfaceC22805vr3.b h() {
            return new a();
        }

        private InterfaceC22805vr3.b i() {
            return new b();
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.a b(C6432No4 c6432No4, C24948zU0 c24948zU0) {
            if (c6432No4 == null) {
                g(6);
            }
            if (c24948zU0 != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void c(C6432No4 c6432No4, C24948zU0 c24948zU0, C6432No4 c6432No42) {
            if (c6432No4 == null) {
                g(3);
            }
            if (c24948zU0 == null) {
                g(4);
            }
            if (c6432No42 == null) {
                g(5);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void d(C6432No4 c6432No4, BU0 bu0) {
            if (c6432No4 == null) {
                g(0);
            }
            if (bu0 == null) {
                g(1);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.b e(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                g(2);
            }
            String strH = c6432No4.h();
            if ("d1".equals(strH)) {
                return h();
            }
            if ("d2".equals(strH)) {
                return i();
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void f(C6432No4 c6432No4, Object obj) {
            if (c6432No4 == null) {
                return;
            }
            String strH = c6432No4.h();
            if ("k".equals(strH)) {
                if (obj instanceof Integer) {
                    C22475vI5.this.i = C21625tr3.a.j(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strH)) {
                if (obj instanceof int[]) {
                    C22475vI5.this.a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(strH)) {
                if (obj instanceof int[]) {
                    C22475vI5.this.b = new C4513Fl3((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(strH)) {
                if (obj instanceof String) {
                    C22475vI5.this.c = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strH)) {
                if (obj instanceof Integer) {
                    C22475vI5.this.d = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strH) && (obj instanceof String)) {
                C22475vI5.this.e = (String) obj;
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void a() {
        }
    }

    /* renamed from: ir.nasim.vI5$d */
    private class d implements InterfaceC22805vr3.a {

        /* renamed from: ir.nasim.vI5$d$a */
        class a extends b {
            a() {
            }

            private static /* synthetic */ void e(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // ir.nasim.C22475vI5.b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                C22475vI5.this.f = strArr;
            }
        }

        /* renamed from: ir.nasim.vI5$d$b */
        class b extends b {
            b() {
            }

            private static /* synthetic */ void e(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // ir.nasim.C22475vI5.b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                C22475vI5.this.g = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private InterfaceC22805vr3.b h() {
            return new a();
        }

        private InterfaceC22805vr3.b i() {
            return new b();
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.a b(C6432No4 c6432No4, C24948zU0 c24948zU0) {
            if (c6432No4 == null) {
                g(6);
            }
            if (c24948zU0 != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void c(C6432No4 c6432No4, C24948zU0 c24948zU0, C6432No4 c6432No42) {
            if (c6432No4 == null) {
                g(3);
            }
            if (c24948zU0 == null) {
                g(4);
            }
            if (c6432No42 == null) {
                g(5);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void d(C6432No4 c6432No4, BU0 bu0) {
            if (c6432No4 == null) {
                g(0);
            }
            if (bu0 == null) {
                g(1);
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.b e(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                g(2);
            }
            String strH = c6432No4.h();
            if ("data".equals(strH) || "filePartClassNames".equals(strH)) {
                return h();
            }
            if ("strings".equals(strH)) {
                return i();
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void f(C6432No4 c6432No4, Object obj) {
            if (c6432No4 == null) {
                return;
            }
            String strH = c6432No4.h();
            if (!ParameterNames.VERSION.equals(strH)) {
                if ("multifileClassName".equals(strH)) {
                    C22475vI5.this.c = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                C22475vI5.this.a = iArr;
                if (C22475vI5.this.b == null) {
                    C22475vI5.this.b = new C4513Fl3(iArr);
                }
            }
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void a() {
        }
    }

    @Override // ir.nasim.InterfaceC22805vr3.c
    public void a() {
    }
}
