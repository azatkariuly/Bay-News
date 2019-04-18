package com.example.azatkariuly.bainews;

public class NewsDesc {

    private String mUrl;
    private String mImg;
    private String mTitle;
    private String mDate;
    private String mSource;
    private String mAuthor;

    public NewsDesc() {

    }

    public NewsDesc(String mUrl, String mImg, String mTitle, String mDate, String mSource, String mAuthor) {
        this.setmUrl(mUrl);
        this.setmImg(mImg);
        this.setmTitle(mTitle);
        this.setmDate(mDate);
        this.setmSource(mSource);
        this.setmAuthor(mAuthor);
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }
}
