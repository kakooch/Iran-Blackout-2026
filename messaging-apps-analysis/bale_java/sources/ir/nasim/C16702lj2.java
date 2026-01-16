package ir.nasim;

import android.content.Context;
import ir.nasim.jaryan.feed.data.db.FeedDatabase;

/* renamed from: ir.nasim.lj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16702lj2 {
    public static final C16702lj2 a = new C16702lj2();

    private C16702lj2() {
    }

    public final InterfaceC15500jh2 a(FeedDatabase feedDatabase) {
        AbstractC13042fc3.i(feedDatabase, "feedDatabase");
        return feedDatabase.H();
    }

    public final FeedDatabase b(Context context) {
        AbstractC13042fc3.i(context, "context");
        return (FeedDatabase) C26.a(context, FeedDatabase.class, "feed_db").b(AbstractC6055Lz1.a()).b(AbstractC6055Lz1.b()).g().e();
    }

    public final C21544tj2 c() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        return new C21544tj2(interfaceC3570Bk5Q);
    }
}
