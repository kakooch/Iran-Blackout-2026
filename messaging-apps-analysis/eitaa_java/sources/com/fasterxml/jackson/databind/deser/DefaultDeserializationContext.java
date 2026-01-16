package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    protected DefaultDeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        super(deserializerFactory, deserializerCache);
    }

    public static final class Impl extends DefaultDeserializationContext {
        public Impl(DeserializerFactory deserializerFactory) {
            super(deserializerFactory, null);
        }
    }
}
