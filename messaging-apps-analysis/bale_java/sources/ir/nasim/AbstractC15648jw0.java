package ir.nasim;

import ai.bale.proto.MeetOuterClass$ResponseGetCallLogs;
import ai.bale.proto.MeetStruct$CallLog;
import ai.bale.proto.MeetStruct$MultiPeerCallLog;
import ai.bale.proto.PeersStruct$OutExPeer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.jw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC15648jw0 {

    /* renamed from: ir.nasim.jw0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC13908h14.values().length];
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_MISSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC13908h14.PrivateCallLogStatus_DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC13908h14.UNRECOGNIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
            int[] iArr2 = new int[U04.values().length];
            try {
                iArr2[U04.GroupCallLogStatus_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[U04.GroupCallLogStatus_JOINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[U04.GroupCallLogStatus_MISSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[U04.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC10067b14.values().length];
            try {
                iArr3[EnumC10067b14.MultiPeerCallLogStatus_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[EnumC10067b14.MultiPeerCallLogStatus_JOINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[EnumC10067b14.MultiPeerCallLogStatus_MISSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[EnumC10067b14.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            c = iArr3;
        }
    }

    public static final EnumC11643dM2 a(U04 u04) {
        AbstractC13042fc3.i(u04, "apiStatus");
        int i = a.b[u04.ordinal()];
        if (i == 1) {
            return EnumC11643dM2.a;
        }
        if (i == 2) {
            return EnumC11643dM2.b;
        }
        if (i == 3) {
            return EnumC11643dM2.c;
        }
        if (i == 4) {
            return EnumC11643dM2.a;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final C4997Hl4 b(MeetStruct$MultiPeerCallLog meetStruct$MultiPeerCallLog) {
        EnumC4514Fl4 enumC4514Fl4;
        AbstractC13042fc3.i(meetStruct$MultiPeerCallLog, "apiStatus");
        List<PeersStruct$OutExPeer> peersList = meetStruct$MultiPeerCallLog.getPeersList();
        AbstractC13042fc3.h(peersList, "getPeersList(...)");
        List<PeersStruct$OutExPeer> list = peersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((PeersStruct$OutExPeer) it.next()).getId()));
        }
        EnumC10067b14 status = meetStruct$MultiPeerCallLog.getStatus();
        int i = status == null ? -1 : a.c[status.ordinal()];
        if (i == 1) {
            enumC4514Fl4 = EnumC4514Fl4.a;
        } else if (i == 2) {
            enumC4514Fl4 = EnumC4514Fl4.b;
        } else if (i == 3) {
            enumC4514Fl4 = EnumC4514Fl4.c;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            enumC4514Fl4 = EnumC4514Fl4.a;
        }
        return new C4997Hl4(arrayList, enumC4514Fl4);
    }

    public static final EnumC18114o65 c(EnumC13908h14 enumC13908h14) {
        AbstractC13042fc3.i(enumC13908h14, "apiStatus");
        switch (a.a[enumC13908h14.ordinal()]) {
            case 1:
                return EnumC18114o65.a;
            case 2:
                return EnumC18114o65.b;
            case 3:
                return EnumC18114o65.c;
            case 4:
                return EnumC18114o65.d;
            case 5:
                return EnumC18114o65.e;
            case 6:
                return EnumC18114o65.f;
            case 7:
                return EnumC18114o65.a;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final List d(MeetOuterClass$ResponseGetCallLogs meetOuterClass$ResponseGetCallLogs) {
        AbstractC13042fc3.i(meetOuterClass$ResponseGetCallLogs, "apiResponse");
        List<MeetStruct$CallLog> callLogsList = meetOuterClass$ResponseGetCallLogs.getCallLogsList();
        AbstractC13042fc3.h(callLogsList, "getCallLogsList(...)");
        List<MeetStruct$CallLog> list = callLogsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MeetStruct$CallLog meetStruct$CallLog : list) {
            long startDate = meetStruct$CallLog.getStartDate();
            long duration = meetStruct$CallLog.getDuration();
            long id = meetStruct$CallLog.getPeer().getId();
            long id2 = meetStruct$CallLog.getInitiator().getId();
            long id3 = meetStruct$CallLog.getFinisher().getId();
            EnumC13908h14 status = meetStruct$CallLog.getPrivateCallLog().getStatus();
            AbstractC13042fc3.h(status, "getStatus(...)");
            EnumC18114o65 enumC18114o65C = c(status);
            U04 status2 = meetStruct$CallLog.getGroupCallLog().getStatus();
            AbstractC13042fc3.h(status2, "getStatus(...)");
            EnumC11643dM2 enumC11643dM2A = a(status2);
            MeetStruct$MultiPeerCallLog multiPeerCallLog = meetStruct$CallLog.getMultiPeerCallLog();
            AbstractC13042fc3.h(multiPeerCallLog, "getMultiPeerCallLog(...)");
            arrayList.add(new C15057iw0(startDate, duration, id, id2, id3, enumC18114o65C, enumC11643dM2A, b(multiPeerCallLog), meetStruct$CallLog.getCallId().getValue()));
        }
        return arrayList;
    }
}
