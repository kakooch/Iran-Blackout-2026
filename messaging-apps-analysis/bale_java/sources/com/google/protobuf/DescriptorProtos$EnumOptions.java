package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$EnumOptions extends GeneratedMessageLite.ExtendableMessage<DescriptorProtos$EnumOptions, a> implements U64 {
    public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
    private static final DescriptorProtos$EnumOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private boolean allowAlias_;
    private int bitField0_;
    private boolean deprecated_;
    private byte memoizedIsInitialized = 2;
    private B.j uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.d implements U64 {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$EnumOptions.DEFAULT_INSTANCE);
        }
    }

    static {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = new DescriptorProtos$EnumOptions();
        DEFAULT_INSTANCE = descriptorProtos$EnumOptions;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$EnumOptions.class, descriptorProtos$EnumOptions);
    }

    private DescriptorProtos$EnumOptions() {
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
    public void clearAllowAlias() {
        this.bitField0_ &= -2;
        this.allowAlias_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeprecated() {
        this.bitField0_ &= -3;
        this.deprecated_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUninterpretedOption() {
        this.uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUninterpretedOptionIsMutable() {
        B.j jVar = this.uninterpretedOption_;
        if (jVar.u()) {
            return;
        }
        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$EnumOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setAllowAlias(boolean z) {
        this.bitField0_ |= 1;
        this.allowAlias_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeprecated(boolean z) {
        this.bitField0_ |= 2;
        this.deprecated_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(i, descriptorProtos$UninterpretedOption);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$EnumOptions();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0002ϧ\u0003\u0000\u0001\u0001\u0002ဇ\u0000\u0003ဇ\u0001ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "uninterpretedOption_", DescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$EnumOptions.class) {
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

    public boolean getAllowAlias() {
        return this.allowAlias_;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
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

    public boolean hasAllowAlias() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumOptions);
    }

    public static DescriptorProtos$EnumOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$EnumOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$EnumOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, descriptorProtos$UninterpretedOption);
    }

    public static DescriptorProtos$EnumOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$EnumOptions parseFrom(byte[] bArr) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$EnumOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$EnumOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$EnumOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$EnumOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$EnumOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$EnumOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
