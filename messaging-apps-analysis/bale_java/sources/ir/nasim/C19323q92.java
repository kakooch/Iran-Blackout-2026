package ir.nasim;

import ir.nasim.database.model.file.FileState;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* renamed from: ir.nasim.q92, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19323q92 {
    private final C19687qm2 a;

    public C19323q92(C19687qm2 c19687qm2) {
        AbstractC13042fc3.i(c19687qm2, "fileStateConverter");
        this.a = c19687qm2;
    }

    public final String a(FileState fileState) throws IOException {
        AbstractC13042fc3.i(fileState, "fileState");
        StringWriter stringWriter = new StringWriter();
        try {
            C22155ul3 c22155ul3 = new C22155ul3(stringWriter);
            try {
                this.a.d(c22155ul3, fileState);
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(c22155ul3, null);
                stringWriter.flush();
                String string = stringWriter.toString();
                YV0.a(stringWriter, null);
                AbstractC13042fc3.h(string, "use(...)");
                return string;
            } finally {
            }
        } finally {
        }
    }

    public final FileState b(String str) throws IOException {
        AbstractC13042fc3.i(str, "json");
        StringReader stringReader = new StringReader(str);
        try {
            C12523el3 c12523el3 = new C12523el3(stringReader);
            try {
                FileState fileStateB = this.a.b(c12523el3);
                YV0.a(c12523el3, null);
                YV0.a(stringReader, null);
                return fileStateB;
            } finally {
            }
        } finally {
        }
    }
}
