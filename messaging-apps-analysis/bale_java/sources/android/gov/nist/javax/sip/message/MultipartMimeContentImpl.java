package android.gov.nist.javax.sip.message;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.HeaderFactoryExt;
import android.gov.nist.javax.sip.header.HeaderFactoryImpl;
import ir.nasim.InterfaceC19085pl1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* loaded from: classes.dex */
public class MultipartMimeContentImpl implements MultipartMimeContent {
    public static final String BOUNDARY = "boundary";
    private String boundary;
    private List<Content> contentList = new LinkedList();
    private HeaderFactoryExt headerFactory = new HeaderFactoryImpl();
    private InterfaceC19085pl1 multipartMimeContentTypeHeader;

    public MultipartMimeContentImpl(InterfaceC19085pl1 interfaceC19085pl1) {
        this.multipartMimeContentTypeHeader = interfaceC19085pl1;
        this.boundary = interfaceC19085pl1.getParameter(BOUNDARY);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.gov.nist.javax.sip.message.ContentImpl parseBodyPart(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "\n"
            boolean r0 = r6.startsWith(r0)
            r1 = 0
            if (r0 != 0) goto L32
            java.lang.String r0 = "\r\n"
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L12
            goto L32
        L12:
            java.lang.String r0 = "\r?\n\r?\n"
            r2 = 2
            java.lang.String[] r0 = r6.split(r0, r2)
            int r3 = r0.length
            if (r3 != r2) goto L32
            r2 = r0[r1]
            java.lang.String r3 = "\r?\n"
            java.lang.String[] r2 = r2.split(r3)
            r3 = r2[r1]
            java.lang.String r4 = ":"
            int r3 = r3.indexOf(r4)
            if (r3 <= 0) goto L32
            r6 = 1
            r6 = r0[r6]
            goto L33
        L32:
            r2 = 0
        L33:
            android.gov.nist.javax.sip.message.ContentImpl r0 = new android.gov.nist.javax.sip.message.ContentImpl
            r0.<init>(r6)
            if (r2 == 0) goto L5f
            int r6 = r2.length
        L3b:
            if (r1 >= r6) goto L5f
            r3 = r2[r1]
            android.gov.nist.javax.sip.header.HeaderFactoryExt r4 = r5.headerFactory
            ir.nasim.HU2 r3 = r4.createHeader(r3)
            boolean r4 = r3 instanceof ir.nasim.InterfaceC19085pl1
            if (r4 == 0) goto L4f
            ir.nasim.pl1 r3 = (ir.nasim.InterfaceC19085pl1) r3
            r0.setContentTypeHeader(r3)
            goto L5c
        L4f:
            boolean r4 = r3 instanceof ir.nasim.InterfaceC23329wk1
            if (r4 == 0) goto L59
            ir.nasim.wk1 r3 = (ir.nasim.InterfaceC23329wk1) r3
            r0.setContentDispositionHeader(r3)
            goto L5c
        L59:
            r0.addExtensionHeader(r3)
        L5c:
            int r1 = r1 + 1
            goto L3b
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.message.MultipartMimeContentImpl.parseBodyPart(java.lang.String):android.gov.nist.javax.sip.message.ContentImpl");
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public boolean add(Content content) {
        return this.contentList.add((ContentImpl) content);
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public void addContent(Content content) {
        add(content);
    }

    public void createContentList(String str) {
        if (this.boundary == null) {
            ContentImpl bodyPart = parseBodyPart(str);
            bodyPart.setContentTypeHeader(getContentTypeHeader());
            this.contentList.add(bodyPart);
            return;
        }
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("\r?\n?--" + this.boundary + "(--)?\r?\n?");
        while (scanner.hasNext()) {
            try {
                this.contentList.add(parseBodyPart(scanner.next()));
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public int getContentCount() {
        return this.contentList.size();
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public InterfaceC19085pl1 getContentTypeHeader() {
        return this.multipartMimeContentTypeHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public Iterator<Content> getContents() {
        return this.contentList.iterator();
    }

    @Override // android.gov.nist.javax.sip.message.MultipartMimeContent
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Content content : this.contentList) {
            sb.append("--" + this.boundary + Separators.NEWLINE);
            sb.append(content.toString());
            sb.append(Separators.NEWLINE);
        }
        if (!this.contentList.isEmpty()) {
            sb.append("--" + this.boundary + "--");
        }
        return sb.toString();
    }
}
