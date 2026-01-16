package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* renamed from: ir.nasim.Yk3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9083Yk3 {
    public static AbstractC22735vk3 a(C12523el3 c12523el3) {
        boolean zM = c12523el3.m();
        c12523el3.D(true);
        try {
            try {
                return AbstractC19553qY6.a(c12523el3);
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source: " + c12523el3 + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + c12523el3 + " to Json", e2);
            }
        } finally {
            c12523el3.D(zM);
        }
    }

    public static AbstractC22735vk3 b(Reader reader) {
        try {
            C12523el3 c12523el3 = new C12523el3(reader);
            AbstractC22735vk3 abstractC22735vk3A = a(c12523el3);
            if (!abstractC22735vk3A.x() && c12523el3.G() != EnumC16723ll3.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return abstractC22735vk3A;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public static AbstractC22735vk3 c(String str) {
        return b(new StringReader(str));
    }
}
