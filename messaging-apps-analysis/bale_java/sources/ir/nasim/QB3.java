package ir.nasim;

import ir.nasim.IZ6;
import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public abstract class QB3 implements SerialDescriptor {
    private final SerialDescriptor a;
    private final int b;

    public /* synthetic */ QB3(SerialDescriptor serialDescriptor, ED1 ed1) {
        this(serialDescriptor);
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
        throw new IllegalArgumentException(str + " is not a valid list index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        return String.valueOf(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QB3)) {
            return false;
        }
        QB3 qb3 = (QB3) obj;
        return AbstractC13042fc3.d(this.a, qb3.a) && AbstractC13042fc3.d(i(), qb3.i());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC19731qq6 f() {
        return IZ6.b.a;
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
            return this.a;
        }
        throw new IllegalArgumentException(("Illegal index " + i + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + i().hashCode();
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
        return i() + '(' + this.a + ')';
    }

    private QB3(SerialDescriptor serialDescriptor) {
        this.a = serialDescriptor;
        this.b = 1;
    }
}
