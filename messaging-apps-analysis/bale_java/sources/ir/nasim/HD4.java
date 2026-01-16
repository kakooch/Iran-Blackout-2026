package ir.nasim;

/* loaded from: classes5.dex */
public interface HD4 {
    static /* synthetic */ void a(HD4 hd4, String str, String str2, long j, long j2, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteOlderReactionsByMessageKeyForGroup");
        }
        hd4.w(str, str2, j, j2, (i & 16) != 0 ? EnumC13889gz5.f : enumC13889gz5);
    }

    static /* synthetic */ void b(HD4 hd4, String str, String str2, long j, long j2, String str3, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteOlderReactionByMessageKeyAndReactionCode");
        }
        hd4.l(str, str2, j, j2, str3, (i & 32) != 0 ? EnumC13889gz5.f : enumC13889gz5);
    }

    static /* synthetic */ JD4 f(HD4 hd4, String str, String str2, long j, String str3, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectLatestReactionByMessageKeyAndPushTypeAndReactionCode");
        }
        if ((i & 16) != 0) {
            enumC13889gz5 = EnumC13889gz5.f;
        }
        return hd4.o(str, str2, j, str3, enumC13889gz5);
    }

    static /* synthetic */ void h(HD4 hd4, String str, long j, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteOlderByPeerIdAndMessageDateExceptDeleteType");
        }
        if ((i & 4) != 0) {
            enumC13889gz5 = EnumC13889gz5.c;
        }
        hd4.v(str, j, enumC13889gz5);
    }

    static /* synthetic */ void i(HD4 hd4, String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAllByMessageKeyExceptReactionAndReadType");
        }
        if ((i & 8) != 0) {
            enumC13889gz5 = EnumC13889gz5.f;
        }
        EnumC13889gz5 enumC13889gz53 = enumC13889gz5;
        if ((i & 16) != 0) {
            enumC13889gz52 = EnumC13889gz5.e;
        }
        hd4.n(str, str2, j, enumC13889gz53, enumC13889gz52);
    }

    static /* synthetic */ JD4 j(HD4 hd4, String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52, EnumC13889gz5 enumC13889gz53, int i, Object obj) {
        if (obj == null) {
            return hd4.g(str, str2, j, (i & 8) != 0 ? EnumC13889gz5.b : enumC13889gz5, (i & 16) != 0 ? EnumC13889gz5.h : enumC13889gz52, (i & 32) != 0 ? EnumC13889gz5.i : enumC13889gz53);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectLatestMessageByMessageKeyExceptReactionType");
    }

    static /* synthetic */ JD4 k(HD4 hd4, String str, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectLatestReadByPeerId");
        }
        if ((i & 2) != 0) {
            enumC13889gz5 = EnumC13889gz5.e;
        }
        return hd4.e(str, enumC13889gz5);
    }

    static /* synthetic */ JD4 r(HD4 hd4, String str, long j, EnumC13889gz5 enumC13889gz5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectLatestMessageCommentReplyMessage");
        }
        if ((i & 4) != 0) {
            enumC13889gz5 = EnumC13889gz5.j;
        }
        return hd4.c(str, j, enumC13889gz5);
    }

    JD4 c(String str, long j, EnumC13889gz5 enumC13889gz5);

    Integer d(String str, String str2, long j, EnumC13889gz5 enumC13889gz5);

    JD4 e(String str, EnumC13889gz5 enumC13889gz5);

    JD4 g(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52, EnumC13889gz5 enumC13889gz53);

    void l(String str, String str2, long j, long j2, String str3, EnumC13889gz5 enumC13889gz5);

    JD4 m(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, long j2, String str3, Integer num);

    void n(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, EnumC13889gz5 enumC13889gz52);

    JD4 o(String str, String str2, long j, String str3, EnumC13889gz5 enumC13889gz5);

    void p(JD4 jd4);

    void q(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, int i);

    JD4 s(String str, String str2, long j, EnumC13889gz5 enumC13889gz5);

    JD4 t(String str, String str2, long j, EnumC13889gz5 enumC13889gz5, String str3);

    void u(String str, String str2, long j, EnumC13889gz5 enumC13889gz5);

    void v(String str, long j, EnumC13889gz5 enumC13889gz5);

    void w(String str, String str2, long j, long j2, EnumC13889gz5 enumC13889gz5);
}
