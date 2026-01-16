package bale.smart_support.v1;

import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17018mF6;
import ir.nasim.EnumC18200oF6;
import ir.nasim.InterfaceC16427lF6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$Datasource extends GeneratedMessageLite implements InterfaceC16427lF6 {
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final SmartSupportStruct$Datasource DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 9;
    public static final int FILE_LOCATION_FIELD_NUMBER = 8;
    public static final int FILE_TYPE_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 5;
    public static final int SUBJECT_NAME_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int bitField0_;
    private long createdAt_;
    private boolean enabled_;
    private FilesStruct$FileLocation fileLocation_;
    private int fileType_;
    private long id_;
    private long size_;
    private int status_;
    private String title_ = "";
    private String subjectName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16427lF6 {
        private a() {
            super(SmartSupportStruct$Datasource.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$Datasource smartSupportStruct$Datasource = new SmartSupportStruct$Datasource();
        DEFAULT_INSTANCE = smartSupportStruct$Datasource;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$Datasource.class, smartSupportStruct$Datasource);
    }

    private SmartSupportStruct$Datasource() {
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearEnabled() {
        this.enabled_ = false;
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileType() {
        this.fileType_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearSize() {
        this.size_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearSubjectName() {
        this.subjectName_ = getDefaultInstance().getSubjectName();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static SmartSupportStruct$Datasource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.fileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$FileLocation;
        } else {
            this.fileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.fileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$Datasource parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Datasource parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    private void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setFileType(EnumC18200oF6 enumC18200oF6) {
        this.fileType_ = enumC18200oF6.getNumber();
    }

    private void setFileTypeValue(int i) {
        this.fileType_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setSize(long j) {
        this.size_ = j;
    }

    private void setStatus(EnumC17018mF6 enumC17018mF6) {
        this.status_ = enumC17018mF6.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setSubjectName(String str) {
        str.getClass();
        this.subjectName_ = str;
    }

    private void setSubjectNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.subjectName_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$Datasource();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005\f\u0006\f\u0007\u0002\bဉ\u0000\t\u0007", new Object[]{"bitField0_", "id_", "createdAt_", "title_", "subjectName_", "status_", "fileType_", "size_", "fileLocation_", "enabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$Datasource.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public boolean getEnabled() {
        return this.enabled_;
    }

    public FilesStruct$FileLocation getFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.fileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public EnumC18200oF6 getFileType() {
        EnumC18200oF6 enumC18200oF6J = EnumC18200oF6.j(this.fileType_);
        return enumC18200oF6J == null ? EnumC18200oF6.UNRECOGNIZED : enumC18200oF6J;
    }

    public int getFileTypeValue() {
        return this.fileType_;
    }

    public long getId() {
        return this.id_;
    }

    public long getSize() {
        return this.size_;
    }

    public EnumC17018mF6 getStatus() {
        EnumC17018mF6 enumC17018mF6J = EnumC17018mF6.j(this.status_);
        return enumC17018mF6J == null ? EnumC17018mF6.UNRECOGNIZED : enumC17018mF6J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getSubjectName() {
        return this.subjectName_;
    }

    public AbstractC2383g getSubjectNameBytes() {
        return AbstractC2383g.N(this.subjectName_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportStruct$Datasource smartSupportStruct$Datasource) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$Datasource);
    }

    public static SmartSupportStruct$Datasource parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Datasource parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$Datasource parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$Datasource parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$Datasource parseFrom(byte[] bArr) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$Datasource parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$Datasource parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Datasource parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Datasource parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$Datasource parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$Datasource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
