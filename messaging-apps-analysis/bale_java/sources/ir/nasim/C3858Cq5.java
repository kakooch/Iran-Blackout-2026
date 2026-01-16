package ir.nasim;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Cq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3858Cq5 implements SerialDescriptor {
    private final String a;
    private final AbstractC25167zq5 b;

    public C3858Cq5(String str, AbstractC25167zq5 abstractC25167zq5) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(abstractC25167zq5, "kind");
        this.a = str;
        this.b = abstractC25167zq5;
    }

    private final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String str) {
        AbstractC13042fc3.i(str, "name");
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3858Cq5)) {
            return false;
        }
        C3858Cq5 c3858Cq5 = (C3858Cq5) obj;
        return AbstractC13042fc3.d(i(), c3858Cq5.i()) && AbstractC13042fc3.d(f(), c3858Cq5.f());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return SerialDescriptor.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return i().hashCode() + (f().hashCode() * 31);
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
        a();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC25167zq5 f() {
        return this.b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + i() + ')';
    }
}
