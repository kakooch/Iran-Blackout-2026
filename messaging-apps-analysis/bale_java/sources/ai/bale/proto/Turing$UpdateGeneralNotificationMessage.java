package ai.bale.proto;

import ai.bale.proto.TuringStruct$CustomGeneralMessageAction;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Turing$UpdateGeneralNotificationMessage extends GeneratedMessageLite implements U64 {
    public static final int ACTION_FIELD_NUMBER = 3;
    private static final Turing$UpdateGeneralNotificationMessage DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private TuringStruct$CustomGeneralMessageAction action_;
    private int bitField0_;
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Turing$UpdateGeneralNotificationMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        Turing$UpdateGeneralNotificationMessage turing$UpdateGeneralNotificationMessage = new Turing$UpdateGeneralNotificationMessage();
        DEFAULT_INSTANCE = turing$UpdateGeneralNotificationMessage;
        GeneratedMessageLite.registerDefaultInstance(Turing$UpdateGeneralNotificationMessage.class, turing$UpdateGeneralNotificationMessage);
    }

    private Turing$UpdateGeneralNotificationMessage() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static Turing$UpdateGeneralNotificationMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction) {
        turingStruct$CustomGeneralMessageAction.getClass();
        TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction2 = this.action_;
        if (turingStruct$CustomGeneralMessageAction2 == null || turingStruct$CustomGeneralMessageAction2 == TuringStruct$CustomGeneralMessageAction.getDefaultInstance()) {
            this.action_ = turingStruct$CustomGeneralMessageAction;
        } else {
            this.action_ = (TuringStruct$CustomGeneralMessageAction) ((TuringStruct$CustomGeneralMessageAction.a) TuringStruct$CustomGeneralMessageAction.newBuilder(this.action_).v(turingStruct$CustomGeneralMessageAction)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Turing$UpdateGeneralNotificationMessage parseDelimitedFrom(InputStream inputStream) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(ByteBuffer byteBuffer) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction) {
        turingStruct$CustomGeneralMessageAction.getClass();
        this.action_ = turingStruct$CustomGeneralMessageAction;
        this.bitField0_ |= 1;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
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
        switch (m2.a[gVar.ordinal()]) {
            case 1:
                return new Turing$UpdateGeneralNotificationMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "title_", "description_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Turing$UpdateGeneralNotificationMessage.class) {
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

    public TuringStruct$CustomGeneralMessageAction getAction() {
        TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction = this.action_;
        return turingStruct$CustomGeneralMessageAction == null ? TuringStruct$CustomGeneralMessageAction.getDefaultInstance() : turingStruct$CustomGeneralMessageAction;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasAction() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Turing$UpdateGeneralNotificationMessage turing$UpdateGeneralNotificationMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(turing$UpdateGeneralNotificationMessage);
    }

    public static Turing$UpdateGeneralNotificationMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(byte[] bArr) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(InputStream inputStream) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Turing$UpdateGeneralNotificationMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Turing$UpdateGeneralNotificationMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
