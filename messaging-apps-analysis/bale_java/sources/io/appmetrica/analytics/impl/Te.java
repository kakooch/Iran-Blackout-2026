package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Te {
    public final String a;
    public final String b;
    public final List c;
    public final Map d;
    public final Me e;
    public final Me f;
    public final List g;

    public Te(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Me(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() == null ? null : new Me(eCommerceProduct.getOriginalPrice()), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + '}';
    }

    public Te(String str, String str2, List list, Map map, Me me2, Me me3, List list2) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = me2;
        this.f = me3;
        this.g = list2;
    }
}
