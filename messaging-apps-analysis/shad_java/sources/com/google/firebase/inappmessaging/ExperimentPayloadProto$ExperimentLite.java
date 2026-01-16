package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class ExperimentPayloadProto$ExperimentLite extends GeneratedMessageLite<ExperimentPayloadProto$ExperimentLite, Builder> implements MessageLiteOrBuilder {
    private static final ExperimentPayloadProto$ExperimentLite DEFAULT_INSTANCE;
    public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ExperimentPayloadProto$ExperimentLite> PARSER;
    private String experimentId_ = BuildConfig.FLAVOR;

    private ExperimentPayloadProto$ExperimentLite() {
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ExperimentPayloadProto$ExperimentLite, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(ExperimentPayloadProto$1 experimentPayloadProto$1) {
            this();
        }

        private Builder() {
            super(ExperimentPayloadProto$ExperimentLite.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ExperimentPayloadProto$1 experimentPayloadProto$1 = null;
        switch (ExperimentPayloadProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ExperimentPayloadProto$ExperimentLite();
            case 2:
                return new Builder(experimentPayloadProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"experimentId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExperimentPayloadProto$ExperimentLite> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (ExperimentPayloadProto$ExperimentLite.class) {
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
        ExperimentPayloadProto$ExperimentLite experimentPayloadProto$ExperimentLite = new ExperimentPayloadProto$ExperimentLite();
        DEFAULT_INSTANCE = experimentPayloadProto$ExperimentLite;
        GeneratedMessageLite.registerDefaultInstance(ExperimentPayloadProto$ExperimentLite.class, experimentPayloadProto$ExperimentLite);
    }
}
