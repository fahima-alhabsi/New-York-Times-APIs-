package org.example;

import java.util.ArrayList;

public class docs {
    String abstracts;
    String web_url;
    String snippet;
    String lead_paragraph;
    String source;
    String pub_date;
    String document_type;

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLead_paragraph() {
        return lead_paragraph;
    }

    public void setLead_paragraph(String lead_paragraph) {
        this.lead_paragraph = lead_paragraph;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public void setNews_desk(String news_desk) {
        this.news_desk = news_desk;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSubsection_name() {
        return subsection_name;
    }

    public void setSubsection_name(String subsection_name) {
        this.subsection_name = subsection_name;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public ArrayList<org.example.multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(ArrayList<org.example.multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public org.example.headline getHeadline() {
        return headline;
    }

    public void setHeadline(org.example.headline headline) {
        this.headline = headline;
    }

    public org.example.byline getByline() {
        return byline;
    }

    public void setByline(org.example.byline byline) {
        this.byline = byline;
    }

    public ArrayList<org.example.keywords> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<org.example.keywords> keywords) {
        this.keywords = keywords;
    }

    String news_desk;
    String section_name;
    String subsection_name;
    String type_of_material;
    String _id;
    String uri;
    int word_count;
    ArrayList<multimedia > multimedia  = new ArrayList<multimedia >();
    headline headline=new headline();
    byline byline=new byline();

    ArrayList<keywords > keywords  = new ArrayList<keywords >();
}
