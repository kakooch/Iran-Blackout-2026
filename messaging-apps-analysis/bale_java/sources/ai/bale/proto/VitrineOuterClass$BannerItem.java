package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.VitrineOuterClass$Action;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18972pZ7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$BannerItem extends GeneratedMessageLite implements InterfaceC18972pZ7 {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final VitrineOuterClass$BannerItem DEFAULT_INSTANCE;
    public static final int IMAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private VitrineOuterClass$Action action_;
    private int bitField0_;
    private FilesStruct$ImageLocation image_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18972pZ7 {
        private a() {
            super(VitrineOuterClass$BannerItem.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem = new VitrineOuterClass$BannerItem();
        DEFAULT_INSTANCE = vitrineOuterClass$BannerItem;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$BannerItem.class, vitrineOuterClass$BannerItem);
    }

    private VitrineOuterClass$BannerItem() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -3;
    }

    private void clearImage() {
        this.image_ = null;
        this.bitField0_ &= -2;
    }

    public static VitrineOuterClass$BannerItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(VitrineOuterClass$Action vitrineOuterClass$Action) {
        vitrineOuterClass$Action.getClass();
        VitrineOuterClass$Action vitrineOuterClass$Action2 = this.action_;
        if (vitrineOuterClass$Action2 == null || vitrineOuterClass$Action2 == VitrineOuterClass$Action.getDefaultInstance()) {
            this.action_ = vitrineOuterClass$Action;
        } else {
            this.action_ = (VitrineOuterClass$Action) ((VitrineOuterClass$Action.a) VitrineOuterClass$Action.newBuilder(this.action_).v(vitrineOuterClass$Action)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeImage(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.image_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.image_ = filesStruct$ImageLocation;
        } else {
            this.image_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.image_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$BannerItem parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$BannerItem parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(VitrineOuterClass$Action vitrineOuterClass$Action) {
        vitrineOuterClass$Action.getClass();
        this.action_ = vitrineOuterClass$Action;
        this.bitField0_ |= 2;
    }

    private void setImage(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.image_ = filesStruct$ImageLocation;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$BannerItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "image_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$BannerItem.class) {
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

    public VitrineOuterClass$Action getAction() {
        VitrineOuterClass$Action vitrineOuterClass$Action = this.action_;
        return vitrineOuterClass$Action == null ? VitrineOuterClass$Action.getDefaultInstance() : vitrineOuterClass$Action;
    }

    public FilesStruct$ImageLocation getImage() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasImage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$BannerItem);
    }

    public static VitrineOuterClass$BannerItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$BannerItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$BannerItem parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$BannerItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$BannerItem parseFrom(byte[] bArr) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$BannerItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$BannerItem parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$BannerItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$BannerItem parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$BannerItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$BannerItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
