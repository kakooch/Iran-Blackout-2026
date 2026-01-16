package ir.nasim;

import ir.nasim.features.share.ShareData;

/* loaded from: classes4.dex */
public abstract class K35 {

    public static final class a extends K35 {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }
    }

    public static final class b extends K35 {
        public static final int b = ShareData.e;
        private final ShareData a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ShareData shareData) {
            super(null);
            AbstractC13042fc3.i(shareData, "shareData");
            this.a = shareData;
        }

        public final ShareData a() {
            return this.a;
        }
    }

    private K35() {
    }

    public /* synthetic */ K35(ED1 ed1) {
        this();
    }
}
