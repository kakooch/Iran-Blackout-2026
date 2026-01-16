package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.NE2;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002\u0011\u001fB+\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Lir/nasim/QH3;", "", "", "seen0", "", "latitude", "longitude", "Lir/nasim/tq6;", "serializationConstructorMarker", "<init>", "(IDDLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "a", "(Lir/nasim/QH3;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "getLatitude", "()D", "b", "getLongitude", "Companion", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.QH3, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class Location {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final double latitude;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final double longitude;

    /* renamed from: ir.nasim.QH3$a */
    public /* synthetic */ class a implements NE2 {
        public static final a a;
        private static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ir.nasim.dialoglist.data.mapper.mappingStrategies.Location", aVar, 2);
            pluginGeneratedSerialDescriptor.l("latitude", false);
            pluginGeneratedSerialDescriptor.l("longitude", false);
            b = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // ir.nasim.XI1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Location deserialize(Decoder decoder) {
            int i;
            double dF;
            double d;
            AbstractC13042fc3.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
            if (cVarB.p()) {
                double dF2 = cVarB.F(serialDescriptor, 0);
                dF = cVarB.F(serialDescriptor, 1);
                d = dF2;
                i = 3;
            } else {
                double dF3 = 0.0d;
                boolean z = true;
                int i2 = 0;
                double dF4 = 0.0d;
                while (z) {
                    int iO = cVarB.o(serialDescriptor);
                    if (iO == -1) {
                        z = false;
                    } else if (iO == 0) {
                        dF4 = cVarB.F(serialDescriptor, 0);
                        i2 |= 1;
                    } else {
                        if (iO != 1) {
                            throw new UnknownFieldException(iO);
                        }
                        dF3 = cVarB.F(serialDescriptor, 1);
                        i2 |= 2;
                    }
                }
                i = i2;
                dF = dF3;
                d = dF4;
            }
            cVarB.c(serialDescriptor);
            return new Location(i, d, dF, null);
        }

        @Override // ir.nasim.InterfaceC22798vq6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, Location location) {
            AbstractC13042fc3.i(encoder, "encoder");
            AbstractC13042fc3.i(location, "value");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
            Location.a(location, dVarB, serialDescriptor);
            dVarB.c(serialDescriptor);
        }

        @Override // ir.nasim.NE2
        public final KSerializer[] childSerializers() {
            C16584lX1 c16584lX1 = C16584lX1.a;
            return new KSerializer[]{c16584lX1, c16584lX1};
        }

        @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // ir.nasim.NE2
        public KSerializer[] typeParametersSerializers() {
            return NE2.a.a(this);
        }
    }

    /* renamed from: ir.nasim.QH3$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer serializer() {
            return a.a;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ Location(int i, double d, double d2, AbstractC21618tq6 abstractC21618tq6) {
        if (3 != (i & 3)) {
            AbstractC19039pg5.a(i, 3, a.a.getDescriptor());
        }
        this.latitude = d;
        this.longitude = d2;
    }

    public static final /* synthetic */ void a(Location self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.D(serialDesc, 0, self.latitude);
        output.D(serialDesc, 1, self.longitude);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location location = (Location) other;
        return Double.compare(this.latitude, location.latitude) == 0 && Double.compare(this.longitude, location.longitude) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude);
    }

    public String toString() {
        return "Location(latitude=" + this.latitude + ", longitude=" + this.longitude + Separators.RPAREN;
    }
}
