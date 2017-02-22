
package com.kotensky.lampatest.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemNews {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("sourceId")
    @Expose
    private Integer sourceId;
    @SerializedName("autotop")
    @Expose
    private Object autotop;
    @SerializedName("platformIds")
    @Expose
    private Object platformIds;
    @SerializedName("app_views")
    @Expose
    private Integer appViews;
    @SerializedName("source_views")
    @Expose
    private Integer sourceViews;
    @SerializedName("removed")
    @Expose
    private Boolean removed;
    @SerializedName("top")
    @Expose
    private Boolean top;
    @SerializedName("previewId")
    @Expose
    private Integer previewId;
    @SerializedName("localImage")
    @Expose
    private String localImage;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("previewLink")
    @Expose
    private String previewLink;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Object getAutotop() {
        return autotop;
    }

    public void setAutotop(Object autotop) {
        this.autotop = autotop;
    }

    public Object getPlatformIds() {
        return platformIds;
    }

    public void setPlatformIds(Object platformIds) {
        this.platformIds = platformIds;
    }

    public Integer getAppViews() {
        return appViews;
    }

    public void setAppViews(Integer appViews) {
        this.appViews = appViews;
    }

    public Integer getSourceViews() {
        return sourceViews;
    }

    public void setSourceViews(Integer sourceViews) {
        this.sourceViews = sourceViews;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Integer getPreviewId() {
        return previewId;
    }

    public void setPreviewId(Integer previewId) {
        this.previewId = previewId;
    }

    public String getLocalImage() {
        return localImage;
    }

    public void setLocalImage(String localImage) {
        this.localImage = localImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

}
