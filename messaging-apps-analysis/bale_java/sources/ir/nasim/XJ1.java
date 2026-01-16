package ir.nasim;

import ai.bale.proto.AuthStruct$AuthSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public final class XJ1 {

    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Boolean.valueOf(((ZJ1) obj).f()), Boolean.valueOf(((ZJ1) obj2).f()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(AuthStruct$AuthSession authStruct$AuthSession, AuthStruct$AuthSession authStruct$AuthSession2) {
        AbstractC13042fc3.i(authStruct$AuthSession, "lhs");
        AbstractC13042fc3.i(authStruct$AuthSession2, "rhs");
        return authStruct$AuthSession2.getAuthTime() - authStruct$AuthSession.getAuthTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    public final List c(List list) {
        AbstractC13042fc3.i(list, "apiAuthSessionList");
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.VJ1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(XJ1.d((AuthStruct$AuthSession) obj, (AuthStruct$AuthSession) obj2));
            }
        };
        List<AuthStruct$AuthSession> listA1 = AbstractC15401jX0.a1(list, new Comparator() { // from class: ir.nasim.WJ1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return XJ1.e(interfaceC14603iB2, obj, obj2);
            }
        });
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA1, 10));
        for (AuthStruct$AuthSession authStruct$AuthSession : listA1) {
            String deviceTitle = authStruct$AuthSession.getDeviceTitle();
            AbstractC13042fc3.h(deviceTitle, "getDeviceTitle(...)");
            String appTitle = authStruct$AuthSession.getAppTitle();
            AbstractC13042fc3.h(appTitle, "getAppTitle(...)");
            arrayList.add(new ZJ1(deviceTitle, appTitle, authStruct$AuthSession.getAuthTime() * 1000, authStruct$AuthSession.getAuthHolder() == VQ.AuthHolder_THISDEVICE, authStruct$AuthSession.getId(), authStruct$AuthSession.getAppId()));
        }
        return AbstractC15401jX0.a1(arrayList, new a());
    }
}
