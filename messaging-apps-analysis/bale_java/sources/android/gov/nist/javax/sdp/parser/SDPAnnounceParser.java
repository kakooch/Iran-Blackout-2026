package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sdp.SessionDescriptionImpl;
import java.text.ParseException;
import java.util.Vector;

/* loaded from: classes.dex */
public class SDPAnnounceParser extends ParserCore {
    protected Lexer lexer;
    protected Vector sdpMessage;

    public SDPAnnounceParser(Vector vector) {
        this.sdpMessage = vector;
    }

    public SessionDescriptionImpl parse() throws ParseException {
        SessionDescriptionImpl sessionDescriptionImpl = new SessionDescriptionImpl();
        for (int i = 0; i < this.sdpMessage.size(); i++) {
            SDPParser sDPParserCreateParser = ParserFactory.createParser((String) this.sdpMessage.elementAt(i));
            sessionDescriptionImpl.addField(sDPParserCreateParser != null ? sDPParserCreateParser.parse() : null);
        }
        return sessionDescriptionImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        if (r2 == r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        if (r3 == r2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SDPAnnounceParser(java.lang.String r5) {
        /*
            r4 = this;
            r4.<init>()
            if (r5 != 0) goto L6
            return
        L6:
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            r4.sdpMessage = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r5.trim()
            r0.append(r5)
            java.lang.String r5 = "\r\n"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            r1 = 0
        L24:
            int r2 = r5.length()
            if (r0 >= r2) goto L73
            java.lang.String r2 = "\n"
            int r2 = r5.indexOf(r2, r0)
            java.lang.String r3 = "\r"
            int r3 = r5.indexOf(r3, r0)
            if (r2 < 0) goto L43
            if (r3 >= 0) goto L43
            java.lang.String r0 = r5.substring(r0, r2)
        L3e:
            int r2 = r2 + 1
        L40:
            r1 = r0
            r0 = r2
            goto L6d
        L43:
            if (r2 >= 0) goto L50
            if (r3 < 0) goto L50
            java.lang.String r0 = r5.substring(r0, r3)
        L4b:
            int r3 = r3 + 1
        L4d:
            r1 = r0
            r0 = r3
            goto L6d
        L50:
            if (r2 < 0) goto L68
            if (r3 < 0) goto L68
            if (r2 <= r3) goto L5f
            java.lang.String r0 = r5.substring(r0, r3)
            int r3 = r3 + 1
            if (r2 != r3) goto L4d
            goto L3e
        L5f:
            java.lang.String r0 = r5.substring(r0, r2)
            int r2 = r2 + 1
            if (r3 != r2) goto L40
            goto L4b
        L68:
            if (r2 >= 0) goto L6d
            if (r3 >= 0) goto L6d
            goto L73
        L6d:
            java.util.Vector r2 = r4.sdpMessage
            r2.addElement(r1)
            goto L24
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sdp.parser.SDPAnnounceParser.<init>(java.lang.String):void");
    }
}
