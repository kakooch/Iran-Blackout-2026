package com.google.api;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.Any;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC16228kv;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class Distribution extends GeneratedMessageLite implements U64 {
    public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
    public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final Distribution DEFAULT_INSTANCE;
    public static final int EXEMPLARS_FIELD_NUMBER = 10;
    public static final int MEAN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RANGE_FIELD_NUMBER = 4;
    public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
    private BucketOptions bucketOptions_;
    private long count_;
    private double mean_;
    private Range range_;
    private double sumOfSquaredDeviation_;
    private int bucketCountsMemoizedSerializedSize = -1;
    private B.i bucketCounts_ = GeneratedMessageLite.emptyLongList();
    private B.j exemplars_ = GeneratedMessageLite.emptyProtobufList();

    public static final class BucketOptions extends GeneratedMessageLite implements U64 {
        private static final BucketOptions DEFAULT_INSTANCE;
        public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
        public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
        public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
        private static volatile KW4 PARSER;
        private int optionsCase_ = 0;
        private Object options_;

        public static final class Explicit extends GeneratedMessageLite implements U64 {
            public static final int BOUNDS_FIELD_NUMBER = 1;
            private static final Explicit DEFAULT_INSTANCE;
            private static volatile KW4 PARSER;
            private int boundsMemoizedSerializedSize = -1;
            private B.b bounds_ = GeneratedMessageLite.emptyDoubleList();

            public static final class a extends GeneratedMessageLite.b implements U64 {
                /* synthetic */ a(a aVar) {
                    this();
                }

                private a() {
                    super(Explicit.DEFAULT_INSTANCE);
                }
            }

            static {
                Explicit explicit = new Explicit();
                DEFAULT_INSTANCE = explicit;
                GeneratedMessageLite.registerDefaultInstance(Explicit.class, explicit);
            }

            private Explicit() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllBounds(Iterable<? extends Double> iterable) {
                ensureBoundsIsMutable();
                AbstractC2377a.addAll((Iterable) iterable, (List) this.bounds_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addBounds(double d) {
                ensureBoundsIsMutable();
                this.bounds_.s1(d);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBounds() {
                this.bounds_ = GeneratedMessageLite.emptyDoubleList();
            }

            private void ensureBoundsIsMutable() {
                B.b bVar = this.bounds_;
                if (bVar.u()) {
                    return;
                }
                this.bounds_ = GeneratedMessageLite.mutableCopy(bVar);
            }

            public static Explicit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static a newBuilder() {
                return (a) DEFAULT_INSTANCE.createBuilder();
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream) {
                return (Explicit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseFrom(ByteBuffer byteBuffer) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static KW4 parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBounds(int i, double d) {
                ensureBoundsIsMutable();
                this.bounds_.S0(i, d);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.a[gVar.ordinal()]) {
                    case 1:
                        return new Explicit();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001#", new Object[]{"bounds_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        KW4 cVar = PARSER;
                        if (cVar == null) {
                            synchronized (Explicit.class) {
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

            public double getBounds(int i) {
                return this.bounds_.getDouble(i);
            }

            public int getBoundsCount() {
                return this.bounds_.size();
            }

            public List<Double> getBoundsList() {
                return this.bounds_;
            }

            public static a newBuilder(Explicit explicit) {
                return (a) DEFAULT_INSTANCE.createBuilder(explicit);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Explicit parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
            }

            public static Explicit parseFrom(AbstractC2383g abstractC2383g) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
            }

            public static Explicit parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
            }

            public static Explicit parseFrom(byte[] bArr) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Explicit parseFrom(byte[] bArr, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
            }

            public static Explicit parseFrom(InputStream inputStream) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Explicit parseFrom(InputStream inputStream, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Explicit parseFrom(AbstractC2384h abstractC2384h) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
            }

            public static Explicit parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
                return (Explicit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
            }
        }

        public static final class Exponential extends GeneratedMessageLite implements U64 {
            private static final Exponential DEFAULT_INSTANCE;
            public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            private static volatile KW4 PARSER = null;
            public static final int SCALE_FIELD_NUMBER = 3;
            private double growthFactor_;
            private int numFiniteBuckets_;
            private double scale_;

            public static final class a extends GeneratedMessageLite.b implements U64 {
                /* synthetic */ a(a aVar) {
                    this();
                }

                private a() {
                    super(Exponential.DEFAULT_INSTANCE);
                }
            }

            static {
                Exponential exponential = new Exponential();
                DEFAULT_INSTANCE = exponential;
                GeneratedMessageLite.registerDefaultInstance(Exponential.class, exponential);
            }

            private Exponential() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGrowthFactor() {
                this.growthFactor_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearScale() {
                this.scale_ = 0.0d;
            }

            public static Exponential getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static a newBuilder() {
                return (a) DEFAULT_INSTANCE.createBuilder();
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream) {
                return (Exponential) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseFrom(ByteBuffer byteBuffer) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static KW4 parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGrowthFactor(double d) {
                this.growthFactor_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setScale(double d) {
                this.scale_ = d;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.a[gVar.ordinal()]) {
                    case 1:
                        return new Exponential();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0000\u0003\u0000", new Object[]{"numFiniteBuckets_", "growthFactor_", "scale_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        KW4 cVar = PARSER;
                        if (cVar == null) {
                            synchronized (Exponential.class) {
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

            public double getGrowthFactor() {
                return this.growthFactor_;
            }

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            public double getScale() {
                return this.scale_;
            }

            public static a newBuilder(Exponential exponential) {
                return (a) DEFAULT_INSTANCE.createBuilder(exponential);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Exponential parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
            }

            public static Exponential parseFrom(AbstractC2383g abstractC2383g) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
            }

            public static Exponential parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
            }

            public static Exponential parseFrom(byte[] bArr) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Exponential parseFrom(byte[] bArr, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
            }

            public static Exponential parseFrom(InputStream inputStream) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exponential parseFrom(InputStream inputStream, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Exponential parseFrom(AbstractC2384h abstractC2384h) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
            }

            public static Exponential parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
                return (Exponential) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
            }
        }

        public static final class Linear extends GeneratedMessageLite implements U64 {
            private static final Linear DEFAULT_INSTANCE;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int OFFSET_FIELD_NUMBER = 3;
            private static volatile KW4 PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 2;
            private int numFiniteBuckets_;
            private double offset_;
            private double width_;

            public static final class a extends GeneratedMessageLite.b implements U64 {
                /* synthetic */ a(a aVar) {
                    this();
                }

                private a() {
                    super(Linear.DEFAULT_INSTANCE);
                }
            }

            static {
                Linear linear = new Linear();
                DEFAULT_INSTANCE = linear;
                GeneratedMessageLite.registerDefaultInstance(Linear.class, linear);
            }

            private Linear() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNumFiniteBuckets() {
                this.numFiniteBuckets_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOffset() {
                this.offset_ = 0.0d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearWidth() {
                this.width_ = 0.0d;
            }

            public static Linear getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static a newBuilder() {
                return (a) DEFAULT_INSTANCE.createBuilder();
            }

            public static Linear parseDelimitedFrom(InputStream inputStream) {
                return (Linear) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseFrom(ByteBuffer byteBuffer) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static KW4 parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNumFiniteBuckets(int i) {
                this.numFiniteBuckets_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOffset(double d) {
                this.offset_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setWidth(double d) {
                this.width_ = d;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.a[gVar.ordinal()]) {
                    case 1:
                        return new Linear();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0000\u0003\u0000", new Object[]{"numFiniteBuckets_", "width_", "offset_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        KW4 cVar = PARSER;
                        if (cVar == null) {
                            synchronized (Linear.class) {
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

            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            public double getOffset() {
                return this.offset_;
            }

            public double getWidth() {
                return this.width_;
            }

            public static a newBuilder(Linear linear) {
                return (a) DEFAULT_INSTANCE.createBuilder(linear);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Linear parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
            }

            public static Linear parseFrom(AbstractC2383g abstractC2383g) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
            }

            public static Linear parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
            }

            public static Linear parseFrom(byte[] bArr) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Linear parseFrom(byte[] bArr, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
            }

            public static Linear parseFrom(InputStream inputStream) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Linear parseFrom(InputStream inputStream, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
            }

            public static Linear parseFrom(AbstractC2384h abstractC2384h) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
            }

            public static Linear parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
                return (Linear) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
            }
        }

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(a aVar) {
                this();
            }

            private a() {
                super(BucketOptions.DEFAULT_INSTANCE);
            }
        }

        public enum b {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);

            private final int a;

            b(int i) {
                this.a = i;
            }

            public static b a(int i) {
                if (i == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (i == 1) {
                    return LINEAR_BUCKETS;
                }
                if (i == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (i != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }
        }

        static {
            BucketOptions bucketOptions = new BucketOptions();
            DEFAULT_INSTANCE = bucketOptions;
            GeneratedMessageLite.registerDefaultInstance(BucketOptions.class, bucketOptions);
        }

        private BucketOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLinearBuckets() {
            if (this.optionsCase_ == 1) {
                this.optionsCase_ = 0;
                this.options_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.optionsCase_ = 0;
            this.options_ = null;
        }

        public static BucketOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExplicitBuckets(Explicit explicit) {
            explicit.getClass();
            if (this.optionsCase_ != 3 || this.options_ == Explicit.getDefaultInstance()) {
                this.options_ = explicit;
            } else {
                this.options_ = ((Explicit.a) Explicit.newBuilder((Explicit) this.options_).v(explicit)).j();
            }
            this.optionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExponentialBuckets(Exponential exponential) {
            exponential.getClass();
            if (this.optionsCase_ != 2 || this.options_ == Exponential.getDefaultInstance()) {
                this.options_ = exponential;
            } else {
                this.options_ = ((Exponential.a) Exponential.newBuilder((Exponential) this.options_).v(exponential)).j();
            }
            this.optionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLinearBuckets(Linear linear) {
            linear.getClass();
            if (this.optionsCase_ != 1 || this.options_ == Linear.getDefaultInstance()) {
                this.options_ = linear;
            } else {
                this.options_ = ((Linear.a) Linear.newBuilder((Linear) this.options_).v(linear)).j();
            }
            this.optionsCase_ = 1;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream) {
            return (BucketOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseFrom(ByteBuffer byteBuffer) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExplicitBuckets(Explicit explicit) {
            explicit.getClass();
            this.options_ = explicit;
            this.optionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExponentialBuckets(Exponential exponential) {
            exponential.getClass();
            this.options_ = exponential;
            this.optionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLinearBuckets(Linear linear) {
            linear.getClass();
            this.options_ = linear;
            this.optionsCase_ = 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[gVar.ordinal()]) {
                case 1:
                    return new BucketOptions();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"options_", "optionsCase_", Linear.class, Exponential.class, Explicit.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (BucketOptions.class) {
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

        public Explicit getExplicitBuckets() {
            return this.optionsCase_ == 3 ? (Explicit) this.options_ : Explicit.getDefaultInstance();
        }

        public Exponential getExponentialBuckets() {
            return this.optionsCase_ == 2 ? (Exponential) this.options_ : Exponential.getDefaultInstance();
        }

        public Linear getLinearBuckets() {
            return this.optionsCase_ == 1 ? (Linear) this.options_ : Linear.getDefaultInstance();
        }

        public b getOptionsCase() {
            return b.a(this.optionsCase_);
        }

        public boolean hasExplicitBuckets() {
            return this.optionsCase_ == 3;
        }

        public boolean hasExponentialBuckets() {
            return this.optionsCase_ == 2;
        }

        public boolean hasLinearBuckets() {
            return this.optionsCase_ == 1;
        }

        public static a newBuilder(BucketOptions bucketOptions) {
            return (a) DEFAULT_INSTANCE.createBuilder(bucketOptions);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static BucketOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static BucketOptions parseFrom(AbstractC2383g abstractC2383g) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static BucketOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static BucketOptions parseFrom(byte[] bArr) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BucketOptions parseFrom(byte[] bArr, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static BucketOptions parseFrom(InputStream inputStream) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BucketOptions parseFrom(InputStream inputStream, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static BucketOptions parseFrom(AbstractC2384h abstractC2384h) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static BucketOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (BucketOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class Exemplar extends GeneratedMessageLite implements c {
        public static final int ATTACHMENTS_FIELD_NUMBER = 3;
        private static final Exemplar DEFAULT_INSTANCE;
        private static volatile KW4 PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 1;
        private B.j attachments_ = GeneratedMessageLite.emptyProtobufList();
        private Timestamp timestamp_;
        private double value_;

        public static final class a extends GeneratedMessageLite.b implements c {
            /* synthetic */ a(a aVar) {
                this();
            }

            private a() {
                super(Exemplar.DEFAULT_INSTANCE);
            }
        }

        static {
            Exemplar exemplar = new Exemplar();
            DEFAULT_INSTANCE = exemplar;
            GeneratedMessageLite.registerDefaultInstance(Exemplar.class, exemplar);
        }

        private Exemplar() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAttachments(Iterable<? extends Any> iterable) {
            ensureAttachmentsIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.attachments_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttachments(Any any) {
            any.getClass();
            ensureAttachmentsIsMutable();
            this.attachments_.add(any);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAttachments() {
            this.attachments_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.timestamp_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0.0d;
        }

        private void ensureAttachmentsIsMutable() {
            B.j jVar = this.attachments_;
            if (jVar.u()) {
                return;
            }
            this.attachments_ = GeneratedMessageLite.mutableCopy(jVar);
        }

        public static Exemplar getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimestamp(Timestamp timestamp) {
            timestamp.getClass();
            Timestamp timestamp2 = this.timestamp_;
            if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
                this.timestamp_ = timestamp;
            } else {
                this.timestamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.timestamp_).v(timestamp)).j();
            }
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static Exemplar parseDelimitedFrom(InputStream inputStream) {
            return (Exemplar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Exemplar parseFrom(ByteBuffer byteBuffer) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAttachments(int i) {
            ensureAttachmentsIsMutable();
            this.attachments_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttachments(int i, Any any) {
            any.getClass();
            ensureAttachmentsIsMutable();
            this.attachments_.set(i, any);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(Timestamp timestamp) {
            timestamp.getClass();
            this.timestamp_ = timestamp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(double d) {
            this.value_ = d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[gVar.ordinal()]) {
                case 1:
                    return new Exemplar();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0000\u0002\t\u0003\u001b", new Object[]{"value_", "timestamp_", "attachments_", Any.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Exemplar.class) {
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

        public Any getAttachments(int i) {
            return (Any) this.attachments_.get(i);
        }

        public int getAttachmentsCount() {
            return this.attachments_.size();
        }

        public List<Any> getAttachmentsList() {
            return this.attachments_;
        }

        public InterfaceC16228kv getAttachmentsOrBuilder(int i) {
            return (InterfaceC16228kv) this.attachments_.get(i);
        }

        public List<? extends InterfaceC16228kv> getAttachmentsOrBuilderList() {
            return this.attachments_;
        }

        public Timestamp getTimestamp() {
            Timestamp timestamp = this.timestamp_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        public double getValue() {
            return this.value_;
        }

        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        public static a newBuilder(Exemplar exemplar) {
            return (a) DEFAULT_INSTANCE.createBuilder(exemplar);
        }

        public static Exemplar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Exemplar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Exemplar parseFrom(AbstractC2383g abstractC2383g) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttachments(int i, Any any) {
            any.getClass();
            ensureAttachmentsIsMutable();
            this.attachments_.add(i, any);
        }

        public static Exemplar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Exemplar parseFrom(byte[] bArr) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Exemplar parseFrom(byte[] bArr, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Exemplar parseFrom(InputStream inputStream) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Exemplar parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Exemplar parseFrom(AbstractC2384h abstractC2384h) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Exemplar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Exemplar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class Range extends GeneratedMessageLite implements U64 {
        private static final Range DEFAULT_INSTANCE;
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static volatile KW4 PARSER;
        private double max_;
        private double min_;

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(a aVar) {
                this();
            }

            private a() {
                super(Range.DEFAULT_INSTANCE);
            }
        }

        static {
            Range range = new Range();
            DEFAULT_INSTANCE = range;
            GeneratedMessageLite.registerDefaultInstance(Range.class, range);
        }

        private Range() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            this.max_ = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMin() {
            this.min_ = 0.0d;
        }

        public static Range getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static Range parseDelimitedFrom(InputStream inputStream) {
            return (Range) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseFrom(ByteBuffer byteBuffer) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(double d) {
            this.max_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMin(double d) {
            this.min_ = d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[gVar.ordinal()]) {
                case 1:
                    return new Range();
                case 2:
                    return new a(aVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"min_", "max_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Range.class) {
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

        public double getMax() {
            return this.max_;
        }

        public double getMin() {
            return this.min_;
        }

        public static a newBuilder(Range range) {
            return (a) DEFAULT_INSTANCE.createBuilder(range);
        }

        public static Range parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Range parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Range parseFrom(AbstractC2383g abstractC2383g) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Range parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Range parseFrom(byte[] bArr) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Range parseFrom(byte[] bArr, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Range parseFrom(InputStream inputStream) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Range parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Range parseFrom(AbstractC2384h abstractC2384h) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Range parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Range) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
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

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            super(Distribution.DEFAULT_INSTANCE);
        }
    }

    public interface c extends U64 {
    }

    static {
        Distribution distribution = new Distribution();
        DEFAULT_INSTANCE = distribution;
        GeneratedMessageLite.registerDefaultInstance(Distribution.class, distribution);
    }

    private Distribution() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBucketCounts(Iterable<? extends Long> iterable) {
        ensureBucketCountsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bucketCounts_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllExemplars(Iterable<? extends Exemplar> iterable) {
        ensureExemplarsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exemplars_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBucketCounts(long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.l1(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExemplars(Exemplar exemplar) {
        exemplar.getClass();
        ensureExemplarsIsMutable();
        this.exemplars_.add(exemplar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucketCounts() {
        this.bucketCounts_ = GeneratedMessageLite.emptyLongList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBucketOptions() {
        this.bucketOptions_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCount() {
        this.count_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExemplars() {
        this.exemplars_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMean() {
        this.mean_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRange() {
        this.range_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSumOfSquaredDeviation() {
        this.sumOfSquaredDeviation_ = 0.0d;
    }

    private void ensureBucketCountsIsMutable() {
        B.i iVar = this.bucketCounts_;
        if (iVar.u()) {
            return;
        }
        this.bucketCounts_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    private void ensureExemplarsIsMutable() {
        B.j jVar = this.exemplars_;
        if (jVar.u()) {
            return;
        }
        this.exemplars_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Distribution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBucketOptions(BucketOptions bucketOptions) {
        bucketOptions.getClass();
        BucketOptions bucketOptions2 = this.bucketOptions_;
        if (bucketOptions2 == null || bucketOptions2 == BucketOptions.getDefaultInstance()) {
            this.bucketOptions_ = bucketOptions;
        } else {
            this.bucketOptions_ = (BucketOptions) ((BucketOptions.a) BucketOptions.newBuilder(this.bucketOptions_).v(bucketOptions)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRange(Range range) {
        range.getClass();
        Range range2 = this.range_;
        if (range2 == null || range2 == Range.getDefaultInstance()) {
            this.range_ = range;
        } else {
            this.range_ = (Range) ((Range.a) Range.newBuilder(this.range_).v(range)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream) {
        return (Distribution) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseFrom(ByteBuffer byteBuffer) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeExemplars(int i) {
        ensureExemplarsIsMutable();
        this.exemplars_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketCounts(int i, long j) {
        ensureBucketCountsIsMutable();
        this.bucketCounts_.z1(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBucketOptions(BucketOptions bucketOptions) {
        bucketOptions.getClass();
        this.bucketOptions_ = bucketOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCount(long j) {
        this.count_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExemplars(int i, Exemplar exemplar) {
        exemplar.getClass();
        ensureExemplarsIsMutable();
        this.exemplars_.set(i, exemplar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMean(double d) {
        this.mean_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRange(Range range) {
        range.getClass();
        this.range_ = range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSumOfSquaredDeviation(double d) {
        this.sumOfSquaredDeviation_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.a[gVar.ordinal()]) {
            case 1:
                return new Distribution();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\n\u0007\u0000\u0002\u0000\u0001\u0002\u0002\u0000\u0003\u0000\u0004\t\u0006\t\u0007%\n\u001b", new Object[]{"count_", "mean_", "sumOfSquaredDeviation_", "range_", "bucketOptions_", "bucketCounts_", "exemplars_", Exemplar.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Distribution.class) {
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

    public long getBucketCounts(int i) {
        return this.bucketCounts_.getLong(i);
    }

    public int getBucketCountsCount() {
        return this.bucketCounts_.size();
    }

    public List<Long> getBucketCountsList() {
        return this.bucketCounts_;
    }

    public BucketOptions getBucketOptions() {
        BucketOptions bucketOptions = this.bucketOptions_;
        return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
    }

    public long getCount() {
        return this.count_;
    }

    public Exemplar getExemplars(int i) {
        return (Exemplar) this.exemplars_.get(i);
    }

    public int getExemplarsCount() {
        return this.exemplars_.size();
    }

    public List<Exemplar> getExemplarsList() {
        return this.exemplars_;
    }

    public c getExemplarsOrBuilder(int i) {
        return (c) this.exemplars_.get(i);
    }

    public List<? extends c> getExemplarsOrBuilderList() {
        return this.exemplars_;
    }

    public double getMean() {
        return this.mean_;
    }

    public Range getRange() {
        Range range = this.range_;
        return range == null ? Range.getDefaultInstance() : range;
    }

    public double getSumOfSquaredDeviation() {
        return this.sumOfSquaredDeviation_;
    }

    public boolean hasBucketOptions() {
        return this.bucketOptions_ != null;
    }

    public boolean hasRange() {
        return this.range_ != null;
    }

    public static b newBuilder(Distribution distribution) {
        return (b) DEFAULT_INSTANCE.createBuilder(distribution);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Distribution parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Distribution parseFrom(AbstractC2383g abstractC2383g) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExemplars(int i, Exemplar exemplar) {
        exemplar.getClass();
        ensureExemplarsIsMutable();
        this.exemplars_.add(i, exemplar);
    }

    public static Distribution parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Distribution parseFrom(byte[] bArr) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Distribution parseFrom(byte[] bArr, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Distribution parseFrom(InputStream inputStream) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Distribution parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Distribution parseFrom(AbstractC2384h abstractC2384h) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Distribution parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Distribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
