package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.ContactList;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ContactParser extends AddressParametersParser {
    public ContactParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        char cLookAhead;
        headerName(TokenTypes.CONTACT);
        ContactList contactList = new ContactList();
        while (true) {
            Contact contact = new Contact();
            if (this.lexer.lookAhead(0) == '*') {
                char cLookAhead2 = this.lexer.lookAhead(1);
                if (cLookAhead2 == ' ' || cLookAhead2 == '\t' || cLookAhead2 == '\r' || cLookAhead2 == '\n') {
                    this.lexer.match(42);
                    contact.setWildCardFlag(true);
                } else {
                    super.parse((AddressParametersHeader) contact);
                }
            } else {
                super.parse((AddressParametersHeader) contact);
            }
            contactList.add((ContactList) contact);
            this.lexer.SPorHT();
            cLookAhead = this.lexer.lookAhead(0);
            if (cLookAhead != ',') {
                break;
            }
            this.lexer.match(44);
            this.lexer.SPorHT();
        }
        if (cLookAhead == '\n' || cLookAhead == 0) {
            return contactList;
        }
        throw createParseException("unexpected char");
    }

    protected ContactParser(Lexer lexer) {
        super(lexer);
        this.lexer = lexer;
    }
}
