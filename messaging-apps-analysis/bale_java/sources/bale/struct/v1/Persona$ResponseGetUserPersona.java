package bale.struct.v1;

import bale.struct.v1.PersonaStruct$UserPersona;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class Persona$ResponseGetUserPersona extends GeneratedMessageLite implements U64 {
    private static final Persona$ResponseGetUserPersona DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PERSONA_FIELD_NUMBER = 1;
    private int bitField0_;
    private PersonaStruct$UserPersona persona_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Persona$ResponseGetUserPersona.DEFAULT_INSTANCE);
        }
    }

    static {
        Persona$ResponseGetUserPersona persona$ResponseGetUserPersona = new Persona$ResponseGetUserPersona();
        DEFAULT_INSTANCE = persona$ResponseGetUserPersona;
        GeneratedMessageLite.registerDefaultInstance(Persona$ResponseGetUserPersona.class, persona$ResponseGetUserPersona);
    }

    private Persona$ResponseGetUserPersona() {
    }

    private void clearPersona() {
        this.persona_ = null;
        this.bitField0_ &= -2;
    }

    public static Persona$ResponseGetUserPersona getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePersona(PersonaStruct$UserPersona personaStruct$UserPersona) {
        personaStruct$UserPersona.getClass();
        PersonaStruct$UserPersona personaStruct$UserPersona2 = this.persona_;
        if (personaStruct$UserPersona2 == null || personaStruct$UserPersona2 == PersonaStruct$UserPersona.getDefaultInstance()) {
            this.persona_ = personaStruct$UserPersona;
        } else {
            this.persona_ = (PersonaStruct$UserPersona) ((PersonaStruct$UserPersona.a) PersonaStruct$UserPersona.newBuilder(this.persona_).v(personaStruct$UserPersona)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Persona$ResponseGetUserPersona parseDelimitedFrom(InputStream inputStream) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Persona$ResponseGetUserPersona parseFrom(ByteBuffer byteBuffer) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPersona(PersonaStruct$UserPersona personaStruct$UserPersona) {
        personaStruct$UserPersona.getClass();
        this.persona_ = personaStruct$UserPersona;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.struct.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new Persona$ResponseGetUserPersona();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "persona_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Persona$ResponseGetUserPersona.class) {
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

    public PersonaStruct$UserPersona getPersona() {
        PersonaStruct$UserPersona personaStruct$UserPersona = this.persona_;
        return personaStruct$UserPersona == null ? PersonaStruct$UserPersona.getDefaultInstance() : personaStruct$UserPersona;
    }

    public boolean hasPersona() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Persona$ResponseGetUserPersona persona$ResponseGetUserPersona) {
        return (a) DEFAULT_INSTANCE.createBuilder(persona$ResponseGetUserPersona);
    }

    public static Persona$ResponseGetUserPersona parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Persona$ResponseGetUserPersona parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Persona$ResponseGetUserPersona parseFrom(AbstractC2383g abstractC2383g) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Persona$ResponseGetUserPersona parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Persona$ResponseGetUserPersona parseFrom(byte[] bArr) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Persona$ResponseGetUserPersona parseFrom(byte[] bArr, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Persona$ResponseGetUserPersona parseFrom(InputStream inputStream) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Persona$ResponseGetUserPersona parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Persona$ResponseGetUserPersona parseFrom(AbstractC2384h abstractC2384h) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Persona$ResponseGetUserPersona parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Persona$ResponseGetUserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
