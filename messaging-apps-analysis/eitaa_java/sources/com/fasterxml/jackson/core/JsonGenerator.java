package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable {
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_BINARY_WRITE_CAPABILITIES;
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_TEXTUAL_WRITE_CAPABILITIES;
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_WRITE_CAPABILITIES;
    protected PrettyPrinter _cfgPrettyPrinter;

    public boolean canOmitFields() {
        return true;
    }

    public boolean canWriteBinaryNatively() {
        return false;
    }

    public boolean canWriteObjectId() {
        return false;
    }

    public boolean canWriteTypeId() {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract JsonGenerator disable(Feature feature);

    @Override // java.io.Flushable
    public abstract void flush() throws IOException;

    public abstract int getFeatureMask();

    public abstract JsonStreamContext getOutputContext();

    public abstract boolean isEnabled(Feature feature);

    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        return this;
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        return this;
    }

    @Deprecated
    public abstract JsonGenerator setFeatureMask(int i);

    public abstract JsonGenerator setHighestNonEscapedChar(int i);

    public abstract int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException;

    public abstract void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException;

    public abstract void writeBoolean(boolean z) throws IOException;

    public abstract void writeEndArray() throws IOException;

    public abstract void writeEndObject() throws IOException;

    public abstract void writeFieldName(SerializableString serializableString) throws IOException;

    public abstract void writeFieldName(String str) throws IOException;

    public abstract void writeNull() throws IOException;

    public abstract void writeNumber(double d) throws IOException;

    public abstract void writeNumber(float f) throws IOException;

    public abstract void writeNumber(int i) throws IOException;

    public abstract void writeNumber(long j) throws IOException;

    public abstract void writeNumber(String str) throws IOException;

    public abstract void writeNumber(BigDecimal bigDecimal) throws IOException;

    public abstract void writeNumber(BigInteger bigInteger) throws IOException;

    public void writeOmittedField(String str) throws IOException {
    }

    public abstract void writeRaw(char c) throws IOException;

    public abstract void writeRaw(String str) throws IOException;

    public abstract void writeRaw(char[] cArr, int i, int i2) throws IOException;

    public abstract void writeRawValue(String str) throws IOException;

    public abstract void writeStartArray() throws IOException;

    public abstract void writeStartObject() throws IOException;

    public abstract void writeString(SerializableString serializableString) throws IOException;

    public abstract void writeString(String str) throws IOException;

    public abstract void writeString(char[] cArr, int i, int i2) throws IOException;

    static {
        JacksonFeatureSet<StreamWriteCapability> jacksonFeatureSetFromDefaults = JacksonFeatureSet.fromDefaults(StreamWriteCapability.values());
        DEFAULT_WRITE_CAPABILITIES = jacksonFeatureSetFromDefaults;
        DEFAULT_TEXTUAL_WRITE_CAPABILITIES = jacksonFeatureSetFromDefaults.with(StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS);
        DEFAULT_BINARY_WRITE_CAPABILITIES = jacksonFeatureSetFromDefaults.with(StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY);
    }

    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (i & this._mask) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    protected JsonGenerator() {
    }

    public void setCurrentValue(Object obj) {
        JsonStreamContext outputContext = getOutputContext();
        if (outputContext != null) {
            outputContext.setCurrentValue(obj);
        }
    }

    public JsonGenerator overrideStdFeatures(int i, int i2) {
        return setFeatureMask((i & i2) | (getFeatureMask() & (i2 ^ (-1))));
    }

    public void setSchema(FormatSchema formatSchema) {
        throw new UnsupportedOperationException(String.format("Generator of type %s does not support schema of type '%s'", getClass().getName(), formatSchema.getSchemaType()));
    }

    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        this._cfgPrettyPrinter = prettyPrinter;
        return this;
    }

    public PrettyPrinter getPrettyPrinter() {
        return this._cfgPrettyPrinter;
    }

    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void writeStartArray(int i) throws IOException {
        writeStartArray();
    }

    public void writeStartArray(Object obj) throws IOException {
        writeStartArray();
        setCurrentValue(obj);
    }

    public void writeStartArray(Object obj, int i) throws IOException {
        writeStartArray(i);
        setCurrentValue(obj);
    }

    public void writeStartObject(Object obj) throws IOException {
        writeStartObject();
        setCurrentValue(obj);
    }

    public void writeStartObject(Object obj, int i) throws IOException {
        writeStartObject();
        setCurrentValue(obj);
    }

    public void writeFieldId(long j) throws IOException {
        writeFieldName(Long.toString(j));
    }

    public void writeArray(int[] iArr, int i, int i2) throws IOException {
        if (iArr == null) {
            throw new IllegalArgumentException("null array");
        }
        _verifyOffsets(iArr.length, i, i2);
        writeStartArray(iArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            writeNumber(iArr[i]);
            i++;
        }
        writeEndArray();
    }

    public void writeArray(long[] jArr, int i, int i2) throws IOException {
        if (jArr == null) {
            throw new IllegalArgumentException("null array");
        }
        _verifyOffsets(jArr.length, i, i2);
        writeStartArray(jArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            writeNumber(jArr[i]);
            i++;
        }
        writeEndArray();
    }

    public void writeArray(double[] dArr, int i, int i2) throws IOException {
        if (dArr == null) {
            throw new IllegalArgumentException("null array");
        }
        _verifyOffsets(dArr.length, i, i2);
        writeStartArray(dArr, i2);
        int i3 = i2 + i;
        while (i < i3) {
            writeNumber(dArr[i]);
            i++;
        }
        writeEndArray();
    }

    public void writeRaw(SerializableString serializableString) throws IOException {
        writeRaw(serializableString.getValue());
    }

    public void writeRawValue(SerializableString serializableString) throws IOException {
        writeRawValue(serializableString.getValue());
    }

    public void writeBinary(byte[] bArr, int i, int i2) throws IOException {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, i, i2);
    }

    public void writeBinary(byte[] bArr) throws IOException {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, 0, bArr.length);
    }

    public int writeBinary(InputStream inputStream, int i) throws IOException {
        return writeBinary(Base64Variants.getDefaultVariant(), inputStream, i);
    }

    public void writeNumber(short s) throws IOException {
        writeNumber((int) s);
    }

    public void writeObjectId(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }

    public void writeObjectRef(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }

    public void writeTypeId(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Type Ids", this);
    }

    public WritableTypeId writeTypePrefix(WritableTypeId writableTypeId) throws IOException {
        Object obj = writableTypeId.id;
        JsonToken jsonToken = writableTypeId.valueShape;
        if (canWriteTypeId()) {
            writableTypeId.wrapperWritten = false;
            writeTypeId(obj);
        } else {
            String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            writableTypeId.wrapperWritten = true;
            WritableTypeId.Inclusion inclusion = writableTypeId.include;
            if (jsonToken != JsonToken.START_OBJECT && inclusion.requiresObjectContext()) {
                inclusion = WritableTypeId.Inclusion.WRAPPER_ARRAY;
                writableTypeId.include = inclusion;
            }
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[inclusion.ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3) {
                    writeStartObject(writableTypeId.forValue);
                    writeStringField(writableTypeId.asProperty, strValueOf);
                    return writableTypeId;
                }
                if (i == 4) {
                    writeStartObject();
                    writeFieldName(strValueOf);
                } else {
                    writeStartArray();
                    writeString(strValueOf);
                }
            }
        }
        if (jsonToken == JsonToken.START_OBJECT) {
            writeStartObject(writableTypeId.forValue);
        } else if (jsonToken == JsonToken.START_ARRAY) {
            writeStartArray();
        }
        return writableTypeId;
    }

    /* renamed from: com.fasterxml.jackson.core.JsonGenerator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion;

        static {
            int[] iArr = new int[WritableTypeId.Inclusion.values().length];
            $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion = iArr;
            try {
                iArr[WritableTypeId.Inclusion.PARENT_PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[WritableTypeId.Inclusion.PAYLOAD_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[WritableTypeId.Inclusion.METADATA_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[WritableTypeId.Inclusion.WRAPPER_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[WritableTypeId.Inclusion.WRAPPER_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WritableTypeId writeTypeSuffix(WritableTypeId writableTypeId) throws IOException {
        JsonToken jsonToken = writableTypeId.valueShape;
        if (jsonToken == JsonToken.START_OBJECT) {
            writeEndObject();
        } else if (jsonToken == JsonToken.START_ARRAY) {
            writeEndArray();
        }
        if (writableTypeId.wrapperWritten) {
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$type$WritableTypeId$Inclusion[writableTypeId.include.ordinal()];
            if (i == 1) {
                Object obj = writableTypeId.id;
                writeStringField(writableTypeId.asProperty, obj instanceof String ? (String) obj : String.valueOf(obj));
            } else if (i != 2 && i != 3) {
                if (i == 5) {
                    writeEndArray();
                } else {
                    writeEndObject();
                }
            }
        }
        return writableTypeId;
    }

    public void writeStringField(String str, String str2) throws IOException {
        writeFieldName(str);
        writeString(str2);
    }

    protected void _reportError(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str, this);
    }

    protected final void _throwInternal() {
        VersionUtil.throwInternal();
    }

    protected final void _verifyOffsets(int i, int i2, int i3) {
        if (i2 < 0 || i2 + i3 > i) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }
}
