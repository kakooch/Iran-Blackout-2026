package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class C03 extends NC6 {
    private static final Pattern c = Pattern.compile("(.+?)='(.*?)';", 32);
    private final CharsetDecoder a = AbstractC12884fL0.c.newDecoder();
    private final CharsetDecoder b = AbstractC12884fL0.b.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        try {
            return this.a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.b.decode(byteBuffer).toString();
                this.b.reset();
                byteBuffer.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // ir.nasim.NC6
    protected Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer) {
        String strC = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strC == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = c.matcher(strC);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strE = AbstractC14083hK.e(strGroup);
                strE.hashCode();
                if (strE.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strE.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
