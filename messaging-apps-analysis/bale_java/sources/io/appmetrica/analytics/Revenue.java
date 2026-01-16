package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.Am;
import io.appmetrica.analytics.impl.C2875td;
import java.util.Currency;

/* loaded from: classes3.dex */
public class Revenue {
    public final Currency currency;
    public final String payload;
    public final long priceMicros;
    public final String productID;
    public final Integer quantity;
    public final Receipt receipt;

    public static class Builder {
        private static final Am g = new Am(new C2875td("revenue currency"));
        final long a;
        final Currency b;
        Integer c;
        String d;
        String e;
        Receipt f;

        /* synthetic */ Builder(long j, Currency currency, int i) {
            this(j, currency);
        }

        public Revenue build() {
            return new Revenue(this, 0);
        }

        public Builder withPayload(String str) {
            this.e = str;
            return this;
        }

        public Builder withProductID(String str) {
            this.d = str;
            return this;
        }

        public Builder withQuantity(Integer num) {
            this.c = num;
            return this;
        }

        public Builder withReceipt(Receipt receipt) {
            this.f = receipt;
            return this;
        }

        private Builder(long j, Currency currency) {
            g.a(currency);
            this.a = j;
            this.b = currency;
        }
    }

    public static class Receipt {
        public final String data;
        public final String signature;

        public static class Builder {
            private String a;
            private String b;

            /* synthetic */ Builder(int i) {
                this();
            }

            public Receipt build() {
                return new Receipt(this, 0);
            }

            public Builder withData(String str) {
                this.a = str;
                return this;
            }

            public Builder withSignature(String str) {
                this.b = str;
                return this;
            }

            private Builder() {
            }
        }

        /* synthetic */ Receipt(Builder builder, int i) {
            this(builder);
        }

        public static Builder newBuilder() {
            return new Builder(0);
        }

        private Receipt(Builder builder) {
            this.data = builder.a;
            this.signature = builder.b;
        }
    }

    /* synthetic */ Revenue(Builder builder, int i) {
        this(builder);
    }

    public static Builder newBuilder(long j, Currency currency) {
        return new Builder(j, currency, 0);
    }

    private Revenue(Builder builder) {
        this.priceMicros = builder.a;
        this.currency = builder.b;
        this.quantity = builder.c;
        this.productID = builder.d;
        this.payload = builder.e;
        this.receipt = builder.f;
    }
}
