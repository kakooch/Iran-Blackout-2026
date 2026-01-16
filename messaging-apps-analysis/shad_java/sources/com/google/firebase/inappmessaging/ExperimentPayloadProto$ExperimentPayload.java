package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class ExperimentPayloadProto$ExperimentPayload extends GeneratedMessageLite<ExperimentPayloadProto$ExperimentPayload, Builder> implements MessageLiteOrBuilder {
    public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
    public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
    private static final ExperimentPayloadProto$ExperimentPayload DEFAULT_INSTANCE;
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
    public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
    public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
    private static volatile Parser<ExperimentPayloadProto$ExperimentPayload> PARSER = null;
    public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
    public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
    public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
    public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
    public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
    public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
    public static final int VARIANT_ID_FIELD_NUMBER = 2;
    private long experimentStartTimeMillis_;
    private int overflowPolicy_;
    private long timeToLiveMillis_;
    private long triggerTimeoutMillis_;
    private String experimentId_ = BuildConfig.FLAVOR;
    private String variantId_ = BuildConfig.FLAVOR;
    private String triggerEvent_ = BuildConfig.FLAVOR;
    private String setEventToLog_ = BuildConfig.FLAVOR;
    private String activateEventToLog_ = BuildConfig.FLAVOR;
    private String clearEventToLog_ = BuildConfig.FLAVOR;
    private String timeoutEventToLog_ = BuildConfig.FLAVOR;
    private String ttlExpiryEventToLog_ = BuildConfig.FLAVOR;
    private Internal.ProtobufList<ExperimentPayloadProto$ExperimentLite> ongoingExperiments_ = GeneratedMessageLite.emptyProtobufList();

    private ExperimentPayloadProto$ExperimentPayload() {
    }

    public String getExperimentId() {
        return this.experimentId_;
    }

    public String getVariantId() {
        return this.variantId_;
    }

    public long getExperimentStartTimeMillis() {
        return this.experimentStartTimeMillis_;
    }

    public String getTriggerEvent() {
        return this.triggerEvent_;
    }

    public long getTriggerTimeoutMillis() {
        return this.triggerTimeoutMillis_;
    }

    public long getTimeToLiveMillis() {
        return this.timeToLiveMillis_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayloadProto$ExperimentPayload, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(ExperimentPayloadProto$1 experimentPayloadProto$1) {
            this();
        }

        private Builder() {
            super(ExperimentPayloadProto$ExperimentPayload.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ExperimentPayloadProto$1 experimentPayloadProto$1 = null;
        switch (ExperimentPayloadProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ExperimentPayloadProto$ExperimentPayload();
            case 2:
                return new Builder(experimentPayloadProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", ExperimentPayloadProto$ExperimentLite.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExperimentPayloadProto$ExperimentPayload> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (ExperimentPayloadProto$ExperimentPayload.class) {
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
        ExperimentPayloadProto$ExperimentPayload experimentPayloadProto$ExperimentPayload = new ExperimentPayloadProto$ExperimentPayload();
        DEFAULT_INSTANCE = experimentPayloadProto$ExperimentPayload;
        GeneratedMessageLite.registerDefaultInstance(ExperimentPayloadProto$ExperimentPayload.class, experimentPayloadProto$ExperimentPayload);
    }

    public static ExperimentPayloadProto$ExperimentPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
