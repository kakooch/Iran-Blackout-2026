package com.google.developers.mobile.targeting.proto;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class ClientSignalsProto$ClientSignals extends GeneratedMessageLite<ClientSignalsProto$ClientSignals, Builder> implements MessageLiteOrBuilder {
    public static final int APP_VERSION_FIELD_NUMBER = 1;
    private static final ClientSignalsProto$ClientSignals DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    private static volatile Parser<ClientSignalsProto$ClientSignals> PARSER = null;
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
    public static final int TIME_ZONE_FIELD_NUMBER = 4;
    private String appVersion_ = BuildConfig.FLAVOR;
    private String platformVersion_ = BuildConfig.FLAVOR;
    private String languageCode_ = BuildConfig.FLAVOR;
    private String timeZone_ = BuildConfig.FLAVOR;

    private ClientSignalsProto$ClientSignals() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppVersion(String str) {
        str.getClass();
        this.appVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformVersion(String str) {
        str.getClass();
        this.platformVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageCode(String str) {
        str.getClass();
        this.languageCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeZone(String str) {
        str.getClass();
        this.timeZone_ = str;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ClientSignalsProto$ClientSignals, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(ClientSignalsProto$1 clientSignalsProto$1) {
            this();
        }

        private Builder() {
            super(ClientSignalsProto$ClientSignals.DEFAULT_INSTANCE);
        }

        public Builder setAppVersion(String str) {
            copyOnWrite();
            ((ClientSignalsProto$ClientSignals) this.instance).setAppVersion(str);
            return this;
        }

        public Builder setPlatformVersion(String str) {
            copyOnWrite();
            ((ClientSignalsProto$ClientSignals) this.instance).setPlatformVersion(str);
            return this;
        }

        public Builder setLanguageCode(String str) {
            copyOnWrite();
            ((ClientSignalsProto$ClientSignals) this.instance).setLanguageCode(str);
            return this;
        }

        public Builder setTimeZone(String str) {
            copyOnWrite();
            ((ClientSignalsProto$ClientSignals) this.instance).setTimeZone(str);
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        ClientSignalsProto$1 clientSignalsProto$1 = null;
        switch (ClientSignalsProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientSignalsProto$ClientSignals();
            case 2:
                return new Builder(clientSignalsProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"appVersion_", "platformVersion_", "languageCode_", "timeZone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientSignalsProto$ClientSignals> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (ClientSignalsProto$ClientSignals.class) {
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
        ClientSignalsProto$ClientSignals clientSignalsProto$ClientSignals = new ClientSignalsProto$ClientSignals();
        DEFAULT_INSTANCE = clientSignalsProto$ClientSignals;
        GeneratedMessageLite.registerDefaultInstance(ClientSignalsProto$ClientSignals.class, clientSignalsProto$ClientSignals);
    }
}
