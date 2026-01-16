package ai.bale.proto;

import ai.bale.proto.FilesStruct$SendTypeValue;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FilesOuterClass$RequestGetNasimFileUploadUrl extends GeneratedMessageLite implements U64 {
    public static final int CHUNK_SIZE_FIELD_NUMBER = 8;
    public static final int CRC_FIELD_NUMBER = 2;
    private static final FilesOuterClass$RequestGetNasimFileUploadUrl DEFAULT_INSTANCE;
    public static final int EXPECTED_SIZE_FIELD_NUMBER = 1;
    public static final int EX_PEER_FIELD_NUMBER = 6;
    public static final int MIME_TYPE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SEND_TYPE_FIELD_NUMBER = 7;
    public static final int UID_FIELD_NUMBER = 3;
    private int bitField0_;
    private long chunkSize_;
    private long crc_;
    private PeersStruct$ExPeer exPeer_;
    private int expectedSize_;
    private FilesStruct$SendTypeValue sendType_;
    private long uid_;
    private String name_ = "";
    private String mimeType_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setCrc(j);
            return this;
        }

        public a B(PeersStruct$ExPeer.a aVar) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setExPeer((PeersStruct$ExPeer) aVar.a());
            return this;
        }

        public a C(int i) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setExpectedSize(i);
            return this;
        }

        public a D(String str) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setMimeType(str);
            return this;
        }

        public a E(String str) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setName(str);
            return this;
        }

        public a F(FilesStruct$SendTypeValue.a aVar) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setSendType((FilesStruct$SendTypeValue) aVar.a());
            return this;
        }

        public a G(long j) {
            q();
            ((FilesOuterClass$RequestGetNasimFileUploadUrl) this.b).setUid(j);
            return this;
        }

        private a() {
            super(FilesOuterClass$RequestGetNasimFileUploadUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        FilesOuterClass$RequestGetNasimFileUploadUrl filesOuterClass$RequestGetNasimFileUploadUrl = new FilesOuterClass$RequestGetNasimFileUploadUrl();
        DEFAULT_INSTANCE = filesOuterClass$RequestGetNasimFileUploadUrl;
        GeneratedMessageLite.registerDefaultInstance(FilesOuterClass$RequestGetNasimFileUploadUrl.class, filesOuterClass$RequestGetNasimFileUploadUrl);
    }

    private FilesOuterClass$RequestGetNasimFileUploadUrl() {
    }

    private void clearChunkSize() {
        this.chunkSize_ = 0L;
    }

    private void clearCrc() {
        this.crc_ = 0L;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExpectedSize() {
        this.expectedSize_ = 0;
    }

    private void clearMimeType() {
        this.mimeType_ = getDefaultInstance().getMimeType();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearSendType() {
        this.sendType_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUid() {
        this.uid_ = 0L;
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSendType(FilesStruct$SendTypeValue filesStruct$SendTypeValue) {
        filesStruct$SendTypeValue.getClass();
        FilesStruct$SendTypeValue filesStruct$SendTypeValue2 = this.sendType_;
        if (filesStruct$SendTypeValue2 == null || filesStruct$SendTypeValue2 == FilesStruct$SendTypeValue.getDefaultInstance()) {
            this.sendType_ = filesStruct$SendTypeValue;
        } else {
            this.sendType_ = (FilesStruct$SendTypeValue) ((FilesStruct$SendTypeValue.a) FilesStruct$SendTypeValue.newBuilder(this.sendType_).v(filesStruct$SendTypeValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseDelimitedFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(ByteBuffer byteBuffer) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChunkSize(long j) {
        this.chunkSize_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCrc(long j) {
        this.crc_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpectedSize(int i) {
        this.expectedSize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeType(String str) {
        str.getClass();
        this.mimeType_ = str;
    }

    private void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mimeType_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendType(FilesStruct$SendTypeValue filesStruct$SendTypeValue) {
        filesStruct$SendTypeValue.getClass();
        this.sendType_ = filesStruct$SendTypeValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(long j) {
        this.uid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1841b0.a[gVar.ordinal()]) {
            case 1:
                return new FilesOuterClass$RequestGetNasimFileUploadUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0004Ȉ\u0005Ȉ\u0006ဉ\u0000\u0007ဉ\u0001\b\u0002", new Object[]{"bitField0_", "expectedSize_", "crc_", "uid_", "name_", "mimeType_", "exPeer_", "sendType_", "chunkSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FilesOuterClass$RequestGetNasimFileUploadUrl.class) {
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

    public long getChunkSize() {
        return this.chunkSize_;
    }

    public long getCrc() {
        return this.crc_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public int getExpectedSize() {
        return this.expectedSize_;
    }

    public String getMimeType() {
        return this.mimeType_;
    }

    public AbstractC2383g getMimeTypeBytes() {
        return AbstractC2383g.N(this.mimeType_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public FilesStruct$SendTypeValue getSendType() {
        FilesStruct$SendTypeValue filesStruct$SendTypeValue = this.sendType_;
        return filesStruct$SendTypeValue == null ? FilesStruct$SendTypeValue.getDefaultInstance() : filesStruct$SendTypeValue;
    }

    public long getUid() {
        return this.uid_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSendType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(FilesOuterClass$RequestGetNasimFileUploadUrl filesOuterClass$RequestGetNasimFileUploadUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(filesOuterClass$RequestGetNasimFileUploadUrl);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(byte[] bArr) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(InputStream inputStream) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FilesOuterClass$RequestGetNasimFileUploadUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FilesOuterClass$RequestGetNasimFileUploadUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
