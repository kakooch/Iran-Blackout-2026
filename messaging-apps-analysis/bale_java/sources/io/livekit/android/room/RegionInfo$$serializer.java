package io.livekit.android.room;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.C20006rJ3;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.NE2;
import ir.nasim.VY6;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"io/livekit/android/room/RegionInfo.$serializer", "Lir/nasim/NE2;", "Lio/livekit/android/room/RegionInfo;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/livekit/android/room/RegionInfo;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lir/nasim/rB7;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/livekit/android/room/RegionInfo;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
@InterfaceC14067hI1
/* loaded from: classes3.dex */
public final class RegionInfo$$serializer implements NE2 {
    public static final RegionInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        RegionInfo$$serializer regionInfo$$serializer = new RegionInfo$$serializer();
        INSTANCE = regionInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.livekit.android.room.RegionInfo", regionInfo$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("region", false);
        pluginGeneratedSerialDescriptor.l("url", false);
        pluginGeneratedSerialDescriptor.l("distance", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RegionInfo$$serializer() {
    }

    @Override // ir.nasim.NE2
    public KSerializer[] childSerializers() {
        VY6 vy6 = VY6.a;
        return new KSerializer[]{vy6, vy6, C20006rJ3.a};
    }

    @Override // ir.nasim.XI1
    public RegionInfo deserialize(Decoder decoder) {
        String strN;
        int i;
        String strN2;
        long jF;
        AbstractC13042fc3.i(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.c cVarB = decoder.b(descriptor2);
        if (cVarB.p()) {
            strN = cVarB.n(descriptor2, 0);
            i = 7;
            strN2 = cVarB.n(descriptor2, 1);
            jF = cVarB.f(descriptor2, 2);
        } else {
            String strN3 = null;
            boolean z = true;
            long jF2 = 0;
            String strN4 = null;
            int i2 = 0;
            while (z) {
                int iO = cVarB.o(descriptor2);
                if (iO == -1) {
                    z = false;
                } else if (iO == 0) {
                    strN3 = cVarB.n(descriptor2, 0);
                    i2 |= 1;
                } else if (iO == 1) {
                    strN4 = cVarB.n(descriptor2, 1);
                    i2 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    jF2 = cVarB.f(descriptor2, 2);
                    i2 |= 4;
                }
            }
            strN = strN3;
            i = i2;
            strN2 = strN4;
            jF = jF2;
        }
        cVarB.c(descriptor2);
        return new RegionInfo(i, strN, strN2, jF, null);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, RegionInfo value) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.d dVarB = encoder.b(descriptor2);
        RegionInfo.b(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // ir.nasim.NE2
    public KSerializer[] typeParametersSerializers() {
        return NE2.a.a(this);
    }
}
