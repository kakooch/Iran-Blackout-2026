package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FieldOptions extends GeneratedMessageLite.ExtendableMessage<DescriptorProtos$FieldOptions, a> implements U64 {
    public static final int CTYPE_FIELD_NUMBER = 1;
    private static final DescriptorProtos$FieldOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    public static final int LAZY_FIELD_NUMBER = 5;
    public static final int PACKED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int WEAK_FIELD_NUMBER = 10;
    private int bitField0_;
    private int ctype_;
    private boolean deprecated_;
    private int jstype_;
    private boolean lazy_;
    private boolean packed_;
    private boolean weak_;
    private byte memoizedIsInitialized = 2;
    private B.j uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.d implements U64 {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$FieldOptions.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        STRING(0),
        CORD(1),
        STRING_PIECE(2);

        private static final B.d e = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.a(i);
            }
        }

        /* renamed from: com.google.protobuf.DescriptorProtos$FieldOptions$b$b, reason: collision with other inner class name */
        private static final class C0201b implements B.e {
            static final B.e a = new C0201b();

            private C0201b() {
            }

            @Override // com.google.protobuf.B.e
            public boolean a(int i) {
                return b.a(i) != null;
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return CORD;
            }
            if (i != 2) {
                return null;
            }
            return STRING_PIECE;
        }

        public static B.e j() {
            return C0201b.a;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            return this.a;
        }
    }

    public enum c implements B.c {
        JS_NORMAL(0),
        JS_STRING(1),
        JS_NUMBER(2);

        private static final B.d e = new a();
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

        private static final class b implements B.e {
            static final B.e a = new b();

            private b() {
            }

            @Override // com.google.protobuf.B.e
            public boolean a(int i) {
                return c.a(i) != null;
            }
        }

        c(int i) {
            this.a = i;
        }

        public static c a(int i) {
            if (i == 0) {
                return JS_NORMAL;
            }
            if (i == 1) {
                return JS_STRING;
            }
            if (i != 2) {
                return null;
            }
            return JS_NUMBER;
        }

        public static B.e j() {
            return b.a;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = new DescriptorProtos$FieldOptions();
        DEFAULT_INSTANCE = descriptorProtos$FieldOptions;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$FieldOptions.class, descriptorProtos$FieldOptions);
    }

    private DescriptorProtos$FieldOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUninterpretedOption(Iterable<? extends DescriptorProtos$UninterpretedOption> iterable) {
        ensureUninterpretedOptionIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCtype() {
        this.bitField0_ &= -2;
        this.ctype_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeprecated() {
        this.bitField0_ &= -17;
        this.deprecated_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJstype() {
        this.bitField0_ &= -5;
        this.jstype_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLazy() {
        this.bitField0_ &= -9;
        this.lazy_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacked() {
        this.bitField0_ &= -3;
        this.packed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUninterpretedOption() {
        this.uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeak() {
        this.bitField0_ &= -33;
        this.weak_ = false;
    }

    private void ensureUninterpretedOptionIsMutable() {
        B.j jVar = this.uninterpretedOption_;
        if (jVar.u()) {
            return;
        }
        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$FieldOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUninterpretedOption(int i) {
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCtype(b bVar) {
        this.ctype_ = bVar.getNumber();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeprecated(boolean z) {
        this.bitField0_ |= 16;
        this.deprecated_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJstype(c cVar) {
        this.jstype_ = cVar.getNumber();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLazy(boolean z) {
        this.bitField0_ |= 8;
        this.lazy_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacked(boolean z) {
        this.bitField0_ |= 2;
        this.packed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(i, descriptorProtos$UninterpretedOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeak(boolean z) {
        this.bitField0_ |= 32;
        this.weak_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$FieldOptions();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0005ϧЛ", new Object[]{"bitField0_", "ctype_", b.j(), "packed_", "deprecated_", "lazy_", "jstype_", c.j(), "weak_", "uninterpretedOption_", DescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$FieldOptions.class) {
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

    public b getCtype() {
        b bVarA = b.a(this.ctype_);
        return bVarA == null ? b.STRING : bVarA;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public c getJstype() {
        c cVarA = c.a(this.jstype_);
        return cVarA == null ? c.JS_NORMAL : cVarA;
    }

    public boolean getLazy() {
        return this.lazy_;
    }

    public boolean getPacked() {
        return this.packed_;
    }

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int i) {
        return (DescriptorProtos$UninterpretedOption) this.uninterpretedOption_.get(i);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List<DescriptorProtos$UninterpretedOption> getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public InterfaceC2391o getUninterpretedOptionOrBuilder(int i) {
        return (InterfaceC2391o) this.uninterpretedOption_.get(i);
    }

    public List<? extends InterfaceC2391o> getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean getWeak() {
        return this.weak_;
    }

    public boolean hasCtype() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasJstype() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLazy() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPacked() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasWeak() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldOptions);
    }

    public static DescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$FieldOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, descriptorProtos$UninterpretedOption);
    }

    public static DescriptorProtos$FieldOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] bArr) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$FieldOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FieldOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FieldOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$FieldOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
