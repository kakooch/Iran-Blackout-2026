package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.io.IOException;

@JacksonStdImpl
/* loaded from: classes.dex */
public class JsonValueSerializer extends StdSerializer<Object> implements ContextualSerializer {
    protected final AnnotatedMember _accessor;
    protected transient PropertySerializerMap _dynamicSerializers;
    protected final boolean _forceTypeInformation;
    protected final BeanProperty _property;
    protected final JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final TypeSerializer _valueTypeSerializer;

    public JsonValueSerializer(AnnotatedMember annotatedMember, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(annotatedMember.getType());
        this._accessor = annotatedMember;
        this._valueType = annotatedMember.getType();
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = null;
        this._forceTypeInformation = true;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }

    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z) {
        super(_notNullClass(jsonValueSerializer.handledType()));
        this._accessor = jsonValueSerializer._accessor;
        this._valueType = jsonValueSerializer._valueType;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = beanProperty;
        this._forceTypeInformation = z;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }

    private static final Class<Object> _notNullClass(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    protected JsonValueSerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z) {
        return (this._property == beanProperty && this._valueTypeSerializer == typeSerializer && this._valueSerializer == jsonSerializer && z == this._forceTypeInformation) ? this : new JsonValueSerializer(this, beanProperty, typeSerializer, jsonSerializer, z);
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(SerializerProvider serializerProvider, Object obj) throws UnsupportedOperationException, IllegalArgumentException {
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            return true;
        }
        JsonSerializer<Object> jsonSerializer_findDynamicSerializer = this._valueSerializer;
        if (jsonSerializer_findDynamicSerializer == null) {
            try {
                jsonSerializer_findDynamicSerializer = _findDynamicSerializer(serializerProvider, value.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return jsonSerializer_findDynamicSerializer.isEmpty(serializerProvider, value);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TypeSerializer typeSerializerForProperty = this._valueTypeSerializer;
        if (typeSerializerForProperty != null) {
            typeSerializerForProperty = typeSerializerForProperty.forProperty(beanProperty);
        }
        JsonSerializer<?> jsonSerializer = this._valueSerializer;
        if (jsonSerializer == null) {
            if (!serializerProvider.isEnabled(MapperFeature.USE_STATIC_TYPING) && !this._valueType.isFinal()) {
                return beanProperty != this._property ? withResolved(beanProperty, typeSerializerForProperty, jsonSerializer, this._forceTypeInformation) : this;
            }
            JsonSerializer<Object> jsonSerializerFindPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer(this._valueType, beanProperty);
            return withResolved(beanProperty, typeSerializerForProperty, jsonSerializerFindPrimaryPropertySerializer, isNaturalTypeWithStdHandling(this._valueType.getRawClass(), jsonSerializerFindPrimaryPropertySerializer));
        }
        return withResolved(beanProperty, typeSerializerForProperty, serializerProvider.handlePrimaryContextualization(jsonSerializer, beanProperty), this._forceTypeInformation);
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IllegalArgumentException {
        Object value;
        try {
            value = this._accessor.getValue(obj);
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, e, obj, this._accessor.getName() + "()");
            value = null;
        }
        if (value == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
            return;
        }
        JsonSerializer<Object> jsonSerializer_findDynamicSerializer = this._valueSerializer;
        if (jsonSerializer_findDynamicSerializer == null) {
            jsonSerializer_findDynamicSerializer = _findDynamicSerializer(serializerProvider, value.getClass());
        }
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        if (typeSerializer != null) {
            jsonSerializer_findDynamicSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
        } else {
            jsonSerializer_findDynamicSerializer.serialize(value, jsonGenerator, serializerProvider);
        }
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, IllegalArgumentException {
        Object value;
        try {
            value = this._accessor.getValue(obj);
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, e, obj, this._accessor.getName() + "()");
            value = null;
        }
        if (value == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
            return;
        }
        JsonSerializer<Object> jsonSerializer_findDynamicSerializer = this._valueSerializer;
        if (jsonSerializer_findDynamicSerializer == null) {
            jsonSerializer_findDynamicSerializer = _findDynamicSerializer(serializerProvider, value.getClass());
        } else if (this._forceTypeInformation) {
            WritableTypeId writableTypeIdWriteTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(obj, JsonToken.VALUE_STRING));
            jsonSerializer_findDynamicSerializer.serialize(value, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeIdWriteTypePrefix);
            return;
        }
        jsonSerializer_findDynamicSerializer.serializeWithType(value, jsonGenerator, serializerProvider, new TypeSerializerRerouter(typeSerializer, obj));
    }

    protected boolean isNaturalTypeWithStdHandling(Class<?> cls, JsonSerializer<?> jsonSerializer) {
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE && cls != Boolean.TYPE && cls != Double.TYPE) {
                return false;
            }
        } else if (cls != String.class && cls != Integer.class && cls != Boolean.class && cls != Double.class) {
            return false;
        }
        return isDefaultSerializer(jsonSerializer);
    }

    protected JsonSerializer<Object> _findDynamicSerializer(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException, IllegalArgumentException {
        JsonSerializer<Object> jsonSerializerSerializerFor = this._dynamicSerializers.serializerFor(cls);
        if (jsonSerializerSerializerFor != null) {
            return jsonSerializerSerializerFor;
        }
        if (this._valueType.hasGenericTypes()) {
            JavaType javaTypeConstructSpecializedType = serializerProvider.constructSpecializedType(this._valueType, cls);
            JsonSerializer<Object> jsonSerializerFindPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer(javaTypeConstructSpecializedType, this._property);
            this._dynamicSerializers = this._dynamicSerializers.addSerializer(javaTypeConstructSpecializedType, jsonSerializerFindPrimaryPropertySerializer).map;
            return jsonSerializerFindPrimaryPropertySerializer;
        }
        JsonSerializer<Object> jsonSerializerFindPrimaryPropertySerializer2 = serializerProvider.findPrimaryPropertySerializer(cls, this._property);
        this._dynamicSerializers = this._dynamicSerializers.addSerializer(cls, jsonSerializerFindPrimaryPropertySerializer2).map;
        return jsonSerializerFindPrimaryPropertySerializer2;
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this._accessor.getDeclaringClass() + "#" + this._accessor.getName() + ")";
    }

    static class TypeSerializerRerouter extends TypeSerializer {
        protected final Object _forObject;
        protected final TypeSerializer _typeSerializer;

        public TypeSerializerRerouter(TypeSerializer typeSerializer, Object obj) {
            this._typeSerializer = typeSerializer;
            this._forObject = obj;
        }

        @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
        public TypeSerializer forProperty(BeanProperty beanProperty) {
            throw new UnsupportedOperationException();
        }

        @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
        public JsonTypeInfo.As getTypeInclusion() {
            return this._typeSerializer.getTypeInclusion();
        }

        @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
        public String getPropertyName() {
            return this._typeSerializer.getPropertyName();
        }

        @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
        public WritableTypeId writeTypePrefix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            writableTypeId.forValue = this._forObject;
            return this._typeSerializer.writeTypePrefix(jsonGenerator, writableTypeId);
        }

        @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
        public WritableTypeId writeTypeSuffix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            return this._typeSerializer.writeTypeSuffix(jsonGenerator, writableTypeId);
        }
    }
}
