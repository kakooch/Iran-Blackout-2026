package ir.nasim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

/* renamed from: ir.nasim.Xn7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8839Xn7 {
    public static final long a(Reader reader, Writer writer, int i) throws IOException {
        AbstractC13042fc3.i(reader, "<this>");
        AbstractC13042fc3.i(writer, "out");
        char[] cArr = new char[i];
        int i2 = reader.read(cArr);
        long j = 0;
        while (i2 >= 0) {
            writer.write(cArr, 0, i2);
            j += i2;
            i2 = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(reader, writer, i);
    }

    public static final void c(Reader reader, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(reader, "<this>");
        AbstractC13042fc3.i(ua2, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                ua2.invoke(it.next());
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(bufferedReader, null);
        } finally {
        }
    }

    public static final InterfaceC23384wp6 d(BufferedReader bufferedReader) {
        AbstractC13042fc3.i(bufferedReader, "<this>");
        return AbstractC9962aq6.d(new C9218Yz3(bufferedReader));
    }

    public static final String e(Reader reader) {
        AbstractC13042fc3.i(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
