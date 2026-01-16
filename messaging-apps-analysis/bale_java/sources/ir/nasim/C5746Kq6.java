package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.bank.mybank.model.ServiceBannerEntity;

/* renamed from: ir.nasim.Kq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5746Kq6 {
    public static final a g = new a(null);
    public static final int h = 0;
    private final int a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final int f;

    /* renamed from: ir.nasim.Kq6$a */
    public static final class a {
        private a() {
        }

        public final C5746Kq6 a(ServiceBannerEntity serviceBannerEntity) {
            AbstractC13042fc3.i(serviceBannerEntity, "serviceBannerEntity");
            return new C5746Kq6(serviceBannerEntity.getId(), serviceBannerEntity.getBannerUrl(), serviceBannerEntity.getPayloadUrl(), serviceBannerEntity.getPayloadPeerId(), serviceBannerEntity.getPayloadPeerType(), serviceBannerEntity.getActionType());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5746Kq6(int i, String str, String str2, int i2, int i3, int i4) {
        AbstractC13042fc3.i(str, "bannerUrl");
        AbstractC13042fc3.i(str2, "payloadUrl");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final int a() {
        return this.f;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5746Kq6)) {
            return false;
        }
        C5746Kq6 c5746Kq6 = (C5746Kq6) obj;
        return this.a == c5746Kq6.a && AbstractC13042fc3.d(this.b, c5746Kq6.b) && AbstractC13042fc3.d(this.c, c5746Kq6.c) && this.d == c5746Kq6.d && this.e == c5746Kq6.e && this.f == c5746Kq6.f;
    }

    public final String f() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "ServiceBannerUI(id=" + this.a + ", bannerUrl=" + this.b + ", payloadUrl=" + this.c + ", payloadPeerId=" + this.d + ", payloadPeerType=" + this.e + ", actionType=" + this.f + Separators.RPAREN;
    }
}
