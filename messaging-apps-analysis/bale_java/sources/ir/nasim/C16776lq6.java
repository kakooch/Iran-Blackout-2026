package ir.nasim;

import java.util.List;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.lq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16776lq6 implements SerialDescriptor, InterfaceC8886Xt0 {
    private final SerialDescriptor a;
    private final String b;
    private final Set c;

    public C16776lq6(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "original");
        this.a = serialDescriptor;
        this.b = serialDescriptor.i() + '?';
        this.c = AbstractC4227Ef5.a(serialDescriptor);
    }

    @Override // ir.nasim.InterfaceC8886Xt0
    public Set a() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String str) {
        AbstractC13042fc3.i(str, "name");
        return this.a.c(str);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int i) {
        return this.a.e(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C16776lq6) && AbstractC13042fc3.d(this.a, ((C16776lq6) obj).a);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC19731qq6 f() {
        return this.a.f();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i) {
        return this.a.g(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        return this.a.h(i);
    }

    public int hashCode() {
        return this.a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i) {
        return this.a.j(i);
    }

    public final SerialDescriptor k() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('?');
        return sb.toString();
    }
}
