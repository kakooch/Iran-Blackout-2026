package ir.eitaa.tgnet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.lang.reflect.Field;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
/* loaded from: classes.dex */
public class TLObject {
    private static final ThreadLocal<NativeByteBuffer> sizeCalculator = new ThreadLocal<NativeByteBuffer>() { // from class: ir.eitaa.tgnet.TLObject.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public NativeByteBuffer initialValue() {
            return new NativeByteBuffer(true);
        }
    };
    int constructor;
    public String constructor_;
    public boolean disableFree = false;
    public int networkType;

    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor, boolean exception) {
        return null;
    }

    public void freeResources() {
    }

    public void readParams(AbstractSerializedData stream, boolean exception) {
    }

    public void serializeToStream(AbstractSerializedData stream) {
    }

    public TLObject() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getDeclaredField("constructor");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(this);
            this.constructor = i;
            this.constructor_ = String.format("0x%08x", Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public int getObjectSize() {
        ThreadLocal<NativeByteBuffer> threadLocal = sizeCalculator;
        NativeByteBuffer nativeByteBuffer = threadLocal.get();
        nativeByteBuffer.rewind();
        serializeToStream(threadLocal.get());
        return nativeByteBuffer.length();
    }
}
