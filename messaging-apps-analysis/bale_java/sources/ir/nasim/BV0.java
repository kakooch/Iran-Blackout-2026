package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC6544Ny5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class BV0 {
    public static final BV0 a = new BV0();

    private BV0() {
    }

    private final String d(AbstractC24063xz abstractC24063xz) {
        if (abstractC24063xz != null) {
            try {
                byte[] bArrQ = abstractC24063xz.q();
                AbstractC13042fc3.f(bArrQ);
                return C14582i90.b(bArrQ);
            } catch (Exception e) {
                C19406qI3.a("NotificationData", e.getMessage(), new Object[0]);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(C8445Vz5 c8445Vz5, E84 e84, C11458d25 c11458d25, C9057Yh4 c9057Yh4) {
        J44 j44;
        AbstractC13042fc3.i(e84, "$messagesModules");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(c9057Yh4, "$context");
        return (c8445Vz5 == null || (j44 = (J44) e84.H0(c11458d25).a(c8445Vz5.s())) == null || j44.U() != c9057Yh4.i0()) ? false : true;
    }

    private static final boolean i(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return ((Boolean) interfaceC9173Yu3.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean j(C9057Yh4 c9057Yh4, String str) {
        AbstractC13042fc3.i(c9057Yh4, "$context");
        AbstractC13042fc3.i(str, "$messageText");
        C17637nI7 c17637nI7 = (C17637nI7) c9057Yh4.W().p0().d(c9057Yh4.w().p());
        Boolean boolValueOf = null;
        String strD0 = c17637nI7 != null ? c17637nI7.d0() : null;
        if (strD0 != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            boolValueOf = Boolean.valueOf(new C20644sM5("@(" + strD0 + ")(:|\\s+|$)").a(lowerCase));
        }
        if (!C8386Vt0.S7() || AbstractC13042fc3.d(boolValueOf, Boolean.TRUE)) {
            return boolValueOf;
        }
        C20644sM5 c20644sM5 = new C20644sM5("\\[.*?]\\(uid:" + c9057Yh4.w().p() + "\\)");
        String lowerCase2 = str.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
        return Boolean.valueOf(c20644sM5.a(lowerCase2));
    }

    private static final Boolean k(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return (Boolean) interfaceC9173Yu3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l(CE7 ce7) {
        AbstractC13042fc3.i(ce7, "$updateMessage");
        return a.d(ce7.d());
    }

    private static final String m(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return (String) interfaceC9173Yu3.getValue();
    }

    private final boolean p(AbstractC17457n0 abstractC17457n0) {
        return ((abstractC17457n0 instanceof AbstractC12586er6) || (abstractC17457n0 instanceof C12872fJ6) || (abstractC17457n0 instanceof C24562yp4)) ? false : true;
    }

    public final void e(C11458d25 c11458d25, FE7 fe7) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(fe7, "messageDeleteUpdate");
        try {
            C19406qI3.a("PushHandler", "onPushReceived from onMessageUpdate : " + EnumC13889gz5.c, new Object[0]);
            VE4 ve4K = AbstractC5969Lp4.d().o2().K();
            AbstractC6544Ny5.a aVar = AbstractC6544Ny5.a.a;
            long jO = AbstractC20507s76.o();
            List listA = fe7.a();
            List listC = fe7.c();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Number) it.next()).longValue()));
            }
            ve4K.I(new IH1(aVar, jO, listA, arrayList, String.valueOf(c11458d25.s() == W25.b ? 2 : 1), String.valueOf(c11458d25.getPeerId()), String.valueOf(c11458d25.getPeerId()), null, null, c11458d25, null, null, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, null));
        } catch (Exception e) {
            C19406qI3.a("PushHandler", "exception while ClientSidePushManager was handling new Delete: " + e.getMessage(), new Object[0]);
        }
    }

    public final void f(C11458d25 c11458d25, DE7 de7, C9057Yh4 c9057Yh4) {
        String strV;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(de7, "updateMessageContentChanged");
        AbstractC13042fc3.i(c9057Yh4, "context");
        try {
            EnumC13889gz5 enumC13889gz5 = EnumC13889gz5.d;
            C19406qI3.a("PushHandler", "onPushReceived from onMessageUpdate : " + enumC13889gz5 + ", peerId: " + c11458d25.getPeerId(), new Object[0]);
            AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(de7.b());
            boolean z = de7.e() == c9057Yh4.i0();
            AbstractC13042fc3.f(abstractC17457n0H);
            if (!p(abstractC17457n0H) || z) {
                return;
            }
            C19406qI3.a("PushHandler", "onPushReceived from onMessageUpdate : " + enumC13889gz5, new Object[0]);
            Long lA = de7.a();
            String strD = d(de7.b());
            if (lA != null) {
                VE4 ve4K = AbstractC5969Lp4.d().o2().K();
                AbstractC6544Ny5.a aVar = AbstractC6544Ny5.a.a;
                long jO = AbstractC20507s76.o();
                String strValueOf = String.valueOf(de7.d());
                String strValueOf2 = String.valueOf(de7.e());
                String strValueOf3 = String.valueOf(c11458d25.getPeerId());
                AbstractC24063xz abstractC24063xzB = de7.b();
                C23345wl7 c23345wl7L = abstractC17457n0H.l();
                if (c23345wl7L == null || (strV = c23345wl7L.v()) == null) {
                    strV = "";
                }
                ve4K.I(new C13345g42(aVar, jO, lA.longValue(), strValueOf, String.valueOf(c11458d25.s() == W25.b ? 2 : 1), strValueOf2, strValueOf3, abstractC24063xzB, strD, strV, null, c11458d25, null, 5120, null));
            }
        } catch (Exception e) {
            C19406qI3.a("PushHandler", "exception while ClientSidePushManager was handling new Edit: " + e.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108 A[Catch: Exception -> 0x0101, TryCatch #11 {Exception -> 0x0101, blocks: (B:44:0x0108, B:45:0x0110, B:37:0x00f4, B:39:0x00fc), top: B:134:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c5 A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #2 {Exception -> 0x01bc, blocks: (B:56:0x01b0, B:61:0x01c5), top: B:116:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(final ir.nasim.C11458d25 r41, ir.nasim.J44 r42, final ir.nasim.CE7 r43, final ir.nasim.C9057Yh4 r44, final ir.nasim.E84 r45) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BV0.g(ir.nasim.d25, ir.nasim.J44, ir.nasim.CE7, ir.nasim.Yh4, ir.nasim.E84):void");
    }

    public final void n(C11458d25 c11458d25, List list, List list2, C9057Yh4 c9057Yh4, E84 e84) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "updateMessages");
        AbstractC13042fc3.i(list2, "messages");
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(e84, "messagesModules");
        for (XV4 xv4 : AbstractC15401jX0.v1(list, list2)) {
            CE7 ce7 = (CE7) xv4.e();
            a.g(c11458d25, (J44) xv4.f(), ce7, c9057Yh4, e84);
        }
    }

    public final void o(C11458d25 c11458d25, long j, C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c9057Yh4, "context");
        try {
            C19406qI3.a("PushHandler", "onPushReceived from onMessageUpdate : " + EnumC13889gz5.e + ", peerId: " + c11458d25.getPeerId(), new Object[0]);
            AbstractC5969Lp4.d().o2().K().I(new C24845zI5(AbstractC6544Ny5.a.a, System.currentTimeMillis(), j, String.valueOf(c11458d25.s() == W25.b ? 2 : 1), String.valueOf(c9057Yh4.i0()), String.valueOf(c11458d25.getPeerId()), null, null, c11458d25, null, 512, null));
        } catch (Exception e) {
            C19406qI3.a("PushHandler", "exception while ClientSidePushManager was handling new Read: " + e.getMessage(), new Object[0]);
        }
    }
}
