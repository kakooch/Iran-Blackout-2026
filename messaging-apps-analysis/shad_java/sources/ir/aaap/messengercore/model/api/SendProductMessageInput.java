package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ProductMessageData;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SendProductMessageInput {
    public String object_guid;
    public String product_id;
    public ArrayList<ProductMessageData.ProductMessageVariety> product_varieties = null;
    public long rnd;
    public String store_id;
}
