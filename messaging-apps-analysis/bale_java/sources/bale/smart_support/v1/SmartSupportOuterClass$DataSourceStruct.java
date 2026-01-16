package bale.smart_support.v1;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18200oF6;
import ir.nasim.JE6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$DataSourceStruct extends GeneratedMessageLite implements JE6 {
    private static final SmartSupportOuterClass$DataSourceStruct DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 5;
    public static final int FILE_NAME_FIELD_NUMBER = 3;
    public static final int FILE_TYPE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private String fileName_ = "";
    private int fileType_;
    private FilesStruct$FileLocation file_;

    public static final class a extends GeneratedMessageLite.b implements JE6 {
        private a() {
            super(SmartSupportOuterClass$DataSourceStruct.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$DataSourceStruct smartSupportOuterClass$DataSourceStruct = new SmartSupportOuterClass$DataSourceStruct();
        DEFAULT_INSTANCE = smartSupportOuterClass$DataSourceStruct;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$DataSourceStruct.class, smartSupportOuterClass$DataSourceStruct);
    }

    private SmartSupportOuterClass$DataSourceStruct() {
    }

    private void clearFile() {
        this.file_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearFileType() {
        this.fileType_ = 0;
    }

    public static SmartSupportOuterClass$DataSourceStruct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.file_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.file_ = filesStruct$FileLocation;
        } else {
            this.file_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.file_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$DataSourceStruct parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFile(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.file_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    private void setFileNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileName_ = abstractC2383g.f0();
    }

    private void setFileType(EnumC18200oF6 enumC18200oF6) {
        this.fileType_ = enumC18200oF6.getNumber();
    }

    private void setFileTypeValue(int i) {
        this.fileType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$DataSourceStruct();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0000\u0003Ȉ\u0004\f\u0005ဉ\u0000", new Object[]{"bitField0_", "fileName_", "fileType_", "file_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$DataSourceStruct.class) {
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

    public FilesStruct$FileLocation getFile() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.file_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getFileName() {
        return this.fileName_;
    }

    public AbstractC2383g getFileNameBytes() {
        return AbstractC2383g.N(this.fileName_);
    }

    public EnumC18200oF6 getFileType() {
        EnumC18200oF6 enumC18200oF6J = EnumC18200oF6.j(this.fileType_);
        return enumC18200oF6J == null ? EnumC18200oF6.UNRECOGNIZED : enumC18200oF6J;
    }

    public int getFileTypeValue() {
        return this.fileType_;
    }

    public boolean hasFile() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportOuterClass$DataSourceStruct smartSupportOuterClass$DataSourceStruct) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$DataSourceStruct);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$DataSourceStruct parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$DataSourceStruct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
