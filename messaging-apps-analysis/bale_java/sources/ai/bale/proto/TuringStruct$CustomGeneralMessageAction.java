package ai.bale.proto;

import ai.bale.proto.TuringStruct$CustomDoNothingAction;
import ai.bale.proto.TuringStruct$CustomOpenUrlAction;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TuringStruct$CustomGeneralMessageAction extends GeneratedMessageLite implements U64 {
    public static final int CUSTOM_DO_NOTHING_ACTION_FIELD_NUMBER = 2;
    public static final int CUSTOM_OPEN_URL_ACTION_FIELD_NUMBER = 1;
    private static final TuringStruct$CustomGeneralMessageAction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TuringStruct$CustomGeneralMessageAction.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        CUSTOM_OPEN_URL_ACTION(1),
        CUSTOM_DO_NOTHING_ACTION(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return CUSTOM_OPEN_URL_ACTION;
            }
            if (i != 2) {
                return null;
            }
            return CUSTOM_DO_NOTHING_ACTION;
        }
    }

    static {
        TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction = new TuringStruct$CustomGeneralMessageAction();
        DEFAULT_INSTANCE = turingStruct$CustomGeneralMessageAction;
        GeneratedMessageLite.registerDefaultInstance(TuringStruct$CustomGeneralMessageAction.class, turingStruct$CustomGeneralMessageAction);
    }

    private TuringStruct$CustomGeneralMessageAction() {
    }

    private void clearCustomDoNothingAction() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCustomOpenUrlAction() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static TuringStruct$CustomGeneralMessageAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCustomDoNothingAction(TuringStruct$CustomDoNothingAction turingStruct$CustomDoNothingAction) {
        turingStruct$CustomDoNothingAction.getClass();
        if (this.traitCase_ != 2 || this.trait_ == TuringStruct$CustomDoNothingAction.getDefaultInstance()) {
            this.trait_ = turingStruct$CustomDoNothingAction;
        } else {
            this.trait_ = ((TuringStruct$CustomDoNothingAction.a) TuringStruct$CustomDoNothingAction.newBuilder((TuringStruct$CustomDoNothingAction) this.trait_).v(turingStruct$CustomDoNothingAction)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeCustomOpenUrlAction(TuringStruct$CustomOpenUrlAction turingStruct$CustomOpenUrlAction) {
        turingStruct$CustomOpenUrlAction.getClass();
        if (this.traitCase_ != 1 || this.trait_ == TuringStruct$CustomOpenUrlAction.getDefaultInstance()) {
            this.trait_ = turingStruct$CustomOpenUrlAction;
        } else {
            this.trait_ = ((TuringStruct$CustomOpenUrlAction.a) TuringStruct$CustomOpenUrlAction.newBuilder((TuringStruct$CustomOpenUrlAction) this.trait_).v(turingStruct$CustomOpenUrlAction)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TuringStruct$CustomGeneralMessageAction parseDelimitedFrom(InputStream inputStream) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(ByteBuffer byteBuffer) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCustomDoNothingAction(TuringStruct$CustomDoNothingAction turingStruct$CustomDoNothingAction) {
        turingStruct$CustomDoNothingAction.getClass();
        this.trait_ = turingStruct$CustomDoNothingAction;
        this.traitCase_ = 2;
    }

    private void setCustomOpenUrlAction(TuringStruct$CustomOpenUrlAction turingStruct$CustomOpenUrlAction) {
        turingStruct$CustomOpenUrlAction.getClass();
        this.trait_ = turingStruct$CustomOpenUrlAction;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (n2.a[gVar.ordinal()]) {
            case 1:
                return new TuringStruct$CustomGeneralMessageAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", TuringStruct$CustomOpenUrlAction.class, TuringStruct$CustomDoNothingAction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TuringStruct$CustomGeneralMessageAction.class) {
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

    public TuringStruct$CustomDoNothingAction getCustomDoNothingAction() {
        return this.traitCase_ == 2 ? (TuringStruct$CustomDoNothingAction) this.trait_ : TuringStruct$CustomDoNothingAction.getDefaultInstance();
    }

    public TuringStruct$CustomOpenUrlAction getCustomOpenUrlAction() {
        return this.traitCase_ == 1 ? (TuringStruct$CustomOpenUrlAction) this.trait_ : TuringStruct$CustomOpenUrlAction.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasCustomDoNothingAction() {
        return this.traitCase_ == 2;
    }

    public boolean hasCustomOpenUrlAction() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(TuringStruct$CustomGeneralMessageAction turingStruct$CustomGeneralMessageAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(turingStruct$CustomGeneralMessageAction);
    }

    public static TuringStruct$CustomGeneralMessageAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(AbstractC2383g abstractC2383g) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(byte[] bArr) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(InputStream inputStream) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(AbstractC2384h abstractC2384h) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TuringStruct$CustomGeneralMessageAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TuringStruct$CustomGeneralMessageAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
