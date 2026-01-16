package com.google.internal.firebase.inappmessaging.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class CampaignProto$VanillaCampaignPayload extends GeneratedMessageLite<CampaignProto$VanillaCampaignPayload, Builder> implements MessageLiteOrBuilder {
    public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
    public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
    private static final CampaignProto$VanillaCampaignPayload DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_CAMPAIGN_ID_FIELD_NUMBER = 2;
    private static volatile Parser<CampaignProto$VanillaCampaignPayload> PARSER;
    private long campaignEndTimeMillis_;
    private long campaignStartTimeMillis_;
    private String campaignId_ = BuildConfig.FLAVOR;
    private String experimentalCampaignId_ = BuildConfig.FLAVOR;
    private String campaignName_ = BuildConfig.FLAVOR;

    private CampaignProto$VanillaCampaignPayload() {
    }

    public String getCampaignId() {
        return this.campaignId_;
    }

    public long getCampaignStartTimeMillis() {
        return this.campaignStartTimeMillis_;
    }

    public long getCampaignEndTimeMillis() {
        return this.campaignEndTimeMillis_;
    }

    public String getCampaignName() {
        return this.campaignName_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CampaignProto$VanillaCampaignPayload, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CampaignProto$1 campaignProto$1) {
            this();
        }

        private Builder() {
            super(CampaignProto$VanillaCampaignPayload.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CampaignProto$1 campaignProto$1 = null;
        switch (CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignProto$VanillaCampaignPayload();
            case 2:
                return new Builder(campaignProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0002\u0005Ȉ", new Object[]{"campaignId_", "experimentalCampaignId_", "campaignStartTimeMillis_", "campaignEndTimeMillis_", "campaignName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CampaignProto$VanillaCampaignPayload> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CampaignProto$VanillaCampaignPayload.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        CampaignProto$VanillaCampaignPayload campaignProto$VanillaCampaignPayload = new CampaignProto$VanillaCampaignPayload();
        DEFAULT_INSTANCE = campaignProto$VanillaCampaignPayload;
        GeneratedMessageLite.registerDefaultInstance(CampaignProto$VanillaCampaignPayload.class, campaignProto$VanillaCampaignPayload);
    }

    public static CampaignProto$VanillaCampaignPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
