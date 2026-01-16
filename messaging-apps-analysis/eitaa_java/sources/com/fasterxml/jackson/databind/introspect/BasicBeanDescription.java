package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BasicBeanDescription extends BeanDescription {
    private static final Class<?>[] NO_VIEWS = new Class[0];
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final AnnotatedClass _classInfo;
    protected final MapperConfig<?> _config;
    protected Class<?>[] _defaultViews;
    protected boolean _defaultViewsResolved;
    protected ObjectIdInfo _objectIdInfo;
    protected final POJOPropertiesCollector _propCollector;
    protected List<BeanPropertyDefinition> _properties;

    protected BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector, JavaType javaType, AnnotatedClass annotatedClass) {
        super(javaType);
        this._propCollector = pOJOPropertiesCollector;
        MapperConfig<?> config = pOJOPropertiesCollector.getConfig();
        this._config = config;
        if (config == null) {
            this._annotationIntrospector = null;
        } else {
            this._annotationIntrospector = config.getAnnotationIntrospector();
        }
        this._classInfo = annotatedClass;
    }

    protected BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass, List<BeanPropertyDefinition> list) {
        super(javaType);
        this._propCollector = null;
        this._config = mapperConfig;
        if (mapperConfig == null) {
            this._annotationIntrospector = null;
        } else {
            this._annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        }
        this._classInfo = annotatedClass;
        this._properties = list;
    }

    protected BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector) {
        this(pOJOPropertiesCollector, pOJOPropertiesCollector.getType(), pOJOPropertiesCollector.getClassDef());
        this._objectIdInfo = pOJOPropertiesCollector.getObjectIdInfo();
    }

    public static BasicBeanDescription forSerialization(POJOPropertiesCollector pOJOPropertiesCollector) {
        return new BasicBeanDescription(pOJOPropertiesCollector);
    }

    public static BasicBeanDescription forOtherUse(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        return new BasicBeanDescription(mapperConfig, javaType, annotatedClass, Collections.emptyList());
    }

    protected List<BeanPropertyDefinition> _properties() {
        if (this._properties == null) {
            this._properties = this._propCollector.getProperties();
        }
        return this._properties;
    }

    public boolean removeProperty(String str) {
        Iterator<BeanPropertyDefinition> it = _properties().iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public AnnotatedClass getClassInfo() {
        return this._classInfo;
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public ObjectIdInfo getObjectIdInfo() {
        return this._objectIdInfo;
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public List<BeanPropertyDefinition> findProperties() {
        return _properties();
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public AnnotatedMember findJsonKeyAccessor() {
        POJOPropertiesCollector pOJOPropertiesCollector = this._propCollector;
        if (pOJOPropertiesCollector == null) {
            return null;
        }
        return pOJOPropertiesCollector.getJsonKeyAccessor();
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public AnnotatedMember findJsonValueAccessor() {
        POJOPropertiesCollector pOJOPropertiesCollector = this._propCollector;
        if (pOJOPropertiesCollector == null) {
            return null;
        }
        return pOJOPropertiesCollector.getJsonValueAccessor();
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public boolean hasKnownClassAnnotations() {
        return this._classInfo.hasAnnotations();
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public Annotations getClassAnnotations() {
        return this._classInfo.getAnnotations();
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public Object instantiateBean(boolean z) throws SecurityException {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        if (z) {
            defaultConstructor.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return defaultConstructor.getAnnotated().newInstance(new Object[0]);
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            ClassUtil.throwIfError(e);
            ClassUtil.throwIfRTE(e);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this._classInfo.getAnnotated().getName() + ": (" + e.getClass().getName() + ") " + ClassUtil.exceptionMessage(e), e);
        }
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public JsonFormat.Value findExpectedFormat(JsonFormat.Value value) {
        JsonFormat.Value valueFindFormat;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector != null && (valueFindFormat = annotationIntrospector.findFormat(this._classInfo)) != null) {
            value = value == null ? valueFindFormat : value.withOverrides(valueFindFormat);
        }
        JsonFormat.Value defaultPropertyFormat = this._config.getDefaultPropertyFormat(this._classInfo.getRawType());
        return defaultPropertyFormat != null ? value == null ? defaultPropertyFormat : value.withOverrides(defaultPropertyFormat) : value;
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public Class<?>[] findDefaultViews() {
        if (!this._defaultViewsResolved) {
            this._defaultViewsResolved = true;
            AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
            Class<?>[] clsArrFindViews = annotationIntrospector == null ? null : annotationIntrospector.findViews(this._classInfo);
            if (clsArrFindViews == null && !this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                clsArrFindViews = NO_VIEWS;
            }
            this._defaultViews = clsArrFindViews;
        }
        return this._defaultViews;
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public Converter<Object, Object> findSerializationConverter() {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector == null) {
            return null;
        }
        return _createConverter(annotationIntrospector.findSerializationConverter(this._classInfo));
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public JsonInclude.Value findPropertyInclusion(JsonInclude.Value value) {
        JsonInclude.Value valueFindPropertyInclusion;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        return (annotationIntrospector == null || (valueFindPropertyInclusion = annotationIntrospector.findPropertyInclusion(this._classInfo)) == null) ? value : value == null ? valueFindPropertyInclusion : value.withOverrides(valueFindPropertyInclusion);
    }

    @Override // com.fasterxml.jackson.databind.BeanDescription
    public AnnotatedMember findAnyGetter() throws NoSuchMethodException, SecurityException, IllegalArgumentException {
        POJOPropertiesCollector pOJOPropertiesCollector = this._propCollector;
        if (pOJOPropertiesCollector == null) {
            return null;
        }
        AnnotatedMember anyGetterMethod = pOJOPropertiesCollector.getAnyGetterMethod();
        if (anyGetterMethod != null) {
            if (Map.class.isAssignableFrom(anyGetterMethod.getRawType())) {
                return anyGetterMethod;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", anyGetterMethod.getName()));
        }
        AnnotatedMember anyGetterField = this._propCollector.getAnyGetterField();
        if (anyGetterField == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(anyGetterField.getRawType())) {
            return anyGetterField;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", anyGetterField.getName()));
    }

    protected Converter<Object, Object> _createConverter(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == Converter.None.class || ClassUtil.isBogusClass(cls)) {
            return null;
        }
        if (!Converter.class.isAssignableFrom(cls)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        if (this._config.getHandlerInstantiator() != null) {
            throw null;
        }
        return (Converter) ClassUtil.createInstance(cls, this._config.canOverrideAccessModifiers());
    }
}
