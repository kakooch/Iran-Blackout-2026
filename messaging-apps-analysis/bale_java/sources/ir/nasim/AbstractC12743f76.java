package ir.nasim;

import ir.nasim.AbstractC6718Or3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RtpCapabilities;
import livekit.org.webrtc.RtpTransceiver;

/* renamed from: ir.nasim.f76, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12743f76 {
    public static final void a(RtpTransceiver rtpTransceiver, String str, UA2 ua2) {
        AbstractC13042fc3.i(rtpTransceiver, "<this>");
        AbstractC13042fc3.i(str, "targetCodec");
        AbstractC13042fc3.i(ua2, "capabilitiesGetter");
        RtpCapabilities rtpCapabilities = (RtpCapabilities) ua2.invoke(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO);
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "capabilities:", new Object[0]);
        }
        List<RtpCapabilities.CodecCapability> list = rtpCapabilities.codecs;
        AbstractC13042fc3.h(list, "codecs");
        for (RtpCapabilities.CodecCapability codecCapability : list) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "codec: " + codecCapability.name + ", " + codecCapability.kind + ", " + codecCapability.mimeType + ", " + codecCapability.parameters + ", " + codecCapability.preferredPayloadType, new Object[0]);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (RtpCapabilities.CodecCapability codecCapability2 : rtpCapabilities.codecs) {
            String str2 = codecCapability2.mimeType;
            AbstractC13042fc3.h(str2, "mimeType");
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (AbstractC13042fc3.d(lowerCase, "audio/opus")) {
                AbstractC13042fc3.f(codecCapability2);
                arrayList.add(codecCapability2);
            } else {
                if (!AbstractC13042fc3.d(lowerCase, "video/" + str)) {
                    AbstractC13042fc3.f(codecCapability2);
                    arrayList3.add(codecCapability2);
                } else if (!AbstractC13042fc3.d(str, "h264")) {
                    AbstractC13042fc3.f(codecCapability2);
                    arrayList.add(codecCapability2);
                } else if (AbstractC13042fc3.d(codecCapability2.parameters.get("profile-level-id"), "42e01f")) {
                    AbstractC13042fc3.f(codecCapability2);
                    arrayList.add(codecCapability2);
                } else {
                    AbstractC13042fc3.f(codecCapability2);
                    arrayList2.add(codecCapability2);
                }
            }
        }
        rtpTransceiver.setCodecPreferences(AbstractC15401jX0.R0(AbstractC15401jX0.R0(arrayList, arrayList2), arrayList3));
    }
}
