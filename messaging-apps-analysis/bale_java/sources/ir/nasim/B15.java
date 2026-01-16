package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public abstract class B15 extends AbstractC24089y15 {
    public static final List a(Path path, String str) throws IOException {
        AbstractC13042fc3.i(path, "<this>");
        AbstractC13042fc3.i(str, "glob");
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream directoryStreamA = A15.a(directoryStreamNewDirectoryStream);
            AbstractC13042fc3.f(directoryStreamA);
            List listM1 = AbstractC15401jX0.m1(directoryStreamA);
            YV0.a(directoryStreamNewDirectoryStream, null);
            return listM1;
        } finally {
        }
    }

    public static /* synthetic */ List b(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Separators.STAR;
        }
        return a(path, str);
    }
}
