package com.fasterxml.jackson.databind.jdk14;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class JDK14Util {
    public static String[] getRecordFieldNames(Class<?> cls) {
        return RecordAccessor.instance().getRecordFieldNames(cls);
    }

    static class RecordAccessor {
        private static final RecordAccessor INSTANCE;
        private static final RuntimeException PROBLEM;
        private final Method RECORD_COMPONENT_GET_NAME;
        private final Method RECORD_COMPONENT_GET_TYPE;
        private final Method RECORD_GET_RECORD_COMPONENTS;

        static {
            RecordAccessor recordAccessor = null;
            try {
                e = null;
                recordAccessor = new RecordAccessor();
            } catch (RuntimeException e) {
                e = e;
            }
            INSTANCE = recordAccessor;
            PROBLEM = e;
        }

        private RecordAccessor() throws ClassNotFoundException, RuntimeException {
            try {
                this.RECORD_GET_RECORD_COMPONENTS = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.RECORD_COMPONENT_GET_NAME = cls.getMethod("getName", new Class[0]);
                this.RECORD_COMPONENT_GET_TYPE = cls.getMethod("getType", new Class[0]);
            } catch (Exception e) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e.getClass().getName(), e.getMessage()), e);
            }
        }

        public static RecordAccessor instance() {
            RuntimeException runtimeException = PROBLEM;
            if (runtimeException != null) {
                throw runtimeException;
            }
            return INSTANCE;
        }

        public String[] getRecordFieldNames(Class<?> cls) throws IllegalArgumentException {
            Object[] objArrRecordComponents = recordComponents(cls);
            String[] strArr = new String[objArrRecordComponents.length];
            for (int i = 0; i < objArrRecordComponents.length; i++) {
                try {
                    strArr[i] = (String) this.RECORD_COMPONENT_GET_NAME.invoke(objArrRecordComponents[i], new Object[0]);
                } catch (Exception e) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrRecordComponents.length), ClassUtil.nameOf(cls)), e);
                }
            }
            return strArr;
        }

        protected Object[] recordComponents(Class<?> cls) throws IllegalArgumentException {
            try {
                return (Object[]) this.RECORD_GET_RECORD_COMPONENTS.invoke(cls, new Object[0]);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + ClassUtil.nameOf(cls));
            }
        }
    }
}
