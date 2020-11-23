package com.retrofit.testretorfit.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "rss")
public class Channel {
    @Element(name = "title")
    @Path("channel")
    private String title;
    @Element(name = "link")
    @Path("channel")
    private String link;
    @Element(name = "description")
    @Path("channel")
    private String description;
    @Element(name = "copyright")
    @Path("channel")
    private String copyright;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
