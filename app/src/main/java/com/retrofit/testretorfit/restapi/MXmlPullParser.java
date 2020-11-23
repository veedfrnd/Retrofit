package com.retrofit.testretorfit.restapi;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class MXmlPullParser {

    private String response="";

    public  MXmlPullParser(String xmlString) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(new StringReader(xmlString));
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("string")) {

                        }
                        break;

                    case XmlPullParser.TEXT:
                        response = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String get(){
        return response;
    }
}
