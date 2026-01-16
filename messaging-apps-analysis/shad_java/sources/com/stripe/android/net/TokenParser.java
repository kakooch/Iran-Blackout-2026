package com.stripe.android.net;

import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.util.StripeJsonUtils;
import com.stripe.android.util.StripeTextUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TokenParser {
    public static Token parseToken(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = StripeJsonUtils.getString(jSONObject, "id");
        Long lValueOf = Long.valueOf(jSONObject.getLong("created"));
        Boolean boolValueOf = Boolean.valueOf(jSONObject.getBoolean("livemode"));
        String strAsTokenType = StripeTextUtils.asTokenType(StripeJsonUtils.getString(jSONObject, "type"));
        Boolean boolValueOf2 = Boolean.valueOf(jSONObject.getBoolean("used"));
        Card card = CardParser.parseCard(jSONObject.getJSONObject("card"));
        return new Token(string, boolValueOf.booleanValue(), new Date(lValueOf.longValue() * 1000), boolValueOf2, card, strAsTokenType);
    }
}
