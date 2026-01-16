package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.Ik3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5221Ik3 extends JsonPrimitive {
    private final boolean a;
    private final SerialDescriptor b;
    private final String c;

    public /* synthetic */ C5221Ik3(Object obj, boolean z, SerialDescriptor serialDescriptor, int i, ED1 ed1) {
        this(obj, z, (i & 4) != 0 ? null : serialDescriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C5221Ik3.class != obj.getClass()) {
            return false;
        }
        C5221Ik3 c5221Ik3 = (C5221Ik3) obj;
        return i() == c5221Ik3.i() && AbstractC13042fc3.d(f(), c5221Ik3.f());
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String f() {
        return this.c;
    }

    public final SerialDescriptor h() {
        return this.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(i()) * 31) + f().hashCode();
    }

    public boolean i() {
        return this.a;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String toString() {
        if (!i()) {
            return f();
        }
        StringBuilder sb = new StringBuilder();
        SY6.c(sb, f());
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5221Ik3(Object obj, boolean z, SerialDescriptor serialDescriptor) {
        super(null);
        AbstractC13042fc3.i(obj, "body");
        this.a = z;
        this.b = serialDescriptor;
        this.c = obj.toString();
        if (serialDescriptor != null && !serialDescriptor.isInline()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
