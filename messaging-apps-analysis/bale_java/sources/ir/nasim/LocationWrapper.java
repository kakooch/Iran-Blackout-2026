package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.Location;
import ir.nasim.NE2;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u0010\u001fB%\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lir/nasim/gI3;", "", "", "seen0", "Lir/nasim/QH3;", "location", "Lir/nasim/tq6;", "serializationConstructorMarker", "<init>", "(ILir/nasim/QH3;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "a", "(Lir/nasim/gI3;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/QH3;", "getLocation", "()Lir/nasim/QH3;", "Companion", "b", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.gI3, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public final /* data */ class LocationWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final Location location;

    /* renamed from: ir.nasim.gI3$a */
    public /* synthetic */ class a implements NE2 {
        public static final a a;
        private static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ir.nasim.dialoglist.data.mapper.mappingStrategies.LocationWrapper", aVar, 1);
            pluginGeneratedSerialDescriptor.l("location", false);
            b = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // ir.nasim.XI1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LocationWrapper deserialize(Decoder decoder) {
            Location location;
            AbstractC13042fc3.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
            int i = 1;
            AbstractC21618tq6 abstractC21618tq6 = null;
            if (cVarB.p()) {
                location = (Location) cVarB.E(serialDescriptor, 0, Location.a.a, null);
            } else {
                boolean z = true;
                int i2 = 0;
                location = null;
                while (z) {
                    int iO = cVarB.o(serialDescriptor);
                    if (iO == -1) {
                        z = false;
                    } else {
                        if (iO != 0) {
                            throw new UnknownFieldException(iO);
                        }
                        location = (Location) cVarB.E(serialDescriptor, 0, Location.a.a, location);
                        i2 = 1;
                    }
                }
                i = i2;
            }
            cVarB.c(serialDescriptor);
            return new LocationWrapper(i, location, abstractC21618tq6);
        }

        @Override // ir.nasim.InterfaceC22798vq6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, LocationWrapper locationWrapper) {
            AbstractC13042fc3.i(encoder, "encoder");
            AbstractC13042fc3.i(locationWrapper, "value");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
            LocationWrapper.a(locationWrapper, dVarB, serialDescriptor);
            dVarB.c(serialDescriptor);
        }

        @Override // ir.nasim.NE2
        public final KSerializer[] childSerializers() {
            return new KSerializer[]{Location.a.a};
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

    /* renamed from: ir.nasim.gI3$b, reason: from kotlin metadata */
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

    public /* synthetic */ LocationWrapper(int i, Location location, AbstractC21618tq6 abstractC21618tq6) {
        if (1 != (i & 1)) {
            AbstractC19039pg5.a(i, 1, a.a.getDescriptor());
        }
        this.location = location;
    }

    public static final /* synthetic */ void a(LocationWrapper self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.B(serialDesc, 0, Location.a.a, self.location);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LocationWrapper) && AbstractC13042fc3.d(this.location, ((LocationWrapper) other).location);
    }

    public int hashCode() {
        return this.location.hashCode();
    }

    public String toString() {
        return "LocationWrapper(location=" + this.location + Separators.RPAREN;
    }
}
