package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC25061zg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestChangeCampaignState extends GeneratedMessageLite implements U64 {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestChangeCampaignState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REJECTION_REASON_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 2;
    private String campaignId_ = "";
    private String rejectionReason_ = "";
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestChangeCampaignState.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestChangeCampaignState advertisementOuterClass$RequestChangeCampaignState = new AdvertisementOuterClass$RequestChangeCampaignState();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestChangeCampaignState;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestChangeCampaignState.class, advertisementOuterClass$RequestChangeCampaignState);
    }

    private AdvertisementOuterClass$RequestChangeCampaignState() {
    }

    private void clearCampaignId() {
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = getDefaultInstance().getRejectionReason();
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCampaignId(String str) {
        str.getClass();
        this.campaignId_ = str;
    }

    private void setCampaignIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.campaignId_ = abstractC2383g.f0();
    }

    private void setRejectionReason(String str) {
        str.getClass();
        this.rejectionReason_ = str;
    }

    private void setRejectionReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rejectionReason_ = abstractC2383g.f0();
    }

    private void setState(EnumC25061zg enumC25061zg) {
        this.state_ = enumC25061zg.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestChangeCampaignState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003Ȉ", new Object[]{"campaignId_", "state_", "rejectionReason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestChangeCampaignState.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getCampaignId() {
        return this.campaignId_;
    }

    public AbstractC2383g getCampaignIdBytes() {
        return AbstractC2383g.N(this.campaignId_);
    }

    public String getRejectionReason() {
        return this.rejectionReason_;
    }

    public AbstractC2383g getRejectionReasonBytes() {
        return AbstractC2383g.N(this.rejectionReason_);
    }

    public EnumC25061zg getState() {
        EnumC25061zg enumC25061zgJ = EnumC25061zg.j(this.state_);
        return enumC25061zgJ == null ? EnumC25061zg.UNRECOGNIZED : enumC25061zgJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestChangeCampaignState advertisementOuterClass$RequestChangeCampaignState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestChangeCampaignState);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestChangeCampaignState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeCampaignState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
