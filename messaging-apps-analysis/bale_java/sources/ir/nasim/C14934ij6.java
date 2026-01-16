package ir.nasim;

import ai.bale.proto.AuthOuterClass$RequestDeleteAccount;
import ai.bale.proto.AuthOuterClass$RequestGetAuthSessions;
import ai.bale.proto.AuthOuterClass$RequestSendDeleteAccountVerificationCode;
import ai.bale.proto.AuthOuterClass$RequestTerminateAllSessions;
import ai.bale.proto.AuthOuterClass$RequestTerminateSession;
import ai.bale.proto.AuthOuterClass$ResponseGetAuthSessions;
import ai.bale.proto.AuthOuterClass$ResponseSendDeleteAccountVerificationCode;
import ai.bale.proto.Misc$ResponseVoid;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C3553Bi6;
import java.util.List;

/* renamed from: ir.nasim.ij6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14934ij6 extends AbstractC21707u0 implements InterfaceC15524jj6 {
    private final C9528a7 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14934ij6(final C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = C12736f7.n().f("security/router", C4614Fw5.d(new V6() { // from class: ir.nasim.hj6
            @Override // ir.nasim.V6
            public final K6 create() {
                return C14934ij6.M(c9057Yh4);
            }
        }).a("D_heavy"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J(AuthOuterClass$ResponseGetAuthSessions authOuterClass$ResponseGetAuthSessions) {
        AbstractC13042fc3.i(authOuterClass$ResponseGetAuthSessions, "response");
        return authOuterClass$ResponseGetAuthSessions.getUserAuthsList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String L(AuthOuterClass$ResponseSendDeleteAccountVerificationCode authOuterClass$ResponseSendDeleteAccountVerificationCode) {
        AbstractC13042fc3.i(authOuterClass$ResponseSendDeleteAccountVerificationCode, "response");
        return authOuterClass$ResponseSendDeleteAccountVerificationCode.getTransactionHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 M(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "$context");
        return new C3553Bi6(c9057Yh4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 O(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Q(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    public final C6517Nv5 G(String str, String str2) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(str2, "transactionHash");
        GeneratedMessageLite generatedMessageLiteA = AuthOuterClass$RequestDeleteAccount.newBuilder().A(str).B(str2).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.auth.v1.Auth/DeleteAccount", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.dj6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C14934ij6.H((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 I() {
        AuthOuterClass$RequestGetAuthSessions defaultInstance = AuthOuterClass$RequestGetAuthSessions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        AuthOuterClass$ResponseGetAuthSessions defaultInstance2 = AuthOuterClass$ResponseGetAuthSessions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = x(new C22871vx5("/bale.auth.v1.Auth/GetAuthSessions", defaultInstance, defaultInstance2)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.cj6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C14934ij6.J((AuthOuterClass$ResponseGetAuthSessions) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 K() {
        AuthOuterClass$RequestSendDeleteAccountVerificationCode defaultInstance = AuthOuterClass$RequestSendDeleteAccountVerificationCode.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        AuthOuterClass$ResponseSendDeleteAccountVerificationCode defaultInstance2 = AuthOuterClass$ResponseSendDeleteAccountVerificationCode.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = x(new C22871vx5("/bale.auth.v1.Auth/SendDeleteAccountVerificationCode", defaultInstance, defaultInstance2)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.gj6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C14934ij6.L((AuthOuterClass$ResponseSendDeleteAccountVerificationCode) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    public final C6517Nv5 N() {
        AuthOuterClass$RequestTerminateAllSessions defaultInstance = AuthOuterClass$RequestTerminateAllSessions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        Misc$ResponseVoid defaultInstance2 = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.auth.v1.Auth/TerminateAllSessions", defaultInstance, defaultInstance2)).H(new InterfaceC17569nB2() { // from class: ir.nasim.ej6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C14934ij6.O((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 P(int i) {
        GeneratedMessageLite generatedMessageLiteA = AuthOuterClass$RequestTerminateSession.newBuilder().A(i).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.auth.v1.Auth/TerminateSession", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.fj6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C14934ij6.Q((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    @Override // ir.nasim.InterfaceC15524jj6
    public void n() {
        this.b.d(new C3553Bi6.a());
    }
}
