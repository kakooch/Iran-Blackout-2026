package com.google.internal.firebase.inappmessaging.v1;

import com.google.firebase.inappmessaging.CommonTypesProto$Priority;
import com.google.firebase.inappmessaging.CommonTypesProto$TriggeringCondition;
import com.google.firebase.inappmessaging.MessagesProto$Content;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class CampaignProto$ThickContent extends GeneratedMessageLite<CampaignProto$ThickContent, Builder> implements MessageLiteOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
    private static final CampaignProto$ThickContent DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    private static volatile Parser<CampaignProto$ThickContent> PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    private MessagesProto$Content content_;
    private boolean isTestCampaign_;
    private Object payload_;
    private CommonTypesProto$Priority priority_;
    private int payloadCase_ = 0;
    private MapFieldLite<String, String> dataBundle_ = MapFieldLite.emptyMapField();
    private Internal.ProtobufList<CommonTypesProto$TriggeringCondition> triggeringConditions_ = GeneratedMessageLite.emptyProtobufList();

    private CampaignProto$ThickContent() {
    }

    public enum PayloadCase {
        VANILLA_PAYLOAD(1),
        EXPERIMENTAL_PAYLOAD(2),
        PAYLOAD_NOT_SET(0);

        PayloadCase(int i) {
        }

        public static PayloadCase forNumber(int i) {
            if (i == 0) {
                return PAYLOAD_NOT_SET;
            }
            if (i == 1) {
                return VANILLA_PAYLOAD;
            }
            if (i != 2) {
                return null;
            }
            return EXPERIMENTAL_PAYLOAD;
        }
    }

    public PayloadCase getPayloadCase() {
        return PayloadCase.forNumber(this.payloadCase_);
    }

    public CampaignProto$VanillaCampaignPayload getVanillaPayload() {
        if (this.payloadCase_ == 1) {
            return (CampaignProto$VanillaCampaignPayload) this.payload_;
        }
        return CampaignProto$VanillaCampaignPayload.getDefaultInstance();
    }

    public CampaignProto$ExperimentalCampaignPayload getExperimentalPayload() {
        if (this.payloadCase_ == 2) {
            return (CampaignProto$ExperimentalCampaignPayload) this.payload_;
        }
        return CampaignProto$ExperimentalCampaignPayload.getDefaultInstance();
    }

    public MessagesProto$Content getContent() {
        MessagesProto$Content messagesProto$Content = this.content_;
        return messagesProto$Content == null ? MessagesProto$Content.getDefaultInstance() : messagesProto$Content;
    }

    public CommonTypesProto$Priority getPriority() {
        CommonTypesProto$Priority commonTypesProto$Priority = this.priority_;
        return commonTypesProto$Priority == null ? CommonTypesProto$Priority.getDefaultInstance() : commonTypesProto$Priority;
    }

    public List<CommonTypesProto$TriggeringCondition> getTriggeringConditionsList() {
        return this.triggeringConditions_;
    }

    public boolean getIsTestCampaign() {
        return this.isTestCampaign_;
    }

    private static final class DataBundleDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, BuildConfig.FLAVOR, fieldType, BuildConfig.FLAVOR);
        }
    }

    private MapFieldLite<String, String> internalGetDataBundle() {
        return this.dataBundle_;
    }

    public Map<String, String> getDataBundleMap() {
        return Collections.unmodifiableMap(internalGetDataBundle());
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CampaignProto$ThickContent, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CampaignProto$1 campaignProto$1) {
            this();
        }

        private Builder() {
            super(CampaignProto$ThickContent.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CampaignProto$1 campaignProto$1 = null;
        switch (CampaignProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CampaignProto$ThickContent();
            case 2:
                return new Builder(campaignProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\b\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003\t\u0004\t\u0005\u001b\u0007\u0007\b2", new Object[]{"payload_", "payloadCase_", CampaignProto$VanillaCampaignPayload.class, CampaignProto$ExperimentalCampaignPayload.class, "content_", "priority_", "triggeringConditions_", CommonTypesProto$TriggeringCondition.class, "isTestCampaign_", "dataBundle_", DataBundleDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CampaignProto$ThickContent> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CampaignProto$ThickContent.class) {
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
        CampaignProto$ThickContent campaignProto$ThickContent = new CampaignProto$ThickContent();
        DEFAULT_INSTANCE = campaignProto$ThickContent;
        GeneratedMessageLite.registerDefaultInstance(CampaignProto$ThickContent.class, campaignProto$ThickContent);
    }
}
