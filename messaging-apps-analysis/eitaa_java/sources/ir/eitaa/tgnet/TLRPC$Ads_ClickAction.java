package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$Ads_ClickAction extends TLObject {
    public String link;
    public String uri;

    public static TLRPC$Ads_ClickAction TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Ads_ClickAction tLRPC$Ads_ClickAction;
        if (constructor == -1661694581) {
            tLRPC$Ads_ClickAction = new TLRPC$Ads_ClickAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_ads_openExternalLinkAction
                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream2, int constructor2, boolean exception2) {
                    return TLRPC$Ads_ClickAction.TLdeserialize(stream2, constructor2, exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.link = stream2.readString(exception2);
                }
            };
        } else if (constructor == -899560710) {
            tLRPC$Ads_ClickAction = new TLRPC$Ads_ClickAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_ads_openLinkAction
                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream2, int constructor2, boolean exception2) {
                    return TLRPC$Ads_ClickAction.TLdeserialize(stream2, constructor2, exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.link = stream2.readString(exception2);
                }
            };
        } else {
            tLRPC$Ads_ClickAction = constructor != 155099767 ? null : new TLRPC$Ads_ClickAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_ads_intentAction
                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream2, int constructor2, boolean exception2) {
                    return TLRPC$Ads_ClickAction.TLdeserialize(stream2, constructor2, exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.uri = stream2.readString(exception2);
                }
            };
        }
        if (tLRPC$Ads_ClickAction == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Ads_ClickAction", Integer.valueOf(constructor)));
        }
        if (tLRPC$Ads_ClickAction != null) {
            tLRPC$Ads_ClickAction.readParams(stream, exception);
        }
        return tLRPC$Ads_ClickAction;
    }
}
