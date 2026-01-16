package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class OptionalHandlerFactory implements Serializable {
    private static final Class<?> CLASS_DOM_DOCUMENT;
    private static final Class<?> CLASS_DOM_NODE;
    private static final Java7Handlers _jdk7Helper;
    public static final OptionalHandlerFactory instance;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0007
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            r0 = 0
            java.lang.Class<org.w3c.dom.Node> r1 = org.w3c.dom.Node.class
            java.lang.Class<org.w3c.dom.Document> r2 = org.w3c.dom.Document.class
            goto L8
        L6:
            r1 = r0
        L7:
            r2 = r0
        L8:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.CLASS_DOM_NODE = r1
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.CLASS_DOM_DOCUMENT = r2
            com.fasterxml.jackson.databind.ext.Java7Handlers r0 = com.fasterxml.jackson.databind.ext.Java7Handlers.instance()     // Catch: java.lang.Throwable -> L10
        L10:
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory._jdk7Helper = r0
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory r0 = new com.fasterxml.jackson.databind.ext.OptionalHandlerFactory
            r0.<init>()
            com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.instance = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ext.OptionalHandlerFactory.<clinit>():void");
    }

    protected OptionalHandlerFactory() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put("java.sql.Timestamp", DateSerializer.instance);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Object objInstantiate;
        JsonSerializer<?> serializerForJavaNioFilePath;
        Class<?> rawClass = javaType.getRawClass();
        if (_IsXOfY(rawClass, CLASS_DOM_NODE)) {
            return (JsonSerializer) instantiate("com.fasterxml.jackson.databind.ext.DOMSerializer", javaType);
        }
        Java7Handlers java7Handlers = _jdk7Helper;
        if (java7Handlers != null && (serializerForJavaNioFilePath = java7Handlers.getSerializerForJavaNioFilePath(rawClass)) != null) {
            return serializerForJavaNioFilePath;
        }
        String name = rawClass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            if (obj instanceof JsonSerializer) {
                return (JsonSerializer) obj;
            }
            return (JsonSerializer) instantiate((String) obj, javaType);
        }
        if ((name.startsWith("javax.xml.") || hasSuperClassStartingWith(rawClass, "javax.xml.")) && (objInstantiate = instantiate("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", javaType)) != null) {
            return ((Serializers) objInstantiate).findSerializer(serializationConfig, javaType, beanDescription);
        }
        return null;
    }

    private boolean _IsXOfY(Class<?> cls, Class<?> cls2) {
        return cls2 != null && cls2.isAssignableFrom(cls);
    }

    private Object instantiate(String str, JavaType javaType) {
        try {
            return instantiate(Class.forName(str), javaType);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + ClassUtil.getTypeDescription(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    private Object instantiate(Class<?> cls, JavaType javaType) {
        try {
            return ClassUtil.createInstance(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + ClassUtil.getTypeDescription(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    private boolean hasSuperClassStartingWith(Class<?> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }
}
