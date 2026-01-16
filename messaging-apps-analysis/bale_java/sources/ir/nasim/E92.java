package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC19731qq6;
import ir.nasim.IZ6;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* loaded from: classes8.dex */
public final class E92 extends PluginGeneratedSerialDescriptor {
    private final AbstractC19731qq6 m;
    private final InterfaceC9173Yu3 n;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ E92 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, String str, E92 e92) {
            super(0);
            this.e = i;
            this.f = str;
            this.g = e92;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor[] invoke() {
            int i = this.e;
            SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i];
            for (int i2 = 0; i2 < i; i2++) {
                serialDescriptorArr[i2] = AbstractC17958nq6.c(this.f + '.' + this.g.e(i2), IZ6.d.a, new SerialDescriptor[0], null, 8, null);
            }
            return serialDescriptorArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E92(String str, int i) {
        super(str, null, i, 2, null);
        AbstractC13042fc3.i(str, "name");
        this.m = AbstractC19731qq6.b.a;
        this.n = AbstractC13269fw3.a(new a(i, str, this));
    }

    private final SerialDescriptor[] t() {
        return (SerialDescriptor[]) this.n.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.f() == AbstractC19731qq6.b.a && AbstractC13042fc3.d(i(), serialDescriptor.i()) && AbstractC13042fc3.d(AbstractC4227Ef5.a(this), AbstractC4227Ef5.a(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC19731qq6 f() {
        return this.m;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i) {
        return t()[i];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int iHashCode = i().hashCode();
        int iHashCode2 = 1;
        for (String str : AbstractC17367mq6.b(this)) {
            int i = iHashCode2 * 31;
            iHashCode2 = i + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        return AbstractC15401jX0.A0(AbstractC17367mq6.b(this), ", ", i() + '(', Separators.RPAREN, 0, null, null, 56, null);
    }
}
