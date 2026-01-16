package ir.nasim;

import ai.bale.proto.SearchOuterClass$ResponseSearchMarket;
import ai.bale.proto.SearchStruct$MarketSearchResult;
import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.vg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22698vg6 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final ArrayList a;
    private final int b;
    private final byte[] c;

    /* renamed from: ir.nasim.vg6$a */
    public static final class a {
        private a() {
        }

        public final C22698vg6 a(SearchOuterClass$ResponseSearchMarket searchOuterClass$ResponseSearchMarket) {
            AbstractC13042fc3.i(searchOuterClass$ResponseSearchMarket, "response");
            ArrayList arrayList = new ArrayList();
            List<SearchStruct$MarketSearchResult> marketResultsList = searchOuterClass$ResponseSearchMarket.getMarketResultsList();
            AbstractC13042fc3.h(marketResultsList, "getMarketResultsList(...)");
            for (SearchStruct$MarketSearchResult searchStruct$MarketSearchResult : marketResultsList) {
                b.a aVar = b.f;
                AbstractC13042fc3.f(searchStruct$MarketSearchResult);
                arrayList.add(aVar.a(searchStruct$MarketSearchResult));
            }
            int resultCount = searchOuterClass$ResponseSearchMarket.getResultCount();
            byte[] bArrA0 = searchOuterClass$ResponseSearchMarket.getLoadMoreState().getValue().a0();
            AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
            return new C22698vg6(arrayList, resultCount, bArrA0);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vg6$b */
    public static final class b {
        public static final a f = new a(null);
        private final String a;
        private final String b;
        private final int c;
        private final String d;
        private final String e;

        /* renamed from: ir.nasim.vg6$b$a */
        public static final class a {
            private a() {
            }

            public final b a(SearchStruct$MarketSearchResult searchStruct$MarketSearchResult) {
                AbstractC13042fc3.i(searchStruct$MarketSearchResult, "response");
                String value = searchStruct$MarketSearchResult.getChannelNick().getValue();
                AbstractC13042fc3.h(value, "getValue(...)");
                String channelTitle = searchStruct$MarketSearchResult.getChannelTitle();
                AbstractC13042fc3.h(channelTitle, "getChannelTitle(...)");
                int channelId = searchStruct$MarketSearchResult.getChannelId();
                String value2 = searchStruct$MarketSearchResult.getChannelAbout().getValue();
                AbstractC13042fc3.h(value2, "getValue(...)");
                return new b(value, channelTitle, channelId, value2, "tv");
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(String str, String str2, int i, String str3, String str4) {
            AbstractC13042fc3.i(str, "nick");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(str3, "about");
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = str4;
        }

        public final String a() {
            return this.d;
        }

        public final String b() {
            return this.e;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.graphics.drawable.Drawable c(android.content.Context r5) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                ir.nasim.AbstractC13042fc3.i(r5, r0)
                java.lang.String r0 = r4.e
                r1 = 0
                if (r0 == 0) goto L4d
                int r2 = r0.hashCode()
                r3 = 3714(0xe82, float:5.204E-42)
                if (r2 == r3) goto L3d
                r3 = 96432(0x178b0, float:1.3513E-40)
                if (r2 == r3) goto L2d
                r3 = 50511102(0x302bcfe, float:3.842052E-37)
                if (r2 == r3) goto L1d
                goto L4d
            L1d:
                java.lang.String r2 = "category"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L26
                goto L4d
            L26:
                int r0 = ir.nasim.KB5.drawable_market_suggestion_category
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L4e
            L2d:
                java.lang.String r2 = "ads"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L36
                goto L4d
            L36:
                int r0 = ir.nasim.KB5.drawable_market_suggestion_ads
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L4e
            L3d:
                java.lang.String r2 = "tv"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L46
                goto L4d
            L46:
                int r0 = ir.nasim.KB5.drawable_market_suggestion_tv
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L4e
            L4d:
                r0 = r1
            L4e:
                if (r0 != 0) goto L51
                goto L59
            L51:
                int r0 = r0.intValue()
                android.graphics.drawable.Drawable r1 = ir.nasim.AbstractC4043Dl1.f(r5, r0)
            L59:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22698vg6.b.c(android.content.Context):android.graphics.drawable.Drawable");
        }

        public final int d() {
            return this.c;
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public final String f() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
            String str = this.e;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Peer(nick=" + this.a + ", title=" + this.b + ", id=" + this.c + ", about=" + this.d + ", drawable=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.vg6$c */
    public static final class c {
    }

    /* renamed from: ir.nasim.vg6$d */
    public static final class d {
    }

    public C22698vg6(ArrayList arrayList, int i, byte[] bArr) {
        AbstractC13042fc3.i(arrayList, "peers");
        AbstractC13042fc3.i(bArr, "loadMore");
        this.a = arrayList;
        this.b = i;
        this.c = bArr;
    }

    public final int a() {
        return this.b;
    }

    public final byte[] b() {
        return this.c;
    }

    public final ArrayList c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C22698vg6.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchMarketResponse");
        C22698vg6 c22698vg6 = (C22698vg6) obj;
        return AbstractC13042fc3.d(this.a, c22698vg6.a) && this.b == c22698vg6.b && Arrays.equals(this.c, c22698vg6.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + Arrays.hashCode(this.c);
    }

    public String toString() {
        return "SearchMarketResponse(peers=" + this.a + ", count=" + this.b + ", loadMore=" + Arrays.toString(this.c) + Separators.RPAREN;
    }
}
