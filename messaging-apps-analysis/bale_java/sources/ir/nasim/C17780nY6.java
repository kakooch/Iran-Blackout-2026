package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC19731qq6;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.JsonElement;

/* renamed from: ir.nasim.nY6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C17780nY6 extends kotlinx.serialization.encoding.a implements InterfaceC20277rk3 {
    private final AbstractC11279ck3 a;
    private final Gb8 b;
    public final Z0 c;
    private final AbstractC3859Cq6 d;
    private int e;
    private a f;
    private final C15531jk3 g;
    private final C23921xk3 h;

    /* renamed from: ir.nasim.nY6$a */
    public static final class a {
        public String a;

        public a(String str) {
            this.a = str;
        }
    }

    /* renamed from: ir.nasim.nY6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Gb8.values().length];
            try {
                iArr[Gb8.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gb8.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Gb8.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Gb8.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public C17780nY6(AbstractC11279ck3 abstractC11279ck3, Gb8 gb8, Z0 z0, SerialDescriptor serialDescriptor, a aVar) {
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(gb8, "mode");
        AbstractC13042fc3.i(z0, "lexer");
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        this.a = abstractC11279ck3;
        this.b = gb8;
        this.c = z0;
        this.d = abstractC11279ck3.a();
        this.e = -1;
        this.f = aVar;
        C15531jk3 c15531jk3D = abstractC11279ck3.d();
        this.g = c15531jk3D;
        this.h = c15531jk3D.i() ? null : new C23921xk3(serialDescriptor);
    }

    private final void K() {
        if (this.c.F() != 4) {
            return;
        }
        Z0.x(this.c, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean L(SerialDescriptor serialDescriptor, int i) {
        String strG;
        AbstractC11279ck3 abstractC11279ck3 = this.a;
        if (!serialDescriptor.j(i)) {
            return false;
        }
        SerialDescriptor serialDescriptorH = serialDescriptor.h(i);
        if (serialDescriptorH.b() || !this.c.N(true)) {
            if (!AbstractC13042fc3.d(serialDescriptorH.f(), AbstractC19731qq6.b.a)) {
                return false;
            }
            if ((serialDescriptorH.b() && this.c.N(false)) || (strG = this.c.G(this.g.p())) == null || AbstractC7601Sk3.h(serialDescriptorH, abstractC11279ck3, strG) != -3) {
                return false;
            }
            this.c.o();
        }
        return true;
    }

    private final int M() {
        boolean zM = this.c.M();
        if (!this.c.e()) {
            if (!zM || this.a.d().c()) {
                return -1;
            }
            AbstractC3802Ck3.g(this.c, "array");
            throw new KotlinNothingValueException();
        }
        int i = this.e;
        if (i != -1 && !zM) {
            Z0.x(this.c, "Expected end of the array or comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i2 = i + 1;
        this.e = i2;
        return i2;
    }

    private final int N() {
        int i = this.e;
        boolean zM = false;
        boolean z = i % 2 != 0;
        if (!z) {
            this.c.l(':');
        } else if (i != -1) {
            zM = this.c.M();
        }
        if (!this.c.e()) {
            if (!zM || this.a.d().c()) {
                return -1;
            }
            AbstractC3802Ck3.h(this.c, null, 1, null);
            throw new KotlinNothingValueException();
        }
        if (z) {
            if (this.e == -1) {
                Z0 z0 = this.c;
                boolean z2 = !zM;
                int i2 = z0.a;
                if (!z2) {
                    Z0.x(z0, "Unexpected leading comma", i2, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                Z0 z02 = this.c;
                int i3 = z02.a;
                if (!zM) {
                    Z0.x(z02, "Expected comma after the key-value pair", i3, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        int i4 = this.e + 1;
        this.e = i4;
        return i4;
    }

    private final int O(SerialDescriptor serialDescriptor) {
        int iH;
        boolean zM;
        boolean zM2 = this.c.M();
        while (true) {
            boolean z = true;
            if (!this.c.e()) {
                if (zM2 && !this.a.d().c()) {
                    AbstractC3802Ck3.h(this.c, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                C23921xk3 c23921xk3 = this.h;
                if (c23921xk3 != null) {
                    return c23921xk3.d();
                }
                return -1;
            }
            String strP = P();
            this.c.l(':');
            iH = AbstractC7601Sk3.h(serialDescriptor, this.a, strP);
            if (iH == -3) {
                zM = false;
            } else {
                if (!this.g.f() || !L(serialDescriptor, iH)) {
                    break;
                }
                zM = this.c.M();
                z = false;
            }
            zM2 = z ? Q(strP) : zM;
        }
        C23921xk3 c23921xk32 = this.h;
        if (c23921xk32 != null) {
            c23921xk32.c(iH);
        }
        return iH;
    }

    private final String P() {
        return this.g.p() ? this.c.r() : this.c.i();
    }

    private final boolean Q(String str) {
        if (this.g.j() || S(this.f, str)) {
            this.c.I(this.g.p());
        } else {
            this.c.A(str);
        }
        return this.c.M();
    }

    private final void R(SerialDescriptor serialDescriptor) {
        while (o(serialDescriptor) != -1) {
        }
    }

    private final boolean S(a aVar, String str) {
        if (aVar == null || !AbstractC13042fc3.d(aVar.a, str)) {
            return false;
        }
        aVar.a = null;
        return true;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public boolean C() {
        C23921xk3 c23921xk3 = this.h;
        return ((c23921xk3 != null ? c23921xk3.b() : false) || Z0.O(this.c, false, 1, null)) ? false : true;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.c
    public Object E(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(xi1, "deserializer");
        boolean z = this.b == Gb8.e && (i & 1) == 0;
        if (z) {
            this.c.b.d();
        }
        Object objE = super.E(serialDescriptor, i, xi1, obj);
        if (z) {
            this.c.b.f(objE);
        }
        return objE;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public byte G() {
        long jM = this.c.m();
        byte b2 = (byte) jM;
        if (jM == b2) {
            return b2;
        }
        Z0.x(this.c, "Failed to parse byte for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.c
    public AbstractC3859Cq6 a() {
        return this.d;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        Gb8 gb8B = Hb8.b(this.a, serialDescriptor);
        this.c.b.c(serialDescriptor);
        this.c.l(gb8B.a);
        K();
        int i = b.a[gb8B.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? new C17780nY6(this.a, gb8B, this.c, serialDescriptor, this.f) : (this.b == gb8B && this.a.d().i()) ? this : new C17780nY6(this.a, gb8B, this.c, serialDescriptor, this.f);
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.c
    public void c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        if (this.a.d().j() && serialDescriptor.d() == 0) {
            R(serialDescriptor);
        }
        if (this.c.M() && !this.a.d().c()) {
            AbstractC3802Ck3.g(this.c, "");
            throw new KotlinNothingValueException();
        }
        this.c.l(this.b.b);
        this.c.b.b();
    }

    @Override // ir.nasim.InterfaceC20277rk3
    public final AbstractC11279ck3 d() {
        return this.a;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "enumDescriptor");
        return AbstractC7601Sk3.i(serialDescriptor, this.a, y(), " at path " + this.c.b.a());
    }

    @Override // ir.nasim.InterfaceC20277rk3
    public JsonElement g() {
        return new C19087pl3(this.a.d(), this.c).e();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public int h() {
        long jM = this.c.m();
        int i = (int) jM;
        if (jM == i) {
            return i;
        }
        Z0.x(this.c, "Failed to parse int for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public Object k(XI1 xi1) {
        AbstractC13042fc3.i(xi1, "deserializer");
        try {
            if ((xi1 instanceof AbstractC24673z1) && !this.a.d().o()) {
                String strC = AbstractC13131fi5.c(xi1.getDescriptor(), this.a);
                String strE = this.c.E(strC, this.g.p());
                if (strE == null) {
                    return AbstractC13131fi5.d(this, xi1);
                }
                try {
                    XI1 xi1A = AbstractC14313hi5.a((AbstractC24673z1) xi1, this, strE);
                    AbstractC13042fc3.g(xi1A, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                    this.f = new a(strC);
                    return xi1A.deserialize(this);
                } catch (SerializationException e) {
                    String message = e.getMessage();
                    AbstractC13042fc3.f(message);
                    String strE0 = AbstractC20762sZ6.E0(AbstractC20762sZ6.g1(message, '\n', null, 2, null), Separators.DOT);
                    String message2 = e.getMessage();
                    AbstractC13042fc3.f(message2);
                    Z0.x(this.c, strE0, 0, AbstractC20762sZ6.W0(message2, '\n', ""), 2, null);
                    throw new KotlinNothingValueException();
                }
            }
            return xi1.deserialize(this);
        } catch (MissingFieldException e2) {
            String message3 = e2.getMessage();
            AbstractC13042fc3.f(message3);
            if (AbstractC20762sZ6.X(message3, "at path", false, 2, null)) {
                throw e2;
            }
            throw new MissingFieldException(e2.getMissingFields(), e2.getMessage() + " at path: " + this.c.b.a(), e2);
        }
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public long m() {
        return this.c.m();
    }

    @Override // kotlinx.serialization.encoding.c
    public int o(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        int i = b.a[this.b.ordinal()];
        int iM = i != 2 ? i != 4 ? M() : O(serialDescriptor) : N();
        if (this.b != Gb8.e) {
            this.c.b.g(iM);
        }
        return iM;
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        return AbstractC18962pY6.b(serialDescriptor) ? new C20868sk3(this.c, this.a) : super.q(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public short s() {
        long jM = this.c.m();
        short s = (short) jM;
        if (jM == s) {
            return s;
        }
        Z0.x(this.c, "Failed to parse short for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public float t() throws NumberFormatException {
        Z0 z0 = this.c;
        String strQ = z0.q();
        try {
            float f = Float.parseFloat(strQ);
            if (this.a.d().a() || !(Float.isInfinite(f) || Float.isNaN(f))) {
                return f;
            }
            AbstractC3802Ck3.k(this.c, Float.valueOf(f));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'float' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public double v() throws NumberFormatException {
        Z0 z0 = this.c;
        String strQ = z0.q();
        try {
            double d = Double.parseDouble(strQ);
            if (this.a.d().a() || !(Double.isInfinite(d) || Double.isNaN(d))) {
                return d;
            }
            AbstractC3802Ck3.k(this.c, Double.valueOf(d));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            Z0.x(z0, "Failed to parse type 'double' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public boolean w() {
        return this.c.g();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public char x() {
        String strQ = this.c.q();
        if (strQ.length() == 1) {
            return strQ.charAt(0);
        }
        Z0.x(this.c, "Expected single char, but got '" + strQ + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.a, kotlinx.serialization.encoding.Decoder
    public String y() {
        return this.g.p() ? this.c.r() : this.c.o();
    }
}
