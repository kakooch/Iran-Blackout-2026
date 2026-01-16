package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public class StdSubtypeResolver extends SubtypeResolver implements Serializable {
    protected LinkedHashSet<NamedType> _registeredSubtypes;

    @Override // com.fasterxml.jackson.databind.jsontype.SubtypeResolver
    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listFindSubtypes;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        Class<?> rawType = javaType == null ? annotatedMember.getRawType() : javaType.getRawClass();
        HashMap<NamedType, NamedType> map = new HashMap<>();
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            Iterator<NamedType> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                NamedType next = it.next();
                if (rawType.isAssignableFrom(next.getType())) {
                    _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, next.getType()), next, mapperConfig, annotationIntrospector, map);
                }
            }
        }
        if (annotatedMember != null && (listFindSubtypes = annotationIntrospector.findSubtypes(annotatedMember)) != null) {
            for (NamedType namedType : listFindSubtypes) {
                _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, namedType.getType()), namedType, mapperConfig, annotationIntrospector, map);
            }
        }
        _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, rawType), new NamedType(rawType, null), mapperConfig, annotationIntrospector, map);
        return new ArrayList(map.values());
    }

    @Override // com.fasterxml.jackson.databind.jsontype.SubtypeResolver
    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        HashMap<NamedType, NamedType> map = new HashMap<>();
        if (this._registeredSubtypes != null) {
            Class<?> rawType = annotatedClass.getRawType();
            Iterator<NamedType> it = this._registeredSubtypes.iterator();
            while (it.hasNext()) {
                NamedType next = it.next();
                if (rawType.isAssignableFrom(next.getType())) {
                    _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, next.getType()), next, mapperConfig, annotationIntrospector, map);
                }
            }
        }
        _collectAndResolve(annotatedClass, new NamedType(annotatedClass.getRawType(), null), mapperConfig, annotationIntrospector, map);
        return new ArrayList(map.values());
    }

    protected void _collectAndResolve(AnnotatedClass annotatedClass, NamedType namedType, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap<NamedType, NamedType> map) {
        String strFindTypeName;
        if (!namedType.hasName() && (strFindTypeName = annotationIntrospector.findTypeName(annotatedClass)) != null) {
            namedType = new NamedType(namedType.getType(), strFindTypeName);
        }
        NamedType namedType2 = new NamedType(namedType.getType());
        if (map.containsKey(namedType2)) {
            if (!namedType.hasName() || map.get(namedType2).hasName()) {
                return;
            }
            map.put(namedType2, namedType);
            return;
        }
        map.put(namedType2, namedType);
        List<NamedType> listFindSubtypes = annotationIntrospector.findSubtypes(annotatedClass);
        if (listFindSubtypes == null || listFindSubtypes.isEmpty()) {
            return;
        }
        for (NamedType namedType3 : listFindSubtypes) {
            _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, namedType3.getType()), namedType3, mapperConfig, annotationIntrospector, map);
        }
    }
}
