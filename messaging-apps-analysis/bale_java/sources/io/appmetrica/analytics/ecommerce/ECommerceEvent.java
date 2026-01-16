package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.C2424ak;
import io.appmetrica.analytics.impl.C2474ck;
import io.appmetrica.analytics.impl.C2524ek;
import io.appmetrica.analytics.impl.C2985y3;
import io.appmetrica.analytics.impl.Fd;
import io.appmetrica.analytics.impl.We;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements We {
    protected ECommerceEvent() {
    }

    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C2985y3(4, eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Fd(6, eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Fd(7, eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new C2985y3(5, eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C2424ak(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C2474ck(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C2524ek(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // io.appmetrica.analytics.impl.We
    public abstract /* synthetic */ List toProto();
}
