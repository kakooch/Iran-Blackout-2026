package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.jdk14.JDK14Util;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {
    protected final BaseNameValidator _baseNameValidator;
    protected final MapperConfig<?> _config;
    protected final AnnotatedClass _forClass;
    protected final String _getterPrefix;
    protected final String _isGetterPrefix;
    protected final String _mutatorPrefix;
    protected final boolean _stdBeanNaming;

    public interface BaseNameValidator {
        boolean accept(char c, String str, int i);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String modifyFieldName(AnnotatedField annotatedField, String str) {
        return str;
    }

    protected DefaultAccessorNamingStrategy(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, String str, String str2, String str3, BaseNameValidator baseNameValidator) {
        this._config = mapperConfig;
        this._forClass = annotatedClass;
        this._stdBeanNaming = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._mutatorPrefix = str;
        this._getterPrefix = str2;
        this._isGetterPrefix = str3;
        this._baseNameValidator = baseNameValidator;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (this._isGetterPrefix == null) {
            return null;
        }
        Class<?> rawType = annotatedMethod.getRawType();
        if ((rawType != Boolean.class && rawType != Boolean.TYPE) || !str.startsWith(this._isGetterPrefix)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, 2);
        }
        return legacyManglePropertyName(str, 2);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._getterPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (_isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && _isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, this._getterPrefix.length());
        }
        return legacyManglePropertyName(str, this._getterPrefix.length());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForMutator(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._mutatorPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, this._mutatorPrefix.length());
        }
        return legacyManglePropertyName(str, this._mutatorPrefix.length());
    }

    protected String legacyManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        BaseNameValidator baseNameValidator = this._baseNameValidator;
        if (baseNameValidator != null && !baseNameValidator.accept(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    protected String stdManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        BaseNameValidator baseNameValidator = this._baseNameValidator;
        if (baseNameValidator != null && !baseNameValidator.accept(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i2, length);
        return sb.toString();
    }

    protected boolean _isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Class<?> rawType = annotatedMethod.getRawType();
        if (!rawType.isArray()) {
            return false;
        }
        String name = rawType.getComponentType().getName();
        if (name.contains(".cglib")) {
            return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib");
        }
        return false;
    }

    protected boolean _isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getRawType().getName().startsWith("groovy.lang");
    }

    public static class Provider extends AccessorNamingStrategy.Provider implements Serializable {
        protected final BaseNameValidator _baseNameValidator;
        protected final String _getterPrefix;
        protected final String _isGetterPrefix;
        protected final String _setterPrefix;
        protected final String _withPrefix;

        public Provider() {
            this("set", "with", "get", "is", null);
        }

        protected Provider(String str, String str2, String str3, String str4, BaseNameValidator baseNameValidator) {
            this._setterPrefix = str;
            this._withPrefix = str2;
            this._getterPrefix = str3;
            this._isGetterPrefix = str4;
            this._baseNameValidator = baseNameValidator;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forPOJO(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new DefaultAccessorNamingStrategy(mapperConfig, annotatedClass, this._setterPrefix, this._getterPrefix, this._isGetterPrefix, this._baseNameValidator);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forRecord(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new RecordNaming(mapperConfig, annotatedClass);
        }
    }

    public static class RecordNaming extends DefaultAccessorNamingStrategy {
        protected final Set<String> _fieldNames;

        public RecordNaming(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            super(mapperConfig, annotatedClass, null, "get", "is", null);
            this._fieldNames = new HashSet();
            for (String str : JDK14Util.getRecordFieldNames(annotatedClass.getRawType())) {
                this._fieldNames.add(str);
            }
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy, com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
            return this._fieldNames.contains(str) ? str : super.findNameForRegularGetter(annotatedMethod, str);
        }
    }
}
