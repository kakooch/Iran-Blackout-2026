package ir.nasim;

import android.gov.nist.core.Separators;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AbstractC5923Lk3;
import ir.nasim.LocationWrapper;
import ir.nasim.NE2;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@InterfaceC14941ik3(discriminator = "dataType")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00152\u00020\u0001:\u0003\u0016\u0017\u0018B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lir/nasim/Lk3;", "", "<init>", "()V", "", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "e", "(Lir/nasim/Lk3;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lir/nasim/Ok3;", "d", "()Lir/nasim/Ok3;", "dataType", "Companion", "b", "c", "a", "Lir/nasim/Lk3$b;", "Lir/nasim/Lk3$c;", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Lk3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5923Lk3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final InterfaceC9173Yu3 a = AbstractC13269fw3.b(EnumC4870Gx3.b, new SA2() { // from class: ir.nasim.Kk3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC5923Lk3.b();
        }
    });

    /* renamed from: ir.nasim.Lk3$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) AbstractC5923Lk3.a.getValue();
        }

        public final KSerializer serializer() {
            return a();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002'\u001eB/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lir/nasim/Lk3$b;", "Lir/nasim/Lk3;", "", "seen0", "Lir/nasim/Ok3;", "dataType", "Lir/nasim/gI3;", "data", "Lir/nasim/tq6;", "serializationConstructorMarker", "<init>", "(ILir/nasim/Ok3;Lir/nasim/gI3;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "g", "(Lir/nasim/Lk3$b;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/Ok3;", "d", "()Lir/nasim/Ok3;", "c", "Lir/nasim/gI3;", "getData", "()Lir/nasim/gI3;", "Companion", "a", "dialogList_release"}, k = 1, mv = {2, 0, 0})
    /* renamed from: ir.nasim.Lk3$b, reason: from toString */
    public static final /* data */ class LocationDataContainer extends AbstractC5923Lk3 {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] d = {EnumC6655Ok3.INSTANCE.serializer(), null};

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final EnumC6655Ok3 dataType;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final LocationWrapper data;

        /* renamed from: ir.nasim.Lk3$b$a */
        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;
            public static final int c;

            /* renamed from: ir.nasim.Lk3$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0485a implements InterfaceC14941ik3 {
                private final /* synthetic */ String b;

                public C0485a(String str) {
                    AbstractC13042fc3.i(str, "discriminator");
                    this.b = str;
                }

                @Override // java.lang.annotation.Annotation
                public final /* synthetic */ Class annotationType() {
                    return InterfaceC14941ik3.class;
                }

                @Override // ir.nasim.InterfaceC14941ik3
                public final /* synthetic */ String discriminator() {
                    return this.b;
                }

                @Override // java.lang.annotation.Annotation
                public final boolean equals(Object obj) {
                    return (obj instanceof InterfaceC14941ik3) && AbstractC13042fc3.d(discriminator(), ((InterfaceC14941ik3) obj).discriminator());
                }

                @Override // java.lang.annotation.Annotation
                public final int hashCode() {
                    return this.b.hashCode() ^ 707790692;
                }

                @Override // java.lang.annotation.Annotation
                public final String toString() {
                    return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.b + Separators.RPAREN;
                }
            }

            static {
                a aVar = new a();
                a = aVar;
                c = 8;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("location", aVar, 2);
                pluginGeneratedSerialDescriptor.l("dataType", true);
                pluginGeneratedSerialDescriptor.l("data", false);
                pluginGeneratedSerialDescriptor.s(new C0485a("dataType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final LocationDataContainer deserialize(Decoder decoder) {
                EnumC6655Ok3 enumC6655Ok3;
                LocationWrapper locationWrapper;
                int i;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = LocationDataContainer.d;
                AbstractC21618tq6 abstractC21618tq6 = null;
                if (cVarB.p()) {
                    enumC6655Ok3 = (EnumC6655Ok3) cVarB.E(serialDescriptor, 0, kSerializerArr[0], null);
                    locationWrapper = (LocationWrapper) cVarB.E(serialDescriptor, 1, LocationWrapper.a.a, null);
                    i = 3;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    EnumC6655Ok3 enumC6655Ok32 = null;
                    LocationWrapper locationWrapper2 = null;
                    while (z) {
                        int iO = cVarB.o(serialDescriptor);
                        if (iO == -1) {
                            z = false;
                        } else if (iO == 0) {
                            enumC6655Ok32 = (EnumC6655Ok3) cVarB.E(serialDescriptor, 0, kSerializerArr[0], enumC6655Ok32);
                            i2 |= 1;
                        } else {
                            if (iO != 1) {
                                throw new UnknownFieldException(iO);
                            }
                            locationWrapper2 = (LocationWrapper) cVarB.E(serialDescriptor, 1, LocationWrapper.a.a, locationWrapper2);
                            i2 |= 2;
                        }
                    }
                    enumC6655Ok3 = enumC6655Ok32;
                    locationWrapper = locationWrapper2;
                    i = i2;
                }
                cVarB.c(serialDescriptor);
                return new LocationDataContainer(i, enumC6655Ok3, locationWrapper, abstractC21618tq6);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, LocationDataContainer locationDataContainer) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(locationDataContainer, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                LocationDataContainer.g(locationDataContainer, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                return new KSerializer[]{LocationDataContainer.d[0], LocationWrapper.a.a};
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

        /* renamed from: ir.nasim.Lk3$b$b, reason: collision with other inner class name and from kotlin metadata */
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LocationDataContainer(int i, EnumC6655Ok3 enumC6655Ok3, LocationWrapper locationWrapper, AbstractC21618tq6 abstractC21618tq6) {
            super(i, abstractC21618tq6);
            if (2 != (i & 2)) {
                AbstractC19039pg5.a(i, 2, a.a.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.dataType = EnumC6655Ok3.b;
            } else {
                this.dataType = enumC6655Ok3;
            }
            this.data = locationWrapper;
        }

        public static final /* synthetic */ void g(LocationDataContainer self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            AbstractC5923Lk3.e(self, output, serialDesc);
            KSerializer[] kSerializerArr = d;
            if (output.z(serialDesc, 0) || self.getDataType() != EnumC6655Ok3.b) {
                output.B(serialDesc, 0, kSerializerArr[0], self.getDataType());
            }
            output.B(serialDesc, 1, LocationWrapper.a.a, self.data);
        }

        @Override // ir.nasim.AbstractC5923Lk3
        /* renamed from: d, reason: from getter */
        public EnumC6655Ok3 getDataType() {
            return this.dataType;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocationDataContainer)) {
                return false;
            }
            LocationDataContainer locationDataContainer = (LocationDataContainer) other;
            return this.dataType == locationDataContainer.dataType && AbstractC13042fc3.d(this.data, locationDataContainer.data);
        }

        public int hashCode() {
            return (this.dataType.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "LocationDataContainer(dataType=" + this.dataType + ", data=" + this.data + Separators.RPAREN;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH×\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH×\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lir/nasim/Lk3$c;", "Lir/nasim/Lk3;", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/Ok3;", "b", "Lir/nasim/Ok3;", "d", "()Lir/nasim/Ok3;", "dataType", "dialogList_release"}, k = 1, mv = {2, 0, 0})
    /* renamed from: ir.nasim.Lk3$c */
    public static final /* data */ class c extends AbstractC5923Lk3 {
        public static final c INSTANCE = new c();

        /* renamed from: b, reason: from kotlin metadata */
        private static final EnumC6655Ok3 dataType = EnumC6655Ok3.d;
        private static final /* synthetic */ InterfaceC9173Yu3 c = AbstractC13269fw3.b(EnumC4870Gx3.b, new SA2() { // from class: ir.nasim.Mk3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC5923Lk3.c.b();
            }
        });

        private c() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new AG4(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, INSTANCE, new Annotation[]{new LocationDataContainer.a.C0485a("dataType")});
        }

        private final /* synthetic */ KSerializer g() {
            return (KSerializer) c.getValue();
        }

        @Override // ir.nasim.AbstractC5923Lk3
        /* renamed from: d */
        public EnumC6655Ok3 getDataType() {
            return dataType;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof c);
        }

        public int hashCode() {
            return 1622733682;
        }

        public final KSerializer serializer() {
            return g();
        }

        public String toString() {
            return "UnknownDataContainer";
        }
    }

    private AbstractC5923Lk3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new C4219Ee6("ir.nasim.dialoglist.data.mapper.mappingStrategies.JsonMessageDataContainer", AbstractC10882cM5.b(AbstractC5923Lk3.class), new InterfaceC11299cm3[]{AbstractC10882cM5.b(LocationDataContainer.class), AbstractC10882cM5.b(c.class)}, new KSerializer[]{LocationDataContainer.a.a, new AG4(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, c.INSTANCE, new Annotation[]{new LocationDataContainer.a.C0485a("dataType")})}, new Annotation[]{new LocationDataContainer.a.C0485a("dataType")});
    }

    /* renamed from: d */
    public abstract EnumC6655Ok3 getDataType();

    public /* synthetic */ AbstractC5923Lk3(int i, AbstractC21618tq6 abstractC21618tq6) {
    }

    public /* synthetic */ AbstractC5923Lk3(ED1 ed1) {
        this();
    }

    public static final /* synthetic */ void e(AbstractC5923Lk3 self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
    }
}
