package io.livekit.android.room;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.C3712Ca3;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"io/livekit/android/room/IceCandidateJSON.$serializer", "Lir/nasim/NE2;", "Lio/livekit/android/room/IceCandidateJSON;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/livekit/android/room/IceCandidateJSON;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lir/nasim/rB7;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/livekit/android/room/IceCandidateJSON;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
@InterfaceC14067hI1
/* loaded from: classes3.dex */
public final class IceCandidateJSON$$serializer implements NE2 {
    public static final IceCandidateJSON$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        IceCandidateJSON$$serializer iceCandidateJSON$$serializer = new IceCandidateJSON$$serializer();
        INSTANCE = iceCandidateJSON$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.livekit.android.room.IceCandidateJSON", iceCandidateJSON$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("candidate", false);
        pluginGeneratedSerialDescriptor.l("sdpMLineIndex", false);
        pluginGeneratedSerialDescriptor.l("sdpMid", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IceCandidateJSON$$serializer() {
    }

    @Override // ir.nasim.NE2
    public KSerializer[] childSerializers() {
        VY6 vy6 = VY6.a;
        return new KSerializer[]{vy6, C3712Ca3.a, AbstractC18503om0.p(vy6)};
    }

    @Override // ir.nasim.XI1
    public IceCandidateJSON deserialize(Decoder decoder) {
        int i;
        int i2;
        String str;
        String str2;
        AbstractC13042fc3.i(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.c cVarB = decoder.b(descriptor2);
        if (cVarB.p()) {
            String strN = cVarB.n(descriptor2, 0);
            int i3 = cVarB.i(descriptor2, 1);
            str = strN;
            str2 = (String) cVarB.H(descriptor2, 2, VY6.a, null);
            i = i3;
            i2 = 7;
        } else {
            boolean z = true;
            int i4 = 0;
            String strN2 = null;
            String str3 = null;
            int i5 = 0;
            while (z) {
                int iO = cVarB.o(descriptor2);
                if (iO == -1) {
                    z = false;
                } else if (iO == 0) {
                    strN2 = cVarB.n(descriptor2, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    i4 = cVarB.i(descriptor2, 1);
                    i5 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    str3 = (String) cVarB.H(descriptor2, 2, VY6.a, str3);
                    i5 |= 4;
                }
            }
            i = i4;
            i2 = i5;
            str = strN2;
            str2 = str3;
        }
        cVarB.c(descriptor2);
        return new IceCandidateJSON(i2, str, i, str2, null);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, IceCandidateJSON value) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.d dVarB = encoder.b(descriptor2);
        IceCandidateJSON.d(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // ir.nasim.NE2
    public KSerializer[] typeParametersSerializers() {
        return NE2.a.a(this);
    }
}
