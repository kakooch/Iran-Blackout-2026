package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: ir.nasim.Px7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC7010Px7 {
    public static final AbstractC6277Mx7 A;
    public static final AbstractC6277Mx7 B;
    public static final InterfaceC6537Nx7 C;
    public static final AbstractC6277Mx7 D;
    public static final InterfaceC6537Nx7 E;
    public static final AbstractC6277Mx7 F;
    public static final InterfaceC6537Nx7 G;
    public static final AbstractC6277Mx7 H;
    public static final InterfaceC6537Nx7 I;
    public static final AbstractC6277Mx7 J;
    public static final InterfaceC6537Nx7 K;
    public static final AbstractC6277Mx7 L;
    public static final InterfaceC6537Nx7 M;
    public static final AbstractC6277Mx7 N;
    public static final InterfaceC6537Nx7 O;
    public static final AbstractC6277Mx7 P;
    public static final InterfaceC6537Nx7 Q;
    public static final AbstractC6277Mx7 R;
    public static final InterfaceC6537Nx7 S;
    public static final AbstractC6277Mx7 T;
    public static final InterfaceC6537Nx7 U;
    public static final AbstractC6277Mx7 V;
    public static final InterfaceC6537Nx7 W;
    public static final InterfaceC6537Nx7 X;
    public static final AbstractC6277Mx7 a;
    public static final InterfaceC6537Nx7 b;
    public static final AbstractC6277Mx7 c;
    public static final InterfaceC6537Nx7 d;
    public static final AbstractC6277Mx7 e;
    public static final AbstractC6277Mx7 f;
    public static final InterfaceC6537Nx7 g;
    public static final AbstractC6277Mx7 h;
    public static final InterfaceC6537Nx7 i;
    public static final AbstractC6277Mx7 j;
    public static final InterfaceC6537Nx7 k;
    public static final AbstractC6277Mx7 l;
    public static final InterfaceC6537Nx7 m;
    public static final AbstractC6277Mx7 n;
    public static final InterfaceC6537Nx7 o;
    public static final AbstractC6277Mx7 p;
    public static final InterfaceC6537Nx7 q;
    public static final AbstractC6277Mx7 r;
    public static final InterfaceC6537Nx7 s;
    public static final AbstractC6277Mx7 t;
    public static final AbstractC6277Mx7 u;
    public static final AbstractC6277Mx7 v;
    public static final AbstractC6277Mx7 w;
    public static final InterfaceC6537Nx7 x;
    public static final AbstractC6277Mx7 y;
    public static final AbstractC6277Mx7 z;

    /* renamed from: ir.nasim.Px7$A */
    class A implements InterfaceC6537Nx7 {
        final /* synthetic */ Class a;
        final /* synthetic */ AbstractC6277Mx7 b;

        /* renamed from: ir.nasim.Px7$A$a */
        class a extends AbstractC6277Mx7 {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // ir.nasim.AbstractC6277Mx7
            public Object b(C12523el3 c12523el3) {
                Object objB = A.this.b.b(c12523el3);
                if (objB == null || this.a.isInstance(objB)) {
                    return objB;
                }
                throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + objB.getClass().getName() + "; at path " + c12523el3.k());
            }

            @Override // ir.nasim.AbstractC6277Mx7
            public void d(C22155ul3 c22155ul3, Object obj) {
                A.this.b.d(c22155ul3, obj);
            }
        }

        A(Class cls, AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = cls;
            this.b = abstractC6277Mx7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            Class<?> clsC = typeToken.c();
            if (this.a.isAssignableFrom(clsC)) {
                return new a(clsC);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    /* renamed from: ir.nasim.Px7$B */
    static /* synthetic */ class B {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16723ll3.values().length];
            a = iArr;
            try {
                iArr[EnumC16723ll3.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC16723ll3.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC16723ll3.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC16723ll3.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC16723ll3.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC16723ll3.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: ir.nasim.Px7$C */
    class C extends AbstractC6277Mx7 {
        C() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(C12523el3 c12523el3) throws IOException {
            EnumC16723ll3 enumC16723ll3G = c12523el3.G();
            if (enumC16723ll3G != EnumC16723ll3.NULL) {
                return enumC16723ll3G == EnumC16723ll3.STRING ? Boolean.valueOf(Boolean.parseBoolean(c12523el3.T0())) : Boolean.valueOf(c12523el3.q());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Boolean bool) throws IOException {
            c22155ul3.T(bool);
        }
    }

    /* renamed from: ir.nasim.Px7$D */
    class D extends AbstractC6277Mx7 {
        D() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Boolean.valueOf(c12523el3.T0());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Boolean bool) throws IOException {
            c22155ul3.X(bool == null ? "null" : bool.toString());
        }
    }

    /* renamed from: ir.nasim.Px7$E */
    class E extends AbstractC6277Mx7 {
        E() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            try {
                int iR0 = c12523el3.r0();
                if (iR0 <= 255 && iR0 >= -128) {
                    return Byte.valueOf((byte) iR0);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iR0 + " to byte; at path " + c12523el3.k());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.S(number.byteValue());
            }
        }
    }

    /* renamed from: ir.nasim.Px7$F */
    class F extends AbstractC6277Mx7 {
        F() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            try {
                int iR0 = c12523el3.r0();
                if (iR0 <= 65535 && iR0 >= -32768) {
                    return Short.valueOf((short) iR0);
                }
                throw new JsonSyntaxException("Lossy conversion from " + iR0 + " to short; at path " + c12523el3.k());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.S(number.shortValue());
            }
        }
    }

    /* renamed from: ir.nasim.Px7$G */
    class G extends AbstractC6277Mx7 {
        G() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            try {
                return Integer.valueOf(c12523el3.r0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.S(number.intValue());
            }
        }
    }

    /* renamed from: ir.nasim.Px7$H */
    class H extends AbstractC6277Mx7 {
        H() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(C12523el3 c12523el3) {
            try {
                return new AtomicInteger(c12523el3.r0());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AtomicInteger atomicInteger) throws IOException {
            c22155ul3.S(atomicInteger.get());
        }
    }

    /* renamed from: ir.nasim.Px7$I */
    class I extends AbstractC6277Mx7 {
        I() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(C12523el3 c12523el3) {
            return new AtomicBoolean(c12523el3.q());
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AtomicBoolean atomicBoolean) throws IOException {
            c22155ul3.Z(atomicBoolean.get());
        }
    }

    /* renamed from: ir.nasim.Px7$J */
    private static final class J extends AbstractC6277Mx7 {
        private final Map a = new HashMap();
        private final Map b = new HashMap();
        private final Map c = new HashMap();

        /* renamed from: ir.nasim.Px7$J$a */
        class a implements PrivilegedAction {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() throws SecurityException {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public J(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    InterfaceC23984xq6 interfaceC23984xq6 = (InterfaceC23984xq6) field.getAnnotation(InterfaceC23984xq6.class);
                    if (interfaceC23984xq6 != null) {
                        strName = interfaceC23984xq6.value();
                        for (String str : interfaceC23984xq6.alternate()) {
                            this.a.put(str, r4);
                        }
                    }
                    this.a.put(strName, r4);
                    this.b.put(string, r4);
                    this.c.put(r4, strName);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Enum b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            Enum r0 = (Enum) this.a.get(strT0);
            return r0 == null ? (Enum) this.b.get(strT0) : r0;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Enum r3) throws IOException {
            c22155ul3.X(r3 == null ? null : (String) this.c.get(r3));
        }
    }

    /* renamed from: ir.nasim.Px7$a, reason: case insensitive filesystem */
    class C7011a extends AbstractC6277Mx7 {
        C7011a() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(C12523el3 c12523el3) throws IOException {
            ArrayList arrayList = new ArrayList();
            c12523el3.a();
            while (c12523el3.l()) {
                try {
                    arrayList.add(Integer.valueOf(c12523el3.r0()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            c12523el3.e();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AtomicIntegerArray atomicIntegerArray) throws IOException {
            c22155ul3.c();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                c22155ul3.S(atomicIntegerArray.get(i));
            }
            c22155ul3.g();
        }
    }

    /* renamed from: ir.nasim.Px7$b, reason: case insensitive filesystem */
    class C7012b extends AbstractC6277Mx7 {
        C7012b() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            try {
                return Long.valueOf(c12523el3.K1());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.S(number.longValue());
            }
        }
    }

    /* renamed from: ir.nasim.Px7$c, reason: case insensitive filesystem */
    class C7013c extends AbstractC6277Mx7 {
        C7013c() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Float.valueOf((float) c12523el3.f1());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            c22155ul3.U(number);
        }
    }

    /* renamed from: ir.nasim.Px7$d, reason: case insensitive filesystem */
    class C7014d extends AbstractC6277Mx7 {
        C7014d() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Double.valueOf(c12523el3.f1());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.P(number.doubleValue());
            }
        }
    }

    /* renamed from: ir.nasim.Px7$e, reason: case insensitive filesystem */
    class C7015e extends AbstractC6277Mx7 {
        C7015e() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            if (strT0.length() == 1) {
                return Character.valueOf(strT0.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + strT0 + "; at " + c12523el3.k());
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Character ch) throws IOException {
            c22155ul3.X(ch == null ? null : String.valueOf(ch));
        }
    }

    /* renamed from: ir.nasim.Px7$f, reason: case insensitive filesystem */
    class C7016f extends AbstractC6277Mx7 {
        C7016f() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(C12523el3 c12523el3) throws IOException {
            EnumC16723ll3 enumC16723ll3G = c12523el3.G();
            if (enumC16723ll3G != EnumC16723ll3.NULL) {
                return enumC16723ll3G == EnumC16723ll3.BOOLEAN ? Boolean.toString(c12523el3.q()) : c12523el3.T0();
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, String str) throws IOException {
            c22155ul3.X(str);
        }
    }

    /* renamed from: ir.nasim.Px7$g, reason: case insensitive filesystem */
    class C7017g extends AbstractC6277Mx7 {
        C7017g() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            try {
                return new BigDecimal(strT0);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as BigDecimal; at path " + c12523el3.k(), e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, BigDecimal bigDecimal) throws IOException {
            c22155ul3.U(bigDecimal);
        }
    }

    /* renamed from: ir.nasim.Px7$h, reason: case insensitive filesystem */
    class C7018h extends AbstractC6277Mx7 {
        C7018h() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            try {
                return new BigInteger(strT0);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as BigInteger; at path " + c12523el3.k(), e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, BigInteger bigInteger) throws IOException {
            c22155ul3.U(bigInteger);
        }
    }

    /* renamed from: ir.nasim.Px7$i, reason: case insensitive filesystem */
    class C7019i extends AbstractC6277Mx7 {
        C7019i() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C8632Wu3 b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return new C8632Wu3(c12523el3.T0());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, C8632Wu3 c8632Wu3) throws IOException {
            c22155ul3.U(c8632Wu3);
        }
    }

    /* renamed from: ir.nasim.Px7$j, reason: case insensitive filesystem */
    class C7020j extends AbstractC6277Mx7 {
        C7020j() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return new StringBuilder(c12523el3.T0());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, StringBuilder sb) throws IOException {
            c22155ul3.X(sb == null ? null : sb.toString());
        }
    }

    /* renamed from: ir.nasim.Px7$k */
    class k extends AbstractC6277Mx7 {
        k() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(C12523el3 c12523el3) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* renamed from: ir.nasim.Px7$l */
    class l extends AbstractC6277Mx7 {
        l() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return new StringBuffer(c12523el3.T0());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, StringBuffer stringBuffer) throws IOException {
            c22155ul3.X(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: ir.nasim.Px7$m */
    class m extends AbstractC6277Mx7 {
        m() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            if ("null".equals(strT0)) {
                return null;
            }
            return new URL(strT0);
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, URL url) throws IOException {
            c22155ul3.X(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: ir.nasim.Px7$n */
    class n extends AbstractC6277Mx7 {
        n() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            try {
                String strT0 = c12523el3.T0();
                if ("null".equals(strT0)) {
                    return null;
                }
                return new URI(strT0);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, URI uri) throws IOException {
            c22155ul3.X(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: ir.nasim.Px7$o */
    class o extends AbstractC6277Mx7 {
        o() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return InetAddress.getByName(c12523el3.T0());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, InetAddress inetAddress) throws IOException {
            c22155ul3.X(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* renamed from: ir.nasim.Px7$p */
    class p extends AbstractC6277Mx7 {
        p() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            String strT0 = c12523el3.T0();
            try {
                return UUID.fromString(strT0);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as UUID; at path " + c12523el3.k(), e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, UUID uuid) throws IOException {
            c22155ul3.X(uuid == null ? null : uuid.toString());
        }
    }

    /* renamed from: ir.nasim.Px7$q */
    class q extends AbstractC6277Mx7 {
        q() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(C12523el3 c12523el3) throws IOException {
            String strT0 = c12523el3.T0();
            try {
                return Currency.getInstance(strT0);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as Currency; at path " + c12523el3.k(), e);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Currency currency) throws IOException {
            c22155ul3.X(currency.getCurrencyCode());
        }
    }

    /* renamed from: ir.nasim.Px7$r */
    class r extends AbstractC6277Mx7 {
        r() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(C12523el3 c12523el3) throws IOException, NumberFormatException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            c12523el3.B();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (c12523el3.G() != EnumC16723ll3.END_OBJECT) {
                String strN0 = c12523el3.n0();
                int iR0 = c12523el3.r0();
                if ("year".equals(strN0)) {
                    i = iR0;
                } else if ("month".equals(strN0)) {
                    i2 = iR0;
                } else if ("dayOfMonth".equals(strN0)) {
                    i3 = iR0;
                } else if ("hourOfDay".equals(strN0)) {
                    i4 = iR0;
                } else if ("minute".equals(strN0)) {
                    i5 = iR0;
                } else if ("second".equals(strN0)) {
                    i6 = iR0;
                }
            }
            c12523el3.F();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Calendar calendar) throws IOException {
            if (calendar == null) {
                c22155ul3.s();
                return;
            }
            c22155ul3.d();
            c22155ul3.p("year");
            c22155ul3.S(calendar.get(1));
            c22155ul3.p("month");
            c22155ul3.S(calendar.get(2));
            c22155ul3.p("dayOfMonth");
            c22155ul3.S(calendar.get(5));
            c22155ul3.p("hourOfDay");
            c22155ul3.S(calendar.get(11));
            c22155ul3.p("minute");
            c22155ul3.S(calendar.get(12));
            c22155ul3.p("second");
            c22155ul3.S(calendar.get(13));
            c22155ul3.j();
        }
    }

    /* renamed from: ir.nasim.Px7$s */
    class s extends AbstractC6277Mx7 {
        s() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(c12523el3.T0(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Locale locale) throws IOException {
            c22155ul3.X(locale == null ? null : locale.toString());
        }
    }

    /* renamed from: ir.nasim.Px7$t */
    class t extends AbstractC6277Mx7 {
        t() {
        }

        private AbstractC22735vk3 f(C12523el3 c12523el3, EnumC16723ll3 enumC16723ll3) throws IOException {
            int i = B.a[enumC16723ll3.ordinal()];
            if (i == 1) {
                return new C9906al3(new C8632Wu3(c12523el3.T0()));
            }
            if (i == 2) {
                return new C9906al3(c12523el3.T0());
            }
            if (i == 3) {
                return new C9906al3(Boolean.valueOf(c12523el3.q()));
            }
            if (i == 6) {
                c12523el3.u();
                return C8074Uk3.a;
            }
            throw new IllegalStateException("Unexpected token: " + enumC16723ll3);
        }

        private AbstractC22735vk3 g(C12523el3 c12523el3, EnumC16723ll3 enumC16723ll3) throws IOException {
            int i = B.a[enumC16723ll3.ordinal()];
            if (i == 4) {
                c12523el3.a();
                return new C13149fk3();
            }
            if (i != 5) {
                return null;
            }
            c12523el3.B();
            return new C8542Wk3();
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AbstractC22735vk3 b(C12523el3 c12523el3) throws IOException {
            EnumC16723ll3 enumC16723ll3G = c12523el3.G();
            AbstractC22735vk3 abstractC22735vk3G = g(c12523el3, enumC16723ll3G);
            if (abstractC22735vk3G == null) {
                return f(c12523el3, enumC16723ll3G);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (c12523el3.l()) {
                    String strN0 = abstractC22735vk3G instanceof C8542Wk3 ? c12523el3.n0() : null;
                    EnumC16723ll3 enumC16723ll3G2 = c12523el3.G();
                    AbstractC22735vk3 abstractC22735vk3G2 = g(c12523el3, enumC16723ll3G2);
                    boolean z = abstractC22735vk3G2 != null;
                    if (abstractC22735vk3G2 == null) {
                        abstractC22735vk3G2 = f(c12523el3, enumC16723ll3G2);
                    }
                    if (abstractC22735vk3G instanceof C13149fk3) {
                        ((C13149fk3) abstractC22735vk3G).C(abstractC22735vk3G2);
                    } else {
                        ((C8542Wk3) abstractC22735vk3G).C(strN0, abstractC22735vk3G2);
                    }
                    if (z) {
                        arrayDeque.addLast(abstractC22735vk3G);
                        abstractC22735vk3G = abstractC22735vk3G2;
                    }
                } else {
                    if (abstractC22735vk3G instanceof C13149fk3) {
                        c12523el3.e();
                    } else {
                        c12523el3.F();
                    }
                    if (arrayDeque.isEmpty()) {
                        return abstractC22735vk3G;
                    }
                    abstractC22735vk3G = (AbstractC22735vk3) arrayDeque.removeLast();
                }
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AbstractC22735vk3 abstractC22735vk3) throws IOException {
            if (abstractC22735vk3 == null || abstractC22735vk3.x()) {
                c22155ul3.s();
                return;
            }
            if (abstractC22735vk3.B()) {
                C9906al3 c9906al3R = abstractC22735vk3.r();
                if (c9906al3R.F()) {
                    c22155ul3.U(c9906al3R.C());
                    return;
                } else if (c9906al3R.D()) {
                    c22155ul3.Z(c9906al3R.f());
                    return;
                } else {
                    c22155ul3.X(c9906al3R.v());
                    return;
                }
            }
            if (abstractC22735vk3.w()) {
                c22155ul3.c();
                Iterator it = abstractC22735vk3.j().iterator();
                while (it.hasNext()) {
                    d(c22155ul3, (AbstractC22735vk3) it.next());
                }
                c22155ul3.g();
                return;
            }
            if (!abstractC22735vk3.A()) {
                throw new IllegalArgumentException("Couldn't write " + abstractC22735vk3.getClass());
            }
            c22155ul3.d();
            for (Map.Entry entry : abstractC22735vk3.o().I()) {
                c22155ul3.p((String) entry.getKey());
                d(c22155ul3, (AbstractC22735vk3) entry.getValue());
            }
            c22155ul3.j();
        }
    }

    /* renamed from: ir.nasim.Px7$u */
    class u implements InterfaceC6537Nx7 {
        u() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            Class clsC = typeToken.c();
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new J(clsC);
        }
    }

    /* renamed from: ir.nasim.Px7$v */
    class v extends AbstractC6277Mx7 {
        v() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BitSet b(C12523el3 c12523el3) throws IOException, NumberFormatException {
            BitSet bitSet = new BitSet();
            c12523el3.a();
            EnumC16723ll3 enumC16723ll3G = c12523el3.G();
            int i = 0;
            while (enumC16723ll3G != EnumC16723ll3.END_ARRAY) {
                int i2 = B.a[enumC16723ll3G.ordinal()];
                boolean zQ = true;
                if (i2 == 1 || i2 == 2) {
                    int iR0 = c12523el3.r0();
                    if (iR0 == 0) {
                        zQ = false;
                    } else if (iR0 != 1) {
                        throw new JsonSyntaxException("Invalid bitset value " + iR0 + ", expected 0 or 1; at path " + c12523el3.k());
                    }
                } else {
                    if (i2 != 3) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + enumC16723ll3G + "; at path " + c12523el3.A());
                    }
                    zQ = c12523el3.q();
                }
                if (zQ) {
                    bitSet.set(i);
                }
                i++;
                enumC16723ll3G = c12523el3.G();
            }
            c12523el3.e();
            return bitSet;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, BitSet bitSet) throws IOException {
            c22155ul3.c();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                c22155ul3.S(bitSet.get(i) ? 1L : 0L);
            }
            c22155ul3.g();
        }
    }

    /* renamed from: ir.nasim.Px7$w */
    class w implements InterfaceC6537Nx7 {
        final /* synthetic */ TypeToken a;
        final /* synthetic */ AbstractC6277Mx7 b;

        w(TypeToken typeToken, AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = typeToken;
            this.b = abstractC6277Mx7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            if (typeToken.equals(this.a)) {
                return this.b;
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.Px7$x */
    class x implements InterfaceC6537Nx7 {
        final /* synthetic */ Class a;
        final /* synthetic */ AbstractC6277Mx7 b;

        x(Class cls, AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = cls;
            this.b = abstractC6277Mx7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            if (typeToken.c() == this.a) {
                return this.b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    /* renamed from: ir.nasim.Px7$y */
    class y implements InterfaceC6537Nx7 {
        final /* synthetic */ Class a;
        final /* synthetic */ Class b;
        final /* synthetic */ AbstractC6277Mx7 c;

        y(Class cls, Class cls2, AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = cls;
            this.b = cls2;
            this.c = abstractC6277Mx7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            Class clsC = typeToken.c();
            if (clsC == this.a || clsC == this.b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
        }
    }

    /* renamed from: ir.nasim.Px7$z */
    class z implements InterfaceC6537Nx7 {
        final /* synthetic */ Class a;
        final /* synthetic */ Class b;
        final /* synthetic */ AbstractC6277Mx7 c;

        z(Class cls, Class cls2, AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = cls;
            this.b = cls2;
            this.c = abstractC6277Mx7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            Class clsC = typeToken.c();
            if (clsC == this.a || clsC == this.b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
        }
    }

    static {
        AbstractC6277Mx7 abstractC6277Mx7A = new k().a();
        a = abstractC6277Mx7A;
        b = b(Class.class, abstractC6277Mx7A);
        AbstractC6277Mx7 abstractC6277Mx7A2 = new v().a();
        c = abstractC6277Mx7A2;
        d = b(BitSet.class, abstractC6277Mx7A2);
        C c2 = new C();
        e = c2;
        f = new D();
        g = c(Boolean.TYPE, Boolean.class, c2);
        E e2 = new E();
        h = e2;
        i = c(Byte.TYPE, Byte.class, e2);
        F f2 = new F();
        j = f2;
        k = c(Short.TYPE, Short.class, f2);
        G g2 = new G();
        l = g2;
        m = c(Integer.TYPE, Integer.class, g2);
        AbstractC6277Mx7 abstractC6277Mx7A3 = new H().a();
        n = abstractC6277Mx7A3;
        o = b(AtomicInteger.class, abstractC6277Mx7A3);
        AbstractC6277Mx7 abstractC6277Mx7A4 = new I().a();
        p = abstractC6277Mx7A4;
        q = b(AtomicBoolean.class, abstractC6277Mx7A4);
        AbstractC6277Mx7 abstractC6277Mx7A5 = new C7011a().a();
        r = abstractC6277Mx7A5;
        s = b(AtomicIntegerArray.class, abstractC6277Mx7A5);
        t = new C7012b();
        u = new C7013c();
        v = new C7014d();
        C7015e c7015e = new C7015e();
        w = c7015e;
        x = c(Character.TYPE, Character.class, c7015e);
        C7016f c7016f = new C7016f();
        y = c7016f;
        z = new C7017g();
        A = new C7018h();
        B = new C7019i();
        C = b(String.class, c7016f);
        C7020j c7020j = new C7020j();
        D = c7020j;
        E = b(StringBuilder.class, c7020j);
        l lVar = new l();
        F = lVar;
        G = b(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = b(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = b(URI.class, nVar);
        o oVar = new o();
        L = oVar;
        M = e(InetAddress.class, oVar);
        p pVar = new p();
        N = pVar;
        O = b(UUID.class, pVar);
        AbstractC6277Mx7 abstractC6277Mx7A6 = new q().a();
        P = abstractC6277Mx7A6;
        Q = b(Currency.class, abstractC6277Mx7A6);
        r rVar = new r();
        R = rVar;
        S = d(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = b(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = e(AbstractC22735vk3.class, tVar);
        X = new u();
    }

    public static InterfaceC6537Nx7 a(TypeToken typeToken, AbstractC6277Mx7 abstractC6277Mx7) {
        return new w(typeToken, abstractC6277Mx7);
    }

    public static InterfaceC6537Nx7 b(Class cls, AbstractC6277Mx7 abstractC6277Mx7) {
        return new x(cls, abstractC6277Mx7);
    }

    public static InterfaceC6537Nx7 c(Class cls, Class cls2, AbstractC6277Mx7 abstractC6277Mx7) {
        return new y(cls, cls2, abstractC6277Mx7);
    }

    public static InterfaceC6537Nx7 d(Class cls, Class cls2, AbstractC6277Mx7 abstractC6277Mx7) {
        return new z(cls, cls2, abstractC6277Mx7);
    }

    public static InterfaceC6537Nx7 e(Class cls, AbstractC6277Mx7 abstractC6277Mx7) {
        return new A(cls, abstractC6277Mx7);
    }
}
