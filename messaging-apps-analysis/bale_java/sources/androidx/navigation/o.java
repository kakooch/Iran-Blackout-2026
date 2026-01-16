package androidx.navigation;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.os.Parcelable;
import ir.nasim.AbstractC10868cL0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC9648aK;
import ir.nasim.ED1;
import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class o {
    public static final l c = new l(null);
    public static final o d = new f();
    public static final o e = new i();
    public static final o f = new e();
    public static final o g = new h();
    public static final o h = new g();
    public static final o i = new d();
    public static final o j = new c();
    public static final o k = new b();
    public static final o l = new a();
    public static final o m = new k();
    public static final o n = new j();
    private final boolean a;
    private final String b = "nav_type";

    public static final class a extends o {
        a() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            return new boolean[]{((Boolean) o.k.j(str)).booleanValue()};
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean[] g(String str, boolean[] zArr) {
            boolean[] zArrG;
            AbstractC13042fc3.i(str, "value");
            return (zArr == null || (zArrG = AbstractC9648aK.G(zArr, f(str))) == null) ? f(str) : zArrG;
        }

        @Override // androidx.navigation.o
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, boolean[] zArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class b extends o {
        b() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Boolean) obj).booleanValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean j(String str) {
            boolean z;
            AbstractC13042fc3.i(str, "value");
            if (AbstractC13042fc3.d(str, "true")) {
                z = true;
            } else {
                if (!AbstractC13042fc3.d(str, "false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public void k(Bundle bundle, String str, boolean z) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putBoolean(str, z);
        }
    }

    public static final class c extends o {
        c() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public float[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public float[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            return new float[]{((Number) o.i.j(str)).floatValue()};
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public float[] g(String str, float[] fArr) {
            float[] fArrA;
            AbstractC13042fc3.i(str, "value");
            return (fArr == null || (fArrA = AbstractC9648aK.A(fArr, f(str))) == null) ? f(str) : fArrA;
        }

        @Override // androidx.navigation.o
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, float[] fArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putFloatArray(str, fArr);
        }
    }

    public static final class d extends o {
        d() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).floatValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Float a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            Object obj = bundle.get(str);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Float");
            return (Float) obj;
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Float j(String str) {
            AbstractC13042fc3.i(str, "value");
            return Float.valueOf(Float.parseFloat(str));
        }

        public void k(Bundle bundle, String str, float f) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putFloat(str, f);
        }
    }

    public static final class e extends o {
        e() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            return new int[]{((Number) o.d.j(str)).intValue()};
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public int[] g(String str, int[] iArr) {
            int[] iArrC;
            AbstractC13042fc3.i(str, "value");
            return (iArr == null || (iArrC = AbstractC9648aK.C(iArr, f(str))) == null) ? f(str) : iArrC;
        }

        @Override // androidx.navigation.o
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, int[] iArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putIntArray(str, iArr);
        }
    }

    public static final class f extends o {
        f() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            Object obj = bundle.get(str);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer j(String str) throws NumberFormatException {
            int i;
            AbstractC13042fc3.i(str, "value");
            if (AbstractC20153rZ6.S(str, "0x", false, 2, null)) {
                String strSubstring = str.substring(2);
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                i = Integer.parseInt(strSubstring, AbstractC10868cL0.a(16));
            } else {
                i = Integer.parseInt(str);
            }
            return Integer.valueOf(i);
        }

        public void k(Bundle bundle, String str, int i) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putInt(str, i);
        }
    }

    public static final class g extends o {
        g() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public long[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public long[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            return new long[]{((Number) o.g.j(str)).longValue()};
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public long[] g(String str, long[] jArr) {
            long[] jArrD;
            AbstractC13042fc3.i(str, "value");
            return (jArr == null || (jArrD = AbstractC9648aK.D(jArr, f(str))) == null) ? f(str) : jArrD;
        }

        @Override // androidx.navigation.o
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, long[] jArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putLongArray(str, jArr);
        }
    }

    public static final class h extends o {
        h() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).longValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            Object obj = bundle.get(str);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Long");
            return (Long) obj;
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Long j(String str) throws NumberFormatException {
            String strSubstring;
            long j;
            AbstractC13042fc3.i(str, "value");
            if (AbstractC20153rZ6.C(str, TokenNames.L, false, 2, null)) {
                strSubstring = str.substring(0, str.length() - 1);
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = str;
            }
            if (AbstractC20153rZ6.S(str, "0x", false, 2, null)) {
                String strSubstring2 = strSubstring.substring(2);
                AbstractC13042fc3.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
                j = Long.parseLong(strSubstring2, AbstractC10868cL0.a(16));
            } else {
                j = Long.parseLong(strSubstring);
            }
            return Long.valueOf(j);
        }

        public void k(Bundle bundle, String str, long j) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putLong(str, j);
        }
    }

    public static final class i extends o {
        i() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "reference";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            Object obj = bundle.get(str);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return (Integer) obj;
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer j(String str) throws NumberFormatException {
            int i;
            AbstractC13042fc3.i(str, "value");
            if (AbstractC20153rZ6.S(str, "0x", false, 2, null)) {
                String strSubstring = str.substring(2);
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                i = Integer.parseInt(strSubstring, AbstractC10868cL0.a(16));
            } else {
                i = Integer.parseInt(str);
            }
            return Integer.valueOf(i);
        }

        public void k(Bundle bundle, String str, int i) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putInt(str, i);
        }
    }

    public static final class j extends o {
        j() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string[]";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            return new String[]{str};
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public String[] g(String str, String[] strArr) {
            String[] strArr2;
            AbstractC13042fc3.i(str, "value");
            return (strArr == null || (strArr2 = (String[]) AbstractC9648aK.F(strArr, f(str))) == null) ? f(str) : strArr2;
        }

        @Override // androidx.navigation.o
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, String[] strArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putStringArray(str, strArr);
        }
    }

    public static final class k extends o {
        k() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string";
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.o
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String j(String str) {
            AbstractC13042fc3.i(str, "value");
            if (AbstractC13042fc3.d(str, "null")) {
                return null;
            }
            return str;
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, String str2) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            bundle.putString(str, str2);
        }
    }

    public static final class l {
        private l() {
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.navigation.o a(java.lang.Object r4) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.o.l.a(java.lang.Object):androidx.navigation.o");
        }

        public /* synthetic */ l(ED1 ed1) {
            this();
        }
    }

    public static final class m extends q {
        private final Class p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Class cls) {
            super(false, cls);
            AbstractC13042fc3.i(cls, "type");
            if (cls.isEnum()) {
                this.p = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.o.q, androidx.navigation.o
        public String b() {
            String name = this.p.getName();
            AbstractC13042fc3.h(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o.q
        /* renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Enum j(String str) {
            Object obj;
            AbstractC13042fc3.i(str, "value");
            Object[] enumConstants = this.p.getEnumConstants();
            AbstractC13042fc3.h(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i];
                if (AbstractC20153rZ6.D(((Enum) obj).name(), str, true)) {
                    break;
                }
                i++;
            }
            Enum r3 = (Enum) obj;
            if (r3 != null) {
                return r3;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.p.getName() + '.');
        }
    }

    public static final class n extends o {
        private final Class o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Class cls) throws ClassNotFoundException {
            super(true);
            AbstractC13042fc3.i(cls, "type");
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
            try {
                Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                AbstractC13042fc3.g(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                this.o = cls2;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.o.getName();
            AbstractC13042fc3.h(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !AbstractC13042fc3.d(n.class, obj.getClass())) {
                return false;
            }
            return AbstractC13042fc3.d(this.o, ((n) obj).o);
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Parcelable[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Parcelable[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, Parcelable[] parcelableArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            this.o.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    /* renamed from: androidx.navigation.o$o, reason: collision with other inner class name */
    public static final class C0107o extends o {
        private final Class o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0107o(Class cls) {
            super(true);
            AbstractC13042fc3.i(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public Object a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return bundle.get(str);
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.o.getName();
            AbstractC13042fc3.h(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !AbstractC13042fc3.d(C0107o.class, obj.getClass())) {
                return false;
            }
            return AbstractC13042fc3.d(this.o, ((C0107o) obj).o);
        }

        @Override // androidx.navigation.o
        /* renamed from: f */
        public Object j(String str) {
            AbstractC13042fc3.i(str, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.o
        public void h(Bundle bundle, String str, Object obj) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            this.o.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }

        public int hashCode() {
            return this.o.hashCode();
        }
    }

    public static final class p extends o {
        private final Class o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Class cls) throws ClassNotFoundException {
            super(true);
            AbstractC13042fc3.i(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
            try {
                Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                AbstractC13042fc3.g(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                this.o = cls2;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.o.getName();
            AbstractC13042fc3.h(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !AbstractC13042fc3.d(p.class, obj.getClass())) {
                return false;
            }
            return AbstractC13042fc3.d(this.o, ((p) obj).o);
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Serializable[] a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Serializable[] j(String str) {
            AbstractC13042fc3.i(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, Serializable[] serializableArr) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            this.o.cast(serializableArr);
            bundle.putSerializable(str, serializableArr);
        }
    }

    public o(boolean z) {
        this.a = z;
    }

    public abstract Object a(Bundle bundle, String str);

    public abstract String b();

    public boolean c() {
        return this.a;
    }

    public final Object d(Bundle bundle, String str, String str2) {
        AbstractC13042fc3.i(bundle, "bundle");
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "value");
        Object objJ = j(str2);
        h(bundle, str, objJ);
        return objJ;
    }

    public final Object e(Bundle bundle, String str, String str2, Object obj) {
        AbstractC13042fc3.i(bundle, "bundle");
        AbstractC13042fc3.i(str, "key");
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        }
        if (str2 == null) {
            return obj;
        }
        Object objG = g(str2, obj);
        h(bundle, str, objG);
        return objG;
    }

    /* renamed from: f */
    public abstract Object j(String str);

    public Object g(String str, Object obj) {
        AbstractC13042fc3.i(str, "value");
        return j(str);
    }

    public abstract void h(Bundle bundle, String str, Object obj);

    public String toString() {
        return b();
    }

    public static class q extends o {
        private final Class o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Class cls) {
            super(true);
            AbstractC13042fc3.i(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
            if (true ^ cls.isEnum()) {
                this.o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.o.getName();
            AbstractC13042fc3.h(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q) {
                return AbstractC13042fc3.d(this.o, ((q) obj).o);
            }
            return false;
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        @Override // androidx.navigation.o
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Serializable a(Bundle bundle, String str) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.navigation.o
        public Serializable j(String str) {
            AbstractC13042fc3.i(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.o
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String str, Serializable serializable) {
            AbstractC13042fc3.i(bundle, "bundle");
            AbstractC13042fc3.i(str, "key");
            AbstractC13042fc3.i(serializable, "value");
            this.o.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z, Class cls) {
            super(z);
            AbstractC13042fc3.i(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }
}
