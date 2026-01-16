package io.livekit.android.room;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.NE2;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"io/livekit/android/room/RegionSettings.$serializer", "Lir/nasim/NE2;", "Lio/livekit/android/room/RegionSettings;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/livekit/android/room/RegionSettings;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lir/nasim/rB7;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/livekit/android/room/RegionSettings;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
@InterfaceC14067hI1
/* loaded from: classes3.dex */
public final class RegionSettings$$serializer implements NE2 {
    public static final RegionSettings$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        RegionSettings$$serializer regionSettings$$serializer = new RegionSettings$$serializer();
        INSTANCE = regionSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.livekit.android.room.RegionSettings", regionSettings$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("regions", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RegionSettings$$serializer() {
    }

    @Override // ir.nasim.NE2
    public KSerializer[] childSerializers() {
        return new KSerializer[]{RegionSettings.b[0]};
    }

    @Override // ir.nasim.XI1
    public RegionSettings deserialize(Decoder decoder) {
        List list;
        AbstractC13042fc3.i(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.c cVarB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = RegionSettings.b;
        int i = 1;
        if (cVarB.p()) {
            list = (List) cVarB.E(descriptor2, 0, kSerializerArr[0], null);
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            while (z) {
                int iO = cVarB.o(descriptor2);
                if (iO == -1) {
                    z = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    list2 = (List) cVarB.E(descriptor2, 0, kSerializerArr[0], list2);
                    i2 = 1;
                }
            }
            list = list2;
            i = i2;
        }
        cVarB.c(descriptor2);
        return new RegionSettings(i, list, null);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, RegionSettings value) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.d dVarB = encoder.b(descriptor2);
        dVarB.B(descriptor2, 0, RegionSettings.b[0], value.regions);
        dVarB.c(descriptor2);
    }

    @Override // ir.nasim.NE2
    public KSerializer[] typeParametersSerializers() {
        return NE2.a.a(this);
    }
}
