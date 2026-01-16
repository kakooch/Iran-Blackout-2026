package com.google.api;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6487Nt3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class MetricDescriptor extends GeneratedMessageLite implements e {
    private static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int launchStage_;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private int valueType_;
    private String name_ = "";
    private String type_ = "";
    private B.j labels_ = GeneratedMessageLite.emptyProtobufList();
    private String unit_ = "";
    private String description_ = "";
    private String displayName_ = "";

    public static final class MetricDescriptorMetadata extends GeneratedMessageLite implements U64 {
        private static final MetricDescriptorMetadata DEFAULT_INSTANCE;
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        private static volatile KW4 PARSER = null;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private Duration ingestDelay_;
        private int launchStage_;
        private Duration samplePeriod_;

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(a aVar) {
                this();
            }

            private a() {
                super(MetricDescriptorMetadata.DEFAULT_INSTANCE);
            }
        }

        static {
            MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata();
            DEFAULT_INSTANCE = metricDescriptorMetadata;
            GeneratedMessageLite.registerDefaultInstance(MetricDescriptorMetadata.class, metricDescriptorMetadata);
        }

        private MetricDescriptorMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIngestDelay() {
            this.ingestDelay_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLaunchStage() {
            this.launchStage_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSamplePeriod() {
            this.samplePeriod_ = null;
        }

        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeIngestDelay(Duration duration) {
            duration.getClass();
            Duration duration2 = this.ingestDelay_;
            if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
                this.ingestDelay_ = duration;
            } else {
                this.ingestDelay_ = (Duration) ((Duration.b) Duration.newBuilder(this.ingestDelay_).v(duration)).j();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSamplePeriod(Duration duration) {
            duration.getClass();
            Duration duration2 = this.samplePeriod_;
            if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
                this.samplePeriod_ = duration;
            } else {
                this.samplePeriod_ = (Duration) ((Duration.b) Duration.newBuilder(this.samplePeriod_).v(duration)).j();
            }
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIngestDelay(Duration duration) {
            duration.getClass();
            this.ingestDelay_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLaunchStage(EnumC6487Nt3 enumC6487Nt3) {
            this.launchStage_ = enumC6487Nt3.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLaunchStageValue(int i) {
            this.launchStage_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSamplePeriod(Duration duration) {
            duration.getClass();
            this.samplePeriod_ = duration;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[gVar.ordinal()]) {
                case 1:
                    return new MetricDescriptorMetadata();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"launchStage_", "samplePeriod_", "ingestDelay_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (MetricDescriptorMetadata.class) {
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

        public Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        @Deprecated
        public EnumC6487Nt3 getLaunchStage() {
            EnumC6487Nt3 enumC6487Nt3A = EnumC6487Nt3.a(this.launchStage_);
            return enumC6487Nt3A == null ? EnumC6487Nt3.UNRECOGNIZED : enumC6487Nt3A;
        }

        @Deprecated
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        public Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        public boolean hasIngestDelay() {
            return this.ingestDelay_ != null;
        }

        public boolean hasSamplePeriod() {
            return this.samplePeriod_ != null;
        }

        public static a newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return (a) DEFAULT_INSTANCE.createBuilder(metricDescriptorMetadata);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static MetricDescriptorMetadata parseFrom(AbstractC2383g abstractC2383g) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static MetricDescriptorMetadata parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static MetricDescriptorMetadata parseFrom(AbstractC2384h abstractC2384h) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static MetricDescriptorMetadata parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GeneratedMessageLite.g.values().length];
            a = iArr;
            try {
                iArr[GeneratedMessageLite.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.g.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.g.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.g.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.g.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.g.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.g.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends GeneratedMessageLite.b implements e {
        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }
    }

    public enum c implements B.c {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);

        private static final B.d g = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i) {
                return c.a(i);
            }
        }

        c(int i) {
            this.a = i;
        }

        public static c a(int i) {
            if (i == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (i == 1) {
                return GAUGE;
            }
            if (i == 2) {
                return DELTA;
            }
            if (i != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum d implements B.c {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);

        private static final B.d j = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i) {
                return d.a(i);
            }
        }

        d(int i) {
            this.a = i;
        }

        public static d a(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        GeneratedMessageLite.registerDefaultInstance(MetricDescriptor.class, metricDescriptor);
    }

    private MetricDescriptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
        ensureLabelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabels() {
        this.labels_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLaunchStage() {
        this.launchStage_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetricKind() {
        this.metricKind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    private void ensureLabelsIsMutable() {
        B.j jVar = this.labels_;
        if (jVar.u()) {
            return;
        }
        this.labels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
        if (metricDescriptorMetadata2 == null || metricDescriptorMetadata2 == MetricDescriptorMetadata.getDefaultInstance()) {
            this.metadata_ = metricDescriptorMetadata;
        } else {
            this.metadata_ = (MetricDescriptorMetadata) ((MetricDescriptorMetadata.a) MetricDescriptorMetadata.newBuilder(this.metadata_).v(metricDescriptorMetadata)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (MetricDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLabels(int i) {
        ensureLabelsIsMutable();
        this.labels_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabels(int i, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.set(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaunchStage(EnumC6487Nt3 enumC6487Nt3) {
        this.launchStage_ = enumC6487Nt3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaunchStageValue(int i) {
        this.launchStage_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        this.metadata_ = metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKind(c cVar) {
        this.metricKind_ = cVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKindValue(int i) {
        this.metricKind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.type_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnit(String str) {
        str.getClass();
        this.unit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.unit_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueType(d dVar) {
        this.valueType_ = dVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueTypeValue(int i) {
        this.valueType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.a[gVar.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\f\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\n\t\f\f", new Object[]{"name_", "labels_", LabelDescriptor.class, "metricKind_", "valueType_", "unit_", "description_", "displayName_", "type_", "metadata_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MetricDescriptor.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public AbstractC2383g getDisplayNameBytes() {
        return AbstractC2383g.N(this.displayName_);
    }

    public LabelDescriptor getLabels(int i) {
        return (LabelDescriptor) this.labels_.get(i);
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public com.google.api.d getLabelsOrBuilder(int i) {
        return (com.google.api.d) this.labels_.get(i);
    }

    public List<? extends com.google.api.d> getLabelsOrBuilderList() {
        return this.labels_;
    }

    public EnumC6487Nt3 getLaunchStage() {
        EnumC6487Nt3 enumC6487Nt3A = EnumC6487Nt3.a(this.launchStage_);
        return enumC6487Nt3A == null ? EnumC6487Nt3.UNRECOGNIZED : enumC6487Nt3A;
    }

    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    public MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        return metricDescriptorMetadata == null ? MetricDescriptorMetadata.getDefaultInstance() : metricDescriptorMetadata;
    }

    public c getMetricKind() {
        c cVarA = c.a(this.metricKind_);
        return cVarA == null ? c.UNRECOGNIZED : cVarA;
    }

    public int getMetricKindValue() {
        return this.metricKind_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getType() {
        return this.type_;
    }

    public AbstractC2383g getTypeBytes() {
        return AbstractC2383g.N(this.type_);
    }

    public String getUnit() {
        return this.unit_;
    }

    public AbstractC2383g getUnitBytes() {
        return AbstractC2383g.N(this.unit_);
    }

    public d getValueType() {
        d dVarA = d.a(this.valueType_);
        return dVarA == null ? d.UNRECOGNIZED : dVarA;
    }

    public int getValueTypeValue() {
        return this.valueType_;
    }

    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    public static b newBuilder(MetricDescriptor metricDescriptor) {
        return (b) DEFAULT_INSTANCE.createBuilder(metricDescriptor);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MetricDescriptor parseFrom(AbstractC2383g abstractC2383g) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(int i, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        ensureLabelsIsMutable();
        this.labels_.add(i, labelDescriptor);
    }

    public static MetricDescriptor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MetricDescriptor parseFrom(AbstractC2384h abstractC2384h) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MetricDescriptor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
