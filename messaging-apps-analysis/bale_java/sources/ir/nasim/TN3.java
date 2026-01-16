package ir.nasim;

import ir.nasim.IZ6;
import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public abstract class TN3 implements SerialDescriptor {
    private final String a;
    private final SerialDescriptor b;
    private final SerialDescriptor c;
    private final int d;

    public /* synthetic */ TN3(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, ED1 ed1) {
        this(str, serialDescriptor, serialDescriptor2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String str) {
        AbstractC13042fc3.i(str, "name");
        Integer numO = AbstractC19562qZ6.o(str);
        if (numO != null) {
            return numO.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        return String.valueOf(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TN3)) {
            return false;
        }
        TN3 tn3 = (TN3) obj;
        return AbstractC13042fc3.d(i(), tn3.i()) && AbstractC13042fc3.d(this.b, tn3.b) && AbstractC13042fc3.d(this.c, tn3.c);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC19731qq6 f() {
        return IZ6.c.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i) {
        if (i >= 0) {
            return AbstractC10360bX0.m();
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return SerialDescriptor.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        if (i >= 0) {
            int i2 = i % 2;
            if (i2 == 0) {
                return this.b;
            }
            if (i2 == 1) {
                return this.c;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.b + ", " + this.c + ')';
    }

    private TN3(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.a = str;
        this.b = serialDescriptor;
        this.c = serialDescriptor2;
        this.d = 2;
    }
}
