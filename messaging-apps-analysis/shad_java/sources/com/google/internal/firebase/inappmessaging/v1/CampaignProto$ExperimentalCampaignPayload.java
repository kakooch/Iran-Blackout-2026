package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.ExperimentPayloadProto$ExperimentPayload;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class CampaignProto$ExperimentalCampaignPayload extends GeneratedMessageLite<CampaignProto$ExperimentalCampaignPayload, Builder> implements MessageLiteOrBuilder {
    public static final int CAMPAIGN_END_TIME_MILLIS_FIELD_NUMBER = 4;
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 5;
    public static final int CAMPAIGN_START_TIME_MILLIS_FIELD_NUMBER = 3;
    private static final CampaignProto$ExperimentalCampaignPayload DEFAULT_INSTANCE;
    public static final int EXPERIMENT_PAYLOAD_FIELD_NUMBER = 2;
    private static volatile Parser<CampaignProto$ExperimentalCampaignPayload> PARSER;
    private long campaignEndTimeMillis_;
    private String campaignId_ = BuildConfig.FLAVOR;
    private String campaignName_ = BuildConfig.FLAVOR;
    private long campaignStartTimeMillis_;
    private ExperimentPayloadProto$ExperimentPayload experimentPayload_;

    private CampaignProto$ExperimentalCampaignPayload() {
    }

    public String getCampaignId() {
        return this.campaignId_;
    }

    public ExperimentPayloadProto$ExperimentPayload getExperimentPayload() {
        ExperimentPayloadProto$ExperimentPayload experimentPayloadProto$ExperimentPayload = this.experimentPayload_;
        return experimentPayloadProto$ExperimentPayload == null ? ExperimentPayloadProto$ExperimentPayload.getDefaultInstance() : experimentPayloadProto$ExperimentPayload;
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

    public static final class Builder extends GeneratedMessageLite.Builder<CampaignProto$ExperimentalCampaignPayload, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CampaignProto$1 campaignProto$1) {
            this();
        }

        private Builder() {
            super(CampaignProto$ExperimentalCampaignPayload.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CampaignProto$1 campaignProto$1 = null;
        switch (CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignProto$ExperimentalCampaignPayload();
            case 2:
                return new Builder(campaignProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0002\u0004\u0002\u0005Ȉ", new Object[]{"campaignId_", "experimentPayload_", "campaignStartTimeMillis_", "campaignEndTimeMillis_", "campaignName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CampaignProto$ExperimentalCampaignPayload> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CampaignProto$ExperimentalCampaignPayload.class) {
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
        CampaignProto$ExperimentalCampaignPayload campaignProto$ExperimentalCampaignPayload = new CampaignProto$ExperimentalCampaignPayload();
        DEFAULT_INSTANCE = campaignProto$ExperimentalCampaignPayload;
        GeneratedMessageLite.registerDefaultInstance(CampaignProto$ExperimentalCampaignPayload.class, campaignProto$ExperimentalCampaignPayload);
    }

    public static CampaignProto$ExperimentalCampaignPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
