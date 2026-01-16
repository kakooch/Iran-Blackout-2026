package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CI1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class DescriptorProtos$MethodDescriptorProto extends GeneratedMessageLite implements CI1 {
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private static final DescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private int bitField0_;
    private boolean clientStreaming_;
    private DescriptorProtos$MethodOptions options_;
    private boolean serverStreaming_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String inputType_ = "";
    private String outputType_ = "";

    public static final class a extends GeneratedMessageLite.b implements CI1 {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE);
        }
    }

    static {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = new DescriptorProtos$MethodDescriptorProto();
        DEFAULT_INSTANCE = descriptorProtos$MethodDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$MethodDescriptorProto.class, descriptorProtos$MethodDescriptorProto);
    }

    private DescriptorProtos$MethodDescriptorProto() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientStreaming() {
        this.bitField0_ &= -17;
        this.clientStreaming_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputType() {
        this.bitField0_ &= -3;
        this.inputType_ = getDefaultInstance().getInputType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutputType() {
        this.bitField0_ &= -5;
        this.outputType_ = getDefaultInstance().getOutputType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerStreaming() {
        this.bitField0_ &= -33;
        this.serverStreaming_ = false;
    }

    public static DescriptorProtos$MethodDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        descriptorProtos$MethodOptions.getClass();
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions2 = this.options_;
        if (descriptorProtos$MethodOptions2 == null || descriptorProtos$MethodOptions2 == DescriptorProtos$MethodOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$MethodOptions;
        } else {
            this.options_ = (DescriptorProtos$MethodOptions) ((DescriptorProtos$MethodOptions.a) DescriptorProtos$MethodOptions.newBuilder(this.options_).v(descriptorProtos$MethodOptions)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientStreaming(boolean z) {
        this.bitField0_ |= 16;
        this.clientStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputType(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.inputType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputTypeBytes(AbstractC2383g abstractC2383g) {
        this.inputType_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
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
    public void setOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        descriptorProtos$MethodOptions.getClass();
        this.options_ = descriptorProtos$MethodOptions;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputType(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.outputType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputTypeBytes(AbstractC2383g abstractC2383g) {
        this.outputType_ = abstractC2383g.f0();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerStreaming(boolean z) {
        this.bitField0_ |= 32;
        this.serverStreaming_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$MethodDescriptorProto();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$MethodDescriptorProto.class) {
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

    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public String getInputType() {
        return this.inputType_;
    }

    public AbstractC2383g getInputTypeBytes() {
        return AbstractC2383g.N(this.inputType_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public DescriptorProtos$MethodOptions getOptions() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = this.options_;
        return descriptorProtos$MethodOptions == null ? DescriptorProtos$MethodOptions.getDefaultInstance() : descriptorProtos$MethodOptions;
    }

    public String getOutputType() {
        return this.outputType_;
    }

    public AbstractC2383g getOutputTypeBytes() {
        return AbstractC2383g.N(this.outputType_);
    }

    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public boolean hasClientStreaming() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasInputType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasOutputType() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasServerStreaming() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$MethodDescriptorProto);
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] bArr) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
