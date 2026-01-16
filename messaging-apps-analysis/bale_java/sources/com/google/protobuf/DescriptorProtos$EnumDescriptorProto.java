package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AI1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumDescriptorProto extends GeneratedMessageLite implements InterfaceC2389m {
    private static final DescriptorProtos$EnumDescriptorProto DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 5;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private DescriptorProtos$EnumOptions options_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private B.j value_ = GeneratedMessageLite.emptyProtobufList();
    private B.j reservedRange_ = GeneratedMessageLite.emptyProtobufList();
    private B.j reservedName_ = GeneratedMessageLite.emptyProtobufList();

    public static final class EnumReservedRange extends GeneratedMessageLite implements b {
        private static final EnumReservedRange DEFAULT_INSTANCE;
        public static final int END_FIELD_NUMBER = 2;
        private static volatile KW4 PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private int start_;

        public static final class a extends GeneratedMessageLite.b implements b {
            /* synthetic */ a(AbstractC2387k abstractC2387k) {
                this();
            }

            private a() {
                super(EnumReservedRange.DEFAULT_INSTANCE);
            }
        }

        static {
            EnumReservedRange enumReservedRange = new EnumReservedRange();
            DEFAULT_INSTANCE = enumReservedRange;
            GeneratedMessageLite.registerDefaultInstance(EnumReservedRange.class, enumReservedRange);
        }

        private EnumReservedRange() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnd() {
            this.bitField0_ &= -3;
            this.end_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStart() {
            this.bitField0_ &= -2;
            this.start_ = 0;
        }

        public static EnumReservedRange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) {
            return (EnumReservedRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumReservedRange parseFrom(ByteBuffer byteBuffer) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnd(int i) {
            this.bitField0_ |= 2;
            this.end_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStart(int i) {
            this.bitField0_ |= 1;
            this.start_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            AbstractC2387k abstractC2387k = null;
            switch (AbstractC2387k.a[gVar.ordinal()]) {
                case 1:
                    return new EnumReservedRange();
                case 2:
                    return new a(abstractC2387k);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (EnumReservedRange.class) {
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

        public int getEnd() {
            return this.end_;
        }

        public int getStart() {
            return this.start_;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasStart() {
            return (this.bitField0_ & 1) != 0;
        }

        public static a newBuilder(EnumReservedRange enumReservedRange) {
            return (a) DEFAULT_INSTANCE.createBuilder(enumReservedRange);
        }

        public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static EnumReservedRange parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static EnumReservedRange parseFrom(AbstractC2383g abstractC2383g) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static EnumReservedRange parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static EnumReservedRange parseFrom(byte[] bArr) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EnumReservedRange parseFrom(byte[] bArr, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static EnumReservedRange parseFrom(InputStream inputStream) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumReservedRange parseFrom(InputStream inputStream, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static EnumReservedRange parseFrom(AbstractC2384h abstractC2384h) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static EnumReservedRange parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (EnumReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class a extends GeneratedMessageLite.b implements InterfaceC2389m {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$EnumDescriptorProto.DEFAULT_INSTANCE);
        }
    }

    public interface b extends U64 {
    }

    static {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = new DescriptorProtos$EnumDescriptorProto();
        DEFAULT_INSTANCE = descriptorProtos$EnumDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$EnumDescriptorProto.class, descriptorProtos$EnumDescriptorProto);
    }

    private DescriptorProtos$EnumDescriptorProto() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllReservedName(Iterable<String> iterable) {
        ensureReservedNameIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reservedName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
        ensureReservedRangeIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reservedRange_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValue(Iterable<? extends DescriptorProtos$EnumValueDescriptorProto> iterable) {
        ensureValueIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.value_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReservedName(String str) {
        str.getClass();
        ensureReservedNameIsMutable();
        this.reservedName_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReservedNameBytes(AbstractC2383g abstractC2383g) {
        ensureReservedNameIsMutable();
        this.reservedName_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReservedRange(EnumReservedRange enumReservedRange) {
        enumReservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.add(enumReservedRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValue(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        descriptorProtos$EnumValueDescriptorProto.getClass();
        ensureValueIsMutable();
        this.value_.add(descriptorProtos$EnumValueDescriptorProto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReservedName() {
        this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReservedRange() {
        this.reservedRange_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReservedNameIsMutable() {
        B.j jVar = this.reservedName_;
        if (jVar.u()) {
            return;
        }
        this.reservedName_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureReservedRangeIsMutable() {
        B.j jVar = this.reservedRange_;
        if (jVar.u()) {
            return;
        }
        this.reservedRange_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureValueIsMutable() {
        B.j jVar = this.value_;
        if (jVar.u()) {
            return;
        }
        this.value_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$EnumDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        descriptorProtos$EnumOptions.getClass();
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions2 = this.options_;
        if (descriptorProtos$EnumOptions2 == null || descriptorProtos$EnumOptions2 == DescriptorProtos$EnumOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$EnumOptions;
        } else {
            this.options_ = (DescriptorProtos$EnumOptions) ((DescriptorProtos$EnumOptions.a) DescriptorProtos$EnumOptions.newBuilder(this.options_).v(descriptorProtos$EnumOptions)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeReservedRange(int i) {
        ensureReservedRangeIsMutable();
        this.reservedRange_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValue(int i) {
        ensureValueIsMutable();
        this.value_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        this.name_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        descriptorProtos$EnumOptions.getClass();
        this.options_ = descriptorProtos$EnumOptions;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReservedName(int i, String str) {
        str.getClass();
        ensureReservedNameIsMutable();
        this.reservedName_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReservedRange(int i, EnumReservedRange enumReservedRange) {
        enumReservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.set(i, enumReservedRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        descriptorProtos$EnumValueDescriptorProto.getClass();
        ensureValueIsMutable();
        this.value_.set(i, descriptorProtos$EnumValueDescriptorProto);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$EnumDescriptorProto();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", DescriptorProtos$EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$EnumDescriptorProto.class) {
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
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public DescriptorProtos$EnumOptions getOptions() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = this.options_;
        return descriptorProtos$EnumOptions == null ? DescriptorProtos$EnumOptions.getDefaultInstance() : descriptorProtos$EnumOptions;
    }

    public String getReservedName(int i) {
        return (String) this.reservedName_.get(i);
    }

    public AbstractC2383g getReservedNameBytes(int i) {
        return AbstractC2383g.N((String) this.reservedName_.get(i));
    }

    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    public List<String> getReservedNameList() {
        return this.reservedName_;
    }

    public EnumReservedRange getReservedRange(int i) {
        return (EnumReservedRange) this.reservedRange_.get(i);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List<EnumReservedRange> getReservedRangeList() {
        return this.reservedRange_;
    }

    public b getReservedRangeOrBuilder(int i) {
        return (b) this.reservedRange_.get(i);
    }

    public List<? extends b> getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    public DescriptorProtos$EnumValueDescriptorProto getValue(int i) {
        return (DescriptorProtos$EnumValueDescriptorProto) this.value_.get(i);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List<DescriptorProtos$EnumValueDescriptorProto> getValueList() {
        return this.value_;
    }

    public AI1 getValueOrBuilder(int i) {
        return (AI1) this.value_.get(i);
    }

    public List<? extends AI1> getValueOrBuilderList() {
        return this.value_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumDescriptorProto);
    }

    public static DescriptorProtos$EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReservedRange(int i, EnumReservedRange enumReservedRange) {
        enumReservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.add(i, enumReservedRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValue(int i, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        descriptorProtos$EnumValueDescriptorProto.getClass();
        ensureValueIsMutable();
        this.value_.add(i, descriptorProtos$EnumValueDescriptorProto);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] bArr) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$EnumDescriptorProto parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$EnumDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
