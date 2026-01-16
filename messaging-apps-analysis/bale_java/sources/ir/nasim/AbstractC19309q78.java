package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RTCStats;
import livekit.org.webrtc.RTCStatsReport;

/* renamed from: ir.nasim.q78, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19309q78 {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v39, types: [ir.nasim.uT7] */
    public static final List c(RTCStatsReport rTCStatsReport) {
        String string;
        PN c21986uT7;
        String string2;
        String string3;
        Double dK;
        String string4;
        Double dK2;
        String string5;
        Double dK3;
        String string6;
        Double dK4;
        String string7;
        Double dK5;
        String string8;
        Double dK6;
        String string9;
        Double dK7;
        String string10;
        Double dK8;
        String string11;
        Double dK9;
        String string12;
        Double dK10;
        String string13;
        Double dK11;
        String string14;
        Double dK12;
        String string15;
        Double dK13;
        String string16;
        Double dK14;
        String string17;
        Double dK15;
        String string18;
        Double dK16;
        String string19;
        Double dK17;
        String string20;
        Double dK18;
        String string21;
        Double dK19;
        String string22;
        Double dK20;
        Collection<RTCStats> collectionValues = rTCStatsReport.getStatsMap().values();
        ArrayList<RTCStats> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (AbstractC13042fc3.d(((RTCStats) obj).getType(), "inbound-rtp")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (RTCStats rTCStats : arrayList) {
            Object obj2 = rTCStats.getMembers().get("kind");
            if (obj2 == null || (string = obj2.toString()) == null) {
                string = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
            }
            String str = string;
            long timestampUs = ((long) rTCStats.getTimestampUs()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            Object obj3 = rTCStats.getMembers().get("jitterBufferDelay");
            long jDoubleValue = (obj3 == null || (string22 = obj3.toString()) == null || (dK20 = AbstractC18971pZ6.k(string22)) == null) ? 0L : (long) dK20.doubleValue();
            Object obj4 = rTCStats.getMembers().get("jitterBufferEmittedCount");
            long jDoubleValue2 = (obj4 == null || (string21 = obj4.toString()) == null || (dK19 = AbstractC18971pZ6.k(string21)) == null) ? 0L : (long) dK19.doubleValue();
            double dDoubleValue = 0.0d;
            if (AbstractC13042fc3.d(str, MediaStreamTrack.AUDIO_TRACK_KIND)) {
                Object obj5 = rTCStats.getMembers().get("packetsDiscarded");
                long jDoubleValue3 = (obj5 == null || (string20 = obj5.toString()) == null || (dK18 = AbstractC18971pZ6.k(string20)) == null) ? 0L : (long) dK18.doubleValue();
                Object obj6 = rTCStats.getMembers().get("fecpacketsreceived");
                long jDoubleValue4 = (obj6 == null || (string19 = obj6.toString()) == null || (dK17 = AbstractC18971pZ6.k(string19)) == null) ? 0L : (long) dK17.doubleValue();
                Object obj7 = rTCStats.getMembers().get("fecpacketsdiscarded");
                long jDoubleValue5 = (obj7 == null || (string18 = obj7.toString()) == null || (dK16 = AbstractC18971pZ6.k(string18)) == null) ? 0L : (long) dK16.doubleValue();
                Object obj8 = rTCStats.getMembers().get("concealedSamples");
                long jDoubleValue6 = (obj8 == null || (string17 = obj8.toString()) == null || (dK15 = AbstractC18971pZ6.k(string17)) == null) ? 0L : (long) dK15.doubleValue();
                Object obj9 = rTCStats.getMembers().get("concealmentEvents");
                long jDoubleValue7 = (obj9 == null || (string16 = obj9.toString()) == null || (dK14 = AbstractC18971pZ6.k(string16)) == null) ? 0L : (long) dK14.doubleValue();
                Object obj10 = rTCStats.getMembers().get("audioLevel");
                if (obj10 != null && (string15 = obj10.toString()) != null && (dK13 = AbstractC18971pZ6.k(string15)) != null) {
                    dDoubleValue = dK13.doubleValue();
                }
                c21986uT7 = new PN(str, timestampUs, jDoubleValue, jDoubleValue2, jDoubleValue3, jDoubleValue4, jDoubleValue5, jDoubleValue6, jDoubleValue7, Double.valueOf(dDoubleValue));
            } else if (AbstractC13042fc3.d(str, MediaStreamTrack.VIDEO_TRACK_KIND)) {
                Object obj11 = rTCStats.getMembers().get("framesDropped");
                long jDoubleValue8 = (obj11 == null || (string14 = obj11.toString()) == null || (dK12 = AbstractC18971pZ6.k(string14)) == null) ? 0L : (long) dK12.doubleValue();
                Object obj12 = rTCStats.getMembers().get("framesPerSecond");
                long jDoubleValue9 = (obj12 == null || (string13 = obj12.toString()) == null || (dK11 = AbstractC18971pZ6.k(string13)) == null) ? 0L : (long) dK11.doubleValue();
                Object obj13 = rTCStats.getMembers().get("pauseCount");
                long jDoubleValue10 = (obj13 == null || (string12 = obj13.toString()) == null || (dK10 = AbstractC18971pZ6.k(string12)) == null) ? 0L : (long) dK10.doubleValue();
                Object obj14 = rTCStats.getMembers().get("totalPausesDuration");
                long jDoubleValue11 = (obj14 == null || (string11 = obj14.toString()) == null || (dK9 = AbstractC18971pZ6.k(string11)) == null) ? 0L : (long) dK9.doubleValue();
                Object obj15 = rTCStats.getMembers().get("freezeCount");
                long jDoubleValue12 = (obj15 == null || (string10 = obj15.toString()) == null || (dK8 = AbstractC18971pZ6.k(string10)) == null) ? 0L : (long) dK8.doubleValue();
                Object obj16 = rTCStats.getMembers().get("totalfreezesduration");
                long jDoubleValue13 = (obj16 == null || (string9 = obj16.toString()) == null || (dK7 = AbstractC18971pZ6.k(string9)) == null) ? 0L : (long) dK7.doubleValue();
                Object obj17 = rTCStats.getMembers().get("lastpacketreceivedtimestamp");
                double dDoubleValue2 = (obj17 == null || (string8 = obj17.toString()) == null || (dK6 = AbstractC18971pZ6.k(string8)) == null) ? 0.0d : dK6.doubleValue();
                Object obj18 = rTCStats.getMembers().get("nackCount");
                long jDoubleValue14 = (obj18 == null || (string7 = obj18.toString()) == null || (dK5 = AbstractC18971pZ6.k(string7)) == null) ? 0L : (long) dK5.doubleValue();
                Object obj19 = rTCStats.getMembers().get("firCount");
                long jDoubleValue15 = (obj19 == null || (string6 = obj19.toString()) == null || (dK4 = AbstractC18971pZ6.k(string6)) == null) ? 0L : (long) dK4.doubleValue();
                Object obj20 = rTCStats.getMembers().get("pliCount");
                long jDoubleValue16 = (obj20 == null || (string5 = obj20.toString()) == null || (dK3 = AbstractC18971pZ6.k(string5)) == null) ? 0L : (long) dK3.doubleValue();
                Object obj21 = rTCStats.getMembers().get("framesReceived");
                long jDoubleValue17 = (obj21 == null || (string4 = obj21.toString()) == null || (dK2 = AbstractC18971pZ6.k(string4)) == null) ? 0L : (long) dK2.doubleValue();
                Object obj22 = rTCStats.getMembers().get("retransmittedPacketsReceived");
                long jDoubleValue18 = (obj22 == null || (string3 = obj22.toString()) == null || (dK = AbstractC18971pZ6.k(string3)) == null) ? 0L : (long) dK.doubleValue();
                Object obj23 = rTCStats.getMembers().get("decoderImplementation");
                if (obj23 == null || (string2 = obj23.toString()) == null) {
                    string2 = "";
                }
                c21986uT7 = new C21986uT7(str, timestampUs, jDoubleValue, jDoubleValue2, jDoubleValue8, jDoubleValue9, jDoubleValue10, jDoubleValue11, jDoubleValue12, jDoubleValue13, dDoubleValue2, jDoubleValue14, jDoubleValue15, jDoubleValue16, jDoubleValue17, string2, jDoubleValue18);
            } else {
                c21986uT7 = null;
            }
            if (c21986uT7 != null) {
                arrayList2.add(c21986uT7);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List d(livekit.org.webrtc.RTCStatsReport r41) {
        /*
            Method dump skipped, instructions count: 1526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19309q78.d(livekit.org.webrtc.RTCStatsReport):java.util.List");
    }
}
